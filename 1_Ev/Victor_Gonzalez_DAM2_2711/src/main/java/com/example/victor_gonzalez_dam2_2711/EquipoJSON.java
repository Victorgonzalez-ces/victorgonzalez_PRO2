package com.example.victor_gonzalez_dam2_2711;

public class EquipoJSON {

    public String strTeam;

    public String strTeamBadge;
    public EquipoJSON(String strTeam, String strTeamBadge) {
        this.strTeam = strTeam;
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    @Override
    public String toString() {
        return strTeam;
    }
}
