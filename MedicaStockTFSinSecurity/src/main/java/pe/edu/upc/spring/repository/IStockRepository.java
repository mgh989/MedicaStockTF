package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Stock;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Integer> {

	@Query("from Stock s where s.medicamento.nombreMedicamento like %:nombreMedicamento%")
	List<Stock> buscarMedicamento(@Param ("nombreMedicamento") String nombreMedicamento);
	
	@Query("from Stock s where s.farmacia.nombreFarmacia like %:nombreFarmacia%")
	List<Stock> buscarFarmacia(@Param ("nombreFarmacia") String nombreFarmacia);
}