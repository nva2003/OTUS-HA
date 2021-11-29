[Official mysql image readme](https://hub.docker.com/_/mysql/)

[Backup and restore a mysql database from a running Docker mysql container](https://gist.github.com/spalladino/6d981f7b33f6e0afe6bb)

[ПЕРЕНОС БАЗЫ ДАННЫХ MYSQL СО СТАРОГО НА НОВЫЙ СЕРВЕР](https://wiki.merionet.ru/servernye-resheniya/22/perenos-bazy-dannyx-mysql-so-starogo-na-novyj-server/)
[Cron MySQL backup](https://github.com/vmpartner/mysql-buckup)

# Backup
docker exec CONTAINER /usr/bin/mysqldump -u root --password=root DATABASE > backup.sql

    docker exec homework_2_mysql_1 /usr/bin/mysqldump -u root --password=password myDB > backup-myDB.sql

## Creating database dumps
docker exec some-mysql sh -c 'exec mysqldump --all-databases -uroot -p"$MYSQL_ROOT_PASSWORD"' > /some/path/on/your/host/all-databases.sql

# for backup
mysqldump -uroot -ppass IPAddress DB_NAME -P 3306 > db_backup.sql

# Backup with compression:
docker exec CONTAINER /usr/bin/mysqldump -u root --password=root DATABASE | gzip > `date +%Y-%m-%d-%T%z`-NAME.sql.gz`

    docker exec  homework_2_mysql_1 /usr/bin/mysqldump -u root --password=password myDB | gzip > `date +%Y-%m-%d-%T%z`-myDB.sql.gz`

## Restore

    docker exec homework_2_mysql_1 /usr/bin/mysql -u root --password=password -e "CREATE DATABASE myDB;"

    docker exec -i homework_2_mysql_1 /usr/bin/mysql -u root --password=password myDB < backup-myDB.sql

linux:

cat backup.sql | docker exec -i CONTAINER /usr/bin/mysql -u root --password=root DATABASE

 
## Restoring data from dump files

$ docker exec -i some-mysql sh -c 'exec mysql -uroot -p"$MYSQL_ROOT_PASSWORD"' < /some/path/on/your/host/all-databases.sql

## for restore, db must be exist
mysql -uroot -ppass -h IPAddress DB_NAME -P 3306 < db_backup.sql

# Restore with compression:
zcat 2018-11-14-backup.sql.gz | docker exec -i CONTAINER /usr/bin/mysql -u root --password=root DATABASE
