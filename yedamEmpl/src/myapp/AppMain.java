package myapp;

import java.awt.Font;
import java.awt.event.ActionEvent;

import org.graalvm.compiler.phases.common.NodeCounterPhase.Stage;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import jdk.tools.jlink.internal.Platform;

public class AppMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 컨트롤, label, button
		Label label = new Label();
		label.setText("Hello, JavaFX");
		label.setFont(new Font(50));

		Button button = new Button();
		button.setText("확인");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Platform.exit();
			}
		});
		
		// 컨테이너
		VBox root = new VBox();
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);

		root.getChildren().add(label);
		root.getChildren().add(button);

		// 컨테이너를 Scene의 매개값으로
		Scene scene = new Scene(root);

		// stage의 매개값으로 Scene 달아줌
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args); // 메인 메소드가 갖고 있는 매개값, 매개변수를 .launch에 넣어줌

	}

}
