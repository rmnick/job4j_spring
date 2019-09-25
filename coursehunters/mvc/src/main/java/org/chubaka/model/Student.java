package org.chubaka.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private Map<String, String> countries;
    private String programmingLanguage;
    private List<String> operationSystem;

    public Student() {
        countries = new LinkedHashMap<>();
        countries.put("RUS", "Russia");
        countries.put("USA", "United States of America");
        countries.put("BRA", "Brazil");
        countries.put("FRA", "France");
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, String> getCountries() {
        return this.countries;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public List<String> getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(List<String> operationSystem) {
        this.operationSystem = operationSystem;
    }

    @Override
    public String toString() {
        return String.format("student %s %s", this.lastName, this.firstName);
    }

}
