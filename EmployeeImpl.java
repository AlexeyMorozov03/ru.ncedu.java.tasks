package ru.ncedu.java.tasks;

public class EmployeeImpl implements Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private Employee manager;

    EmployeeImpl(){
        firstName = null;
        lastName = null;
        salary = 1000;
        manager = null;
    }

    EmployeeImpl(String firstNameEmployee, String lastNameEmployee, int salarySize, Employee localManager){
        setFirstName(firstNameEmployee);
        setLastName(lastNameEmployee);
        salary = salarySize;
        setManager(localManager);
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public void increaseSalary(int value) {
        salary += value;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstNameEmployee) {
        firstName = firstNameEmployee;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastNameEmployee) {
        lastName = lastNameEmployee;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public void setManager(Employee localManager) {
        manager = localManager;
    }

    @Override
    public String getManagerName() {
        if(manager == null){
            return "No manager";
        }
        return manager.getFirstName() + " " + manager.getLastName();
    }

    @Override
    public Employee getTopManager() {
        if(manager == null){
            return this;
        }
        else{
            return manager.getTopManager();
        }
    }

    public static void main(String... args){
        EmployeeImpl a = new EmployeeImpl("John", "Newman", 5000, null);

        EmployeeImpl b = new EmployeeImpl();
        b.setFirstName("Neil");
        b.setLastName("Masuro");
        b.increaseSalary(1600);
        b.setManager(a);

        EmployeeImpl c = new EmployeeImpl("Zack", "Hougher", 1500, b);

        System.out.println("Full name: " + a.getFullName());
        System.out.println("Salary: " + a.getSalary());
        System.out.println("Manager: " + a.getManagerName());
        System.out.println();

        System.out.println("Full name: " + b.getFullName());
        System.out.println("Salary: " + b.getSalary());
        System.out.println("Manager: " + b.getManagerName());
        System.out.println();

        System.out.println("Full name: " + c.getFullName());
        System.out.println("Salary: " + c.getSalary());
        System.out.println("Manager: " + c.getManagerName());
        System.out.println();

        System.out.println("Top manager: " + c.getTopManager().getFullName());
    }
}
