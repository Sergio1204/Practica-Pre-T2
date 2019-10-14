package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.Minimarket1.model.entity.Transaccion;
import pe.edu.upn.Minimarket1.model.repository.TransaccionRepository;
import pe.edu.upn.Minimarket1.service.TransaccionService;

@Service
public class TransaccionServiceImpl implements TransaccionService{
	@Autowired
	private TransaccionRepository transaccionRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Transaccion> findAll() throws Exception {
		return transaccionRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Transaccion> findById(Integer id) throws Exception {
		return transaccionRepository.findById(id);
	}

	@Transactional
	@Override
	public Transaccion save(Transaccion entity) throws Exception {
		return transaccionRepository.save(entity);
	}

	@Transactional
	@Override
	public Transaccion update(Transaccion entity) throws Exception {
		return transaccionRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		transaccionRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		transaccionRepository.deleteAll();
	}
}
