package com.wandoufilm.util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{
	public void launchFrame(){
		setSize(Const.B_width,Const.B_height);
		setLocation(Const.L_width,Const.L_height);
		setVisible(true);
		new  PaintThread().start();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);;
			}

		});
		
	}
	
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
