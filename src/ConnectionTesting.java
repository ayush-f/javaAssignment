import org.junit.jupiter.api.Test;

import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectionTesting

{


    @Test
    void test() {
        DatabaseConnection db=new DatabaseConnection();
        Statement AO=db.connection();
        assertEquals(null,AO);

    }

}

