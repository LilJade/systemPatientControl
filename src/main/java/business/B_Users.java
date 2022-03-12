package business;

import data.D_Users;
import entities.Users;
import java.util.ArrayList;

/**
 *
 * @author LilJade
 */
public class B_Users {
    
    D_Users data = new D_Users();
    
    public Users B_loginUser(Users user) {
        user = data.loginUser(user);
        
        if (user == null) {
            return null;
        }
        return user;
    }
    
    public ArrayList B_listUsers() {
        ArrayList list = data.listUsers();
        
        if (list == null) {
            System.out.println("Error al cargar la lista de usuarios!");
            return null;
        }
        
        return list;
    }
    
    public boolean B_insertUser(Users user) {
        return data.insertUser(user);
    }
    
    public boolean B_updateUser(Users user) {
        return data.updateUser(user);
    }
    
    public boolean B_deleteUser(Users user) {
        return data.deleteUser(user);
    }
    
}
