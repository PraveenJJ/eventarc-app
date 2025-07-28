# eventarc-app

Spring Boot application to receive and process Google Cloud Eventarc events.

## API Endpoints

### 1. Loader API

- **Endpoint:** `POST /tmsgis/loader/process`
- **Description:** Receives Cloud Storage event notifications as JSON.
- **Request Body:** JSON payload representing a [StorageObjectData](https://cloud.google.com/events/docs/reference/google.events.cloud.storage.v1#storageobjectdata) event.
- **Consumes:** `application/json`
- **Example:**
    ```sh
    curl -X POST http://localhost:8080/tmsgis/loader/process \
      -H "Content-Type: application/json" \
      -d '{"bucket":"my-bucket","name":"my-object.txt", ...}'
    ```

### 2. Geohash API

- **Endpoint:** `POST /tmsgis/geohash/event`
- **Description:** Receives Firestore document event notifications as Protobuf.
- **Request Body:** Protobuf-encoded payload representing a [DocumentEventData](https://cloud.google.com/events/docs/reference/google.events.cloud.firestore.v1#documenteventdata) event.
- **Consumes:** `application/protobuf`
- **Example:**
    ```sh
    curl -X POST http://localhost:8080/tmsgis/geohash/event \
      -H "Content-Type: application/protobuf" \
      --data-binary @event_data.bin
    ```

## Source Code

- Loader API: [`LoaderController`](src/main/java/com/example/eventarc_app/controller/LoaderController.java)
- Geohash API: [`GeohashController`](src/main/java/com/example/eventarc_app/controller/GeohashController.java)

## Running the Application

Build with Maven:

```sh
mvn clean package
```

Run locally:

```sh
java -jar target/eventarc-app-0.0.1.jar
```

The application will start on port 8080 by default.