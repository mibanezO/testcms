/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.test.abc.testcms.api;

import com.test.abc.testcms.model.Client;
import com.test.abc.testcms.model.ClientPage;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-01T23:04:49.901173-05:00[America/Lima]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "client", description = "All about client management")
public interface ClientsApi {

    default ClientsApiDelegate getDelegate() {
        return new ClientsApiDelegate() {};
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
     */
    @Operation(
        operationId = "addClient",
        summary = "Adds a new client",
        description = "Adds a new client",
        tags = { "client" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "401", description = "Access token is missing or invalid"),
            @ApiResponse(responseCode = "422", description = "Validation exception")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/clients",
        produces = { "application/json" },
        consumes = { "application/json", "application/x-www-form-urlencoded" }
    )
    
    default ResponseEntity<Client> addClient(
        @Parameter(name = "Client", description = "Adds a new client", required = true) @Valid @RequestBody Client client
    ) {
        return getDelegate().addClient(client);
    }


    /**
     * DELETE /clients/{clientId} : Deletes a client
     * delete a client
     *
     * @param clientId Client ID to delete (required)
     * @return Invalid client value (status code 400)
     *         or Access token is missing or invalid (status code 401)
     */
    @Operation(
        operationId = "deleteClient",
        summary = "Deletes a client",
        description = "delete a client",
        tags = { "client" },
        responses = {
            @ApiResponse(responseCode = "400", description = "Invalid client value"),
            @ApiResponse(responseCode = "401", description = "Access token is missing or invalid")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/clients/{clientId}"
    )
    
    default ResponseEntity<Void> deleteClient(
        @Parameter(name = "clientId", description = "Client ID to delete", required = true, in = ParameterIn.PATH) @PathVariable("clientId") Long clientId
    ) {
        return getDelegate().deleteClient(clientId);
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
     */
    @Operation(
        operationId = "getClientById",
        summary = "Find client by ID",
        description = "Returns a single client",
        tags = { "client" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "401", description = "Access token is missing or invalid"),
            @ApiResponse(responseCode = "404", description = "Client not found")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/clients/{clientId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Client> getClientById(
        @Parameter(name = "clientId", description = "ID of client to return", required = true, in = ParameterIn.PATH) @PathVariable("clientId") Long clientId
    ) {
        return getDelegate().getClientById(clientId);
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
     */
    @Operation(
        operationId = "listClients",
        summary = "Lists clients",
        description = "Lists clients",
        tags = { "client" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ClientPage.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "401", description = "Access token is missing or invalid"),
            @ApiResponse(responseCode = "422", description = "Validation exception")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/clients",
        produces = { "application/json" }
    )
    
    default ResponseEntity<ClientPage> listClients(
        @NotNull @Parameter(name = "offset", description = "Current page offset", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "offset", required = true) Long offset,
        @NotNull @Parameter(name = "limit", description = "Current page limit", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = true) Long limit,
        @Parameter(name = "firstName", description = "The user first name", in = ParameterIn.QUERY) @Valid @RequestParam(value = "firstName", required = false) String firstName,
        @Parameter(name = "lastName", description = "The user last name", in = ParameterIn.QUERY) @Valid @RequestParam(value = "lastName", required = false) String lastName
    ) {
        return getDelegate().listClients(offset, limit, firstName, lastName);
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
     */
    @Operation(
        operationId = "updateClient",
        summary = "Update an existing client",
        description = "Update an existing client by Id",
        tags = { "client" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "401", description = "Access token is missing or invalid"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "422", description = "Validation exception")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/clients/{clientId}",
        produces = { "application/json" },
        consumes = { "application/json", "application/x-www-form-urlencoded" }
    )
    
    default ResponseEntity<Client> updateClient(
        @Parameter(name = "clientId", description = "ID of client to update", required = true, in = ParameterIn.PATH) @PathVariable("clientId") Long clientId,
        @Parameter(name = "Client", description = "Update an existent client", required = true) @Valid @RequestBody Client client
    ) {
        return getDelegate().updateClient(clientId, client);
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
     */
    @Operation(
        operationId = "updateClientWithForm",
        summary = "Updates a client with form data",
        description = "",
        tags = { "client" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "401", description = "Access token is missing or invalid")
        },
        security = {
            @SecurityRequirement(name = "bearerAuth")
        }
    )
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/clients/{clientId}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<Client> updateClientWithForm(
        @Parameter(name = "clientId", description = "ID of client that needs to be updated", required = true, in = ParameterIn.PATH) @PathVariable("clientId") Long clientId,
        @Parameter(name = "firstName", description = "First name of client that needs to be updated", in = ParameterIn.QUERY) @Valid @RequestParam(value = "firstName", required = false) String firstName,
        @Parameter(name = "lastName", description = "Last name of client that needs to be updated", in = ParameterIn.QUERY) @Valid @RequestParam(value = "lastName", required = false) String lastName,
        @Parameter(name = "age", description = "Age of client that needs to be updated", in = ParameterIn.QUERY) @Valid @RequestParam(value = "age", required = false) Integer age,
        @Parameter(name = "birthDate", description = "Birth date of client that needs to be updated", in = ParameterIn.QUERY) @Valid @RequestParam(value = "birthDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate
    ) {
        return getDelegate().updateClientWithForm(clientId, firstName, lastName, age, birthDate);
    }

}
