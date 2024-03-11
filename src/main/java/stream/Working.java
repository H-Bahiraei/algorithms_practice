package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/8/2024
 * @project demo1
 * &
 */
public class Working {

    public static void main(String[] args) {


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

        String str = new String();
        List<String> resultList = myList.stream().map(a -> a.getFirstName()).filter(a -> a.startsWith("A")).
                collect(Collectors.toList());
//        System.out.println("resultList = " + resultList);

        Map<String, List<Student>> mapData = myList.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
//        System.out.println("mapData = " + mapData);
//        System.out.println("Students grouped by the department names : "+mapData.keySet());
//        System.out.println("Students grouped by the department names : "+mapData.get("Electronics Engineering"));

        int maxAge = myList.stream().mapToInt(Student::getAge).max().getAsInt();
//        System.out.println("maxAge = " + maxAge);

        OptionalInt maxAge2 = myList.stream().mapToInt(dt -> dt.getAge()).max();
//        System.out.println("Max age of student : "+maxAge2.getAsInt());


        Set<String> depNamesList = myList.stream().map(Student::getDepartmantName).collect(Collectors.toSet());
//        System.out.println("depNamesList = " + depNamesList);

        Long aLong = myList.stream().
                collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .values().stream().max(Long::compare).get();
        String key = myList.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .entrySet().stream().max((entry1, entry2) -> (int) (entry1.getValue() - entry2.getValue())).get().getKey(); // todo share it
//        System.out.println("key = " + key);

        Set<Map.Entry<String, Long>> entries = myList.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                .entrySet();
//        System.out.println(entries);


//        System.out.println(aLong);

        List<Student> collect = myList.stream().filter(st -> st.getAge() < 30).sorted((a, b) -> b.getAge() - a.getAge()).toList();
//        System.out.println(collect);

//        List<Student> students = myList.stream().filter(st -> 50 < st.getRank() && st.getRank() < 100).toList();
        List<Integer> students = myList.stream().map(Student::getRank).filter(st -> 50 < st && st < 100).toList();
//        System.out.println("students = " + students);


        Map<String, Double> collect1 = myList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
//        System.out.println("collect1 = " + collect1);


        List<Student> delhi = myList.stream().filter(st -> st.getCity().equals("Delhi"))
//                .sorted((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName())).toList();
//                .sorted(Comparator.comparing(student -> student.getFirstName())).toList();
                .sorted(Comparator.comparing(Student::getFirstName)).toList();
//        System.out.println(delhi);


        OptionalDouble average = myList.stream().mapToInt(Student::getRank).average();
//        System.out.println("average = " + average.getAsDouble());

        Map<String, Double> collect2 = myList.stream()
                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank)));
//        System.out.println(collect2);


        Map<String, Optional<Student>> collect3 = myList.stream().collect(
                Collectors.groupingBy(Student::getDepartmantName, Collectors.maxBy(Comparator.comparingInt(Student::getRank))));
//        System.out.println(collect3);


        List<Student> students1 = myList.stream().sorted(Comparator.comparingInt(Student::getRank)).toList();
//        System.out.println( students1);


        Integer integer = myList.stream().
                sorted(Comparator.comparingInt(Student::getRank)).skip(1).findFirst().map(Student::getRank).get();
        System.out.println(integer);

        List<Integer> myList2 = Arrays.asList(1, 3, 5, 89, 4, 24, 9, 45, 4, 35, 97, 43, 12, 45, 85, 36, 22);

//        Integer sum = myList.stream().reduce((a, b) -> a + b).get();
//        System.out.println("sum = " + sum);

        Integer size = myList2.size();
        Double sum2 = Double.valueOf(myList2.stream().reduce((a, b) -> a + b).get());
        Double average22 = sum2 / size;
//        System.out.println("average = " + average22);


        double average2 = myList2.stream().mapToInt(e -> e + 2).average().getAsDouble(); // todo
//        System.out.println("average = " + average2);


        myList2.stream().map(a -> a * a).filter(a -> a > 100).mapToInt(a -> a).average().getAsDouble();


        Set<Integer> list2 = myList2.stream().filter(a -> a % 2 != 0).collect(Collectors.toSet());


        List<Integer> list1 = myList2.stream().filter(Working::isStartWith).collect(Collectors.toList());
//        System.out.println(list1);

    }

    static Boolean isStartWith(Integer num) {
        int l = String.valueOf(num).length();
        int pow = (int) Math.pow(10, l - 1);
        double integer = num / pow;
        return integer == 2;
    }

}
