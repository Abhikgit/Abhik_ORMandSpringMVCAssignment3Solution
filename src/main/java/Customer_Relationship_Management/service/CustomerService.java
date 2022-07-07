package Customer_Relationship_Management.service;


import java.util.List;

import Customer_Relationship_Management.entity.customer;


public interface CustomerService {

	List<customer> listAll();

	customer findById(int theId);

	void save(customer thecustomer);

	void deleteById(int theId);

}
