package com.auditDemo.controllers;

import com.auditDemo.entities.dto.BranchWrapper;
import com.auditDemo.entities.dto.IssueResponse;
import com.auditDemo.services.IssueRepoActionsInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Validated
@CrossOrigin
@RequestMapping("api/branch/")
@RestController
public class BranchController {

    private IssueRepoActionsInterface branchRequestServiceIntf;

    @Autowired
    public BranchController( @Qualifier("BranchEventService") IssueRepoActionsInterface branchRequestServiceIntf) {
        this.branchRequestServiceIntf = branchRequestServiceIntf;
    }

    @PostMapping("new_branch")
    public IssueResponse letsDoWebhookBranch(@Valid @RequestBody BranchWrapper branchWrapper) {
        BranchWrapper br = new BranchWrapper();
        //Do some
        return branchRequestServiceIntf.createIssue(br);
    }
}
