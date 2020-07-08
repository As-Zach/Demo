import java.sql.*;

public class test_MySQL {
    private static Connection dbConn = null;

    public static void main(String[] args) {

        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载驱动成功！");
            //2.连接
            String dbURL = "jdbc:mysql://localhost:3306/yggl?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            dbConn = DriverManager.getConnection(dbURL, "root", "mysql");
            System.out.println("连接数据库成功！");
            //3.查询语句
            String sql="select * from Employees";
            Statement statement=dbConn.createStatement();
            ResultSet res=statement.executeQuery(sql);
            while(res.next()){
                String title=res.getString("EmployeeID");
                System.out.println(title);
            }
            res.close();
            dbConn.close();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("连接数据库失败！");
        }

    }
}