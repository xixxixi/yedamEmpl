package myapp.chartControl;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart.Series;

public class RootController implements Initializable {
	@FXML
	PieChart pieChart;
	@FXML
	BarChart<String, Integer> barChart; // <ī�װ� ǥ�� Ÿ��, value�� �ش�Ǵ� Ÿ��>
	@FXML
	AreaChart<String, Integer> areaChart;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<Data> pieList = FXCollections.observableArrayList();
		pieList.add(new PieChart.Data("Java", 30));
		pieList.add(new PieChart.Data("HTML", 25));
		pieList.add(new PieChart.Data("JavaScript", 45));

		pieChart.setData(pieList);
		
		// Series = � �����͵��� ���� Ŭ������ ��Ʈ�� ������
		// XYChar << Series1, Series2, Series3... �ø�� �����ϴ� �����Ͱ� �;���
		// Series1 << Data1, Data2, Data3...
		// Serise2 << Data1, Data2, Data3...
		// Serise3 << Data1, Data2, Data3...
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		ObservableList<XYChart.Data<String, Integer>> data1 = FXCollections.observableArrayList();
		data1.add(new XYChart.Data<String, Integer>("�Ӽ���", 30));
		data1.add(new XYChart.Data<String, Integer>("���ؿ�", 20));
		data1.add(new XYChart.Data<String, Integer>("���ն�", 35));
		series1.setData(data1);
		series1.setName("����");
		
		
		XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();
		ObservableList<XYChart.Data<String, Integer>> data2 = FXCollections.observableArrayList();
		data2.add(new XYChart.Data<String, Integer>("�Ӽ���", 35));
		data2.add(new XYChart.Data<String, Integer>("���ؿ�", 22));
		data2.add(new XYChart.Data<String, Integer>("���ն�", 45));
		series2.setData(data2);
		series2.setName("����");
		
		XYChart.Series<String, Integer> series3 = new XYChart.Series<String, Integer>();
		ObservableList<XYChart.Data<String, Integer>> data3 = FXCollections.observableArrayList();
		data3.add(new XYChart.Data<String, Integer>("�Ӽ���", 55));
		data3.add(new XYChart.Data<String, Integer>("���ؿ�", 26));
		data3.add(new XYChart.Data<String, Integer>("���ն�", 33));
		series3.setData(data3);
		series3.setName("����");
		
		barChart.getData().add(series1);
		barChart.getData().add(series2);
		barChart.getData().add(series3);

//		barChart.setData(barList);
	}

}
