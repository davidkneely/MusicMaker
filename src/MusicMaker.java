import java.security.SecureRandom;
import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/*
 * TODO:
 * 
 * Create melodies based on the circle of fifths.
 * 
 *   Determine common patterns based on the fifths. eg. Twinkle Twinkle Little Star.
 *   
 * List out all the proper notes based on each scale.
 * 
 *   Remove constants from code.
 * 
 * Importing patterns:
 * 
 *   Create method to import random patterns.
 * 
 * Future updates:
 * 
 *   Filters and envelopes
 *   Eventually would like to support some different kinds of tones.
 *   Attack
 *   Release
 *   Sustain
 *   Decay
 *   Hook code to Ableton or Logic to utilize the synth engine.
 * 
 * Import different kinds of source formats:
 * 
 *   File formats
 *   Weather patterns
 *   Words
 *
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

		// Pick a starting key.
		// Pick a starting note.
		// Pick a starting feeling.
		// Generate the plot of the piece.
		// Have the algorithm fill in the notes between the notes.
		
		int songDuration = 30;
		
        final AudioFormat af = new AudioFormat(Note.SAMPLE_RATE, 8, 1, true, true);
        SourceDataLine line = AudioSystem.getSourceDataLine(af);
        line.open(af, Note.SAMPLE_RATE);
        line.start();
        
        int restDuration = 100;
        int noteDuration = 500;

        //playScale(line, restDuration, noteDuration);
        playRandomScale(line, restDuration, noteDuration, songDuration);
        
        line.drain();
        line.close();
    }

	private static void playScale(SourceDataLine line, int restDuration, int noteDuration) {
		for  (Note n : Note.values()) {
            play(line, n, noteDuration);
            play(line, Note.REST, restDuration);
        }
	}
	
	private static void playRandomScale(SourceDataLine line, int restDuration, int noteDuration, int songDuration) {
		
		int min = 10;
		int max = noteDuration;

		for(int i = 0; i < songDuration; i++){
			
			Random rand = new Random();
			
			int randomNum = rand.nextInt((max - min) + 1) + min;
			Note inputNote = randomEnum(Note.class);
			play(line, inputNote, randomNum);
			//randomNum = rand.nextInt((max - min) + 1) + min;
			//play(line, Note.REST, randomNum);
			play(line, Note.REST, restDuration);
		}
	}
	
	public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
		
		Random rand = new Random();
        int x = rand.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
	
	/**
	 * Plays the input Note.
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