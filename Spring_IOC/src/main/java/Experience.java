public class Experience {
    private String companyName;
    private String salary;

    public Experience(String companyName, String salary) {
        this.companyName = companyName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "companyName='" + companyName + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
