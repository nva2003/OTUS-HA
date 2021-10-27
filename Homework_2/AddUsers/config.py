import os

dbconfig = {
    'user': os.getenv('MYSQL_USER', 'root'),
    'password': os.getenv('MYSQL_PASSWORD', 'password'),
    'host': os.getenv('MYSQL_HOST', 'localhost'),
    'database': os.getenv('MYSQL_DATABASE', 'myDB')
    # 'user': os.environ['MYSQL_USER',],
    # 'password': os.environ['MYSQL_PASSWORD'],
    # 'host': os.environ['MYSQL_HOST'],
    # 'database': os.environ['MYSQL_DATABASE']
}
