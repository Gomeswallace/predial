package com.automacaopredial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automacaopredial.domain.Usuario;
import com.automacaopredial.domain.enums.TipoUsuario;
import com.automacaopredial.dto.UsuarioDTO;
import com.automacaopredial.dto.UsuarioNewDTO;
import com.automacaopredial.repositories.UsuarioRepository;
import com.automacaopredial.security.UserSS;
import com.automacaopredial.services.exceptions.AuthorizationException;
import com.automacaopredial.services.exceptions.DataIntegrityException;
import com.automacaopredial.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;

	@Autowired
	private BCryptPasswordEncoder pe;

	// @Autowired
	// private S3Service s3Service;

	// @Autowired
	// private ImageService imageService;

	// @Value("${img.prefix.client.profile}")
	// private String prefix;

	// @Value("${img.profile.size}")
	// private Integer size;

	public Usuario find(Integer id) {
		//retorna o usuario logado
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(TipoUsuario.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	@Transactional
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Usuario> findAll() {
		return repo.findAll();
	}

	public Usuario findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(TipoUsuario.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		Usuario obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}

	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Usuario fromDTO(UsuarioDTO objDTO) {
		return new Usuario(objDTO.getId(), objDTO.getNome(), 
						   objDTO.getEmail(), pe.encode(objDTO.getSenha()));
	}

	public Usuario fromDTO(UsuarioNewDTO objNewDto) {
		Usuario user = new Usuario(null, objNewDto.getNome(), objNewDto.getEmail(), 
									pe.encode(objNewDto.getSenha()));
		return user;
	}

	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	/*
	 * public URI uploadProfilePicture(MultipartFile multipartFile) { UserSS user =
	 * UserService.authenticated(); if (user == null) { throw new
	 * AuthorizationException("Acesso negado"); }
	 * 
	 * BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
	 * jpgImage = imageService.cropSquare(jpgImage); jpgImage =
	 * imageService.resize(jpgImage, size);
	 * 
	 * String fileName = prefix + user.getId() + ".jpg";
	 * 
	 * return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"),
	 * fileName, "image"); }
	 */
}
