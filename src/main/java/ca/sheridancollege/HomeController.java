package ca.sheridancollege;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.sheridancollege.bean.Student;
import ca.sheridancollege.dao.Dao;

@Controller
public class HomeController {

	Dao dao = new Dao();

	@RequestMapping("/")
	public String showHome(Model model) {
		model.addAttribute("student", new Student());
		// Student s1 = new Student(4, "Snow@gmail.com", "Jon", "L6Y5S6");
		// Student s2 = new Student(0, "Snow@gmail.com", null, "L6Y5S6");
		// Student s3 = new Student(9, "aaaaaaaaaaaadhfdaaaaaaaaaaa", "Jon", "L6Y5S6");
		// dao.validateStudent(s3);
		return "addContact";
	}

	@RequestMapping(value = "savecontact", method = RequestMethod.POST)
	public String saveContact(Model model, @ModelAttribute Student student) {
		if (dao.validateStudent(student).isEmpty()) {
			dao.addContact(student);
			model.addAttribute("student", new Student());
		}
		else {
			model.addAttribute("errorList", dao.validateStudent(student));
		}
		return "addContact";
	}

}
