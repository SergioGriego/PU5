package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Lagrange {
    @FXML
    TextField x,x1, x2, x3, x4, f1, f2, f3, f4;
    @FXML
    TextArea textArea;


    public void calcular(ActionEvent event) {
        double xx=Double.parseDouble(x.getText());
        double x11 = Double.parseDouble(x1.getText());
        double x22 = Double.parseDouble(x2.getText());
        double x33 = Double.parseDouble(x3.getText());
        double x44 = Double.parseDouble(x4.getText());
        double f11 = Double.parseDouble(f1.getText());
        double f22 = Double.parseDouble(f2.getText());
        double f33 = Double.parseDouble(f3.getText());
        double f44 = Double.parseDouble(f4.getText());
        //resolver términos
        double l0,l1,l2,l3;
        l0=((xx-x22)*(xx-x33)*(xx-x44))/((x11-x22)*(x11-x33)*(x11-x44));
        l1=((xx-x11)*(xx-x33)*(xx-x44))/((x22-x11)*(x22-x33)*(x22-x44));
        l2=((xx-x11)*(xx-x22)*(xx-x44))/((x33-x11)*(x33-x22)*(x33-x44));
        l3=((xx-x11)*(xx-x22)*(xx-x33))/((x44-x11)*(x44-x22)*(x44-x33));
        //
        double px;
        px=(f11*l0)+(f22*l1)+(f33*l2)+(f44*l3);
        textArea.setText("Tu resultado deseado es:\n"+px+"\nEcuación:\n"+
                f11+"[(x-"+x22+")(x-"+x33+")(x-"+x44+")"+"\n--------------------------\n"
                +"("+x11+"-"+x22+")("+x11+"-"+x33+")("+x11+"-"+x44+")]\n"+

                "+"+f22+"[(x-"+x11+")(x-"+x33+")(x-"+x44+")"+"\n--------------------------\n"
                +"("+x22+"-"+x11+")("+x22+"-"+x33+")("+x22+"-"+x44+")]\n"+

                "+"+f33+"[(x-"+x11+")(x-"+x22+")(x-"+x44+")"+"\n--------------------------\n"
                +"("+x33+"-"+x11+")("+x33+"-"+x22+")("+x33+"-"+x44+")]\n"+

                "+"+f44+"[(x-"+x11+")(x-"+x22+")(x-"+x33+")"+"\n--------------------------\n"
                +"("+x44+"-"+x11+")("+x44+"-"+x22+")("+x44+"-"+x33+")]\n" );

    }

    public void grafica(ActionEvent event) {
        double x11 = Double.parseDouble(x1.getText());
        double x22 = Double.parseDouble(x2.getText());
        double x33 = Double.parseDouble(x3.getText());
        double x44 = Double.parseDouble(x4.getText());
        double f11 = Double.parseDouble(f1.getText());
        double f22 = Double.parseDouble(f2.getText());
        double f33 = Double.parseDouble(f3.getText());
        double f44 = Double.parseDouble(f4.getText());

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("x");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("y");

        LineChart lineChart = new LineChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Grafica");

        dataSeries1.getData().add(new XYChart.Data(x11, f11));
        dataSeries1.getData().add(new XYChart.Data(x22, f22));
        dataSeries1.getData().add(new XYChart.Data(x33, f33));
        dataSeries1.getData().add(new XYChart.Data(x44, f44));

        lineChart.getData().add(dataSeries1);
        Button btnsalir = new Button("Salir");
        btnsalir.setMaxHeight(25);
        btnsalir.setMaxWidth(50);
        btnsalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("./login/login.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                Main.stage.setScene(scene);
                Main.stage.setHeight(540);
                Main.stage.setWidth(520);
            }
        });
        VBox vbox = new VBox(lineChart, btnsalir);


        Scene scene = new Scene(vbox, 400, 300);

        Main.stage.setScene(scene);
        Main.stage.setHeight(300);
        Main.stage.setWidth(400);

        Main.stage.show();
    }

    public void salir(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Has salido");
        alert.show();
        Parent root = FXMLLoader.load(getClass().getResource("./login/login.fxml"));
        Scene scene = new Scene(root);
        Main.stage.setScene(scene);
    }

    public void add(ActionEvent event) {

    }
}
