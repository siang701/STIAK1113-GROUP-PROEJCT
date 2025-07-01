package my.payrollsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */


    public abstract class Employees {

    private String id;
    private String name;
    private String position;

    public Employees(String id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public abstract double calculateSalary();
    
    
    public String getId(){  
        return id; 
    }
    public String getName() {
        return name; 
    }
    public String getPosition() {
        return position; 
    }
      

    public void setId(String id) {
        this.id = id; 
    }
    public void setName(String name) {
        this.name = name; 
    }
    public void setPosition(String position) {
        this.position = position; 
    }
    
     @Override
     public String toString(){
        return "Name: " + name + "\nStaff ID: " + id + "\nPosition: " + position;
    }
}

