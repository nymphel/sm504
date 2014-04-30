package tr.metu.edu.sm.cookbook.test.unit;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tr.metu.edu.sm.cookbook.entity.Category;
import tr.metu.edu.sm.cookbook.entity.parent.IdName;
import tr.metu.edu.sm.cookbook.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
public class CategoryTest {
	
	private static Logger logger = Logger.getLogger(CategoryTest.class);

	@Autowired
	private CategoryService<Category, Integer> categoryService;

	@Test
	public void test() {
		IdName category = new Category();
		category.setName("new cat");

		logger.info("created");
		
		List<Category> categories = categoryService.getAll();
		if(categories !=null && !categories.isEmpty()) {
			for (Category cat : categories) {
				System.out.println(cat.getName());
			}
		}
	}
	
	
}
