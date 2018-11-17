package model;

import java.util.ArrayList;
import java.util.Random;

public class Company {

	private String companyName;
	private int numberOfEmployees;
	private int companyValue;
	private ArrayList<Employee> collectionOfEmployees;
	private double hiringRate;
	private int companyId;
	private Random randomNum;
	private Employee tmpEmployee;
	
	public Company() {
		// TODO Auto-generated constructor stub
		numberOfEmployees = 0;
		companyValue = 0;
		//ArrayList<Object> collectionOfEmployees = new ArrayList<Object>();
		collectionOfEmployees = new ArrayList<Employee>();
		hiringRate = 0.1;
	}

//	public Company(int numberOfEmployees) {
//		for(int i=1; i<=numberOfEmployees; i++) {
//			Employee emp = new Employee("employee " + Integer.toString(i), i);
//			addEmployee(emp);
//		}
//	}
	
	public Company(String name, int id, int numberOfEmployees) {
		this();
		
		companyName = name;
		companyId = id;
		
		for(int i=1; i<=numberOfEmployees; i++) {
			Employee emp = new Employee("employee " + Integer.toString(i), i);
			addEmployee(emp);
		}
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String name) {
		companyName = name;
	}
	
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	
	public void setNumberOfEmployees(int number) {
		numberOfEmployees = number;
	}
	
	public int getCompanyValue() {
		return companyValue;
	}
	
	public void setCompanyValue(int value) {
		companyValue = value;
	}
	
	public void addCompanyValue(int value) {
		companyValue = companyValue + value;
	}
	
	public void subtractCompanyValue(int value) {
		companyValue = companyValue - value;
	}
	
	public void multiplyCompanyValue(int value) {
		companyValue = companyValue * value;
	}
	
	public void divideCompanyValue(int value) {
		companyValue = companyValue / value;
	}
	
	public void addEmployee(Employee employee) {
		collectionOfEmployees.add(employee);
		setNumberOfEmployeeObjects();
		//numberOfEmployees ++;
	}
	
	public void removeEmployee(Employee employee) {
		collectionOfEmployees.remove(employee);
		setNumberOfEmployeeObjects();
		//numberOfEmployees --;
	}
	
	public double getHiringRate() {
		return hiringRate;
	}
	
	public void setHiringRate(double value) {
		hiringRate = value;
	}
	
	public int getNumberOfEmployeeObjects() {
		return collectionOfEmployees.size();
	}
	
	public void setNumberOfEmployeeObjects() {
		numberOfEmployees = getNumberOfEmployees();
	}
	
	public int getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(int id) {
		companyId = id;
	}
	
	public void setEmployee() {
		randomNum = new Random();
		tmpEmployee = null;
		
		while(tmpEmployee == null) {
			for(Employee emp : collectionOfEmployees) {
				if(collectionOfEmployees.indexOf(emp) == randomNum.nextInt(10)) {
					tmpEmployee = emp;
				} else {
					continue;
				}
			}
		}
	}
	
	public Employee getEmployee() {
		setEmployee();
		return tmpEmployee;
	}
	
//	public Employee getEmployee() {
//		randomNum = new Random();
//		try {
//			for(Employee emp : collectionOfEmployees) {
//				if(collectionOfEmployees.indexOf(emp) == randomNum.nextInt(10)) {
//					return emp;
//				} else {
//					return null;
//				}
//				
//			}
//		} catch(Exception e) {
//			System.out.println("No Employee returned...");
//			return null;
//		}
//	}
	
}

