package com.yc.fav.mapper;

import java.util.List;

import com.yc.fav.entity.Tag;

public interface TagMapper {

	List<Tag> findAllTags();

	Boolean findTagByTagName(String tname);

	void updateTagCount(String tname);

	void insertTag(String tname);

}
