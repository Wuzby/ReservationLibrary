import java.util.Scanner;

public class Book extends PrintedItem{

    private String author;
    private double isbn;

    public Book(){

        super();

    }

    public void extractData(Scanner s){

        author = s.next();
        isbn = s.nextDouble();

        super.extractData(s);

    }

    public void printDetails(){

        System.out.println("Author: "+ getAuthor());
        System.out.println("Number of isbn: "+ getIsbn());
        System.out.println();
        super.printDetails();

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getIsbn() {
        return isbn;
    }

    public void setIsbn(double isbn) {
        this.isbn = isbn;
    }
}
