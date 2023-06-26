package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.picture;
import com.example.weizhinote2.Bean.remark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.weizhinote2.Mapper.remarkMapper;

import java.util.List;

@Service
public class remarkService {
    private remarkMapper remarkMapper;

    @Autowired
    public void setRemarkMapper(remarkMapper remarkMapper){
        this.remarkMapper = remarkMapper;
    }

    //约束：remarkId, userName, noteTitle, remarkContent
    public boolean addRemark(remark remark){

        String remarkId= IdWorker.getIdStr();
        remark.setRemarkId(remarkId);

        QueryWrapper<remark> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("remarkId", remarkId);
        remark remark1=remarkMapper.selectOne(queryWrapper);
        if(remark1==null){
            remarkMapper.insert(remark);
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteRemark(String remarkId){
        QueryWrapper<remark> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("remarkId", remarkId);
        remarkMapper.delete(queryWrapper);
    }

    public void updateRemark(remark remark){
        QueryWrapper<remark> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("remarkId", remark.getRemarkId());
        remarkMapper.update(remark, queryWrapper);
    }

    /*
    public List<remark> getRemarkByNoteTitle(String noteTitle){
        QueryWrapper<remark> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle", noteTitle);
        return remarkMapper.selectList(queryWrapper);
    }

     */

    public List<remark> getRemarkByNoteId(String noteId)
    {
        QueryWrapper<remark> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle", noteId);
        return remarkMapper.selectList(queryWrapper);
    }

    public List<remark> getRemarkByUserName(String userName){
        QueryWrapper<remark> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);
        return remarkMapper.selectList(queryWrapper);
    }
}
