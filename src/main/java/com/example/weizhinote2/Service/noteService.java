package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.layercontent;
import com.example.weizhinote2.Bean.note;
import com.example.weizhinote2.Mapper.layercontentMapper;
import com.example.weizhinote2.Mapper.noteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class noteService {
    private noteMapper NoteMapper;
    private layercontentMapper LayercontentMapper;
    @Autowired
    public void setNoteMapper(noteMapper NoteMapper)
    {
        this.NoteMapper = NoteMapper;
    }

    @Autowired
    public void setLayercontentMapper(layercontentMapper LayercontentMapper)
    {
        this.LayercontentMapper = LayercontentMapper;
    }

    //addNote
    public boolean addNote(note note1,List<layercontent> layercontentList)
    {
        //生成唯一noteId
        String noteId = IdWorker.getIdStr();
        note1.setNoteId(noteId);

        //查询数据库是否存在对应记录
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteId",note1.getNoteId());
        note note2 = NoteMapper.selectOne(queryWrapper);

        if(note2!=null)
        {
            return false;
        }
        else
        {
            NoteMapper.insert(note1);
            for (layercontent layercontent1:layercontentList)
            {
                layercontent1.setLayerContentId(IdWorker.getIdStr());
                LayercontentMapper.insert(layercontent1);
            }
            return true;
        }
    }

    //deleteNote by Id
    public void deleteNote(note note1,List<layercontent> layercontentList)
    {
        //删除笔记
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteId",note1.getNoteId());
        NoteMapper.delete(queryWrapper);

        //删除内容
        List<String> layerContentIdList = new ArrayList<>();
        for (layercontent layercontent1:layercontentList)
        {
            layerContentIdList.add(layercontent1.getLayerContentId());
        }
        QueryWrapper<layercontent> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.in("layerContentId",layerContentIdList);
        LayercontentMapper.delete(queryWrapper1);
    }

    //updateNote
    public void updateNoteContent(note note1,List<layercontent> layercontentList)
    {
        //更新笔记
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteId",note1.getNoteId());
        NoteMapper.update(note1,queryWrapper);
        //更新内容
        List<String> layerContentIdList = new ArrayList<>();
        for (layercontent layercontent1:layercontentList)
        {
            layerContentIdList.add(layercontent1.getLayerContentId());
        }
        QueryWrapper<layercontent> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.in("layerContentId",layerContentIdList);
        LayercontentMapper.delete(queryWrapper1);
        for (layercontent layercontent1:layercontentList)
        {
            layercontent1.setLayerContentId(IdWorker.getIdStr());
            LayercontentMapper.insert(layercontent1);
        }
    }


    /*
    读取笔记，by noteId, byBookNameandUserName ,社区获取所有公开笔记


    //判断笔记是否存在
    public boolean isNoteExist(String noteId){
        note note1=NoteMapper.selectById(noteId);
        if(note1==null){
            return false;
        }
        else{
            return true;
        }
    }

    //getNoteById

    //note
    public note getNoteByNoteId(String noteId)
    {
       return NoteMapper.selectById(noteId);
    }

    //layercontent
    public List<layercontent> getLayerContentById(String layerContentId)
    {
        return LayercontentMapper.selectList(new QueryWrapper<layercontent>().eq("layerContentId",layerContentId));
    }

     */

    //ByBookName

    //获取用户的所有笔记本
    public List<String> getBookNameByUserName(String userName)
    {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",userName);
        List<note> noteList = NoteMapper.selectList(queryWrapper);
        List<String> bookNameList = new ArrayList<>();
        for (note note1:noteList)
        {
            bookNameList.add(note1.getBookName());
        }
        return bookNameList;
    }
    //根据笔记本获取用户的所有笔记
    public List<note> getNoteByBookNameAndUserName(String bookName,String userName)
    {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bookName",bookName);
        queryWrapper.eq("userName",userName);
        return NoteMapper.selectList(queryWrapper);
    }

    //getNoteByUserNameAndUserName(一个用户的所有笔记)
    public List<note> getNoteByUserName(String userName)
    {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName",userName);
        return NoteMapper.selectList(queryWrapper);
    }
}
