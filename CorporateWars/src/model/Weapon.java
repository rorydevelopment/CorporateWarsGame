package model;

public class Weapon {

	private String weaponType;
	private int weaponIndex;
	private int weaponPower;
	private final int WEAPON_POWER_LEVEL_1 = 5;
	private final int WEAPON_POWER_LEVEL_2 = 10;
	private final int WEAPON_POWER_LEVEL_3 = 20;
	private final int WEAPON_POWER_LEVEL_4 = 35;
	private final int WEAPON_POWER_LEVEL_5 = 50;
	
	public Weapon() {
		// TODO Auto-generated constructor stub
		// default to basic weapon...
		weaponIndex = 1;
		setWeaponType("Keyboard");
		setWeaponPower(WEAPON_POWER_LEVEL_1);
	}

	public Weapon(int weaponLevel) {
		weaponIndex = weaponLevel;
		
		if(weaponIndex == 2) {
			weaponType = "Stapler";
			setWeaponPower(WEAPON_POWER_LEVEL_2);
		} else if(weaponIndex == 3) {
			setWeaponType("Lunch Box");
			setWeaponPower(WEAPON_POWER_LEVEL_3);
		} else if(weaponIndex == 4) {
			setWeaponType("Desk Chair");
			setWeaponPower(WEAPON_POWER_LEVEL_4);
		} else if(weaponIndex == 5) {
			setWeaponType("HR Rep");
			setWeaponPower(WEAPON_POWER_LEVEL_5);
		} else {
			//no valid weapon index provided, so default to basic...
			weaponIndex = 1;
			setWeaponType("Keyboard");
		}
	}
	
	public String getWeaponType() {
		return weaponType;
	}
	
	public void setWeaponType(String type) {
		weaponType = type;
	}
	
	public int getWeaponIndex() {
		return weaponIndex;
	}
	
	public void setWeaponIndex(int index) {
		weaponIndex = index;
	}
	
	public int getWeaponPower() {
		return weaponPower;
	}
	
	public void setWeaponPower(int value) {
		weaponPower = value;
	}
	
}
