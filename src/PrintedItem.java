import java.util.Scanner;

public abstract class PrintedItem extends LibraryItem{

    protected int noOfPages;

    public void printedDetails(){

        System.out.println("Number of Pages: " + getNoOfPages());
        System.out.println("Publisher: " + getPublisher());
        super.printDetails();

    }


    public void extractData(Scanner scanner){

        noOfPages = scanner.nextInt();
        publisher = scanner.next();
        super.extractData(scanner);

    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected String publisher;

    public PrintedItem(){

    }
}