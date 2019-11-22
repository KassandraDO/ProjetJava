import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MesTweets {
	// collec : contient l'ensemble des articles d'actualit�
    private static BaseDeTweets collec = null;

    //Programme principal
    public static void main(String[] args) {
        boucle();
    }
    
    //Affichage des options du menu 
    public static void Menu()
    {
       System.out.println("--- Liste des possibilit�s ---");
       System.out.println("1. Cr�er une nouvelle base d'actualit�s");
       System.out.println("2. Ouvrir une base d'actualit�s");
       System.out.println("3. Sauvegarder la base d'actualit�s");
       System.out.println("4. Afficher toutes les actualit�s");
       System.out.println("5. Ins�rer une nouvelle actualit�");
       System.out.println("6. Supprimer une actualit�");
       System.out.println("7. Rechercher une actualit�");
       System.out.println("8. Quitter");        
    }
    
    //Affichage en boucle du menu avec les fonctions associ�es
    public static void boucle()
    {        
        int num = 0;
        do {
            Menu();
            System.out.print("Choix: ");
            Scanner scan = new Scanner(System.in);
            num = scan.nextInt();
            switch (num)
            {
                case 1: creationBase();
                    break;
                case 2: ouvrirBase();
                    break;                    
                case 3: sauvegarderBase();
                    break;                    
                case 4: affichage();
                    break;    
                case 5: insererTweets();
                    break;
                case 6: suppression();
                    break;
                case 7: rechercher();
                    break;                   
            }
        } while (num != 8);
        System.out.println("Fin du programme");
    }
    
    //Cr�ation d'une base
    public static void creationBase()
    {
        System.out.println(" --- Creation d'une base d'articles --- ");	
        collec = new BaseDeTweets();
    }
    
    //Appel � l'insertion d'une news
    public static void insererTweets(Tweets t)
    {
        collec.insertTweets(t);
    }
    
    //Collecte des informations + insertion
    public static void insererTweets()
    {
    	Scanner scanti = new Scanner(System.in);
        System.out.print("Veuillez entrer un id : ");
        Integer id = scanti.nextInt();
        
        Scanner scanu = new Scanner(System.in);
        System.out.print("Veuillez entrer un nom d'utilisateur : ");
        String utilisateur = scanu.nextLine();
        
        Scanner scant = new Scanner(System.in);
        System.out.print("Veuillez entrer le contenu du tweet : ");
        String texte = scant.nextLine();
        
        Scanner scand = new Scanner(System.in);
        System.out.print("Veuillez entrer une date au format jj-mm-aaaa : ");
        String d = scand.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        LocalDate date = LocalDate.now(); // par d�faut
        try
        {
            date = LocalDate.parse(d, formatter);
        } catch (DateTimeParseException e) { }
       
        Scanner scanr = new Scanner(System.in);
        System.out.print("Veuillez entrer un nom d'utilisateur retweet� : ");
        String rtid = scanr.nextLine();
        
        Tweets t=new Tweets(id,date,utilisateur,texte,rtid);
        
    }    
    
    //Suppression d'une news
    public static void suppression()
    {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Quelle actualit� voulez-vous supprimer ?");
        int i = scan.nextInt();
        collec.supprimerNews(i);
    }
    
    //Affichage de la base
    public static void affichage()
    {
        System.out.println(collec);
    }

    //R�cup�ration d'une base
    public static void ouvrirBase() {
        System.out.println(" --- Lecture des actualit�s --- ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Veuillez entrer le nom pour la base : ");
        String nom = scan.nextLine();
        collec.lecture(nom);
    }

    //Sauvegarde d'une base
    public static void sauvegarderBase() {
        System.out.println(" --- Sauvegarde des actualit�s --- ");
        Scanner scan = new Scanner(System.in);
        System.out.print("Veuillez entrer le nom pour la base : ");
        String nom = scan.nextLine();
        collec.enregistrer(nom);
        
    }

    //Requ�tage
    public static void rechercher()
    {
    	
    	Scanner scan = new Scanner(System.in);
        System.out.println("Votre requ�te : ");
        String mot = scan.nextLine();
        collec.recherche(mot);
    }
    
}
