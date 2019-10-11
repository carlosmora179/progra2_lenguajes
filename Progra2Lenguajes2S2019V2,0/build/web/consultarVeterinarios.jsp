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
                <li><a href="#">Inicio</a></li>
                <li><a href="consultarMascotas.jsp">Mascotas</a></li>
                <li><a href="consultarVentas.jsp">Facturas</a></li>
                <li><a href="#">Tienda</a></li>
                <li><a href="veterinarios.jsp">Veterinarios</a></li>
                <li><a href="#">Acerca de nosotros</a></li>
                <li><a href="plantilla.jsp">plantilla</a></li>
            </ul>
        </div>
        
        <div class="container text-center">
            <form>
                <div class="form-group mb-2 row">
                    <label>Cédula del veterinario: </label>
                    &nbsp;
                    <input type="text" name="cedula">
                                
                </div>
                
                <button type="submit" class="btn btn-primary mb-2">Buscar</button>
            
            </form>
            <br>
            <button type="submit" onclick="window.location='consultaMultipleVeterinario.jsp'" class="btn btn-primary mb-2">Realizar consulta general</button>

        </div>

            
        <div>
            
</div>

    </body>
        
</html>
