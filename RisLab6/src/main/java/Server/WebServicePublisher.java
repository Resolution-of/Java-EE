package Server;

import javax.xml.ws.Endpoint;
// класс нашего веб-сервиса


public class WebServicePublisher {
    public static void main(String... args) {
        // запускаем веб-сервер на порту 1986
        // и по адресу, указанному в первом аргументе,
        // запускаем веб-сервис, передаваемый во втором аргументе
        Endpoint.publish("http://localhost:8080/RisLab6", new SearchInDatabase());
    }
}
