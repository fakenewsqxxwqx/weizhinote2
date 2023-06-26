package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.weizhinote2.Mapper.tagMapper;

import java.util.List;

@Service
public class tagService {

    private tagMapper tagMapper;

    @Autowired
    public void setTagMapper(tagMapper tagMapper){
        this.tagMapper = tagMapper;
    }

    public boolean addTag(tag tag){
        String tagId= IdWorker.getIdStr();
        tag.setTagId(tagId);

        QueryWrapper<tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tagId", tagId);
        tag tag1=tagMapper.selectOne(queryWrapper);
        if(tag1==null){
            tagMapper.insert(tag);
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteTag(String tagId){
        QueryWrapper<tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tagId", tagId);
        tagMapper.delete(queryWrapper);
    }

    public List<tag> getTagByNoteTitle(String noteTitle){
        QueryWrapper<tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle", noteTitle);
        return tagMapper.selectList(queryWrapper);
    }

}
