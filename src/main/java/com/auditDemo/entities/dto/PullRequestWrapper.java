package com.auditDemo.entities.dto;

import com.auditDemo.entities.pojo.Sender;
import com.auditDemo.entities.pojo.Repository;
import com.auditDemo.entities.tables.PullRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PullRequestWrapper implements IssueWrapperInterface{
	@JsonProperty("action")
	String action;
	
	@JsonProperty("number")
	int number;
	
	@JsonProperty("pull_request")
	PullRequest pull_request;
	
	@JsonProperty("repository")
	Repository repository;
	
	@JsonProperty("sender")
	Sender sender;
	
	public PullRequestWrapper(PullRequestWrapper prWrapper) {
		this.pull_request = new PullRequest(prWrapper.getPull_request());
	}
	
}
