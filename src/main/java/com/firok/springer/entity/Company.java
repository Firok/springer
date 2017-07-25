package com.firok.springer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Company entity
 * @author Firok
 * @since 7/24/2017
 */
@Entity
@NamedQueries({
	@NamedQuery(name="company.findByCompanyName", query="SELECT c FROM Company c WHERE c.companyName=:companyName")
})
public class Company implements Serializable{
	
	/**
	 * serialization version UID for 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@NotEmpty(message = "The company name can not be null")
	@Column(unique=true)
	private String companyName;
	
    private String companyDescription;
    
    private String companyWebsite;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Job> jobs= new LinkedList<>();

    /**
     * default constructor 
     */
	public Company() {
		
	}

	/**
	 * constructor with parameters
	 * @param companyName The company name to set
	 * @param companyDescription The company description to set
	 * @param companyWebsite The company website to set
	 */
	public Company(String companyName, String companyDescription, String companyWebsite) {
		this.companyName = companyName;
		this.companyDescription = companyDescription;
		this.companyWebsite = companyWebsite;
	}

	/**
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Method to get the company name
	 * @return The company name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * Method to set company name
	 * @param companyName The company name to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * Method to get company description
	 * @return The company description
	 */
	public String getCompanyDescription() {
		return companyDescription;
	}

	/**
	 * Method to set the company description
	 * @param companyDescription The company description to set
	 */
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	/**
	 * Method to get the company website
	 * @return The company website
	 */
	public String getCompanyWebsite() {
		return companyWebsite;
	}

	/**
	 * Method to set the company website
	 * @param companyWebsite
	 */
	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	/**
	 * Method to get the created date of the company record
	 * @return The created date of the company record
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Method to set the date of creation of the company record
	 * @param createdDate The created date to be set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Method to get the updated date of the company record
	 * @return the modified date
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * Method to set the updated date of the company record
	 * @param modifiedDate the modified date to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	/**
	 * Method the get the company jobs
	 * @return the list of company jobs
	 */
	public List<Job> getJobs() {
		return jobs;
	}	
	
	/**
	 * Method to set the created date before the record
	 */
	@PrePersist
	public void addCreatedDate(){
		this.createdDate = new Date();
	}
	
	/**
	 * Method to set the Modified date before the updating
	 */
	@PreUpdate
    private void addModifiedDate() {
        this.modifiedDate = new Date();
    }

	
    
	
    

}
