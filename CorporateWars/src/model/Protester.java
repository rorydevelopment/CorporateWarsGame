package model;

import java.util.Random;

public class Protester {

	private String protesterName;
	private int protesterId;
	private int protesterHealth;
	private int protesterAttack;
	private Random randomNum;
	
	public Protester() {
		// TODO Auto-generated constructor stub
		setProtesterHealth(100);
	}
	
	public Protester(String name, int Id) {
		this();
		setProtesterName(name);
		setProtesterId(Id);
	}
	
	public int getProtesterAttack() {
		return protesterAttack;
	}
	
	public void setProtesterAttack() {
		randomNum = new Random();
		protesterAttack = randomNum.nextInt(10) + 1;
	}

	public String getProtesterName() {
		return protesterName;
	}

	public void setProtesterName(String protesterName) {
		this.protesterName = protesterName;
	}

	public int getProtesterId() {
		return protesterId;
	}

	public void setProtesterId(int protesterId) {
		this.protesterId = protesterId;
	}

	public int getProtesterHealth() {
		return protesterHealth;
	}

	public void setProtesterHealth(int protesterHealth) {
		this.protesterHealth = protesterHealth;
	}

}
