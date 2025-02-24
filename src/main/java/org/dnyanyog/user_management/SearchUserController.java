package org.dnyanyog.user_management;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SearchUserController extends DBUtil  {
	@FXML
	private TextField searchUser;

    @FXML
    Label errorMessage;
    
    public void searchUser() throws SQLException {
    	
		String query = "SELECT * From loginscreen.user where username = '" + searchUser.getText() + "';";
		
		ResultSet result = DBUtil.resultQuery(query);
		
		if(result.next()) {
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText(searchUser.getText());
		}else {
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Product not found...");
		}
    }
    
    public void back() {
    	new UserMenu().show();
    }
}
