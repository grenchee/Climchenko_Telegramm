package com.Grenche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        try {
      
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot());

            System.out.println(" Бот запущен! Жду сообщения...");
        } catch (TelegramApiException e) {
            System.err.println("Ошибка запуска бота: " + e.getMessage());
            e.printStackTrace();
        }


        SpringApplication.run(Main.class, args);
        System.out.println("🚀 Сервер запущен на порту: " + System.getProperty("server.port", "не задан"));
    }


}
