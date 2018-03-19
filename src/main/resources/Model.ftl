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
@Table(name = "${object?lower_case}")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
public class ${object}Model  implements Serializable{

	private static final long serialVersionUID = 1L;  

	
   	<#list fields?keys as key>	
	private ${fields[key]} ${key}; 
	
	</#list>
	
	public ${object}Model() {
		super();
	}
	
	<#list fields?keys as key>
	<#if key_index == 0>
	
	@Id
	@Column(name = "${key}")
	public ${fields[key]} get${key?substring(0,1)?upper_case}${key?substring(1)}() {
		return ${key};
	}
	<#else>
	@Column(name = "${key}")
	public ${fields[key]} get${key?substring(0,1)?upper_case}${key?substring(1)}() {
		return ${key};
	}
	</#if>
	
	public void set${key?substring(0,1)?upper_case}${key?substring(1)}(${fields[key]} ${key}) {
		this.${key} = ${key};
	}
	
	</#list>
}