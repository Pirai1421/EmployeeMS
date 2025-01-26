import java.util.*;
public class Addresse {
    public String StreetNumber;
    public String StreetName;
    public String City;
    public String State;
    public String Country;
    public Addresse(String streetNumber, String streetName, String city, String state, String country) {
        this.StreetNumber = streetNumber;
        this.StreetName = validateString(streetName, "Street Name");
        this.City = validateString(city, "City");
        this.State = validateString(state, "State");
        this.Country = validateString(country, "Country");
    }
    private String validateString(String field,String fieldname){
        if(field == null || field.isEmpty() || !field.matches("[a-zA-z\\s]+")){
            throw new IllegalArgumentException(fieldname+"enter valid character");
        }
        return field;
    }




    @Override
    public String toString() {
        return "Addresse{" +
                "StreetNumber='" + StreetNumber + '\'' +
                ", StreetName='" + StreetName + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
