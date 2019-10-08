package com.example.app.service;

import com.example.app.model.Message;
import org.jdom2.Element;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MessageService{


    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);
    String messageHandle(Element root );
    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

}
