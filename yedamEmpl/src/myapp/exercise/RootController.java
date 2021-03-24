package myapp.exercise;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import common.InputBoardVo;
import common.InputDAO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
	@FXML
	TableView<Student> table;
	@FXML
	TableColumn<Student, String> name;
	@FXML
	TableColumn<Student, Integer> ko;
	@FXML
	TableColumn<Student, Integer> math;
	@FXML
	TableColumn<Student, Integer> eng;
	@FXML
	Button addBtn, btnReg, btnCancel;

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				addBtnAction(e);
			}

		});

	}

	public void addBtnAction(ActionEvent e) {
		Stage stage = new Stage(StageStyle.DECORATED);
		stage.initModality(Modality.WINDOW_MODAL); // 모달 타입의 윈도우 : 새로 띄운 창은 그 창이 닫히기 전에 다른 창으로 포커스 이동 X
		stage.initOwner(primaryStage);

		BorderPane bp;
		try {
			bp = FXMLLoader.load(getClass().getResource("form.fxml"));
			Scene scene = new Scene(bp);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
