import java.util.Scanner;

public class MesTweets {
	// collec : contient l'ensemble des articles d'actualit�
    private static BaseDeTweets collec = null;

    //Programme principal
    public static void main(String[] args) {
    	//creationBase();
    	//ouvrirBase();
    }
    
    //Cr�ation d'une base
    public static void creationBase()
    {
        collec = new BaseDeTweets();
    }
    
    //Affichage de la base
   /* public static void affichage()
    {
        System.out.println(collec);
    }
    */
    
    //R�cup�ration d'une base
    public static void ouvrirBase(String base) {
        System.out.println(" --- Chargement de la base: --- ");
        //Scanner scan = new Scanner(System.in);
        //System.out.print("Veuillez entrer le nom pour la base : ");
        //String nom = scan.nextLine();
        collec.lecture(base);
    }
   
    //Requ�tage
    public static void rechercher(String recherche)
    {
    	//Scanner scan = new Scanner(System.in);
        //System.out.println("Votre requ�te : ");
        //String mot = scan.nextLine();
        collec.recherche(recherche);
    }
    
}