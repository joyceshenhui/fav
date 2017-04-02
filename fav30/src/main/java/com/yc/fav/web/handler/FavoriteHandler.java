package com.yc.fav.web.handler;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.fav.entity.Favorite;
import com.yc.fav.service.FavoriteService;

@Controller("favoriteHandler")
@RequestMapping("fav")
public class FavoriteHandler {
	
	@Autowired
	private FavoriteService  favoriteService;
	
	@RequestMapping(value="/{tagName}",method=RequestMethod.GET)
	@ResponseBody
	public List<Favorite> list(@PathVariable("tagName")String tagName) throws UnsupportedEncodingException{
		return favoriteService.listFavs(new String(tagName.getBytes("ISO-8859-1"),"UTF-8"));
		
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public boolean addFavs(Favorite favs){
		return favoriteService.addFavs(favs);
		
	}
}
