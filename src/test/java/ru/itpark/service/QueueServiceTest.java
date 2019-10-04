package ru.itpark.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueServiceTest {
    @Test
    public void shouldGetLength() {
        QueueElement firstElement = new QueueElement("A001");
        QueueElement secondElement = new QueueElement("B002");
        QueueElement thirdElement = new QueueElement("C003");
        QueueService service = new QueueService();
        service.setFirst(firstElement);
        firstElement.setNext(secondElement);
        secondElement.setNext(thirdElement);

        int queueLength = service.getLength();

        assertEquals(3, queueLength);
    }

}