# PathCalculator

A program that helps the shipper choose the shortest shipping path by using drones. The path is depending on the total distance from the drone depot to the warehouse and from the warehouse to the customer.


## Running the program

- Run the **MainServer** class at first. Once the Server started successfully, run **ClientServer** class.
- In order to reduce the calculation time, the coordinate data of depots and stores (warehouses) will be parsed in the initial Server setup process.
- The parsing process is using Google Geocoding API, so please make sure your network is working properly.

### Adding customer

Create a Customer Object with name and a valid address in the **ClientOutputThread** class. Then add this customer to request.

```java
Customer c5=new Customer("c5","address");
request.add(c5);
```

### Adding depot

Create a Depot Object in the **Algorithm** class at first.

```java
public static Depot d3=new Depot();
```
Then set the depot name, address and the coordinate in the **MainServer** class.

```java
Algorithm.d3.setName("d3");
Algorithm.d3.setAddress("address");
Algorithm.d3.setCoo(Algorithm.address2coordinates("address"));
Algorithm.depots.add(Algorithm.d3);
```
Once done, you can check the new depot by printing it to the console.

```java
System.out.printf("%-45s%s%n", Algorithm.d3.getName()+": "+Algorithm.d3.getAddress(), Algorithm.d3.getCoo());
```

### Adding store

The adding store process is quite similar to the adding depot process. But create a Store Object instead.



## Algorithm

In order to find the shortest path to deliver the products, we need to calculate all the possible routes from the depot to store and store to the customer. In the program we have 2 depots and 5 stores, so for each customer, we need to calculate $2*5=10$ times, and then find the shortest path. All the paths are stored in an ArrayList and can be sorted.

![](https://github.com/sukaidie/PathCalculator/blob/master/imgs/img_1.png)

The figure below shows the real result for the 4 customers. We can see the shortest path is mostly starting from D2 to S1, seems like they are closer to most customers.

![](https://github.com/sukaidie/PathCalculator/blob/master/imgs/img_2.png)

## Built With

* [Geocoding](https://developers.google.com/maps/documentation/geocoding/start) - Parsing the address to coordinates.
* [Maven](https://maven.apache.org/) - Dependency Management
* [JSON-java](https://github.com/stleary/JSON-java) - Used to parse the JSON file.

## Author

* **Kaidie Su** 
