/*
 * Synth.java
 * 
 * Copyright 2017 Lucas Corentin <clucas@pc107-043-07>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;

public class Synth{
	int tempo;
	Sequence Seq;
	int[][] sequence;
	int dureeNote;

	public Synth(Sequence s, int t){
		this.tempo = t;
		this.dureeNote = calculDureeNote(this.tempo);
		this.sequence = s.sequence;
	}
	
/**
 * /!\TEMPORAIRE/!\ Joue la sequence en bouble 
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
		System.out.println("TEMPO : "+ d); 
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

