package cz.etn.emailvalidator.entity;

import cz.etn.emailvalidator.enums.MessageSeverity;

public class Message {
	public final MessageSeverity severity;
	public final String text;


	public Message(MessageSeverity severity, String text) {
		this.severity = severity;
		this.text = text;

	}
}
