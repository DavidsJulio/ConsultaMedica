package com.davidjulio.consultamedica.model;

import java.io.Serializable;

public class Patient implements Serializable { //transferir um dado para outra tela

    private Long id;
    private String namePatient, phonePatient, bDatePatient, cityPatient, resultPatient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getPhonePatient() {
        return phonePatient;
    }

    public void setPhonePatient(String phonePatient) {
        this.phonePatient = phonePatient;
    }

    public String getbDatePatient() {
        return bDatePatient;
    }

    public void setbDatePatient(String bDatePatient) {
        this.bDatePatient = bDatePatient;
    }

    public String getCityPatient() {
        return cityPatient;
    }

    public void setCityPatient(String cityPatient) {
        this.cityPatient = cityPatient;
    }

    public String getResultPatient() {
        return resultPatient;
    }

    public void setResultPatient(String resultPatient) {
        this.resultPatient = resultPatient;
    }
}
