package com.auditDemo.services;

import java.util.List;

import com.auditDemo.entities.dto.IssueResponse;
import com.auditDemo.entities.dto.IssueWrapperInterface;

public interface IssueRepoActionsInterface {

	IssueResponse createIssue(IssueWrapperInterface issueWrapperInterface);
	
	List<IssueResponse> getAllIssues();

	IssueResponse findIssueById(long id);
}
