package es.wata.jalmansa.springuebung.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projekte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDateTime date;
	
	@JsonIgnore
	@OneToMany(mappedBy = "projekte")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Mitarbeiter> mitarbeiterList;

	public Projekte() {
		super();
	}

	public Projekte(String name, LocalDateTime date, List<Mitarbeiter> mitarbeiterList) {
		super();
		this.name = name;
		this.date = date;
		this.mitarbeiterList = mitarbeiterList;
	}

	public Projekte(Long id, String name, LocalDateTime date, List<Mitarbeiter> mitarbeiterList) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.mitarbeiterList = mitarbeiterList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public List<Mitarbeiter> getMitarbeiterList() {
		return mitarbeiterList;
	}

	public void setMitarbeiterList(List<Mitarbeiter> mitarbeiterList) {
		this.mitarbeiterList = mitarbeiterList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mitarbeiterList == null) ? 0 : mitarbeiterList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projekte other = (Projekte) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mitarbeiterList == null) {
			if (other.mitarbeiterList != null)
				return false;
		} else if (!mitarbeiterList.equals(other.mitarbeiterList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projekte [id=" + id + ", name=" + name + ", date=" + localDateToString() + "]";
	}
	
	private String localDateToString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return date.format(formatter);
	}

}
