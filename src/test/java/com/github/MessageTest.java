package com.github;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.producer.ActivemqProducer;

public class MessageTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageTest.class);
	private ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("spring-context.xml");
	}

	@Test
	public void sendMessage() throws Exception {
		ActivemqProducer activemqProducer = (ActivemqProducer) context.getBean("activemqProducer");
		int num = 10;
		while (num > 0) {
			activemqProducer.sendMessage("directQueue", "producer send message success, NO:" + num--);
			activemqProducer.sendMessage("topicQueue", "producer send message success, NO:" + num--);
			try {
				// 暂停一下，好让消费者去取消息打印出来
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				LOGGER.error("producer send message fail ---> {}", e.getMessage());
			}
		}
	}
}
