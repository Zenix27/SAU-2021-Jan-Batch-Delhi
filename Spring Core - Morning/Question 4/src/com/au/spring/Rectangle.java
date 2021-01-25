package com.au.spring;

import java.util.Iterator;
import java.util.Map;

public class Rectangle {
	private Map<String,Point> points;

	public Map<String, Point> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}
	
	public void draw() {	
        Iterator<Map.Entry<String, Point>> itr = this.points.entrySet().iterator(); 
		while(itr.hasNext()) {
			Map.Entry<String, Point>  mp = itr.next();
			System.out.println(mp.getKey()+" "+ mp.getValue().getX() +","+mp.getValue().getY());			
		}
	}
}
