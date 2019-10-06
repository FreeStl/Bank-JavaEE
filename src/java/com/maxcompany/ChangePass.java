/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maxcompany;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class ChangePass  extends HttpServlet  {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException
	{
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException, java.io.IOException {
            String name = req.getParameter("user-name");
            String oldPassword = req.getParameter("old-password");
            String newPass = req.getParameter("new-password");
            String newPassRepeat = req.getParameter("new-password-confirm");
            
            AccountBean account;
            ServletContext context = req.getServletContext();
            String realPath = context.getRealPath("/WEB-INF/files/")+"\\"+name+".ser";
            try{
                FileInputStream fis = new FileInputStream(new File(realPath));
                ObjectInputStream ois = new ObjectInputStream(fis);
                account = (AccountBean)ois.readObject();
                ois.close();
                System.out.println("B");
            } catch(Exception e) {
                System.out.println("C");
                account = new AccountBean();
            }
            if (account.getName() != null && account.getPassword().equals(oldPassword) && newPass.equals(newPassRepeat)){
                account.setPassword(newPass);
                FileOutputStream fos = new FileOutputStream(realPath);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(account);
                oos.close();
                req.getRequestDispatcher("/logged").forward(req, res);
            } else {
                    req.setAttribute("changeFail", "Wrong data, please repeat");
                    req.getRequestDispatcher("/changePass").forward(req, res);
                }
                
        }
}
