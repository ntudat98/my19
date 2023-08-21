package myapp.controller;

import myapp.annotations.Default;
import myapp.security.SanitizerUtils;
import myapp.response.GreetingResponse;
import myapp.request.ItemRequest;
import myapp.service.My19Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("My19/v1")
@Slf4j
@Tag(name = "My19")
@SecurityRequirement(name = "bearerAuth")
@ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "OK"),
    @ApiResponse(responseCode = "201", description = "Created"),
    @ApiResponse(responseCode = "401", description = "Unauthorized"),
    @ApiResponse(responseCode = "403", description = "Forbidden"),
    @ApiResponse(responseCode = "404", description = "Not Found") })
public class My19Controller {


  @Autowired
  My19Service service;


  @Operation(summary = "Get welcome")
  @GetMapping(value = "/welcome", produces = "application/My19-v1.0+json")
  public GreetingResponse getGreeting(@RequestParam("name") String name) {
    log.info("Welcome API called with " + name);
    String message = service.buildMessage(SanitizerUtils.sanitizeString(name));
    return GreetingResponse.builder().greeting(message).build();

  }


  @Operation(summary = "Get detail items")
  @GetMapping(value = "/items", produces = "application/My19-v1.0+json")
  public ResponseEntity<?> getItems() {
    log.info("GetItems API called with items: " + new ArrayList<>());
    return ResponseEntity.ok().body(new ArrayList<>());
  }


  @Operation(summary = "Save an item")
  @PostMapping(value = "/save-item", produces = "application/My19-v1.0+json")
  public ResponseEntity<?> saveItem(@RequestBody ItemRequest request) {
    log.info("SaveItem API called with item: " + request);
    ItemRequest sanitizerRequest = request.sanitize(request);
    return ResponseEntity.ok().body(new ArrayList<>());
  }


  @Operation(summary = "Delete an item")
  @DeleteMapping(value = "/delete-item", produces = "application/My19-v1.0+json")
  public ResponseEntity<?> deleteItem(@RequestBody ItemRequest request) {
    log.info("DeleteItem API called with item: " + request);
    ItemRequest sanitizerRequest = request.sanitize(request);
    return ResponseEntity.ok().body(new ArrayList<>());
  }


  @Operation(summary = "Update an items")
  @PutMapping(value = "/update-item", produces = "application/My19-v1.0+json")
  public ResponseEntity<?> updateItem(@RequestBody ItemRequest request) {
    log.info("UpdateItem API called with item: " + request);
    ItemRequest sanitizerRequest = request.sanitize(request);
    return ResponseEntity.ok().body(new ArrayList<>());
  }
}
