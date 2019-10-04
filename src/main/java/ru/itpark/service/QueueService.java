package ru.itpark.service;

public class QueueService {
    private QueueElement first;

//    public QueueElement getFirst() {
//        return first;
//    }

    public void setFirst(QueueElement first) {
        this.first = first;
    }

    public int getLength() {
        int length = 0;
        QueueElement element = first;
        while (element != null) {
            length++;
            element = element.getNext();
        }
        return length;
    }

    public QueueElement findLast() {
        if (first == null) {
            return null;
        } else {
            QueueElement element = first;
            while (element.getNext() != null) {
                element = element.getNext();
            }
            return element;
        }
    }

    public void addToTheEnd(String name) {
        QueueElement newElement = new QueueElement(name);
        addToTheEnd(newElement);
    }

    public void addToTheEnd(QueueElement newElement) {
        if (first == null) {
            first = newElement;
        } else {
            QueueElement element = first;
            while (element.getNext() != null) {
                element = element.getNext();
            }
            element.setNext(newElement);
        }
    }
}
