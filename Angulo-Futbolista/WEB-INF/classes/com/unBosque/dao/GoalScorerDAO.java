package com.unBosque.dao;

import java.util.List;

import com.unBosque.entities.GoalScorer;

public interface GoalScorerDAO {

	public void save(GoalScorer goalScorer);

	public GoalScorer getGoalScorer(String idGoalScorer);

	public List<GoalScorer> list();

	public void remove(GoalScorer goalScorer);

	public void update(GoalScorer goalScorer);
	
}
