package com.packagename.CCE;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.*;

@Route("success")
@PageTitle("Successfully Signed In")
public class SuccessView extends VerticalLayout {
    public SuccessView()
    {
        setAlignItems(Alignment.CENTER);
        Button returnToLogin = new Button("Return");
        returnToLogin.addClickListener(e->{
                returnToLogin.getUI().ifPresent(ui -> ui.navigate(""));
        });
        add(new H1("Successfully signed in "));
        add(new H3("Need to return to the login page?"));
        add(returnToLogin);
    }
}
