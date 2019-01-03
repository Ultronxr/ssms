package dao.impl;

import dao.AdminDao;
import utils.MysqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    @Override
    public boolean getLoginStatus(String account, String password){

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
            //e.printStackTrace();
            System.out.println("[x] src.main.java.dao.impl-AdminDaoImpl 查询管理员账户时，连接数据库出错！");
        } finally{
            MysqlUtils.closeConnection(rs, ps, con);
        }
        return flag;
    }

}
