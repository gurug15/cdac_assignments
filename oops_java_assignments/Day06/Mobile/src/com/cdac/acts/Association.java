package com.cdac.acts;


//class add
class Address {
	private String street, city, state, zipCode;


	public Address(String street, String city, String state, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
}


//class emp
class Employee {
	private String name, empId;
	private Address address;

	public Employee(String name, String empId, Address address) {
		this.name = name;
		this.empId = empId;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee: " + name + " (ID: " + empId + ")\n" + address;
	}
}


//class association
public class Association {
	public static void main(String[] args) {
		Address address = new Address("Pashan", "Pune", "Maharashtra", "411008");
		Employee employee = new Employee("Sam Pitroda", "E12345", address);

		System.out.println(employee);
	}
}

