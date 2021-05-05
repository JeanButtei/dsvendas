package com.jeanbuttei.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeanbuttei.dsvendas.dto.SaleDTO;
import com.jeanbuttei.dsvendas.entities.Sale;
import com.jeanbuttei.dsvendas.repositories.SaleRepository;
import com.jeanbuttei.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll(); //Evitar muitas consultas para carregar Sellers
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
}