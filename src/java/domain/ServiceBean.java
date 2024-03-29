/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import abstractFacade.AbstractFacade;
import entities.Employee;
import entities.Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.hibernate.Session;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.Session;


/**
 *
 * @author Lachgar
 */
@ManagedBean
@RequestScoped
public class ServiceBean extends AbstractFacade<Service> implements Serializable{

    private Service service;
    private List<Service> services;
    //ServiceService seviceService;

    public ServiceBean() {
        service =  new Service();
        services = new ArrayList<>();
        //seviceService = new ServiceService(null);
    }

    public void onCreationAction(){
        services.add(service);
        //seviceService.create(service);
        service = new Service();
    }
    
    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @Override
    protected Class<Service> getEntityClass() {
        return Service.class;
    }    
    
}
