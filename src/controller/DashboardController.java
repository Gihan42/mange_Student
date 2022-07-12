package controller;

import crudutil.CrudUtil;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardController {

    public Button btnsave;
    public Button btnsave1;
    public Button btnsave11;
    public TextField txtSearchStudent;

    public TableView tblStudent;
    public TableColumn colemail;
    public TableColumn colid;
    public TableColumn colname;
    public TableColumn colAddress;
    public TableColumn colcontact;
    public TableColumn colnic;

    public TextField txtName;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtContact;
    public Label lblstudentid;
    public TextField txtNic;

    public  void initialize(){

    }

    public void SearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet resultSet = CrudUtil.execute
                    ("SELECT * FROM  Customer WHERE c_nic=?", txtSearchStudent.getText());
            if (resultSet.next()) {
                txtName.setText(resultSet.getString(2));
                txtEmail.setText(resultSet.getString(3));
                txtContact.setText(resultSet.getString(4));
                txtAddress.setText(resultSet.getString(5));
                txtNic.setText(resultSet.getString(6));

            } else {
                new Alert(Alert.AlertType.ERROR, "EMPTY RESULT").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Student c =new  Student(
                lblstudentid.getText(),
                txtName.getText(),
                txtEmail.getText(),
                txtContact.getText(),
                txtAddress.getText(),
                txtNic.getText()
        );
        try {
            if ( CrudUtil.execute("Insert into Student Values(?,?,?,?,?,?)",
                    c.getSId(),c.getSName(),c.getEMail(),c.getContact(),c.getAddress(),c.getNic())){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Saved").show();
               /* generateOrderId();
               lblstudentid.setText(generateOrderId());*/
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Please Try Again").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }
    public String generateOrderId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM Student ORDER BY id DESC LIMIT 1");
        if (resultSet.next()) {
            String oldId = resultSet.getString(1);
            String substring = oldId.substring(1, 4);
            int intId = Integer.parseInt(substring);

            intId = intId + 1;
            if (intId < 10) {
                return "O00" + intId;
            } else if (intId < 100) {
                return "O0" + intId;
            } else if (intId < 1000) {
                return "O" + intId;
            }
        }
        return "O001";
    }
}
