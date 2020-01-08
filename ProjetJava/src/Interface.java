import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Interface extends Application  {
	public Scene construireScene() {
		//Initialisation de l'interface
		BorderPane borderPaneRoot = new BorderPane();
		Scene scene = new Scene(borderPaneRoot,350, 150);
		
		//Initalisation du corps de l'interface
		VBox vBox1 = new VBox();
		vBox1.setPadding(new Insets(10));
		HBox hbox1 = new HBox();
		hbox1.setSpacing(10);
		HBox hbox2 = new HBox();
		hbox2.setSpacing(10);
		HBox hbox3 = new HBox();
		hbox3.setSpacing(10);
		
		//Choix de la base
		Label labelNom = new Label("Quel base de donn�es voulez-vous importer ?");
		Label Base = new Label();
		labelNom.setPadding(new Insets(10));
		Base.setPadding(new Insets(10));
		
		final ToggleGroup importation = new ToggleGroup();
		RadioButton rbc= new RadioButton("Climat");
		rbc.setToggleGroup(importation);
		RadioButton rbf= new RadioButton("Foot");
		rbf.setToggleGroup(importation);
		
		//Bouton de validation et lancement d'une fenetre
		Button BV = new Button("Valider");
		BV.setOnAction(new EventHandler<ActionEvent>()
		{
		public void handle(ActionEvent event)
		{
			 if (importation.getSelectedToggle() != null) {
	         	   ToggleButton button = (ToggleButton) importation.getSelectedToggle();
	                //Base.setText("Importation en cours de la base de donn�es sur le " + button.getText());
	                MesTweets.creationBase();
	        		MesTweets.ouvrirBase(button.getText().toLowerCase().concat(".txt"));
	        		//button.getText().toLowerCase().concat(".txt")
	        		
	        		//Initalisation du corps de l'interface
	        		VBox vBox1 = new VBox();
	        		vBox1.setPadding(new Insets(10));
	        		
	        		// Barre de recherche
	        		HBox hbox2 = new HBox();
	        		hbox2.setSpacing(10);
	        		Label labelNom2 = new Label("Recherche :"); 
	        		labelNom2.setPadding(new Insets(5));
	        		TextField text1 = new TextField(); 
	        		hbox2.getChildren().addAll(labelNom2, text1);
	        				
	        		//Crit�res de recherche
	        		HBox hbox3 = new HBox();
	        		hbox2.setSpacing(10);
	        		Label labelNom3 = new Label("Crit�res :"); 
	        		labelNom3.setPadding(new Insets(5));
	        		hbox3.getChildren().addAll(labelNom3);
	        		
	        		
	        		
	        		//Choix de la date
	        		HBox hbox4 = new HBox();
	        		hbox4.setSpacing(10);
	        		Label labelNom4 = new Label("Date "); 
	        		labelNom4.setPadding(new Insets(5));
	        		
	        		ComboBox<String> Date=new ComboBox<String>(); 
	        		ArrayList<String> listed=BaseDeTweets.ListeDate();
	        		Date.getItems().add("Toutes les dates");
	        		for(int i=0;i<listed.size();i++) {
	        			String d=listed.get(i);
	        			Date.getItems().add(d);
	        		}
	        		Date.getSelectionModel().select("Toutes les dates");
	        		
	        		
	        		
	        		hbox4.getChildren().addAll(labelNom4,Date);
	        		
	        		//Choix de l'utilisateur
	        		HBox hbox5 = new HBox();
	        		hbox5.setSpacing(10);
	        		Label labelNom5 = new Label("Utilisateur "); 
	        		labelNom5.setPadding(new Insets(5));
	        		
	        		//Liste d�roulante
	        		ComboBox<String> Utilisateur=new ComboBox<String>(); 
	        		//Liste des utilisateurs
	        		ArrayList<String> listeu=BaseDeTweets.ListeUtilisateur();
	        		//Ajout d'un choix g�n�rique
	        		Utilisateur.getItems().add("Tous les utilisateurs");
	        		//Ajout des utilisateurs � la liste d�roulante
	        		for(int i=0;i<listeu.size();i++) {
	        			String u=listeu.get(i);
	        			Utilisateur.getItems().add(u);
	        		}
	        		//Choix pr�selectionn�
	        		Utilisateur.getSelectionModel().select("Tous les utilisateurs");
	        		
	        		//Ajout de la liste � l'interface
	        		hbox5.getChildren().addAll(labelNom5,Utilisateur);
	        		
	        		
	        		//Choix de l'utilisateur retweet�
	        		HBox hbox6 = new HBox();
	        		hbox6.setSpacing(10);
	        		Label labelNom6 = new Label("Utilisateur retweet� "); 
	        		labelNom6.setPadding(new Insets(5));
	        		
	        		ComboBox<String> Rtutilisateur=new ComboBox<String>(); 
	        		ArrayList<String> listertu=BaseDeTweets.ListeRtutilisateur();
	        		Rtutilisateur.getItems().add("Tous les utilisateurs retweet�s");
	        		for(int i=0;i<listertu.size();i++) {
	        			String u=listertu.get(i);
	        			Rtutilisateur.getItems().add(u);
	        		}
	        		Rtutilisateur.getSelectionModel().select("Tous les utilisateurs retweet�s");
	        		hbox6.getChildren().addAll(labelNom6,Rtutilisateur);
	        		
	        		//Action sur la recherche
	        		HBox hbox8 = new HBox();
	        		hbox8.setSpacing(10);
	        		Label labelNom7 = new Label("Action :"); 
	        		labelNom7.setPadding(new Insets(5));
	        		hbox8.getChildren().addAll(labelNom7);
	        		
	        		//Choix normalisation
	        		HBox hbox9 = new HBox();
	        		hbox9.setSpacing(10);
	        		
	        		//Bouton radio pour la normalisation
	        		final ToggleGroup groupe1 = new ToggleGroup();
	        		RadioButton rb1= new RadioButton("Normalisation bas�e sur la recherche");
	        		rb1.setToggleGroup(groupe1);
	        		
	        		//Bouton radio pour les K-means
	        		final ToggleGroup groupe2 = new ToggleGroup();
	        		RadioButton rb2= new RadioButton("K-Means");
	        		rb2.setToggleGroup(groupe2);
	        		
	        		//Liste d�roulante pour les param�tres de K-means
	        		ComboBox<Integer> nb_c=new ComboBox<Integer>(); 
	        		ComboBox<Integer> nb_i=new ComboBox<Integer>();
	        		Label Classe = new Label("Nombre de classes :");
	        		Label Iterations = new Label("Nombre d'it�rations : ");
	           		
	        		//Ajout des boutons
	        		hbox9.getChildren().addAll(rb1,rb2);
	        		
	        		//Evenement si le bouton K-means est s�lectionn�
	        		groupe2.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
	        			 public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
	        	               if (groupe2.getSelectedToggle() != null) {
	        	            	   
	        	            	   //Liste du choix du nombre de classe
	        	            	   for(int i=2;i<101;i++) {
	        		           			nb_c.getItems().add(i);
	        		           		}
	        		           		nb_c.getSelectionModel().select(1);
	        		           		
	        		           		//Liste du choix du nombre d'it�rations
	        		           		nb_i.getItems().add(1);
	        		           		for(int i=10;i<=100;i=i+10) {
	        		           			nb_i.getItems().add(i);
	        		           		}
	        		           		nb_i.getSelectionModel().select(1);
	        		           		
	        		           		hbox9.getChildren().addAll(Classe,nb_c,Iterations,nb_i);
	        		           		
	        	               }
	        	           }
	        		});
	        		
	        		//Boutton de validation
	        		HBox hbox7 = new HBox();
	        		hbox7.setSpacing(10);
	        		
	        		Button ButtonR = new Button("Valider la recherche");
	        		ButtonR.setOnAction(new EventHandler<ActionEvent>()
	        		{
	        		public void handle(ActionEvent event)
	        		{
	        			
	        			
	        			
	        			//R�cup�ration de tous les tweets
	        			ObservableList<Tweets> list=BaseDeTweets.ListeTweets();
	        			ObservableList<Tweets> temp=FXCollections.observableArrayList();
	        			
	        			//Liste des tweets contenant la recherche
	        			if(text1.getText()!="") {
	        				String recherche_tot = text1.getText();
	        				System.out.println(recherche_tot);
	        				temp=BaseDeTweets.recherche(recherche_tot,1,list);
	        				list=temp;
	        			}
	        			
	        			//Liste des tweets � la date choisie
	        			if(Date.getValue()!="Toutes les dates") {	
	        				String recherche_date = Date.getValue();
	        				temp=BaseDeTweets.recherche(recherche_date,4,list);
	        				list=temp;
	        			}
	        			
	        			//Liste des tweets de l'utilisateur choisi
	        			if(Utilisateur.getValue()!="Tous les utilisateurs") {
	        				String recherche_utilisateur = Utilisateur.getValue();
	        				temp=BaseDeTweets.recherche(recherche_utilisateur,2,list);
	        				list=temp;
	        			}
	        			
	        			//Liste des tweets retweet� d'un utilisateur
	        			if(Rtutilisateur.getValue()!="Tous les utilisateurs retweet�s") {
	        				String recherche_rtutilisateur = Rtutilisateur.getValue();
	        				temp=BaseDeTweets.recherche(recherche_rtutilisateur,3,list);
	        				list=temp;
	        			}
	        			
	        			//Normalisation
	        			if (groupe1.getSelectedToggle() != null & text1.getText()!="") {
	        				
	        				//Cr�ation d'une liste de toutes les listes de mots des tweets
	        				ArrayList<ArrayList<String>> documents = new ArrayList<ArrayList<String>>();
	        				Iterator<Tweets> iter1=list.iterator();
	        		        while(iter1.hasNext())
	        		        {
	        		            Tweets t = iter1.next();
	        		            ArrayList<String> mots=t.getMots();
	        		            documents.add(mots);
	        		            
	        		        }
	        		        
	        		        //Calcul du poids de chaque tweets
	        		        Iterator<Tweets> iter2=list.iterator();
	        		        while(iter2.hasNext())
	        		        { 
	        		            Tweets t = iter2.next();
	        		            ArrayList<String> mots=t.getMots();
	        		            Double p=Normalisation.norm(mots, documents, text1.getText());
	        		            t.setPoids(p);
	        		        }
	        			}
	        			
	        			//K-Means
	        	        if (groupe2.getSelectedToggle() != null) { 
	        	        	ArrayList<Tweets> moy=new ArrayList<Tweets>();
	        	        	
	        	        	//Cas o� la normalisation est selectionn�e
	        	        	boolean select=false;
	        	        	if (groupe1.getSelectedToggle() != null) {select=true;}
	        	        	
	        	        	//Initialisation des centro�des
	        		        KMeans.initialisation(nb_c.getValue(), list, moy);

	        	        	//Pour chaque it�ration : affectation d'une classe
	        	        	ArrayList<Double> dist=new ArrayList <Double>();
	        		        for(int j=0;j<nb_i.getValue();j++) {
	        		        	moy=KMeans.affectation(moy, dist, nb_c.getValue(), list, select);
	        			        
	        		        }
	        	        }
	        			
	        	        //Tableau d'affichage des tweets
	        	        TableView<Tweets> table=new TableView<Tweets>();
	        	        
	        			boolean norm=false;
	        			boolean c=false;
	        			if (groupe1.getSelectedToggle() != null) {norm=true;}
	        			if (groupe2.getSelectedToggle() != null) {c=true;}
	        			table=MesTweets.tab_data(list, norm, c);
	        			//Nouvelle fen�tre pour l'affichage du tableau
	        		    StackPane secondaryLayout = new StackPane();
	        		    secondaryLayout.getChildren().add(table);
	        		    Scene secondScene = new Scene(secondaryLayout, 1500, 1000);
	        		    Stage newWindow = new Stage();
	        		    newWindow.setTitle("R�sultats de la recherche");
	        		    newWindow.setScene(secondScene);
	        		    newWindow.show();
	        		}
	        		});
	        		
	        		//Affichage de toutes les donn�es
	        		Button ButtonV = new Button("Afficher toutes les donn�es");
	        		ButtonV.setOnAction(new EventHandler<ActionEvent>()
	        		{
	        		public void handle(ActionEvent event)
	        		{
	        			//Cr�ation d'un tableau d'affichage des tweets
	        			TableView<Tweets> table=new TableView<Tweets>();
	        	    	
	        			//R�cup�ration des r�sultats de la recherche
	        			ObservableList<Tweets> list=BaseDeTweets.ListeTweets();
	        			table=MesTweets.tab_data(list, false,false);
	        			
	        			//Nouvelle fen�tre pour l'affichage du tableau
	        		    StackPane secondaryLayout = new StackPane();
	        		    secondaryLayout.getChildren().add(table);
	        		    Scene secondScene = new Scene(secondaryLayout, 1500, 1000);
	        		    Stage newWindow = new Stage();
	        		    newWindow.setTitle("Donn�es");
	        		    newWindow.setScene(secondScene);
	        		    newWindow.show();
	        		}
	        		});
	        		//Ajout des boutons
	        		hbox7.getChildren().addAll(ButtonR,ButtonV);
	        		
	        		
	        		// Ajout des hbox dans le vbox
	        		vBox1.getChildren().add(hbox2);
	        		vBox1.getChildren().add(hbox3);
	        		vBox1.getChildren().add(hbox4);
	        		vBox1.getChildren().add(hbox5);
	        		vBox1.getChildren().add(hbox6);
	        		vBox1.getChildren().add(hbox8);
	        		vBox1.getChildren().add(hbox9);
	        		vBox1.getChildren().add(hbox7);
	        		
	        		StackPane recherche = new StackPane();
        		    recherche.getChildren().add(vBox1);
        		    Scene secondScene = new Scene(recherche, 800, 400);
        		    Stage fenetre = new Stage();
        		    fenetre.setTitle("Fouille de tweets: "+button.getText().toLowerCase());
        		    fenetre.setScene(secondScene);
        		    fenetre.show();
	        		
	            }else {
	            	Base.setText("Choisissez une base de donn�es");
	            }
			 
		}
		});
		
		//Ajout des elements � l'interface
		hbox1.getChildren().addAll(labelNom);
		hbox2.getChildren().addAll(rbc,rbf);
		hbox3.getChildren().addAll(BV,Base);
		vBox1.getChildren().add(hbox1);
		vBox1.getChildren().add(hbox2);
		vBox1.getChildren().add(hbox3);
		borderPaneRoot.setCenter(vBox1); 
		
		return scene;
	}
	
	//Afichage de l'interface
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Choix du th�me");
		primaryStage.setScene(construireScene());
		primaryStage.show();
	}

	//Programme principal
	public static void main(String[] args)
	{
		launch(args);
	}
			
}