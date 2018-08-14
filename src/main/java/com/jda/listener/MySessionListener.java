package com.jda.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		// TODO Auto-generated method stub
		System.out.println("Session Created::ID "+sessionEvent.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		// TODO Auto-generated method stub
		System.out.println("Session Created::ID "+sessionEvent.getSession().getId());		
	}

}
