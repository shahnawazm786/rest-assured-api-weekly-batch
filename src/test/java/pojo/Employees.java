package pojo;

public class Employees {
    private long empno;
    private String empname;
    private  double sal;
    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
public Employees(long empno,String empname,double sal){
        this.empno=empno;
        this.empname=empname;
        this.sal=sal;
}
}
