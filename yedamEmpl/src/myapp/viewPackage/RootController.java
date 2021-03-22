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
				FXCollections.observableArrayList("°¶·°½ÃS1", "°¶·°½ÃS2", "°¶·°½ÃS3", "°¶·°½ÃS4", "°¶·°½ÃS5", "°¶·°½ÃS6", "°¶·°½ÃS7"));

		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tableView.getSelectionModel().select(newValue.intValue());
				tableView.scrollTo(newValue.intValue());
			}
		});

		ObservableList phoneList = FXCollections.observableArrayList(new Phone("°¶·°½ÃS1", "phone01.png"),
				new Phone("°¶·°½ÃS2", "phone02.png"), new Phone("°¶·°½ÃS3", "phone03.png"), new Phone("°¶·°½ÃS4", "phone04.png"),
				new Phone("°¶·°½ÃS5", "phone05.png"), new Phone("°¶·°½ÃS6", "phone06.png"),
				new Phone("°¶·°½ÃS7", "phone07.png"));
		
		TableColumn tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		tcSmartPhone.setStyle("-fx-alignment: CENTER;");
		
		tableView.setItems(phoneList);
		
	}

}
