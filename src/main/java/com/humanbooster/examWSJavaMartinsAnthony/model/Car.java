/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examWSJavaMartinsAnthony.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author HB
 */
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "marque", nullable = false, length = 250)
    @NotNull(message = "La marque ne peut pas etre null")
    @NotBlank(message = "La marque ne peut pas etre vide")
    private String marque;

    @Basic
    @Column(name = "modele", nullable = false, length = 250)
    @NotNull(message = "Le modele ne peut pas etre null")
    @NotBlank(message = "Le modele ne peut pas etre vide")
    private String modele;

    @Basic
    @Column(name = "carburant", nullable = false, length = 250)
    @NotNull(message = "Le carburant ne peut pas etre null")
    @NotBlank(message = "Le carburant ne peut pas etre vide")
    private String carburant;

    @Basic
    @Column(name = "annee", nullable = false)
    @NotNull(message = "L'annee ne peut pas etre null")
    private Integer annee;

    @Basic
    @Column(name = "kilometrage", nullable = false)
    @NotNull(message = "Le kilometrage ne peut pas etre null")
    private Integer kilometrage;

    @Basic
    @Column(name = "prix", nullable = false)
    @NotNull(message = "Le prix ne peut pas etre null")
    private Integer prix;

    @Basic
    @Column(name = "description", nullable = false, length = 250)
    @NotNull(message = "La description ne peut pas etre null")
    @NotBlank(message = "La description ne peut pas etre vide")
    private String description;
    
    public Car(){
        
    }
    
    public Car(String marque, String modele, String carburant, Integer annee, Integer kilometrage, Integer prix, String description) {
        
        this.marque = marque;
        this.modele = modele;
        this.carburant = carburant;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.description = description;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
