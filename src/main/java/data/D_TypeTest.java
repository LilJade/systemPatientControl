package data;

import config.db_connection;
import entities.TypeTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author LilJade
 */
public class D_TypeTest {
    
    db_connection db = new db_connection();
    
    public ArrayList<TypeTest> listTests() {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TypeTest> list = new ArrayList();
        TypeTest test;
        
        try {
            ps = con.prepareStatement("select * from typeTest");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                test = new TypeTest();
                test.setId(rs.getInt("id"));
                test.setTypeTest(rs.getString("typeTest"));
                test.setState(rs.getInt("state"));
                
                list.add(test);
            }
            
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error trying to consult list of tests: " + e.getMessage());
        }
        
        return list;
    }
    
    public boolean insertTypeTest(TypeTest typeTest) {
        Connection con = db.connectDB();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("insert into typeTest(typeTest, state) values(?, 0)");
            
            ps.setString(1, typeTest.getTypeTest());
            
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error trying to add new typeTest: " + e.getMessage());
        }
        
        return true;
    }
    
    public boolean updateTypeTest(TypeTest typeTest) {
        Connection con = db.connectDB();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("update typeTest set typeTest=?, state=? where id=?");
            
            ps.setString(1, typeTest.getTypeTest());
            ps.setInt(2, typeTest.getState());
            ps.setInt(5, typeTest.getId());
            
            ps.executeUpdate();     
            
        } catch (SQLException e) {
            System.out.println("Error trying to update typeTest: " + e.getMessage());
        }
        
        return true;
    }
    
    public boolean deleteTypeTest(TypeTest typeTest) {
        Connection con = db.connectDB();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("delete from TypeTest where id=?");
                
            ps.setInt(1, typeTest.getId());
                
            int rowsDeleted = ps.executeUpdate();
                
            if (rowsDeleted > 0) {
                return true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error trying to delete typeTest: " + e.getMessage());
        }
        
        return false;
    }
}
