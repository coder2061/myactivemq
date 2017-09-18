package com.github.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息监听器
 * 
 * @author jiangyf
 * @date 2017年9月21日 下午3:46:59
 */
public class ConsumerListener implements MessageListener {
	private static final Logger log = LoggerFactory.getLogger(ConsumerListener.class);

	@Override
	public void onMessage(Message message) {
		try {
			String text = ((TextMessage) message).getText();
			log.info("comsumer receive message:{}", text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
