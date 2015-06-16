package com.wandoufilm.Plan;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.wandoufilm.util.Const;
import com.wandoufilm.util.GameUtil;
import com.wandoufilm.util.MyFrame;
/**
 * 战机类
 * @author xiaomi
 *
 */
public class Plan extends GameObject{
	 boolean top,bottom,left,right;
	 private boolean live=true;
	public void draw(Graphics g){
		if(live){
			g.drawImage(img, (int)x,(int)y, null);
			move();
		}
	}


	public Plan(String imgpath, double x, double y) {
		super();
		this.img =GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
	}
	public Plan(){
		
	}
	
	public boolean isLive() {
		return live;
	}


	public void setLive(boolean live) {
		this.live = live;
	}


	public void move(){
		// TODO Auto-generated method stub
		if(top){
			if(y>30){
				y-=speed;
			}
		}
		if(bottom){
			if(y<Const.B_height-120){
				y+=speed;	
			}
			
		}
		if(left){
			if(x>0){
				x-=speed;
			}
			
		}
		if(right){
			if(x<Const.B_height-30){
				x+=speed;
			}
		}

	}
	
	
}
