import java.util.*;
import java.awt.*;
import java.io.*;

public abstract class LibraryItem {

    protected String title;
    protected String itemCode;
    protected int timeBorrowed;
    protected boolean onLoan;
    protected int cost;

    public void printDetails(){
        System.out.println("Title: " + getTitle());
        System.out.println("Item Code: " + getItemCode());
        System.out.println("Times Borrowed: " + getTimeBorrowed());
        System.out.println("On Loan: " + getTimeBorrowed());
        System.out.println("Cost: " + getCost());
    }

    public void extractData(Scanner scanner){
        title = scanner.next();
        itemCode = scanner.next();
        itemCode = scanner.next();
        cost = scanner.nextInt();
        scanner.close();

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getTimeBorrowed() {
        return timeBorrowed;
    }

    public void setTimeBorrowed(int timeBorrowed) {
        this.timeBorrowed = timeBorrowed;
    }

    public boolean isOnLoan() {
        return onLoan;
    }

    public void setOnLoan(boolean onLoan) {
        this.onLoan = onLoan;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}