/**
 * Classe Synth
 * Permet de jouer la séquence avec un instrument et un tempo
 * 
 * @author Corentin LUCAS
 */

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;

public class Synth{
	int tempo;
	int instrument;
	Sequence Seq;
	int dureeNote;
	
	public Synth(Sequence s, int t, int i){
		this.tempo = t;
		this.instrument = i;
		this.dureeNote = calculDureeNote(this.tempo);
		this.sequence = s.sequence;
	}
	
/**
 * Joue la sequence en bouble 
 */
	public void jouer(){
		while(true){
			iterSequence(this.sequence);
		}
	}
/**
 * Calcule la durée d'une note en fonction du tempo
 * @param t tempo en bpm
 * @return d durée d'une note en ms
 */
	public int calculDureeNote(int t){
		int d = (int)((60.0/(double)t)*1000);
		System.out.println("TEMPO : "+ t); 
		return d;
	}
/**
 * Parcours la sequence de notes et la fait jouer par le synthetiseur de JAVA
 * @param seq Tableau de la séquence précédement généré
 */
	public void iterSequence(int[][] seq){
		for(int i = 0; i<seq.length; i++){
			for(int j = 0; j<seq[i].length; j++){
				jouerNote(seq[i][j]);
				System.out.println("Playing : "+ seq[i][j]);
			}
		}
	}
/**
 * Joue la note avec le Synthétiseur JAVA
 * @param note Note à jouer
 */
	public void jouerNote(int note){
		Synthesizer	synth = null;

		try{
			synth = MidiSystem.getSynthesizer();
		}
		catch(MidiUnavailableException e){
			e.printStackTrace();
			System.exit(1);
		}

		try{
			synth.open();
		}
		catch (MidiUnavailableException e){
			e.printStackTrace();
			System.exit(1);
		}

		MidiChannel[] channels = synth.getChannels();
		MidiChannel	channel = channels[0];
		channel.programChange(instrument);
		channel.noteOn(note, 127);

		try{
			Thread.sleep(dureeNote);
		}
		catch (InterruptedException e)
		{}
		channel.noteOff(note);
		synth.close();
	}
}

