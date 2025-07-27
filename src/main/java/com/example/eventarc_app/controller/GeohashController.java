package com.example.eventarc_app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;

@RestController
@RequestMapping("/tmsgis/geohash")
public class GeohashController {

    private static final Logger logger = LoggerFactory.getLogger(GeohashController.class.getName());

    @PostMapping("/event")
    public void handleFirestoreEvent(HttpServletRequest request) {
        try {
            StringBuilder sb = new StringBuilder();
            String line;
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String requestBody = sb.toString();
            logger.info("Request Body Start");
            logger.info(requestBody);
            logger.info("Request Body End");
        } catch (Exception e) {
            logger.error("Error reading request body: {}", e.getMessage());
        }
    }

}
