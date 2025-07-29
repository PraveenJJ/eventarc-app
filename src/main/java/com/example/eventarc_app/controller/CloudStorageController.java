package com.example.eventarc_app.controller;

import com.google.events.cloud.storage.v1.StorageObjectData;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example/cloudstorage")
public class CloudStorageController {

    private static final Logger logger = LoggerFactory.getLogger(CloudStorageController.class.getName());

    // for intercepting events from cloud storage
    @PostMapping("/event")
    public void processCloudStorageEvent(@RequestBody String jsonData) throws InvalidProtocolBufferException {
        logger.info("Cloud Storage Event Start");
        StorageObjectData.Builder builder = StorageObjectData.newBuilder();
        JsonFormat.parser().merge(jsonData, builder);
        StorageObjectData storageObjectData = builder.build();
        logger.info(storageObjectData.toString());
        logger.info("Cloud Storage Event End");
    }

}
