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


public class PartTimeEmployee extends Employees {
    private static double ratePerHour = 18.0;
    private int workingHours;

    public PartTimeEmployee(String id, String name, String position, int workingHours) {
        super(id, name, position);
        this.workingHours = workingHours;
    }

    @Override
    public double calculateSalary(){
        return ratePerHour * workingHours;
    }

    
    public int getWorkingHours(){ 
        return workingHours; 
    }
    public void setWorkingHours(int workingHours){ 
        this.workingHours = workingHours; 
    }
@Override
    public String toString() {
    return super.toString() +
           "\nEmployee Type: Part-Time" +
           "\nWorking Hours: " + workingHours +
           "\nRate Per Hour: RM" + ratePerHour +
           "\nSalary: RM" + String.format("%.2f", calculateSalary());
}
    
}
