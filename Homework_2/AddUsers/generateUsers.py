import names
import generate_random_email_address
import addUser

def countdown(n):
    while n > 0:
        real_name = names.get_full_name()
        first_name, last_name = real_name.lower().split(' ')
        # first_name = names.get_first_name()
        # last_name = names.get_last_name()
        print(real_name)
        # print(first_name)
        # print(last_name)
        addUser.add_user(generate_random_email_address.get_email(), first_name, last_name)
        n -= 1
        print(n)
    print('Готово!')


countdown(1000000)

