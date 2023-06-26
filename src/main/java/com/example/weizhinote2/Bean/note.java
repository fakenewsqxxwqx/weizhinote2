package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@Component
@TableName("note")
public class note extends Model<note> {
    @TableId(type = IdType.ASSIGN_ID)
    private String noteId;
    private String noteTitle;
    private int permission;
    private String userName;
    private Date time;
    private String type;
    private String bookName;
}
