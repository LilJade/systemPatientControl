package entities;

/**
 *
 * @author LilJade
 */
public class TypeTest {
    private int id, state;
    private String typeTest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTypeTest() {
        return typeTest;
    }

    public void setTypeTest(String typeTest) {
        this.typeTest = typeTest;
    }
    
    public TypeTest() { }
    
    public TypeTest(int state, String typeTest) {
        this.state = state;
        this.typeTest = typeTest;
    }
    
    public TypeTest(int id, int state, String typeTest) {
        this.id = id;
        this.state = state;
        this.typeTest = typeTest;
    }
    
}
