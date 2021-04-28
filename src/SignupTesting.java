import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;
public class SignupTesting {
    @Test
    void test() {


        Reg ltest =new Reg();
        int result=ltest.userSignup("kamlesh", "kamlesh12", "a@gmail.com", "aaaa");
        assertEquals(1,result);
    }

}
