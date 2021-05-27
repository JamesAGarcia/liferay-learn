package com.acme.y4a2.internal.antivirus;

import com.liferay.document.library.kernel.antivirus.AntivirusScanner;
import com.liferay.document.library.kernel.antivirus.AntivirusScannerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.File;

import org.osgi.service.component.annotations.Component;

@Component(service = AntivirusScanner.class)
public class Y4A2AntivirusScanner implements AntivirusScanner {

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public void scan(byte[] bytes) throws AntivirusScannerException {
		if (_log.isInfoEnabled()) {
			_log.info("Invoke #scan(byte)");
		}
	}

	@Override
	public void scan(File file) throws AntivirusScannerException {
		if (_log.isInfoEnabled()) {
			_log.info("Invoke #scan(File)");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		Y4A2AntivirusScanner.class);

}