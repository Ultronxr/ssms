import utils.MysqlUtils;

import java.sql.Connection;

public class JDBCTest {

    public static void main(String[] args){

        Connection connection = MysqlUtils.getConnection();
        UserDao userdao=new UserDao();
        userdao.LoginStatus("123","123");
        MysqlUtils.closeConnection(null, null, connection);
    }

}
