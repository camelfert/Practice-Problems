import random
import string

chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*-=+'

print('Welcome to a (slightly cryptographically secure) password generator.')
length = input('How many characters should this password be? ')
length = int(length)

password = ''.join(random.SystemRandom().choice(chars) for i in range(length))

print('Your new password is: ' + password)