package my.payrollsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */

import my.payrollsystem.PartTimeEmployee;
import my.payrollsystem.Employees;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class PayrollManager {

    private ArrayList<Employees> employeeList = new ArrayList<>();

    public void addEmployee(Employees emp) throws Exception {
        for (Employees e : employeeList) {
            if (e.getId().equalsIgnoreCase(emp.getId())) {
                throw new Exception("ID already exists.");
            }
        }
        employeeList.add(emp);
    }

    public boolean deleteEmployee(String id) {
         Iterator<Employees> iterator = employeeList.iterator();
    while (iterator.hasNext()) {
        Employees e = iterator.next();
        if (e.getId().equalsIgnoreCase(id)) {
            iterator.remove();
            return true;
        }
    }
    return false;
}

    public Employees searchEmployee(String id) {
        for (Employees e : employeeList) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    public boolean updatePermanentEmployee(String id, String name, String position, double salary, int leaveTaken, int otHours) {
        for (Employees e : employeeList) {
            if (e.getId().equalsIgnoreCase(id) && e instanceof PermanentEmployee) {
                PermanentEmployee pe = (PermanentEmployee) e;
                pe.setName(name);
                pe.setPosition(position);
                pe.setBasicSalary(salary);
                pe.setLeaveTaken(leaveTaken);
                pe.setOtHours(otHours);
                return true;
            }
        }
        return false;
    }

    public boolean updatePartTimeEmployee(String id, String name, String position, int workingHours) {
        for (Employees e : employeeList) {
            if (e.getId().equalsIgnoreCase(id) && e instanceof PartTimeEmployee) {
                PartTimeEmployee pt = (PartTimeEmployee) e;
                pt.setName(name);
                pt.setPosition(position);
                pt.setWorkingHours(workingHours);
                return true;
            }
        }
        return false;
    }

    public void saveToFile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (Employees e : employeeList) {
                if (e instanceof PermanentEmployee) {
                    PermanentEmployee pe = (PermanentEmployee) e;
                    writer.println("Permanent," + pe.getId() + "," + pe.getName() + "," + pe.getPosition() + "," +
                                   pe.getBasicSalary() + "," + pe.getLeaveTaken() + "," + pe.getTotalLeaveTaken() + "," +
                                   pe.getAnnualLeaveRemaining() + "," + pe.getOtHours());
                } else if (e instanceof PartTimeEmployee) {
                    PartTimeEmployee pt = (PartTimeEmployee) e;
                    writer.println("PartTime," + pt.getId() + "," + pt.getName() + "," + pt.getPosition() + "," +
                                   pt.getWorkingHours());
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public void loadFromFile(String fileName) {
        employeeList.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase("Permanent")) {
                    Employees pe = new PermanentEmployee(
                        data[1], data[2], data[3],
                        Double.parseDouble(data[4]),
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]),
                        Integer.parseInt(data[8])
                    );
                    employeeList.add(pe);
                } else if (data[0].equalsIgnoreCase("PartTime")) {
                    Employees pt = new PartTimeEmployee(
                        data[1], data[2], data[3],
                        Integer.parseInt(data[4])
                    );
                    employeeList.add(pt);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No previous data found or failed to load.");
        }
    }

    public ArrayList<Employees> getAllEmployees() {
        return employeeList;
    }
}

