package org.dnyanyog.productmanagement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SearchProductController extends DBUtil {

    @FXML
    private TextField searchProduct;

    @FXML
    private Label errorMessage;
    
    public void searchProduct() throws SQLException {
	
		String query = "SELECT * From loginscreen.product where productname = '" + searchProduct.getText() + "';";
		
		ResultSet result = DBUtil.resultQuery(query);
		
		if(result.next()) {
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText("Product found!");
		}else {
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Product not found...");
		}
    }
    
    public void back() {
    	new MenuProductScreen().show();
    }
}
