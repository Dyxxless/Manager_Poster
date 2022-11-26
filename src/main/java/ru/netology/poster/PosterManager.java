package ru.netology.poster;

public class PosterManager {
    private String[] films = new String[0];
    private int limit;

    //Конструктор с заданным лимитом фильмов
    public PosterManager(int limit) {
        this.limit = limit;
    }

    //Конструктор с лимитом фильмов 10
    public PosterManager() {
        limit = 10;
    }

    public String[] getFilm() {
        return films;
    }

    //Добавление новых фильмов. Подмена изначального массива с фильмами
    public void addFilm(String film) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    //Обычное добавление фильмов
    public String[] findAll() {
        return films;
    }

    //Показ фильмов в порядке от последнего добавленного к старому
    public String[] findLast() {
        int resultLenght;
        if (limit <= films.length) {
            resultLenght = limit;
        } else {
            resultLenght = films.length;
        }
        String[] result = new String[resultLenght];
        for (int i = 0; i < result.length; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}