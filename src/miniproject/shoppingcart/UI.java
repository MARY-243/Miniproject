package miniproject.shoppingcart;

import java.util.List;
import java.util.Scanner;


public class UI extends Cart {
   
    Scanner scan = new Scanner(System.in);
    public int ch = 0;

    public UI () {
    	System.out.println("***Welcome to our Shopping Cart!***");
    	System.out.println();
        menu();
       
    }
    
    public void startScreen () {
        System.out.println("1. Display Store Products");
        System.out.println("2. Display Cart");
        System.out.println("0. Exit");
    }
    
    public void storeProductsMenu() {
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove From Cart");
        System.out.println("0. Exit");
    }
    
    public void menu () {
    	
        do {
            startScreen();
            getUserInput();
            
            switch (ch) {
                case 1: 
                    displayStoreProducts();
                    storeProductsMenu();
                    getUserInput();
                    Choice2();
                    break;
                case 2:
                    printCart();
                    storeProductsMenu();
                    getUserInput();
                    Choice2();
                    break;
                case 0:  
                	
                	System.out.println("Do you want to checkout? (yes/no): ");
                	String  c=scan.next();
                	if (c.equals("yes")) {
                		checkout();
                		System.out.println("Thank you for shopping with us!");
                	} else {
                		menu();
                	}
              default:break;
            } 
        } while (ch != 0);
    }
    
    /*A method to modify the cart using operations like 
     *Add to cart,
     *Remove the product from the cart
     *Proceed for checkout
     */
 
    private void Choice2() {
    	
        switch (ch) {
            case 1:
                	addProductToCart();
                	printCart();
                	break;
            case 2:
                	removeProductFromCart();
                	printCart();
                	break;
           
            case 0:
            		System.out.println("Do you want to checkout? (yes/no): ");
            		String  c=scan.next();
            		if (c.equals("yes")) {
                		checkout();
            			System.out.println("Thank you for shopping with us!");
            		} 
            		else {
            			menu();
            		}
            		break;
            		
            default:break;
            
        }	
       
    }
    
    public int getUserInput() throws NumberFormatException {
        Scanner input = new Scanner (System.in);
        ch = Integer.parseInt(input.nextLine());
        return ch;
    }
    
    //To display the available products.
    public void displayStoreProducts() {
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
    }

    //Method to give the item id as input to add an item.
    public void addProductToCart() {
    	System.out.println("Enter the product id:");
        int id = getUserInput();
        addProductToCartByPID(id); 
        
    }
   
    //Method to give the item id as input to remove an item .
    public void removeProductFromCart() {
       	System.out.println("Enter the product id:");
        int id = getUserInput();
        removeProductByPID(id);
    }
 
}
