package tr.metu.edu.sm.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.metu.edu.sm.cookbook.dao.CommentDao;
import tr.metu.edu.sm.cookbook.dao.parent.GenericDao;
import tr.metu.edu.sm.cookbook.entity.Comment;
import tr.metu.edu.sm.cookbook.service.parent.GenericServiceImpl;

@Service(value = "commentService")
public class CommentServiceImpl extends
		GenericServiceImpl<Comment, Integer> implements
		CommentService<Comment, Integer> {

	@Autowired
	private CommentDao dao;

	@Override
	public GenericDao<Comment, Integer> getDao() {
		return this.dao;
	}

}
