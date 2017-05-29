/*
 * Sequence.java
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


public class Sequence {
	int longueur;
	int etendue;
	int [][] sequence;
	Gamme G;
	
	public Sequence(int l,int e, Gamme g){
		this.longueur= l;
		this.etendue = e;
		this.G = g;
        this.sequence = genererSequence(G);
		
	}
	
	public String toString(){
		String description = "la séquence dure "+longueur+" mesures. Elle s'étend sur "+ etendue+" octaves.";
		return description;
	}
	
	public int[][] genererSequence(Gamme ref){
		int [][]tab = new int[longueur][4];
            for(int i=0;i<tab.length;i++){
                for(int j=0;j<tab[i].length;j++){
                    tab[i][j] = ref.s[(int)(Math.round(Math.random()*(ref.s.length-1)))]+(int)(12*(Math.round(Math.random()*(etendue-1))));
                }
            }
		return tab;
	}
		
		
	
	
	
	
		 
	
}

