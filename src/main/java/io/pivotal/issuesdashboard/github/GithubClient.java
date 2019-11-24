package io.pivotal.issuesdashboard.github;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.pivotal.issuesdashboard.GithubProperties;

@Component
public class GithubClient {
	
	private static final String EVENT_ISSUE_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events";

    private final RestTemplate restTemplate;
    

	public GithubClient(RestTemplateBuilder restTemplateBuilder, GithubProperties properties) {
		this.restTemplate = restTemplateBuilder
				.additionalInterceptors(new GithubAppTokenInterceptor(properties.getToken()))
				.build();
	}
    
    public ResponseEntity<RepositoryEvent[]> fetchEvents(String orgName, String repoName){
    	return restTemplate.getForEntity(EVENT_ISSUE_URL, RepositoryEvent[].class, orgName, repoName);
    }
}
