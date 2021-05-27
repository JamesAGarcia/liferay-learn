package com.acme.f5d5.web.internal.portlet;

import com.acme.f5d5.web.internal.constants.F5D5WebKeys;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.criteria.UUIDItemSelectorReturnType;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.roles.item.selector.RoleItemSelectorCriterion;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.display-name=F5D5 Portlet",
		"javax.portlet.init-param.view-template=/view.jsp"
	},
	service = Portlet.class
)
public class F5D5Portlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ItemSelectorCriterion itemSelectorCriterion =
			new RoleItemSelectorCriterion();

		itemSelectorCriterion.setDesiredItemSelectorReturnTypes(
			new UUIDItemSelectorReturnType());

		PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
			RequestBackedPortletURLFactoryUtil.create(renderRequest),
			renderResponse.getNamespace() + "selectRole",
			itemSelectorCriterion);

		renderRequest.setAttribute(
			F5D5WebKeys.ITEM_SELECTOR_URL, itemSelectorURL);

		super.render(renderRequest, renderResponse);
	}

	@Reference
	private ItemSelector _itemSelector;

}