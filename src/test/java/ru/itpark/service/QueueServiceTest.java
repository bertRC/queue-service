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

    @Test
    public void shouldGetLengthForEmptyQueue() {
        QueueService service = new QueueService();

        int queueLength = service.getLength();

        assertEquals(0, queueLength);
    }

    @Test
    public void shouldFindLastForEmptyQueue() {
        QueueService service = new QueueService();

        QueueElement last = service.findLast();

        assertSame(null, last);
    }

    @Test
    public void shouldFindLast() {
        QueueElement firstElement = new QueueElement("A001");
        QueueElement secondElement = new QueueElement("B002");
        QueueElement thirdElement = new QueueElement("C003");
        QueueService service = new QueueService();
        service.setFirst(firstElement);
        firstElement.setNext(secondElement);
        secondElement.setNext(thirdElement);

        QueueElement last = service.findLast();

        assertSame(thirdElement, last);
    }

    @Test
    public void shouldAddToTheEndForEmptyQueue() {
        QueueElement newElement = new QueueElement("A001");
        QueueService service = new QueueService();

        service.addToTheEnd(newElement);

        assertEquals(1, service.getLength());
        assertSame(newElement, service.findLast());
    }

    @Test
    public void shouldAddToTheEnd() {
        QueueElement thirdElement = new QueueElement("C003");
        QueueService service = new QueueService();

        service.addToTheEnd("A001");
        service.addToTheEnd("B002");
        service.addToTheEnd(thirdElement);

        assertEquals(3, service.getLength());
        assertSame(thirdElement, service.findLast());
    }

    @Test
    public void shouldGetFirstAndRemoveFromEmptyQueue() {
        QueueService service = new QueueService();

        QueueElement elementWillBeDeleted = service.getFirstAndRemoveFromQueue();

        assertSame(null, elementWillBeDeleted);
    }

    @Test
    public void shouldGetFirstAndRemoveFromQueue() {
        QueueElement firstElement = new QueueElement("Рђ001");
        QueueElement secondElement = new QueueElement("Рџ002");
        QueueService service = new QueueService();
        service.addToTheEnd(firstElement);
        service.addToTheEnd(secondElement);

        QueueElement elementWillBeDeleted = service.getFirstAndRemoveFromQueue();

        assertEquals(1, service.getLength());
        assertSame(firstElement, elementWillBeDeleted);
        assertSame(secondElement, service.getFirst());
    }

    @Test
    public void shouldGetFirstNameAndRemoveFromEmptyQueue() {
        QueueService service = new QueueService();

        String name = service.getFirstNameAndRemoveFromQueue();

        assertSame(null, name);
    }
}