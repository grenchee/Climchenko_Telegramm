package com.Grenche;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping//("/bot/internal")
public class TelegrammController {

    @Autowired
    private TelegramBot telegramBot;


    @PostMapping(/*"/story"*/"/test")
    public ResponseEntity<String> storeDate(@RequestBody Map<String, String> request) {

        String data = request.get("data");
        System.out.println(data);


        return ResponseEntity.ok("заебись");

    }



}
