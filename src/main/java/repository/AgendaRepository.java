package repository;

import model.Contacto;

import java.util.List;

public interface AgendaRepository {
    void agregarContacto(Contacto contacto);

    Contacto recuperarContacto(String email);

    void eliminarContacto(String email);

    List<Contacto> devolverContactos();

    void eliminarContacto(int idContacto);

    Contacto recuperarContacto(int idContacto);

    void actualizarContacto(Contacto contacto);
}
