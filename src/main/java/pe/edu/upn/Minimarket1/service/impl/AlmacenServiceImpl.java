package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.Minimarket1.model.entity.Almacen;
import pe.edu.upn.Minimarket1.model.repository.AlmacenRepository;
import pe.edu.upn.Minimarket1.service.AlmacenService;

@Service
public class AlmacenServiceImpl implements AlmacenService{
	@Autowired
	private AlmacenRepository almacenRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Almacen> findAll() throws Exception {
		return almacenRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Almacen> findById(String id) throws Exception {
		return almacenRepository.findById(id);
	}

	@Transactional
	@Override
	public Almacen save(Almacen entity) throws Exception {
		return almacenRepository.save(entity);
	}

	@Transactional
	@Override
	public Almacen update(Almacen entity) throws Exception {
		return almacenRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		almacenRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		almacenRepository.deleteAll();
	}
}
