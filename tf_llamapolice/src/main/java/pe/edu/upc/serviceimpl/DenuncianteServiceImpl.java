package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Denunciante;
import pe.edu.upc.repository.IDenuncianteRepository;
import pe.edu.upc.service.IDenuncianteService;

@Service
public class DenuncianteServiceImpl implements IDenuncianteService {
	

	
		@Autowired
		private IDenuncianteRepository dDenunciante;

		@Override
		@Transactional
		public boolean insertar(Denunciante denunciante) {
			Denunciante objDenunciante = dDenunciante.save(denunciante);
			if (objDenunciante!=null)
				return true;
			else 
				return false;
		}

		@Override
		@Transactional
		public boolean modificar(Denunciante denunciante) {
			boolean flag = false;
			try {
				dDenunciante.save(denunciante);
				flag = true;
			}
			catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			return flag;
		}

		@Override
		@Transactional
		public void eliminar(int idDenunciante) {
			dDenunciante.deleteById(idDenunciante);
		}

		@Override
		public Optional<Denunciante> buscarId(int idDenunciante) {
			return dDenunciante.findById(idDenunciante);	}

		@Override
		public Optional<Denunciante> listarId(int idDenunciante) {
			return dDenunciante.findById(idDenunciante);
		}

		@Override
		@Transactional(readOnly=true)
		public List<Denunciante> listar() {
			return dDenunciante.findAll();
		}

		@Override
		public List<Denunciante> buscarNombre(String nombreDenunciante) {
			return dDenunciante.buscarNombre(nombreDenunciante);
		}

	}

	
