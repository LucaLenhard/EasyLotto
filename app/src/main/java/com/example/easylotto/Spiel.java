package com.example.easylotto;

public class Spiel {
    private Integer Volumen;
    private String Spielnummer;
    private Integer Spieleranzahl;
    private String Ziehungsdatum;

    public Spiel(String Spielnummer, Integer Spieleranzahl, String Ziehungsdatum, Integer Volumen ) {
    this.Volumen = Volumen;
    this.Spielnummer = Spielnummer;
    this.Spieleranzahl = Spieleranzahl;
    this.Ziehungsdatum = Ziehungsdatum;
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

    public void setSpieleranzahl(Integer spieleranzahl) {
        Spieleranzahl = spieleranzahl;
    }

    public void setZiehungsdatum(String ziehungsdatum) {
        Ziehungsdatum = ziehungsdatum;
    }
}
