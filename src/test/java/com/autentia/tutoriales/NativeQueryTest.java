package com.autentia.tutoriales;

import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.autentia.tutoriales.dao.service.Dao;
import com.autentia.tutoriales.entity.Footballer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class NativeQueryTest {

	@Resource
	private Dao dao;

	private static final int IKER_CASILLAS_NUMBER = 1;

	@Test
	public void testFindByNumberByStoreProcedure() {
		final List<Footballer> footballerList = dao.findByNamedQuery("Footballer.findByNumber", -1, -1,
				IKER_CASILLAS_NUMBER);

		Assert.assertEquals("Debería haber un futbolista ", 1, footballerList.size());

		final Footballer footballer = footballerList.get(0);

		Assert.assertEquals("Iker", footballer.getName());
		Assert.assertEquals("Casillas", footballer.getLastname());
		Assert.assertEquals(IKER_CASILLAS_NUMBER, footballer.getNumber());
	}

	@Test
	public void testSumaByStoreProcedure() {
		final List<Integer> list = dao.findByNamedQuery("Footballer.SumaDeEnteros", -1, -1, 2, 3);
		Assert.assertEquals(Integer.valueOf(5), list.get(0));
	}
}
