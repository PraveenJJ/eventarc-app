package com.example.eventarc_app.controller;

import com.google.events.cloud.firestore.v1.DocumentEventData;
import com.google.events.cloud.storage.v1.StorageObjectData;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tmsgis/geohash")
public class GeohashController {

    private static final Logger logger = LoggerFactory.getLogger(GeohashController.class.getName());

    // for intercepting events from firestore
    @PostMapping(value = "/event", consumes = "application/protobuf")
    public void handleFirestoreEvent(@RequestBody byte[] data) throws InvalidProtocolBufferException {
        DocumentEventData firestoreEventData = DocumentEventData.parseFrom(data);
        logger.info("Firestore Event Start");
        logger.info(firestoreEventData.toString());
        logger.info("Firestore Event End");
    }

}
