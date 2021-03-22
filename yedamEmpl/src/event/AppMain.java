package event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		root.setPrefHeight(50);
		root.setPrefWidth(200);
		root.setSpacing(20);

		Button btn1 = new Button("��ư1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) { // EventHandler�� �߻� �޼ҵ�
				System.out.println("��ư1 Ŭ���Ǿ����ϴ�.");
			}

		});

		Button btn2 = new Button("��ư2");
		btn2.setOnAction(event -> System.out.println("��ư2 Ŭ���Ǿ����ϴ�."));

		root.getChildren().add(btn1);
		root.getChildren().add(btn2);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
