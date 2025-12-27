package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.AccountStatusLog;
import com.examly.springapp.service.AccountStatusLogService;

@RestController
@RequestMapping("/api/logs")
public class AccountStatusLogController {
  @Autowired
  private AccountStatusLogService serObj;

  @PostMapping
public ResponseEntity<AccountStatusLog> addAccountStatusLog(
    @RequestBody AccountStatusLog accountStatusLog) {

  AccountStatusLog saved = serObj.addAccountStatusLog(accountStatusLog);
  return ResponseEntity.status(HttpStatus.CREATED).body(saved);
}

@GetMapping
public ResponseEntity<List<AccountStatusLog>> getAllAccountStatusLog() {
  List<AccountStatusLog> list = serObj.getAllAccountStatusLog();
  return ResponseEntity.status(HttpStatus.OK).body(list);
}

@GetMapping("/{id}")
public ResponseEntity<AccountStatusLog> getAccountStatusLog(@PathVariable long id) {
  AccountStatusLog log = serObj.getAccountStatusLog(id);
  if(log!=null){
    return ResponseEntity.status(HttpStatus.OK).body(log);
  }
  return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
}

@PutMapping("/{id}")
public ResponseEntity<AccountStatusLog> putAccountStatusLog(
    @PathVariable long id,
    @RequestBody AccountStatusLog accountStatusLog) {

  AccountStatusLog updated = serObj.putAccountStatusLog(id, accountStatusLog);
  return ResponseEntity.status(HttpStatus.OK).body(updated);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteAccountStatusLog(@PathVariable long id) {
  serObj.deleteAccountStatusLog(id);
  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}

}

