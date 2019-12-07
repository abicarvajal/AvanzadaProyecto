/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.model;

import com.google.gson.reflect.TypeToken;
import com.google.gson.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Abi
 */
public class ServiceDAO {
    
    public ArrayList<clienteVO> getServices(){
         ArrayList<clienteVO> services = null;
         try {
            String url = "http://localhost:8080/TransporteCarga";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            Type tipoListaServicios = new TypeToken<List<clienteVO>>(){}.getType();


            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               response.append(inputLine);
            }
            in.close();
            //print in String
            services = gson.fromJson(response.toString(), tipoListaServicios);

         } catch (MalformedURLException ex0) {
             Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex0);
         } catch (ProtocolException ex2) {
             Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex2);
         } catch (IOException ex1) {
             Logger.getLogger(ServiceDAO.class.getName()).log(Level.SEVERE, null, ex1);
         }
         
         return services;
     }
}
