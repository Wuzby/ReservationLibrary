import java.util.Scanner;

public class Pereodical extends PrintedItem {

    private String publicationDate;

    public Pereodical() {

        super();

    }

    @Override
    public void extractData(Scanner scanner) {
        publicationDate = scanner.next();
        super.extractData(scanner);
    }

    public void printDetails() {
        System.out.println("Publication data - " + publicationDate);
        System.out.println();
        super.printDetails();
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}
