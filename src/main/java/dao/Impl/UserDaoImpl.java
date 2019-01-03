package dao.Impl;

import dao.UserDao;
import utils.MysqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public boolean LoginStatus(String account, String password){
        boolean flag = false;
        if(account == null) account="";
        if(password == null) password = "";
        String sql="SELECT * FROM Admin WHERE account=? and password=?";
        Connection con = MysqlUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(!rs.next()){
                flag = false;
            }
            else
                flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return flag;
    }

}
