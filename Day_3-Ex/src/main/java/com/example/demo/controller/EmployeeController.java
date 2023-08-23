package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;
	
	@PostMapping("postdetails")
	public EmployeeEntity add(@RequestBody EmployeeEntity ee)
	{
		return es.saveinfo(ee);
	}
	
	@PostMapping("postmoredetails")
	public List<EmployeeEntity> addmore(@RequestBody List<EmployeeEntity> ee) {
		return es.savedetails(ee);
	}
	
	@GetMapping("showdetails")
	public List<EmployeeEntity> show()
	{
		return es.showinfo();
	}
	
	@GetMapping("showdetails/{id}")
	public Optional<EmployeeEntity> showemp(@PathVariable int id) {
		return es.showone(id);
	}
	
	@GetMapping("showdetail")
	public Optional<EmployeeEntity> showEmp(@RequestParam int id) {
		return es.showone(id);
	}
	
	@PutMapping("updatedetail")
	public EmployeeEntity update(@RequestBody EmployeeEntity ee) {
		return es.updateinfo(ee);
	}
	
	@DeleteMapping("delete")
	public String del(@RequestParam int id) {
		return es.deleteinfo(id);
	}
	
}
