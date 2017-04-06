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

    public Corps_Medical(int id_CM) {
        this.id_CM = id_CM;
    }

    public int getId_CM() {
        return id_CM;
    }

    public String getPoste_CM() {
        return poste_CM;
    }

    public String getLocalisation_CM() {
        return localisation_CM;
    }

    public String getNom_Cm() {
        return nom_Cm;
    }

    public String getPrenom_CM() {
        return prenom_CM;
    }

    public String getNomHopital_CM() {
        return nomHopital_CM;
    }

    public String getTel_CM() {
        return tel_CM;
    }

    public String getAdress_CM() {
        return adress_CM;
    }

    public String getCp_CM() {
        return cp_CM;
    }

    public String getVille_CM() {
        return ville_CM;
    }

    public String getMail_CM() {
        return mail_CM;
    }

    public String getMdp_CM() {
        return mdp_CM;
    }

    public void setId_CM(int id_CM) {
        this.id_CM = id_CM;
    }

    public void setPoste_CM(String poste_CM) {
        this.poste_CM = poste_CM;
    }

    public void setLocalisation_CM(String localisation_CM) {
        this.localisation_CM = localisation_CM;
    }

    public void setNom_Cm(String nom_Cm) {
        this.nom_Cm = nom_Cm;
    }

    public void setPrenom_CM(String prenom_CM) {
        this.prenom_CM = prenom_CM;
    }

    public void setNomHopital_CM(String nomHopital_CM) {
        this.nomHopital_CM = nomHopital_CM;
    }

    public void setTel_CM(String tel_CM) {
        this.tel_CM = tel_CM;
    }

    public void setAdress_CM(String adress_CM) {
        this.adress_CM = adress_CM;
    }

    public void setCp_CM(String cp_CM) {
        this.cp_CM = cp_CM;
    }

    public void setVille_CM(String ville_CM) {
        this.ville_CM = ville_CM;
    }

    public void setMail_CM(String mail_CM) {
        this.mail_CM = mail_CM;
    }

    public void setMdp_CM(String mdp_CM) {
        this.mdp_CM = mdp_CM;
    }



}
