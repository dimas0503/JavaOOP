package Tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 05.10.2015.
 */
public class ForEachMain {
    public static void main(String[] args) {
        Company company = new Company();
        company.addEmployee(new Employee("Jon",100));
        company.addEmployee(new Employee("Ben",200));

        for (Employee emp : company){
            System.out.println(emp.getName());
        }
    }

}
