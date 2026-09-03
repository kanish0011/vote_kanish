package com.devops;

public class Voter {
    private String name;
    private int age;
    private String citizenship;
    private String voterId;
    private boolean isIdValid;

    public Voter(String name, int age, String citizenship, String voterId, boolean isIdValid) {
        this.name = name;
        this.age = age;
        this.citizenship = citizenship;
        this.voterId = voterId;
        this.isIdValid = isIdValid;
    }

    public String checkEligibility() {
        StringBuilder reasons = new StringBuilder();
        
        if (age < 18) {
            reasons.append("Underage (Must be at least 18 years old). ");
        }
        if (!"Indian".equalsIgnoreCase(citizenship)) {
            reasons.append("Not a citizen of the country. ");
        }
        if (voterId == null || voterId.trim().isEmpty() || !isIdValid) {
            reasons.append("Invalid or missing Voter ID. ");
        }

        if (reasons.length() == 0) {
            return "ELIGIBLE";
        } else {
            return "NOT ELIGIBLE -> Reasons: " + reasons.toString().trim();
        }
    }

    @Override
    public String toString() {
        return "Voter Details: [Name=" + name + ", Age=" + age + ", Citizenship=" + citizenship + 
               ", Voter ID=" + voterId + ", Status=" + checkEligibility() + "]";
    }
}
