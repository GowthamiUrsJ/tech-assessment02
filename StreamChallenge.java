/* import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamChallenge {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeData.getEmployees();

        // Challenge Set A
        System.out.println("1. Employees earning > $75,000:");
        employees.stream()
                 .filter(e -> e.getSalary() > 75000)
                 .forEach(System.out::println);

        System.out.println("\n2. Unique departments:");
        employees.stream()
                 .map(Employee::getDepartment)
                 .distinct()
                 .sorted()
                 .forEach(System.out::println);

        System.out.println("\n3. Total salary expenditure:");
        double total = employees.stream()
                                .mapToDouble(Employee::getSalary)
                                .sum();
        System.out.println("Total Salary = $" + total);
    }
} */

/* 
//challenge B
import java.util.*;
import java.util.stream.*;

public class StreamChallenge {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "HR", 85000, List.of("Communication", "Recruitment")),
            new Employee("Bob", "Engineering", 95000, List.of("Java", "Spring", "SQL")),
            new Employee("Charlie", "Finance", 75000, List.of("Excel", "Accounting")),
            new Employee("David", "Engineering", 105000, List.of("Java", "AWS", "Docker")),
            new Employee("Eve", "Marketing", 65000, List.of("SEO", "Content Writing"))
        );

        // 1. Average salary per department
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));
        System.out.println("Average salary by department:");
        avgSalaryByDept.forEach((dept, avg) -> System.out.println(dept + ": $" + avg));

        // 2. Unique skills sorted alphabetically
        List<String> uniqueSkills = employees.stream()
            .flatMap(emp -> emp.getSkills().stream())
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("\nUnique skills across organization:");
        uniqueSkills.forEach(System.out::println);

        // 3. Top 3 highest-paid employees' names
        List<String> topEarners = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .limit(3)
            .map(Employee::getName)
            .collect(Collectors.toList());
        System.out.println("\nTop 3 highest-paid employees:");
        topEarners.forEach(System.out::println);
    }
}
    */

    import java.util.*;
import java.util.stream.*;

public class StreamChallenge {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Alice", "HR", 85000, List.of("Communication", "Recruitment")),
            new Employee("Bob", "Engineering", 95000, List.of("Java", "Spring", "SQL")),
            new Employee("Charlie", "Finance", 75000, List.of("Excel", "Accounting")),
            new Employee("David", "Engineering", 105000, List.of("Java", "AWS", "Docker")),
            new Employee("Eve", "Marketing", 65000, List.of("SEO", "Content Writing"))
        );

        // 1. Department Report
        Map<String, String> deptToEmployeeNames = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.joining(", "))
            ));
        System.out.println("Department Report:");
        deptToEmployeeNames.forEach((dept, names) -> System.out.println(dept + ": " + names));

        // 2. Salary Bands
        Map<String, List<Employee>> salaryBands = employees.stream()
            .collect(Collectors.groupingBy(emp -> {
                double salary = emp.getSalary();
                if (salary <= 50000) return "0-50k";
                else if (salary <= 80000) return "50k-80k";
                else return "80k+";
            }));
        System.out.println("\nSalary Bands:");
        salaryBands.forEach((band, empList) -> {
            String names = empList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
            System.out.println(band + ": " + names);
        });

        // 3. Top Talent by Department
        Map<String, Optional<Employee>> topTalent = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
            ));
        System.out.println("\nTop Talent by Department:");
        topTalent.forEach((dept, empOpt) -> {
            String name = empOpt.map(Employee::getName).orElse("None");
            System.out.println(dept + ": " + name);
        });
    }
}



