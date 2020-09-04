package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.Agenda;
import py.com.progweb.prueba.model.Persona;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PersonaDAO {
    @PersistenceContext(unitName = "pruebaPU")

    private EntityManager em;

    @Inject
    AgendaDAO agendaDao;

    /**
     * Cada vez que querramos persistir una persona, persistimos tb su agenda.
     * Por cada persona, le pasamos la agenda.
     *
     * @param entidad
     */
    public void agregar(Persona entidad) {
        this.em.persist(entidad);
        for (Agenda a : entidad.getListaAgenda()) {
            a.setPersona(entidad);
            agendaDao.agregar(a);

        }
    }

    public Object lista() {
        Query q = this.em.createQuery("select p from Persona p");
        List<Persona> personas = (List<Persona>) q.getResultList();
        for(Persona p : personas) {
            q = this.em.createQuery("select a from Agenda a where a.persona = "+p.getId_persona());
            p.setListaAgenda((List<Agenda>) q.getResultList());
        }
        return personas;
    }


}
