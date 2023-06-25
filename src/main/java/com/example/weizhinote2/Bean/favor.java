package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("favor")
public class favor {
    @TableId
    private String favorId;
    private String userName;
    private String noteTitle;
}
