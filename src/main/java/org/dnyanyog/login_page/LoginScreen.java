package org.dnyanyog.login_page;

import java.io.IOException;

import org.dnyanyog.common.StageFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginScreen {
	
	public void show() {
		
		StageFactory.getStage();
		StageFactory.getStage().setTitle("Customer Login");
		
		Parent actorGroup = null;
		try {
			actorGroup = FXMLLoader.load(getClass().getResource("/login/LoginPage.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene scene = new Scene(actorGroup);
		StageFactory.getStage().setScene(scene);
		
		StageFactory.getStage().show();
	}

}
