package com.wandoufilm.Plan;

import java.awt.Image;
import java.awt.Rectangle;

import com.wandoufilm.util.Const;

public class GameObject {
	 Image img;
	 double x,y;
	 int speed=Const.PLAN_speed;
	 int width,height;
	public Rectangle getRect(){
		Rectangle r=new Rectangle((int)x,(int)y,width,height);
		return r;
	}
	public GameObject(Image img, double x, double y, int speed, int width,
			int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}
	public GameObject(){
		
	}
}
