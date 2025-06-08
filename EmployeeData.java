import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
            new Employee("Alice", "HR", 85000, LocalDate.of(2020, 5, 10), Arrays.asList("Communication", "Recruiting")),
            new Employee("Bob", "Engineering", 95000, LocalDate.of(2019, 3, 15), Arrays.asList("Java", "Spring", "AWS")),
            new Employee("Charlie", "Marketing", 72000, LocalDate.of(2021, 1, 5), Arrays.asList("SEO", "Content Writing")),
            new Employee("David", "Engineering", 105000, LocalDate.of(2018, 7, 20), Arrays.asList("Java", "Kubernetes", "Docker")),
            new Employee("Eva", "Finance", 65000, LocalDate.of(2022, 4, 12), Arrays.asList("Excel", "Budgeting"))
        );
    }
}
