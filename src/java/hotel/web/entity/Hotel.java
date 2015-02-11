package hotel.web.entity;

import java.util.Objects;

/**
 * Entity class. This class is a representation of the Hotel table. The class
 * name is similar to the table name and the class properties are similar to the
 * table columns. It is used to provide structured data to/from database
 * operation code.
 *
 * @author John
 */
public class Hotel {

    private Long hotelId;
    private String hotelName;
    private String streetAddress;
    private String city;
    private String state;
    private String postalCode;
    private String notes;

    public Hotel() {
    }

    public Hotel(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel(String hotelName, String streetAddress, String city,
            String state, String postalCode, String notes) {
        this.hotelName = hotelName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.notes = notes;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.hotelId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.hotelId, other.hotelId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotel{" + "hotelId=" + hotelId + ", hotelName=" + hotelName
                + ", streetAddress=" + streetAddress + ", city=" + city
                + ", state=" + state + ", postalCode=" + postalCode
                + ", notes=" + notes + '}';
    }

}
