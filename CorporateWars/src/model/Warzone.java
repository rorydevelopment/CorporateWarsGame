package model;

import java.util.ArrayList;
import java.util.Random;

public class Warzone {

	private ArrayList<Company> collectionOfCompanies;
	private Random randomNum;
	private boolean gameOver;
	private Company attackCompany;
	private Company victimCompany;
	private Employee attackEmp = null;
	private Employee victimEmp = null;
	
	public Warzone() {
		// TODO Auto-generated constructor stub
		collectionOfCompanies = new ArrayList<Company>();
		
		for(int i=1; i<11; i++) {
			Company comp = new Company("company " + Integer.toString(i), i, 10);
			collectionOfCompanies.add(comp);
		}
	}
	
	public void fight() {
		randomNum = new Random();
		gameOver = false;
		
		// Create the Game loop...
		while(gameOver == false) {
			// Attacking Company:
			// Randomly select a company with an Id within the range of total Companies.
			while(attackCompany == null) {
				for(Company comp : collectionOfCompanies) {
					if(comp.getCompanyId() == randomNum.nextInt(10) + 1) {
						attackCompany = comp;
					} else {
						continue;
					}
				}
			}
			// Victim Company:
			// Randomly select a company by number less than total amount of Companies
			// but not equal to the Id of the Attacking Company.
			while(victimCompany == null) {
				for(Company comp : collectionOfCompanies) {
					if(comp.getCompanyId() == randomNum.nextInt(10) + 1 && comp.getCompanyId() != attackCompany.getCompanyId()) {
						victimCompany = comp;
					} else {
						// Continue with the next Object in the loop if True fails...
						continue;
					}
				}
			}
			// Get Employees:
			// Randomly select an Employee from the Attacking and Victim Companies.

			attackEmp = attackCompany.getEmployee();
			victimEmp = victimCompany.getEmployee();
			
			// Attack the Victim Employee.
			victimEmp.setEmployeeHealth(victimEmp.getEmployeeHealth() - attackEmp.getWeaponPower());
			// If their Health is = 0, remove them from the Company.
			if(victimEmp.getEmployeeHealth() <= 0) {
				victimCompany.removeEmployee(victimEmp);
			}
			checkIfCompanyStillHasEmployees();
			
			printGameStatus();
			resetAttackersAndVictims();
			
			// Check to see how many Companies are left. Only one can remain to Win the Game...
			if(collectionOfCompanies.size() > 1) {
				gameOver = false;
			} else {
				Company winner = collectionOfCompanies.get(collectionOfCompanies.size()-1);
				System.out.println("Winner is: " + winner.getCompanyName());
				gameOver = true;
			}
		}
	}

	public boolean isGameOver() {
		if(gameOver == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void setGameStatus(boolean status) {
		gameOver = status;
	}
	
	public void printGameStatus() {
		System.out.println("  " + attackCompany.getCompanyName() + "[" +
							attackCompany.getNumberOfEmployeeObjects() + "]" + 
							": Employee " + attackEmp.getEmployeeId() + " [" + 
							attackEmp.getEmployeeHealth() + "]" + " attacks " +
							victimCompany.getCompanyName() + "[" + 
							victimCompany.getNumberOfEmployeeObjects() + "]" + 
							": Employee " + victimEmp.getEmployeeId() + " [" +
							victimEmp.getEmployeeHealth() + "]");
		
//		System.out.println("  " + attackCompany.getCompanyName() + ": Employee " + 
//				   attackEmp.getEmployeeId() + " attacks " +
//				   victimCompany.getCompanyName() + ": Employee " + 
//				   victimEmp.getEmployeeId());
		
//		for(Company comp : collectionOfCompanies) {
//			System.out.println(comp.getCompanyName() + ": Employee count is: " + 
//							   comp.getNumberOfEmployeeObjects());
//		}

	}
	
	public void resetAttackersAndVictims() {
		attackCompany = null;
		victimCompany = null;
		attackEmp = null;
		victimEmp = null;
	}
	
	public void checkIfCompanyStillHasEmployees() {		
		if(victimCompany.getNumberOfEmployeeObjects() < 1) {
			// Kill the Company...
			collectionOfCompanies.remove(victimCompany);
		}
	}
	
}
