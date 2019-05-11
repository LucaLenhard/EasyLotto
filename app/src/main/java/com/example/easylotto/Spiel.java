package com.example.easylotto;

public class Spiel {
    private Integer Volumen;
    private String Spielnummer;
    private Integer Spieleranzahl;
    private String Ziehungsdatum;
    private Integer UserAktiv;
    private Integer UserGewonnen;

    public Spiel(String Spielnummer, Integer Spieleranzahl, String Ziehungsdatum, Integer Volumen ) {
    this.Volumen = Volumen;
    this.Spielnummer = Spielnummer;
    this.Spieleranzahl = Spieleranzahl; // Jetzt : BuyIN !!
    this.Ziehungsdatum = Ziehungsdatum;
    this.UserAktiv = 0; ///false; 1 for true
    this.UserGewonnen =0; //false; 1 for true
    }
    //Getter

    public Integer getVolumen() {
        return Volumen;
    }

    public String getSpielnummer() {
        return Spielnummer;
    }

    public Integer getSpieleranzahl() {
        return Spieleranzahl;
    }

    public String getZiehungsdatum() {
        return Ziehungsdatum;
    }
    //Setter
    public void setVolumen(Integer volumen) {
        Volumen = volumen;
    }

    public void setSpielnummer(String spielnummer) {
        Spielnummer = spielnummer;
    }

    public Integer getUserAktiv() {
        return UserAktiv;
    }

    public Integer getUserGewonnen() {
        return UserGewonnen;
    }

    public void setUserAktiv(Integer userAktiv) {
        UserAktiv = userAktiv;
    }

    public void setUserGewonnen(Integer userGewonnen) {
        UserGewonnen = userGewonnen;
    }

    public void setSpieleranzahl(Integer spieleranzahl) {
        Spieleranzahl = spieleranzahl;
    }

    public void setZiehungsdatum(String ziehungsdatum) {
        Ziehungsdatum = ziehungsdatum;
    }
}
