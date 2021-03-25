/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import validar.Captcha;

/**
 *
 * @author jhong
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String usuario = request.getParameter("username");
            String password = request.getParameter("contraseña");
            Usuarios usuarios = new Usuarios();
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            boolean verificado = Captcha.verificar(gRecaptchaResponse);
            if(verificado==true){
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaPU");
                EntityManager em = emf.createEntityManager();
                EntityTransaction et = em.getTransaction();
                usuarios.setNombre(usuario);
                usuarios.setContraseña(password);
                usuarios.setSalt(".");
                
                et.begin();
                em.persist(usuario);
                et.commit();
                em.close();
                response.sendRedirect("form.jsp");             
            }else{
                response.sendRedirect("index.jsp");
            }
            System.out.println(gRecaptchaResponse);
        }
    }

    

}