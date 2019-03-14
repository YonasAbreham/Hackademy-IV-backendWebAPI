package io.orten.nano.model;

import javax.persistence.*;
/**
 *represents an organization raising fund for one or more projects
 */
@Entity
@Table(name="organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationId;
    private String organizationNumber;
    private String name;
    private String address;
    private String contactPersonName;
    private String contactPersonEmail;
    private String accountNumber;
    private String billingInformation;
    private String description;

    /**
     * default constructor required by hibernate
     */
    public Organization()
    {

    }

    /**
     *  Bussiness Constructor
     */
    public Organization(Long organizationID,String organizationNumber, String organizationName
            , String organizationAddress, String contactPersonName, String contactPersonEmail
            , String accountNumber,String billingInformation, String description) {
        this.organizationId = organizationID;
        this.organizationNumber= organizationNumber;
        this.name = organizationName;
        this.address = organizationAddress;
        this.contactPersonName = contactPersonName;
        this.contactPersonEmail = contactPersonEmail;
        this.accountNumber = accountNumber;
        this.billingInformation = billingInformation;
        this.description = description;

    }

    /**
     * getters and setters
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonEmail() {
        return contactPersonEmail;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBillingInformation() {
        return billingInformation;
    }

    public void setBillingInformation(String billingInformation) {
        this.billingInformation = billingInformation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

