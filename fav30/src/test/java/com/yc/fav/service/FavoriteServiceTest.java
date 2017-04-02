package com.yc.fav.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.fav.entity.Favorite;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class FavoriteServiceTest {
	
	@Autowired
	private FavoriteService  favoriteService;

	@Test
	public void test() {
		 List<Favorite> favs = favoriteService.listFavs("-0");
		 System.out.println(favs);
		 assertNotNull(favs);
	}
	@Test
	public void testAddFav() {
		Favorite fav = new Favorite();
		fav.setFtags("购物,java");
		fav.setFdesc("全球最大的电子商务网站");
		fav.setFurl("http://www.taobao.com");
		fav.setFlabel("淘宝网");
		 boolean result = favoriteService.addFavs(fav);
		 System.out.println(result);
		 assertEquals(result,true);
	}
}
