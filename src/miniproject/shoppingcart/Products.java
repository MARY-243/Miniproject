package miniproject.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Products {
	private final List<Product> products = new ArrayList<Product>();

    public Products () {
        this.storeItems();
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public void storeItems() {
        String [] productNames = {"Headphones","TV","Laptop","Watch","SmartPhone","Keyboard","Speaker","Alexa","Mouse","Pendrive"};
        Float  [] productPrice = {999.00f,15500.00f,40200.00f,1800.00f,10050.00f,980.00f,799.00f,2999.00f,399.00f,359.00f};
        Integer [] stock = {100,10,15,30,20,32,5,3,13,48};
        Integer [] quantity= {1,1,1,1,1,1,1,1,1,1};
        
        for (int i=0; i <productNames.length; i++) {
            this.products.add(new Product(i+1, productNames[i], productPrice[i], stock[i],quantity[i]));
        }
    }
}


