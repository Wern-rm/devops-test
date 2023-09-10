# LogGate - Шлюз для сбора логов.

- Информацию о методах можно найти в Swagger-UI по адресу: `http://127.0.0.1:8080/swagger-ui/index.html`

### Инструкция по установке базы данных:

- Установить Postgres v15
- Создать прикладного пользователя `logger_user` 
- Создать базу данных `logging` и назначить владельца базы данных, пользоваля `logger_user`
- Воссоздать базу данных из ниже перечисленных SQL команд:

#### Создание таблицы "Сервисы логирования"
```sql
CREATE TABLE IF NOT EXISTS logging_system (
      id            bigserial	NOT NULL PRIMARY KEY
    , name			text 		NOT NULL
    , sys_name 		text 		NOT NULL 
    , status    	bool 		NOT NULL DEFAULT TRUE	
    , at_create 	TIMESTAMP	NOT NULL DEFAULT LOCALTIMESTAMP
    , at_update  	TIMESTAMP 			 DEFAULT NULL
);

ALTER TABLE IF EXISTS logging_system OWNER TO logger_user;
```
#### Создание таблицы "История логирования"
```sql
CREATE TABLE IF NOT EXISTS logging_history
(
      id        bigserial   NOT NULL PRIMARY KEY
    , system_id bigint      NOT NULL REFERENCES logging_system(id)
    , log_level text 	    NOT NULL DEFAULT 'INFO'
    , message   text        NOT NULL
    , at_create TIMESTAMP   NOT NULL DEFAULT LOCALTIMESTAMP
);

-- Table Access
ALTER TABLE IF EXISTS logging_history OWNER TO logger_user;
```

### Инструкция по установке:

- Используя Docker и `dockerfile` развернуть Rest-API;
- Добавить HealthCheck на endpoint `http://127.0.0.1:8080/ping` каждые 30 секунд;
- Добавить переменные окружения среды из раздела "Enviroments"
- Добавить nginx через который будет происходить обращение к API логирования

### Enviroments

- `DB_URL` - URI покдлючения к базе данных (`jdbc:postgresql://172.16.20.120:5432/log_gate`)
- `DB_USERNAME` - Пользовать для подключения к базе данных (`logger_user`)
- `DB_PASSWORD` - Пароль пользователя для подключения к базе данных
- `POOL_SIZE` - Размер пула коннектов к базе данных (`10`)
- `CONNECT_TIMEOUT` - Время таймаута к базе данных в миллисекундах (`5000`)

### Используемые технологии:

- Java 17
- Postgres v15
- Spring Boot v3.1.0
- MyBatis v3

### ChangeLog

- 1.0.1 - Первый релиз системы
