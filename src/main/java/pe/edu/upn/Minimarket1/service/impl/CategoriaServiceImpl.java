package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.Minimarket1.model.entity.Categoria;
import pe.edu.upn.Minimarket1.model.repository.CategoriaRepository;
import pe.edu.upn.Minimarket1.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Categoria> findAll() throws Exception{
		return categoriaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Categoria> findById(String id) throws Exception{
		return categoriaRepository.findById(id);
	}
	
	@Transactional
	@Override
	public Categoria save(Categoria entity) throws Exception{
		return categoriaRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Categoria update(Categoria entity) throws Exception{
		return categoriaRepository.save(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(String id) throws Exception{
		categoriaRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception{
		categoriaRepository.deleteAll();
	}
	
}
