package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo er;
	
	public EmployeeEntity saveinfo(EmployeeEntity ee)
	{
		return er.save(ee);
	}
	
	public List<EmployeeEntity> savedetails(List<EmployeeEntity> ee) {
		return (List<EmployeeEntity>)er.saveAll(ee);
	}
	
	public List<EmployeeEntity> showinfo()
	{
		return er.findAll();
	}
	public Optional<EmployeeEntity> showone(int id) {
		return er.findById(id);
	}
	
	public EmployeeEntity updateinfo(EmployeeEntity ee)
	{
		return er.saveAndFlush(ee);
	}
	
	public String deleteinfo(int id) {
		er.deleteById(id);
		return "Succesfully deleted :" + id;
	}
}
