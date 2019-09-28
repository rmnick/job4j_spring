package org.chubaka.model;

import org.chubaka.service.LoginValidation;

import javax.validation.constraints.*;

/**
 * practice with validation from hibernate in spring
 */
public class Customer {

    private String firstName;

    @NotNull(message = "input last name")
    @Size(min = 2, message = "more than two letters")
    private String lastName;

    @Min(value = 18, message = "you must be an adult")
    @Max(value = 150, message = "that's bullshit")
    private int age;

    @Pattern(regexp = "[0-9]{6}", message = "only the digits, length equals six")
    private String postalCode;

    @NotNull(message = "there's must be something")
    @LoginValidation
    private String login;

    public Customer() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return String.format("customer %s %s", this.firstName, this.lastName);
    }
}
