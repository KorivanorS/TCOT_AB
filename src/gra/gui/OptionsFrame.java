package gra.gui;

import gra.GEngine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JPanel;

public class OptionsFrame extends JPanel{
	boolean set = false;
	int numb = 5;
	Button btns[] = new Button[numb];
	int sel = 0;
	public OptionsFrame(){
		super();
		btns[0]=new Button(100,100,300,50,Color.red,Color.green,"GRAPHON");
		btns[1]=new Button("BAS&ROLL");
		btns[2]=new Button("BLACKJACK");
		btns[3]=new Button("SLUTS");
		btns[4]=new Button("BACK");
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
			if(sel<0) sel=numb-1;
			btns[sel].on();
		}
		if(GEngine.keycode==KeyEvent.VK_DOWN){
			btns[sel].off();
			sel++;
			if(sel>numb-1) sel=0;
			btns[sel].on();
		}
		if(GEngine.keycode==KeyEvent.VK_ENTER){
			if(sel==0){btns[0].txt="LOL";}
			if(sel==1){btns[1].txt="LOL";}
			if(sel==2){btns[2].txt="LOL";}
			if(sel==3){btns[3].txt="LOL";}
			if(sel==4){GEngine.nxtP = new MainFrame();}
		}
		GEngine.res();
	}
}
