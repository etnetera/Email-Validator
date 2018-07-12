package cz.etn.emailvalidator.entity;

import java.util.List;

public class ValidationResult {
	public final boolean isValid;
	public final List<Message> messages;
	public final Email email;

	public ValidationResult(boolean isValid, List<Message> messages, Email email) {
		this.isValid = isValid;
		this.messages = messages;
		this.email = email;
	}
}
