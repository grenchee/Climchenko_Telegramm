package com.Grenche;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dopi")
public class TelegrammController {

    @Autowired
    private TelegramBot telegramBot;


    @PostMapping(/*"/story"*/"/data")
    public ResponseEntity<String> storeDate(@RequestBody Map<String, String> request) {

        String data = request.get("data");
        System.out.println(data);


        return ResponseEntity.ok("заебись");

    }

    @PostMapping("/test")
    public void otvet(
            @RequestBody Map<String, String> request
    ) {
        System.out.println(request.get("email") + request.get("pass") + "в пизду");
    }



}
