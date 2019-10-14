package pe.edu.upn.Minimarket1.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upn.Minimarket1.model.entity.Pedido;
import pe.edu.upn.Minimarket1.model.repository.PedidoRepository;
import pe.edu.upn.Minimarket1.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Pedido> findAll() throws Exception {
		return pedidoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Pedido> findById(Integer id) throws Exception {
		return pedidoRepository.findById(id);
	}

	@Transactional
	@Override
	public Pedido save(Pedido entity) throws Exception {
		return pedidoRepository.save(entity);
	}

	@Transactional
	@Override
	public Pedido update(Pedido entity) throws Exception {
		return pedidoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		pedidoRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		pedidoRepository.deleteAll();
	}
}
