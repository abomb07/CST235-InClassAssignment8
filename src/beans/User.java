package beans;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {

	@NotNull(message = "Please, enter your first name!")
	@Size(min = 4, max = 15)
	String firstName = "";
	@NotNull(message = "Please, enter your last name!")
	@Size(min = 4, max = 15)
	String lastName = "";

	@PostConstruct
	public void init() {
		// Get the logged in Principle
		Principal principle = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		if (principle == null) {
			setFirstName("Unknown");
			setLastName("");
		} else {
			setFirstName(principle.getName());
			setLastName("");
		}

	}

	public User() {
		firstName = "";
		lastName = "";
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
