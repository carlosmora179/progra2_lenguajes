<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PetSafe</title>
        
        <link href="vista/estilo.css" rel="stylesheet" type="text/css"/>
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
                <li><a href="mascotas.jsp">Mascotas</a></li>
                <li><a href="consultarVentas.jsp">Facturas</a></li>
                <li><a href="#">Tienda</a></li>
                <li><a href="veterinarios.jsp">Veterinarios</a></li>
                <li><a href="#">Acerca de nosotros</a></li>
                <li><a href="plantilla.jsp">plantilla</a></li>
            </ul>
        </div>
        <%=request.getParameter("msg")%>
        <div class="slider">
		<ul>
                    <li>
                        <img  src="imagenes/orig_37616.jpg" alt=""/>
                    </li>
                    <li>
                        <img src="imagenes/camaleones-como-mascotas-artistas-del-camuflaje.jpg" alt=""/>
                    </li>
                    <li>
                        <img src="imagenes/mascotas.jpg" alt=""/>
                    </li>
                    <li>
                        <img src="imagenes/default-image-2.jpg" alt=""/>
                    </li>

		</ul>
	</div>
        

    </body>
        
</html>