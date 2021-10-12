package se.iths.javafx.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class HelloController {

    Model model;

    public TextField textField1;
    public Canvas canvas;

    @FXML
    private Label welcomeText;
    @FXML
    private CheckBox checkbox1;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Checkbox: " + checkbox1.isSelected());
    }

    public void initialize(){
        model = new Model();


        textField1.setText("Hej");
        textField1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                textField1.setText(oldValue);
            }
        });
    }

    public void onCheckBoxChecked() {
      // if( actionEvent.getSource() == checkbox1)
           welcomeText.setText("Checkbox: " + checkbox1.isSelected());
    }

    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX() + ":" + mouseEvent.getY());
        System.out.println(mouseEvent.getScreenX() + ":" + mouseEvent.getScreenY());
    }

    public void keyTyped(KeyEvent keyEvent) {
        System.out.println(keyEvent.getCharacter());
        String text = textField1.getText();
        if(text.length() > 5)
            textField1.setText(text.substring(0, text.length() -1));
    }

    public void canvasClicked(MouseEvent mouseEvent) {
        var context = canvas.getGraphicsContext2D();
        context.fillOval(mouseEvent.getX(),mouseEvent.getY(), 25,25);
    }
}