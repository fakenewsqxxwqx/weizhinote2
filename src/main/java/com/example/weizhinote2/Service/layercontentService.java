package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.layercontent;
import com.example.weizhinote2.Mapper.layercontentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class layercontentService {
    private layercontentMapper LayercontentMapper;
    @Autowired
    public void setLayercontentMapper(layercontentMapper LayercontentMapper)
    {
        this.LayercontentMapper = LayercontentMapper;
    }

    //addLayercontent
    public boolean addLayerContent(layercontent layercontent1)
    {
        //生成唯一layercontentId
        String layercontentId = IdWorker.getIdStr();
        layercontent1.setLayerContentId(layercontentId);

        //查询数据库是否存在对应记录
        QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("layerContentId",layercontent1.getLayerContentId());
        layercontent layercontent2 = LayercontentMapper.selectOne(queryWrapper);

        if(layercontent2!=null)
        {
            return false;
        }
        else
        {
            LayercontentMapper.insert(layercontent1);
            return true;
        }
    }

    //deleteLayercontent
    public void deleteLayerContent(layercontent layercontent1)
    {
        QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("layerContentId",layercontent1.getLayerContentId());
        LayercontentMapper.delete(queryWrapper);
    }

    //updateLayercontent
    public void updateLayerContent(layercontent layercontent1)
    {
        QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("layerContentId",layercontent1.getLayerContentId());
        LayercontentMapper.update(layercontent1,queryWrapper);
    }

    /*
    读取layercontent，by id,title,
     */
    //getLayercontentById
    public List<layercontent> getLayerContentById(layercontent layercontent1)
    {
        QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("layerContentId",layercontent1.getLayerContentId());
        return LayercontentMapper.selectList(queryWrapper);
    }

    //getLayercontentByTitle
    public List<layercontent> getLayerContentByTitle(layercontent layercontent1)
    {
        QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle",layercontent1.getNoteTitle());
        return LayercontentMapper.selectList(queryWrapper);
    }

    //getAllLayercontent
    public List<layercontent> getAllLayerContent()
    {
        return LayercontentMapper.selectList(null);
    }
}
