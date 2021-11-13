package miniproject.shoppingcart;


import java.util.ArrayList;
import java.util.List;

class Cart {

    List<Product> cartItems = new ArrayList<Product>();
    public double totalPrice=0.0; 
   
    
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
    
    //Add to cart
    public void addProductToCartByPID(int id) {
        Product product = getProductByProductID(id);
        addToCart(product);   
    }
   
    //Add to cart
    private void addToCart(Product product) {
    	int idxPos = cartItems.indexOf(product);
    	if( idxPos != -1) {
            product = cartItems.get(idxPos);
            product.addOne();
        }else {
            cartItems.add(product);
        }
        
    }
    //Remove the items from cart
    public void removeProductByPID(int id) {
        Product prod = getProductByProductID(id);
        decreaseByOne(prod);
          }
    
    //Reduce the quantity by one
    
    public void decreaseByOne(Product product) {
        
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
    //To print the Cart
    void printCartItems() {
    	 System.out.println("==================================");
         System.out.println("CART ITEMS:");        
         System.out.println("==================================");
        for (Product prod: cartItems) {
        	System.out.println("PRODUCT ID: "+prod.getId());
        	System.out.println("PRODUCT NAME: "+prod.getPname());
        	System.out.println("PRODUCT PRICE: "+prod.getPrice());
        	System.out.println("PRODUCT ORDER QTY: "+prod.getQuantity());
        	System.out.print("TOTAL: ");
        	getPriceWithQuantity(prod);
        	}
        	System.out.println("==================================");    
            System.out.print("Net Total : ");
            totalPrice(cartItems);
            System.out.println();
            System.out.println("==================================");        
        }    
              
     //To print the total price of each item
     public void getPriceWithQuantity(Product product) {
    	 double  qprice=product.getPrice()*product.getQuantity();
    	 System.out.println(qprice);
    	 
     	}
    

     public void totalPrice(List<Product> cartItems)    { 
    	    List <Product> newList = new ArrayList<>();
            newList.addAll(cartItems); 

    	 totalPrice=0.0;
	     for (int j = 0; j<cartItems.size(); j++) {
	    	Product product=cartItems.get(j);
	    	double Price =product.getQuantity() * product.getPrice();
	    	totalPrice=totalPrice+Price;
	    		
	     }
            System.out.println( "Total Price: "+totalPrice);

}
   //After the confirmation of order, empty the cart
     public void emptyCart(){        
    	 cartItems.clear();
     	}
}
