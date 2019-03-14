package io.orten.nano.business;

import io.orten.nano.impl.EventService;
import io.orten.nano.model.Event;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/events")
public class EventAPI {

    public static List<Event> eventList = new ArrayList<Event>();

    @GET
    @Path("/{eventid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventByEventId(@PathParam("eventid") Long id) {
        try {
            Event event = EventService.getEventByEventId(id);
            return Response.status(HttpServletResponse.SC_OK).entity(event).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/projectid/{projectid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventsByProjectId(@PathParam("projectid") long projectid) {
        try {
            List<Event> events = EventService.getEventsByProjectId(projectid);
            return Response.status(HttpServletResponse.SC_OK).entity(events).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListOfEvents() {
        try {
            List<Event> events = EventService.getListOfEvents();
            return Response.status(HttpServletResponse.SC_OK).entity(events).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/eventTitle/{eventTitle}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventsByEventTitle(@PathParam("eventTitle") String eventTitle) {
        try {
            List<Event> events = EventService.getEventsByEventTitle(eventTitle);
            return Response.status(HttpServletResponse.SC_OK).entity(events).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveEvent(Event event) {
        try {
            EventService.saveEvent(event);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/{eventid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEvent(Event event, @PathParam("eventid") Long eventId) {
        try {
            if(event.getEventId() == eventId) {
                EventService.updateEvent(event);
                return Response.status(HttpServletResponse.SC_OK).build();
            }
            else {
                return Response.status(HttpServletResponse.SC_BAD_REQUEST).build();
            }

        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{eventid}")
    public Response deleteEvent(@PathParam("eventid") Long eventId) {
        try {
            EventService.deleteEvent(eventId);
            return Response.status(HttpServletResponse.SC_OK).build();
        } catch (Exception e) {
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).build();
        }
    }
}