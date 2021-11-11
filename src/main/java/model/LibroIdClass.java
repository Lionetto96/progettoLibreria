package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LibroIdClass implements Serializable { //

	private static final long serialVersionUID = 1L;

	private int libroId;

	private String nome;
	
	public int getlibroId() {
		return libroId;
	}
	public void setCaneId(int libroId) {
		this.libroId = libroId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + libroId;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		LibroIdClass other = (LibroIdClass) obj;
		if (libroId != other.libroId)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
