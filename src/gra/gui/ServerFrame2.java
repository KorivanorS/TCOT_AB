package gra.gui;

import gra.GEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;

import mp.Server;

public class ServerFrame2 extends JPanel{
	boolean set = false;
	Button btns[] = new Button[2];
	int sel = 0;
	public ServerFrame2(){
		super();
		btns[0]=new Button(100,100,300,50,Color.red,Color.green,"");
		btns[1]=new Button("Stop!");
		btns[0].on();
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.fillRect(0, 0, 800, 600);
		if(!set) try{g2.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/OP.ttf")).deriveFont(30f));}catch(Exception e){e.printStackTrace();}
		for(Button i:btns) i.draw(g2);
		if(GEngine.keycode==KeyEvent.VK_UP){
			btns[sel].off();
			sel--;
			if(sel<0) sel=1;
			btns[sel].on();
		}
		else if(GEngine.keycode==KeyEvent.VK_DOWN){
			btns[sel].off();
			sel++;
			if(sel>1) sel=0;
			btns[sel].on();
		}
		else if(GEngine.keycode==KeyEvent.VK_ENTER){
			if(sel==0){}
			else if(sel==1){System.exit(0);}
		} else if(GEngine.keycode==0){
			
		}
		else{
			(btns[sel]).cal(GEngine.keycode);
			GEngine.res();
		}
		GEngine.res();
	}
}
