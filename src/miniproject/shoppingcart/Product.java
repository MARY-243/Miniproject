package miniproject.shoppingcart;

import java.util.Objects;


public class Product {

    private Integer id;
    private String pname;
    private Float price;
    private Integer stock;
	private Integer quantity;

    
    public Product () {       
    }
    
    public Product (Integer id, String pname, Float price, Integer stock,Integer quantity) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.stock = stock;
        this.quantity=quantity;
       
    }
    public Integer getQuantity() {
    	
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

    //To increment the quantity of an item in the cart .
    public Integer addOne() {
        return quantity = quantity + 1;
    }
    
    //To decrement the quantity of an item in the cart .
    public Integer reduceOne() {
        return quantity = quantity - 1;
    }

	public Integer getId() {
		return id;
	}


	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	 
	@Override
	public int hashCode() {
	     return id;
	}
	  
	//Define the equality of two products.
	 @Override
	 public boolean equals(Object obj) {
		
		 Product p=(Product) obj;
	     return id==p.id;
	}  
	 
	 public void setId(Integer id) {
	        this.id = id;
	}  
	 
}


  


