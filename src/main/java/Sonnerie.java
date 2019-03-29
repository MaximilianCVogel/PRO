/*
 * Sources :
 * https://stackoverflow.com/questions/11273773/javafx-2-1-toolkit-not-initialized
 * https://stackoverflow.com/questions/6045384/playing-mp3-and-wav-in-java
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
 */
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.CountDownLatch;

public class Sonnerie extends Thread {
    private MediaPlayer media;

    public Sonnerie(){
        try {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new JFXPanel(); // initializes JavaFX environment
                }
            });
            String sonnerie = "monFichier.mp3";
            File f = new File(sonnerie);
            if(!f.exists() || f.isDirectory()) {
                throw new FileNotFoundException("Le fichier média n'existe pas");
            }
            Media hit = new Media(f.toURI().toString());
            media = new MediaPlayer(hit);
        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe);
            fnfe.printStackTrace();
        }
    }

    public boolean isPlaying(){
        return  media.getStatus().equals(MediaPlayer.Status.PLAYING);
    }

    public void stopPlaying() {
        media.stop();
    }

    public void run() {
        media.play();
        while(true);
    }
}
