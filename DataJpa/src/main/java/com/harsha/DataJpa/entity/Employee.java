
package com.harsha.DataJpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;


@TypeDefs ({
    @TypeDef(name = "json", typeClass = JsonStringType.class),
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
    })
@Table(name = "Employee")
@Entity
public class Employee {

	@Id
	@Column
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Type(type = "jsonb")
	@Column(name="Details", columnDefinition = "jsonb")
	private String details;
	
	@Type(type = "jsonb")
	@Column(name="Contact", columnDefinition = "jsonb")
	private String contact;

	
	
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

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


	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", details=" + details + ", contact=" + contact + "]";
	}

	
	
	
}
