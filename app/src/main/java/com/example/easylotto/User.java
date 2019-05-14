package com.example.easylotto;

public class User {
    private String Benutzername;
    private String Passwort;
    private Integer Guthaben = 1000;

    public User(String Benutzername, String Passwort) {
       this.Benutzername = Benutzername;
       this.Passwort = Passwort;
       this.Guthaben = 1000;
    }

    public boolean checkUser(String eingabePW, String eingabeBenutzername) {

        if (eingabePW == this.Passwort && eingabeBenutzername == this.Benutzername)
            return true;
        else
            return false;
    }
}
