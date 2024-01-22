package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/22/2024
 * @project algorithms_practice
 * &
 */
public class StreamWorker {


    public static void main(String[] args) {
        List<Car> carsList = Arrays.asList(new Car("Black", 30), new Car("Black", 90), new Car("Black", 50), new Car("white", 20), new Car("Yellow", 60));

        List<Employee> employeesList = Arrays.asList(new Employee("Mehrad1", true, 999L), new Employee("Mehrad2", true, 1000L), new Employee("Mehrad3", true, 1001L), new Employee("Mehrad4", false, 998L), new Employee("Mehrad5", true, 1002L), new Employee("Mehrad6", true, 997L));


//        employeesList.stream().
//                filter(Employee::getMarried).
//                filter(x -> x.getSalary() < 1000).
//                sorted((x, y) -> x.getSalary().compareTo(y.getSalary())).
////                sorted((x, y) -> (int) (x.getSalary()-y.getSalary())).
//                limit(10).
//                forEach(x -> System.out.println("x = " + x.getName()));

//        Car[] myArray =
//        String[] myArray =
        Optional<Integer> optionalSum =

                carsList.stream().filter(x -> x.getColor().equals("Black")).
//                sorted((x,y)->(x.getPrice()-y.getPrice())).
//        sorted(Comparator.comparingInt(Car::getPrice)).
                        map(Car::getPrice).
                        sorted().
                        limit(2).
                        reduce(Integer::sum);
        optionalSum.ifPresent(System.out::println);

        Integer sum = optionalSum.orElseGet(() -> 0);
        System.out.println("sum = " + sum);

        //                parallel().
//        limit(3).


//                        map(Car::getColor).
//                        toArray(String[]::new);
//        for (String str : myArray) {
//            System.out.println("str = " + str);
//        }


//                toArray(size -> new Car[4]);
//        for (Car car : myArray) {
//            System.out.println("car = " + car);
//        }

//        collect(Collectors.toMap(car -> car.getPrice(), car -> car.getColor())).
//                forEach((key, value) -> System.out.println("Key : " + key + " & Value : " + value));

//                collect(Collectors.toList()).forEach(x-> System.out.println("x = " + x));

//                forEach(x -> System.out.println("x = " + x));


        IntStream.range(2,100).
        filter(
                a ->
                        IntStream.range(2,a-1).noneMatch(x-> a % x == 0)
        ).forEach(System.out::println);

    }
}
