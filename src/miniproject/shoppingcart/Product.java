package miniproject.shoppingcart;

import java.util.Objects;

public class Product {

    private Integer id;
    private String pname;
    private Double price;
    private Integer stock;
	private Integer quantity;

    
    public Product () {       
    }
    
    public Product (Integer id, String pname, Double price, Integer stock,Integer quantity) {
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

    
    public void setId(Integer id) {
        this.id = id;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
    public Integer addOne() {
	     return quantity = quantity + 1;
	}

	public Integer reduceOne() {
	     return quantity = quantity - 1;
	}
	
	 @Override
	    public int hashCode() {
	        int hash = 7;
	        hash = 29 * hash + Objects.hashCode(this.id);
	        hash = 29 * hash + Objects.hashCode(this.pname);
	        hash = 29 * hash + Objects.hashCode(this.price);
	        hash = 29 * hash + Objects.hashCode(this.stock);
	     
	        return hash;
	    }

	  @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Product other = (Product) obj;
	        if (!Objects.equals(this.pname, other.pname)) {
	            return false;
	        }
	        if (!Objects.equals(this.id, other.id)) {
	            return false;
	        }
	        if (!Objects.equals(this.price, other.price)) {
	            return false;
	        }
	        if (!Objects.equals(this.stock, other.stock)) {
	            return false;
	        }
	      
	        return true;
	    }

	
	}


  


