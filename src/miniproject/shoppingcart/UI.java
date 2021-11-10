package miniproject.shoppingcart;

import java.util.List;
import java.util.Scanner;


import miniproject.shoppingcart.Product;
import miniproject.shoppingcart.Products;
import miniproject.shoppingcart.Cart;


public class UI {
	 Cart cart = new Cart();
	  private int ch = 0;
  
    public UI () {
        menu();
    }
    
    public void Screen () {
    	 System.out.println();
        System.out.println("1. Display Store Products");
        System.out.println("2. Display Cart");
        System.out.println("0. Exit");
    }
    
    public void storeProductsMenu() {
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove From Cart");
        System.out.println("0. Exit");
    }
	private void showcart() {
		cart.printCartItems();
		System.out.println(" added");
	}
    public void menu () {
        do {
            Screen();
            getUserInput();
            switch (ch) {
            case 1: 
                displayStoreProducts();
                storeProductsMenu();
                getUserInput();
                Choice2();
                break;
            case 2: System.out.println();
            	     cart.printCartItems();
                     break;
                
            default :break;}

}while(ch != 0);
}
       



	private void Choice2() { 
        switch (ch) {
        case 1:
            addProductToCart();
         
            showcart();
            
            break;
	    default:break;}
		
	}

	private void addProductToCart() {
		 System.out.print("Enter the product id:");
		 int id = getUserInput();
	        cart.addProductToCartByPid(id);      
	    
		
	}

	private int getUserInput() {
		   Scanner input = new Scanner (System.in);
	        ch = Integer.parseInt(input.nextLine());
	        return ch;
		
	}
	 private void displayStoreProducts() {
	        List<Product> products = new Products().getProducts();
	        System.out.println("Product Name| Price| Stock");
	        System.out.println();
	        for (Product prod: products) {
	            System.out.println(
	                    prod.getId() + " . " +
	                            prod.getPname() + " | " +
	                            prod.getPrice() + " | " +
	                            prod.getStock()
	            );
	            
	        }System.out.println("\n");
	 }}
