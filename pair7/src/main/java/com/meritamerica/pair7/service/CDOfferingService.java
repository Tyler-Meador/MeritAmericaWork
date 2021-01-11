package com.meritamerica.pair7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.pair7.model.CDOffering;
import com.meritamerica.pair7.repository.CDOfferingRepository;


@Service
public class CDOfferingService {
	@Autowired
	private CDOfferingRepository repository;
	
	public CDOffering addAccount(CDOffering acc) {
		return repository.save(acc);
	}
	
	public List<CDOffering> getAccount(){
		return repository.findAll();
	}
	
	public List<CDOffering> getAccountById(Iterable<Integer> ids){
		return repository.findAllById(ids);
	}
}
