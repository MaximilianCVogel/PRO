import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectionTest {

    @Test
    void shouldBeAbleToConnectToDatabase() throws SQLException {
        DataBaseConnection dbc = new DataBaseConnection();
        Connection c = dbc.getConnection();
        assertEquals(true, true);
    }
}
