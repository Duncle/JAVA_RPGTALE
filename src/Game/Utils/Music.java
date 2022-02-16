package Game.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

    java.applet.AudioClip clip;

    public void play(String filepath) {

        URL soundByte = null;
        try {
            soundByte = new File(filepath).toURI().toURL();
        } catch (
                MalformedURLException ex) {
            ex.printStackTrace();
        }
        clip = java.applet.Applet.newAudioClip(soundByte);
        clip.play();
    }

    public void stop() {
        clip.stop();
    }

}
