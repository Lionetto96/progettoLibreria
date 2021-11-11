package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Autore")
@NamedQueries({ @NamedQuery(name = "findAllAutori", query = "SELECT a FROM Autore a"), // HQL >> for hibernate
	//@NamedQuery(name = "findAutorebyname", query = "SELECT a FROM Autore a where a.nome=:"+Autore.NAMED_QUERY_PER_RICERCA_BY_NOME"
})
//@JasonIgnoreProperties(value = {"cognome"})
public class Autore implements Serializable {
	private static final long serialVersionUID = 1L;

//	
//	//named query listed 
//	public final static String NAMED_QUERY_ALL = "findAllAutori";
//	public final static String NAMED_QUERY_PER_RICERCA_BY_NOME = "findAutorebyname";
//	//parameters query listed 
//	public final static String PARAM_QUERY_NOME="nome";
	@Id
	@Column(name = "id_Autore", nullable = false)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cognome")
	private String cognome;

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "autore") // nome che mappa l'entita'
//	@Transient
//	private List<Libro> libri;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

//	public List<Libro> getLibri() {
//		return libri;
//	}
//
//	public void setLibri(List<Libro> libri) {
//		this.libri = libri;
//	}

}
