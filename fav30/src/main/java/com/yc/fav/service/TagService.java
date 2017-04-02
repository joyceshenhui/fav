package com.yc.fav.service;

import java.util.List;

import com.yc.fav.entity.Tag;

public interface TagService {

	List<Tag> listTags();

	Boolean findTag(String tname);

	void insertTag(String tname);

	void updateTagCount(String tname);

}
