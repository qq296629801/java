package com.wandoufilm.Plan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.wandoufilm.util.Const;
/**
 * 子弹类
 * @author xiaomi
 *
 */
public class Bullet extends GameObject {
	int speed=1;
	double deg;
	
	public void draw(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.red);
		g.fillOval((int)x,(int) y, width, height);
		g.setColor(c);
		x+=speed*Math.cos(deg);
		y+=speed*Math.sin(deg);
		
		if(y>Const.B_height-10||y<10){
			deg=-deg;
		}
		if(x<0||x>Const.B_width-width){
			deg=Math.PI-deg;
		}
		
	}
	public Bullet(){
		x=Const.B_width/2;
		y=Const.B_width/2;
		deg=Math.random()*Math.PI*2;
		width=5;
		height=5;
	}
	
}
