import java.util.*;
import java.io.*;
import java.awt.*;

public class ItemReservation
{
    private String reservationNo;
    private String itemCode;
    private String userID;
    private Date startDate;
    private int noOfDays;
    private int num;

    public ItemReservation(String reservationNo, String itemCode, String userID, String startDate, int noOfDays){

    }


    public String getReservationNo(){
        return reservationNo;
    }

    public String getItemCode(){
        return itemCode;
    }

    public String getUserID(){
        return userID;
    }

    public Date getStartDate(){
        return startDate;
    }

    public int getNoOfDays(){
        return noOfDays;
    }


    public void setReservationNo(String newReservationNo){
        reservationNo = newReservationNo;
    }

    public void setItemCode(String newItemCode){
        itemCode = newItemCode;
    }

    public void setUserID(String newUserID){
        userID = newUserID;
    }

    // public void setStartDate(String newStartDate){
    // startDate = newStartDate;
    // }

    public void setNoOfDays(int newNoOfDays){
        noOfDays = newNoOfDays;
    }

    public void printDetails(){
        System.out.println("Reservation Number"+ reservationNo);
        System.out.println("Item Code"+ itemCode);
        System.out.println("UserID"+ userID);
        System.out.println("Start Date" + startDate);
        System.out.println("Number of Days" + noOfDays);
    }

    public void extractData(Scanner scanner){
        DateUtil dateUtil = new DateUtil();
        reservationNo = scanner.nextLine();
        itemCode = scanner.nextLine();
        startDate = DateUtil.convertStringToDate(scanner.next());
        noOfDays = scanner.nextInt();
    }

    public String generateReservationNo(){

        if(num < 1000000){
            num++;
        }
        reservationNo = String.format("%06d", num);
        return reservationNo;
    }
}
