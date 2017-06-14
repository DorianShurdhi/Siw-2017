package it.uniroma3.siw.progetto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Opera {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @NotNull
	 @Size(min=1,message="il titolo dell'opera non può essere nulla")
	 private String titolo;
	 
	  @Temporal (TemporalType.TIMESTAMP)
	  private Date annoDiCreazione;
	  private String tecnica;
	  private String dimensioni;
	  
 
	  @OneToOne
	  private Autore autore;
	  

		public Opera(String titolo, Autore autore, Date anno, String tecnica, String dimensioni, String restauro) {
			super();
			this.titolo = titolo;
			this.autore = autore;
			this.annoDiCreazione = anno;
			this.setTecnica(tecnica);
			this.dimensioni = dimensioni;
			this.restauro = restauro;
			
		}
	public String getRestauro() {
			return restauro;
		}
		public void setRestauro(String restauro) {
			this.restauro = restauro;
		}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Date getAnnoDiCreazione() {
		return annoDiCreazione;
	}

	public void setAnnoDiCreazione(Date annoDiCreazione) {
		this.annoDiCreazione = annoDiCreazione;
	}

	public String getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Opera[id=%d, titolo='%s', autore='%s']",
                id, titolo, autore);
    }

}
