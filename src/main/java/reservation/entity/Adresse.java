/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.entity;

import javax.persistence.Embeddable;

/**
 *
 * @author formation
 */
@Embeddable
public class Adresse {
    private String rue;
    private Long num;
    private String localite;
    private Long codePostal;
    private String pays;

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public Long getCodePostal() {
       return codePostal;
    }

  public void setCodePostal(long codePostal) {
    this.codePostal = codePostal;
 }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
    
}
