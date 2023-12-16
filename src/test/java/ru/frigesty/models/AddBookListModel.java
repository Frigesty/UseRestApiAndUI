package ru.frigesty.models;

import lombok.Data;

import java.util.List;

@Data
public class AddBookListModel {

    String userId;

    List<IsbnModel> collectionOfIsbns;
}
