OTUS (Highload Architect)
https://otus.ru/lessons/highloadarchitect

# Домашнее задание
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
