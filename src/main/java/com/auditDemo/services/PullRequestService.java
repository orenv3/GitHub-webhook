package com.auditDemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.auditDemo.entities.dto.IssueResponse;
import com.auditDemo.entities.dto.IssueWrapperInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.auditDemo.entities.tables.Picture;
import com.auditDemo.entities.tables.PullRequest;
import com.auditDemo.entities.dto.PullRequestWrapper;
import com.auditDemo.entities.dto.PullRequestResponse;
import com.auditDemo.utils.printscreen.PullRequestScreenshot;
import com.auditDemo.repo.PicturesRepo;
import com.auditDemo.repo.PullRequestRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service("PullRequestService")
public class PullRequestService implements IssueRepoActionsInterface {

	private final PullRequestRepo pullRequestRepo;
	private final PicturesRepo picturesRepo;

	@Override
	public IssueResponse createIssue(IssueWrapperInterface issueWrapperInterface) {
		log.debug("creating PullRequestWrapper details: " + issueWrapperInterface);
		PullRequestWrapper pullRequestWrapper = (PullRequestWrapper)issueWrapperInterface;
		PullRequestScreenshot pullRequestScreenshot = new PullRequestScreenshot(pullRequestWrapper);
		pullRequestScreenshot.start();
		PullRequest pullRequest = pullRequestWrapper.getPull_request();
		log.debug("creating pull request details: " + pullRequest);
		PullRequestResponse response = new PullRequestResponse();

		Picture p = picturesRepo.save(pullRequestScreenshot.getPicture());
		pullRequest.setPicture(p); 
		response.setPullRequest(pullRequestRepo.save(pullRequest));
		log.debug("sending response details: " + response);
		return response;
	}

	@Override
	public List<IssueResponse> getAllIssues() {
		List<IssueResponse> prList = new ArrayList<>();
		log.debug("Method getAllPullRequests executed");
		pullRequestRepo.findAll().forEach(c -> prList.add(new PullRequestResponse(c)));
		log.debug("List<PullRequestResponse> details: "+prList);
		return prList;
	}

	@Override
	public PullRequestResponse findIssueById(long id) {
		Optional<PullRequest> optionalPullRequest = pullRequestRepo.findById(id);
		PullRequestResponse pullRequestResponse = new PullRequestResponse();
		if(optionalPullRequest.isEmpty()) {
			pullRequestResponse.setPullRequest(new PullRequest());
		}else {
			pullRequestResponse.setPullRequest(optionalPullRequest.get());
		}
		return pullRequestResponse;
	}


}
