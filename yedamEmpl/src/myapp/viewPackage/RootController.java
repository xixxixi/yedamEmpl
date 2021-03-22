package myapp.viewPackage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

public class RootController implements Initializable {
	@FXML
	private ListView<String> listView;
	@FXML
	private TableView<Phone> tableView;
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listView.setItems(
				FXCollections.observableArrayList("������S1", "������S2", "������S3", "������S4", "������S5", "������S6", "������S7"));

		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tableView.getSelectionModel().select(newValue.intValue());
				tableView.scrollTo(newValue.intValue());
			}
		});

		ObservableList phoneList = FXCollections.observableArrayList(new Phone("������S1", "phone01.png"),
				new Phone("������S2", "phone02.png"), new Phone("������S3", "phone03.png"), new Phone("������S4", "phone04.png"),
				new Phone("������S5", "phone05.png"), new Phone("������S6", "phone06.png"),
				new Phone("������S7", "phone07.png"));
		
		TableColumn tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		tcSmartPhone.setStyle("-fx-alignment: CENTER;");
		
		tableView.setItems(phoneList);
		
	}

}
