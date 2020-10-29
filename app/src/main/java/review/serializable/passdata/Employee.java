package review.serializable.passdata;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private double rateOfPay;
    private double hoursWorked;
    private int performanceLevel;
    private double totalSalary;
    private double incomeTax;
    private double netSalary;

    // constructor
    public Employee(String name, double rateOfPay, double hoursWorked, int performanceLevel) {
        this.name = name;
        this.rateOfPay = rateOfPay;
        this.hoursWorked = hoursWorked;
        this.performanceLevel = performanceLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRateOfPay() {
        return rateOfPay;
    }

    public void setRateOfPay(double rateOfPay) {
        this.rateOfPay = rateOfPay;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getPerformanceLevel() {
        return performanceLevel;
    }

    public void setPerformanceLevel(int performanceLevel) {
        this.performanceLevel = performanceLevel;
    }

    public double calculateGrossSalary(double workedHours, double payRate, int performanceRate){

        if(performanceRate==1){
            totalSalary=(workedHours*payRate)+100;
        }
        else if(performanceRate==2){
            totalSalary=(workedHours*payRate)+225;
        }
        else{
            totalSalary=(workedHours*payRate)+500;
        }
        return totalSalary;
    }

    public double incomeTax(double grossSalary){
        if(grossSalary<=20000){
            incomeTax=0;
        }
        else{
            incomeTax=(grossSalary*0.4);
        }
        return incomeTax;
    }

    public double netSalary(double grossSalary,double incomeTax){
        netSalary=grossSalary-incomeTax;
        return  netSalary;
    }
}
