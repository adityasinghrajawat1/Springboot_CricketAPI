package com.spring.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.restapi.model.Cricket;
import com.spring.restapi.repository.CricketRepository;

@Service
public class CricketService {

	@Autowired 
	CricketRepository repo;
	
	public Cricket saveCricketer(Cricket cricket)
	{
		for(int i=0;i<100;i++)
		{
			Cricket  c = new Cricket();
			c.setName("name"+i);
			c.setAge(23);
			c.setNick_name("nick_name"+i);
			//repo.save(c);
		}
		return repo.save(cricket);
	}
	
	public List<Cricket> getAllCricketer()
	{
		return repo.findAll();
	}
	
	
	public boolean removeCricketer(int id)
	{
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			 return true;
		}
		
		throw new IllegalArgumentException("No Cricketer with id-"+id+" present.");
	}
	
	public Optional<Cricket> getCricketerById(int id)
	{
		return repo.findById(id);
	}
	
	
	public Cricket updateCricketerInfo(int id , Cricket cricket)
	{
		 Optional<Cricket> optionalCricket = repo.findById(id);
		 
		 if(optionalCricket.isPresent())
		 {
			 Cricket cricket2 = optionalCricket.get();
			 
			 cricket2.setName(cricket.getName());
			 cricket2.setAge(cricket.getAge());
			 cricket2.setNick_name(cricket.getNick_name());
			 
			 return repo.save(cricket2);
		 }
		 
		 throw new IllegalArgumentException("No Cricketer found with id: "+id);
	}
	
	
	
	public Page<Cricket> getPages(int page, int size)
	{
		Pageable pageable = PageRequest.of(page, size);
		return repo.findAll(pageable);
	}
}
