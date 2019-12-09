<%-- 
    Document   : agregar2
    Created on : 04-dic-2019, 7:41:01
    Author     : Melissa
--%>
<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Agregar Registro</h1>
            <hr>
            <form action="" method="post" class="form-control" style="width: 500px; height: 400px">
                    
                            <label for="cedula">Nombre:</label>
                            <input type="text" class="form-control" placeholder="María" name="nombre" />
                       
                            <label for="cedula">Cedula:</label>
                            <input type="text" class="form-control" placeholder="1720980067" name="cedula" />
                       
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
<%
       //CONECTANOD A LA BASE DE DATOS:
       Connection con;
       String url="jdbc:mysql://localhost:3306/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       String Driver="com.mysql.jdbc.Driver";
       String user="root";
       String clave="";
       Class.forName(Driver);
       con=DriverManager.getConnection(url,user,clave);
       PreparedStatement ps;
       String identificacion, nombre,direccion,telefono, correo,placa, zona;
       identificacion=request.getParameter("cedula");
       nombre=request.getParameter("nombre");
       direccion=request.getParameter("direccion");
       telefono=request.getParameter("telefono");
       correo=request.getParameter("correo");
       placa=request.getParameter("placa");
       zona=request.getParameter("zona");
       
       if(identificacion!=null && nombre!=null&& direccion!=null&& telefono!=null&& correo!=null&& placa!=null&& zona!=null){
           String sql="INSERT INTO transportista(identificacion,nombre,direccion,telefono,correo,placa,zona) VALUES(?,?,?,?,?,?,?)";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, identificacion);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, telefono);
            ps.setString(5, correo);
            ps.setString(6, placa);
            ps.setString(7, zona);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex);
        }
              
     
       }
       
       
%>