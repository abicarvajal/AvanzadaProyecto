/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.transportecarga.service;

import java.util.Set;

/**
 *
 * @author Melissa
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends javax.ws.rs.core.Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ec.edu.espe.transportecarga.service.CarrierResource.class);
        resources.add(ec.edu.espe.transportecarga.service.ClientResource.class);
        resources.add(ec.edu.espe.transportecarga.service.DepartmentResource.class);
        resources.add(ec.edu.espe.transportecarga.service.GuideResource.class);
        resources.add(ec.edu.espe.transportecarga.service.ProductResource.class);
        resources.add(ec.edu.espe.transportecarga.service.ProvinceResource.class);
        resources.add(ec.edu.espe.transportecarga.service.TransportistResource.class);
        resources.add(ec.edu.espe.transportecarga.service.UserResource.class);
        resources.add(ec.edu.espe.transportecarga.service.ZoneResource.class);
    }
    
}
