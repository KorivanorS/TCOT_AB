package gra.gui;

import gra.GEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;

import utils.Debug;

public class MainFrame extends JPanel{
	boolean set = false;
	Button btns[] = new Button[4];
	int sel = 0;
	public MainFrame(){
		super();
		btns[0]=new Button(100,100,300,50,Color.red,Color.green,"Client");
		btns[1]=new Button("Server");
		btns[2]=new Button("Oprions");
		btns[3]=new Button("Exit");
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
		if(GEngine.keycode==KeyEvent.VK_DOWN){
			btns[sel].off();
			sel++;
			if(sel>3) sel=0;
			btns[sel].on();
		}
		if(GEngine.keycode==KeyEvent.VK_ENTER){
			if(sel==0){GEngine.nxtP=new ClientFrame();}
			if(sel==1){GEngine.nxtP=new ServerFrame();}
			if(sel==2){GEngine.nxtP=new OptionsFrame();}
			if(sel==3){System.exit(0);}
		}
		GEngine.res();
	}
}
