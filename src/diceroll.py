import random

answer = None
dice = random.randint(1, 6)
while answer not in ("yes", "no"):
    answer = input("Would you like to roll the six-sided dice? ")
    if (answer == "yes" or answer == "y" or answer == "Yes" or answer == "Y"):
        print("You rolled a " + str(dice) + ".")
    elif (answer == "no" or answer == "n" or answer == "No" or answer == "N"):
        print("The dice was not rolled.")
    else:
        print("Please choose whether to roll the dice or not.")
