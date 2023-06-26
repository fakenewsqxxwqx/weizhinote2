package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@TableName("star")
public class star extends Model<star> {
    @TableId(type = IdType.ASSIGN_ID)
    private String starId;
    private String noteTitle;
    private String userName;
    private Date addTime;
}
