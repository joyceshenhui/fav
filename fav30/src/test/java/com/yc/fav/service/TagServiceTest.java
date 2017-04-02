package com.yc.fav.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.fav.entity.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TagServiceTest {
	
	@Autowired
	private TagService tagService;
	@Test
	public void test() {
		List<Tag> tags = tagService.listTags();
		System.out.println(tags);
		assertNotNull(tags);
	}
	@Test
	public void testFindTag() {
		Boolean result = tagService.findTag("java");
		System.out.println(result);
		assertEquals(result,true);
	}
}
