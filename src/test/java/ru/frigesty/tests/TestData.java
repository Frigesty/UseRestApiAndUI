package ru.frigesty.tests;

import ru.frigesty.models.LoginRequestModel;

public class TestData {
    private static String login = "Frigesty",
            password = "Qwerty123#";

    public static LoginRequestModel credentials = new LoginRequestModel(login, password);
}
