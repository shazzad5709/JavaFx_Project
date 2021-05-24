package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Hospital3Controller {

    static ObservableList<Hospital> dataList = FXCollections.observableArrayList();
    ArrayList<Hospital> Allinfo = new ArrayList<>();
    @FXML
    private StackPane stkReg; // full stack for registering hospitals
    @FXML
    private Pane pnRegDone; // Register SUCCESSFUL window
    @FXML
    private Button RegDoneToUp;
    @FXML
    private Pane pnReg; // Register window
    @FXML
    private ImageView RegToHos;
    @FXML
    private Button RegToRegDone;
    @FXML
    private StackPane stkHU; // full stack for stkUp(Update info) and pnHos(2nd Mainwindow)
    @FXML
    private StackPane stkUp; // full stack for updating info(pnUp, pnUpDone)
    @FXML
    private Pane pnUpDone; // update SUCCESSFUL window
    @FXML
    private Button UpDoneToTable;
    @FXML
    private Pane pnUp; // update window
    @FXML
    private ImageView UpToHos;
    @FXML
    private Button UpToUpDone;
    @FXML
    private Pane pnHos; // 2nd main window
    @FXML
    private ImageView HosToHome;
    @FXML
    private Button HosToUp;
    @FXML
    private Button HosToReg;
    @FXML
    private Button HosToTable;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLoc;
    @FXML
    private TextField txtKey;
    @FXML
    private TextField txtUpKey;
    @FXML
    private TextField txtICU;
    @FXML
    private TextField txtOxy;
    private Stage stage;
    private Scene scene;
    private Parent root;

// blank kisu jodi thake seta publicly declare kora jabe na

    @FXML
    private void bHosToReg(ActionEvent event) {
        if (event.getSource().equals(HosToReg)) {
            System.out.println("Welcome to Registration Window");
            stkReg.toFront();
            pnReg.toFront();
        }
    }

    @FXML
    private void bHosToUp(ActionEvent event) {
        if (event.getSource().equals(HosToUp)) {
            System.out.println("Welcome to Update Window");
            stkUp.toFront();
            pnUp.toFront();
        }
    }

    @FXML
    private void bHosToTable(ActionEvent event) {
        if (event.getSource().equals(HosToTable)) {
            System.out.println("Show Table");
        }
    }

    @FXML
    private void backToHos(MouseEvent event) {
        System.out.println("Back to 2nd MainWindow");
    }

    @FXML
    public void mHosToHome(MouseEvent mouseEvent) throws IOException {
        System.out.println("Return to 1st MainWindow[ImageViewBack]");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home.fxml")));

        Stage stage = (Stage) (((Node) mouseEvent.getSource()).getScene().getWindow());
        stage.setScene(new Scene(root));
        stage.setTitle("FormView");
        stage.show();
    }

    @FXML
    private void bUpToUpDone(ActionEvent event) {
        updateUserInfo();
        System.out.println("Update DONE!!!");
        pnUpDone.toFront();
    }

    @FXML
    private void mUptoHos(MouseEvent event) {
        System.out.println("Update to 2nd MainWIndow[ImageViewBack]");
        pnHos.toFront();
    }

    @FXML
    private void bRegToRegDone(ActionEvent event) { //registration done page
        System.out.println("Registration DONE!!");
        registerUser();
        pnRegDone.toFront();
    }

    @FXML
    private void mRegToHos(MouseEvent event) {
        System.out.println("Registration to 2nd MainWindow[ImageviewBack]");
        stkHU.toFront();
        pnHos.toFront();
    }

    @FXML
    private void bRegDoneToUp(ActionEvent event) { //return to update info page
        System.out.println("Registration Done!! to 2nd MainWindow*******");
        stkHU.toFront();
        stkUp.toFront();
        pnUp.toFront();
    }


    public void bUpDonetoHos(MouseEvent mouseEvent) {
        System.out.println("Update Done to 2nd MainWindow");
        stkHU.toFront();
        pnHos.toFront();
    }

    public void registerUser() {
        String name = txtName.getText();
        String location = txtLoc.getText();
        String key = txtKey.getText();

        //Hospital h1 = new Hospital(name, location, null, null, key);

        // save info as csv file.
        File f = new File("data.csv");
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("New file created successfully!!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter fw = new FileWriter(f, true);
            System.out.println("Info Added successfully");

            fw.write(name + "," + location + "," + null + "," + null + "," + key + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //dataList.add(h1); //kahini ase

        txtKey.clear();
        txtLoc.clear();
        txtName.clear();
    }

    public void updateUserInfo() {

        String ICU = txtICU.getText();
        String Oxygen = txtOxy.getText();
        String key = txtUpKey.getText();


        // save info as csv file.

        StringBuffer sb = new StringBuffer();
        File f = new File("data.csv");
        if (!f.exists()) {
            try {
                f.createNewFile();
                System.out.println("New file created successfully!!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        String row = "", s = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.csv"));
            while ((s = br.readLine()) != null) {

                String[] parts = s.split(",");
                for (int i = 0; i < 5; i++) {
                    System.out.print(parts[i] + " ");
                }
                System.out.println("KEY: " + key);
                if (parts[4].equals(key)) {
                    System.out.println("Info is updating!!");
                    row += parts[0] + "," + parts[1] + ",";

                    parts[2] = ICU;
                    parts[3] = Oxygen;

                    row += parts[2] + "," + parts[3] + "," + parts[4] + "\n";
                    sb.append(row);
                    System.out.println(row);
                } else {
                    sb.append(s); //goto next line
                    sb.append("\n");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            File file = new File("data.csv");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false));
            pw.print(sb);
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        txtICU.clear();
        txtUpKey.clear();
        txtOxy.clear();

    }
}
