package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.RatingDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Rating;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "ratingService")
public class RatingServiceImpl extends
		GenericServiceImpl<Rating, Integer> implements
		RatingService<Rating, Integer> {

	@Autowired
	private RatingDao dao;

	@Override
	public GenericDao<Rating, Integer> getDao() {
		return this.dao;
	}

}
