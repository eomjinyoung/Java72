package net.bitacademy.java72.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

public class ResponseFactory {
  public static ResponseEntity<String> createResponse(Object obj) {
    
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-type"
        , "text/plain;charset=UTF-8");
    
    return new ResponseEntity<String>(
        new Gson().toJson(obj), 
        headers,
        HttpStatus.OK);
  }
}
