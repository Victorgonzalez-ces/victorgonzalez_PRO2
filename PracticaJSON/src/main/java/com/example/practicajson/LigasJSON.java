package com.example.practicajson;

public class LigasJSON {
    private String idLeague;
    private String strLeague;
    private String strSport;
    private String strLeagueAlternate;

    public LigasJSON(String idLeague, String strLeague, String strSport, String strLeagueAlternate) {
        this.idLeague = idLeague;
        this.strLeague = strLeague;
        this.strSport = strSport;
        this.strLeagueAlternate = strLeagueAlternate;
    }

    public LigasJSON(String idLeague, String strLeague) {
        this.idLeague = idLeague;
        this.strLeague = strLeague;
    }

    public LigasJSON() {
    }

    @Override
    public String toString() {
        return strLeague;
    }

    public String getIDLeague() { return idLeague; }
    public void setIDLeague(String value) { this.idLeague = value; }

    public String getStrLeague() { return strLeague; }
    public void setStrLeague(String value) { this.strLeague = value; }

    public String getStrSport() { return strSport; }
    public void setStrSport(String value) { this.strSport = value; }

    public String getStrLeagueAlternate() { return strLeagueAlternate; }
    public void setStrLeagueAlternate(String value) { this.strLeagueAlternate = value; }
}
