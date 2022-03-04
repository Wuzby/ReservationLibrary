import java.util.Scanner;

public class DVD extends AudioVisual{

    private String director;

    public DVD(){

        super();

    }

    public void extractData(Scanner scannerOne){

        director = scannerOne.next();

        super.extractData(scannerOne);


    }



    public void printDetails(){

        super.printDetails();
        System.out.println("Director - " + getDirector());

    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}