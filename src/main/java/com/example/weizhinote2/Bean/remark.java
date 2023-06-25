package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("remark")
public class remark {
    @TableId
    private String remarkId;
    private String userName;
    private String noteTitle;
    private String remarkContent;
}
