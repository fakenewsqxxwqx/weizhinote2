package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.favor;
import com.example.weizhinote2.Mapper.favorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class favorService {
    private favorMapper FavorMapper;
    @Autowired
    public void setFavorMapper(favorMapper FavorMapper){
        this.FavorMapper = FavorMapper;
    }

    //查看是否点赞
    public boolean checkFavor(favor favor1)
    {
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",favor1.getUserName());
        long count = FavorMapper.selectCount(queryWrapper);
        return count>0;
    }

    //addFavor
    public boolean addFavor(favor favor1)
    {
        //生成唯一favorId
        String favorId = IdWorker.getIdStr();
        favor1.setFavorId(favorId);

        //查询数据库是否存在对应记录
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("favorId",favor1.getFavorId());
        favor favor2 = FavorMapper.selectOne(queryWrapper);

        if(favor2!=null)
        {
            return false;
        }
        else
        {
            FavorMapper.insert(favor1);
            return true;
        }
    }

    //deleteFavor
    public void deleteFavor(favor favor1)
    {
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("favorId",favor1.getFavorId());
        FavorMapper.delete(queryWrapper);
    }

    //点赞方法集成
    public boolean favorControl(favor favor1)
    {
        if(checkFavor(favor1))
        {
            deleteFavor(favor1);
            return false;
        }
        else
        {
            addFavor(favor1);
            return true;
        }
    }
/*
    //点赞数量
    public long favorCount(favor favor1)
    {
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("favorId",favor1.getFavorId());
        return FavorMapper.selectCount(queryWrapper);
    }
 */

    public long favorCount(String noteId)
    {
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle",noteId);
        return FavorMapper.selectCount(queryWrapper);
    }

    public List<favor> getFavorByNoteId(String noteId){
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle", noteId);
        return FavorMapper.selectList(queryWrapper);
    }
}
