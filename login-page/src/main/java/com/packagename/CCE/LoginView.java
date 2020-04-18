package com.packagename.CCE;

import com.ejt.vaadin.loginform.*;
import com.google.common.hash.Hashing;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.component.login.LoginForm;
import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Route("")
@PageTitle("Login screen")
public class LoginView extends VerticalLayout{
    private LoginForm loginForm = new LoginForm();

    public LoginView() {
        setAlignItems(Alignment.CENTER);
        loginForm.addLoginListener(e ->{
            boolean authenticated =  authenticate(e.getUsername().toLowerCase(),e.getPassword());
            if(authenticated)
                getUI().ifPresent(ui -> ui.navigate("success"));
            else
                loginForm.setError(true);
        });
        NativeButton register = new NativeButton("Create account now");
        register.addClickListener( e-> {
            register.getUI().ifPresent(ui -> ui.navigate("register"));
        });
        loginForm.setForgotPasswordButtonVisible(false);
        add(new H1("Login"), loginForm);
        add(new H2("Need to make an account?"));
        add(register);
    }

    private boolean authenticate(String user, String pass) {
        HashMap<String, User> userHashMap = Application.userArray;
        String attemptedPass = Hashing.sha256()
                .hashString(pass, StandardCharsets.UTF_8)
                .toString();
        if(userHashMap.containsKey(user))
        {
            if(userHashMap.get(user).getPassword().equals(attemptedPass))
                return true;
        }
        return false;
    }
}