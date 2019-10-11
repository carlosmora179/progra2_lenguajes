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
            function insertarFila(texto) {
                var table = document.getElementById("tabla_horarios");    
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
                <li><a href="mascotas.jsp">Mascotas</a></li>
                <li><a href="#">Facturas</a></li>
                <li><a href="#">Tienda</a></li>
                <li><a href="veterinarios.jsp">Veterinarios</a></li>
                <li><a href="#">Acerca de nosotros</a></li>
            </ul>
        </div>
        
         <%! List<Horario> horarios;%>
        <%! String toInsert = "";%>
        <%  toInsert = "";
            ConsultaHorario resultado = new ConsultaHorario();
            
            horarios = resultado.consultaGeneral();
            
            for(int x = 0; x < horarios.size(); x++){
                toInsert += horarios.get(x).toString() + '_';
                System.out.println(toInsert);
            }

        %>
        
        <div class="container text-center">
            
           
            <form action="srvController" method="post" >
                <br>
                    <br>
                    <br>
                <div class="form-group mb-2 row">
                    
                    <label>Cédula del veterinario: </label>
                    
                    &nbsp;
                    
                    <input  type="text" name="cedula">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Nombre del veterinario: </label>
                    &nbsp;
                    <input type="text" name="nombre">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Apellido 1 del veterinario: </label>
                    &nbsp;
                    <input type="text" name="apll1">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Apellido 2 del veterinario: </label>
                    &nbsp;
                    <input type="text" name="apll2">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Dirección del veterinario: </label>
                    &nbsp;
                    <input type="text" name="direc">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Telefonos del veterinario: </label>
                    &nbsp;
                    <input type="text" name="telefonos">
                    </div>
                    <div class="form-group mb-2 row">
                    <label>Especialidades del veterinario: </label>
                    &nbsp;
                    <input type="text" name="espv">
                    </div>
                    <div class="form-group mb-2 row">
                        <label>Horario del veterinario: </label>
                        <input type="text" name="horariovet">
                    &nbsp;
                    
                    
                    
                    <!-- Table  -->
                    <table class="table table-bordered" id="tabla_horarios">
  <!-- Table head -->
  <thead>
    <tr>
      
       <th>id</th>
        
      
      <th>Entrada</th>
      <th>Salida</th>
      <th>Días</th>
    </tr>
  </thead>
  <!-- Table head -->

  <!-- Table body -->
  <tbody>
<script>
    
    insertarFila('<%=toInsert%>');
("tabla_horarios").find("tbody").empty();</script>   
  </tbody>
  <!-- Table body -->
</table>
<!-- Table  -->
                    </div>
                    
                    <button  type="submit" name="aghorario" class="btn btn-primary mb-2" value="agregh">Agregar horario</button>
                <button  type="submit" name="agregvet" class="btn btn-primary mb-2" value="agregar" >Agregar</button>
            
                
        
            </form>
            
        </div>
       

    </body>
        
</html>

