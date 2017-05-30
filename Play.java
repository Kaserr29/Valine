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
        
        System.out.println("##     ##    ###    ##       #### ##    ## ######## ");
        System.out.println("##     ##   ## ##   ##        ##  ###   ## ##       ");
        System.out.println("##     ##  ##   ##  ##        ##  ####  ## ##       ");
        System.out.println("##     ## ##     ## ##        ##  ## ## ## ######   ");
        System.out.println(" ##   ##  ######### ##        ##  ##  #### ##       ");
        System.out.println("  ## ##   ##     ## ##        ##  ##   ### ##       ");
        System.out.println("   ###    ##     ## ######## #### ##    ## ######## ");
        System.out.println("              Sequencer audio Java                  ");
        System.out.println("");
        
		int instrument = 0;
        int longueur = 0;
        int tempo = 0;
        int etendue = 0;
        int mode = 0;
        int octave = 0;
        int note = 0;
        
        
        Scanner sc = new Scanner(System.in);
        
        //Selection de la note
        do{
            System.out.println("-> Choisir note : (A, A#, B, C, C#, D, D#, E, F, F#, G, G#)");
            note = detecteNote(sc.nextLine());
            System.out.println("");
        }while(note==-1);
        
        //Selection de l'octave
        do{
            System.out.println("-> Choisir l'octaves' : (0 a 9)");
            octave = detecterInt(sc.nextLine());
            System.out.println("");
        }while(etendue<0 || etendue>9);
        
        //Selection du Mode
        do{
            System.out.println("-> Choisir mode : (majeur, mineur)");
            mode = detecteMode(sc.nextLine());
            System.out.println("");
        }while(mode<0 || mode>1));
        
        //Selection de l'étendue
        do{
            System.out.println("-> Choisir l'etendue en octaves' : (1 a 4)");
            etendue = detecterInt(sc.nextLine());
            System.out.println("");
        }while(etendue<1 || etendue>4);
        
        //Selection du tempo
        do{
            System.out.println("-> Choisir le tempo en bpm' : (1 a 240)");
            tempo = detecterInt(sc.nextLine());
            System.out.println("");
        }while(tempo<1 || tempo>240);
        
        //Selection de la longueur
        do{
            System.out.println("-> Choisir la longueur de mesures' : (1 a 10)");
            longueur = detecterInt(sc.nextLine());
            System.out.println("");
        }while(etendue<1 || etendue>10);
        
        //Selection de l'instrument
        do{
            System.out.println("-> Choisir l'instrument : (1 a 127)");
            instrument = detecterInt(sc.nextLine());
            System.out.println("");
        }while(instrument<1 || instrument>127);
        
        System.out.println("########## LECTURE ##########");
        
        Gamme playGamme = new Gamme(mode, note, octave); //Creer gamme
        Sequence playSequence = new Sequence(longueur, etendue, playGamme); //Creer Sequence
        Synth playSynth = new Synth(playSequence, tempo, instrument); //Creer Synthetiseur
        
        playSynth.jouer(); //Jouer la sequence
	}
    
/**
 * Trasforme une chaine de caracteres en int representant ue note midi avec gestion des erreurs
 * @param arg entree utilisateur
 * @return note en notation MIDI
 */
    public static int detecteNote(String arg){
        char[] ref = {'C',' ','D',' ','E','F',' ','G',' ','A',' ','B'}; // Les index correspondent a la note midi 
        int r = -1;
        for(int i = 0; i<ref.length; i++){
            if(arg.charAt(0) == ref[i]){
                r = i+1;
                break;
            }
        }
        if(r!=-1 && !arg.equals(" ") && arg.length()==1){ //si la note n'a ni "#" ni "b"
            r=r;
        }
        else if(r!=-1 && !arg.equals(" ") && arg.length()==2){ //si il y a "#" ou "b"
            if(arg.charAt(1) == '#'){
                r++;
            }
            else if(arg.charAt(1) == 'b'){
                r--;
            }
        }
        else{
            System.out.println("!!! Note non reconnue !!!");
            r=-1;
        }
        return r;
    }
    
/**
 * Transforme chaine de caractere en int represenatant un mode avec gestion des erreurs
 * @param arg entree utilisateur
 * @return int representant un mode
 */
    public static int detecteMode(String arg){
        if(arg.equalsIgnoreCase("majeur")){
            return 0;
        }
        else if(arg.equalsIgnoreCase("mineur")){
            return 1;
        }
        else{
            System.out.println("!!! Mode non reconnu !!!");
            return -1;
        }
    }
    
/**
 * Transforme une chaine de caracteres en int avec gestion des erreurs
 * @param arg entree utilisateur
 * @return int
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
}
