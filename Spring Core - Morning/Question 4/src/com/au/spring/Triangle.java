package com.au.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Triangle {
	private Map<String,Point> points;
	private int height, width;
	//private List<Point> points; 
	
//	public List<Point> getPoints(){
//		return points;
//	}
//	
//	public void setPoints(List<Point> points){
//		this.points = points;
//	}
	/*private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}*/

	
//	public void draw() {
//		
//		for(Point point:points) {
//			System.out.println("PointA = "+point.getX()+","+point.getY());
//		}
//		/*System.out.println("PointA"+getPointA().getX()+"PointA"+getPointA().getX());
//		System.out.println("PointB"+getPointA().getX()+"PointB"+getPointB().getX());
//		System.out.println("PointC"+getPointA().getX()+"PointC"+getPointC().getX());*/
//	}

	public Map<String, Point> getPoints() {
		return points;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}

	public void draw() {	
        Iterator<Map.Entry<String, Point>> itr = this.points.entrySet().iterator(); 
		while(itr.hasNext()) {
			Map.Entry<String, Point>  mp = itr.next();
			System.out.println(mp.getKey()+" { "+ mp.getValue().getX() + ", "+mp.getValue().getY() + " } ");			
		}
		System.out.println("Height : " + getHeight());
		System.out.println("Width : " + getWidth());
	}

}
