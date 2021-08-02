package com.unBosque.dao;

import com.unBosque.dao.impl.AuditDAO_Impl;
import com.unBosque.dao.impl.GoalScorerDAO_Impl;
import com.unBosque.dao.impl.MenuDAO_Impl;
import com.unBosque.dao.impl.NewsDAO_Impl;
import com.unBosque.dao.impl.ParameterDAO_Impl;
import com.unBosque.dao.impl.RefereeDAO_Impl;
import com.unBosque.dao.impl.ScheduleDAO_Impl;
import com.unBosque.dao.impl.StadiumDAO_Impl;
import com.unBosque.dao.impl.TeamDAO_Impl;
import com.unBosque.dao.impl.UserDAO_Impl;

public class DAOFactory {
	
	public static AuditDAO getAuditDAO () {
		return new AuditDAO_Impl();
	}
	
	public static GoalScorerDAO getGoalScorerDAO () {
		return new GoalScorerDAO_Impl();
	}
	
	public static MenuDAO getMenuDAO () {
		return new MenuDAO_Impl();
	}
	
	public static NewsDAO getNewsDAO () {
		return new NewsDAO_Impl();
	}
	
	public static ParameterDAO getParameterDAO () {
		return new ParameterDAO_Impl();
	}
	
	public static RefereeDAO getRefereeDAO () {
		return new RefereeDAO_Impl();
	}
	
	public static ScheduleDAO getScheduleDAO () {
		return new ScheduleDAO_Impl();
	}
	
	public static StadiumDAO getStadiumDAO () {
		return new StadiumDAO_Impl();
	}
	
	public static TeamDAO getTeamDAO () {
		return new TeamDAO_Impl();
	}
	
	public static UserDAO getUserDAO () {
		return new UserDAO_Impl();
	}
	
}
