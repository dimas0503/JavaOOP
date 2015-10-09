package Tests;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Dima on 05.10.2015.
 */
public class Company implements Iterable<Employee> {

    Employee employee;
    Employee lastEmployee;

    @Override
    public Iterator<Employee> iterator() {
        return new Itr(employee);
    }

    private class Itr implements Iterator<Employee>{
        Employee currPos;

        public Itr(){}

        public Itr(Employee employee){
            this.currPos = employee;
        }

        @Override
        public boolean hasNext() {
            return currPos != null;
        }

        @Override
        public Employee next() {
            Employee res = currPos;
            currPos = currPos.getNext();
            return res;
        }
    }

    public void addEmployee(Employee employee){
        if (this.lastEmployee == null){
            this.lastEmployee = this.employee = employee;
        }else {
            lastEmployee.setNext(employee);
            lastEmployee = employee;
        }
    }

/*
    @Override
    public boolean hasNext() {
        return employee.getNext() != null;
    }

    @Override
    public Employee next() {
        return employee.getNext();
    }
*/
}
