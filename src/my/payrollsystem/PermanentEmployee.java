package my.payrollsystem;


import my.payrollsystem.Employees;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author user
 */


public class PermanentEmployee extends Employees {
    private double basicSalary;
    private int leaveTaken;
    private int totalLeaveTaken;
    private int annualLeaveRemaining;
    private int otHours;

    private static int fixedWorkingDays = 24;
    private static int annualLeave = 8;
    private static double EPF = 0.12;
    private static double otRate = 25.0;

    public PermanentEmployee(String id, String name, String position, double basicSalary, int annualLeaveTaken, int totalLeaveTaken, int annualLeaveRemaining, int otHours) {
        super(id, name, position);
        this.basicSalary = basicSalary;
        this.leaveTaken = leaveTaken;
        this.totalLeaveTaken = totalLeaveTaken;
        this.annualLeaveRemaining = annualLeaveRemaining;
        this.otHours = otHours;
    }

    public void setLeaveTaken(int leaveTaken) {
        this.leaveTaken = leaveTaken;
        this.totalLeaveTaken += leaveTaken;

        
        this.annualLeaveRemaining -= leaveTaken;
        if (this.annualLeaveRemaining < 0) {
            this.annualLeaveRemaining = 0;
        }
    }
    
    @Override
    public double calculateSalary() {
       
        double epf = basicSalary * EPF;
        
        double leaveDeduction = 0.0;
        if (leaveTaken > annualLeaveRemaining) {
            int extraLeave = leaveTaken - annualLeaveRemaining;
            leaveDeduction = (basicSalary / fixedWorkingDays) * extraLeave;
    }
        double bonus;
        if (totalLeaveTaken > annualLeave) {
            bonus=0;       
        } else{
            bonus=150;
        }
        
        double otPay = otHours * otRate;
           
        return basicSalary - leaveDeduction - epf + bonus + otPay;
    }
    
    public void setCurrentLeaveTaken(int leave) {
        this.leaveTaken = leave;
        this.totalLeaveTaken += leave;  
    }

    public double getBasicSalary(){ 
        return basicSalary; 
    }
    public int getLeaveTaken(){ 
        return leaveTaken; 
    }
    public int getTotalLeaveTaken(){ 
        return totalLeaveTaken; 
    }
    public int getAnnualLeave(){
         return annualLeave;
         }
    public int getAnnualLeaveRemaining() {
        return annualLeaveRemaining;
    }
    public int getOtHours(){ 
        return otHours; 
    }
    


    public void setBasicSalary(double basicSalary){ 
        this.basicSalary = basicSalary; 
    }
    public void setAnnualLeaveRemaining(int annualLeaveRemaining) {
        this.annualLeaveRemaining = annualLeaveRemaining;
    }
    public void setOtHours(int otHours){ 
        this.otHours = otHours; 
    }

 @Override
    public String toString() {
    return super.toString() +
           "\nEmployee Type: Permanent" +
           "\nBasic Salary: RM" + basicSalary +
           "\nLeave Taken (This Entry): " + leaveTaken +
           "\nTotal Leave Taken: " + totalLeaveTaken +
           "\nAnnual Leave Remaining: " + annualLeaveRemaining +
           "\nOT Hours: " + otHours +
           "\nEPF (12%): RM" + String.format("%.2f", basicSalary * 0.12) +
           "\nFinal Salary: RM" + String.format("%.2f", calculateSalary());
}

}
