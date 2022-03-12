package data;

import config.db_connection;
import entities.ListPatient;
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
public class D_ListPatient {

    db_connection db = new db_connection();

    public ArrayList<ListPatient> listTests() {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<ListPatient> list = new ArrayList();
        ListPatient listPatient;

        try {
            ps = con.prepareStatement("select * from listPatient");
            rs = ps.executeQuery();

            while (rs.next()) {
                listPatient = new ListPatient();
                listPatient.setId(rs.getInt("id"));
                listPatient.setDatefield(rs.getTimestamp("datefield"));
                listPatient.setPosition(rs.getInt("position"));
                listPatient.setNamePatient(rs.getString("namePatient"));
                listPatient.setDescriptionDate(rs.getString("descriptionDate"));
                TypeTest typeTest = new TypeTest();
                typeTest.setId(rs.getInt("idTypeTest"));
                listPatient.setIdTypeTest(typeTest);

                list.add(listPatient);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error trying to consult list of patients: " + e.getMessage());
        }

        return list;
    }

    public boolean insertListPatient(ListPatient listPatient) {
        Connection con = db.connectDB();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("insert into listPatient(datefield, position, namePatient, descriptionDate, idTypeTest) values(?, ?, ?, ?, ?)");

            ps.setTimestamp(1, listPatient.getDatefield());
            ps.setInt(2, listPatient.getPosition());
            ps.setString(3, listPatient.getNamePatient());
            ps.setString(4, listPatient.getDescriptionDate());
            ps.setInt(5, listPatient.getIdTypeTest().getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error trying to add new listPatient: " + e.getMessage());
        }

        return true;
    }

    public boolean updateListPatient(ListPatient listPatient) {
        Connection con = db.connectDB();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("update listPatient set datefield=?, position=?, namePatient=?, descriptionDate=?, idTypeTest=? where id=?");

            ps.setTimestamp(1, listPatient.getDatefield());
            ps.setInt(2, listPatient.getPosition());
            ps.setString(3, listPatient.getNamePatient());
            ps.setString(4, listPatient.getDescriptionDate());
            ps.setInt(5, listPatient.getIdTypeTest().getId());
            ps.setInt(6, listPatient.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error trying to update listPatient: " + e.getMessage());
        }

        return true;
    }

    public boolean deleteListPatient(ListPatient listPatient) {
        Connection con = db.connectDB();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("delete from listPatient where id=?");

            ps.setInt(1, listPatient.getId());

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error trying to delete listPatient: " + e.getMessage());
        }

        return false;
    }
}
