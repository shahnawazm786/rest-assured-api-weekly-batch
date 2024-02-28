import org.testng.annotations.Test;

public class TestNGPriorityCheck {
    @Test(priority = 0)
    public void Login(){
        System.out.println("Login");
    }
    @Test(priority = 1)
    public void Login1(){
        System.out.println("Login -1");
    }
    @Test(priority = -1)
    public void Login2(){
        System.out.println("Login 2");
    }



    @Test
    public void Search(){
        System.out.println("Search");
    }
    @Test(priority = 2)
    public void Dashboard(){
        System.out.println("Dashboard");
    }
}
