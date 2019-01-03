import utils.MysqlUtils;

import java.sql.Connection;

public class JDBCTest {

    public static void main(String[] args){

        Connection connection = MysqlUtils.getConnection();
        MysqlUtils.closeConnection(null, null, connection);
    }

}
