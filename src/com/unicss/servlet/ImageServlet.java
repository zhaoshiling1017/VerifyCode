package com.unicss.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = -3879957733728304120L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedImage bufferImage = new BufferedImage(68,22, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferImage.getGraphics();
		Color color = new Color(200, 150, 255);
		graphics.setColor(color);
		graphics.fillRect(0, 0, 68, 20);
		char[] ch = "abcdefghijklmnopkrstuvwxyz0123456789".toCharArray();
		Random random = new Random();
		int length = ch.length, index;
		StringBuffer strBuffer = new StringBuffer();
		for(int i=0; i<4; i++){
			index = random.nextInt(length);
			graphics.setColor(new Color(random.nextInt(100), random.nextInt(150), random.nextInt(200)));
			graphics.drawString(ch[index]+"", (i*15)+3, 18);
			strBuffer.append(ch[index]);
		}
		req.getSession().setAttribute("picCode", strBuffer.toString());
		ImageIO.write(bufferImage, "JPG", resp.getOutputStream());
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
