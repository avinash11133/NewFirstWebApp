package com.am.servers;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class SessionFilter
 */
public class SessionFilter implements Filter 
{

    /**
     * Default constructor. 
     */
    public SessionFilter() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	private static final Logger log = LogManager.getLogger(PerformanceFilter.class);
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		long startTime=System.currentTimeMillis();

		HttpServletRequest req=(HttpServletRequest) request;
		HttpSession session=req.getSession(false);
		
		if(session==null)
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request,response);
		}
		
		else
			chain.doFilter(request, response);
		
		log.debug("Time taken:"+(System.currentTimeMillis()-startTime));

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException 
	{
		// TODO Auto-generated method stub
	}

}
