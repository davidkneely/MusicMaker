import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/*
 * TODO:
 * 
 * Update code with method to import random patterns.
 * Remove constants from code.
 * 
 */

/*
 * Cited Sources:
 * 
 * http://stackoverflow.com/questions/7782721/java-raw-audio-output/7782749#7782749
 * http://stackoverflow.com/questions/2064066/does-java-have-built-in-libraries-for-audio-synthesis/2065693#2065693
 */

/**
 * Generates random music with Java Sound API.
 * @author David Neely
 */
public class MusicMaker {

	/**
	 * Plays a scale of music starting at A.
	 * @param args The arguments. Not implemented.
	 */	
	public static void main(String[] args) throws LineUnavailableException {
        final AudioFormat af = new AudioFormat(Note.SAMPLE_RATE, 8, 1, true, true);
        SourceDataLine line = AudioSystem.getSourceDataLine(af);
        line.open(af, Note.SAMPLE_RATE);
        line.start();
        for  (Note n : Note.values()) {
            play(line, n, 500);
            play(line, Note.REST, 10);
        }
        line.drain();
        line.close();
    }
	/**
	 * Plays the melody.
	 * @param line The entire melody to be played.
	 * @param note The note to be added to the melody.
	 * @param ms The duration of the note.
	 */
    private static void play(SourceDataLine line, Note note, int ms) {
        ms = Math.min(ms, Note.SECONDS * 1000);
        int length = Note.SAMPLE_RATE * ms / 1000;
        int count = line.write(note.data(), 0, length);
    }

}
/**
 * Lists out the notes to be played.
 * @author David Neely
 *
 */
enum Note {

    REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
    public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
    public static final int SECONDS = 2;
    private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

    Note() {
        int n = this.ordinal();
        if (n > 0) {
            double exp = ((double) n - 1) / 12d;
            double f = 440d * Math.pow(2d, exp);
            for (int i = 0; i < sin.length; i++) {
                double period = (double)SAMPLE_RATE / f;
                double angle = 2.0 * Math.PI * i / period;
                sin[i] = (byte)(Math.sin(angle) * 127f);
            }
        }
    }

    /**
     * The individual note to be played.
     * @return The sin wave.
     */
    public byte[] data() {
        return sin;
    }
}