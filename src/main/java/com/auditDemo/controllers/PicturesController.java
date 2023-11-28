package com.auditDemo.controllers;

import com.auditDemo.entities.dto.EvidenceWrapperInterface;
import com.auditDemo.entities.dto.PictureWrapper;
import com.auditDemo.services.EvidenceRepoActionsInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/picture/")
public class PicturesController {

	private final EvidenceRepoActionsInterface evidenceRepoActionsInterface;
	
	@PostMapping("savePicture/{name}")
	public EvidenceWrapperInterface savePicture(@PathVariable("id") PictureWrapper pictureWrp){
		log.debug("savePicture API executed with pictue: " + pictureWrp.picture());
		EvidenceWrapperInterface evidenceWrapperInterface = new PictureWrapper(pictureWrp.picture());
		return evidenceRepoActionsInterface.saveEvidence(evidenceWrapperInterface);
	}
	
	@GetMapping("getPicture/{id}")
	public EvidenceWrapperInterface getPicture(@PathVariable("id") long id){
		log.debug("getPicture API executed with id: " + id);
		return evidenceRepoActionsInterface.getEvidenceById(id);
	}
	
}
