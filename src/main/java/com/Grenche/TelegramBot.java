package com.Grenche;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {


    private static final String BOT_TOKEN = "8658871791:AAFE8qsTzJ8J2w5rxogE2hxya6QTtlegFHA";
    private static final String BOT_USERNAME = "@mess_golub_bot";

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public void onUpdateReceived(Update update) {
        // Проверяем, что это сообщение от пользователя
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String messageText = update.getMessage().getText();

            System.out.println("📩 Получено сообщение: " + messageText);

            // Обрабатываем команды
            String response = handleCommand(messageText, chatId);


            // Отправляем ответ
            sendMessage(chatId, response);
            sendMessage(chatId, chatId);
        }
    }


    private String handleCommand(String message, String chatId) {
        String lower = message.toLowerCase();

        if (lower.equals("/start")) {
            return "Привет! Я бот.";
        } else if (lower.equals("/help")) {
            return "Доступные команды:\n" +
                    "/start - Приветствие\n" +
                    "/help - Помощь\n"
                    ;
        } else {
            return  message + chatId;
        }
    }

    // ===== ОТПРАВКА СООБЩЕНИЯ =====
    private void sendMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try {
            execute(message);
            System.out.println("Ответ отправлен: " + text);
        } catch (TelegramApiException e) {
            System.err.println("Ошибка отправки: " + e.getMessage());
        }
    }
}
