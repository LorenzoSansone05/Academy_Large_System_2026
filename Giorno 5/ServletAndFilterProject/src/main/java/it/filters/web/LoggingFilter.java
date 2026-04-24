package it.filters.web;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
/**
 * Servlet Filter implementation class LoggingFilter
 */
@WebFilter("/*")
public class LoggingFilter extends HttpFilter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoggingFilter() {
        super();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		long timeStamp = System.currentTimeMillis(); 
		String httpMethod = httpRequest.getMethod();
		String url = httpRequest.getRequestURI();
		
		
		System.out.println("Timestamp : " + timeStamp);
		System.out.println("HttpMethod: " + httpMethod);
		System.out.println("URL : " + url);

		chain.doFilter(request, response);

		long endRequest = System.currentTimeMillis();

		 System.out.println("Tempo: " + (endRequest - timeStamp) + " ms");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
