package org.fin.project.service;

import org.fin.project.dto.FileDto;
import org.fin.project.entity.FileEntity;

public interface FileConverter {
    FileDto toDto(FileEntity fileEntity);

    FileEntity fromDto(FileDto fileDto);
}
