package com.collections;

public class Employee implements Comparable<Employee> {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return this.name + " " + this.salary;
    }

    @Override
    public int compareTo(Employee employee) {
      return this.getName().compareTo(employee.getName());
    }

}
