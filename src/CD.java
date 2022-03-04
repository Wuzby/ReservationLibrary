import java.util.Scanner;

public class CD extends AudioVisual{

    private String artist;
    private int noOfTracks;

    public CD(){

        super();

    }

    public void extractData(Scanner scanner){

        artist = scanner.next();
        noOfTracks = scanner.nextInt();
        super.extractData(scanner);


    }

    public void printDetails(){

        System.out.println("Artist - " + getArtist());
        System.out.println("Number of Tracks - " + getNoOfTracks());
        System.out.println();
        super.printDetails();

    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNoOfTracks() {
        return noOfTracks;
    }

    public void setNoOfTracks(int noOfTracks) {
        this.noOfTracks = noOfTracks;
    }


}
