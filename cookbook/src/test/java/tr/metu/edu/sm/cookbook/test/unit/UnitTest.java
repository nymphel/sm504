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

import tr.metu.edu.sm.cookbook.entity.Unit;
import tr.metu.edu.sm.cookbook.service.UnitService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
@Transactional
public class UnitTest {
	
	private static Logger logger = Logger.getLogger(UnitTest.class);

	@Autowired
	private UnitService<Unit, Integer> unitService;

	@Test
	public void test() {
		
		List<Unit> list = list();
		
		int size = list.size();
		logger.info("before size: "+size);
		
		Unit unit = new Unit();
		unit.setName("new");
		unitService.create(unit);
		
		list = list();
		int sizeA = list.size();
		logger.info("after size: "+sizeA);
		
		Assert.assertEquals(1, sizeA - size);
		
		
	}

	private List<Unit> list() {
		List<Unit> list = unitService.getAll();
		if(list !=null && !list.isEmpty()) {
			for (Unit l : list) {
				System.out.println(l.getName());
			}
		}
		return list;
	}
	
	
}
