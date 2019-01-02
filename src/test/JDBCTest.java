import utils.MysqlUtils;

import java.sql.Connection;

public class JDBCTest {
    /***
     * 阿里云防火墙设置3306开放
     * /etc/mysql/mysql.conf.d/mysqld.cnf注释bind-host一行
     * https://blog.csdn.net/qq_39781497/article/details/81302950
     */

    public static void main(String[] args){

        Connection connection = MysqlUtils.getConnection();
        UserDao userdao=new UserDao();
        userdao.LoginStatus("123","123");
        MysqlUtils.closeConnection(null, null, connection);
    }

}
