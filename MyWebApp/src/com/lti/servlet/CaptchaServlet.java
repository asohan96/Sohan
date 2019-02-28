package com.lti.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



 
@WebServlet("/cap.jpg")
public class CaptchaServlet extends HttpServlet {
	 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		 String text = "";
		  for (int i = 0; i < 5; i++) {
		      int r= (int)(Math.floor(Math.random() * str.length()));
		     text+=str.charAt(r);
		
	}
		  response.setContentType("image/jpeg");
			ServletOutputStream out=response.getOutputStream();
			
			BufferedImage img=new BufferedImage(130,80,BufferedImage.TYPE_INT_RGB);
			Graphics g=img.getGraphics();
			
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, 130, 80);
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Harrington",Font.BOLD,28));
			g.drawString(text, 5, 50);
			
			ImageIO.write(img, "jpeg",out);
			
		
		  //System.out.print(text);
 
	}


}