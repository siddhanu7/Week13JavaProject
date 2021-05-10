package com.tts;
import java.util.*;


public class Program {

    AddressBook currentBook = new AddressBook();
    public void start()
    {
        String menu = "1) Add an Entry\n2) Remove an Entry\n3) Search for a Specific Entry\n4) Print Address Book\n5) Delete Book\n6) Quit\n\nPlease choose what you'd like to do with the database: ";
         String searchOptions = "1) First Name\n2) Last Name\n3) Phone Number\n4) Email Address\n";

        Scanner scanner = new Scanner(System.in);
        Boolean quit= false;
        while (quit==false)
        {

            System.out.println (menu);

            String userInputString = scanner.next();
            int userInput;

            try{
                userInput = Integer.parseInt(userInputString);
            }
            catch (Exception e){
                System.out.println("\nPlease input a number 1-6.\n");
                continue;
            }
            System.out.print("\n");

            if (userInput < 1 || userInput > 6){
                System.out.println("\nPlease input a number 1-6.\n");
                continue;
            }
            //add a user entry
            else if (userInput == 1)
            {
                String fn;
                String ln;
                String pn;
                String ea;
                System.out.print("First Name: ");
                fn = scanner.next();
                System.out.print("Last Name: ");
                ln = scanner.next();
                System.out.print("Phone Number: ");
                pn = scanner.next();
                System.out.print("Email Address: ");
                ea = scanner.next();
                currentBook.addNewEntry(fn, ln, pn, ea);

            }

            // ask for email of entry to remove
            else if (userInput == 2){
                System.out.print("Enter an entry's email to remove: ");
                String removeEmail = scanner.next();
                this.currentBook.deleteEntry(removeEmail);
            }

            // ask for a search type and do the search
            else if (userInput == 3){
                System.out.print(searchOptions);
                System.out.print("\nChose a search type: ");
                String searchOptionString = scanner.next();
                int searchOption;
// check for valid input
                try{
                    searchOption =
                            Integer.parseInt(searchOptionString);
                }
                catch (Exception e){
                    System.out.println("\nInvalid search option.\n");
                    continue;
                }
                if (searchOption < 1 || searchOption > 4){
                    System.out.println("\nInvalid search option.\n");
                    continue;
                }
// check the input and conduct the search
                String searchType = "";
                if (searchOption == 1){
                    searchType = "FIRSTNAME";
                }
                else if (searchOption == 2){
                    searchType = "LASTNAME";
                }
                else if (searchOption == 3){
                    searchType = "PHONENUMBER";
                }
                else if (searchOption == 4){
                    searchType = "EMAIL";
                }
                System.out.print("\nEnter your search: ");
                String searchQuery = scanner.next();
                this.currentBook.searchAddressBook(searchType, searchQuery);
            }
            // print the address book
            else if (userInput == 4){
                currentBook.printAddressBook();
            }

            // reset the address book
            else if (userInput == 5){
                System.out.println("Address book cleared!\n");
                this.currentBook = new AddressBook();
            }
            if (userInput == 6){
                quit = true;
            }
        }
    }
}
