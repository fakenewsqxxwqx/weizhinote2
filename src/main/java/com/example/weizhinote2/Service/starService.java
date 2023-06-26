package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.note;
import com.example.weizhinote2.Bean.star;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.weizhinote2.Mapper.starMapper;
import com.example.weizhinote2.Mapper.noteMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class starService {

    private starMapper starMapper;
    private noteMapper noteMapper;

    @Autowired
    public void setStarMapper(starMapper starMapper){
        this.starMapper = starMapper;
    }

    @Autowired
    public void setNoteMapper(noteMapper noteMapper){
        this.noteMapper = noteMapper;
    }



    public boolean addStar(star star){
        String starId= IdWorker.getIdStr();
        star.setStarId(starId);

        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("starId", starId);
        star star1=starMapper.selectOne(queryWrapper);
        if(star1==null){
            starMapper.insert(star);
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteStar(String starId){
        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("starId", starId);
        starMapper.delete(queryWrapper);
    }

    /*public List<star> getStarByNoteTitle(String noteTitle){
        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle", noteTitle);
        return starMapper.selectList(queryWrapper);
    }
     */

    public List<note> getStarByUserName(String userName){
        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);

        List<star> starList=starMapper.selectList(queryWrapper);
        List<String> noteTitleList=new ArrayList<>();
        for(star star:starList){
            noteTitleList.add(star.getNoteTitle());
        }
        QueryWrapper<note> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.in("noteTitle", noteTitleList);
        return noteMapper.selectList(queryWrapper1);
    }

    public List<star> getStarByNoteId(String noteId){
        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteId", noteId);
        return starMapper.selectList(queryWrapper);
    }

    public long getStarCountByNoteId(String noteId){
        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteId", noteId);
        return starMapper.selectCount(queryWrapper);
    }
    //查看是否收藏
    public boolean checkStar(star star1)
    {
        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",star1.getUserName());
        long count = starMapper.selectCount(queryWrapper);
        return count>0;
    }

    //star方法集成
    public boolean starControl(star star1)
    {
        if(checkStar(star1))
        {
            deleteStar(star1.getStarId());
            return false;
        }
        else
        {
            addStar(star1);
            return true;
        }
    }
}
