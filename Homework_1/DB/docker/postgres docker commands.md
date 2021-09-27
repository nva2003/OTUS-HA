# Command for 'qa' profile to check locally connection to mysql

## Create docker image and start mysql container

[comment]: <> пароль суперпользователя придётся задать явно
docker run -p 5432:5432 --name postgresContainer -e POSTGRES_PASSWORD=password; POSTGRES_DB=myDB; POSTGRES_USER=postgres -d postgres:latest
```shell
docker run -p 5432:5432 --name postgresContainer -e POSTGRES_PASSWORD=password; POSTGRES_DB=myDB; POSTGRES_USER=postgres -d postgres:latest
```

## Connect to mysql container 
docker exec -it postgresContainer bash -l  
```shell
psql --username=postgres --dbname=myDB
```
сокращенный вариант этой команды:
```shell
psql -U postgres -d myDB
```


## Stop container
docker stop postgresContainer

[comment]: <> (docker stop mysql)

## Add your data from a file on your machine
Инициализацию БД можно запустить через однострочник, но в этом случае требуется указывать абсолютный путь до каталога со скриптами:
```shell
docker run --name habr-pg-13.3 -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=myDB -d -v "/absolute/path/to/directory-with-init-scripts":/docker-entrypoint-initdb.d postgres:13.3
```
Например, на моей машине это выглядит так:
```shell
docker run --name habr-pg-13.3 -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=myDB -d -v "/Users/ivahrusev/src/useful-sql-scripts/running_pg_in_docker/2. Init Database":/docker-entrypoint-initdb.d postgres:13.3
```


See also:
https://habr.com/ru/post/578744/

