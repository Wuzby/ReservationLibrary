import java.util.*;
import java.awt.*;
import java.io.*;

public class LibraryUser
{
    private String userID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;
    private int length = 6;


    public String getUserID(){
        return userID;
    }

    public String getSurname(){
        return surname;
    }

    public String getfirstName(){
        return firstName;
    }

    public String getOtherInitials(){
        return otherInitials;
    }

    public String getTitle(){
        return title;
    }


    public void setUserID(String newUserID){
        userID = newUserID;
    }

    public void setSurnameID(String newSurname){
        surname = newSurname;
    }

    public void setFirstName(String newFirstName){
        firstName = newFirstName;
    }

    public void setOtherInitials(String newOtherInitials){
        otherInitials = newOtherInitials;
    }

    public void setTitle(String newTitle){
        title = newTitle;
    }


    public String generateUserID(String prefix)
    {
        Random rand = new Random();
        String string = "";
        userID = prefix + string;

        for(int i = 0; i < length; i++){
            int rndm = rand.nextInt(10);
            string += rndm;
        }

        return userID;
    }

    public void extractData(Scanner scanner){
        userID = scanner.next();
        surname = scanner.next();
        firstName = scanner.next();
        otherInitials = scanner.next();
        title = scanner.next();
        scanner.close();
    }

    public void printDetails(){
        System.out.println("UserID: " + userID);
        System.out.println("Surname: " + surname);
        System.out.println("First Name: " + firstName);
        System.out.println("Other Initials: " + otherInitials);
        System.out.println("Title: " + title);
    }

    public void writeData(PrintWriter pWriter){
        String output = userID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title;
        pWriter.println(output);
    }
}
