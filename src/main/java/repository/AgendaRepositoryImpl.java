package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Contacto;

@Repository
public class AgendaRepositoryImpl implements AgendaRepository {

	final AgendaJpaRepository agenda;

	public AgendaRepositoryImpl(AgendaJpaRepository agenda) {
		this.agenda = agenda;
	}


	@Override
	public void agregarContacto(Contacto contacto) {
		agenda.save(contacto);
	}

	@Override
	public Contacto recuperarContacto(String email) {
		return agenda.findByEmail(email);
	}

	@Override
	public void eliminarContacto(String email) {
		agenda.eliminarPorEmail(email);
	}

	@Override
	public List<Contacto> devolverContactos() {
		return agenda.findAll();
	}
	
	@Override
	public void eliminarContacto(int idContacto) {
		agenda.deleteById(idContacto);
		
	}

	@Override
	public Contacto recuperarContacto(int idContacto) {	
		return agenda.findById(idContacto).orElse(null);
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		agenda.save(contacto);
		
	}
	

}
