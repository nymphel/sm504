package tr.metu.edu.sm.cookbook.test.unit;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tr.metu.edu.sm.cookbook.entity.Cuisine;
import tr.metu.edu.sm.cookbook.entity.parent.IdName;
import tr.metu.edu.sm.cookbook.service.CuisineService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
public class CuisineTest {
	
	private static Logger logger = Logger.getLogger(CuisineTest.class);

	@Autowired
	private CuisineService<Cuisine, Integer> cuisineService;

	@Test
	public void test() {
		IdName cuisine = new Cuisine();
		cuisine.setName("new cat");

		logger.info("created");
		
		List<Cuisine> list = cuisineService.getAll();
		if(list !=null && !list.isEmpty()) {
			for (Cuisine cat : list) {
				System.out.println(cat.getName());
			}
		}
	}
	
	
}
