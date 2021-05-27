package com.acme.b4d8.dynamic.data.mapping.data.provider.internal.settings;

import com.acme.b4d8.dynamic.data.mapping.data.provider.internal.B4D8DDMDataProviderSettings;

import com.liferay.dynamic.data.mapping.data.provider.settings.DDMDataProviderSettingsProvider;

import org.osgi.service.component.annotations.Component;

@Component(
	property = "ddm.data.provider.type=b4d8",
	service = DDMDataProviderSettingsProvider.class
)
public class B4D8DDMDataProviderSettingsProvider
	implements DDMDataProviderSettingsProvider {

	@Override
	public Class<?> getSettings() {
		return B4D8DDMDataProviderSettings.class;
	}

}