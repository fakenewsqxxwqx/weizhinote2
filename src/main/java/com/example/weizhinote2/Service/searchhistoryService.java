package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.searchhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.weizhinote2.Mapper.searchhistoryMapper;

import java.util.List;

@Service
public class searchhistoryService {

    private searchhistoryMapper searchhistoryMapper;

    @Autowired
    public void setSearchhistoryMapper(searchhistoryMapper searchhistoryMapper){
        this.searchhistoryMapper = searchhistoryMapper;
    }

    public boolean addSearchHistory(searchhistory searchhistory){
        String searchHistoryId= IdWorker.getIdStr();
        searchhistory.setSearchHistoryId(searchHistoryId);

        QueryWrapper<searchhistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("searchHistoryId", searchHistoryId);
        searchhistory searchhistory1=searchhistoryMapper.selectOne(queryWrapper);
        if(searchhistory1==null){
            searchhistoryMapper.insert(searchhistory);
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteSearchHistory(String searchHistoryId){
        QueryWrapper<searchhistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("searchHistoryId", searchHistoryId);
        searchhistoryMapper.delete(queryWrapper);
    }

    public List<searchhistory> getSearchHistoryByUserNameAsc(String userName){
        //按时间升序排列
        QueryWrapper<searchhistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName).orderByAsc("time");
        return searchhistoryMapper.selectList(queryWrapper);
    }

    public List<searchhistory> getSearchHistoryByUserNameDesc(String userName){
        //按时间降序排列
        QueryWrapper<searchhistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName).orderByDesc("time");
        return searchhistoryMapper.selectList(queryWrapper);
    }

}
