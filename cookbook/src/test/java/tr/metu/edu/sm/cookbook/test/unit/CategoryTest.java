package tr.metu.edu.sm.cookbook.test.unit;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tr.metu.edu.sm.cookbook.entity.Category;
import tr.metu.edu.sm.cookbook.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
public class CategoryTest {
	
	private static Logger logger = Logger.getLogger(CategoryTest.class);

	@Autowired
	private CategoryService<Category, Integer> categoryService;

	@Test
	public void test() {
		
		List<Category> list = list();
		
		int size = list.size();
		logger.info("before size: "+size);
		
		Category category = new Category();
		category.setName("new");
		categoryService.create(category);
		
		list = list();
		int sizeA = list.size();
		logger.info("after size: "+sizeA);
		
		Assert.assertEquals(1, sizeA - size);
		
		
	}

	private List<Category> list() {
		List<Category> list = categoryService.getAll();
		if(list !=null && !list.isEmpty()) {
			for (Category l : list) {
				System.out.println(l.getName());
			}
		}
		return list;
	}
	
	
}
