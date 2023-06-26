package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("picture")
public class picture {
    @TableId(type = IdType.ASSIGN_ID)
    private String pictureId;
    private String noteTitle;
    private String pictureUrl;
}
