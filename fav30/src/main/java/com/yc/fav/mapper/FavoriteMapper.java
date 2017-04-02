package com.yc.fav.mapper;

import java.util.List;

import com.yc.fav.entity.Favorite;

public interface FavoriteMapper {

	List<Favorite> findFavs(String tname);

	int insertFav(Favorite favs);

}
