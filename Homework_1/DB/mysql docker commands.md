# Command for 'qa' profile to check locally connection to mysql

## Create docker image and start mysql container

###build an image with
docker build -f Dockerfile.mysql -t social-network/mysql .

###run empty
[comment]: <> (docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=password MYSQL_DATABASE=myDB -d mysql:latest)
docker run -p 3306:3306 --name MySQLContainer -e MYSQL_ROOT_PASSWORD=password MYSQL_DATABASE=myDB -d mysql:latest
```shell
docker run -p 3306:3306 --env MYSQL_ROOT_PASSWORD=password --env MYSQL_DATABASE=myDB --name MySQLContainer mysql:latest
```

## Connect to mysql container 
docker exec -it MySQLContainer bash -l  

[comment]: <> (docker exec -it mysql bash -l  )

mysql -P 3306 --protocol=tcp -u root -p
connect myDB

## Stop container
docker stop MySQLContainer

[comment]: <> (docker stop mysql)

## Add your data from a file on your machine
```shell
docker exec -i test-mysql-2 mysql -p password mysql < /path/to/my/sqlfile/myfile.sql
```
##Add your data when you create a container
```shell
docker run --name test-mysql-3 -v /my/own/datadir:/docker-entrypoint-initdb.d -p 3306 -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=mysql -d mysql:latest

```

See also:
https://developer.ibm.com/tutorials/docker-dev-db/

