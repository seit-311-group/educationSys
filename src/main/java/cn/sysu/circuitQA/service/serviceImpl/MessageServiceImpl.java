package cn.sysu.circuitQA.service.serviceImpl;

import cn.sysu.circuitQA.pojo.message;
import cn.sysu.circuitQA.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private cn.sysu.circuitQA.mapper.messageMapper messageMapper;

    @Override
    public void addMessage(String content, String date) {
        message message = new message();
        message.setMessage(content);
        message.setDate(date);
        messageMapper.insert(message);
    }
}
