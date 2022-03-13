package entities;

import java.sql.Timestamp;

/**
 *
 * @author LilJade
 */
public class ListPatient {
    private int id, position, state;
    private Timestamp datefield;
    private String namePatient, descriptionDate;
    private TypeTest idTypeTest;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getDatefield() {
        return datefield;
    }

    public void setDatefield(Timestamp datefield) {
        this.datefield = datefield;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getDescriptionDate() {
        return descriptionDate;
    }

    public void setDescriptionDate(String descriptionDate) {
        this.descriptionDate = descriptionDate;
    }

    public TypeTest getIdTypeTest() {
        return idTypeTest;
    }

    public void setIdTypeTest(TypeTest idTypeTest) {
        this.idTypeTest = idTypeTest;
    }

    public ListPatient() { }
    
    public ListPatient(int id, int position, int state, Timestamp datefield, String namePatient, String descriptionDate, TypeTest idTypeTest) {
        this.id = id;
        this.position = position;
        this.state = state;
        this.datefield = datefield;
        this.namePatient = namePatient;
        this.descriptionDate = descriptionDate;
        this.idTypeTest = idTypeTest;
    }

}
