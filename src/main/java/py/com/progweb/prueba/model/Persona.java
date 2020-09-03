package py.com.progweb.prueba.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="persona")

public class Persona {
    @Id
    @Column(name = "id_persona")
    @Basic(optional = false )
    @GeneratedValue(generator = "personaSec",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "personaSec", sequenceName = "persona_sec", allocationSize = 0)
    private Integer id_persona;


    @Column(name = "apellido", length = 50)
    @Basic(optional = false )
    private String apellido;


    @Column(name = "nombre", length = 50)
    @Basic(optional = false )
    private  String nombre;


    @OneToMany(mappedBy = "persona")
    private List<Agenda> listaAgenda;


    public Persona() {


    }

    public Integer getId_persona() {
        return id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Agenda> getListaAgenda() {
        return listaAgenda;
    }

    public void setListaAgenda(List<Agenda> listaAgenda) {
        this.listaAgenda = listaAgenda;
    }
}
