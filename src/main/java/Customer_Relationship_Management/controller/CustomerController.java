package Customer_Relationship_Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Customer_Relationship_Management.entity.customer;
import Customer_Relationship_Management.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService CustomerService;

	@RequestMapping("/begin-add")
	public String handleBeginAdd(Model theModel) {

		customer c1 = new customer();

		theModel.addAttribute("customer", c1);

		return "customer-details";
	}

	@RequestMapping("/begin-update")
	public String handleBeginUpdate(
			@RequestParam("customeremail") int theemail, 
			Model theModel) {

		customer c1 = CustomerService.findById(theemail);
		theModel.addAttribute("customer", c1);
		return "customer-details";
	}

	@SuppressWarnings("null")
	@PostMapping("/save")
	public String handleSave( 
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName") String lastName, 		
		@RequestParam("email") String email)
		{

		customer c1;
		//if (id != 0) {
			
			// Update customer
			//c1.setFirstName(firstName);
			//c1.setLastName(lastName);
			//c1.setCourse(email);
		//} else {
		
			// Add Customer
			c1 = new customer(firstName, lastName,email);
			
		CustomerService.save(c1);
		return "redirect:/customers/list";

}

	@RequestMapping("/delete")
	public String handleDelete(@RequestParam("customerId") int theId) {

		CustomerService.deleteById(theId);

		return "redirect:/customers/list";

	}
}
