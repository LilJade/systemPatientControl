package business;

import data.D_ListPatient;
import entities.ListPatient;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author LilJade
 */
public class B_ListPatient {
    D_ListPatient data = new D_ListPatient();
    
    public ArrayList B_listPatients() {
        ArrayList list = data.listPatients();
        
        if (list == null) {
            System.out.println("Error al cargar la lista de pacientes!");
            return null;
        }
        
        return list;
    }
    
    public boolean B_insertPatient(ListPatient listPatient) {
        return data.insertListPatient(listPatient);
    }
    
    public boolean B_updatePatient(ListPatient listPatient) {
        return data.updateListPatient(listPatient);
    }
    
    public boolean B_deletePatient(ListPatient listPatient) {
        return data.deleteListPatient(listPatient);
    }
    
    public Timestamp B_lastDate() {
        return data.lastDate();
    }
    
    public int B_lastPosition() {
        return data.lastPosition();
    }
}
