package miniproject.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import miniproject.shoppingcart.Product;
import miniproject.shoppingcart.Products;

public class Cart {
	  List<Product> cartItems = new ArrayList<Product>();

	public void addProductToCartByPid(int id) {
		 Product product = getProductByProductID(id);
	        addToCart(product);
		
	}

	private Product getProductByProductID(int id) {
		
	     Product product = null;
	        List<Product> products = new Products().getProducts();
	        for (Product prod: products) {
	            if (prod.getId() == id) {
	                product = prod;
	                break;
	            }
	        }
	       
		return product;
	    
	}

	private void addToCart(Product product) {
		cartItems.add(product);
		
	}

	public void printCartItems() {
		 for (Product prod: cartItems) {
	            System.out.print(prod.getPname());
	          

	        }
	}

}
