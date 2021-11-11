package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Libro")
@NamedQuery(name = "findAllLibri", query = "SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_libro")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_libro;
	@Column(nullable = false, name = "titolo")
	private String titolo;
	@Column(name = "pagine")
	private int numeroPagine;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_autore")
//	private Autore idAutore;

	public int getId_libro() {
		return id_libro;
	}

	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

//	public Autore getIdAutore() {
//		return idAutore;
//	}
//
//	public void setIdAutore(Autore idAutore) {
//		this.idAutore = idAutore;
//	}
//
//	@Override
//	public String toString() {
//		return "Libro [id_libro=" + id_libro + ", titolo=" + titolo + ", numeroPagine=" + numeroPagine + ", idAutore="
//				+ idAutore + "]";
//	}
}