package com.holyshit.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//�����������
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-contrl", "no-cache");
		response.setHeader("expires", "0");
		//������ҳˢ��
//		response.setIntHeader("refresh", 1);
//		
		//����ͼ��
		int width=100,height=34;
		BufferedImage image = createCode(width, height,request);
		//���������
		OutputStream out=response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}
	
	
	private BufferedImage createCode(int width, int height,HttpServletRequest request) {
		HttpSession session=request.getSession();
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics=image.getGraphics();
		//��ȡ����ɫ
		Color bg=getRandColor(150, 255);
		
		
		graphics.setColor(bg);
		graphics.fillRect(1, 1, width-2, height-2);
		
		//��ȡ�߿���ɫ
		Color fg=getRandColor(0, 150);
		graphics.setColor(fg);
		graphics.drawRect(1, 1, width-1, height-1);
		Random randnumber=new Random();
		String number="";
		for(int i=0;i<4;i++){
			int num=randnumber.nextInt(10);
			number+=num;
			Color fontColor=getRandColor(50, 100);
			graphics.setFont(new Font("����",Font.BOLD,30));
			graphics.drawString(Integer.toString(num), 10+20*i, 30);
		}
		//������֤�뵽session
		session.setAttribute("validatecode", number);
		//���������
		for(int i=0;i<50;i++){
			int x1=randnumber.nextInt(100);
			int y1=randnumber.nextInt(50);
			int x2=randnumber.nextInt(100);
			int y2=randnumber.nextInt(50);
			graphics.setColor(getRandColor(50, 100));
			graphics.drawLine(x1, y1, x2, y2);
		}
		return image;
	}
	private Color getRandColor(int a,int b){
		if(a>b){
			a=200;
			b=255;
		}
		Random random=new Random();
		int x1=a+random.nextInt(b-a+1);
		int x2=a+random.nextInt(b-a+1);
		int x3=a+random.nextInt(b-a+1);
		return new Color(x1,x2,x3);
	}
}
