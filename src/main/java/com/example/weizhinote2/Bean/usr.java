package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("usr")
public class usr {
    @TableId
    private String userId;
    private String userName;
    private String passW;
    private String photoUrl;
}
