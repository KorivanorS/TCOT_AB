package gra.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import utils.Debug;

public class TxtButton extends Button{
	public String entertxt = "";
	public TxtButton(int x, int y, int sx, int sy, Color color, Color color2,String txt) {
		super(x, y, sx, sy, color, color2, txt);
	}
	public TxtButton(String txt){
		super(txt);
	}
	public void draw(Graphics2D g){
		Color color;
		if(state==false) color=cOFF;
		else color=cON;
		g.setColor(color);
		g.draw(new Rectangle2D.Float(x,y,sx,sy));
		g.setColor(new Color(255-color.getRed()/2,255-color.getGreen()/2,255-color.getBlue()/2));
		g.fillRect(x+1, y+1, sx-2, sy-2);
		g.setColor(Color.black);
		g.drawString(txt+entertxt, x+20, y+37);
	}
	public void cal(int keycode){
		char key=(char) keycode;
		if(key>='!'&&key<='~')
			entertxt=entertxt+Character.toString(key);
		else if(key==8 && !entertxt.equals(""))
			entertxt=(String) entertxt.subSequence(0, entertxt.length()-1);
	}
}
