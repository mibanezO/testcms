/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.test.abc.testcms.api;

import com.test.abc.testcms.model.TokenResponse;
import com.test.abc.testcms.model.User;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-02T16:08:41.447901-05:00[America/Lima]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "user", description = "All about user management")
public interface UserApi {

    default UserApiDelegate getDelegate() {
        return new UserApiDelegate() {};
    }

    /**
     * POST /user/login : Logs user into the system
     * 
     *
     * @param username The user name for login (optional)
     * @param password The password for login in clear text (optional)
     * @return successful operation (status code 200)
     *         or Invalid username/password supplied (status code 400)
     */
    @Operation(
        operationId = "loginUser",
        summary = "Logs user into the system",
        description = "",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TokenResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid username/password supplied")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/login",
        produces = { "application/json" }
    )
    
    default ResponseEntity<TokenResponse> loginUser(
        @Parameter(name = "username", description = "The user name for login", in = ParameterIn.QUERY) @Valid @RequestParam(value = "username", required = false) String username,
        @Parameter(name = "password", description = "The password for login in clear text", in = ParameterIn.QUERY) @Valid @RequestParam(value = "password", required = false) String password
    ) {
        return getDelegate().loginUser(username, password);
    }


    /**
     * POST /user/signin : Registers user into the system
     * 
     *
     * @param user Creates an user (required)
     * @return Successful operation (status code 200)
     *         or Invalid parameters (status code 400)
     *         or Validation exception (status code 422)
     */
    @Operation(
        operationId = "signInUser",
        summary = "Registers user into the system",
        description = "",
        tags = { "user" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters"),
            @ApiResponse(responseCode = "422", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user/signin",
        produces = { "application/json" },
        consumes = { "application/json", "application/x-www-form-urlencoded" }
    )
    
    default ResponseEntity<User> signInUser(
        @Parameter(name = "User", description = "Creates an user", required = true) @Valid @RequestBody User user
    ) {
        return getDelegate().signInUser(user);
    }

}
