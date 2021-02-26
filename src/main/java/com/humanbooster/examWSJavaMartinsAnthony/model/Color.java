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
@Table(name = "color")
public class Color {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "codeRgv", nullable = false, length = 250)
    @NotNull(message = "Le codeRgv ne peut pas etre null")
    @NotBlank(message = "Le codeRgv ne peut pas etre vide")
    private String codeRgv;

    @Basic
    @Column(name = "libelle", nullable = false, length = 250)
    @NotNull(message = "Le libelle ne peut pas etre null")
    @NotBlank(message = "Le libelle ne peut pas etre vide")
    private String libelle;
    
    public Color() {
        
    }
    
    public Color(String codeRgv, String libelle) {
        
        this.codeRgv = codeRgv;
        this.libelle = libelle;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeRgv() {
        return codeRgv;
    }

    public void setCodeRgv(String codeRgv) {
        this.codeRgv = codeRgv;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
