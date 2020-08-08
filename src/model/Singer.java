package model;

import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Singer
{
    //ATTRIBUTES
    private String fullName;
    private Date dateOfBirth;
    private Country nationality;

    //GETTERS AND SETTERS
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    //CONSTRUCTOR
    void Singer()
    {}

    void Singer (String fullName, Date dateOfBirth, Country nationality)
    {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

}
