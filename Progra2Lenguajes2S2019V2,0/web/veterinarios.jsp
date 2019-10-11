<%-- 
    Document   : veterinarios
    Created on : 08/10/2019, 09:48:19 AM
    Author     : alece
--%>

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
                <li><a href="facturas.jsp">Facturas</a></li>
                <li><a href="tienda.jsp">Tienda</a></li>
                <li><a href="veterinarios.jsp">Veterinarios</a></li>
                <li><a href="#">Acerca de nosotros</a></li>
            </ul>
        </div>
        
        <h1>Seleccione una opción:</h1>
        <button type="text" class="btn btn-primary mb-2">Agregar Veterinario</button>
        <button type="text" class="btn btn-primary mb-2" 
                onclick="window.location='consultaVeterinario.jsp'">Consultar Veterinarios</button>
        <button type="text" class="btn btn-primary mb-2" 
                onclick="window.location='consultaMascotaVeterinario.jsp'">Mascotas Atendidas por Veterinario</button>
        <button type="text" class="btn btn-primary mb-2"
                onclick="window.location='borrarVeterinario.jsp'">Eliminar Veterinario</button>
        <button type="text" class="btn btn-primary mb-2">Actualizar Información Veterinario</button>
        

    </body>
        
</html>