import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

// command to stop current loop.
// play diffrent song.

// would like to hook this up to the global happiness project.
// global consciousness project.
// feed in random ints from those sensors.
// see what kind of songs those random ints made...

// another idea to make the program listen to popular music to analyze the note structures that got the most virality.
// ... creation of the perfectly derivative pop song.


/**
 * Generates random music with Java Sound API.
 * @author David Neely
 */
public class MusicMaker {

  private static final float SONG_DURATION = 30;
  private static final float REST_DURATION = 0;
  public static final float SECOND_DURATION = 1000;
  public static final float TEMPORAL_RATIO = 0.9f;
  private static final float WHOLE_NOTE_DURATION = Integer.valueOf((int) (SECOND_DURATION/TEMPORAL_RATIO));
  private static final float HALF_NOTE_DURATION = WHOLE_NOTE_DURATION /2;
  private static final float QUARTER_NOTE_DURATION = HALF_NOTE_DURATION/2;
  private static final float EIGTH_NOTE_DURATION = QUARTER_NOTE_DURATION/2;
  private static final float SIXTEENTH_NOTE_DURATION = EIGTH_NOTE_DURATION/2;
  private static final float THIRTYSECOND_NOTE_DURATION = SIXTEENTH_NOTE_DURATION/2;

  // Just hung out with Kyle and demo'd the output.

  // He suggested updating the track to support "Beats on the Seconds. 60 second timer. Not a boring 60 seconds."

  // Ideas of generated toward making this player
  // Polyphonic to cluster sound rashes
  // Against the main melody at a lower volume.
  // like
  // but with more subtlety?

  /**
   * Plays a scale of music starting at A.
   * @param args The arguments. Not implemented.
   */
	public static void main(String[] args) throws LineUnavailableException {

    setSongKey();
    setSongStartNote();
    setSongFeeling();
    setSongPlotline();

    ArrayList<Note> aMajorScale = createAMajorScale();
    ArrayList<Note> cMajorScale = createCMajorScale();
    ArrayList<Float> noteTimes = createNoteTimes();

    final AudioFormat af = new AudioFormat(Note.SAMPLE_RATE, 8, 1, true, true);
    SourceDataLine line = AudioSystem.getSourceDataLine(af);
    line.open(af, Note.SAMPLE_RATE);
    line.start();

    //playRandomSong(line, aMajorScale, REST_DURATION, WHOLE_NOTE_DURATION, SONG_DURATION);
    //playRandomSong(line, cMajorScale, REST_DURATION, WHOLE_NOTE_DURATION, SONG_DURATION);
    //playScale(line, REST_DURATION, WHOLE_NOTE_DURATION);

  for(int i = 10; i < 20; i++){
      createMelody(aMajorScale, line);
    }
    //createMelody002(aMajorScale, line);

    // maybe add in some standard drum beat???

    line.drain();
    line.close();
  }

  private static void createMelody(ArrayList<Note> aMajorScale, SourceDataLine line) {
    ArrayList<Note> loopX = new ArrayList<>(createLoop(aMajorScale));
    ArrayList<Note> loopY = new ArrayList<>(createLoop(aMajorScale));
    ArrayList<Note> loopZ = new ArrayList<>(createLoop(aMajorScale));

    // added length variable
    //float QUARTER_NOTE_DURATION = 100;

    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopZ){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopZ){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopZ){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopZ){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
  }

  private static void createMelody002(ArrayList<Note> aMajorScale, SourceDataLine line) {
    ArrayList<Note> loopX = new ArrayList<>(createLoop(aMajorScale));
    ArrayList<Note> loopY = new ArrayList<>(createLoop(aMajorScale));
    ArrayList<Note> loopZ = new ArrayList<>(createLoop(aMajorScale));

    for(Note note: loopX){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopZ){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopZ){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopZ){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopZ){
      play(line, note, SIXTEENTH_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopX){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
    for(Note note: loopY){
      play(line, note, QUARTER_NOTE_DURATION);
      play(line, Note.REST, REST_DURATION);
    }
  }

  //  private static void playLoop(ArrayList<Note> inputArray) {
//
//    for(Note note: inputArray){
//      play(line, inputNote, randomNum);
//      play(line, Note.REST, restDuration);
//    }
//
//  }
  private static ArrayList<Note> createLoop(ArrayList<Note> inputArray){

    // populate a random array
    ArrayList<Note> returnArrayPatternNotes = new ArrayList<>();
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));

    return  returnArrayPatternNotes;


  }

  private static ArrayList<Note> createLoopTimes(ArrayList<Note> inputArray){

    // populate a random array
    ArrayList<Note> returnArrayPatternNotes = new ArrayList<>();
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));
    returnArrayPatternNotes.add(getRandomElementFromList(inputArray));

    return  returnArrayPatternNotes;


  }

  private static ArrayList<Note> createAMajorScale() {
    ArrayList<Note> notesCMajorScale = new ArrayList<Note>();
    notesCMajorScale.add(Note.A4);
    notesCMajorScale.add(Note.B4);
    notesCMajorScale.add(Note.C4);
    notesCMajorScale.add(Note.D4);
    notesCMajorScale.add(Note.E4);
    notesCMajorScale.add(Note.F4);
    notesCMajorScale.add(Note.G4);
    notesCMajorScale.add(Note.A5);
    return notesCMajorScale;
  }

  private static ArrayList<Float> createNoteTimes() {
    ArrayList<Float> returnArray = new ArrayList<Float>();
    returnArray.add(WHOLE_NOTE_DURATION);
    returnArray.add(HALF_NOTE_DURATION);
    returnArray.add(QUARTER_NOTE_DURATION);
    returnArray.add(SIXTEENTH_NOTE_DURATION);
    returnArray.add(THIRTYSECOND_NOTE_DURATION);
    return returnArray;
  }

  private static ArrayList<Note> createCMajorScale() {

    // 7 diatonic triads in any major key
    // Major, Minor, Minor, Major, Major, Minor, Diminished, Major
    // tonic, super tonic, median, sub dominant, dominant, sub median, leading tone, tonic

    ArrayList<Note> notesCMajorScale = new ArrayList<Note>();
    notesCMajorScale.add(Note.C4);
    notesCMajorScale.add(Note.D4);
    notesCMajorScale.add(Note.E4);
    notesCMajorScale.add(Note.F4);
    notesCMajorScale.add(Note.G4);
    notesCMajorScale.add(Note.A5);
    notesCMajorScale.add(Note.B4); // goes down one octave, need to create more notes in the root notes.
    return notesCMajorScale;
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
  private static void playRandomSong(SourceDataLine line, ArrayList<Note> inputScale, int restDuration, int noteDuration, int songDuration) {

		for(int i = 0; i < songDuration; i++){
			
			Random rand = new Random();

			int randomNum = rand.nextInt((noteDuration - (int)THIRTYSECOND_NOTE_DURATION) + 1) + (int)THIRTYSECOND_NOTE_DURATION;
			Note inputNote = getRandomElementFromList(inputScale);
			play(line, inputNote, randomNum);
			play(line, Note.REST, restDuration);
		}
	}

  private static Note getRandomElementFromList(ArrayList<Note> inputArrayList) {
    Note returnNote;
    Random randomGenerator = new Random();
    int index = randomGenerator.nextInt(inputArrayList.size());
    returnNote = inputArrayList.get(index);
    return returnNote;
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
    private static void play(SourceDataLine line, Note note, float ms) {
        ms = Math.min(ms, Note.SECONDS * 1000);
        float length = Note.SAMPLE_RATE * ms / 1000;
        float count = line.write(note.data(), 0, (int)length);
        
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

enum NotesCMajor {

  /*
  Notes: 	C • D • E • F • G • A • B
  Diatonic Triads: 	C • Dm • Em • F • G • Am • Bdim
  Relative Minor: 	A Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesCMajor() {
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

enum NotesGMajor {

  /*
  Notes: 	G • A • B • C • D • E • F
  Diatonic Triads: 	G • Am • Bm • C • D • Em • F#dim
  Relative Minor: 	E Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesGMajor() {
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

enum NotesDMajor {

  /*
  Notes: 	D • E • F • G • A • B • C
  Diatonic Triads: 	D • Em • F#m • G • A • Bm • C#dim
  Relative Minor: 	B Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesDMajor() {
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

enum NotesAMajor {

  /*
  Notes: 	A • B • C • D • E • F • G
  Diatonic Triads: 	A • Bm • C#m • D • E • F#m • G#dim
  Relative Minor: 	F Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesAMajor() {
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

enum NotesEMajor {

  /*
  Notes: 	E • F • G • A • B • C • D
  Diatonic Triads: 	E • F#m • G#m • A • B • C#m • D#dim
  Relative Minor: 	C Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesEMajor() {
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

enum NotesBMajor {

  /*
  Notes: 	B • C • D • E • F • G • A
  Diatonic Triads: 	B • C#m • D#m • E • F# • G#m • A#dim
  Relative Minor: 	G Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesBMajor() {
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

enum NotesFSharpMajor {

  /*
  Notes: 	F • G • A • B • C • D • E
  Diatonic Triads: 	F# • G#m • A#m • B • C# • D#m • E#dim
  Relative Minor: 	D Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesFSharpMajor() {
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

enum NotesDFlatMajor {

  /*
  Notes: 	D • E • F • G • A • B • C
  Diatonic Triads: 	Db • Ebm • Fm • Gb • Ab • Bbm • Cdim
  Relative Minor: 	B Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesDFlatMajor() {
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

enum NotesAFlatMajor {

  /*
  Notes: 	A • B • C • D • E • F • G
  Diatonic Triads: 	Ab • Bbm • Cm • Db • Eb • Fm • Gdim
  Relative Minor: 	F Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesAFlatMajor() {
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

enum NotesEFlatMajor {

  /*
  Notes: 	E • F • G • A • B • C • D
  Diatonic Triads: 	Eb • Fm • Gm • Ab • Bb • Cm • Ddim
  Relative Minor: 	C Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesEFlatMajor() {
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

enum NotesBFlatMajor {

  /*
  Notes: 	B • C • D • E • F • G • A
  Diatonic Triads: 	Bb • Cm • Dm • Eb • F • Gm • Adim
  Relative Minor: 	G Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesBFlatMajor() {
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

enum NotesFMajor {

  /*
  Notes: 	F • G • A • B • C • D • E
  Diatonic Triads: 	F • Gm • Am • Bb • C • Dm • Edim
  Relative Minor: 	D Minor
  */

  REST, A4, A4$, B4, C4, C4$, D4, D4$, E4, F4, F4$, G4, G4$, A5;
  public static final int SAMPLE_RATE = 16 * 1024; // ~16KHz
  public static final int SECONDS = 2;
  private byte[] sin = new byte[SECONDS * SAMPLE_RATE];

  NotesFMajor() {
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
