import java.util.*;

public abstract class AudioVisual extends LibraryItem {

    protected int playingTime;



    public AudioVisual() {


    }

    public void printDetails() {

        System.out.println("Playing time: " + getPlayingTime());
        super.printDetails();
    }

    public void extractData(Scanner scanner){

        playingTime = scanner.nextInt();
        super.extractData(scanner);

    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

}
