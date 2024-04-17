import java.util.logging.Logger;

/**
 * Трай с ресурсами
 * Для примера и упрощения, вам уже даны 2 класса имплементирующие интерфейс AutoCloseable
 * Любой класс, который имплементит данный интерфейс или интерфейс Closeable, является ресурсом.
 * Так же ресурсами в JAVA являются практически всё IO/NIO и классы требующие закрытия (напр. при работе с БД)
 * <p>
 * Задача:
 * 1. Используя конструкцию "Трай с ресурсами", ОДНОВРЕМЕННО вызвать оба этих класса и посмотреть на то, каким образом
 * ресурсы будут сначала открыты, отработаны, а затем закрыты.
 * 2. Заменить вывод сообщений в консоль, на логирование уровня INFO
 */
public class Main {
    public static void main(String[] args) throws Exception {
        try (AutoCloseableResourcesFirst r1 = new AutoCloseableResourcesFirst();
             AutoCloseableResourcesSecond r2 = new AutoCloseableResourcesSecond()) {
            r1.doSomething();
            r2.doSomething();
        }
    }
}

class AutoCloseableResourcesFirst implements AutoCloseable {
    private static final Logger logger = Logger.getLogger(AutoCloseableResourcesFirst.class.getName());

    public AutoCloseableResourcesFirst() {
        logger.info("Вызов конструктора -> AutoCloseableResources_First");
    }

    public void doSomething() {
        logger.info("Какой то метод -> AutoCloseableResources_First");
    }

    @Override
    public void close() throws Exception {
        logger.info("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_First");
    }
}

class AutoCloseableResourcesSecond implements AutoCloseable {
    private static final Logger logger = Logger.getLogger(AutoCloseableResourcesSecond.class.getName());

    public AutoCloseableResourcesSecond() {
        logger.info("Вызов конструктора -> AutoCloseableResources_Second");
    }

    public void doSomething() {
        logger.info("Какой то метод -> AutoCloseableResources_Second");
    }

    @Override
    public void close() throws Exception {
        logger.info("ЗАКРЫВАЕМ ресурс -> AutoCloseableResources_Second");
    }
}