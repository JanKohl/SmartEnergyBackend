/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jan.smartenergybackend.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author kohlbrecher
 */
@Path("value")
public class ValueResource {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMeasurement(JAXBElement<Measurement> measurement) {
        Todo c = todo.getValue();
        if (TodoDao.instance.getModel().containsKey(todo.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        TodoDao.instance.getModel().put(todo.getId(), todo);
        return res;
    }

}
