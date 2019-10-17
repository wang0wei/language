package cn.itacst.chapter08.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MyAttributeListener
 *
 */
@WebListener
public class MyAttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public MyAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	String name=scae.getName();
    	System.out.println("ServletContext�������:"+name+"="+scae.getServletContext().getAttribute(name));
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	String name=scae.getName();
    	System.out.println("ServletContext�Ƴ�����:"+name);
    }

    /**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
         // TODO Auto-generated method stub
    	String name=scae.getName();
    	System.out.println("ServletContext�滻����:"+name+"="+scae.getServletContext().getAttribute(name));
    }
    
	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	String name=srae.getName();
    	System.out.println("ServletRequest�Ƴ�����:"+name);
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	String name=srae.getName();
    	System.out.println("ServletRequest�������:"+name+"="+srae.getServletRequest().getAttribute(name));
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
         // TODO Auto-generated method stub
    	String name=srae.getName();
    	System.out.println("ServletRequest�滻����:"+name+"="+srae.getServletRequest().getAttribute(name));
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	String name=se.getName();
    	System.out.println("HttpSession�������:"+name+"="+se.getSession().getAttribute(name));
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	String name=se.getName();
    	System.out.println("HttpSession�Ƴ�����:"+name);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	String name=se.getName();
    	System.out.println("HttpSession�滻����:"+name+"="+se.getSession().getAttribute(name));
    }

	
	
}
