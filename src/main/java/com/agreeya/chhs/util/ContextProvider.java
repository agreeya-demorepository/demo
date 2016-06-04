package com.agreeya.chhs.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author amit.sharma
 *
 */
public class ContextProvider implements ApplicationContextAware {

	private static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		ContextProvider.ctx = ctx;
	}

	public static ApplicationContext getContext() {
		return ctx;

	}

}
