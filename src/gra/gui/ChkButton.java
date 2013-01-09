package gra.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import utils.Debug;

public class ChkButton extends Button{
	public String txt2 = "";
	public boolean state2 = false;
	public ChkButton(int x, int y, int sx, int sy, Color color, Color color2,String txt) {
		super(x, y, sx, sy, color, color2, txt);
		String ts=txt;
		this.txt=ts.substring(0, ts.indexOf(':'));
		txt2=ts.substring(ts.indexOf(':')+1,ts.length());
	}
	public ChkButton(String txt){
		super(txt);
		String ts=txt;
		this.txt=ts.substring(0, ts.indexOf(':'));
		txt2=ts.substring(ts.indexOf(':')+1,ts.length());
	}
	public void draw(Graphics2D g){
		Color color;
		if(state2==false) color=cOFF;
		else color=cON;
		g.setColor(color);
		g.draw(new Rectangle2D.Float(x,y,sx/2,sy));
		if(state==false)
			g.setColor(new Color(color.getRed()/2,color.getGreen()/2,color.getBlue()/2));
		else
			g.setColor(new Color(255-color.getRed()/2,255-color.getGreen()/2,255-color.getBlue()/2));
		g.fillRect(x+1, y+1, (sx/2)-2, sy-2);
		g.setColor(Color.black);
		g.drawString(txt, x+10, y+37);
		if(state2==false) color=cON;
		else color=cOFF;
		g.setColor(color);
		g.draw(new Rectangle2D.Float(x+sx/2,y,sx/2,sy));
		if(state==false)
			g.setColor(new Color(color.getRed()/2,color.getGreen()/2,color.getBlue()/2));
		else
			g.setColor(new Color(255-color.getRed()/2,255-color.getGreen()/2,255-color.getBlue()/2));
		g.fillRect(x+sx/2+1, y+1, (sx/2)-2, sy-2);
		g.setColor(Color.black);
		g.drawString(txt2, x+sx/2+10, y+37);
	}
	public void cal(int keycode){
		
	}
}
