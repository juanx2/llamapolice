package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.model.Denunciante;

@Repository
public interface IDenuncianteRepository extends JpaRepository<Denunciante, Integer> {
	@Query("from Denunciante d where d.nombreDenunciante like %:nombreDenunciante%")
	List<Denunciante> buscarNombre(@Param("nombreDenunciante") String nombreDenunciante);
}
