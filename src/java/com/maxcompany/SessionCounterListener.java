/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maxcompany;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author user
 */
public class SessionCounterListener implements HttpSessionListener {

  private static int totalActiveSessions;
  	
  public static int getTotalActiveSession(){
	return totalActiveSessions;
  }
	
  public void sessionCreated(HttpSessionEvent arg0) {
	totalActiveSessions++;
	System.out.println("sessionCreated - add one session into counter");
        logSession();
  }

  public void sessionDestroyed(HttpSessionEvent arg0) {
	totalActiveSessions--;
	System.out.println("sessionDestroyed - deduct one session from counter");
        logSession();
        //
  }
  
  private void logSession(){
            File f = new File("C:\\Users\\user\\Documents\\CS490\\Assignment2\\WebApplication1\\build\\web\\WEB-INF\\files\\log.txt");
            System.out.println("ABS"+f.getAbsolutePath());
                try{
                    f.createNewFile();
                    BufferedWriter bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
                    bw.write(getTotalActiveSession());
                    bw.close();
                } catch(IOException e){
                    System.out.println("fail write");
                }   
   }
}
  
 /*private void logSession(){
            File f = new File("C:\\Users\\user\\Documents\\CS490\\Assignment2\\WebApplication1\\build\\web\\WEB-INF\\files\\log.txt");
            System.out.println("ABS"+f.getAbsolutePath());
            BufferedWriter bw;
            if(f.exists()){
                try{
                    BufferedReader br = new BufferedReader(new FileReader(f.getAbsoluteFile()));
                    int count = Integer.parseInt(br.readLine());
                    bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
                    bw.write(++count);
                    br.close();
                    bw.close();
                } catch(FileNotFoundException e){
                    System.out.println("FileNotFoundException");
                } catch(IOException e){
                    System.out.println("IOException");
                }
            } else {
                try{
                    f.createNewFile();
                    bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile()));
                    bw.write("1");
                    bw.close();
                } catch(IOException e){
                    System.out.println("fail write");
                }
                
                
            }
    }*/

