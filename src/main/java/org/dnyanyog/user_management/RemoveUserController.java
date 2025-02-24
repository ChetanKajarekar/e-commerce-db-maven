package org.dnyanyog.user_management;

import java.sql.SQLException;

import org.dnyanyog.common.DBUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class RemoveUserController extends DBUtil{
	
	@FXML
	private TextField removeUser;

	@FXML
    private Label errorMessage;
	
	public void removeUser() throws SQLException {
			
		String query = "DELETE FROM loginscreen.user WHERE username = '" + removeUser.getText() + "'";
		
		DBUtil.executeQuery(query);
		
		if((removeUser.getText() != null)) {
			
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText("User removed...");
			
		}else {
			
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Something went wrong...");
			
		}
	}
	
	public void back() {
    	new UserMenu().show();
    }
	
}
