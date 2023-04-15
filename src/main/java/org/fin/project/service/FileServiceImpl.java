package org.fin.project.service;

import org.fin.project.model.FileCache;
import org.fin.project.dto.FileDto;

import org.fin.project.entity.FileEntity;
import org.fin.project.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    private static final Map<Long, FileDto> FILE_DTO_CACHE = new HashMap<>();

    private static final LinkedList<FileCache> FILE_CACHES = new LinkedList<>();

    private static final int CACHE_CAPACITY = 15;
    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileConverter converter;


    @Override
    public FileDto getFile(Long documentId) {
        int index = getFromCacheIfExists(documentId);
        if (index >= 0) {
            FileCache fileCache = FILE_CACHES.get(index);
            FILE_CACHES.remove(fileCache);
            FILE_CACHES.addFirst(fileCache);
            return fileCache.getFileDto();
        }
        FileEntity entity = fileRepository.findById(documentId).get();
        FileDto fileDto = converter.toDto(entity);
        if (FILE_CACHES.size() >= CACHE_CAPACITY) {
            FILE_CACHES.removeLast();
        }
        FILE_CACHES.addFirst(new FileCache(documentId, fileDto));
        return fileDto;
    }

    private int getFromCacheIfExists(Long id) {
        return FILE_CACHES.indexOf(new FileCache(id, null));
    }

    public List<FileCache> getCache() {
        return FILE_CACHES;
    }


}
