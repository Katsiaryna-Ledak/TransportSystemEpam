package test;

import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static com.company.Main.init;


public class DBTest {

    @Test
    public void createDBTest() throws ClassNotFoundException, SQLException, IOException {
        init();
    }

}
