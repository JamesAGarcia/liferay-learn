package com.acme.b4d8.dynamic.data.mapping.data.provider.internal;

import com.liferay.dynamic.data.mapping.annotations.DDMForm;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayout;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutColumn;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutPage;
import com.liferay.dynamic.data.mapping.annotations.DDMFormLayoutRow;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderParameterSettings;

@DDMForm
@DDMFormLayout(
	{
		@DDMFormLayoutPage(
			{
				@DDMFormLayoutRow(
					{
						@DDMFormLayoutColumn(
							size = 12, value = "outputParameters"
						)
					}
				)
			}
		)
	}
)
public interface B4D8DDMDataProviderSettings
	extends DDMDataProviderParameterSettings {
}