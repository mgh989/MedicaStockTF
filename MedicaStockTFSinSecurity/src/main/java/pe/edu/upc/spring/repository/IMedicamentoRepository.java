package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Medicamento;

@Repository
public interface IMedicamentoRepository extends JpaRepository<Medicamento, Integer> {

	@Query("from Medicamento m where m.nombreMedicamento like %:nombreMedicamento%")
	List<Medicamento> buscarNombre(@Param("nombreMedicamento") String nombreMedicamento); 
}