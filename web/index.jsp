<%-- 
    Document   : index
    Created on : 24/03/2021, 04:00:56 PM
    Author     : jhong
--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login y Registro</title>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
   
</head>
<body>
    <main>
        <div class="contenedor__todo"> 
            <div class="caja__trasera">
                 <div class="caja__trasera-login">
                     <h3>¿Ya tienes una cuenta?</h3>
                     <p>Inicia sesión para seguir</p>
                     <button id="btn_inicar-sesion">Iniciar Sesión</button>
                 </div>
                    <div class="caja__trasera-register">
                        <h3>¿Aún no tienes una cuenta?</h3>
                        <p>Registrate para poder inicar sesión</p>
                        <button id="btn_registrarse">Registrarse</button>
                    </div>
            </div>
            <!--Formulario de Login y Registro-->
            <div class="contenedor__login-register">
                <!--Login-->
                <form action="inicio" method="POST" class="formulario__login" >
                    <h2>Iniciar sesión</h2>
                    <input type="text" placeholder="Correo electrónico" required="true">
                    <input type="password" placeholder="Contraseña" required="true">
                    <br />
                    <div id="cap" class="g-recaptcha" data-sitekey="6Ld0QY0aAAAAANeo5Gr-DGwhSOaDbCPmFs94dH1C"></div>
                    <br />
                    <button>Ingresar</button>
                </form>
                <!--Registro-->
                <form action="" class="formulario__register">
                    <h2>Registrarse</h2>
                    <input type="text" placeholder="Cédula de ciudadania (C.C)" name="cedula_ciudadania">
                    <input type="text" placeholder="Nombre Completo" name="nombre_completo">
                    <input type="text" placeholder="Correo electrónico" name="correo">
                    <input type="text" placeholder="Usuario" name="usuario">
                    <input type="password" placeholder="Contraseña" name="contrasena">
                   
                    <button>Registrarse</button>
                </form>
            </div>
        </div>
    </main>
    <script src="js/script.js" type="text/javascript"></script>
</body>
</html>