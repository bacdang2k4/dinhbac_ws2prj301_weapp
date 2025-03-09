/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.Certificate;

import java.sql.Date;

/**
 *
 * @author bacda
 */
public class CertificateDTO {
    private int id;
    private String name;
    private String issuer;
    private Date issueDate;

    public CertificateDTO() {
    }

    public CertificateDTO(int id, String name, String issuer, Date issueDate) {
        this.id = id;
        this.name = name;
        this.issuer = issuer;
        this.issueDate = issueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "CertificateDTO{" + "id=" + id + ", name=" + name + ", issuer=" + issuer + ", issueDate=" + issueDate + '}';
    }
    
    

}