package org.dnyanyog.productmanagement;

import java.sql.SQLException;

import org.dnyanyog.common.DBUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddProductController extends DBUtil  {
    @FXML
    private TextField productId;

    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private TextField productQuantity;

    @FXML
    private Label errorMessage;
    
    public void addProduct() throws SQLException {
    	
		String query = "INSERT INTO loginscreen.product (productid,productname,productprice,productquantity)" + 
				"VALUES('" + productId.getText() + "','" + productName.getText() + "','" +productPrice.getText()+ "','"+ productQuantity.getText() +"');";
		
		DBUtil.executeQuery(query);
		
		if((productId.getText() != null && productName.getText() != null) && (productPrice.getText() != null && productQuantity.getText() != null)) {
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText("Product added successfuly...");
			
		}else {
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Something went wrong...");
			
		}
    }
    
    public void back() {
    	new MenuProductScreen().show();
    }
}
