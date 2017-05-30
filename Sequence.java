/**
 * Projet Valine -Thomas LEFEBVRE, Baptiste SORIN, Corentin LUCAS
 * Classe Sequence
 * cree une sequence de notes a partir d'une gamme 
 * 
 * @author Baptiste SORIN
 */


public class Sequence {
	int longueur;
	int etendue;
	int [][] sequence;
	Gamme G;
	
	public Sequence(int l,int e, Gamme g){
		//la longueur est le nombre de mesure que dure la sequence.
		this.longueur= l;
		//l'etendue est le nombre d'octave sur lequel s'etend la séquence.
		this.etendue = e;
		//G est la gamme entree en parametre
		this.G = g;
        this.sequence = genererSequence(G);
		
	}
	
/**
 * genere une note aleatoire de la gamme en parametre
 * @param ref detype gamme : gamme dont on tire la note.
 * @return note un int qui correspond a une note de la gamme en MIDI
 */
	public int noteAleat(Gamme ref){
		//la note est contenu dans s, tableau de ref. l'index de la note est aleatoire
		int index =(int)(Math.round(Math.random()*(ref.s.length-1)));
		//On ajoute a la note un nombre aleatoire d'octave
		int note =ref.s[index]+(int)(12*(Math.round(Math.random()*(etendue-1))));
		return note;
	}

	
/**
* génere un tableau 2D de note en MIDI à partir d'une gamme donnée en parametre.
* @param ref  de type gamme : gamme a partir de laqelle la sequence est generee.
* @return tab tableau 2D avec un int correspondant a une note de la gamme dans chaque case.
*/
	public int[][] genererSequence(Gamme ref){
		//tab est un tableau 2D. Ily a 4 notes par mesure 
		int [][]tab = new int[longueur][4];
            for(int i=0;i<tab.length;i++){
                for(int j=0;j<tab[i].length;j++){
                    //chaque case du tableau tab prend une valeur indexée aléatoirement du tableau ref 
                    tab[i][j] = noteAleat(ref);
                }
            }
		return tab;
	}
		
		
	
	
	
	
		 
	
}

