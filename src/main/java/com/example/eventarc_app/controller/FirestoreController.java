package com.example.eventarc_app.controller;

import com.google.events.cloud.firestore.v1.DocumentEventData;
import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example/firestore")
public class FirestoreController {

    private static final Logger logger = LoggerFactory.getLogger(FirestoreController.class.getName());

    // for intercepting events from firestore
    @PostMapping(value = "/event", consumes = "application/protobuf")
    public void processFirestoreEvent(@RequestBody byte[] data) throws InvalidProtocolBufferException {
        logger.info("Firestore Event Start");
        DocumentEventData firestoreEventData = DocumentEventData.parseFrom(data);
        logger.info(firestoreEventData.toString());
        logger.info("Firestore Event End");
    }

}
