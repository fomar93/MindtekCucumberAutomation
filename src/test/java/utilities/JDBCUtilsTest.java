package utilities;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCUtilsTest {
    public static void main(String[] args) throws SQLException {


        JDBCUtils.establishConnection();
        JDBCUtils.runQuery("Select * From employees");
        List<Map<String, Object>> data=  JDBCUtils.runQuery("Select * From employees");
        System.out.println(data.get(0));

        JDBCUtils.closeDatabase();
    }
}