package com.softserve.edu.teachua.data;

public enum ClubContents {
    DEFAULT_CLUB(Cities.HARKIV_CITY, "Новий Кадр", "Новий кадр — це справжній творчий  майданчик"),
    IT_EDUCATION_CLUB(Cities.KYIV_CITY, "IT освіта: курси \"ГРАНД\"", "Ми вивчаємо все, що можна уявити в ІТ"),
    NEW_CADRE_CLUB(Cities.HARKIV_CITY, "Новий Кадр", "Новий кадр — це справжній творчий  майданчик"),
    VECTOR_CLUB(Cities.HARKIV_CITY, "Центр позашкільної освіти \"ВЕКТОР\" Харківської міської ради", "Центр пропонує заняття у гуртках"),
    GREEN_COUNTRY_CLUB(Cities.HARKIV_CITY, "Грін Кантрі", "Мережа шкіл англійської мови для дітей, навчання за концепцією ''Перевернутий Урок''");

    private String title;
    private String description;
    private Cities city;

    private ClubContents(Cities city, String title, String descriptions) {
    this.city = city;
    this.title = title;
    this.description = descriptions;
    }

    public Cities getCity() {
        //
        return city;
    }

    public String getTitle() {
        //
        return title;
    }

    public String getDescriptions() {
        //
        return description;
    }

    @Override
    public String toString() {

        return city + " " + title + " " + description;
    }
}
