import java.util.*;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class EmployeeDatabase {
    private ArrayList<Employee> employees;

    public EmployeeDatabase() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee searchEmployee(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    public void updateEmployee(int id, String name, double salary) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setSalary(salary);
                break;
            }
        }
    }

    public void displayEmployeeDatabase() {
        System.out.println("Employee Database:");
        for (Employee employee : employees) {
            System.out.print(employee.getId() + " - ");
            System.out.print(employee.getName() + " - ");
            System.out.print(employee.getSalary() + "\n");
        }
    }

    public static void main(String[] args) {
        EmployeeDatabase database = new EmployeeDatabase();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add new employee");
            System.out.println("2. Update employee information");
            System.out.println("3. Search for employee");
            System.out.println("4. Display employee database");
            System.out.println("5. Remove Employee");
            System.out.println("6. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    database.addEmployee(new Employee (name, id, salary));
                    break;
                case 2:
                    System.out.print("Enter employee ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new employee name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new employee salary: ");
                    salary = scanner.nextDouble();
                    database.updateEmployee(id, name, salary);
                    break;
                case 3:
                    System.out.print("Enter employee ID to search: ");
                    id = scanner.nextInt();
                    Employee employee = database.searchEmployee(id);
                    if (employee != null) {
                        System.out.println("Employee found: ");
                        System.out.print(employee.getId() + " - ");
                        System.out.print(employee.getName() + " - ");
                        System.out.print(employee.getSalary() + "\n");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;
                case 4:
                    database.displayEmployeeDatabase();
                    break;
                case 5:
                    System.out.println("Enter the id of the Employee:");
                    int idToRemove = scanner.nextInt();
                    Employee toRemove = database.searchEmployee(idToRemove);
                    if (toRemove.getName().equals("")) {
                        System.out.println("Employee not found.");

                    } else {
                        database.removeEmployee(toRemove);
                        System.out.println("Song removed.");
                    }
                case 6:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }
}
