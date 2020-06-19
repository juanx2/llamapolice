package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Denunciante;

public interface IDenuncianteService {

	public boolean insertar(Denunciante Denunciante);
	public boolean modificar(Denunciante Denunciante);
	public void eliminar(int idDenunciante);
	public Optional<Denunciante> buscarId(int idDenunciante);
	public Optional<Denunciante> listarId(int idDenunciante);
	public List<Denunciante> listar();
	public List<Denunciante> buscarNombre(String nombreDenunciante);
	
	
}
