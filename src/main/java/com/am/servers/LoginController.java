package com.am.servers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.am.Item;

/**
 * Servlet implementation class Login
 */
public class LoginController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
		LoginJavaClass ljc=new LoginJavaClass();
		String id=request.getParameter("userId");
		String pwd=request.getParameter("password");
		HttpSession session1;
		int flag=0;
		RequestDispatcher dispatcher=null;
		
		try 
		{
			flag=ljc.ipValidation(id, pwd);
		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag==1)
		{
			ArrayList<Item> itemList=ljc.getItemList();
			session1=request.getSession(true);
			session1.setAttribute("itemList", itemList);
			dispatcher = getServletContext().getRequestDispatcher("/displayItems.jsp");
	        dispatcher.forward(request, response);
		}
		
		else
		{
        	dispatcher = getServletContext().getRequestDispatcher("/Error.jsp");
        	dispatcher.forward(request, response);
		}
	}
}