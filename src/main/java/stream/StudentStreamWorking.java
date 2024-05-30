package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/15/2024
 * @project algorithms_practice
 * &
 */
public class StudentStreamWorking {

    public static void main(String[] args) {
        // https://medium.com/illumination/java-8-stream-api-commonly-asked-interview-questions-2a57081044ef
        List<Student> myList = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        // 1- Find list of students whose first name starts with alphabet A

        List<Student> a = myList.stream().filter(student -> student.getFirstName().startsWith("A")).toList();
//        System.out.println("a = " + a);

        // 2- Group The Student By Department Names
        Map<String, List<Student>> collect = myList.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
//        System.out.println("collect = " + collect);

//        3- Find the total count of student using stream
        long count = myList.stream().count();
//        System.out.println("count = " + count);


//        4- Find the max age of student
        Integer integer = myList.stream().map(Student::getAge).max(Integer::compare).orElseGet(() -> 0);
        Integer integer2 = myList.stream().mapToInt(Student::getAge).max().orElseGet(() -> 0);
//        System.out.println("integer = " + integer);

//        5- Find all departments names
        List<String> strings = myList.stream().map(Student::getDepartmantName).toList();
//        System.out.println("strings = " + strings);

//        6- Find the count of student in each department
        Map<String, Long> collect1 = myList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
//        System.out.println("collect1 = " + collect1);

//        7- Find the list of students whose age is less than 30
        List<Student> students = myList.stream().filter(student -> student.getAge() < 30).toList();
//        System.out.println("students = " + students);

//        8- Find the list of students whose rank is in between 50 and 100
        List<Student> students1 = myList.stream().filter(student -> 50 < student.getRank() && student.getRank() < 100).toList();
//        System.out.println("students1 = " + students1);

//        9- Find the average age of male and female students
        Map<String, Double> collect2 = myList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
//        System.out.println("collect2 = " + collect2);


//        10- Find the department who is having maximum number of students
        String key = myList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
//              .entrySet().stream().max((o1, o2) -> Long.compare(o1.getValue(), o2.getValue())).get().getKey();
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
//        System.out.println("key = " + key);


//        11- Find the Students who stays in Delhi and sort them by their names
        List<Student> dehli = myList.stream().filter(student -> student.getCity().equals("Delhi"))
//              .sorted((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName())).toList();
                .sorted(Comparator.comparing(Student::getFirstName)).toList();
//        System.out.println("dehli = " + dehli);


//        12- Find the average rank in all departments
        Map<String, Double> collect3 = myList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
//        System.out.println("collect3 = " + collect3);


//        13- Find the highest rank in each department
        Map<String, Optional<Student>> collect4 = myList.stream()
                .collect(Collectors.groupingBy(
                        Student::getDepartmantName, Collectors.minBy(Comparator.comparing(Student::getRank))
                ));
//        System.out.println("collect4 = " + collect4);

//        14- Find the list of students and sort them by their rank
        List<Student> students2 = myList.stream().sorted(Comparator.comparing(Student::getRank)).toList();
//        System.out.println("students2 = " + students2);

//        15- Find the student who has second rank
        Student student = myList.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst().get();
//        System.out.println("student = " + student);



    }


}
