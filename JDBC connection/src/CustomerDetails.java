
public class CustomerDetails {
	
	private String courseName;
	private String purchaseDate;
	private int amount;
	private String location;
	

	public void setDetails(String courseName, String purchaseDate, int amount, String location ) {
		this.courseName = courseName;
		this.purchaseDate = purchaseDate;
		this.amount = amount;
		this.location = location;
	}

		public String getCourseName() {
			return courseName;
		}

		public String getPurchaseDate() {
		return purchaseDate;
	}

		public int getAmount() {
		return amount;
	}

		public String getLocation() {
		return location;
	}

}
