package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("layercontent")
public class layercontent {
    @TableId
    private String layerContentId;
    private String noteTitle;
    private int layer;
    private String content;
}
