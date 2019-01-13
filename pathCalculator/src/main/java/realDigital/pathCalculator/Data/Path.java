package realDigital.pathCalculator.Data;

/**
 * This class can be compared by the path distance.
 */

public class Path implements Comparable<Path>{
	private String name;
	private double distance;
	private String time;

	public Path(String name, double distance, String time) {
		this.name = name;
		this.distance = distance;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public int compareTo(Path p) {
		double res=this.distance-p.distance;
		return (int) (res != 0 ? res : (this.distance-p.distance));
	}

	@Override
	public String toString() {
		return "[route=" + name + ", distance=" + distance + " m, time=" + time + "]";
	}
	
}

