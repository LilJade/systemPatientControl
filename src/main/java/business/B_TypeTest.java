package business;

import data.D_TypeTest;
import entities.TypeTest;
import java.util.ArrayList;

/**
 *
 * @author LilJade
 */
public class B_TypeTest {

    D_TypeTest data = new D_TypeTest();
    
    public ArrayList B_listTests() {
        ArrayList list = data.listTests();
        
        if (list == null) {
            System.out.println("Error al cargar la lista de usuarios!");
            return null;
        }
        
        return list;
    }
    
    public boolean B_insertUser(TypeTest typeTest) {
        return data.insertTypeTest(typeTest);
    }
    
    public boolean B_updateUser(TypeTest typeTest) {
        return data.updateTypeTest(typeTest);
    }
    
    public boolean B_deleteUser(TypeTest typeTest) {
        return data.deleteTypeTest(typeTest);
    }
}
