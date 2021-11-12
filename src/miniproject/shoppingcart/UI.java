package miniproject.shoppingcart;

import java.util.List;
import java.util.Scanner;



public class UI {

    Cart cart = new Cart();
    Scanner scan = new Scanner(System.in);
    private int ch = 0;
    
    public UI () {
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
        System.out.println("3. Total Price");
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
                    showCart();
                    storeProductsMenu();
                    getUserInput();
                    Choice2();
                    break;
                case 0:
                	System.out.println("Do you want to checkout? (yes/no): ");
                	String  c=scan.next();
                	if (c.equals("yes")) {
                		showTotalPrice() ;
                        System.out.println("Thank you for shopping with us!");

                    } else {
                        menu();
                    }
                    break;
                default:
                    
                    break;
            }
        } while (ch != 0);
    }

    private void Choice2() {
        switch (ch) {
            case 1:
                addProductToCart();
                showCart();
                break;
            case 2:
                removeProductFromCart();
                break;
            case 3:
            	showTotalPrice();
                break;
            case 0:
            	System.out.println("Do you want to checkout? (yes/no): ");
            	String  c=scan.next();
            	if (c.equals("yes")) {
            		showTotalPrice() ;
                    System.out.println("Thank you for shopping with us!");

                } else {
                    menu();
                }
            default:
                
                break;
        }
    }

    private int getUserInput() throws NumberFormatException {
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
    }

    private void addProductToCart() {
    	System.out.println("Enter the product id:");
        int id = getUserInput();
        cart.addProductToCartByPID(id); 
        
    }

    private void showCart() {
        cart.printCartItems();
    }

    private void removeProductFromCart() {
       	System.out.println("Enter the product id:");
        int id = getUserInput();
        cart.removeProductByPID(id);
    }
private void showTotalPrice() {
	cart.printTotal();
}
}
