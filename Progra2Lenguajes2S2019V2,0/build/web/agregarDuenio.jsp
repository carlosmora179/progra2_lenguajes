<%@page import="controlador.ConsultaHorario"%>
<%@page import="modelo.Horario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PetSafe</title>
        
        <link href="vista/plantillaestilo.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        
    </head>
    <body >
        
        <div id="header">
            <h1 id="logo">
      
            <img class="mediana" src="imagenes/logo_transparent.png" alt=""/>
            </h1>
        </div>

        
            
        <div id="container">
                
            <ul>
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="mascotas.jsp">Mascotas</a></li>
                <li><a href="#">Facturas</a></li>
                <li><a href="#">Tienda</a></li>
                <li><a href="veterinarios.jsp">Veterinarios</a></li>
                <li><a href="#">Acerca de nosotros</a></li>
            </ul>
        </div>
        
        
        <div class="container text-center">
            
           
            <form action="srvController" method="post" >
                <br>
                    <br>
                    <br>
                <div class="form-group mb-2 row">
                    
                    <label>Cédula del dueño:</label>
                    
                    &nbsp;
                    
                    <input  type="text" name="duecedula">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Nombre del dueño: </label>
                    &nbsp;
                    <input type="text" name="duenombre">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Apellido 1 del dueño: </label>
                    &nbsp;
                    <input type="text" name="dueapll1">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Apellido 2 del dueño: </label>
                    &nbsp;
                    <input type="text" name="dueapll2">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Dirección del dueño: </label>
                    &nbsp;
                    <input type="text" name="duedirec">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Telefonos del dueño: </label>
                    &nbsp;
                    <input type="text" name="duetelefonos">
                    </div>
                    
                <button  type="submit" name="dueagregar" class="btn btn-primary mb-2" value="agregar" >Agregar</button>
            
                
        
            </form>
            
        </div>
       

    </body>
        
</html>
