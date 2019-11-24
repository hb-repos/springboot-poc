package io.pivotal.issuesdashboard.events;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GithubProject implements Serializable {
	
	private static final long serialVersionUID = -4667786244993632168L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String orgName;

	@Column(unique = true)
	private String repoName;

	public GithubProject() {

	}

	public GithubProject(String orgName, String repoName) {
		this.orgName = orgName;
		this.repoName = repoName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	@Override
	public String toString() {
		return "GithubProject [id=" + id + ", orgName=" + orgName + ", repoName=" + repoName + "]";
	}

}
