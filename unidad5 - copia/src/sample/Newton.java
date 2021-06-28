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

public class Newton {
    @FXML
    TextField x,x1,x2,x3,x4,f1,f2,f3,f4;
    @FXML
    TextArea textArea;

    public void calcular(ActionEvent event){
        //Cuando hay 4 X y Y
        double b0= Double.parseDouble(f1.getText());
        //b1
        double b1= (Double.parseDouble(f2.getText())-Double.parseDouble(f1.getText()))/
                (Double.parseDouble(x2.getText())-Double.parseDouble(x1.getText()));
        double b1_=(Double.parseDouble(f3.getText())-Double.parseDouble(f2.getText()))/
                (Double.parseDouble(x3.getText())-Double.parseDouble(x2.getText()));
        double b1_1=(Double.parseDouble(f4.getText())-Double.parseDouble(f3.getText()))/
                (Double.parseDouble(x4.getText())-Double.parseDouble(x3.getText()));
        //b2
        double b2= (b1_-b1)/(Double.parseDouble(x3.getText())-Double.parseDouble(x1.getText()));
        double b2_=(b1_1-b1_)/(Double.parseDouble(x4.getText())-Double.parseDouble(x2.getText()));
        //b3
        double b3=(b2_-b2)/(Double.parseDouble(x4.getText())-Double.parseDouble(x1.getText()));
        //fórmula P(x)

        double px=b0+(b1*(Double.parseDouble(x.getText())-Double.parseDouble(x1.getText())))+
                (b2*(Double.parseDouble(x.getText())-Double.parseDouble(x1.getText()))*(Double.parseDouble(x.getText())-Double.parseDouble(x2.getText())))+
                (b3*(Double.parseDouble(x.getText())-Double.parseDouble(x1.getText()))*(Double.parseDouble(x.getText())-Double.parseDouble(x2.getText()))*(Double.parseDouble(x.getText())-Double.parseDouble(x3.getText())));


        //Resultados
        textArea.setText("La Ecuación es:\n"+b0+"+"+b1+"("+"x"+"-"+Double.parseDouble(x1.getText())+")"+"+"+
                b2+"("+"x"+"-"+Double.parseDouble(x1.getText())+")"+"("+"x"+"-"+Double.parseDouble(x2.getText())+")"+"+"+
                b3+"("+"x"+"-"+Double.parseDouble(x1.getText())+")"+"("+"x"+"-"+Double.parseDouble(x2.getText())+")"+"("+"x"+"-"+Double.parseDouble(x3.getText())+")"+
                "\nEl resultado deseado fue:\n"+px);

        textArea.setEditable(false);
    }
    public void grafica(ActionEvent event){
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

        dataSeries1.getData().add(new XYChart.Data( x11, f11));
        dataSeries1.getData().add(new XYChart.Data( x22, f22));
        dataSeries1.getData().add(new XYChart.Data(x33, f33));
        dataSeries1.getData().add(new XYChart.Data(x44, f44));

        lineChart.getData().add(dataSeries1);
        Button btnsalir=new Button("Salir");
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
        VBox vbox = new VBox(lineChart,btnsalir);


        Scene scene = new Scene(vbox,400, 300);

        Main.stage.setScene(scene);
        Main.stage.setHeight(300);
        Main.stage.setWidth(400);

        Main.stage.show();
    }
    public void salir(ActionEvent event) throws IOException {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Has salido");
        alert.show();
            Parent root = FXMLLoader.load(getClass().getResource("./login/login.fxml"));
            Scene scene = new Scene(root);
            Main.stage.setScene(scene);
    }
}
