package com.github.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.github.dto.MessageDTO;

/**
 * 消息监听器
 * 
 * @author jiangyf
 * @date 2017年9月21日 下午3:46:59
 */
public class ConsumerMessageListener implements SessionAwareMessageListener<Message> {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onMessage(Message message, Session session) throws JMSException {
		log.info("comsumer receive message:{}", message.toString());

		ActiveMQObjectMessage msg = (ActiveMQObjectMessage) message;
		MessageDTO messageDTO = (MessageDTO) msg.getObject();

		log.info("comsumer receive message,subject:{},content:{}", messageDTO.getSubject(),
				messageDTO.getContent());
	}
}
