package com.tts;

import java.util.ArrayList;
import java.util.regex.Pattern;


public class AddressBook {

    // Create an ArrayList object
    ArrayList<TelephoneEntry> phonebook = new ArrayList<>();
    int index;
    public void addNewEntry(String FirstName, String LastName, String PhoneNuumber, String eMail)
    {

        boolean doesExist =false;
        boolean validEmail;
        boolean validPhoneNumber;

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (eMail==null)
        {
            validEmail=false;
            System.out.println("You did not enter anything in the email");
        }
        if (pat.matcher(eMail).matches()==true)
        {
            validEmail=true;
        }
        else
        {
            validEmail=false;
            System.out.println("Incorrect email format and so entry will not be added");
        }



        if (PhoneNuumber.matches("\\d{10}"))
            validPhoneNumber=true;
            // validating phone number with -, . or spaces
        else if (PhoneNuumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
            validPhoneNumber=true;
            // validating phone number with extension length from 3 to 5
        else if (PhoneNuumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
            validPhoneNumber=true;
            // validating phone number where area code is in braces ()
        else if (PhoneNuumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
            validPhoneNumber=true;
            // Validation for India numbers
        else if (PhoneNuumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
            validPhoneNumber=true;
        else if (PhoneNuumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
            validPhoneNumber=true;

        else if (PhoneNuumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
            validPhoneNumber=true;
            // return false if nothing matches the input
        else
        {
            validPhoneNumber=false;
            System.out.println("The phone number format you  entered is invalid");
        }









        for ( index = 0; index < phonebook.size(); index++) {
            if (eMail.equalsIgnoreCase(phonebook.get(index).geteMail())) {
                System.out.println("This email already exists and so no record will be added");
                doesExist = true;
                break;

            }
        }
           if (doesExist==false && validEmail==true && validPhoneNumber==true)
           {
               phonebook.add(new TelephoneEntry(FirstName, LastName, PhoneNuumber, eMail ));
               System.out.println("\nAdded new entry!\n");
           }



    }


    public void deleteEntry (String removeEmail)
    {


        //int index;
        for ( index = 0; index < phonebook.size(); index++) {
            if (removeEmail.equalsIgnoreCase(phonebook.get(index).geteMail())) {


                break;

            }
        }

        try {
            phonebook.remove(index);
            System.out.println("\nRemoved the entry!\n");

        }
        catch (Exception e)
        {
            System.out.println("No records to delete");
    }





    }


    public void searchAddressBook(String searchType, String searchQuery)
    {

        Boolean firstNameExists=false;
        Boolean lastNameExists= false;
        Boolean phoneNumberExists= false;
        Boolean emailExists=false;

        if (searchType=="FIRSTNAME")
        {


            for ( index = 0; index < phonebook.size(); index++) {
                String firstNameIgnoreCase=phonebook.get(index).getFirstName().toLowerCase();
                String searchQueryIgnoreCase = searchQuery.toLowerCase();


                if (firstNameIgnoreCase.contains(searchQueryIgnoreCase)) {

                    String formatString=toString();
                    System.out.println(formatString);
                    firstNameExists=true;


                }
            }
            if (firstNameExists==false)
            {
                System.out.println("No records exist");
            }

        }
        else if (searchType=="LASTNAME")
        {


            for ( index = 0; index < phonebook.size(); index++) {
                String lastNameIgnoreCase=phonebook.get(index).getLastName().toLowerCase();
                String searchQueryIgnoreCase = searchQuery.toLowerCase();

                if (lastNameIgnoreCase.contains(searchQueryIgnoreCase)) {

                    String formatString=toString();
                    System.out.println(formatString);
                    lastNameExists=true;


                }
            }
            if (lastNameExists=false)
            {
                System.out.println("No records exist");
            }

        }
        else if (searchType=="PHONENUMBER")
        {


            for ( index = 0; index < phonebook.size(); index++) {

                if (phonebook.get(index).getPhoneNumber().contains(searchQuery)) {

                    String formatString=toString();
                    System.out.println(formatString);
                    phoneNumberExists=true;

                    //break;

                }
            }
            if(phoneNumberExists=false)
            {
                System.out.println("No records exist");
            }


        }
        else if (searchType=="EMAIL")
        {


            for ( index = 0; index < phonebook.size(); index++) {
                String emailIgnoreCase=phonebook.get(index).geteMail().toLowerCase();
                String searchQueryIgnoreCase = searchQuery.toLowerCase();


                if (emailIgnoreCase.contains(searchQueryIgnoreCase)) {

                    String formatString=toString();
                    System.out.println(formatString);
                    emailExists=true;


                }
            }
            if (emailExists=false)
            {
                System.out.println("No records exist");
            }

        }






    }

    public void printAddressBook()
    {
        if (phonebook.size()==0)
        {
            System.out.println ("No phone records in the directory");
        }
        else
        {
            System.out.println("Below are the entries in the Address Book");
        }
        for (index = 0; index < phonebook.size(); index++) {

            String formatString=toString();
            System.out.println(formatString);

        }



    }

    @Override
    public String toString()

    {

            StringBuilder sb=new StringBuilder();
            sb.append("First name : ").append(phonebook.get(index).getFirstName()).append("\n");
            sb.append("Last name : ").append(phonebook.get(index).getLastName()).append("\n");
            sb.append("Phone Number : ").append(phonebook.get(index).getPhoneNumber()).append("\n");
            sb.append("Email : ").append(phonebook.get(index).geteMail()).append("\n");
            return sb.toString();


    }








}


class TelephoneEntry {

    String FirstName;
    String LastName;
    String PhoneNumber;
    String eMail;

    TelephoneEntry(String FirstName, String LastName, String PhoneNumber, String eMail) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.PhoneNumber = PhoneNumber;
        this.eMail = eMail;
    }

    String getPhoneNumber() {
        return PhoneNumber;
    }

    String getFirstName() {
        return FirstName;
    }
    String getLastName() {
        return LastName;
    }
    String geteMail() {
        return eMail;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "TelephoneEntry{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
