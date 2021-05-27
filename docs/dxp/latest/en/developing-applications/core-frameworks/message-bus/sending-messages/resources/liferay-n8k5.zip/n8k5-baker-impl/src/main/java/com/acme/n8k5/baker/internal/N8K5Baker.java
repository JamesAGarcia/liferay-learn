package com.acme.n8k5.baker.internal;

import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBus;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class N8K5Baker {

	@Activate
	private void _activate() {
		Message message = new Message();

		message.setPayload("N8K5Baker#_activate");

		_messageBus.sendMessage("acme/n8k5_able", message);
	}

	@Reference
	private MessageBus _messageBus;

}