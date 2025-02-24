package org.dnyanyog.user_management;

import java.sql.SQLException;

import org.dnyanyog.common.DBUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddUserController extends DBUtil{
    @FXML
    private TextField emailId;

    @FXML
    private Label errorMessage;

    @FXML
    private TextField password;

    @FXML
    private TextField userId;

    @FXML
    private TextField userName;
    
    public void addUser() throws SQLException {
 		
		String query = "INSERT INTO loginscreen.user (userid,username,emailid,password)" + 
				"VALUES('" + userId.getText() + "','" + userName.getText() + "','" + emailId.getText()+ "','"+ password.getText() +"');";
		
		DBUtil.executeQuery(query);
		
		if((userId.getText() != null && userName.getText() != null) && (emailId.getText() != null && password.getText() != null)) {
			
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText("Product added successfully...");
			
		}else {
			
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Something went wrong...");
			
		}		
    }
    
    public void back() {
    	new UserMenu().show();
    }
}
