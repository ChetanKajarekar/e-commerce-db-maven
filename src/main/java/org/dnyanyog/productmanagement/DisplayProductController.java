package org.dnyanyog.productmanagement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DisplayProductController extends DBUtil {
    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, Integer> columnProductId;

    @FXML
    private TableColumn<Product, String> columnName;

    @FXML
    private TableColumn<Product, String> columnQuantity;

    @FXML
    private TableColumn<Product, String> columnPrice;
    
    @FXML
    private Button back;

    private ObservableList<Product> productList = FXCollections.observableArrayList();

    private void loadDataFromDatabase() throws SQLException {
    	
    	
    	String query = "SELECT * FROM loginscreen.product";
    	
    	ResultSet resultSet = DBUtil.resultQuery(query);
    	
    	while (resultSet.next()) {
    		int productId = resultSet.getInt("productid");
    		String name = resultSet.getString("productname");
    		String quantity = resultSet.getString("productprice");
    		String price = resultSet.getString("productquantity");
    		
    		productList.add(new Product(productId, name, quantity, price));
    	}   
    	
    	productTable.setItems(productList);
    	
    }
    public void initialize() throws SQLException {
        // Set up the columns
        columnProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Load data from the database
        loadDataFromDatabase();
    }

    
    public void back() {
    	new MenuProductScreen().show();
    }
}
