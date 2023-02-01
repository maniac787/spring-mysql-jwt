package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.AgendaRepository;
import model.Contacto;

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	AgendaRepository dao;
	@Override
	public boolean agregarContacto(Contacto contacto) {
		if(dao.recuperarContacto(contacto.getIdContacto())==null) {
			dao.agregarContacto(contacto);
			return true;
		}
		return false;
	}

	@Override
	public List<Contacto> recuperarContactos() {
		return dao.devolverContactos();
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		if(dao.recuperarContacto(contacto.getIdContacto())!=null) {
			dao.actualizarContacto(contacto);
		}

	}

	@Override
	public boolean eliminarContacto(int idContacto) {
		if(dao.recuperarContacto(idContacto)!=null) {
			dao.eliminarContacto(idContacto);
			return true;
		}
		return false;
	}

	@Override
	public Contacto buscarContacto(int idContacto) {
		return dao.recuperarContacto(idContacto);
	}

}
