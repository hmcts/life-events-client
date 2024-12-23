package com.github.hmcts.lifeevents.client.api;

import org.springframework.format.annotation.DateTimeFormat;
import com.github.hmcts.lifeevents.client.model.GeneralError;
import java.time.LocalDate;
import com.github.hmcts.lifeevents.client.model.V1Death;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-05T17:22:06.412789+01:00[Europe/London]")
@Validated
@Tag(name = "death", description = "Death records")
public interface DeathApi {

    /**
     * GET /v1/registration/death/{id} : Look up a specific death record
     * Look up individual death records using the &#x60;systemNumber&#x60; printed in the bottom-left of the death certificate. (UNSTABLE: This endpoint is subject to change.)
     *
     * @param id The system number printed in the bottom-left of the death certificate (required)
     * @return Resource not found (status code 404)
     *         or successful operation (status code 200)
     *         or Bad request (status code 200)
     */
    @Operation(
            operationId = "readV1Death",
            summary = "Look up a specific death record",
            description = "Look up individual death records using the `systemNumber` printed in the bottom-left of the death certificate. (UNSTABLE: This endpoint is subject to change.)",
            tags = { "death", "v1", "unstable" },
            responses = {
                    @ApiResponse(responseCode = "404", description = "Resource not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GeneralError.class))
                    }),
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = V1Death.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Bad request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GeneralError.class))
                    })
            },
            security = {
                    @SecurityRequirement(name = "bearerToken", scopes={  })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/registration/death/{id}",
            produces = "application/json"
    )
    ResponseEntity<V1Death> readV1Death(
            @Parameter(name = "id", description = "The system number printed in the bottom-left of the death certificate", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id
    );


    /**
     * GET /v1/registration/death : Search for death records
     * Search for death records by supplying the surname, at least the first forename and either the date of birth or the date of death of the deceased. (UNSTABLE: This endpoint is subject to change.)
     *
     * @param forenames The deceased&#39;s forenames. The first name must be provided but middlenames are optional. (required)
     * @param surname The deceased&#39;s surname. (required)
     * @param date The deceased&#39;s date of birth or death in international format. (required)
     * @return successful operation (status code 200)
     *         or Bad request (status code 200)
     */
    @Operation(
            operationId = "searchV1Death",
            summary = "Search for death records",
            description = "Search for death records by supplying the surname, at least the first forename and either the date of birth or the date of death of the deceased. (UNSTABLE: This endpoint is subject to change.)",
            tags = { "death", "v1", "unstable" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = V1Death.class)))
                    }),
                    @ApiResponse(responseCode = "default", description = "Bad request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GeneralError.class))
                    })
            },
            security = {
                    @SecurityRequirement(name = "bearerToken", scopes={  })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/v1/registration/death",
            produces = "application/json"
    )
    ResponseEntity<List<V1Death>> searchV1Death(
            @NotNull @Parameter(name = "forenames", description = "The deceased's forenames. The first name must be provided but middlenames are optional.", required = true, in = ParameterIn.QUERY) @jakarta.validation.Valid @RequestParam(value = "forenames", required = true) String forenames,
            @NotNull @Parameter(name = "surname", description = "The deceased's surname.", required = true, in = ParameterIn.QUERY) @jakarta.validation.Valid @RequestParam(value = "surname", required = true) String surname,
            @NotNull @Parameter(name = "date", description = "The deceased's date of birth or death in international format.", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    );

}
