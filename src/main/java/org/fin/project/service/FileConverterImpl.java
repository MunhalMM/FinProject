package org.fin.project.service;

import org.fin.project.dto.FileDto;
import org.fin.project.entity.FileEntity;
import org.springframework.stereotype.Service;

@Service
public class FileConverterImpl implements FileConverter {
    @Override
    public FileDto toDto(FileEntity fileEntity) {
        return null;
    }

    @Override
    public FileEntity fromDto(FileDto fileDto) {
        return null;
    }
}
