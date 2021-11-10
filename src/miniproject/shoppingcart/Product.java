package miniproject.shoppingcart;

public class Product {

    private Integer id;
    private String pname;
    private Double price;
    private Integer stock;
	
	
    
    public Product () {       
    }
    
    public Product (Integer id, String pname, Double price, Integer stock) {
        this.id = id;
        this.pname = pname;
        this.price = price;
        this.stock = stock;
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
	}}
  


