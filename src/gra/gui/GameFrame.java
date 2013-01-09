package gra.gui;

import gra.GEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.*;

import mp.Server;

public class GameFrame extends JPanel{
	public GameFrame(){
		super();
		
	}
	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);
		g2.fillRect(0, 0, 800, 600);
		g2.setColor(Color.green);
		g2.drawLine(600, 0, 600, 600);
		GEngine.res();
	}
}
