/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maxcompany;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 *
 */
public class LoginServlet extends HttpServlet {		
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException
	{
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException {
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");

                ServletContext context = req.getServletContext();
                String realPath = context.getRealPath("/WEB-INF/files/")+"\\"+userid+".ser";
                
                AccountBean account = new AccountBean();

                try{
                    FileInputStream fis = new FileInputStream(new File(realPath));
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    account = (AccountBean)ois.readObject();
                } catch(Exception e) {
                    account = new AccountBean();
                }
                
                if(account.getName() != null && account.getPassword().equals(password)){
                    HttpSession session=req.getSession();
                    session.setAttribute("account", account);
                    req.setAttribute("userid", userid);
                    req.getRequestDispatcher("/accountJSP").forward(req, res);
                } else {
                    req.setAttribute("fail", "Wrong data, please repeat");
                    req.getRequestDispatcher("/login").forward(req, res);
                }
	}
        
        

}
