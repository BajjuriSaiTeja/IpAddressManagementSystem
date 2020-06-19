package com.IPAddressManagement.app.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Entity
@Table(name = "IPAddress")
public class IPModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String ipAddress;
    private boolean accquired;

    public IPModel() {
    }

    public IPModel(String ipAddress, boolean accquired) {
        this.ipAddress = ipAddress;
        this.accquired = accquired;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public boolean isAccquired() {
        return accquired;
    }

    public void setAccquired(boolean accquired) {
        this.accquired = accquired;
    }
}