package com.github.producer;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.github.dto.MessageDTO;

/**
 * 生产者-发送消息
 * 
 * @author jiangyf
 * @date 2017年9月21日 下午3:46:59
 */
@Component("activemqProducer")
public class ActivemqProducer {

	@Resource
	private JmsTemplate jmsTemplate;

	/**
	 * 发送文本消息
	 *
	 * @param destination
	 *            队列名称
	 * @param message
	 *            文本消息
	 */
	public void sendMessage(String destination, final String message) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
		// jmsTemplate.convertAndSend(destination, message);
	}

	/**
	 * 发送对象消息
	 *
	 * @param destination
	 *            队列名称
	 * @param message
	 *            对象消息
	 */
	public void sendMessage(String destination, final MessageDTO messageDTO) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(messageDTO);
			}
		});
		// jmsTemplate.convertAndSend(destination, messageDTO);
	}
}
