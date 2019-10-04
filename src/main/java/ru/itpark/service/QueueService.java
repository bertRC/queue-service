package ru.itpark.service;

public class QueueService {
    private QueueElement first;

    public QueueElement getFirst() {
        return first;
    }

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

}
