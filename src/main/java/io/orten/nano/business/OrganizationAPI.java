package io.orten.nano.business;

import io.orten.nano.impl.OrganizationService;
import io.orten.nano.model.Organization;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * end point for all Organization operations
 */
@Path("/organisations")
public class OrganizationAPI {

    /**
     * saves an organization object in the database
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveOrganization(Organization org)
    {
        return new OrganizationService().save(org);
    }

    /**
     * updates an organization object that already saved in the database
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOrg(Organization org)
    {
        return new OrganizationService().update(org);
    }

    /**
     *     a method to retrieve an organization object from the database based on the organizationID
     */

    @GET
    @Path("{orgId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrg(@PathParam("orgId") Long orgId){
        return new OrganizationService().get(orgId);
    }

    /**
     * retrieves all orgnizations' objects that are already saved in the database
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrg(){
        return new OrganizationService().getAll();
    }

    /**
     * deletes an organization object from the database
     */
    @DELETE
    @Path("{orgId}")
    public Response deleteOrg(@PathParam("orgId") Long orgId){
        return new OrganizationService().delete(orgId);
    }
}

