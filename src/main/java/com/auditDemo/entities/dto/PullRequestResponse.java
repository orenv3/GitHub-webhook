package com.auditDemo.entities.dto;

import com.auditDemo.entities.tables.PullRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PullRequestResponse implements IssueResponse{

	private PullRequest pullRequest;
	private String msg;
	
	public PullRequestResponse(PullRequest pr) {
		this.pullRequest = pr;
	}
}
