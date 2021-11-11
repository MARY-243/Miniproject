package miniproject.shoppingcart;


import java.util.ArrayList;
import java.util.List;


class Cart {

    List<Product> cartItems = new ArrayList<Product>();
    
    public void addProductToCartByPID(int id) {
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
    	int idxPos = cartItems.indexOf(product);
    	if( idxPos != -1) {
            product = cartItems.get(idxPos);
            product.addOne();
        }else {
            cartItems.add(product);
        }
        
    }

    public void removeProductByPID(int id) {
        Product prod = getProductByProductID(id);
        decreaseByOne(prod);
        System.out.println("removed");    }
    

    void printCartItems() {
        for (Product prod: cartItems) {
            System.out.print(prod.getPname());
            System.out.print("|");
            System.out.print(prod.getQuantity());
            System.out.print("|");
            System.out.println(prod.getPrice());
            
        }
    }
    


    public void decreaseByOne(Product product) {
        
        int idxPos = cartItems.indexOf(product);
        if( idxPos != -1) {
            product = cartItems.get(idxPos);
            int qty = product.reduceOne();
            if(qty == 0) {
                cartItems.remove(product);
            }
            }
        else {
                cartItems.remove(product);
            }
    }}  
        

 