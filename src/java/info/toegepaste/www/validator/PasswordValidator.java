/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.toegepaste.www.validator;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 *
 * @author matth_000
 */
@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {
 
	@Override
	public void validate(FacesContext context, UIComponent component,
		Object value) throws ValidatorException {
 
	  String password = value.toString();
 
	  UIInput uiInputConfirmPassword = (UIInput) component.getAttributes()
		.get("wachtwoordbevestig");
	  String confirmPassword = uiInputConfirmPassword.getSubmittedValue()
		.toString();
 
	  
	  if (password == null || password.isEmpty() || confirmPassword == null
		|| confirmPassword.isEmpty()) {
			return;
	  }
 
	  if (!password.equals(confirmPassword)) {
		uiInputConfirmPassword.setValid(false);
		throw new ValidatorException(new FacesMessage(
			"Wachtwoord moet hetzelfde zijn als het bevestigde wachtwoord."));
	  }
 
	}
}