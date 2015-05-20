/**
 * 
 */
package mytest.api;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Data record
 * @author mikulsky
 */
public class Record {
    /** Records's Gender type */
    public enum GENDER {
        FEMALE, MALE
    };

    private String lastName;
    private String firstName;
    private GENDER gender;
    private String favoriteColor;
    private Date dateOfBirth;

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.lastName + ",\t " + this.firstName + ",\t " + this.gender + ",\t " + this.favoriteColor + ",\t "
                + (this.dateOfBirth == null ? "null" : new SimpleDateFormat("MM/dd/yyyy").format(this.dateOfBirth));
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Record))
            return false;
        Record record = (Record) obj;
        if (this.lastName == null && record.lastName != null || this.lastName != null && !this.lastName.equals((record.lastName)))
            return false;
        if (this.firstName == null && record.firstName != null || this.firstName != null && !this.firstName.equals((record.firstName)))
            return false;
        if (this.gender == null && record.gender != null || this.gender != null && !this.gender.equals((record.gender)))
            return false;
        if (this.favoriteColor == null && record.favoriteColor != null || this.favoriteColor != null && !this.favoriteColor.equals((record.favoriteColor)))
            return false;
        if (this.dateOfBirth == null && record.dateOfBirth != null || this.dateOfBirth != null && !this.dateOfBirth.equals((record.dateOfBirth)))
            return false;
        return true;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the gender
     */
    public GENDER getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(GENDER gender) {
        this.gender = gender;
    }

    /**
     * @return the favoriteColor
     */
    public String getFavoriteColor() {
        return favoriteColor;
    }

    /**
     * @param favoriteColor the favoriteColor to set
     */
    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
