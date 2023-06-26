package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("usr")
public class usr extends Model<usr> {
    @TableId(type = IdType.ASSIGN_ID)
    private String userId;
    private String userName;
    private String passW;
    private String photoUrl;
}
