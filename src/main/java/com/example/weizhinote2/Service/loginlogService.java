package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.loginlog;
import com.example.weizhinote2.Mapper.loginlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class loginlogService {
    private loginlogMapper LoginlogMapper;
    @Autowired
    public void setLoginlogMapper(loginlogMapper LoginlogMapper){
        this.LoginlogMapper = LoginlogMapper;
    }

    // 插入登录日志
    public boolean addLoginLog(loginlog loginlog1){
        // 生成唯一loginlogId
        String loginlogId = IdWorker.getIdStr();
        loginlog1.setLoginLogId(loginlogId);

        // 查询数据库是否存在对应记录
        QueryWrapper<loginlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginlogId", loginlog1.getLoginLogId());
        loginlog loginlog2 = LoginlogMapper.selectOne(queryWrapper);

        if(loginlog2 != null){
            return false;
        }else{
            LoginlogMapper.insert(loginlog1);
            return true;
        }
    }

    // 删除登录日志
    public void deleteLoginLog(loginlog loginlog1){
        QueryWrapper<loginlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginlogId", loginlog1.getLoginLogId());
        LoginlogMapper.delete(queryWrapper);
    }

    // 更新登录日志
    public void updateLoginLog(loginlog loginlog1){
        QueryWrapper<loginlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginlogId", loginlog1.getLoginLogId());
        LoginlogMapper.update(loginlog1, queryWrapper);
    }

    /*
    读取登录日志，by id,username
     */
    // getLoginLogById
    public List<loginlog> getLoginLogById(loginlog loginlog1){
        QueryWrapper<loginlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("loginlogId", loginlog1.getLoginLogId());
        return LoginlogMapper.selectList(queryWrapper);
    }
/*
    // getLoginLogByUsername
    public List<loginlog> getLoginLogByUserName(loginlog loginlog1){
        QueryWrapper<loginlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", loginlog1.getUserName());
        return LoginlogMapper.selectList(queryWrapper);
    }

 */

    public List<loginlog> getLoginLogByUserName(String userName){
        QueryWrapper<loginlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);
        return LoginlogMapper.selectList(queryWrapper);
    }

    //getAllLoginLog
    public List<loginlog> getAllLoginLog(){
        return LoginlogMapper.selectList(null);
    }
}
