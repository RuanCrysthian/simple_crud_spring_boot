package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Person;
import com.example.crud.service.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/persons")
@Qualifier("personController")
@Tag(name = "People", description = "Endpoints to managing People")
public class PersonController {
  @Autowired
  private PersonService service;

  @PostMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
      "application/xml" })
  @Operation(summary = "Adds a new Person", description = "Adds a new Person", tags = { "People" }, responses = {
      @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Person.class))),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
  })
  public Person create(@RequestBody Person person) {
    return service.create(person);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  @Operation(summary = "Finds all People", description = "Finds all People", tags = { "People" }, responses = {
      @ApiResponse(description = "Success", responseCode = "200", content = {
          @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Person.class)))
      }),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
  })
  public List<Person> findAll() {
    return service.findAll();
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
  @Operation(summary = "Finds a Person", description = "Finds a Person", tags = { "People" }, responses = {
      @ApiResponse(description = "Sucess", responseCode = "200", content = @Content(schema = @Schema(implementation = Person.class))),
      @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
  })
  public Person findById(@PathVariable(value = "id") Long id) throws Exception {
    return service.findById(id);
  }

  @PutMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
      "application/xml" })
  @Operation(summary = "Updates a new Person", description = "Updates a new Person", tags = { "People" }, responses = {
      @ApiResponse(description = "Updated", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
  })
  public Person update(@RequestBody Person person) {
    return service.update(person);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Deletes a new Person", description = "Deletes a new Person", tags = { "People" }, responses = {
      @ApiResponse(description = "No content", responseCode = "204", content = @Content),
      @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
      @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
      @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
      @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
  })
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {
    service.delete(id);
    return ResponseEntity.ok().build();
  }

}
