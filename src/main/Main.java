package main;

import java.awt.GraphicsEnvironment;

public class Main {
	public static void main(String[] args) {
		SuperVisor tm = new SuperVisor();
		Thread t = new Thread(tm);
		t.start();
	}
}