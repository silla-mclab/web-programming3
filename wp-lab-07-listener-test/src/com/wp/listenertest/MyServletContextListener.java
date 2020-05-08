package com.wp.listenertest;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		
		// get ServletContext ref.
		ServletContext context = sce.getServletContext();
		
		// get "breed" init-parameter
		String breed = context.getInitParameter("breed");
		
		// create a instance of Dog class
		Dog dog = new Dog();
		dog.setBreed(breed);
		
		// bind dog instance to ServletContext
		context.setAttribute("dog", dog);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
}
