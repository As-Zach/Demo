import java.sql.*;

public class test_SqlServer {
    private static Connection dbConn = null;

    public static void main(String[] args) {

        try {
            //1.��������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("���������ɹ���");
            //2.�������ݿ�
            String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=ssgl";
            dbConn = DriverManager.getConnection(dbURL, "sa", "sa");
            System.out.println("�������ݿ�ɹ���");
            //3.�������ݿ�
            String sql="select * from stay_info where Dorm_num=105";
            Statement statement=dbConn.createStatement();
            ResultSet res=statement.executeQuery(sql);
            while(res.next()){
                String title=res.getString("Stu_num");
                System.out.println(title);
            }
            res.close();
            dbConn.close();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("�������ݿ�ʧ�ܣ�");
        }

    }
}