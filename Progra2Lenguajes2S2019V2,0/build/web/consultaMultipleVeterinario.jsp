
<%@page import="modelo.Veterinario"%>
<%@page import="controlador.ConsultaVeterinario"%>
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
            function insertarFila(texto) {
                var table = document.getElementById("tabla_vista");    
                var tempo = texto.split("_");
                var tempo2;
                
                for(var i = 0; i < tempo.length - 1; i++){
                    
                    var row = table.insertRow(i + 1);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                    var cell4 = row.insertCell(3);
                    var cell5 = row.insertCell(4);
                    var cell6 = row.insertCell(5);
           
                    tempo2 = tempo[i].split("-");
                    cell1.innerHTML = tempo2[0];
                    cell2.innerHTML = tempo2[1];
                    cell3.innerHTML = tempo2[2];
                    cell4.innerHTML = tempo2[3];
                    cell5.innerHTML = tempo2[4];
                    cell6.innerHTML = tempo2[5];

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
        
        <%! List<Veterinario> veterinarios;%>
        <%! String toInsert = "";%>
        <%  toInsert = "";
            ConsultaVeterinario resultado = new ConsultaVeterinario();
            
            veterinarios = resultado.consultaGeneral();
            
            for(int x = 0; x < veterinarios.size(); x++){
                toInsert += veterinarios.get(x).toString() + '_';
            }

        %>
        
        <table class="table table-striped" id="tabla_vista">
            <thead>
                <tr>
                    <th scope="col">Cédula</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido1</th>
                    <th scope="col">Apellido2</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Teléfonos</th>
                </tr>
            </thead>
            <tbody>
                <script>insertarFila('<%=toInsert%>');</script>   

            </tbody>
        </table>
        
    </body>
        
</html>