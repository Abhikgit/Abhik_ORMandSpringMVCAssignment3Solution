package Customer_Relationship_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Customer_Relationship_Management.entity.customer;
import Customer_Relationship_Management.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	
	public String handleListStudents(Model theModel) {

		List<customer> customers = customerService.listAll();

		theModel.addAttribute("customers", customers);

		return "customers-lister";
	}

}

