package com.server.web.mapper;

import com.server.web.entity.dto.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileSystemRepository extends MongoRepository<FileSystem,String> {
}
