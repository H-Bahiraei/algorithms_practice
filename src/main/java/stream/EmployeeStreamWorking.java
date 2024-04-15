package stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/15/2024
 * @project algorithms_practice
 * &
 */
public class EmployeeStreamWorking {
    static List<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
// https://medium.com/@bhaskarsharan/practice-java-streams-questions-8a76cbfee1be

        EmployeeFactory employeeFactory = new EmployeeFactory();
        employeeList = employeeFactory.getAllEmployee();

    }
}

