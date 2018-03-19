package com.oauth.resource.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * 
 * @authors Hassan.khani
 * @version 1.1.20170512
 * @change 
 * @target
 * 
 */
 

@Entity
@Table(name = "example")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
public class ExampleModel  implements Serializable{

	private static final long serialVersionUID = 1L;  

	
	private int id; 
	
	private String name; 
	
	private Long phone; 
	
	
	public ExampleModel() {
		super();
	}
	
	
	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "phone")
	public Long getPhone() {
		return phone;
	}
	
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
}