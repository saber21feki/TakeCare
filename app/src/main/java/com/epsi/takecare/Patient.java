package com.epsi.takecare;

import java.util.Date;

/**
 * Created by eugeniebenezech on 05/04/2017.
 */

public class Patient {

    private int id_patient;
    private String nom_patient;
    private String prenom_patient;
    private String date_naissance;
    private String adresse_postale_patient;
    private String cp_patient;
    private String  ville_patient;
    private String telephone_patient;
    private String sexe_patient;
    private String numsecu_patient;
    private String groupeSanguin_patient;
    private String mail_patient;
    private String mdp_patient;

        public Patient(int idPatient, String nomPatient,String prenomPatient, String dateNaissance,String adressePostalePatient, String cpPatient,String  villePatient,String telephonePatient,String sexePatient,String numsecuPatient,String groupeSanguinPatient, String mailPatient, String mdpPatient) {
            this.id_patient = idPatient;
            this.nom_patient = nomPatient;
            this.prenom_patient = prenomPatient;
            this.date_naissance = dateNaissance;
            this.adresse_postale_patient = adressePostalePatient;
            this.cp_patient = cpPatient;
            this.ville_patient = villePatient;
            this.telephone_patient = telephonePatient;
            this.sexe_patient = sexePatient;
            this.numsecu_patient = numsecuPatient;
            this.groupeSanguin_patient = groupeSanguinPatient;
            this.mail_patient = mailPatient;
            this.mdp_patient = mdpPatient;


        }

    public Patient(int idPatient, String nomPatient,String prenomPatient, String dateNaissance) {
        this.id_patient = idPatient;
        this.nom_patient = nomPatient;
        this.prenom_patient = prenomPatient;
        this.date_naissance = dateNaissance;
    }

    public Patient(String nomPatient,String prenomPatient, String dateNaissance) {
        this.nom_patient = nomPatient;
        this.prenom_patient = prenomPatient;
        this.date_naissance = dateNaissance;
    }
    public int getId_patient() {
        return id_patient;
    }

    public String getNom_patient() {
        return nom_patient;
    }

    public String getPrenom_patient() {
        return prenom_patient;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public String getAdresse_postale_patient() {
        return adresse_postale_patient;
    }

    public String getCp_patient() {
        return cp_patient;
    }

    public String getVille_patient() {
        return ville_patient;
    }

    public String getTelephone_patient() {
        return telephone_patient;
    }

    public String getSexe_patient() {
        return sexe_patient;
    }

    public String getNumsecu_patient() {
        return numsecu_patient;
    }

    public String getGroupeSanguin_patient() {
        return groupeSanguin_patient;
    }

    public String getMail_patient() {
        return mail_patient;
    }

    public String getMdp_patient() {
        return mdp_patient;
    }


    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public void setNom_patient(String nom_patient) {
        this.nom_patient = nom_patient;
    }

    public void setPrenom_patient(String prenom_patient) {
        this.prenom_patient = prenom_patient;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setAdresse_postale_patient(String adresse_postale_patient) {
        this.adresse_postale_patient = adresse_postale_patient;
    }

    public void setCp_patient(String cp_patient) {
        this.cp_patient = cp_patient;
    }

    public void setVille_patient(String ville_patient) {
        this.ville_patient = ville_patient;
    }

    public void setTelephone_patient(String telephone_patient) {
        this.telephone_patient = telephone_patient;
    }

    public void setSexe_patient(String sexe_patient) {
        this.sexe_patient = sexe_patient;
    }

    public void setNumsecu_patient(String numsecu_patient) {
        this.numsecu_patient = numsecu_patient;
    }

    public void setGroupeSanguin_patient(String groupeSanguin_patient) {
        this.groupeSanguin_patient = groupeSanguin_patient;
    }

    public void setMail_patient(String mail_patient) {
        this.mail_patient = mail_patient;
    }

    public void setMdp_patient(String mdp_patient) {
        this.mdp_patient = mdp_patient;
    }

}

