package com.company;

public class Main {

    public static void main(String[] args) {
	    // Паттерн (моменто) помогает сохранять объект перед изменениями и вернуть его обратно

        // создаём объект и статус
        Originator originator = new Originator();
        originator.setState("One");

        // созаём инструмент для взаимодействия и сразу сохранём объект
        Creatacer creatacer = new Creatacer();
        creatacer.setMomento(originator.createMomento());

        // ставим другой статут
        originator.setState("two");
        // и возращаем старый статус
        originator.getDateFromMomento(creatacer.getMomento());

        // проверяем
        System.out.println(originator.getState());
    }
}

// объект который мы хотим сохранять
class Originator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    Momento createMomento(){
        return new Momento(state);
    }

    void getDateFromMomento(Momento momento){
        this.state = momento.getState();
    }

}

// объект в который мы сохроняем
class Momento{
    private String state;

    public Momento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// делает сохранение
class Creatacer{
    private Momento momento;

    public void setMomento(Momento momento) {
        this.momento = momento;
    }

    public Momento getMomento() {
        return momento;
    }
}