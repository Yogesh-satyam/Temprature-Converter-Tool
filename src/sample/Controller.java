package sample;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;
public class Controller implements Initializable {
    public Label welcomeLable;
    public ChoiceBox <String> choiceBox;
    public TextField input;
    public Button convert;
    private static final String C_TO_F_TEXT="Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT="Fahrenheit to Celsius";
    private boolean isC_TO_F=true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(C_TO_F_TEXT,F_TO_C_TEXT);
        choiceBox.setValue(C_TO_F_TEXT);
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            if(t1.equals(C_TO_F_TEXT))
                isC_TO_F=true;
            else
                isC_TO_F=false;
        });
        convert.setOnAction(actionEvent -> convert());
    }
    private void convert() {
        float value=0.0f;
        try {
            value=Float.parseFloat(input.getText());
        }catch (Exception ex){
            warnUser();
            return;
        }
        float res=0.0f;
        if(isC_TO_F){
            res=(value*9/5)+32;
        }else {
            res=(value-32)*5/9;
        }
        display(res);
    }
    private void warnUser() {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show();
    }
    private void display(float res) {
        String unit=(isC_TO_F)?" F":" C";
        System.out.println("The Changed Temperature is: "+res+unit);
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The Changed Temperature is: "+res+unit);
        alert.show();
        input.setText(null);
    }
}
