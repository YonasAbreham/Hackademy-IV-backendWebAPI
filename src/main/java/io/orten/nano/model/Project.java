package io.orten.nano.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long Id;
    @Column(name = "projectNumber",unique = true)
    private String projectNumber;
    @Column(name = "projectName")
    private String projectName;
    @Column(name = "address")
    private String address;
    @Column(name = "fromDate")
    private Date fromDate;
    @Column(name = "toDate")
    private Date toDate;
    @Column(name = "longitude")
    private float longitude;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "amountToBeRaised")
    private double amountToBeRaised;
    @Column(name = "raisedFunding")
    private double raisedFunding;
    @Column(name = "description")
    private String description;
    @Column(name = "mainImage")
    private String mainImage;
    @Column(name = "images")
    private String images;
    @Column(name = "projectManager")
    private String projectManager;
    @Column(name = "nationalProject")
    private boolean nationalProject;
    @Column(name = "recurringProject")
    private boolean recurringProject;
    @Column(name = "recurringProjectPublishingDate")
    private Date recurringProjectPublishingDate;
    @Column(name = "organizationId")
    private long organizationId;

    public Project(){}

    public long getId() {
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getProjectNumber() {return projectNumber;}
    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getFromDate() {
        return fromDate;
    }
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    public Date getToDate() {
        return toDate;
    }
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    public float getLongitude() {
        return longitude;
    }
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    public float getLatitude() {
        return latitude;
    }
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    public double getAmountToBeRaised() {
        return amountToBeRaised;
    }
    public void setAmountToBeRaised(double amountToBeRaised) {
        this.amountToBeRaised = amountToBeRaised;
    }
    public double getRaisedFunding() {
        return raisedFunding;
    }
    public void setRaisedFunding(double raisedFunding) {
        this.raisedFunding = raisedFunding;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getMainImage() {
        return mainImage;
    }
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public String getProjectManager() {
        return projectManager;
    }
    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
    public boolean isNationalProject() {
        return nationalProject;
    }
    public void setNationalProject(boolean nationalProject) {
        this.nationalProject = nationalProject;
    }
    public boolean isRecurringProject() {
        return recurringProject;
    }
    public void setRecurringProject(boolean recurringProject) {
        this.recurringProject = recurringProject;
    }
    public Date getRecurringProjectPublishingDate() {
        return recurringProjectPublishingDate;
    }
    public void setRecurringProjectPublishingDate(Date recurringProjectPublishingDate) {
        this.recurringProjectPublishingDate = recurringProjectPublishingDate;}
    public long getOrganizationId() {
        return organizationId;
    }
    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }
}