package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("favor")
public class favor extends Model<favor> {
    @TableId(type = IdType.ASSIGN_ID)
    private String favorId;
    private String userName;
    private String noteTitle;
}
