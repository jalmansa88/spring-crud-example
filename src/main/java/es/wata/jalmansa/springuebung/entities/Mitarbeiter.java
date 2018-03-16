package es.wata.jalmansa.springuebung.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Mitarbeiter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String name;
	private Integer age;

	@ManyToOne
	@JoinColumn(name = "projekte_id", referencedColumnName = "id")
	private Projekte projekte;
	
	public Mitarbeiter() {
		super();
	}
	
	public Mitarbeiter(String username, String name, Integer age, Projekte projekte) {
		super();
		this.username = username;
		this.name = name;
		this.age = age;
		this.projekte = projekte;
	}

	public Mitarbeiter(Long id, String username, String name, Integer age, Projekte projekte) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.age = age;
		this.projekte = projekte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Projekte getProjekte() {
		return projekte;
	}

	public void setProjekte(Projekte projekte) {
		this.projekte = projekte;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((projekte == null) ? 0 : projekte.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Mitarbeiter other = (Mitarbeiter) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projekte == null) {
			if (other.projekte != null)
				return false;
		} else if (!projekte.equals(other.projekte))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mitarbeiter [id=" + id + ", username=" + username + ", name=" + name + ", age=" + age + ", projekte="
				+ projekte + "]";
	}

}
