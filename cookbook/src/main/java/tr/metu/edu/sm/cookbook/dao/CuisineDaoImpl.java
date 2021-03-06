package tr.metu.edu.sm.cookbook.dao;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.Cuisine;

@Repository
public class CuisineDaoImpl extends GenericDaoImpl<Cuisine, Integer> implements
		CuisineDao {

}
