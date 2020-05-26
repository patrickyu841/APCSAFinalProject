Card Game Simulator
Authors: Bill Li, Patrick Yu, Hagen Zhang
Last Revision: May 25, 2020


YT presentation link: https://www.youtube.com/watch?v=wCW2Qy1feRs


Introduction: 
Our program offers a card game or several games which users can play with their friends. We had the idea for this program after realising how easy it was to lose cards. If even one card is lost, then the entire deck is rendered useless. We hope that our program can solve this issue by allowing users to play online or through a computer, our reasoning being that people are generally less likely to misplace a computer than a card. 
The rules of the game are consistent with that of each card game that we code. For example, in poker, we allow users to raise, fold, and draw. Basic card logic, such as the hierarchy of suits and combinations also apply. The goal of the game is to win. How victory is determined depends on the card game. This game would be marketed to anyone who wanted to play cards in a more convenient manner. The primary features of the program would involve an interface of cards, similar to that of a real card game (with cards and a table), multiplayer capabilities, and the game itself. 


Instructions:
Singleplayer:
Mouse Functions:
* Clicking instructions on the main menu will bring up a page containing the rules and controls for the game.
* Clicking the play option on the main menu will allow the player to play.
* The player would have to click on the card they would like to play during their turn.
* Clicking resume in the options menu will resume the game.
* Clicking exit in the options menu will allow the user to exit the game.


Multiplayer:
Keyboard Functions:
* G key - Allows the user to host a game, or check for game start.
* P key - Allows the user to exit the host’s menu, or the waiting room.
Mouse Functions:
* The player would have to click on the card they would like to play during their turn.
* Clicking the exit button on the playing board allows the user to exit to the main menu.
Menu Instructions:
* Clicking instructions on the main menu will bring up a page containing the rules and controls for the game.
* Clicking the host game option will allow a user to host a game online for their friends to join into.
* Clicking the join game option will allow a user to check if a game has started, and to join a host’s game.


________________


Features List:
Must-have Features:
* Menu to select games
   * Game should start with a welcome screen, then choose to join/host a game
* Programmed in Cards/Card Logic
   * The game should know card logic: for example, in poker, for each card combination, the computer will determine the hierarchy of combinations, and determine the winner
* Needs at least 1 game with proper rule set built in
   * This application should at least have one fully functioning game that players can play
* Multiplayer capability (online)
   * Players should be able to play with their friends by connecting multiple devices together to form a party through the use of a server.
* Interface with basic graphics resembling a card game (table, cards, chips)
   * The game itself will have images of cards, decks, etc on a table


Want-to-have Features:
* Multiple card games 
   * Users would be able to choose between a wide variety of games, such as hearts, poker, blackjack, etc etc
* Multiplayer Capability (passing the device)
   * Each game would be played with one device; player one would make the first move on the device, then pass the device to player two (who will then make a decision), and so on and so forth
* Programmed in form of currency (chips)
   * The game will have chips, which players can use to wager (such as raising in poker)
* Online party system
   * Parties of friends who play together can keep track of Win/Loss, can bet in-game currency, or play multiple games together without needing to recreate the party each time 
* In game chat/text features 
   * Players will have the ability of typing in chat rooms
* Card Hand Organization
   * Players can choose between organizing their hand by suit or by number


Stretch Features:
* Bot(s) to play against 
   * If the player decides to play against a bot, they will be put against a bot that is coded to make certain decisions after every turn the player takes.
* Ability to set the difficulty of the bot
   * Depending on what option the player chooses, the bot may make smarter (or less intelligent) decisions.
* Game leaderboard system
   * Leaderboard for all players to see, ranks players based on their win/loss (W/L) ratio (highest ratio first).


________________


Class List:
Singleplayer:
* Main - Starts program, prompts user to select a game
* GameMenu - Lists available game options to user
* PlayerMenu - Allows users to control the number of players in the game (includes multiplayer)
* Card - Creates an object that represents a single card. The suit and rank are represented as fields. 
* PlayingBoard - Creates the digital table on which the card games are played
* CardGame - Interface for all other card game types
   * (ex:) Poker - Class that extends CardGame and has the game rules built in. Players can pull up a menu that explains all the rules.
* DrawingSurface - Represents screen for which all menus and screens of the program are drawn on.


Multiplayer:
* Main - Starts program, prompts user to select a game.
* BlackJack - Represents the rule set and playing board of a BlackJack card game.
* CardGame - Represents the interface for all card game types.
* Card - Represents a card.
* CardStack - Represents a stack of cards.
* DrawingSurface - Represents screen for which all menus and screens of the program are drawn on.
* FirstMenu - Main menu that the user is presented with on program startup.
* HostMenu - Menu that appears if a user wishes to be the host of a card game.
* InstructionsMenu - Menu that contains all the instructions on how to play a card game.
* PlayingBoard - Represents the graphical playing board of a card game.
* Screen - Represents all types of screens
* ScreenSwitcher - Helps switch screens based on user interaction with the program.
* WaitingRoom - Screen that a user is presented with when waiting for another user to host a card game.
* CardState - Represents the state of a card game.
* DataBase - Class that interacts with the Firebase server setup for this project.
* Player - Represents the user playing a card game.


Credits:
Bill Li:
        Singleplayer:
* Main
* GameMenu
* PlayerMenu
* BlackJack
        Multiplayer:
* README
* UML
* Main
* BlackJack
* DrawingSurface
* InstructionsMenu


________________


Patrick Yu:
        Singleplayer:
* README
* UML
* Main
* PlayingBoard
* DrawingSurface
* BlackJack
* Player
* Card
        Multiplayer:
* README
* UML
* BlackJack


Hagen Zhang:
        Singleplayer
* N/A
        Multiplayer
* README        
* UML
* BlackJack
* CardGame
* Card
* CardStack
* DrawingSurface
* Screen
* ScreenSwitcher
* FirstMenu
* HostMenu
* PlayingBoard
* WaitingRoom
* CardState
* CardStateListener
* Database
* Player




Outside Resources:
* Processing library
* Google images
* Mr.Shelby Demos