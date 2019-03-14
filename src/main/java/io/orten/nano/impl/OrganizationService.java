package io.orten.nano.impl;

import io.orten.nano.model.Organization;
import io.orten.nano.util.Database;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class OrganizationService {

    public Response save(Organization org)
    {
        try{
            if (Database.saveOrganization(org)== true) {
                return Response.status(HttpServletResponse.SC_CREATED).build();
            } else {
                return Response.status(HttpServletResponse.SC_BAD_REQUEST).build();
            }
        }
        catch(Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response update(Organization org)
    {
        try{
            Database.updateOrganization(org);
            return Response.status(HttpServletResponse.SC_OK).build();
        }
        catch(Exception e){
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response get(Long orgId)
    {
        try {
            Organization org = Database.getOrganization(orgId);
            if (org!=null) {
                return Response.status(HttpServletResponse.SC_OK).entity(org).build();
            }else {
                return Response.status(HttpServletResponse.SC_NOT_FOUND).build();
            }
        } catch(Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    public Response getAll() {
        try {
            List<Organization> organizations = new ArrayList<>();
            organizations = Database.getAllOrganizations();
            if (!(organizations.isEmpty())){
            return Response.status(HttpServletResponse.SC_OK).entity(organizations).build();
            } else {
                return Response.status(HttpServletResponse.SC_NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    public Response delete(Long  orgId){
        try{
            if (Database.deleteOrganization(orgId)== true) {
                return Response.status(HttpServletResponse.SC_OK).build();
            }
            else {return Response.status(HttpServletResponse.SC_NOT_FOUND).build();}
        }
        catch(Exception e){
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}







