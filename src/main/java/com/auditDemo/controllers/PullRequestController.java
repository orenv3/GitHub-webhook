package com.auditDemo.controllers;

import java.util.List;

import javax.validation.Valid;

import com.auditDemo.entities.dto.IssueResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auditDemo.entities.dto.PullRequestWrapper;
import com.auditDemo.services.IssueRepoActionsInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@CrossOrigin
@RequestMapping("api/pullRequest/")
@RestController
public class PullRequestController {

	private IssueRepoActionsInterface pullRequestServiceIntf;

	@Autowired
	public PullRequestController( @Qualifier("PullRequestService") IssueRepoActionsInterface pullRequestServiceIntf) {
		this.pullRequestServiceIntf = pullRequestServiceIntf;
	}

	@PostMapping("createPullRequest")
	public IssueResponse letsDoWebhookPullRequest(@Valid @RequestBody PullRequestWrapper pullRequestWrapper) {
		PullRequestWrapper pullReqWrp = new PullRequestWrapper(pullRequestWrapper);
		pullReqWrp.setAction(pullRequestWrapper.getAction());
		log.debug("createPullRequest API executed with PullRequestWrapper: " + pullRequestWrapper);
		return pullRequestServiceIntf.createIssue(pullReqWrp);
	}

	@GetMapping("getPullRequestList")
	public List<IssueResponse> letsDoScreenshot() {
		log.debug("getPullRequestList API executed ");
		return pullRequestServiceIntf.getAllIssues();
	}

	@GetMapping("getPullRequest/{id}")
	public IssueResponse getPullRequestById(@PathVariable("id") long id) {
		return pullRequestServiceIntf.findIssueById(id);
	}
}
