# Valine
*N.B : les termes en italique sont expliqués (si besoin) en annexe.*

Le projet “Valine” a pour objectif de permettre à l’Utilisateur de générer une mélodie, grâce au synthétiseur de JAVA (librairie Javax.sound.midi). L’Utilisateur pourra choisir plusieurs paramètres pour générer sa séquence de notes. Ensuite, le programme s'exécute et donne une séquence de notes finale que l’Utilisateur entend une fois le programme exécuté.
L’intérêt est, pour l’Utilisateur, d’être aidé par exemple dans la composition musicale, ou pour savoir rapidement à quoi pourrait ressembler une mélodie selon ses désirs.
Quels sont les paramètres accessibles à l’Utilisateur ?
Pour générer sa séquence, l’Utilisateur devra régler différents paramètres, avant que le programme s’exécute. Comme paramètres, nous avons retenus :
'''
Le type d’instrument (la librairie contient en effet plusieurs sons différents)
Le tempo de la séquence
La tonalité de la séquence
Octave
Le type de gamme
Etendue d’octaves que Väline peut utiliser
La longueur de la séquence (en mesure)
'''

##  A quoi ressemblera la séquence de notes ?

Väline sera programmé pour générer une séquence de noires dont la hauteur de la note est définie aléatoirement. Il y aura donc 4 notes par mesure.
Comment la séquence sera-t-elle générée et jouée ?
L’utilisateur pourra entrer les différents paramètres sur lesquels il souhaite influer depuis la console avec la forme suivante : “C#0 mineur 2 120 4 piano”, avec dans l’ordre, 'tonalite' et 'octave', 'mode', 'etendue', 'tempo', 'longueur', 'instrument'.
La classe Gamme permettra, à partir du tableau 2D mode, de générer la gamme demandé par l’utilisateur.
La classe Sequencer génère une séquence de notes aléatoires d’après les paramètres entrés par l’utilisateur et la gamme précédemment générée.
La classe Synthétiseur utilise la libraire Javax.sound.midi (nativement présente) afin de jouer la séquence précédemment généré, tempo et avec l’instrument voulu par l’utilisateur.

##  Améliorations possibles
  
Il pourrait être intéressant d’ajouter un système de probabilité au séquenceur, en effet certains intervalles entre 2 notes sont plus communs que d’autre et pourrait rendre la séquence plus cohérente et musical.
On pourrait également rajouter un système de la gestion de la vélocité, c’est à dire l’intensité avec laquelle chaque note et joué afin de, encore une fois, rendre le tout plus musical.

##  ANNEXE : Théorie musicale et protocole MIDI

Ton : “unité de mesure”, de la différence sonore entre deux notes,  dans la musique occidentale actuelle. 
*Exemple : entre Do et Ré, il y a un ton. Mais entre Mi et Fa, il y a un demi-ton.*

Tonalité : La tonalité d’un morceau de musique est l’organisation des notes selon une gamme. Ainsi, les notes jouées respecte des écarts de notes précis.

Format MIDI : Outil permettant “d’informatiser” l’unité de mesure qu’est le demi-ton.
La notation MIDI va de 0 à 127, et à chaque nombre correspond une note du clavier. Ainsi, Väline ne prendra pas de “Do” ou de “Sol”, mais plutôt des chiffres allant de 0 à 127, correspondant aux fréquences des notes correspondant
*Exemple: 57 correspond au célèbre “La 440Hz”*

Gamme : Série de notes organisées selon un mode. Exemple : pour la gamme de Do Majeur, les notes sont :
Do - Ré - Mi - Fa - Sol - La - Si - Do ; les écarts entre chaque note est alors (en ton) :
     1      1    ½      1      1     1     ½
Remarque : les écarts de note d’un mode, ne dépende pas de la tonalité !
Les écarts sont donc les même pour une gamme de Sol Majeur ou Do Majeur. 

Octave : Écart entre 2 notes de même nom(ex. un Do “grave” et un Do “aigu”, cf dessin ci-dessus). Une octave correspond toujours à un écart de 12 demi-tons (il y a en effet, 12 notes qui séparent le Do grave du Do aigu sur le dessin ci-dessus).
Remarque : un des paramètres de Väline est l’étendue d’octave, c’est à dire le nombre d’octave que peut utiliser Väline pour créer la séquence, soit toutes les notes contenues dans cet intervalle d’octaves.
