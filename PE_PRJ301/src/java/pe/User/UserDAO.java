/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pe.utils.DBUtils;

/**
 *
 * @author bacda
 */
public class UserDAO {
    public UserDTO login(String username, String password){
        UserDTO user = null;
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        try {
            conn = new DBUtils().getConnection(); 
            
            String sql = "SELECT username, name FROM users WHERE username = ? AND password = ?";
            
            ps = conn.prepareStatement(sql); 
            ps.setString(1, username);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            if (rs != null){
                    if (rs.next()){
                        
                        user = new UserDTO();                        
                        user.setUsername(rs.getString("username"));
                        user.setName(rs.getString("name"));
                    }
                }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error!" + e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
}
