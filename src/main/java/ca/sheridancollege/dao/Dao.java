package ca.sheridancollege.dao;

import java.util.*;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.*;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.bean.Student;

public class Dao {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public void addContact(Student contact) {

		// Open a new session and begin a transaction.
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(contact);

		// Commit the transaction and close the session.
		session.getTransaction().commit();
		session.close();

	}

	public List<String> validateStudent(Student s) {

		List<String> errorList = new ArrayList<String>();

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

		javax.validation.Validator validator = validatorFactory.getValidator();

		Set<ConstraintViolation<Student>> violationErrors = validator.validate(s);

		if (!violationErrors.isEmpty()) {
			for (ConstraintViolation<Student> errors : violationErrors) {
				errorList.add(errors.getPropertyPath() + " :: " + errors.getMessage());
			}
		}
		return errorList;
	}

}
