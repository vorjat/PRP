package serwis;

import java.awt.Label;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.nio.file.Files;

public class SController {

	ObservableList<Obraz> data = FXCollections.observableArrayList();
	// new Obraz("1", "2", "3", "4", "5", "6", "7", "8", "9")
	Stage stage2;
	Stage stage3;
	Stage stage4;
	@FXML
	Button bAnuluj;
	@FXML
	Button bDalej;
	@FXML
	Button sciechaButton;
	@FXML
	TextField sciechaText;
	@FXML
	TableView<Obraz> Obrazy;
	@FXML
	TableColumn<Obraz, String> colTytul;
	@FXML
	TableColumn<Obraz, String> colAutor;
	@FXML
	TableColumn<Obraz, String> colKsztalt;
	@FXML
	TableColumn<Obraz, String> colWysokosc;
	@FXML
	TableColumn<Obraz, String> colSzerokosc;
	@FXML
	TableColumn<Obraz, String> colPromien;
	@FXML
	TableColumn<Obraz, String> colPowierzchnia;
	@FXML
	TableColumn<Obraz, String> colWaga;
	@FXML
	TableColumn<Obraz, String> colCena;
	@FXML
	MenuItem itemPlikWczytaj;
	@FXML
	MenuItem itemPokazAdder;
	@FXML
	TextField adderTytul;
	@FXML
	TextField adderAutor;
	@FXML
	TextField adderKsztalt;
	@FXML
	TextField adderWysokosc;
	@FXML
	TextField adderSzerokosc;
	@FXML
	TextField adderPromien;
	@FXML
	TextField adderWaga;
	@FXML
	TextField adderCena;
	@FXML
	Button adderButton;
	@FXML
	TextField adderSciecha;
	@FXML
	Button koniecButton;
	@FXML
	Button zamknijButton;
	@FXML
	MenuItem itemWyczysc;

	@FXML
	private void bAnulujAction(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void bDalejAction(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/MainWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			stage2 = new Stage();
			// stage2.initModality(Modality.APPLICATION_MODAL);
			// stage2.initStyle(StageStyle.UNDECORATED);
			stage2.setTitle("Serwis Aukcyjny");
			stage2.setScene(new Scene(root1));
			stage2.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*@FXML
	private void TestBAction(ActionEvent event) {

		data.add(new Obraz("1", "2", "3", "4", "5", "6", "7", "8", "9"));
		data.add(new Obraz("1", "2", "3", "4", "5", "6", "7", "8", "9"));

		RefreshTable();
		
		 * colTytul.setCellValueFactory(new PropertyValueFactory<Obraz,
		 * String>("tytul")); colAutor.setCellValueFactory(new
		 * PropertyValueFactory<Obraz, String>("autor"));
		 * colKsztalt.setCellValueFactory(new PropertyValueFactory<Obraz,
		 * String>("ksztalt")); colWysokosc.setCellValueFactory(new
		 * PropertyValueFactory<Obraz, String>("wysokosc"));
		 * colSzerokosc.setCellValueFactory(new PropertyValueFactory<Obraz,
		 * String>("szerokosc")); colPromien.setCellValueFactory(new
		 * PropertyValueFactory<Obraz, String>("promien"));
		 * colPowierzchnia.setCellValueFactory(new PropertyValueFactory<Obraz,
		 * String>("powierzchnia")); colWaga.setCellValueFactory(new
		 * PropertyValueFactory<Obraz, String>("waga"));
		 * colCena.setCellValueFactory(new PropertyValueFactory<Obraz,
		 * String>("cena")); Obrazy.setItems(data);
		 
	}*/

	@FXML
	private void sciechaButtonAction(ActionEvent event) throws IOException {
		
		 FileChooser fileChooser = new FileChooser(); File selectedFile =
		 fileChooser.showOpenDialog(stage2); if (selectedFile != null) {
		 sciechaText.setText(selectedFile.getAbsolutePath()); String temp =
		 sciechaText.getText();
		 
		//String temp = "/home/users/pjarek2/Obrazy/test1.txt";
		HashMap<String, String> map = new HashMap<String, String>();
		BufferedReader reader = new BufferedReader(new FileReader(temp));

		File file = new File(temp);
		int count = 0;
		Scanner sc = new Scanner(file);

		String[] words = new String[0];
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			words = line.split(";");
			
			double powierzchnia = 0;
			String powierzchniaS = "";
			if (words[2].equals("Okrąg")) {
				powierzchnia = 3.14 * Double.parseDouble(words[5]) *2;
			} else {
				powierzchnia = Double.parseDouble(words[3]) * Double.parseDouble(words[4]);
			}
			
			powierzchniaS = String.valueOf(powierzchnia);
			try{
			
			data.add(new Obraz(words[0], words[1], words[2], words[3], words[4], words[5], powierzchniaS, words[7],words[8]));
			} catch(Exception e) {
			System.out.println(words[0]);
			System.out.println(words[1]);
			System.out.println(words[2]);
			System.out.println(words[3]);
			System.out.println(words[4]);
			System.out.println(words[5]);
			System.out.println(words[6]);
			System.out.println(words[7]);
			System.out.println(words[8]);
			}
			count++;
		}

	
		refreshTable();
		 }

	}
	
	private void refreshTable() {
		colTytul.setCellValueFactory(new PropertyValueFactory<Obraz, String>("tytul"));
		colAutor.setCellValueFactory(new PropertyValueFactory<Obraz, String>("autor"));
		colKsztalt.setCellValueFactory(new PropertyValueFactory<Obraz, String>("ksztalt"));
		colWysokosc.setCellValueFactory(new PropertyValueFactory<Obraz, String>("wysokosc"));
		colSzerokosc.setCellValueFactory(new PropertyValueFactory<Obraz, String>("szerokosc"));
		colPromien.setCellValueFactory(new PropertyValueFactory<Obraz, String>("promien"));
		colPowierzchnia.setCellValueFactory(new PropertyValueFactory<Obraz, String>("powierzchnia"));
		colWaga.setCellValueFactory(new PropertyValueFactory<Obraz, String>("waga"));
		colCena.setCellValueFactory(new PropertyValueFactory<Obraz, String>("cena"));
		Obrazy.setItems(data);
	}
	@FXML
	private void adderButtonAction (ActionEvent event) throws IOException {
		//double pow = 0;
		String tytulA = adderTytul.getText();
		String autorA = adderAutor.getText();
		String ksztaltA = adderKsztalt.getText();
		String wysokoscA = adderWysokosc.getText();
		String szerokoscA = adderSzerokosc.getText();
		String promienA = adderPromien.getText();
		String powierzchniaA = "-";
		String wagaA = adderWaga.getText();
		String cenaA = adderCena.getText();
		
		/*if (ksztaltA.equals("Okrąg")) {
			pow = 3.14 * Double.parseDouble(promienA) *2;
		} else {
			pow = Double.parseDouble(wysokoscA) * Double.parseDouble(szerokoscA);
		}
		
		powierzchniaA = String.valueOf(pow);
		data.add(new Obraz(tytulA, autorA,ksztaltA,wysokoscA,szerokoscA,promienA,powierzchniaA,wagaA,cenaA));*/
		
		String toFile = tytulA +";"+autorA+";"+ksztaltA+";"+wysokoscA+";"+szerokoscA+";"+promienA+";"+powierzchniaA+";"+wagaA+";"+cenaA;
		
		File file = new File(adderSciecha.getText());
		
		
		Writer output;
		output = new BufferedWriter(new FileWriter(file, true));  //clears file every time
		output.append(toFile);
		output.close();
		
		
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
		
	}
	@FXML
	private void itemPokazAdderAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/DodawaczObrazow.fxml"));
			Parent root2 = (Parent) loader.load();
			stage3 = new Stage();
			stage3.setTitle("Dodaj obraz");
			stage3.setScene(new Scene(root2));
			stage3.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@FXML
	private void koniecButtonAction(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Koncowe.fxml"));
			Parent root3 = (Parent) loader.load();
			stage4 = new Stage();
			stage4.setTitle("Koniec");
			stage4.setScene(new Scene(root3));
			stage4.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();	
	}
	
	@FXML
	private void zamknijButtonAction(ActionEvent event) {
		Node source = (Node) event.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		stage.close();
	}
	@FXML
	private void itemWyczyscAction(ActionEvent event) {
		Obrazy.getItems().clear();
		refreshTable();
	}
	
}
