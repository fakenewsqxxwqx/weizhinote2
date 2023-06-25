package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@TableName("loginlog")
public class loginlog {
    @TableId
    private String loginLogId;
    private String userName;
    private Date time;
}
