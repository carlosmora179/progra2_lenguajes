<%@page import="controlador.ConsultaTienda"%>
<%@page import="modelo.Tienda"%>
<%@page import="java.util.ArrayList"%>
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

           
                    tempo2 = tempo[i].split("-");
                    cell1.innerHTML = tempo2[0];
                    cell2.innerHTML = tempo2[1];
                    cell3.innerHTML = tempo2[2];
                    cell4.innerHTML = tempo2[3];


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
                <li><a href="mascotas">Mascotas</a></li>
                <li><a href="facturas.jsp">Facturas</a></li>
                <li><a href="tienda.jsp">Tienda</a></li>
                <li><a href="veterinarios.jsp">Veterinarios</a></li>
                <li><a href="#">Acerca de nosotros</a></li>
            </ul>
        </div>
        
        <%! Tienda tienda;%>
        <%! String toInsert = "";%>
        <%

            ConsultaTienda resultado = new ConsultaTienda();
            tienda = resultado.consultaGeneral();
            
            for(int x = 0; x < tienda.getInventario().size(); x++){
               toInsert += tienda.getInventario().get(x).toString() + '_';
            }

        %>
        
        <div class="container text-center">
            <form method="post" action="BorrarProductoConfirmacion.jsp">
                <div class="form-group mb-2 row">
                    <label>Código del producto: </label>
                    &nbsp;
                    <input type="number" name="codigo_producto">
                    &nbsp;
                    <button type="submit" class="btn btn-primary mb-2">Borrar producto</button>            
                </div>
                        
            </form>
        </div>
        
        
        <table class="table table-striped" id="tabla_vista">
            <thead>
                <tr>
                    <th scope="col">Código de producto</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Stock</th>
                </tr>
            </thead>
            <tbody>

                <script>insertarFila('<%=toInsert%>');</script>   

            </tbody>
        </table>
        
    </body>
        
</html>
