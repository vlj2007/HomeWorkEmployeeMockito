package pro.sky.HomeWorkEmployeeMockito.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.sky.HomeWorkEmployeeMockito.model.Employee;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        List<Employee> employeesList = List.of(
                new Employee("Влад", "Волков", 4, 17.000),
                new Employee("Артем", "Верблюдов", 5, 91.000),
                new Employee("Людмила", "Иванова", 6, 1.000),
                new Employee("Игорь", "Криштоп", 1, 9.000),
                new Employee("Павел", "Носков", 2, 44.000),
                new Employee("Иван", "Могиш", 5, 41.000),
                new Employee("Роберт", "Блинов", 3, 24.000),
                new Employee("Сергей", "Арбузов", 2, 67.000),
                new Employee("Павел", "Аленчев", 1, 14.000)
        );
    }
}
