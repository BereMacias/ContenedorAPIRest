package com.example.helados.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helados.entity.Helado;
import com.example.helados.repository.HeladoRepository;

@Service
public class HeladoService{
	
	@Autowired
	private HeladoRepository heladoRepository;
	
	public Helado createHelado (Helado helado) {
		return heladoRepository.save(helado);
	}
	
	public List<Helado> getAllHelado() {
		return heladoRepository.findAll();
	}
	
	public Optional<Helado> findByIdHelado(Long id){
		return heladoRepository.findById(id);
	}
	
	public Helado updateHelado(Helado helado, Long id) {
		
		Helado heladoprep = this.findByIdHelado(id).orElse(null);
		
		if (heladoprep != null) {
			heladoprep.setNombreHelado(helado.getNombreHelado());
			heladoprep.setSabor(helado.getSabor());
			heladoprep.setTipoHelado(helado.getTipoHelado());
		}
		return heladoRepository.save(heladoprep);
	}
	
	public void deleteByIdHelado(Long id) {
		heladoRepository.deleteById(id);
	}
	
	

}
