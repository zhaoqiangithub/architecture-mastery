public class Employee {
    private String name;
    private Integer age;
    private Department department;
    public Employee(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void sayJoke(String content){
        System.out.println(this.getName() + "说" + content);
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("老齐");
        emp.setAge(13);
        Department department = new Department();
        department.setDname("小卖部");
        emp.setDepartment(department);
        emp.sayJoke("一言不合就开车");
    }
}

class Department{
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
