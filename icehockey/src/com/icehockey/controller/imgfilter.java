package com.icehockey.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class imgfilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD,
		DispatcherType.INCLUDE, DispatcherType.ERROR }, urlPatterns = {
		"*.jpg", "*.png" })
public class imgfilter implements Filter {

	/**
	 * Default constructor.
	 */
	public imgfilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		String uri = hrequest.getRequestURI();
		// 地址解码
		String decodeUri = URLDecoder.decode(uri, "utf-8");
		if (uri.equals(decodeUri)) {
			chain.doFilter(request, response);
		} else {
			decodeUri = decodeUri.substring(hrequest.getServletContext()
					.getContextPath().length());
			System.out.println("decode" + decodeUri);
			hrequest.getRequestDispatcher(decodeUri).forward(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
