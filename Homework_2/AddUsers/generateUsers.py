import names
import generate_random_email_address
import addUser
import time
from datetime import timedelta

def countdown(n):
    start_time = time.perf_counter()
    start_time_gt = time.time()

    while n > 0:
        real_name = names.get_full_name()
        first_name, last_name = real_name.lower().split(' ')
        # first_name = names.get_first_name()
        # last_name = names.get_last_name()
        print(real_name)
        # print(first_name)
        # print(last_name)
        try:
            addUser.add_user(generate_random_email_address.get_email(), first_name, last_name)
        except:
            print('Что-то пошло не так.')

        # except mysql.connector.Error as err:
        #     print('ощибка при добавлении пользователя')
        else:
            n -= 1
        print(n)
    print('Готово!')

    end_time = time.perf_counter()

    print(f"Elapsed time: {end_time - start_time:0.4f} seconds")

    elapsed_time = time.time() - start_time_gt
    print ( time.strftime('%H:%M:%S', time.gmtime(elapsed_time) ) )

    td = timedelta(seconds = elapsed_time)
    print('Time in hh:mm:ss:', td)


countdown(1000000)

