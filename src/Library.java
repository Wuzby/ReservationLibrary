import java.awt.*;
import java.io.*;
import java.util.*;

public class Library {

    private HashMap<String, LibraryItem> itemsMap;
    private HashMap<String, LibraryUser> usersMap;
    private HashMap<String, ItemReservation> itemReservMap;


    public Library() {

        itemsMap = new HashMap<String, LibraryItem>();
        usersMap = new HashMap<String, LibraryUser>();

        itemReservMap = new HashMap<String, ItemReservation>();

    }

    public void storeItems(LibraryItem libraryItem){
        itemsMap.put(libraryItem.getItemCode(), libraryItem);
    }
    public void storeUsers(LibraryUser libraryUser){
        if(libraryUser.getUserID().equalsIgnoreCase("unknown"))
        {
            String userID = libraryUser.generateUserID("AB-");
            usersMap.put(userID, libraryUser);
        }
        else
        {
            usersMap.put(libraryUser.getUserID(), libraryUser);
        }
    }

    public void storeItemReservation(ItemReservation iR){
        itemReservMap.put(iR.getReservationNo(), iR);
    }
    public void getItem(String itemCode){
        LibraryItem lI = itemsMap.get(itemCode);
        lI.printDetails();
    }
    public void getUser(String userID){
        LibraryUser lU  = usersMap.get(userID);
        lU.printDetails();
    }
    public void getItemReservation(String reservationNo){
        ItemReservation iR = itemReservMap.get(reservationNo);
        iR.printDetails();
    }


    public boolean makeItemReservation(String userID, String itemCode, String startDate, int noOfDays){     //checks if the values are unique if yes then generates a new number
        if(itemReservMap.values().contains(userID) && itemReservMap.values().contains(itemCode) && itemReservMap.values().contains(startDate) && itemReservMap.values().contains(noOfDays)){
            ItemReservation iR = new ItemReservation(null, userID, itemCode,startDate, noOfDays);
            iR.generateReservationNo();
            storeItemReservation(iR);
            return true;
        }
        return false;
    }

    public void writeItemReservationData(){
        if(itemReservMap.size() == 0){
            System.out.println("There's noting to write, list is empty");   //Checks if if we have data that we can write to the file
        }else{
            Frame myFrame = null;

            FileDialog fileBox = new FileDialog(myFrame, "Store", FileDialog.SAVE);         //allows to save file in selected location via windows interface
            fileBox.setVisible(true);
            String fileName = fileBox.getDirectory() + fileBox.getFile();
            File inFile = new File(fileName);

            PrintWriter printWriter = null;
            try{
                printWriter = new PrintWriter(inFile);
            }
            catch(FileNotFoundException ex){
                System.out.println();
            }
            for(LibraryUser lU : usersMap.values()){
                lU.writeData(printWriter);
            }
        }
    }

//    public void readItemReservationData(){
//        Frame myFrame = null;
//        FileDialog fileBox = new FileDialog(myFrame, "Store", FileDialog.LOAD);        //allows for the selection of the file via windows interface
//        fileBox.setVisible(true);
//
//        String fileName = fileBox.getDirectory() + fileBox.getFile();
//        File inFile = new File(fileName);
//
//        Scanner scanner = null;
//        String typeOfData = null;
//        try{
//            scanner = new Scanner(inFile);
//        }
//        catch(FileNotFoundException ex){
//            System.out.println("Invalid File");     //informs user about the error
//            fileName = null;
//        }
//        if(fileName != null){
//            while(scanner.hasNext()){
//                ItemReservation iR = new ItemReservation();
//                iR.extractData(scanner);
//            }
//            scanner.close();   //close the scanner when the scanning is done
//        }
//    }



    public void readData(String fileName){
        //Open file dialog window
        Frame myFrame = null;
        FileDialog fileBox = new FileDialog(myFrame,"Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        //System.out.println(fileBox);

        //opens the file
        String filename = fileBox.getDirectory()+fileBox.getFile();
        //fileName = ("C:\Users\M3rk\Desktop\Java Project Part 3\Files\items_and_user_data.txt");
        File inFile = new File(fileName);


        String typeOfData = ""; //create empty string
        Scanner sOne = new Scanner("");
        //Output an error message if error is produced
        try{
            sOne = new Scanner(inFile);
        }
        catch(FileNotFoundException ex){
            System.err.println("Invalid file");
        }


        while(sOne.hasNext()){
            String textLine = sOne.nextLine().trim();
            //if textLine has // or is empty then do nothing
            if(textLine.startsWith("//") || (textLine.length() == 0)){
                //if it encounters [ then assign typeOfData to the text line
            }
            else if(textLine.startsWith("["))
            {
                System.out.println(textLine);
                if(textLine.toLowerCase().equals("[cd data]")){
                    typeOfData = "cd";
                }
                else if(textLine.toLowerCase().equals("[dvd data]")){
                    typeOfData = "dvd";
                }
                else if(textLine.toLowerCase().equals("[periodical data]")){
                    typeOfData = "periodical";
                }
                else if(textLine.toLowerCase().equals("[book data]")){
                    typeOfData = "book";
                }
                else if(textLine.toLowerCase().equals("[library user data]")){
                    typeOfData = "libraryUser";
                }
                else typeOfData = "Unknown Data";
            }



            else{
                Scanner s2 = new Scanner(textLine).useDelimiter("[ ]*(,)[ ]*");
                LibraryItem lItem = null;
                LibraryUser userItem = null;


                if (typeOfData.equals("cd")){
                    lItem = new CD();   //creates new cd object
                    //Add cd object to the arrayList
                } else if(typeOfData.equals("dvd")){
                    lItem = new DVD();
                    //Add cd object to the arrayList
                } else if(typeOfData.equals("periodical")){
                    lItem = new Pereodical();
                    //Add cd object to the arrayList
                }else if(typeOfData.equals("book")){
                    lItem = new Book();
                    //Add cd object to the arrayList
                } else if(typeOfData.equals("libraryUser")){
                    userItem = new LibraryUser();
                }
                else{
                    userItem = null;
                    lItem = null;
                }

                if(userItem != null)
                {
                    userItem.extractData(s2);
                    storeUsers(userItem);
                    //same thing for l item
                }
                if(lItem != null)
                {
                    lItem.extractData(s2);
                    storeItems(lItem);
                }
                s2.close();
            }
        }
        sOne.close();
    }










    // public void writeUserData(){
    // PrintWriter pWriter = null;
    // try{
    // pWriter = new PrintWriter();
    // }
    // catch(FileNotFoundException ex){
    // System.out.println("Error");
    // }

    // //String output = "[Library User Data]";
    // //pW.println(output);
    // for(LibraryUser libraryUser : usersMap.values()){
    // libraryUser.writeData(pWriter);
    // }
    // pWriter.close();
    // }

    public void printAllDetails() {
        if(itemsMap != null){   //check if the map is not empty
            for(LibraryItem libraryItem : itemsMap.values()){
                libraryItem.printDetails();
            }
        }else{
            System.out.println("Storage is empty"); //output a message if array list is empty
        }

        if(usersMap != null){
            for (LibraryUser libraryUser : usersMap.values()){
                libraryUser.printDetails();
            }
        }else{
            System.out.println("Storage is empty");
        }

        if(itemReservMap != null){
            for(ItemReservation iR : itemReservMap.values()){
                iR.printDetails();
            }
        }else{
            System.out.println("Storage is empty");
        }
    }
}

