package ru.itwizard.washtelegrambot.Keyboards;

import org.telegram.telegrambots.api.methods.send.SendMessage;

public interface KeyboardMarkupBuilder {

    void setChatId(Long chatId);

    KeyboardMarkupBuilder setText(String text);

    KeyboardMarkupBuilder row();

    KeyboardMarkupBuilder endRow();

    SendMessage build();


}
