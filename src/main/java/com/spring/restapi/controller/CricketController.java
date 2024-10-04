package com.spring.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.model.Cricket;
import com.spring.restapi.service.CricketService;

@RestController
public class CricketController {

	@Autowired
	CricketService cricketService; 
	
	@GetMapping("start")
	public String message() 
	{
		return "Cricket is Life.";
	}
	
	
	@PostMapping("save")
	public Cricket saveCricketer(@RequestBody Cricket cricket) 
	{
		return cricketService.saveCricketer(cricket);
	}
	
	@GetMapping("get")
	public List<Cricket> getAllCricketer()
	{
		return cricketService.getAllCricketer();
	}
	
	@DeleteMapping("/remove/{id}")
	public String removeCricketer(@PathVariable int id)
	{
		cricketService.removeCricketer(id);
		return "Cricketer removed by id:"+id;
	}
	
	@GetMapping("/getById/{id}")
	public Optional<Cricket> getCricketerById(@PathVariable int id)
	{
		return cricketService.getCricketerById(id);
	}
	
	@PutMapping("/update/{id}")
	public Cricket updateCricketerInfo(@PathVariable int id,@RequestBody Cricket cric)
	{
		return cricketService.updateCricketerInfo(id, cric);
	}
	
	@GetMapping("/pagination")
	public Page<Cricket> getPages(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size)
	{
		Page<Cricket> cric = cricketService.getPages(page, size);
		return cric;
	}
}
