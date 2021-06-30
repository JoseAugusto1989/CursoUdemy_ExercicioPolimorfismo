package Entities;

public class ImportedProduct extends Product {
	
	private Double customesFee;
	
	public ImportedProduct() {
		
	}
	
	public ImportedProduct(String name, Double price, Double customesFee) {
		super(name, price);
		this.customesFee = customesFee;
		
	}

	public Double getCustomesFee() {
		return customesFee;
	}

	public void setCustomesFee(Double customesFee) {
		this.customesFee = customesFee;
	}
	
	@Override
	public String priceTag() {
		return null;
	}
	
	public Double totalPrice() {
		return price + customesFee;	
	}

	@Override
	public String toString() {
		return name + " R$ " + totalPrice() + 
			       " (CustomesFee: " + customesFee + ")";
	}
	
	

}
