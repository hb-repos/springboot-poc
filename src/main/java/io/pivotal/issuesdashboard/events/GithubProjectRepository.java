package io.pivotal.issuesdashboard.events;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface GithubProjectRepository extends PagingAndSortingRepository<GithubProject, Long> {

	GithubProject findByRepoName(String repoName);
}
