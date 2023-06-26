package com.example.weizhinote2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.weizhinote2.Bean.usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.weizhinote2.Mapper.usrMapper;

import java.util.List;

@Service
public class userService {

    private usrMapper usrMapper;

    @Autowired
    public void setUsrMapper(usrMapper usrMapper){
        this.usrMapper = usrMapper;
    }

    public String login(String userName,String passWord){

        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);
        usr usr1=usrMapper.selectOne(queryWrapper);
        if(usr1==null){
            return "用户名不存在";
        }
        else{
            if(usr1.getPassW().equals(passWord)){
                return "登录成功";
            }
            else{
                return "密码错误";
            }
        }
    }

    public String reg(usr usr){
        String Id= IdWorker.getIdStr();
        usr.setUserId(Id);

        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", usr.getUserName());
        usr usr1=usrMapper.selectOne(queryWrapper);
        if(usr1==null){
            usrMapper.insert(usr);
            return "注册成功";
        }
        else{
            return "用户名已存在";
        }
    }

    public void changePassW(String userName,String passWord){
        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);
        usr usr1=usrMapper.selectOne(queryWrapper);
        usr1.setPassW(passWord);
        usrMapper.updateById(usr1);
    }

    public void changePhotoUrl(String userName,String photoUrl){
        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);
        usr usr1=usrMapper.selectOne(queryWrapper);
        usr1.setPhotoUrl(photoUrl);
        usrMapper.updateById(usr1);
    }

    public usr getUsrByUserName(String userName){
        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);
        return usrMapper.selectOne(queryWrapper);
    }

    public List<usr> getAllUsr(){
        System.out.println("getAllUsr");
        return usrMapper.selectList(null);

    }

    public usr getUsrById(){
        System.out.println("getUsrById");
        return usrMapper.selectById("1132321");
    }
}
