/**
 * Projet Valine - Thomas Lefebvre, Baptiste Sorin, Corentin Lucas (Groupe 3)
 * Classe Play (Main)
 * Interface utlisateur
 * 
 * @author Corentin LUCAS
 */
 
import java.util.Scanner;

public class Play {
	
	public static void main (String args[]) {

        System.out.println("------------------------------------------------------");
        System.out.println("|##     ##    ###    ##       #### ##    ## ######## |");
        System.out.println("|##     ##   ## ##   ##        ##  ###   ## ##       |");
        System.out.println("|##     ##  ##   ##  ##        ##  ####  ## ##       |");
        System.out.println("|##     ## ##     ## ##        ##  ## ## ## ######   |");
        System.out.println("| ##   ##  ######### ##        ##  ##  #### ##       |");
        System.out.println("|  ## ##   ##     ## ##        ##  ##   ### ##       |");
        System.out.println("|   ###    ##     ## ######## #### ##    ## ######## |");
        System.out.println("|              Sequencer audio Java                  |");
        System.out.println("------------------------------------------------------");
        
		int instrument = 0;
        int longueur = 0;
        int tempo = 0;
        int etendue = 0;
        int mode = 0;
        int octave = 0;
        int note = 0;
        
        
        Scanner sc = new Scanner(System.in);
        
        //Selection de la note
        String[] nIn = {"A","A#","B","C","C#","D","D#","E","F","F#","G","G#"};
        int[] nOut = {0,1,2,3,4,5,6,7,9,10,11,12};
        note = choixString(nIn, nOut, "Choisir note : (A, A#, B, C, C#, D, D#, E, F, F#, G, G#)");
        
        //Selection de l'octave
        octave = choixInt(2, 9, "Choisir l'octave : (2 a 9)");
        
        //Selection du Mode
        String[] mIn = {"majeur","mineur"};
        int[] mOut = {0,1};
        mode = choixString(mIn, mOut, "Choisir mode : (majeur, mineur)");
        
        //Selection de l'étendue
        etendue = choixInt(1, 4, "Choisir l'etendue en octaves : (1 a 4)");
        
        //Selection du tempo
        tempo = choixInt(60, 240, "Choisir le tempo : (60 a 240)");
        
        //Selection de la longueur
        longueur = choixInt(1, 10, "Choisir la longueur de mesures : (1 a 10)");
        
        //Selection de l'instrument
        String[] iIn = {"piano","harmonica","guitare","basse","violon","voix","trompette","flute"};
        int[] iOut = {0,22,29,33,40,52,56,73};
        instrument = choixString(iIn, iOut, "Choisir mode : (piano, harmonica, guitare, basse, violon, voix, trompette, flute)");
        
        System.out.println("########## LECTURE ##########");
        
        Gamme playGamme = new Gamme(mode, note, octave); //Creer gamme
        Sequence playSequence = new Sequence(longueur, etendue, playGamme); //Creer Sequence
        Synth playSynth = new Synth(playSequence, tempo, instrument); //Creer Synthetiseur
        
        playSynth.jouer(); //Jouer la sequence
	}
    
/**
 * Transforme une chaine de caracteres en int avec gestion des erreurs
 * @param arg entree utilisateur
 * @return r valuer entree par l'utilisateur, ou -1 si ar n'est pas un int
 */
    public static int detecterInt(String arg){
            int r = -1;
            // Gestion de l'erreur si une lettre est rentrée
            try{
                r = Integer.parseInt(arg);
            }catch(Exception e){
                System.out.println("!!! Chiffres seulement !!!");
            }
            return r;
    }

/**
 * Gere les entree utilisateur sous forme d'int devant etre compris entre max et un min
 * @param min valeur min minimum desiree
 * @param max valeur max desiree
 * @param desc chaine de caracteres a afficher dans la console
 * @return r int en min et max
 */
    public static int choixInt(int min, int max, String desc){
        Scanner sc = new Scanner(System.in);
        int r =-1; //valeur par defaut
        do{
            System.out.println("-> " + desc + " :"); //interface utilisateur
            r = detecterInt(sc.nextLine()); //lire ce que l'utilisateur entre
            System.out.println("");
        }while(r<min || r>max);
        return r;
    }

/**
 * Transforme les entree utilisateur sous forme de String en int correspondant d'apres les indexes des tableaux
 * @param in tableau de chaines de caracteres a comparer avec entree utilisateur
 * @param out valeur en chiffre des differentes options
 * @param desc chaine de caracteres a afficher dans la console
 * @return r int correspondant a la chaine entree par l'utilisateur
 */
    public static int choixString(String[] in, int[] out, String desc){
        Scanner sc = new Scanner(System.in);
        int r = -1; //valeur par defaut
        String s;
        do{
            System.out.println("-> " + desc + " :"); //interface utilisateur
            s = sc.nextLine(); //lire ce que l'utilisateur entre
            for(int i=0; i<in.length; i++){
                if(s.equalsIgnoreCase(in[i])){ //si l'entree utilisateur correspond a une entre du tableau
                    r = out[i]; //on lui affecte la valeur apprprie
                    break;
                }
            }
        }while(r==-1);
        return r;
    }
}
