package com.sloan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Dan Castillo</br>
 * Creation Date: 11/28/2014</br>
 * @since .75</p>
 * 
 * The purpose of this class is to encapsulate authorization definition</br>
 * where an authorization is analogous to either a group or an attribute</br>
 * as of 11/28/2014 Geppetto supports only groups
 *
 * Modified Date: 12/03/2015
 * Modified By: Suresh Palanisamy
 * 
 * Added "@JsonIgnoreProperties(ignoreUnknown=true)"
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class GpAuthorization {
	@Id
	@GeneratedValue
	private long id;
	@Column
	private String name;
	@Column
	private String label;
	@Column
	private String type;
	@Column
	private String description;
	@Column
	private String notes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	
	
	

}
