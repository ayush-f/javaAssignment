import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class LoginTesting {


    @Test
    void test() {



        Login ltest =new Login();
        int result=ltest.userLogin("","");
        assertEquals(1,result);
    }
}
