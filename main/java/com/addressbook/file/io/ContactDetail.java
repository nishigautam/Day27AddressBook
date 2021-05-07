package com.addressbook.file.io;

public class ContactDetail {
    /**
     * assigning all the details giving its value
     *
     * creating contact details inside AddressBook
     */
    public String firstname;
    public String lastname;
    public String address;
    public String city;
    public String state;
    public String phoneNumber;
    public int zipcode;

    /**
     * assigning variables to each details
     * @param firstname
     * @param lastname
     * @param address
     * @param city
     * @param state
     * @param phoneNumber
     * @param zipcode
     */
    public ContactDetail(String firstname, String lastname, String address, String city,
                        String state,  String phoneNumber, int zipcode ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.zipcode = zipcode;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname() {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname() {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress() {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity() {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState() {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber() {
        this.phoneNumber = phoneNumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * display the contact created in address book.
     */
    @Override
    public String toString() {
        return "AddressBook [" + "firstname=" + firstname + ", lastname=" + lastname +
                ", city=" + city + ", state=" + state + ", phoneNumber=" + phoneNumber + ", zipcode=" + zipcode + "]";
    }
}
