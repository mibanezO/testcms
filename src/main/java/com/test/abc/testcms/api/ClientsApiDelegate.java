package com.test.abc.testcms.api;

import com.test.abc.testcms.model.Client;
import com.test.abc.testcms.model.ClientPage;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ClientsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-02T16:08:41.447901-05:00[America/Lima]", comments = "Generator version: 7.8.0")
public interface ClientsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /clients : Adds a new client
     * Adds a new client
     *
     * @param client Adds a new client (required)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or Validation exception (status code 422)
     * @see ClientsApi#addClient
     */
    default ResponseEntity<Client> addClient(Client client) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"id\" : 9, \"birthDate\" : \"2000-01-23\", \"age\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /clients/{clientId} : Deletes a client
     * delete a client
     *
     * @param clientId Client ID to delete (required)
     * @return Invalid client value (status code 400)
     *         or Access token is missing or invalid (status code 401)
     * @see ClientsApi#deleteClient
     */
    default ResponseEntity<Void> deleteClient(Long clientId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clients/{clientId} : Find client by ID
     * Returns a single client
     *
     * @param clientId ID of client to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or Client not found (status code 404)
     * @see ClientsApi#getClientById
     */
    default ResponseEntity<Client> getClientById(Long clientId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"id\" : 9, \"birthDate\" : \"2000-01-23\", \"age\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /clients : Lists clients
     * Lists clients
     *
     * @param offset Current page offset (required)
     * @param limit Current page limit (required)
     * @param firstName The user first name (optional)
     * @param lastName The user last name (optional)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or Validation exception (status code 422)
     * @see ClientsApi#listClients
     */
    default ResponseEntity<ClientPage> listClients(Long offset,
        Long limit,
        String firstName,
        String lastName) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"offset\" : 1, \"ageStats\" : { \"std\" : 7.061401241503109, \"min\" : 2.3021358869347655, \"max\" : 5.637376656633329, \"mean\" : 5.962133916683182 }, \"count\" : 0, \"limit\" : 6, \"items\" : [ { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"id\" : 9, \"birthDate\" : \"2000-01-23\", \"age\" : 0 }, { \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"id\" : 9, \"birthDate\" : \"2000-01-23\", \"age\" : 0 } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /clients/{clientId} : Update an existing client
     * Update an existing client by Id
     *
     * @param clientId ID of client to update (required)
     * @param client Update an existent client (required)
     * @return Successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Access token is missing or invalid (status code 401)
     *         or Client not found (status code 404)
     *         or Validation exception (status code 422)
     * @see ClientsApi#updateClient
     */
    default ResponseEntity<Client> updateClient(Long clientId,
        Client client) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"id\" : 9, \"birthDate\" : \"2000-01-23\", \"age\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PATCH /clients/{clientId} : Updates a client with form data
     * 
     *
     * @param clientId ID of client that needs to be updated (required)
     * @param firstName First name of client that needs to be updated (optional)
     * @param lastName Last name of client that needs to be updated (optional)
     * @param age Age of client that needs to be updated (optional)
     * @param birthDate Birth date of client that needs to be updated (optional)
     * @return Successful operation (status code 200)
     *         or Invalid input (status code 400)
     *         or Access token is missing or invalid (status code 401)
     * @see ClientsApi#updateClientWithForm
     */
    default ResponseEntity<Client> updateClientWithForm(Long clientId,
        String firstName,
        String lastName,
        Integer age,
        LocalDate birthDate) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"id\" : 9, \"birthDate\" : \"2000-01-23\", \"age\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
