package com.au.aop.service;

import com.au.aop.model.Circle;
import com.au.aop.model.Triangle;

public class ShapeService {
	
	public Circle circle;
	public Triangle triangle;
	
	public Circle getCircle() {
		return circle;
	}
	
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	public Triangle getTriangle() {
		return triangle;
	}
	
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

	public void throwException() throws InterruptedException {
		throw new InterruptedException();
	}
}
