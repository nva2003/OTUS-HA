from config import dbconfig

import mysql.connector
from mysql.connector import errorcode

def add_user(username, first_name, last_name) -> None:
    try:
        cnx = mysql.connector.connect(**dbconfig)
    except mysql.connector.Error as err:
        if err.errno == errorcode.ER_ACCESS_DENIED_ERROR:
            print("Something is wrong with your user name or password")
        elif err.errno == errorcode.ER_BAD_DB_ERROR:
            print("Database does not exist")
        else:
            print(err)
    else:

        cursor = cnx.cursor()

        # SQL
        add_user = ("INSERT INTO users "
                        "(username, password, first_name, last_name, age, sex, interest, city) "
                        "VALUES (%s, %s, %s, %s, %s, %s, %s, %s)")

        data_user = (username, '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', first_name, last_name, 100, 'UNKNOWN', 'murder', 'fantasy')


        """
        data_user2 = {
            'username': 'lordlord'
            , 'password': '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K'
            , 'first_name': 'Lord'
            , 'last_name': 'Varys'
            , 'age': 100
            , 'sex': 'UNKNOWN'
            , 'interest': 'murder'
            , 'city': 'fantasy'
        }
        """

        # Insert new employee
        cursor.execute(add_user, data_user)

        emp_no = cursor.lastrowid

        cnx.commit()
        cursor.close()
        cnx.close()

# add_user(1,1,1)
