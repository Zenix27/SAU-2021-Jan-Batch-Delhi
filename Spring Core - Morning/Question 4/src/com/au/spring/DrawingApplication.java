package com.au.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Triangle t = new Triangle();
		ApplicationContext factory = new FileSystemXmlApplicationContext("spring.xml");
		System.out.println("Triangle : ");
		Triangle triangle = (Triangle)factory.getBean("triangle");
		triangle.draw();

		System.out.println();
		System.out.println("Rectangle : ");
		Rectangle rectangle = (Rectangle) factory.getBean("rectangle");
		rectangle.draw();
		//t.draw();
		
		
	}

}
