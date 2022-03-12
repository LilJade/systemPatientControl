package data;

import config.db_connection;
import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LilJade
 */
public class D_Users {
    db_connection db = new db_connection();
    
    public Users loginUser(Users user) {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement("select * from users where email = ? and pass = ?");
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPass());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setNameUser(rs.getString(2));
                user.setRol(rs.getInt(5));
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error trying login user: " + e.getMessage());
        }
        
        return user;
    }
    
    public ArrayList<Users> listUsers() {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Users> list = new ArrayList();
        Users user;
        
        try {
            ps = con.prepareStatement("select * from users");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                user = new Users();
                user.setId(Integer.parseInt(rs.getString("id")));
                user.setNameUser(rs.getString("nameUser"));
                user.setEmail(rs.getString("email"));
                user.setPass(rs.getString("pass"));
                user.setRol(rs.getInt("rol"));
                
                list.add(user);
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar la lista de usuarios: " + e.getMessage());
        }
        
        return list;
    }
    
    public boolean insertUser(Users user) {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement("insert into users(nameUser, email, pass, rol) values(?, ?, ?, ?)");
            
            ps.setString(1, user.getNameUser());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPass());
            ps.setInt(4, user.getRol());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error trying to add new user: " + e.getMessage());
        }
        
        return true;
    }
    
    public boolean updateUser(Users user) {
        Connection con = db.connectDB();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("update users set nameUser=?, email=?, pass=?, rol=? where id=?");
            
            ps.setString(1, user.getNameUser());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPass());
            ps.setInt(4, user.getRol());
            ps.setInt(5, user.getId());
            
            ps.executeUpdate();     
            
        } catch (SQLException e) {
            System.out.println("Error trying to update user: " + e.getMessage());
        }
        
        return true;
    }
    
    public boolean deleteUser(Users user) {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps = con.prepareStatement("delete from users where id=?");
                
            ps.setInt(1, user.getId());
                
            int rowsDeleted = ps.executeUpdate();
                
            if (rowsDeleted > 0) {
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error trying to delete user: " + e.getMessage());
        }
        
        return false;
    }

}
