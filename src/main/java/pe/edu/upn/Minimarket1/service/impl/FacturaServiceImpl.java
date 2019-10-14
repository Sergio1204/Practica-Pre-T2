package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.upn.Minimarket1.model.entity.Factura;
import pe.edu.upn.Minimarket1.model.repository.FacturaRepository;
import pe.edu.upn.Minimarket1.service.FacturaService;

public class FacturaServiceImpl implements FacturaService{
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Transactional()
	@Override
	public List<Factura> findAll() throws Exception{
		return facturaRepository.findAll();
	}
	
	@Transactional
	@Override
	public Optional<Factura> findById(Integer id) throws Exception{
		return facturaRepository.findById(id);
	}
	
	@Transactional
	@Override
	public Factura save(Factura entity) throws Exception{
		return facturaRepository.save(entity);
	}
	
	@Transactional
	@Override
	public Factura update(Factura entity) throws Exception{
		return facturaRepository.save(entity);
	}
	
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception{
		facturaRepository.deleteById(id);
	}
	
	@Transactional
	@Override
	public void deleteAll() throws Exception{
		facturaRepository.deleteAll();
	}
}
