/** 
 * Projet Valine - Thomas LEFEBVRE, Baptiste SORIN, Corentin LUCAS (Groupe 3 )
 * Classe Gamme
 * Permet de créer un tableau 1D contenant les notes de la gamme
 * 
 * @author Thomas LEFEBVRE
 */


public class Gamme {
	static int [][] init = {{0,2,4,5,7,9,11},{0,2,3,5,7,8,10}};
	int [] s;
	int mode;
	int tonalite;
	int octave;
	
	public Gamme  (int m, int t, int o)	{
		mode = m;
		tonalite = t;
		octave = o;
		s = generator();
		
	}
	
/** 
 * Crée le tableau 1D contenant les notes de la gamme (au format MIDI)
 * @param mode Majeur (valeur 0) ou Mineur (valeur 1)
 * @param tonalite (de 0 = Do à 11 = Si)
 * @param octave (de 0 = première octave à 
 */
	public int [] generator ()	{
		int [] a = {0,0,0,0,0,0,0};
		for (int i = 0 ; i < a.length ; i++) {
			a[i] = init [mode][i];			
			a[i] += tonalite;
			a[i] += 12*octave;
		}
		return a;
	}
/** 
 * Permet d'afficher le contenu du tableau, c'est à dire les valeurs des notes (de 0 & 127, format MIDI)
 */
	public String afficheString(int[] a)	{
		String r = "";
		for (int i=0 ; i<a.length ; i++)	{
				r += a[i] +" | ";
			}
		return r;
	}
	
/** 
 * Permet de tester le fonctionnement de la classe Gamme (inutile pour l'execution générale du programme)
 */
	public String toString()	{
		return "Gamme : "+afficheString(s);
	}
}

