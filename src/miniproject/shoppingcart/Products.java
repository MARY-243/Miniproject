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
        Double [] productPrice = {999.00d,15500.00d,40200.00d,1800.00d,10050.00d,980.00d,799.00d,2999.00d,399.00d,359.00d};
        Integer [] stock = {100,10,15,30,20,32,5,3,13,48};
        Integer [] quantity= {1,1,1,1,1,1,1,1,1,1};
        
        for (int i=0; i < productNames.length; i++) {
            this.products.add(new Product(i+1, productNames[i], productPrice[i], stock[i],quantity[i]));
        }
    }
}


