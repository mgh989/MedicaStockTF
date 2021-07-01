package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Stock;
import pe.edu.upc.spring.repository.IStockRepository;
import pe.edu.upc.spring.service.IStockService;

@Service
public class StockServiceImpl implements IStockService{

	@Autowired
	private IStockRepository sStock;
	
	@Override
	@Transactional
	public boolean insertar(Stock stock) {
		Stock objStock = sStock.save(stock);
		if(objStock!=null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Stock stock) {
		boolean flag = false;
		try {
			sStock.save(stock);
			flag=true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idStock) {
		sStock.deleteById(idStock);		
	}

	@Override
	public Optional<Stock> buscarId(int idStock) {
		return sStock.findById(idStock);
	}

	@Override
	public Optional<Stock> listarId(int idStock) {
		return sStock.findById(idStock);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Stock> listar() {
		return sStock.findAll();
	}
}