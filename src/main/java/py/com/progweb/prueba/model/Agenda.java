package py.com.progweb.prueba.model;



import org.jboss.remoting.samples.chat.exceptions.DatabaseException;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "agenda")

public class Agenda {
    @Id
    @Column(name = "id_agenda")
    @Basic(optional = false)
    @GeneratedValue(generator = "agendaSec", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "agendaSec", sequenceName = "agenda_sec", allocationSize = 0)
    private Integer idAgenda;


    @Column(name = "actividad")
    @Basic(optional = false)
    private String actividad;


    @Column(name = "fecha")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona persona;




    public Agenda() {
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

