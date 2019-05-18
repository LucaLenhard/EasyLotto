package com.example.easylotto;

public class Spiel {
    private Integer Volumen;
    private String Spielnummer;
    private Integer buyin;
    private String Ziehungsdatum;
    private Integer UserAktiv;
    private String UserGewonnen;

    public Spiel(String Spielnummer, Integer buyin, String Ziehungsdatum, Integer Volumen, Integer useraktiv, String usergewonnen) {
        this.Volumen = Volumen;
        this.Spielnummer = Spielnummer;
        this.buyin = buyin; // Jetzt : BuyIN !!
        this.Ziehungsdatum = Ziehungsdatum;
        this.UserAktiv = useraktiv; ///false; 1 for true
        this.UserGewonnen =usergewonnen; //0 == noch nicht gezogen, 1==gewonnen, 2 ==velrloren
    }
    //Getter

    public Integer getVolumen() {
        return Volumen;
    }

    public String getSpielnummer() {
        return Spielnummer;
    }

    public Integer getBuyin() {
        return buyin;
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

    public String getUserGewonnen() {
        return UserGewonnen;
    }

    public void setUserAktiv(Integer userAktiv) {
        UserAktiv = userAktiv;
    }

    public void setUserGewonnen(String userGewonnen) {
        UserGewonnen = userGewonnen;
    }

    public void setBuyin(Integer buyin) {
        this.buyin = buyin;
    }

    public void setZiehungsdatum(String ziehungsdatum) {
        Ziehungsdatum = ziehungsdatum;
    }
}
