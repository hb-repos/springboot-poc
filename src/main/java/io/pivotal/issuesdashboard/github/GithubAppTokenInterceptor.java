package io.pivotal.issuesdashboard.github;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

public class GithubAppTokenInterceptor implements ClientHttpRequestInterceptor {
	
	private final String token;

    GithubAppTokenInterceptor(String token) {
        this.token = token;
    }

	@Override
	public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution)
			throws IOException {
		if (StringUtils.hasText(this.token)) {
            byte[] basicAuthValue = this.token.getBytes(StandardCharsets.UTF_8);
            httpRequest.getHeaders().set(HttpHeaders.AUTHORIZATION,
                    "Basic " + Base64Utils.encodeToString(basicAuthValue));
        }
        return clientHttpRequestExecution.execute(httpRequest, bytes);
	}

}
