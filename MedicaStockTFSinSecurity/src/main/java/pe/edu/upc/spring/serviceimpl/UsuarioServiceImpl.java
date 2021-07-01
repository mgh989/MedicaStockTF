package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.repository.IUsuarioRepository;
import pe.edu.upc.spring.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioRepository uUsuario;
	
	
	@Override
	@Transactional
	public boolean insertar(Usuario usuario) {
		Usuario objUsuario = uUsuario.save(usuario);
		if(objUsuario == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Usuario usuario) {
		boolean flag =  false;
		try {
			uUsuario.save(usuario);
			flag = true;			
		}
		catch (Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idUsuario) {
		uUsuario.deleteById(idUsuario);
	}

	@Override
	public Optional<Usuario> buscarId(int idUsuario) {
		return uUsuario.findById(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> listarId(int idUsuario) {
		return uUsuario.findById(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return uUsuario.findAll();
	}
}