package myapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// ��Ʈ��, label, button
		Label label = new Label();
		label.setText("Hello, JavaFX");
		label.setFont(new Font(50));

		Button button = new Button();
		button.setText("Ȯ��");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
			}
		});
		
		// �����̳�
		VBox root = new VBox();
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);

		root.getChildren().add(label);
		root.getChildren().add(button);

		// �����̳ʸ� Scene�� �Ű�������
		Scene scene = new Scene(root);

		// stage�� �Ű������� Scene �޾���
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args); // ���� �޼ҵ尡 ���� �ִ� �Ű���, �Ű������� .launch�� �־���

	}

}
