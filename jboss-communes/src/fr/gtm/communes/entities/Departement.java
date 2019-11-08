package fr.gtm.communes.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="departments")
@NamedQuery(name = "Departement.all",query = "SELECT d.nom FROM Departement d")
@NamedQuery(name = "Departement.allObjects",query = "SELECT d FROM Departement d")
public class Departement implements Serializable{
	@Id
	@XmlElement
	private String code;
	@Column(name="name")
	@XmlElement
	private String nom;
	@ManyToOne
	@JoinColumn(name="region_code")
	@XmlElement
	private Region region;
	
	public String getNom() {
		return nom;
	}
	public Region getRegion() {
		return region;
	}
	
	public String getNumero() {
		return code;
	}

}
