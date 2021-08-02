package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.Parameter;

public interface ParameterDAO {

	public void save(Parameter parameter);

	public Parameter getParameter(String idParameter);

	public List<Parameter> list();

	public void remove(Parameter parameter);

	public void update(Parameter parameter);
	
}
