package fr.gtm.communes.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="regions")
@NamedQuery(name="Region.all", query = "SELECT r.nom FROM Region r")
@Access(AccessType.FIELD)
public class Region implements Serializable{
	@Id
	@XmlElement
	private String code;
	@Column(name="name")
	@XmlElement
	private String nom;

	public String getNom() {
		return nom;
	}
	public String getCode() {
		return code;
	}

}
