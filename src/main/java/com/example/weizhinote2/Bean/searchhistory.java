package com.example.weizhinote2.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@TableName("searchhistory")
public class searchhistory {
    @TableId
    private String searchHistoryId;
    private String userName;
    private String keyWord;
    private String url;
    private Date time;
}
