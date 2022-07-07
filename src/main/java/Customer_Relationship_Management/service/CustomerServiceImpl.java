package Customer_Relationship_Management.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Customer_Relationship_Management.entity.customer;


@Repository
public class CustomerServiceImpl implements CustomerService {


	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<customer> listAll() {

		Transaction transaction = session.beginTransaction();

		List<customer> customers
			= session.createQuery("from customer_entity").list();

		transaction.commit();
		return customers;
	}

	@Transactional
	public customer findById(int id) {

		customer c1 = new customer();

		Transaction transaction = session.beginTransaction();
		c1 = session.get(customer.class, id);
		transaction.commit();

		return c1;
	}

	@Transactional
	public void save(customer customer) {

		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(customer);

		transaction.commit();
	}

	@Transactional
	public void deleteById(int id) {

		Transaction transaction = session.beginTransaction();

		customer c1 = session.get(customer.class, id);

		session.delete(c1);

		transaction.commit();
	}
}