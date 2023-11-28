package com.auditDemo.entities.dto;

import com.auditDemo.entities.tables.Picture;

public record PictureWrapper(Picture picture) implements EvidenceWrapperInterface{
}
