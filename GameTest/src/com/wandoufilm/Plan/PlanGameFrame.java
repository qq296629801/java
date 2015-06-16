package com.wandoufilm.Plan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.wandoufilm.util.Const;
import com.wandoufilm.util.GameUtil;
import com.wandoufilm.util.MyFrame;

public class PlanGameFrame extends MyFrame{

	Image bg=GameUtil.getImage("img/bg.jpg");
	Image gongji=GameUtil.getImage("img/gongji.png");
	Image jian=GameUtil.getImage("img/jian.png");
	Plan p=new Plan("img/plan.png",50,Const.B_height-140);	
	Date startTime;
	Date endTime;
	ArrayList<Bullet> bulletList=new ArrayList<Bullet>();
	
	public void paint(Graphics g){
		g.drawImage(bg, 0,0, null);
		g.drawImage(gongji,Const.B_width/2-40,Const.B_height/2, null);
		g.drawImage(jian,Const.B_width/2-130,Const.B_height/2-30, null);
		p.draw(g);	
		for(int i=0;i<bulletList.size();i++){
			Bullet b=(Bullet)bulletList.get(i);
			b.draw(g);
			boolean peng=b.getRect().intersects(p.getRect());
			if(peng){
				p.setLive(false);
				endTime=new Date();
			}
		}
		// 检测碰撞
		if(!p.isLive()){
			printInfo(g,"GAME OVER!",20,Const.B_height-200,Const.B_height-200,Color.WHITE);
			int period=(int)((endTime.getTime()-startTime.getTime())/1000);
			switch(period/10){
			case 0:
			case 1:printInfo(g,"得分：菜鸟",30,Const.B_height-200,Const.B_height-300,Color.RED);break;
			case 2:printInfo(g,"得分：小神",30,Const.B_height-200,Const.B_height-300,Color.WHITE);break;
			case 3:printInfo(g,"得分：大神",30,Const.B_height-200,Const.B_height-300,Color.YELLOW);break;
			default:printInfo(g,"得分：牛逼",30,Const.B_height-200,Const.B_height-300,Color.blue);

			}
		}
	
	}
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c=g.getColor();
		g.setColor(color);
		Font f=new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str,x, y);
		g.setColor(c);
	}
	public static void main(String[] args) {
		new PlanGameFrame().launchFrame();
	}
	public void launchFrame(){
		super.launchFrame();
		addKeyListener(new KeyMonitor() {
		});
		
		//生成子弹
		for(int i=0;i<5;i++){
			Bullet b=new Bullet();
			bulletList.add(b);
		}
		
		startTime=new Date();
	}
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:p.left=true;break;
			case KeyEvent.VK_UP:p.top=true;break;
			case KeyEvent.VK_RIGHT:p.right=true;break;
			case KeyEvent.VK_DOWN:p.bottom=true;break;
			default:break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:p.left=false;break;
			case KeyEvent.VK_UP:p.top=false;break;
			case KeyEvent.VK_RIGHT:p.right=false;break;
			case KeyEvent.VK_DOWN:p.bottom=false;break;
			default:break;
			}
		}
		
	}
}
