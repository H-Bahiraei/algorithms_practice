package stream;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/15/2024
 * @project algorithms_practice
 * &
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeFactory extends Employee{

 ArrayList<Employee> employees = new ArrayList<>();

 public List<Employee> getAllEmployee(){

  Project Delta = new Project("Delta Model", "Login", "Robert Downey Jr1");
  Project Beta = new Project("Beta Enhancement", "Authentication", "Robert Downey Jr");
  Project TwoFactorAuth = new Project("Two Factor Authentication", "Authentication", "MSD");
  Project CommonUI = new Project("Common UI", "UI", "Robert Downey Jr");
  Project Pegasus = new Project("Pegasus Model", "Data", "Vikram");
  Project CustomerOnboarding = new Project("Customer Onboarding", "Ads", "Vedha");
  Project Verification = new Project("Source Verification", "Data", "Pablo");
  Project RemoveUsers = new Project("Remove Invalid User", "Proxy", "Jeetu");
  Project SiteReliability = new Project("Site Reliability", "Admin", "Zaheer Khan");
  Project DataTransition = new Project("Data Transition", "Data", "Atif Aslam");
  Project TwoPhaseDeployment =new Project("Two Phase Deployment", "Deployment", "Shaktiman");

  employees.add(new Employee("2020Emp0234", "ABhaskar", "Sharan", 1, 1, Arrays.asList(Delta, Beta)));
  employees.add(new Employee("2012Emp1923", "Dev", "Sharma", 1, 3, Arrays.asList(Pegasus, CustomerOnboarding, Beta, SiteReliability)));
  employees.add(new Employee("2017Emp0721", "Priti", "Kabir", 3, 3, Arrays.asList(TwoFactorAuth, Beta, CommonUI)));
  employees.add(new Employee("2017Emp00031", "Chris", "Martin", 3, 2, Arrays.asList(Delta, TwoFactorAuth)));
  employees.add(new Employee("2013Emp0872", "Sanjay", "Singhania", 4, 3, Arrays.asList(Pegasus, Delta, RemoveUsers, DataTransition)));
  employees.add(new Employee("2022Emp0087", "Babu", "Rao", 6, 1, Arrays.asList(TwoFactorAuth)));
  employees.add(new Employee("2019Emp0050", "Dev", "Anand", 7, 1, Arrays.asList(RemoveUsers, CommonUI)));
  employees.add(new Employee("2023Emp0934", "Shruti", "Sen", 7, 1, Arrays.asList(Pegasus)));
  employees.add(new Employee("2023Emp1033", "Akshay", "Kumar", 8, 0, Arrays.asList(Delta)));
  employees.add(new Employee("2015Emp0009", "Babu", "Dutt", 9, 2, Arrays.asList(Verification, RemoveUsers, TwoPhaseDeployment)));

  return employees;
 }
}
