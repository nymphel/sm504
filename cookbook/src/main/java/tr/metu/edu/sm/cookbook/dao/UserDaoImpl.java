package tr.metu.edu.sm.cookbook.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer>
		implements UserDao, Serializable {

	private static final long serialVersionUID = 9147308305954986944L;

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		
		CriteriaQuery<User> q = cb.createQuery(User.class);
		Root<User> c = q.from(User.class);
		q.select(c);
		
		ParameterExpression<String> emailP = cb.parameter(String.class);
		ParameterExpression<String> passwordP = cb.parameter(String.class);
		
		q.where(cb.equal(c.get("email"), emailP), cb.equal(c.get("password"), passwordP));
		

		TypedQuery<User> query = entityManager.createQuery(q);
		query.setParameter(emailP, email);
		query.setParameter(passwordP, password);
		
		List<User> results = query.getResultList();

		if (results != null && !results.isEmpty()) {
			return results.get(0);
		}

		return null;
	}

	@Override
	public boolean findUsersWithEmailOrUsername(String email, String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
