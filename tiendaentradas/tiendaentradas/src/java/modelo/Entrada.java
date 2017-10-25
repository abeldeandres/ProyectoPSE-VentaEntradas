package modelo;
// Generated 29-may-2014 20:28:38 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entrada generated by hbm2java
 */
@Entity
@Table(name="entrada"
    ,catalog="tiendaentradas"
)
public class Entrada  implements java.io.Serializable {


     private Integer idEntrada;
     private String tipo;
     private int numero;
     private float precio;
     private int idConcierto;

    public Entrada() {
    }

    public Entrada(String tipo, int numero, float precio, int idConcierto) {
       this.tipo = tipo;
       this.numero = numero;
       this.precio = precio;
       this.idConcierto = idConcierto;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_entrada", unique=true, nullable=false)
    public Integer getIdEntrada() {
        return this.idEntrada;
    }
    
    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }
    
    @Column(name="tipo", nullable=false, length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Column(name="numero", nullable=false)
    public int getNumero() {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Column(name="precio", nullable=false, precision=12, scale=0)
    public float getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    @Column(name="id_concierto", nullable=false)
    public int getIdConcierto() {
        return this.idConcierto;
    }
    
    public void setIdConcierto(int idConcierto) {
        this.idConcierto = idConcierto;
    }




}

