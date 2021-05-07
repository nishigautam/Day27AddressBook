package com.addressbook.file.io;

import java.util.*;
import java.util.stream.Collectors;
import java.util.TreeMap;

/**
 * the below method is for adding the contact into address book
 */
public class AddressBook implements IAddressBook {
    private static Map<String, List<ContactDetail>> addressBookMap = new TreeMap<>();

    List<ContactDetail> contact = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    /**
     * UC2 : to add contact of a person in Address Book.
     */
    @Override
    public void addContact() {
        System.out.println("Enter Firstname:");
        String firstname = input.nextLine();

        System.out.println("Enter Lastname:");
        String lastname = input.nextLine();
        /**
         * UC6: refactor the add contact function
         * to check no duplicate firstname or lastname exists.
         */
        for(int check = 0; check < contact.size(); check++) {
            if(contact.get(check).getFirstname().equalsIgnoreCase(firstname)) {
                if(contact.get(check).getLastname().equalsIgnoreCase(lastname)) {
                    System.out.println("Name Already Exist.! Please try again.. : ");
                    return;
                }
            }
        }

        System.out.println("Enter Address:");
        String address = input.nextLine();

        System.out.println("Enter City:");
        String city = input.nextLine();

        System.out.println("Enter State:");
        String state = input.nextLine();

        System.out.println("Enter PhoneNumber:");
        String phoneNumber = input.nextLine();

        System.out.println("Enter ZipCode:");
        int zipcode = input.nextInt();

        ContactDetail contactDetail = new ContactDetail(firstname, lastname, address, city, state, phoneNumber, zipcode);
        contact.add(contactDetail);
        System.out.println(" Firstname=" + firstname + ", Lastname=" + lastname + ", city=" + city + ", state=" + state +
                ", PhoneNumber=" + phoneNumber + ", zipcode=" + zipcode );
        System.out.println("Contact Added Successfully");
    }


    /**
     * UC3: performing the operation for edit contact for the existing contact.
     *
     * @param firstname
     *
     */
    @Override
    public void editContact(String firstname) {
        for (int i = 0; i < contact.size(); ++i) {
            if( contact.get(i).getFirstname().equalsIgnoreCase(firstname)) {
                ContactDetail contactDetail = contact.get(i);
                System.out.println(contactDetail.getFirstname() + "Edit your detail :");
                System.out.println(contactDetail.getFirstname() + "Edit your Address :");
                input.next();
                String address = input.nextLine();
                contactDetail.setAddress();
                System.out.println( contactDetail.getFirstname() + " " + "Edit your city :");
                input.next();
                String city = input.nextLine();
                contactDetail.setCity();
                System.out.println( contactDetail.getFirstname() + " "  + "Edit your State :");
                input.next();
                String state = input.nextLine();
                contactDetail.setState();
                System.out.println( contactDetail.getFirstname() + " " + "Edit your Phone Number :");
                input.next();
                String phoneNumber = input.nextLine();
                contactDetail.setPhoneNumber();
                System.out.println( contactDetail.getFirstname() + " " + "Edit your zipcode :");
                input.next();
                int zipcode = input.nextInt();
                contactDetail.setZipcode(zipcode);
                System.out.println( contactDetail.getFirstname() + " " + "AddressBook Updated Successfully.!");
            }
        }
    }

    /**
     * UC4: performing the operation for delete contact from the existing contact.
     *
     */
    @Override
    public void deleteContact(String firstname) {
        for (int i = 0; i < contact.size(); i++) {
            if(contact.get(i).getFirstname().equalsIgnoreCase(firstname)) {
                ContactDetail contactDetail = contact.get(i);
                contact.remove(contactDetail);
                System.out.println("Contact Deleted Successfully.!");
            }
        }
    }

    /**
     * UC8: Search a person in a city or state accross the multiple AddressBook
     *
     * @param firstname
     */
    @Override
    public void searchPersonByCity(String firstname) {
        List<ContactDetail> contactDetailList = contact.stream().filter(person1 -> person1.getFirstname().equalsIgnoreCase(firstname)).collect(Collectors.toList());
        contactDetailList.stream().forEach(System.out::println);
    }

    @Override
    public void searchPersonByState(String firstname) {
        List<ContactDetail> contactDetailList = contact.stream().filter(person1 -> person1.getFirstname().equalsIgnoreCase(firstname)).collect(Collectors.toList());
        contactDetailList.stream().forEach(System.out::println);
    }

    /**
     * UC9: View a person by city or state accross the multiple AddressBook
     *
     * @param city and state
     */
    @Override
    public void viewByCity(String city) {
        List<ContactDetail> contactDetailList = contact.stream().filter(person1 -> person1.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        contactDetailList.stream().forEach(System.out::println);
        Map<String, ContactDetail> map = contactDetailList.stream().collect(Collectors.toMap(ContactDetail::getFirstname, contactDetail -> contactDetail));
        System.out.println();
    }

    @Override
    public void viewByState(String state) {
        List<ContactDetail> contactDetailList = contact.stream().filter(person1 -> person1.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
        contactDetailList.stream().forEach(System.out::println);
        Map<String, ContactDetail> map = contactDetailList.stream().collect(Collectors.toMap(ContactDetail::getFirstname, contactDetail -> contactDetail));
        System.out.println();
    }

    @Override
    public void CountByCity(String City) {
        int countPerson = 0;
        for(Map.Entry<String, List<ContactDetail>> entry : addressBookMap.entrySet()) {
            for (int i = 0; i < contact.size(); i++) {
                if (contact.get(i).getCity().equals(City)) {
                    System.out.println(contact.get(i));
                    countPerson = i;
                }
            }
        }
        System.out.println("Number of Person in" + City + "is" + countPerson);
    }


    /**
     *
     * @param = display the contact which has been added or updated.
     *
     */
    public void display() {
        for ( ContactDetail contactDetail : contact ) {
            System.out.println(contactDetail);
        }
    }
}