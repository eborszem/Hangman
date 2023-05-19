import random
# ASCII art credit: https://gist.github.com/chrishorton/8510732aa9a80a03c829b09f12e20d9c
stages = ['''
  +---+
  |   |
      |
      |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
      |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
  |   |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|   |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|\  |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|\  |
 /    |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|\  |
 / \  |
      |
=========''']

# Word bank we will use
wordBank = ["there","together","broad","store","call","basis","troops","during","can","nation"
"sport","also","long","cat","although","tired","wheel","western","fish","cause"
"congress","situation","rice","chose","person","plus","everybody","shoe","continent","may"
"up","paid","bill","fought","everyone","fierce","yet","remove","get","husband"
"describe","grabbed","doubt","breeze","rhythm","sometime","blind","someone","musical","yes"
"entire","declared","voice","pictured","call","nor","airplane","later","shoe","cheese"
"want","similar","escape","believed","highest","president","sang","range","mainly","thick"
"bill","anyone","minute","minute","appropriate","musical","sides","something","chosen","between"
"owner","case","machinery","shallow","rose","prevent","without","left","potatoes","rule"
"surface","slipped","population","monkey","grow","becoming","last","older","limited","moon"
"one","pocket","mistake","pain","porch","composition","concerned","differ","spite","baseball"]
# Hangman Code
print("Welcome to HANGMAN!")
word = random.choice(wordBank)
spaces = ['_'] * len(word)
strikes = 0
badGuess = [''] * 26 # Keeps track of incorrect letter guesses
numBadGuess = 0 # Number of bad guesses
won = False
while strikes <= 6: # Limit of bad guesses one can make
  if strikes == 0:
    print(stages[0])
  elif strikes == 1:
    print(stages[1])
  elif strikes == 2:
    print(stages[2])
  elif strikes == 3:
    print(stages[3])
  elif strikes == 4:
    print(stages[4])
  elif strikes == 5:
    print(stages[5])
  
  if strikes == 6 or won:
    if strikes == 6: # Game over!
      print(stages[6])
      print("You lose! Better luck next time!")
      print(f"The word was {word}.") # Reveals word
    elif won: # Win condition!
      print("Congratulations! You won!")
      
    redo = input("Do you want to play again? Y/N\n") # Allows for replayability
    while True:
      # Resets all of the statistics
      if redo.lower() == "y":
        word = random.choice(wordBank)
        spaces = ['_'] * len(word)
        strikes = 0
        badGuess = [''] * 26
        numBadGuess = 0
        won = False
        print(stages[0])
        break
      elif redo.lower() == "n":
        break
      else:
        redo = input("Invalid input, try again.\n")
        
    if redo.lower() == "n":
      print("Goodbye!")
      break
  # Print out the spaces that show the user how long the word is
  for i in spaces:
    print(i, end = "")
    
  print()
  
  while True:
    guess = input("Guess a letter!\n").lower()

    if len(guess) == 1 and guess.isalpha(): # Edge cases to allow only valid input (letters a-z)
      break
    else:
      print("Guess must be a letter! Try again.")

  if guess in badGuess: # If bad letter has already been guessed, user shouldn't get a strike
    print("You already guessed this incorrect letter!")
  elif guess not in word: # If bad letter has been guessed for the first time, user should get a strike
    strikes += 1
    print("Wrong!")
    badGuess[numBadGuess] = guess
    numBadGuess += 1
  elif guess in spaces: # If a good letter has already been guessed, ignore
    print("You already guessed this correct letter!")
  else: # Good letter guessed!
    print("Correct!")
    # Replace space(s) with correct letter
    for i in range(len(spaces)):
      if word[i] == guess:
        spaces[i] = guess
        
    if "_" not in spaces: # If no more spaces, user has won game
      won = True
