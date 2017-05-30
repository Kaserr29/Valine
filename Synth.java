/**
 * Projet Valine - Thomas LEFEBVRE, Baptiste SORIN, Corentin LUCAS (Groupe 3)
 * Classe Synth
 * Permet de jouer la séquence avec un instrument et un tempo
 * 
 * @author Corentin LUCAS
 */

//Librairies pour l'utilisation du synthétiseur midi java
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;

public class Synth{
	int tempo;
	int instrument;
	Sequence seq;
	int dureeNote;

	//Constructeur du synthétiseur
	public Synth(Sequence s, int t, int i){
		this.tempo = t;
		this.instrument = i;
		this.dureeNote = calculDureeNote(this.tempo);
		this.seq = s;
	}
	
/**
 * Joue la sequence en bouble 
 */
	public void jouer(){
		while(true){
			iterSequence(seq.sequence);
			System.out.println("|_________________|");
		}
	}
/**
 * Calcule la durée d'une note en fonction du tempo
 * @param t tempo en bpm
 * @return d durée d'une note en ms
 */
	public int calculDureeNote(int t){
		int d = (int)((60.0/(double)t)*1000);
		System.out.println("### TEMPO : "+ t+ "###"); 
		return d;
	}
/**
 * Parcours la sequence de notes et la fait jouer par le synthetiseur de JAVA
 * @param seq Sequence a jouer
 */
	public void iterSequence(int[][] seq){
		for(int i = 0; i<seq.length; i++){
			System.out.println("|=================|");
				System.out.println("| MESURE : "+i+"      |");
			for(int j = 0; j<seq[i].length; j++){
				jouerNote(seq[i][j]);
				System.out.println("|Note : "+ seq[i][j]+"        |");
			}
		}
	}
/**
 * Joue la note avec le Synthétiseur JAVA
 * @param note Note à jouer
 */
	public void jouerNote(int note){
		Synthesizer	synth = null;

		//Gestion des erreurs si le synthétiseur n'est pas disponible
		try{
			synth = MidiSystem.getSynthesizer();
		}
		catch(MidiUnavailableException e){
			e.printStackTrace(); //affiche erreur
			System.exit(1); //ferme le programme
		}

		//Gestion des erreurs si le synthétiseur n'est pas disponible
		try{
			synth.open();
		}
		catch (MidiUnavailableException e){
			e.printStackTrace();
			System.exit(1);
		}

		MidiChannel[] channels = synth.getChannels();
		MidiChannel	channel = channels[0];
		channel.programChange(instrument); // changement d'instrument
		channel.noteOn(note, 127); //commencer a jouer la note

		try{
			Thread.sleep(dureeNote); //pause = durrée de la note
		}
		catch (InterruptedException e){
		}
		channel.noteOff(note);//arreter de jouer la note
		//synth.close();
	}
}

