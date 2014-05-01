package tr.metu.edu.sm.cookbook.test.unit;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tr.metu.edu.sm.cookbook.entity.Cuisine;
import tr.metu.edu.sm.cookbook.service.CuisineService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
@Transactional
public class CuisineTest {
	
	private static Logger logger = Logger.getLogger(CuisineTest.class);

	@Autowired
	private CuisineService<Cuisine, Integer> cuisineService;

	@Test
	public void test() {
		
		List<Cuisine> list = list();
		
		int size = list.size();
		logger.info("before size: "+size);
		
		Cuisine cuisine = new Cuisine();
		cuisine.setName("new");
		cuisineService.create(cuisine);
		
		list = list();
		int sizeA = list.size();
		logger.info("after size: "+sizeA);
		
		Assert.assertEquals(1, sizeA - size);
		
		
	}

	private List<Cuisine> list() {
		List<Cuisine> list = cuisineService.getAll();
		if(list !=null && !list.isEmpty()) {
			for (Cuisine l : list) {
				System.out.println(l.getName());
			}
		}
		return list;
	}
	
	
}
