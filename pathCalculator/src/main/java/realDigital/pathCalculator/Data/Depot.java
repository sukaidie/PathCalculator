package realDigital.pathCalculator.Data;

public class Depot {
	private String name;
	private String address;
	private Coordinates coo;

	public Depot() {
	}

	public Depot(String name,String address) {
		this.name = name;
		this.address = address;
	}

	public Depot(String name, String address, Coordinates coo) {
		this.name = name;
		this.address = address;
		this.coo = coo;
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

	@Override
	public String toString() {
		return "Depot [name=" + name + ", address=" + address + ", coo=" + coo + "]";
	}
	
}
