package realDigital.pathCalculator.Data;

public class Store {
	private String name;
	private String address;
	private Coordinates coo;
	
	public Store(String name, String address, Coordinates coo) {
		this.name = name;
		this.address = address;
		this.coo = coo;
	}

	public Store() {
	}

	public Store(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Coordinates getCoo() {
		return coo;
	}

	public void setCoo(Coordinates coo) {
		this.coo = coo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
