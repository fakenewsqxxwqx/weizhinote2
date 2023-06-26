package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.weizhinote2.Mapper.pictureMapper;

import java.util.List;

@Service
public class pictureService {

    private pictureMapper pictureMapper;

    @Autowired
    public void setPictureMapper(pictureMapper pictureMapper){
        this.pictureMapper = pictureMapper;
    }

    public boolean addPicture(picture picture){
        String pictureId= IdWorker.getIdStr();
        picture.setPictureId(pictureId);

        QueryWrapper<picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pictureId", pictureId);
        picture picture1=pictureMapper.selectOne(queryWrapper);
        if(picture1==null){
            pictureMapper.insert(picture);
            return true;
        }
        else{
            return false;
        }
    }

    public void deletePicture(String pictureId){
        QueryWrapper<picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pictureId", pictureId);
        pictureMapper.delete(queryWrapper);
    }

    /*
    public List<picture> getPictureByNoteTitle(String noteTitle){
        QueryWrapper<picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle", noteTitle);
        return pictureMapper.selectList(queryWrapper);
    }
     */

    public List<picture> getPictureByNoteId(String noteId){
        QueryWrapper<picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteTitle", noteId);
        return pictureMapper.selectList(queryWrapper);
    }
}
