package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES WHERE messagetext = #{text}")
    ChatMessage getChatMessage(String text);

    @Insert("INSERT INTO MESSAGES (messagetext, username) " + "VALUES(#{messageText}, #{username})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insertMessage(ChatMessage chatMessage);

    @Select(("SELECT * FROM MESSAGES"))
    List<ChatMessage> getAllMessages();

}
