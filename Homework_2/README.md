OTUS (Highload Architect)
https://otus.ru/lessons/highloadarchitect

# Домашнее задание 2
# Производительность индексов

###Цель:
В результате выполнения ДЗ вы создадите набор тестовых данных для проведения нагрузочного тестирования, подберете наиболее подходящие индексы и проведете тесты производительности.
В данном задании тренируются навыки:

* генерация тестовых данных;
* работа с индексами;
* нагрузочное тестирование;
1. Сгенерировать любым способ 1,000,000 анкет. Имена и Фамилии должны быть реальными (чтобы учитывать селективность индекса)
2. Реализовать функционал поиска анкет по префиксу имени и фамилии (одновременно) в вашей социальной сети (запрос в форме firstName LIKE ? and secondName LIKE ?). Сортировать вывод по id анкеты. Использовать InnoDB движок.
3. С помощью wrk провести нагрузочные тесты по этой странице. Поиграть с количеством одновременных запросов. 1/10/100/1000.
4. Построить графики и сохранить их в отчет
5. Сделать подходящий индекс.
6. Повторить пункт 3 и 4.
7. В качестве результата предоставить отчет в котором должны быть:
* графики latency до индекса;
* графики throughput до индекса;
* графики latency после индекса;
* графики throughput после индекса;
* запрос добавления индекса;
* explain запросов после индекса;
* объяснение почему индекс именно такой;

ДЗ принимается в виде отчета по выполненной работе.

####Критерии оценки:
Оценка происходит по принципу зачет/незачет.

####Требования:
Правильно выбраны индексы.
Нагрузочное тестирование проведено и результаты адекватны.

# Let's Go!!
[Installing Connector](https://dev.mysql.com/doc/connector-python/en/connector-python-installation-binary.html)
Linux:
```shell
pip install mysql-connector-python 
```

https://dev.mysql.com/doc/connector-python/en/connector-python-versions.html

Windows:
    Alternatively, to run the installer from the command line, use this command in a console window, where VER and PYVER are the respective Connector/Python and Python version numbers in the installer file name:

    msiexec /i mysql-connector-python-VER-pyPYVER.msi
    msiexec /i mysql-connector-python-8.0.24-py2.7.msi

https://pypi.org/project/mysql-connector-python/8.0.24/#files
https://dev.mysql.com/downloads/connector/python/
http://ftp.iij.ad.jp/pub/db/mysql/Downloads/Connector-Python/

переехал на Python 3.9

[install Random name generator](https://github.com/treyhunner/names)

    pip install names


use generateUsers.py for generate

##Docker
get requirements.txt
    
    pip freeze
    pip freeze > requirements.txt

build 
* simply build an image with
```shell
sudo docker build -t otus/addusers .
```

docker compose:

    docker compose -f docker-compose.yml -d

## Test

[Install wrk](https://hub.docker.com/r/williamyeh/wrk)
    
    docker pull williamyeh/wrk
or use 

    docker pull skandyla/wrk

Sample

    docker run --rm williamyeh/wrk -c 10 -t 4 -d 10 http://ya.ru

>-t: количество потоков для моделирования
> 
>-c: количество подключений, которые необходимо смоделировать
> 
>-d: продолжительность теста
> 
>--timeout: время ожидания
> 
>--latency: отображать статистику задержки


    docker run --rm williamyeh/wrk -c 10 -t 4 -d 10 -s wrk-scripts/post.lua http://ya.ru -- debug true
    docker run --rm williamyeh/wrk -c 10 -t 4 -d 10 -s post.lua http://ya.ru -- debug true
    docker run --rm -v $(pwd):/data skandyla/wrk -c 10 -t 4 -d 10 -s post.lua http://ya.ru -- debug true
    docker run --rm -v C:\Users\user\MyProjects\OTUS\OTUS-HA\Homework_2\LoadTesting\wrk-scripts:/data skandyla/wrk -c 10 -t 4 -d 10 -s post.lua https://otus-ha-social-network.herokuapp.com/login -- debug true
    docker run --rm -v `pwd`/scripts:/scripts williamyeh/wrk -c$1 -t$2 -d$3 -s /scripts/post.lua http://xx.x.xx.xx:port/login
    docker run --rm --net host -v C:\Users\user\MyProjects\OTUS\OTUS-HA\Homework_2\LoadTesting\wrk-scripts:/scripts williamyeh/wrk -c 10 -t 4 -d 10 -s /scripts/post.lua http://localhost:8080/login 

    docker run --rm -v C:\Users\user\MyProjects\OTUS\OTUS-HA\Homework_2\LoadTesting\wrk-scripts:/scripts williamyeh/wrk -c 10 -t 4 -d 10 -s /scripts/post.lua http://192.168.1.222:8080/login

    docker run --rm --net host -v C:\Users\user\MyProjects\OTUS\OTUS-HA\Homework_2\LoadTesting\wrk-scripts:/scripts williamyeh/wrk -c 1 -t 1 -d 1 -s /scripts/post.lua http://192.168.1.222:8080/login 


[wrk2](https://github.com/giltene/wrk2)

    docker pull hugotr/wrk2
    docker pull bootjp/wrk2
    docker run --rm --net=host 1vlad/wrk2-docker -t1 -c1 -d90s -R50 --latency http://localhost

    wrk -c3 -d1s -t2 -s /scripts/debug.lua http://$APP1_PRIVATE_IP:3000 -- debug true

See also:
https://www.programmerall.com/article/91712052934/
https://hub.docker.com/r/rajneeshmitharwal/docker-wrk2-json
[wrk2-with-online-script](https://github.com/syedhassaanahmed/wrk2-with-online-script)
[wrk2 + json](http://czerasz.com/2015/07/19/wrk-http-benchmarking-tool-example/)
[docker-wrk-json](https://github.com/BlackRider97/docker-wrk-json)
(https://www.8host.com/blog/analiz-servisov-http-s-pomoshhyu-wrk-v-ubuntu-14-04/)

> docker context list
> docker context use default