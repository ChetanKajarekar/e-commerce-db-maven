package org.dnyanyog.login_page;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtil;
import org.dnyanyog.home.HomeScreen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginScreenController extends DBUtil {
	
	@FXML
	private TextField userName;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button login;

	@FXML
	private Label message;

	
	public void login() throws SQLException  {
		
		
		String query = "SELECT * From loginscreen.login where loginname = '" + userName.getText() + "'and password = '"
				+ password.getText() + "';";
		
		ResultSet result = DBUtil.resultQuery(query);
		
		if(result.next()) {
			message.setTextFill(Color.GREEN);
			message.setText("login successfully...");
		}else {
			message.setTextFill(Color.RED);
			message.setText("login failed...");
		}
		
		new HomeScreen().show();
	}

}
