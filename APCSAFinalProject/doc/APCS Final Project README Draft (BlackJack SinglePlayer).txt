Card Game Simulator
Authors: Bill Li, Patrick Yu, Hagen Zhang
Revision: April 14, 2020


Introduction: 
Our program offers the card game(s) users can play with their friends. We had the idea for this program after realising how easy it was to lose cards. If even one card is lost, then the entire deck is rendered useless. We hope that our program can solve this issue by allowing users to play online or through a computer, our reasoning being that people are generally less likely to misplace a computer than a card. 
The rules of the game are consistent with that of each card game that we code. For example, in poker, we allow users to raise, fold, and draw. Basic card logic, such as the hierarchy of suits and combinations also apply. The goal of the game is to win. How victory is determined depends on the card game. This game would be marketed to anyone who wanted to play cards in a more convenient manner. The primary features of the program would involve an interface of cards, similar to that of a real card game (with chips, cards, and a table), multiplayer capabilities, and the game itself. 


Instructions:
Mouse Functions:
* Clicking instructions on the main menu will bring up a page containing the rules and controls for the game.
* Clicking the play option on the main menu will allow the player to play.
* The player would have to click on the card they would like to play during their turn.
* Clicking resume in the options menu will resume the game.
* Clicking exit in the options menu will allow the user to exit the game.
Features List:
Must-have Features:
* Menu to select games
   * Game should start with a welcome screen, then the user should be able to select which game they would like to play, with how many players, etc etc.
* Programmed in Cards/Card Logic
   * The game should know card logic: for example, in poker, for each card combination, the computer will determine the hierarchy of combinations, and determine the winner
* Needs at least 1 game with proper rule set built in
   * This application should have the logic for one game coded in
* Interface with basic graphics resembling a card game (table divided based on player, cards)
   * The game itself will have images of cards, tables, and chips for an immersive experience.
* Game is functional
   * Game is able to be played by user
________________
   * 

Want-to-have Features:
* Multiple card games 
   * Users would be able to choose between a wide variety of games, such as hearts, poker, blackjack, etc etc
* Multiplayer Capability (passing the device)
   * Each game would be played with one device; player one would make the first move on the device, then pass the device to player two (who will then make a decision), and so on and so forth
* Multiplayer capability (online)
   * Rather than passing the device, players can play with their friends by connecting multiple devices together to form a party
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




Class List:
* Main - Starts program, prompts user to select a game
* GameMenu - Lists available game options to user
* PlayerMenu - Allows users to control the number of players in the game (includes multiplayer)
* Card - Creates an object that represents a single card. The suit and rank are represented as fields. 
* PlayingBoard - Creates the digital table on which the card games are played
* CardGame - Interface for all other card game types
   * (ex:) Poker - Class that extends CardGame and has the game rules built in. Players can pull up a menu that explains all the rules.




________________


Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
* List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
* Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]


Done:
Bill Li:
* README


Patrick Yu:
* README


Hagen Zhang:
* README        


To-Do:
Bill Li:
* Main
* GameMenu
* PlayerMenu
* BlackJack


Patrick Yu:
* PlayingBoard
* GameMenu
* PlayerMenu
* BlackJack
* Card


Hagen Zhang:
* Card
* CardGame
* CardStack
   * BlackJack