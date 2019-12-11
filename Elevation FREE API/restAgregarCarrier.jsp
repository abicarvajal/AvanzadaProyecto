<%-- 
    Document   : restAgregarCarrier
    Created on : 04-dic-2019, 8:37:49
    Author     : Melissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Agregar Registro</h1>
            <hr>
            <form action="restCarrier.jsp" method="post" class="form-control" style="width: 500px; height: 400px">
                    
                
                            <label for="cedula">Cedula:</label>
                            <input type="text" class="form-control" placeholder="1720980067" name="cedula" />
                            
                            
                            <label for="cedula">Nombre:</label>
                            <input type="text" class="form-control" placeholder="María" name="nombre" />
                            
                          <label for="direccion">Direccion:</label>
                            <input type="text" class="form-control" placeholder="Valle de los Chillos" name="direccion" />
                            
                        <label for="cedula">Teléfono:</label>
                            <input type="text" class="form-control" placeholder="0984927548" name="telefono" />
                            
                        <label for="correo">Correo:</label>
                            <input type="text" class="form-control" placeholder="agcarvajal@espe.edu.ec"
                                name="correo" />
                            
                       
                            <label for="placa">Placa:</label>
                            <input type="text" class="form-control" placeholder="PKO0140" name="placa" />
                            
                        
                            <label for="zona">Zona:</label>
                            <input type="text" class="form-control" placeholder="quito" name="zona" />
             <input type="submit" value="Guardar" />
                
            </form>
                            
        </div>
        
    </body>
</html>
