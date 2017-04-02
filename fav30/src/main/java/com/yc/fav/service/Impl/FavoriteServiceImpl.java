package com.yc.fav.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fav.entity.Favorite;
import com.yc.fav.mapper.FavoriteMapper;
import com.yc.fav.service.FavoriteService;
import com.yc.fav.service.TagService;

@Service("favoriteService")
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	private FavoriteMapper favoriteMapper;
	
	@Autowired
	private TagService tagService;
	
	@Override
	public List<Favorite> listFavs(String tname) {
		
		return favoriteMapper.findFavs(tname);
	}

	@Override
	public boolean addFavs(Favorite favs) {
		favs.setFtags(favs.getFtags().replace(" ", ""));
		//1.增加标签或更新标签
		String[] tnames = favs.getFtags().split(",");
		for (String tname : tnames) {
			if(tagService.findTag(tname) != null){//判断是否存在书签
				//存在就修改书签对应的网站数量
				tagService.updateTagCount(tname);
			}else{
				//不存在，增加一个新书签
				tagService.insertTag(tname);
			}
		}
		//2.增加网站信息
		return favoriteMapper.insertFav(favs)>0;
	}

}
