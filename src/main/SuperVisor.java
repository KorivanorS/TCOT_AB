package main;

import gra.GEngine;

public class SuperVisor implements Runnable{
	public SuperVisor(){
		
	}
	public void run() {
		GEngine en = new GEngine();
		Thread t = new Thread(en);
		t.start();
	}
}
