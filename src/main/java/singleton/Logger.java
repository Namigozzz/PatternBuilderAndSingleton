package singleton;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Logger {
    protected int num = 1;
    private static Logger instance = null;

    public void log(String msg) {
        System.out.println("[" + LocalDate.now() + " " + LocalTime.now() + num++ + "] " + msg);
    }

    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger logger;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {}

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}
