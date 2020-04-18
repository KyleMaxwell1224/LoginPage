import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class RegisterForm extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="height: auto; padding: var(--lumo-space-m); justify-content: flex-start; align-content: flex-start; flex-direction: column; align-items: center;">
 <h1>Register New Account</h1>
 <vaadin-horizontal-layout theme="spacing" style="align-self: center;" modelattribute="user">
  <vaadin-text-field label="First Name" placeholder="First name " id="firstName" style="flex-shrink: 0;" required></vaadin-text-field>
  <vaadin-text-field label="Last Name" placeholder="Last name" id="lastName" style="width: 100%;" required></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-self: center;">
  <vaadin-text-field label="E-mail Address" placeholder="Enter e-mail here." id="eMailAddress" style="flex-shrink: 0; align-self: flex-end;" required>
    email 
  </vaadin-text-field>
  <vaadin-text-field label="Country Code (U.S. is 1)" placeholder="Country Code" id="CountryCode" required></vaadin-text-field>
  <vaadin-text-field label="Phone Number (no spaces)" placeholder="Phone Number" id="phoneNumber" required></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; flex-direction: row; flex-shrink: 1; flex-grow: 0; justify-content: center;">
  <vaadin-vertical-layout theme="spacing-s" style="flex-shrink: 0; flex-grow: 0; align-self: flex-start; flex-direction: column; align-items: flex-end;">
   <vaadin-password-field label="Password" placeholder="Enter password" id="password" required has-value></vaadin-password-field>
   <vaadin-password-field label="Re-enter Password" placeholder="Enter password" required has-value id="reEnterPassword"></vaadin-password-field>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing-xs" style="align-self: center; align-items: flex-end; justify-content: center;"></vaadin-vertical-layout>
  <h6>Password Requirements<li>Contains at least one upper, lower and number</li><li>Length of 8-14 characters</li></h6>
 </vaadin-horizontal-layout>
 <button id="button" style="margin: var(--lumo-space-m);">Create Account</button>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'register-form';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(RegisterForm.is, RegisterForm);
