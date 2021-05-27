package com.acme.g9b6.internal.document.library.video.external.shortcut.provider;

import com.liferay.document.library.video.external.shortcut.DLVideoExternalShortcut;
import com.liferay.document.library.video.external.shortcut.provider.DLVideoExternalShortcutProvider;
import com.liferay.petra.string.StringBundler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(service = DLVideoExternalShortcutProvider.class)
public class G9B6DLVideoExternalShortcutProvider
	implements DLVideoExternalShortcutProvider {

	@Override
	public DLVideoExternalShortcut getDLVideoExternalShortcut(String url) {
		Matcher matcher = _pattern.matcher(url);

		if (!matcher.matches()) {
			return null;
		}

		return new DLVideoExternalShortcut() {

			@Override
			public String getURL() {
				return url;
			}

			@Override
			public String renderHTML(HttpServletRequest httpServletRequest) {
				String iframeSrc =
					"https://www.dailymotion.com/embed/video/" +
						matcher.group(1) + "?rel=0";

				return StringBundler.concat(
					"<iframe allow=\"autoplay; encrypted-media\" ",
					"allowfullscreen height=\"315\" frameborder=\"0\" ",
					"src=\"", iframeSrc, "\" width=\"560\"></iframe>");
			}

		};
	}

	private static final Pattern _pattern = Pattern.compile(
		"https?:\\/\\/(?:www\\.)?dai\\.ly\\/(\\S*)$");

}