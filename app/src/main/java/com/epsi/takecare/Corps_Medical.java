package com.epsi.takecare;

/**
 * Created by gael on 05/04/2017.
 */

public class Corps_Medical {

    private int id_CM;
    private String poste_CM;
    private String localisation_CM;
    private String nom_Cm;
    private String prenom_CM;
    private String nomHopital_CM;
    private String tel_CM;
    private String adress_CM;
    private String cp_CM;
    private String ville_CM;
    private String mail_CM;
    private String mdp_CM;

    public Corps_Medical(int id_CM, String poste_CM, String localisation_CM, String nom_Cm, String prenom_CM, String nomHopital_CM, String tel_CM, String adress_CM, String cp_CM, String ville_CM, String mail_CM, String mdp_CM) {
        this.id_CM = id_CM;
        this.poste_CM = poste_CM;
        this.localisation_CM = localisation_CM;
        this.nom_Cm = nom_Cm;
        this.prenom_CM = prenom_CM;
        this.nomHopital_CM = nomHopital_CM;
        this.tel_CM = tel_CM;
        this.adress_CM = adress_CM;
        this.cp_CM = cp_CM;
        this.ville_CM = ville_CM;
        this.mail_CM = mail_CM;
        this.mdp_CM = mdp_CM;
    }

    public Corps_Medical() {
    }
}
