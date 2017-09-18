package com.github.dto;

import java.io.Serializable;

/**
 * 消息
 *
 * @author jiangyf
 */
public class MessageDTO implements Serializable {
	private static final long serialVersionUID = 6539548355330577504L;

	private String id;

	private String receiverId;

	private String senderId;

	private String subject;

	private String content;

	public MessageDTO(String id, String receiverId, String senderId, String subject, String content) {
		this.id = id;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.subject = subject;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
