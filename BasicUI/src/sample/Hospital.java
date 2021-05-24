package sample;

import java.io.Serializable;

public class Hospital implements Serializable {
    private String Name;
    private String Address;
    private String ICU;
    private String Oxygen;
    private String Contact;
    private String key;

    public Hospital(String name, String address, String ICU, String oxygen, String key) {
        Name = name;
        Address = address;
        this.ICU = ICU;
        Oxygen = oxygen;
        this.key = key;
    }

    public Hospital(String icu, String oxygen, String key) {
        ICU = icu;
        this.Oxygen = oxygen;
        this.key = key;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getICU() {
        return ICU;
    }

    public String getOxygen() {
        return Oxygen;
    }

    public String getContact() {
        return Contact;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setICU(String ICU) {
        this.ICU = ICU;
    }

    public void setOxygen(String oxygen) {
        Oxygen = oxygen;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void info(){

    }

    @Override
    public String toString() {
        return "Hospital{" +
                "Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", ICU='" + ICU + '\'' +
                ", Oxygen='" + Oxygen + '\'' +
                ", Contact='" + Contact + '\'' +
                '}';
    }
}
