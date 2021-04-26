package ru.itwizard.washtelegrambot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import ru.itwizard.washtelegrambot.Keyboards.ReplyKeyboardMarkupBuilder;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage;

        ReplyKeyboardMarkupBuilder replyKeyboardMarkupBuilder = new ReplyKeyboardMarkupBuilder();
        sendMessage = replyKeyboardMarkupBuilder
                .setText("Привет Некит")
                .row()
                .button("Жопа")
                .button("Некит")
                .endRow()
                .build();
        sendMessage.setChatId(update.getMessage().getChatId());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        try {
            updateHandle(update);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }
    public synchronized void updateHandle(Update update) throws TelegramApiException {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(update.getMessage().getChatId());
        switch (update.getMessage().getText()){
            case "привет" :
                sendMessage.setText(" Привет Бродяга");
                execute(sendMessage);
            case "пока" :
                sendMessage.setText("Пока Бродяга");
                execute(sendMessage);
        }
    }

    @Override
    public String getBotUsername() {
        return "CarWashTest_Bot";
    }

    @Override
    public String getBotToken() {
        return "1706833740:AAFDqLmdbKum7fxjwbnk_-HdFb723TvKljI";
    }
}
