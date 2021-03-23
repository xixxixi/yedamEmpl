package myapp.viewPackage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

public class RootController implements Initializable {
	@FXML
	private ListView<String> listView;
	@FXML
	private TableView<Phone> tableView;
	@FXML
	private ImageView imageView;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		listView.setItems(	// list�� ����ִ� �޼ҵ�
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

//		TableColumn tcSmartPhone = tableView.getColumns().get(0);
//		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
//		tcSmartPhone.setStyle("-fx-alignment: CENTER;");
		
		TableColumn<Phone, String> tcSmartPhone = (TableColumn<Phone, String>) tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new Callback<CellDataFeatures<Phone, String>, ObservableValue<String>>(){
			@Override
			public ObservableValue<String> call(CellDataFeatures<Phone, String> param) {
				return param.getValue().smartPhoneProperty();
			}
		});	// Callback �޼ҵ� ���
		
		TableColumn tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		tcImage.setStyle("-fx-alignment: CENTER;");

		tableView.setItems(phoneList);

		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {
			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldVlaue, Phone newValue) {
				if (newValue != null) {
					imageView.setImage(new Image(getClass().getResource("/images/" + newValue.getImage()).toString()));
				}
			}

		});

	}

	public void handleBtnOkAction(ActionEvent e) {
		String item = listView.getSelectionModel().getSelectedItem();
		System.out.println("ListeView ����Ʈ��: " + item);

		Phone phone = tableView.getSelectionModel().getSelectedItem();
		System.out.println("TableView ����Ʈ��: " + phone.getSmartPhone());
		System.out.println("TableView �̹���: " + phone.getImage());
	}

	public void handleBtnCancelAction(ActionEvent e) {
		Platform.exit();
	}

}
