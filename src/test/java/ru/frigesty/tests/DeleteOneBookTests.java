package ru.frigesty.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.frigesty.api.BookAPI;
import ru.frigesty.api.LoginAPI;
import ru.frigesty.models.AddBookListModel;
import ru.frigesty.models.LoginResponseModel;
import ru.frigesty.ui.ProfilePage;

import static io.qameta.allure.Allure.step;
import static ru.frigesty.tests.TestData.credentials;

@DisplayName("API тесты")
public class DeleteOneBookTests extends TestBase {

    LoginAPI loginAPI = new LoginAPI();
    BookAPI bookApi = new BookAPI();
    ProfilePage profile = new ProfilePage();

    @Test
    @DisplayName("Проверка успешной авторизации")
    void deleteOneBookTest() {

        String isbn = "9781449325862";

        LoginResponseModel loginResponse = loginAPI.login(credentials);

        step("Авторизоваться в профиле", () ->
                bookApi.deleteAllBooks(loginResponse));

        step("Добавить книгу в профиль", () ->
                bookApi.addBook(loginResponse, new AddBookListModel()));

        step("Удалить книгу из профиля", () ->
                bookApi.deleteOneBook(loginResponse, isbn));
        step("Проверить, что книга в профиле отсутствует", () -> {
            profile.setCookie(loginResponse)
                    .openProfile()
                    .checkAvailabilityBook(isbn);
        });
    }
}