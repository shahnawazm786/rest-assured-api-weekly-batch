package pojo;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        List<Employees> emp=new ArrayList<>();
        emp.add(new Employees(1000,"Clark",8900));
        emp.add(new Employees(1001,"King",9000));
        for(Employees e:emp){
            System.out.println(e.getEmpno());
            System.out.println(e.getEmpname());
            System.out.println(e.getSal());
        }
    }
}
