package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC {
    public static void main(String[] args) throws SQLException {

        String URL = "jdbc:postgresql://localhost/HR";
        String username ="postgres";
        String password = "Admin";
        String query = "SELECT * FROM employees LIMIT 5";

        Connection connection;
        Statement statement;//
        ResultSet resultset;
        ResultSetMetaData resultSetMetaData;


        connection = DriverManager.getConnection(URL, username, password);

        statement = connection.createStatement();

        resultset = statement.executeQuery(query);

        resultset.next();// it starts from index 1
        System.out.println(resultset.getString(3));
        System.out.println(resultset.getString("salary"));

        resultset.next();// switches to the next row

        System.out.println(resultset.getString(3));
        System.out.println(resultset.getString("salary"));

        while(resultset.next()){
            System.out.print(resultset.getString(1)+" ");
            System.out.print(resultset.getString(2)+" ");
            System.out.print(resultset.getString(3)+" ");
            System.out.print(resultset.getString("salary")+" ");
            System.out.print(resultset.getString("Manager_id")+" ");
            System.out.println("  ");
        }

        resultSetMetaData = resultset.getMetaData();// information about data
        System.out.println(resultSetMetaData.getColumnName(1));
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getTableName(1));

        ResultSet resultset2 = statement.executeQuery(query);

        List<Map<String, Object >> data = new ArrayList<>();

        while (resultset2.next()){
            Map<String, Object> row = new HashMap<>();

            for ( int i=1; i<= resultSetMetaData.getColumnCount(); i++){
                row.put(resultSetMetaData.getColumnName(i), resultset2.getString(i));


            }

            data.add(row);


        }

        System.out.println(data);
        System.out.println(data.get(0));
        System.out.println(data.get(0).get("email"));


        System.out.println(data.get(1).get("employee_id"));

        System.out.println(resultset2.first());

        connection.close();









    }
}
