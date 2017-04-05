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
    private String ville_patient;
    private String telephone_patient;
    private String sexe_patient;
    private String numsecu_patient;
    private String groupeSanguin_patient;
    private String mail_patient;
    private String mdp_patient;
    private float poids_patient;
    private float taille_patient;
    private float temperature_patient;
    private float tension_patient;
    private float bpm_patient;
    private float tpsSommeil_patient;
    private float caloriesDepensees_patient;
    private float nbPas_patient;



        public Patient(int idPatient, String nomPatient,String prenomPatient, String dateNaissance,String adressePostalePatient, String cpPatient,String  villePatient,String telephonePatient,String sexePatient,String numsecuPatient,String groupeSanguinPatient, String mailPatient, String mdpPatient, float poids, float taille, String groupeSanguin, float temperature, float tension, float bpm, float tpsSommeil, float caloriesDepensees, float nbPas) {
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
            this.poids_patient = poids;
            this.taille_patient = taille;
            this.temperature_patient = temperature;
            this.tension_patient = tension;
            this.bpm_patient = bpm;
            this.tpsSommeil_patient = tpsSommeil;
            this.caloriesDepensees_patient = caloriesDepensees;
            this.nbPas_patient = nbPas;


        }

    public void setPoids_patient(float poids_patient) {
        this.poids_patient = poids_patient;
    }

    public void setTaille_patient(float taille_patient) {
        this.taille_patient = taille_patient;
    }

    public void setTemperature_patient(float temperature_patient) {
        this.temperature_patient = temperature_patient;
    }

    public void setTension_patient(float tension_patient) {
        this.tension_patient = tension_patient;
    }

    public void setBpm_patient(float bpm_patient) {
        this.bpm_patient = bpm_patient;
    }

    public void setTpsSommeil_patient(float tpsSommeil_patient) {
        this.tpsSommeil_patient = tpsSommeil_patient;
    }

    public void setCaloriesDepensees_patient(float caloriesDepensees_patient) {
        this.caloriesDepensees_patient = caloriesDepensees_patient;
    }

    public void setNbPas_patient(float nbPas_patient) {
        this.nbPas_patient = nbPas_patient;
    }

    public float getPoids_patient() {
        return poids_patient;
    }

    public float getTaille_patient() {
        return taille_patient;
    }

    public float getTemperature_patient() {
        return temperature_patient;
    }

    public float getTension_patient() {
        return tension_patient;
    }

    public float getBpm_patient() {
        return bpm_patient;
    }

    public float getTpsSommeil_patient() {
        return tpsSommeil_patient;
    }

    public float getCaloriesDepensees_patient() {
        return caloriesDepensees_patient;
    }

    public float getNbPas_patient() {
        return nbPas_patient;
    }

    public Patient(int idPatient, String nomPatient, String prenomPatient, String dateNaissance) {
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

