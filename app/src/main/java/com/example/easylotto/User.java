package com.example.easylotto;

public class User {
    private String Voraname = "Max";
    private String Nachname = "Mustermann";
    private String Passwort = "123";
    private String email ="max.mustermann@web.de";
    private Integer Guthaben = 0;

    public User(String Vorname, String Nachname, String Passwort, String email, Integer Guthaben) {
       this.Voraname = Vorname;
       this.Nachname = Nachname;
       this.Passwort = Passwort;
       this.email = email;
       this.Guthaben = Guthaben;
    }
}
