package entities;

/**
 *
 * @author LilJade
 */
public class Users {
    private int id, rol;
    private String nameUser, email, pass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    public Users() { }
    
    public Users(int rol, String nameUser, String email, String pass) {
        this.rol = rol;
        this.nameUser = nameUser;
        this.email = email;
        this.pass = pass;
    }

    public Users(int id, int rol, String nameUser, String email, String pass) {
        this.id = id;
        this.rol = rol;
        this.nameUser = nameUser;
        this.email = email;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", rol=" + rol + ", nameUser=" + nameUser + ", email=" + email + ", pass=" + pass + '}';
    }

}
