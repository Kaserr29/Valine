/*
 * Gamme.java
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
// Groupe 3 
// Projet "Valine", par B. SORIN, C. LUCAS, T.LEFEBVRE
// rédacteur de la  classe : T. LEFEBVRE


public class Gamme {
	static int [][] init = { {0,2,4,5,7,9,11},{0,2,3,5,7,8,10} };
	int [] s;
	int mode;
	int tonalite;
	int octave;
	
	public Gamme  (int m, int t, int o)	{
		mode = m;
		tonalite = t;
		octave = o;
	}
	
	public int [] generator ()	{
		
		for (int i = 0 ; i < s.length ; i++) {
			if (mode == 0)	{
				s[i] = init [0][i];
			} else if (mode == 1)	{
				s[i] = init [1][i];
			} 
			s[i] += tonalite;
			s[i] += octave;
		}
	return s;	
	}	
	
	public String toString()	{
		return "Mode : "+this.mode+"; Tonalite : "+this.tonalite+"; Octave ; "+this.octave ;
	}
		
	
}

