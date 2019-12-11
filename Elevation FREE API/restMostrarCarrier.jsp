<%-- 
    Document   : restmostrar
    Created on : 04-dic-2019, 8:17:33
    Author     : Melissa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ec.edu.espe.clientes.model.transportistaVO"%>
<%@page import="ec.edu.espe.clientes.model.transportistaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="container">
            <table  class="table table-bordered"  id="tablaDatos">
                <tr>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Identificacion</th>
                    <th class="text-center">Direccion</th>
                    <th class="text-center">Teléfono</th>
                    <th class="text-center">Correo</th>
                    <th class="text-center">Placa</th>
                    <th class="text-center">Zona</th>
                </tr>
                <%transportistaDAO dao=new transportistaDAO();
                ArrayList<transportistaVO> trans=dao.getServices();
                for(transportistaVO transres: trans ){ %>
         <tr>
                    <td class="text-center"><%=transres.getIdentificacion()%></td>
                    <td class="text-center"><%=transres.getNombre()%></td>
                    <td class="text-center"><%=transres.getDireccion()%></td>
                    <td class="text-center"><%=transres.getTelefono()%></td>
                    <td class="text-center"><%=transres.getCorreo()%></td>
                    <td class="text-center"><%=transres.getPlaca()%></td>
                    <td class="text-center"><%=transres.getZona()%></td>
                </tr>
                <%}
                %>
            </table>
        </div>
</html>
