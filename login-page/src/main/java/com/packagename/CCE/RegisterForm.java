package com.packagename.CCE;

import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.*;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import org.passay.*;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.packagename.CCE.RegisterForm.RegisterFormModel.*;

/**
 * A Designer generated component for the register-form template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Route("register")
@Tag("register-form")
@JsModule("./register-form.js")

public class RegisterForm extends PolymerTemplate<RegisterForm.RegisterFormModel> {
    @Id("firstName")
    private TextField firstName;
    @Id("lastName")
    private TextField lastName;
    @Id("eMailAddress")
    private TextField eMailAddress;
    @Id("password")
    private PasswordField passwordField;
    @Id("button")
    private NativeButton submitButton;
    @Id("reEnterPassword")
    private PasswordField reEnterPassword;
    private User newUser = new User();
    @Id("CountryCode")
    private TextField CountryCode;
    @Id("phoneNumber")
    private TextField phoneNumber;

    /**
     * Creates a new RegisterForm.
     */
    public RegisterForm() {
        submitButton.addClickListener(e -> {
           verifyContent(); 
        });
    }

    private void verifyContent() {
        boolean satisfied;
        satisfied = checkPassword(passwordField, reEnterPassword);
        if(satisfied==false)
        {
            System.out.println("Password is not satisfied");
            return;
        }
        satisfied = checkEmail(eMailAddress.getValue());
        if(satisfied == false)
        {
            System.out.println("Invalid Email");
            return;
        }
        satisfied = checkNumber(CountryCode.getValue(), phoneNumber.getValue());
        if(satisfied == false)
        {
            System.out.println("Invalid Phone");
            return;
        }
        setUser();
        Application.userArray.put(newUser.getUserName(), newUser);
        getUI().ifPresent(ui -> ui.navigate("success"));
    }

    private void setUser()
    {
        newUser.setPassword(passwordField.getValue());
        newUser.setUserName(eMailAddress.getValue().toLowerCase());
        newUser.setFirstName(firstName.getValue());
        newUser.setLastName(lastName.getValue());
        newUser.setPhoneNumber(CountryCode.getValue(), phoneNumber.getValue());
    }

    private boolean checkPassword(PasswordField passwordField, PasswordField reEnterPassword) {
        String password = passwordField.getValue();
        if (!password.equals(reEnterPassword.getValue()))
        {
            System.out.println("Passwords are not the same");
            return false;
        }
        List<Rule> rules = new ArrayList<>();
        rules.add(new LengthRule(8, 12));
        rules.add( new CharacterRule(EnglishCharacterData.LowerCase, 1));
        rules.add( new CharacterRule(EnglishCharacterData.UpperCase, 1));
        rules.add(new WhitespaceRule());
        rules.add( new CharacterRule(EnglishCharacterData.Digit, 1));

        PasswordValidator validator = new PasswordValidator(rules);
        PasswordData passwordData = new PasswordData(password);
        RuleResult result = validator.validate(passwordData);

        if (result.isValid()) {
            return true;
        }
        else
            return false;
    }

    public static boolean checkEmail(String email) {
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            return false;
        }
        return true;
    }

    public static boolean checkNumber(String countryNum, String phone) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        String countryCode = phoneUtil.getRegionCodeForCountryCode(Integer.parseInt(countryNum));
        try {
            PhoneNumber phoneProto = phoneUtil.parse(phone, countryCode);
        } catch (NumberParseException e) {
            System.out.print(e);
            return false;
        }
        return true;
    }


    /**
     * This model binds properties between RegisterForm and register-form
     */
    public interface RegisterFormModel extends TemplateModel {
        // Add setters and getters for template properties here.

    }
}
