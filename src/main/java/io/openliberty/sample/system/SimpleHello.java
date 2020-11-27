package io.openliberty.sample.system;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Import for persistence
import io.openliberty.sample.system.Event;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;

@WebServlet(name = "events", urlPatterns = { "/events" })
public class SimpleHello extends HttpServlet {
	
	
	@Resource
	UserTransaction utx;
	
	@PersistenceContext(name="jpa-unit")
	private EntityManager em;
	
	// tag::createEvent[]
    public void createEvent(Event event) {
        // tag::Persist[]
        try {
            utx.begin();
            em.persist(event);
            utx.commit();
        } catch (Exception e) {
            System.out.println("Exception in create: " + e.getMessage());
        }
        
        // end::Persist[]
    }
    // end::createEvent[]

    // tag::readEvent[]
    public Event readEvent(int eventId) {
        // tag::Find[]
        return em.find(Event.class, eventId);
        // end::Find[]
    }
    // end::readEvent[]

    // tag::updateEvent[]
    public void updateEvent(Event event) {
        // tag::Merge[]
        try {
            utx.begin();
            em.merge(event);
            utx.commit();
        } catch (Exception e) {
            System.out.println("Exception in update: " + e.getMessage());
        }
        // end::Merge[]
    }
    // end::updateEvent[]

    // tag::deleteEvent[]
    public void deleteEvent(Event event) {
        // tag::Remove[]
        // end::Remove[]
        try {
            utx.begin();
            Event merged = em.merge(event);
            em.remove(merged);
            utx.commit();
        } catch (Exception e) {
            System.out.println("Exception in delete: " + e.getMessage());
        }
    }
    // end::deleteEvent[]

    // tag::readAllEvents[]
    public List<Event> readAllEvents() {
        return em.createNamedQuery("Event.findAll", Event.class).getResultList();
    }
    // end::readAllEvents[]

    // tag::findEvent[]
    public List<Event> findEvent(String name, String location, String time) {
        return em.createNamedQuery("Event.findEvent", Event.class).setParameter("name", name)
                .setParameter("location", location).setParameter("time", time).getResultList();
    }
	
	
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String time = request.getParameter("time");
        Event prevEvent = readEvent(Integer.parseInt(id));
        try {
            if(prevEvent == null) {
                response.getWriter().println("Could not find the event");
            } else if(!findEvent(name, location, time).isEmpty()){
                response.getWriter().println("Could not find the event");
            } else {
                prevEvent.setName(name);
                prevEvent.setLocation(location);
                prevEvent.setTime(time);
        
                updateEvent(prevEvent);
                response.getWriter().println("Successfully updated event");
            }
        } catch(Exception e) {
            response.getWriter().println("Failed to update event.");
        }
        
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id  = Integer.parseInt(request.getParameter("id"));
            Event event = readEvent(id);
            if(event == null) {
                response.getWriter().println("Failed to find event to delete");
            } else {
                deleteEvent(event);
                response.getWriter().println("Successfully deleted event");
            }

        } catch (Exception e) {
            response.getWriter().println("Failed to delete Event:" + e.getMessage());
        }
        
    }

    @Override // Create an event
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // Add a new event
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String time = request.getParameter("time");
        Event newEvent = new Event(name, location, time);
        try {
            if(!findEvent(name, location, time).isEmpty()) {
                response.getWriter().println("Event already exists");

            } else {
                createEvent(newEvent);
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println("Created Event: " + newEvent.toString());
            }
        } catch (Exception e) {
            System.out.println("Exception" + e.getMessage());
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            Event event = readEvent(Integer.parseInt(id));
            if(event != null) {
                builder.add("name", event.getName()).add("time", event.getTime())
                    .add("location", event.getLocation()).add("id", event.getId());
            }
            response.getWriter().println(builder.build().toString());
        } else {
            JsonObjectBuilder builder = Json.createObjectBuilder();
            JsonArrayBuilder finalArray = Json.createArrayBuilder();
            for (Event event : readAllEvents()) {
                builder.add("name", event.getName()).add("time", event.getTime()).add("location", event.getLocation())
                        .add("id", event.getId());
                finalArray.add(builder.build());
            }
            response.setContentType("text/html;charset=UTF-8");
    
            response.getWriter().println(finalArray.build().toString());
        }  
    }
    
    
}