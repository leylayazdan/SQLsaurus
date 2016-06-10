package Main;

public class Restaurant {
	private String RestaurantName;
	private String Username;
	private Boolean isOpen;
	private String CuisineType;
	 
	public Restaurant() {
	}

	public String getRestaurantName() {
		return RestaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		RestaurantName = restaurantName;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getCuisineType() {
		return CuisineType;
	}

	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}	
}
