package com.auditDemo.services;


import com.auditDemo.entities.dto.EvidenceWrapperInterface;

public interface EvidenceRepoActionsInterface {

	EvidenceWrapperInterface saveEvidence(EvidenceWrapperInterface picture);
	EvidenceWrapperInterface getEvidenceById(long id);
	
}
