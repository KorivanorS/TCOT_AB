package gra.gui;

import gra.GEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;

import mp.Server;

public class ServerFrame extends JPanel{
	boolean set = false;
	Button btns[] = new Button[4];
	int sel = 0;
	public ServerFrame(){
		super();
		btns[0]=new Button(100,100,300,50,Color.red,Color.green,"Start!");
		btns[1]=new TxtButton("Port:");
		btns[2]=new ChkButton("ON:OFF");
		btns[3]=new Button("Back");
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
			if(sel<0) sel=3;
			btns[sel].on();
		}
		else if(GEngine.keycode==KeyEvent.VK_DOWN){
			btns[sel].off();
			sel++;
			if(sel>3) sel=0;
			btns[sel].on();
		}
		else if(GEngine.keycode==KeyEvent.VK_ENTER){
			if(sel==0){GEngine.s = new Server(36491);Thread t = new Thread(GEngine.s);t.start();GEngine.nxtP=new ServerFrame2();}
			else if(sel==1){}
			else if(sel==2){((ChkButton)btns[2]).state2=!((ChkButton)btns[2]).state2;}
			else if(sel==3){GEngine.nxtP=new MainFrame();}
		} else if(GEngine.keycode==0){
			
		}
		else{
			(btns[sel]).cal(GEngine.keycode);
			GEngine.res();
		}
		GEngine.res();
	}
}
