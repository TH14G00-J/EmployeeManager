import entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Employee #%d\n", i);
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            employees.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        Optional<Employee> em = employees.stream().filter(x -> x.getId() == id).findFirst();
        if (em.isPresent()) {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            em.get().salaryIncrease(percentage);
        }else {
            System.out.println("This id does not exist");
        }

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
