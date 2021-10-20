import random
import string

def random_char(y):
    return ''.join(random.choice(string.ascii_lowercase) for x in range(y))

def get_email():
    return random_char(7)+"@gmail.com"

# print (random_char(7)+"@gmail.com")