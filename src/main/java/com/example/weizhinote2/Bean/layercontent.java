package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("layercontent")
public class layercontent extends Model<layercontent> {
    @TableId(type = IdType.ASSIGN_ID)
    private String layerContentId;
    private String noteTitle;
    private int layer;
    private String content;
}
