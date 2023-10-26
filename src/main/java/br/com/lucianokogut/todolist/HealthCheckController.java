package br.com.lucianokogut.todolist;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
// http://localhost:8080/health-check/
public class HealthCheckController {
    @GetMapping("/json")
    /*
     * public ResponseEntity<Object> getRetornoEntity() {
     * Map<String, String> retorno = new HashMap<>();
     * retorno.put("resource", "apiToDoList");
     * retorno.put("message", "OK");
     * retorno.put("statusCode", "200");
     * return new ResponseEntity<>(retorno, HttpStatus.OK);
     */
    public Object getHealth() {
        Map<String, Object> healthMap = new HashMap<>();
        healthMap.put("resource", "apiToDoList");
        healthMap.put("status", "UP");
        healthMap.put("statusCode", HttpStatus.OK);
        System.out.println("Request de Status solicitado...");
        return healthMap;
    }

    @GetMapping("/")
    @ResponseBody
    public String returnDefault() {
        String healthDefault = "resource: apiToDoList" + " | " + "status : UP" + " | " + "statusCode : 200";
        return healthDefault;
    }
}
