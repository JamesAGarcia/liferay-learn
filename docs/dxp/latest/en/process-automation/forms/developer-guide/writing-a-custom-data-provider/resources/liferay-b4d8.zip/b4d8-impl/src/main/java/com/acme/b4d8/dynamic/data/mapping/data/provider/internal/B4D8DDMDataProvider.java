package com.acme.b4d8.dynamic.data.mapping.data.provider.internal;

import com.liferay.dynamic.data.mapping.data.provider.DDMDataProvider;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderException;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderInstanceSettings;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderOutputParametersSettings;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderRequest;
import com.liferay.dynamic.data.mapping.data.provider.DDMDataProviderResponse;
import com.liferay.dynamic.data.mapping.data.provider.settings.DDMDataProviderSettingsProvider;
import com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance;
import com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceService;
import com.liferay.portal.kernel.security.xml.SecureXMLFactoryProviderUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.Validator;

import java.io.StringReader;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;

@Component(
	property = "ddm.data.provider.type=b4d8", service = DDMDataProvider.class
)
public class B4D8DDMDataProvider implements DDMDataProvider {

	@Override
	public DDMDataProviderResponse getData(
			DDMDataProviderRequest ddmDataProviderRequest)
		throws DDMDataProviderException {

		try {
			String key = "LAOOBDZVQ5Z9HHYC4OCXHTGZGQLENMNA";

			String url =
				"https://api.geodatasource.com/cities?key=" + key +
					"&format=xml&lat=37.3861&lng=-122.084";

			return _createDDMDataProviderResponse(
				_ddmDataProviderInstanceSettings.getSettings(
					_getDDMDataProviderInstance(
						ddmDataProviderRequest.getDDMDataProviderId()),
					B4D8DDMDataProviderSettings.class),
				_toDocument(HttpUtil.URLtoString(url)));
		}
		catch (Exception exception) {
			throw new DDMDataProviderException(exception);
		}
	}

	@Override
	public Class<?> getSettings() {
		return _ddmDataProviderSettingsProvider.getSettings();
	}

	private DDMDataProviderResponse _createDDMDataProviderResponse(
			B4D8DDMDataProviderSettings b4d8DataProviderSettings,
			Document document)
		throws Exception {

		DDMDataProviderResponse.Builder builder =
			DDMDataProviderResponse.Builder.newBuilder();

		for (DDMDataProviderOutputParametersSettings
				ddmDataProviderOutputParametersSettings :
					b4d8DataProviderSettings.outputParameters()) {

			NodeList nodeList = document.getElementsByTagName(
				ddmDataProviderOutputParametersSettings.outputParameterPath());
			String outputParameterId =
				ddmDataProviderOutputParametersSettings.outputParameterId();
			String outputParameterType =
				ddmDataProviderOutputParametersSettings.outputParameterType();

			if (Objects.equals(outputParameterType, "list")) {
				List<KeyValuePair> keyValuePairs = new ArrayList<>();

				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);

					keyValuePairs.add(
						new KeyValuePair(
							node.getTextContent(), node.getTextContent()));
				}

				builder.withOutput(outputParameterId, keyValuePairs);
			}
			else if (Objects.equals(outputParameterType, "number")) {
				Node node = nodeList.item(0);

				NumberFormat numberFormat = NumberFormat.getInstance();

				builder.withOutput(
					outputParameterId,
					numberFormat.parse(node.getTextContent()));
			}
			else if (Objects.equals(outputParameterType, "text")) {
				Node node = nodeList.item(0);

				builder.withOutput(outputParameterId, node.getTextContent());
			}
		}

		return builder.build();
	}

	private DDMDataProviderInstance _getDDMDataProviderInstance(
			String ddmDataProviderInstanceId)
		throws Exception {

		DDMDataProviderInstance ddmDataProviderInstance =
			_ddmDataProviderInstanceService.fetchDataProviderInstanceByUuid(
				ddmDataProviderInstanceId);

		if (ddmDataProviderInstance != null) {
			return ddmDataProviderInstance;
		}

		if (Validator.isNumber(ddmDataProviderInstanceId)) {
			return _ddmDataProviderInstanceService.fetchDataProviderInstance(
				GetterUtil.getLong(ddmDataProviderInstanceId));
		}

		return null;
	}

	private Document _toDocument(String xml) throws Exception {
		DocumentBuilderFactory documentBuilderFactory =
			SecureXMLFactoryProviderUtil.newDocumentBuilderFactory();

		DocumentBuilder documentBuilder =
			documentBuilderFactory.newDocumentBuilder();

		return documentBuilder.parse(new InputSource(new StringReader(xml)));
	}

	@Reference
	private DDMDataProviderInstanceService _ddmDataProviderInstanceService;

	@Reference
	private DDMDataProviderInstanceSettings _ddmDataProviderInstanceSettings;

	@Reference(target = "(ddm.data.provider.type=b4d8)")
	private DDMDataProviderSettingsProvider _ddmDataProviderSettingsProvider;

}