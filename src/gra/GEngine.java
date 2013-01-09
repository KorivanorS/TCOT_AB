package gra;

import gra.gui.MainFrame;

import java.awt.event.*;

import javax.swing.*;

import mp.Client;
import mp.Server;

import utils.Debug;

public class GEngine extends JFrame implements Runnable{
	public static int keycode;
	public static JPanel curP;
	public static JPanel nxtP=null;
	public static Server s;
	public static Client c;
	public GEngine(){
		super("AB");
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setResizable(false);
	}
	public static void res(){
		keycode=0;
	}
	public void run() {
		curP = new MainFrame();
		this.add(curP);
		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyPressed(KeyEvent e) {
				keycode=e.getKeyCode();
			}
		});
		while(true){
			curP.repaint();
			if(keycode==KeyEvent.VK_ESCAPE) System.exit(0);
			if(nxtP!=null){
				curP.setVisible(false);
				curP=nxtP;
				this.add(curP);
				nxtP=null;
			}
			try{Thread.sleep(100);}catch(Exception e){}
		}
	}
}
