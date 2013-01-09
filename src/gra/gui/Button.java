package gra.gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Button {
	int x,y,sx,sy;
	Color cON,cOFF;
	String txt;
	boolean state=false;
	static int num;
	static int dx,dy,dsx,dsy;
	static Color dcON,dcOFF;
	public Button(int x,int y,int sx,int sy,Color color,Color color2,String txt){
		this.dx=x;
		this.dy=y;
		this.dsx=sx;
		this.dsy=sy;
		this.x=x;
		this.y=y;
		this.sx=sx;
		this.sy=sy;
		this.dcOFF=color;
		this.dcON=color2;
		this.cOFF=color;
		this.cON=color2;
		this.txt=txt;
		this.num=0;
	}
	public Button(String txt){
		this.num++;
		this.x=dx;
		this.y=dy+(dsy+10)*num;
		this.sx=dsx;
		this.sy=dsy;
		this.cOFF=dcOFF;
		this.cON=dcON;
		this.txt=txt;
	}
	public void on(){
		this.state=true;
	}
	public void off(){
		this.state=false;
	}
	public void draw(Graphics2D g){
		Color color;
		if(state==false) color=cOFF;
		else color=cON;
		g.setColor(color);
		g.draw(new Rectangle2D.Float(x,y,sx,sy));
		g.setColor(new Color(color.getRed()/2,color.getGreen()/2,color.getBlue()/2));
		g.fillRect(x+1, y+1, sx-2, sy-2);
		g.setColor(Color.black);
		g.drawString(txt, x+20, y+37);
	}
	public void cal(int keycode) {
		//stub
	}
}