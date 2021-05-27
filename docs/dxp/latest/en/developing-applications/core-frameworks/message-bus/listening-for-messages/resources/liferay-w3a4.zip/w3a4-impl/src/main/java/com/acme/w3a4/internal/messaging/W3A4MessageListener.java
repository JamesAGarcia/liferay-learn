package com.acme.w3a4.internal.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import org.osgi.service.component.annotations.Component;

@Component(
	property = "destination.name=" + DestinationNames.DOCUMENT_LIBRARY_PDF_PROCESSOR,
	service = MessageListener.class
)
public class W3A4MessageListener implements MessageListener {

	@Override
	public void receive(Message message) {
		if (_log.isInfoEnabled()) {
			Object payload = message.getPayload();

			_log.info("Received message payload " + payload.toString());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		W3A4MessageListener.class);

}