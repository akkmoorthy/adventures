package com.adventures.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ComparableExample {
	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Anil", 20000.00, new Date(2010, 12, 11));
		Employee e2 = new Employee(2, "Amith", 22000.00, new Date(2009, 12, 11));
		Employee e3 = new Employee(3, "Anuya", 10000.00, new Date(1990, 12, 11));
		Employee e4 = new Employee(4, "Fahad", 19000.00, new Date(2001, 12, 11));
		Employee e5 = new Employee(5, "Elangovan", 24000.00, new Date(2006, 12, 11));
		List<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		// PRINT BEFORE SORTING
		System.out.println("BEFORE SORTING");
		System.out.println("===============================================================");
		System.out.println("ID  Name  Salary  Date Of Joining");
		System.out.println("===============================================================");
		for (Employee employee : list) {
			System.out.println(employee.getEmpId() + "\t\t " + employee.getName() + "\t" + employee.getSalary()
					+ "\t\t " + employee.getDateOfJoining().getDay() + "-" + employee.getDateOfJoining().getMonth()
					+ "-" + employee.getDateOfJoining().getYear());
		}

		// Sorting the Employee object
		Collections.sort(list);
		// PRINT AFTER SORTING
		System.out.println("\n\nAFTER SORTING");
		System.out.println("===============================================================");
		System.out.println("ID  Name  Salary  Date Of Joining");
		System.out.println("===============================================================");
		for (Employee employee : list) {
			System.out.println(employee.getEmpId() + "\t\t " + employee.getName() + "\t\t" + employee.getSalary()
					+ "\t\t " + employee.getDateOfJoining().getDay() + "-" + employee.getDateOfJoining().getMonth()
					+ "-" + employee.getDateOfJoining().getYear());
		}
	}
}

class Employee implements Comparable<Employee> {
	public Employee(int empId, String name, double salary, Date dateOfJoining) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dateOfJoining = dateOfJoining;
	}

	private int empId;
	private String name;
	private double salary;
	private Date dateOfJoining;

	@Override
	public int compareTo(Employee o) {
		if (o == null) {
			throw new NullPointerException("compareTo: Argument passed is null");
		}
		if (this.getClass().equals(o.getClass())) {
			Employee e = (Employee) o;
			return this.getName().compareTo(e.getName());
		} else {
			throw new ClassCastException("compareTo: Objects are not comparable");
		}
	}

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