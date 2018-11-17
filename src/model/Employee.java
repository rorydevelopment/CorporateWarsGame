package model;

import java.util.Random;

public class Employee {

	private String employeeName;
	private int employeeId;
	private int employeeHealth;
	private int employeeArmor;
	private Weapon employeeWeapon;
	private boolean employeeHasWeapon;
	private boolean employeeHasArmor;
	@SuppressWarnings("unused")
	private boolean isAlive;
	private Random randomNum;
	
	public Employee() {
		// TODO Auto-generated constructor stub
		employeeHealth = 100;
		employeeArmor = 0;
		employeeHasWeapon = false;
		employeeHasArmor = false;
		isAlive = true;
	}

	public Employee(String name, int Id) {
		this();
		employeeName = name;
		setEmployeeId(Id);
		
		randomNum = new Random();
		setWeapon(randomNum.nextInt(5));
	}
	
	public Employee(String name, boolean armor) {
		employeeName = name;
		employeeHasArmor = armor;
	}
	
	public String getName() {
		return employeeName;
	}
	
	public void setName(String name) {
		employeeName = name;
	}
	
	public int getEmployeeHealth() {
		return employeeHealth;
	}
	
	public void setEmployeeHealth(int value) {
		employeeHealth = value;
	}
	
	public int getEmployeeArmor() {
		return employeeArmor;
	}
	
	public void setEmployeeArmor(int value) {
		employeeArmor = value;
	}
	
	public Weapon getWeapon() {
		return employeeWeapon;
	}
	
	public void setWeapon() {
		employeeWeapon = new Weapon();
		employeeHasWeapon = true;
	}
	
	public void setWeapon(int weaponType) {
		employeeWeapon = new Weapon(weaponType);
		employeeHasWeapon = true;
	}
	
	public int getWeaponPower() {
		return employeeWeapon.getWeaponPower();
	}
	
	public void takeWeapon() {
		employeeWeapon = null;
		employeeHasWeapon = false;
	}
	
	public boolean hasWeapon() {
		if(this.employeeHasWeapon == true) {
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	private void giveArmor() {
		employeeHasArmor = true;
	}
	
	@SuppressWarnings("unused")
	private void takeArmor() {
		employeeHasArmor = false;
	}
	
	@SuppressWarnings("unused")
	private boolean hasArmor() {
		if(this.employeeHasArmor == true) {
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	private boolean isAlive() {
		if(this.employeeHealth > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int Id) {
		employeeId = Id;
	}
}
