package stream;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 4/15/2024
 * @project algorithms_practice
 * &
 */
public class Project {

 private String name;
 private String team;
 private String projectManager;

 Project(){
 }

 public Project(String name, String team, String projectManager) {
  this.name = name;
  this.team = team;
  this.projectManager = projectManager;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getTeam() {
  return team;
 }

 public void setTeam(String team) {
  this.team = team;
 }

 public String getProjectManager() {
  return projectManager;
 }

 public void setProjectManager(String projectManager) {
  this.projectManager = projectManager;
 }
}
