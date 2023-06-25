package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@TableName("star")
public class star {
    @TableId
    private String starId;
    private String noteTitle;
    private String userName;
    private Date addTime;
}
