package org.dnyanyog.productmanagement;

import java.io.IOException;

import org.dnyanyog.common.StageFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SearchProductScreen {
	public void show() {
		
		StageFactory.getStage();
		StageFactory.getStage().setTitle("Search Product");
		
		Parent actorGroup = null;
		try {
			actorGroup = FXMLLoader.load(getClass().getResource("/Product/SearchProduct.fxml"));
		} catch (IOException e) {
			System.out.println("Error while opening SearchProduct.fxml");
			e.printStackTrace();
		}
		
		Scene scene = new Scene(actorGroup);
		StageFactory.getStage().setScene(scene);
		
		StageFactory.getStage().show();
	}
}
