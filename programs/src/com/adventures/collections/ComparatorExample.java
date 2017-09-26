package com.adventures.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ComparatorExample {
	public static void main(String[] args) {
		EmployeePojo e1 = new EmployeePojo(1, "A", 20000.00, new Date(2010, 12, 11));
		EmployeePojo e2 = new EmployeePojo(2, "A", 22000.00, new Date(2009, 12, 11));
		EmployeePojo e3 = new EmployeePojo(3, "A", 10000.00, new Date(1990, 12, 11));
		EmployeePojo e4 = new EmployeePojo(4, "F", 19000.00, new Date(2001, 12, 11));
		EmployeePojo e5 = new EmployeePojo(5, "E", 24000.00, new Date(2006, 12, 11));
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);

		Collections.sort(list, new EmployeeNameComparator());
		// PRINT AFTER SORTED BY NAME
		System.out.println("AFTER SORTED BY NAME");
		System.out.println("===============================================================");
		System.out.println("ID  Name  Salary  Date Of Joining");
		System.out.println("===============================================================");
		for (EmployeePojo employee : list) {
			System.out.println(employee.getEmpId() + "\t\t " + employee.getName() + "\t\t" + employee.getSalary()
					+ "\t\t " + employee.getDateOfJoining().getDay() + "-" + employee.getDateOfJoining().getMonth()
					+ "-" + employee.getDateOfJoining().getYear());
		}

		// sorting the EmployeePojo object

		Collections.sort(list, new EmployeeDOJComparator());

		// PRINT AFTER SORTED BY AGE
		System.out.println("AFTER SORTED BY DATE OF JOINING");
		System.out.println("===============================================================");
		System.out.println("ID  Name  Salary  Date Of Joining");
		System.out.println("===============================================================");
		for (EmployeePojo employee : list) {
			System.out.println(employee.getEmpId() + "\t\t " + employee.getName() + "\t\t" + employee.getSalary()
					+ "\t\t " + employee.getDateOfJoining().getDay() + "-" + employee.getDateOfJoining().getMonth()
					+ "-" + employee.getDateOfJoining().getYear());
		}
	}
}

class EmployeeNameComparator implements Comparator<EmployeePojo> {

	@Override
	public int compare(EmployeePojo e1, EmployeePojo e2) {
		if (e1 == null || e2 == null) {
			throw new NullPointerException("compareTo: Argument passed is null");
		}
		return e1.getName().compareTo(e2.getName());
	}

}

class EmployeeDOJComparator implements Comparator<EmployeePojo> {

	@Override
	public int compare(EmployeePojo e1, EmployeePojo e2) {
		if (e1 == null || e2 == null) {
			throw new NullPointerException("compareTo: Argument passed is null");
		}
		return new Integer(e1.getDateOfJoining().compareTo(e2.getDateOfJoining()));
	}

}

class EmployeePojo {
	public EmployeePojo() {
	}

	public EmployeePojo(int empId, String name, double salary, Date dateOfJoining) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}

	private int empId;
	private String name;
	private double salary;
	private Date dateOfJoining;

	// setters and getters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}