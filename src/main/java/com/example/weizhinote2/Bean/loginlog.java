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
@TableName("loginlog")
public class loginlog extends Model<loginlog> {
    @TableId(type = IdType.ASSIGN_ID)
    private String loginLogId;
    private String userName;
    private Date time;
}
