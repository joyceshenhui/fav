package com.yc.fav.service;

import java.util.List;

import com.yc.fav.entity.Favorite;

public interface FavoriteService {

	List<Favorite> listFavs(String tname);

	boolean addFavs(Favorite favs);

}
