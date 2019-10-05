package ru.itpark.service;

public class QueueElement {
    private Person person;
    private QueueElement next;

    public QueueElement(String name) {
        this.person = new Person(name);
    }

    public QueueElement getNext() {
        return next;
    }

    public void setNext(QueueElement next) {
        this.next = next;
    }

    public Person getPerson() {
        return person;
    }
}
