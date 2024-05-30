package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/15/2024
 * @project algorithms_practice
 * &
 */
public class EmployeeStreamWorking {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
//https://medium.com/@amol_shinde/answers-practice-java-streams-questions-practice-java-streams-questions-8a76cbfee1be-f75a018ee4f5

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

        // List name of all distinct projects in non-ascending order.
        List<String> strings = employeeList.stream()
                .map(Employee::getProjects)
                .flatMap(List::stream).distinct()
                .map(Project::getName)
//                .sorted().toList();
                .sorted(Comparator.reverseOrder()).toList();
//        System.out.println("strings = " + strings);

        //Print full name of any employee whose firstName starts with ‘A’.
        List<String> a = employeeList.stream().filter(employee -> employee.getFirstName().startsWith("A"))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName()).toList();
//        System.out.println("a = " + a);

        //3.List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
        List<Employee> employees = employeeList.stream().filter(employee -> employee.getId().startsWith("2023")).toList();
//        System.out.println("employees = " + employees);

        //4.Sort employees based on firstName, for same firstName sort by salary.
        List<Employee> employees1 = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary)).toList();
//        System.out.println("employees1 = " + employees1);

/*
        //Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
        employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream().sorted((o1, o2) -> o2.getKey().compareTo(o1.getKey()))
//                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)) // descending
                .skip(2).findFirst().get().getValue().stream().map(Employee::getFirstName).forEach(System.out::print);
*/
        //Print min salary.
        int asInt = employeeList.stream().mapToInt(Employee::getSalary).min().getAsInt();
//        System.out.println("asInt = " + asInt);


        //Print list of all employee with min salary.
        List<String> strings1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet().stream().min(Comparator.comparing(Map.Entry::getKey))
                .get().getValue().stream().map(Employee::getFirstName).toList();
//        System.out.println("strings1 = " + strings1);

        //List of people working on more than 2 projects.
        List<Employee> employees2 = employeeList.stream().filter(employee -> employee.getProjects().size() > 2).toList();
//        System.out.println("employees2 = " + employees2);

        //Count of total laptops assigned to the employees.
        Integer integer = employeeList.stream().map(Employee::getTotalLaptopsAssigned).reduce(Integer::sum).get();
//        System.out.println("integer = " + integer);

        //Count of all projects with Robert Downey Jr as PM.
        long robert_downey_jr = employeeList.stream()
                .map(Employee::getProjects)
                .flatMap(List::stream).distinct()
                .filter(project -> project.getProjectManager().equals("Robert Downey Jr"))
                .count();
//        System.out.println("robert_downey_jr = " + robert_downey_jr);


        //List of all people working with Robert Downey Jr.
        long robert_downey_jr1 = employeeList.stream().filter(employee -> employee.getProjects().stream()
                .anyMatch(project -> project.getProjectManager().equals("Robert Downey Jr1"))
        ).count();
//        System.out.println("robert_downey_jr1 = " + robert_downey_jr1);


        //Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year. (Hint : Collectors.toMap)
        Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getId().substring(0, 4)));
//        System.out.println("collect = " + collect);


        //Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year. (Hint : Collectors.groupingBy())
        Map<String, Long> collect1 = employeeList.stream().collect(Collectors.groupingBy(employee -> employee.getId().substring(0, 4), Collectors.counting()));
        System.out.println("collect1 = " + collect1);

    }
}

