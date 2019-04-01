import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SonnerieTest {

    @Test
    void shouldPlayTheMedia() throws InterruptedException {
        Sonnerie s = new Sonnerie();
        s.start();
        TimeUnit.SECONDS.sleep(1);
        boolean music = s.isPlaying();
        assertEquals(true, music);
        s.stopPlaying();
        TimeUnit.SECONDS.sleep(1);
        music = s.isPlaying();
        s.interrupt();
        assertEquals(false, music);
    }
}
