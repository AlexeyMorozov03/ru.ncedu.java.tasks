package ru.ncedu.java.tasks;

public class EmployeeImpl implements Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private Employee manager;

    public EmployeeImpl(){
        salary = 1000;
    }

    public EmployeeImpl(String firstNameEmployee, String lastNameEmployee, int salarySize, Employee localManager){
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
}
