package it.listener.web;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	 String sessionId = se.getSession().getId();

         System.out.println("Sessione CREATA: " + sessionId);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	String sessionId = se.getSession().getId();

        System.out.println("Sessione DISTRUTTA: " + sessionId);
    }
	
}
