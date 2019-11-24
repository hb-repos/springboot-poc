package io.pivotal.issuesdashboard.events;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import io.pivotal.issuesdashboard.github.GithubClient;
import io.pivotal.issuesdashboard.github.RepositoryEvent;

@Controller
public class EventsController {
	
	private final GithubProjectRepository repo;
	
	private final GithubClient client;

	public EventsController(GithubProjectRepository repo, GithubClient client) {
		this.repo = repo;
		this.client = client;
	}

	@GetMapping("/events/{repoName}")
	@ResponseBody
	public RepositoryEvent[] fetchEvents(@PathVariable String repoName) {
		GithubProject project = repo.findByRepoName(repoName);
		if(project!=null)
			return client.fetchEvents(project.getOrgName(), project.getRepoName()).getBody();
		return new RepositoryEvent[0];
	}
}
