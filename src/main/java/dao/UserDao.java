package dao;

import utils.MysqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public boolean LoginStatus(String account,String password){
        String sql="SELECT * FROM User WHERE account="+account +"and password="+password+";";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs==null){
                return false;
            }
            else
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return false;
    }
}
