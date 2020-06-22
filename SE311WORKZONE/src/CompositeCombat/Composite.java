package CompositeCombat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// ORGANIZE A HIERARCHY
interface Employee{
    void showEmployeeDetails();

}
class Developer implements Employee{
    private String name;
    private long empId;
    private String position;

    public Developer(String name, long empId, String position) {
        this.name = name;
        this.empId = empId;
        this.position = position;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println(empId+" "+name+" " +position);
    }
}

class Manager implements Employee{
    private List<Employee> employeeList = new ArrayList<Employee>();
    private String name;
    private double salary;
    public Manager (String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    public Employee getChild(int i ){
        return employeeList.get(i);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("-----------");
        System.out.println("Name = "+getName());
        System.out.println("Salary =" +getSalary());
        System.out.println("------------------");

        Iterator<Employee> employeeIterator = employeeList.iterator();
        while(employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();
            employee.showEmployeeDetails();
        }
    }
    void addEmployee(Employee emp){
        employeeList.add(emp);
    }
    void removeEmployee(Employee emp){
        employeeList.remove(emp);
    }
}

public class Composite {
    public static void main(String[] args) {
        Employee dev1 = new Developer("Berk",1111,"Developer");
        Employee dev2 = new Developer("Barış",2222,"Master");

        Manager engManager = new Manager("Mike",2500);
        engManager.addEmployee(dev1);
        engManager.addEmployee(dev2);

        Employee dev3 = new Developer("Tom",3333,"Developer");

        Manager generalManager = new Manager("Mark",5000);
        generalManager.addEmployee(dev3);
        generalManager.addEmployee(engManager);
        generalManager.showEmployeeDetails();

    }
}
