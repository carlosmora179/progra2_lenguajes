<%@page import="controlador.ConsultaDuenios"%>
<%@page import="modelo.Dueño"%>
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

        <script>
            function agregarDuenios(texto){
                
                 var nombres = texto.split("_");

var select = document.getElementById("duenios");
for(index in nombres) {
    select.options[select.options.length] = new Option(nombres[index], index);
}
                                
            }
           
        </script>
        
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
        <%! List<Dueño> dueños;%>
        <%! String toInsertdue = "";%>
        <%  toInsertdue = "";
            ConsultaDuenios resultado = new ConsultaDuenios();
            
            dueños = resultado.consultaGeneral();
            
            for(int x = 0; x < dueños.size(); x++){
                if(x==(dueños.size()-1)){
              toInsertdue += dueños.get(x).getNombre(); 
           }
           else{
               toInsertdue += dueños.get(x).getNombre()+ '_';
           }
                
                System.out.println(toInsertdue);
            }

        %>
       
        <div class="container text-center">
            
           
            <form action="srvController" method="post" >
                <br>
                    <br>
                    <br>
                <div class="form-group mb-2 row">
                    
                    <label>Tipo de mascota: </label>
                    &nbsp;
                    <input type="text" name="tipom">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Nombre: </label>
                    &nbsp;
                    <input type="text" name="nombremasco">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Fecha de nacimiento: </label>
                    &nbsp;
                    <input type="date" name="nacimiento">
                    </div>
                    
                    <div class="form-group mb-2 row">
                        <label>dueño: </label>
                        &nbsp;
                        <select id="duenios" >
                            <script>
                               agregarDuenios('<%=toInsertdue%>');
                            </script>
                            
                        </select>
                    
                    
                    
                    
                   
                    </div>
                    
                    <button  type="submit" name="agduenio" class="btn btn-primary mb-2" value="agregh">Agregar dueño</button>
                <button  type="submit" name="agregvet" class="btn btn-primary mb-2" value="agregar" >Agregar</button>
            
                
        
            </form>
            
        </div>
       

    </body>
        
</html>

