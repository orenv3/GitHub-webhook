package com.auditDemo.services;

import com.auditDemo.entities.dto.IssueResponse;
import com.auditDemo.entities.dto.IssueWrapperInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service("BranchEventService")
public class BranchEventService implements IssueRepoActionsInterface {
    @Override
    public IssueResponse createIssue(IssueWrapperInterface issueWrapperInterface) {
        return null;
    }

    @Override
    public List<IssueResponse> getAllIssues() {
        return null;
    }

    @Override
    public IssueResponse findIssueById(long id) {
        return null;
    }
}
