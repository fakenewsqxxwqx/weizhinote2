package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("tag")
public class tag extends Model<tag> {
    @TableId(type = IdType.ASSIGN_ID)
    private String tagId;
    private String tagName;
    private String noteTitle;
}
