package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.Schedule;

public interface ScheduleDAO {

	public void save(Schedule schedule);

	public Schedule getSchedule(String idSchedule);

	public List<Schedule> list();

	public void remove(Schedule schedule);

	public void update(Schedule schedule);
	
}
