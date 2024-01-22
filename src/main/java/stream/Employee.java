package stream;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 1/22/2024
 * @project algorithms_practice
 * &
 */
public class Employee {

 String name;
 Boolean isMarried;
 Long salary;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Employee(String name, Boolean isMarried, Long salary) {
  this.isMarried = isMarried;
  this.salary = salary;
  this.name=name;
 }

 public Boolean getMarried() {
  return isMarried;
 }

 public void setMarried(Boolean married) {
  isMarried = married;
 }

 public Long getSalary() {
  return salary;
 }

 public void setSalary(Long salary) {
  this.salary = salary;
 }

 @Override
 public String toString() {
  return "Employee{" +
          "isMarried=" + isMarried +
          ", salary=" + salary +
          '}';
 }
}
