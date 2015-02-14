import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * Generates random music with Java Sound API.
 * @author David Neely
 */
public class MusicMaker {

	/**
	 * Plays a scale of music starting at A.
	 * @param args The arguments. Not implemented.
	 */

  private static final int SONG_DURATION = 30;
  private static final int REST_DURATION = 50;
  private static final int WHOLE_NOTE_DURATION = 500;
  private static final int MINIMUM_NOTE_DURATION = 100;
  private static final int HALF_NOTE_DURATION = WHOLE_NOTE_DURATION /2;
  private static final int QUARTER_NOTE_DURATION = HALF_NOTE_DURATION/2;

	public static void main(String[] args) throws LineUnavailableException {

    setSongKey();
    setSongStartNote();
    setSongFeeling();
    setSongPlotline();

    final AudioFormat af = new AudioFormat(Note.SAMPLE_RATE, 8, 1, true, true);
    SourceDataLine line = AudioSystem.getSourceDataLine(af);
    line.open(af, Note.SAMPLE_RATE);
    line.start();

    playRandomSong(line, REST_DURATION, WHOLE_NOTE_DURATION, SONG_DURATION);

    line.drain();
    line.close();
  }

  private static void setSongPlotline() {
    // Generate the plot of the piece.
  }

  private static void setSongFeeling() {
    // Pick a starting feeling.
    // major
    // minor
    // tempo
    // average space between notes
  }

  private static void setSongStartNote() {
    // Pick a starting note.
  }

  private static void setSongKey() {
    // Pick a starting key.
  }

  /**
   * Plays a random song.
   * @param line The song to be played.
   * @param restDuration The duration of rests between notes.
   * @param noteDuration The duration of the note.
   * @param songDuration The duration of the song.
   */
  private static void playRandomSong(SourceDataLine line, int restDuration, int noteDuration, int songDuration) {

		for(int i = 0; i < songDuration; i++){
			
			Random rand = new Random();

			int randomNum = rand.nextInt((noteDuration - MINIMUM_NOTE_DURATION) + 1) + MINIMUM_NOTE_DURATION;
      //int randomNum = rand.nextInt((noteDuration - QUARTER_NOTE_DURATION) + 1) + QUARTER_NOTE_DURATION;
			Note inputNote = randomEnum(Note.class);
			play(line, inputNote, randomNum);
			play(line, Note.REST, restDuration);
		}
	}

  /**
   * Plays song with randomized intervals.
   * @param line The single note to play.
   * @param restDuration The length of each rest.
   * @param noteDuration The length of each note.
   */
  private static void playScale(SourceDataLine line, int restDuration, int noteDuration) {
    for  (Note n : Note.values()) {
      play(line, n, noteDuration);
      play(line, Note.REST, restDuration);
    }
  }

  /**
   * Gets random element from input Enumeration.
   * @param clazz The class of the input Enumeration.
   * @param <T> The generic type of the input Enumeration.
   * @return The random element of the input Enumeration.
   */
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

  // TODO: Find out how to set these tones at good sounding intervals so they all confirm to a key.

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


/*
 * TODO:
 * Cycle of fifths
 *   perfect cycle of fifths == 12 notes
 *   diatonic cycle of fifths == major/minor scales
 *
 * 
 * Create melodies based on the circle of fifths.
 * 
 *   Determine common patterns based on the fifths. eg. Twinkle Twinkle Little Star.
 *   Set patterns to correspond to.
 *   	Intervals that need to be stuck to in order for the song to be recognizable.
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
