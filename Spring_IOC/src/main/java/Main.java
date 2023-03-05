import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Spring Core");
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        Student student = (Student) applicationContext.getBean("student");

        System.out.println(student);

        Employee employee = (Employee) applicationContext.getBean("employee");

        System.out.println(employee);
        applicationContext.registerShutdownHook();
    }
}
