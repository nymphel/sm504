package tr.metu.edu.sm.cookbook.dao;

import org.springframework.stereotype.Repository;

import tr.metu.edu.sm.cookbook.dao.parent.GenericDaoImpl;
import tr.metu.edu.sm.cookbook.entity.Comment;

@Repository
public class CommentDaoImpl extends GenericDaoImpl<Comment, Integer> implements
		CommentDao {

}
