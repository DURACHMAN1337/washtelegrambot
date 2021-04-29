package ru.itwizard.washtelegrambot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;
import ru.itwizard.washtelegrambot.Keyboards.InlineKeyboardMarkupBuilder;
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
    SendMessage sendMessage = new SendMessage();
    sendMessage.setChatId(update.getMessage().getChatId());
        try {
            execute(messageStarter(update.getMessage().getText(),sendMessage));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


    public synchronized  SendMessage messageStarter(String text, SendMessage sendMessage){
        long chat_id = Long.parseLong(sendMessage.getChatId());
        switch (text){
            case "/start":
                sendMessage = ReplyKeyboardMarkupBuilder.create(chat_id)
                        .setText("Доброго времени суток, вы находитесь на стартовой странице телеграм бота для записи" +
                                "на услуги мойки чтобы начать пользоваться ботом нажмите кнопку /'Продолжить/' ")
                        .row()
                        .button("Продолжить")
                        .endRow()
                        .build();
                break;

            case "Продолжить":
                sendMessage = ReplyKeyboardMarkupBuilder.create(chat_id)
                        .setText("Вы находитесь в главном меню")
                        .row()
                        .button("Записатья на мойку")
                        .endRow()
                        .row()
                        .button("Мои заказы")
                        .button("Личный кабинет")
                        .endRow()
                        .row()
                        .button("Информация")
                        .endRow()
                        .build();

                break;

        }


        return sendMessage;
    }
    public synchronized void updateHandle(Update update) throws TelegramApiException {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(update.getMessage().getChatId());
        switch (update.getMessage().getText()){
            case "привет" :
                sendMessage.setText("Привет Бродяга");
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
