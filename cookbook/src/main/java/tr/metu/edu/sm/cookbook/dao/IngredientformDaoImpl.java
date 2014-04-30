package tr.metu.edu.sm.cookbook.dao;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.Ingredientform;

@Repository
public class IngredientformDaoImpl extends GenericDaoImpl<Ingredientform, Integer> implements
		IngredientformDao {

}
