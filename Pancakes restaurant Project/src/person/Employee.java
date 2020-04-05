package person;

public class Employee extends Person {
    private String jobName;

    public Employee() {
        super();
    }

    public Employee(String name, int age, String jobName) {
        super(name, age);
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "Employee " + " name=" + super.getName() + ", age=" + super.getAge() +
                ", jobName=" + jobName;
    }
}
