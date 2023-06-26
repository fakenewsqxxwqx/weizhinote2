package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@TableName("remark")
public class remark extends Model<remark> {
    @TableId(type = IdType.ASSIGN_ID)
    private String remarkId;
    private String userName;
    private String noteTitle;
    private String remarkContent;
}
