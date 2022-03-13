package data;

import config.db_connection;
import entities.ListPatient;
import entities.TypeTest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author LilJade
 */
public class D_ListPatient {

    db_connection db = new db_connection();

    public ArrayList<ListPatient> listPatients() {
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
                listPatient.setState(rs.getInt("state"));
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
            ps = con.prepareStatement("insert into listPatient(position, namePatient, descriptionDate, idTypeTest, state) values(?, ?, ?, ?, ?)");

            ps.setInt(1, listPatient.getPosition());
            ps.setString(2, listPatient.getNamePatient());
            ps.setString(3, listPatient.getDescriptionDate());
            ps.setInt(4, listPatient.getIdTypeTest().getId());
            ps.setInt(5, listPatient.getState());

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
            ps = con.prepareStatement("update listPatient set position=?, namePatient=?, descriptionDate=?, idTypeTest=? where id=?");

            ps.setInt(1, listPatient.getPosition());
            ps.setString(2, listPatient.getNamePatient());
            ps.setString(3, listPatient.getDescriptionDate());
            ps.setInt(4, listPatient.getIdTypeTest().getId());
            ps.setInt(5, listPatient.getId());

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

    public Timestamp lastDate() {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;

        Timestamp lastDate = null;

        try {
            ps = con.prepareStatement("select datefield from listPatient order by datefield desc limit 1");
            rs = ps.executeQuery();

            if (rs.next()) {
                lastDate = rs.getTimestamp("datefield");
            } else {
                return null;
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error trying to consult last date of patients: " + e.getMessage());
        }

        return lastDate;
    }

    public int lastPosition() {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;

        int lastPosition = 0;

        try {
            ps = con.prepareStatement("select position from listPatient order by position desc limit 1");
            rs = ps.executeQuery();

            if (rs.next()) {
                lastPosition = rs.getInt("position");
            } else {
                return 0;
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error trying to consult last position of patients: " + e.getMessage());
        }

        return lastPosition;
    }

    public ArrayList<ListPatient> listPatientsToDoc() {
        Connection con = db.connectDB();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<ListPatient> list = new ArrayList();
        ListPatient listPatient;

        try {
            ps = con.prepareStatement("select * from listPatient where state != 0");
            rs = ps.executeQuery();

            while (rs.next()) {
                listPatient = new ListPatient();
                listPatient.setId(rs.getInt("id"));
                listPatient.setState(rs.getInt("state"));
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

    public boolean docUpdateListPatient(ListPatient listPatientC, ListPatient listPatientN) {
        Connection con = db.connectDB();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("update listPatient set state=0 where id=?");
            ps.setInt(1, listPatientC.getId());
            ps.executeUpdate();

            ps = con.prepareStatement("update listPatient set state=1 where id=?");
            ps.setInt(1, listPatientN.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error trying to update listPatient: " + e.getMessage());
        }

        return true;
    }
}
