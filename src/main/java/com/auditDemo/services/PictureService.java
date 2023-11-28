package com.auditDemo.services;

import java.util.Optional;

import com.auditDemo.entities.dto.EvidenceWrapperInterface;
import com.auditDemo.entities.dto.PictureWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auditDemo.entities.tables.Picture;
import com.auditDemo.repo.PicturesRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("PictureService")
public class PictureService implements EvidenceRepoActionsInterface{

	private PicturesRepo picturesRepo;

	@Autowired
	public PictureService(PicturesRepo picturesRepo) {
		this.picturesRepo = picturesRepo;
	}

	@Override
	public EvidenceWrapperInterface saveEvidence(EvidenceWrapperInterface pictureWrp) {
		log.debug("creating picture details: " + pictureWrp);
		return new PictureWrapper(picturesRepo.save(((PictureWrapper)pictureWrp).picture()));
	}

	@Override
	public EvidenceWrapperInterface getEvidenceById(long id) {
		log.debug("Getting picture id: " + id);
		Optional<Picture> picOptional = picturesRepo.findById(id);
		if(picOptional.isEmpty())
			{
			return new PictureWrapper(new Picture());
			}
		
		return new PictureWrapper(picOptional.get());
		 
	}

	
}
