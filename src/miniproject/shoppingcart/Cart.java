package miniproject.shoppingcart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

class Cart {

    List<Product> cartItems = new ArrayList<Product>();
    
    float totalCost=0;
    
    // Set of all possible options for PaymentStatus. 
    enum PaymentStatus{
        DONE, DUE, PARTIAL
    };
    
    //Payment Status of current Cart. 
    private PaymentStatus status;
    
    // Payment Mode used by user.
    private String paymentMode;
    
    //Amount Paid by user.
    private Float paymentAmount=0F;
    
    //Date of payment.
    private Date paymentDate;    
    
    // Total amount of ordered items. 
    private Float totalAmount=0F;
    
    // Due amount after payment. 
    private Float paymentDue=0F;
    
    //To check whether the product exists
    //if exists, it returns the product
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
    
    //Method to add an item by it's id.
    public void addProductToCartByPID(int id) {
        Product product = getProductByProductID(id);
        addToCart(product);   
    }
   
    //Add to cart
    //Increases the quantity while adding.
    private void addToCart(Product product) {
    	int idxPos = cartItems.indexOf(product);
    	if( idxPos != -1) {
            product = cartItems.get(idxPos);
            product.addOne();
        }else {
            cartItems.add(product);
        }
        
    }
    
    //Remove the items from cart by it's id.
    public void removeProductByPID(int id) {
    	
        Product prod = getProductByProductID(id);
        removeFromCart(prod);
        
          }

    //Decreases the quantity while removing.
    //If quantity is zero, it removes from the cart.
    public void removeFromCart(Product product) {
        
        int idxPos = cartItems.indexOf(product);
        if( idxPos != -1) {
            product = cartItems.get(idxPos);
            int qty = product.reduceOne();
            System.out.println("Removed"); 
            if(qty == 0) {
                cartItems.remove(product);
            }
            } 
        else{
                cartItems.remove(product);
                System.out.println("It doesn't exist");
            }
    }
      
    /*
     Method handles the Checkout process using different sub-operations like 
     * Payment,
     * Order Confirmation,
     * Print Payment Summary,
     * Empty cart after payment.     
     */
    public void checkout(){
    	printCart();
        handlePayment();    
        confirmOrder();
        printPaymentSummary();
        emptyCart();//after confirmation of order empty the cart
    }
    
    
    // The method Prints all the products from present Cart. 
    public void printCart(){  
    	totalAmount=0f;
        System.out.println("==================================");
        System.out.println("CART ITEMS:");        
        System.out.println("==================================");
        for (Product p : cartItems) {
        	
            System.out.println("PRODUCT ID: "+p.getId());
            System.out.println("PRODUCT NAME: "+p.getPname());
            System.out.println("PRODUCT PRICE: "+p.getPrice());
            System.out.println("PRODUCT ORDER QTY: "+p.getQuantity());
            System.out.print("TOTAL: ");
            float  qprice=p.getPrice()*p.getQuantity();//Total price of each item with quantity.
       	    System.out.println(qprice); 
            totalAmount=totalAmount+qprice;//Total amount of all the items in the cart.
            System.out.println();
        }
        System.out.println("==================================");
        System.out.println("Net Total : "+totalAmount);
        System.out.println("==================================");        
    }   
    
    // A method to handle the payment. 
    public void handlePayment(){
        paymentMode=JOptionPane.showInputDialog("Enter Payment Mode(Cash/Cheque): ");
        paymentDate=new Date();//current date
        paymentAmount=new Float(JOptionPane.showInputDialog("Enter Amount, Total Due is: "+totalAmount));  
        paymentDue=totalAmount-paymentAmount;            
    }
    
    
    // The method handles the order confirmation on the basis of payment made. 
    public void confirmOrder(){
        if(paymentDue==0.0){
            status=PaymentStatus.DONE;
        }else if(paymentDue>0.0 && paymentDue<totalAmount){
            status=PaymentStatus.PARTIAL;
        }else if(paymentAmount==0.0){
            status=PaymentStatus.DUE;
        }  
        if(status==PaymentStatus.DONE || status==PaymentStatus.PARTIAL){
           System.out.println("SUCCESS: Your order is confirmed and will be processed soon."); 
        }else if(status==PaymentStatus.DUE){
            System.out.println("FAILED: Your order is failed. No payment done."); 
        }
    }
    
   
    // The method prints the payment summary.
    void printPaymentSummary(){
        System.out.println();
        System.out.println("PAYMENT SUMMARY: ");   
        System.out.println("==================================");
        System.out.println("TOTAL AMOUNT: "+totalAmount);
        System.out.println("PAYMENT AMOUNT: "+paymentAmount);
        System.out.println("PAYMENT DUE: "+paymentDue);
        System.out.println("PAYMENT MODE: "+paymentMode);
        System.out.println("PAYMENT DATE: "+paymentDate);        
        System.out.println("PAYMENT STATUS: "+status);
    }


   //After the confirmation of order, empty the cart
    public void emptyCart(){        
    	 cartItems.clear();
     	}
}
