package com.yc.fav.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.fav.entity.Tag;
import com.yc.fav.mapper.TagMapper;
import com.yc.fav.service.TagService;

@Service("tagService")
public class TagServiceImpl implements TagService {
	
	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> listTags() {
		return tagMapper.findAllTags();
	}

	@Override
	public Boolean findTag(String tname) {
		return tagMapper.findTagByTagName(tname);
	}

	@Override
	public void updateTagCount(String tname) {
		tagMapper.updateTagCount(tname);
		
	}

	@Override
	public void insertTag(String tag) {
		tagMapper.insertTag(tag);
		
	}

}
