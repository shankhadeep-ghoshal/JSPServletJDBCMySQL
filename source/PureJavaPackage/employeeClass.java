package PureJavaPackage;

/**
 * Created by Echo01 on 4/2/2017.
 */
public class employeeClass implements java.io.Serializable {
    private int id;
    private String name;
    private String job;
    private int subjectid;
    private int salary;

    public employeeClass() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectId) {
        this.subjectid = subjectId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name=" + name +
                ", job=" + job +
                ", subjectid=" + subjectid +
                ", salary=" + salary;
    }
}
