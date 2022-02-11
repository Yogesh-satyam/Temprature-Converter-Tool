package sample;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.Optional;
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        System.out.println("main");
    }
    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("start");
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("Layout.fxml"));
        Pane rootNode = loader.load();
        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.setIconified(true);
        primaryStage.show();
    }
    private MenuBar createMenu(){
        Menu fileMenu=new Menu("File");
        MenuItem newMenuItem=new MenuItem("New");
        newMenuItem.setOnAction(actionEvent -> System.out.println("New item Clicked"));
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitMenuItem=new MenuItem("Quit");
        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
        Menu helpMenu=new Menu("Help");
        MenuItem aboutApp=new MenuItem("About");
        aboutApp.setOnAction(actionEvent -> aboutapp());
        helpMenu.getItems().addAll(aboutApp);
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }
    private void aboutapp() {
        Alert alertDialouge=new Alert(Alert.AlertType.INFORMATION);
        alertDialouge.setTitle("My First Desktop App");
        alertDialouge.setHeaderText("Learning JavaFx");
        alertDialouge.setContentText("This is my first Java App ,I am trying to learn java \n" +
                "This is just a dummy app.Many more to come");
        ButtonType yesBtn=new ButtonType("Yes");
        ButtonType noBtn=new ButtonType("No");
        alertDialouge.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickBtn = alertDialouge.showAndWait();
        if(clickBtn.isPresent()&&clickBtn.get()==yesBtn){
            System.out.println("Yes Button Clicked");
        }else {
            System.out.println("No Button Clicked");
        }
    }
    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop");
    }
}
