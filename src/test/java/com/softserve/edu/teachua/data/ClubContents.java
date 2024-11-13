package com.softserve.edu.teachua.data;

public enum ClubContents {
    DEFAULT_CLUB(Cities.HARKIV_CITY, "Новий Кадр", "Новий кадр — це справжній творчий  майданчик"),
    IT_EDUCATION_CLUB(Cities.KYIV_CITY, "IT освіта: курси \"ГРАНД\"", "Ми вивчаємо все, що можна уявити в ІТ"),
    NEW_CADRE_CLUB(Cities.HARKIV_CITY, "Новий Кадр", "Новий кадр — це справжній творчий  майданчик"),
    VECTOR_CLUB(Cities.HARKIV_CITY, "Центр позашкільної освіти \"ВЕКТОР\" Харківської міської ради", "Центр пропонує заняття у гуртках");

    private ClubContents(Cities city, String title, String descriptions) {
        // TODO
    }

    public Cities getCity() {
        // TODO
        return Cities.HARKIV_CITY;
    }

    public String getTitle() {
        // TODO
        return "Новий Кадр";
    }

    public String getDescriptions() {
        // TODO
        return "";
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }
}
