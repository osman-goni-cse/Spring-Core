import java.util.List;

public class Employee {
    private int employeeId;
    private String employeeName;
    private Address address;
    private List<Experience> experiences;

    public Employee(int employeeId, String employeeName, Address address, List<Experience> experiences) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.address = address;
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", address=" + address +
                ", experiences=" + experiences +
                '}';
    }

//    Spring Bean Lifecycle

    public void init() {
        System.out.println("init method called");
    }

    public void destroy() {
        System.out.println("destroy method called");
    }
}
