This folder contains the Barist-matic Programming assignment

Author- Sahana Sachindra Mallya

This package contains the following files.

....12 java files
....1 ReadMe.txt file
....1 output.txt file

Explanation of the coding concept:

I have used AbstractFactoryPattern in this simulation.

BaristaMatic.java is the main class that should be run to start the application.
MenuOptions.java and Ingredients.java are interfaces. The reason I chose to make these interfaces is that they contain Constants. By making them as interfaces, we can keep the code maintainable. We can add some more MenuOptions and ingredients easily in the interfaces, extend the helper class and easily enhance the code. 
For eg, if we need to add "Fat Free Milk", it is just a matter of adding it in the central interface which can be subclassesd and used appropriately.

I have made each of the drinks as separate classes. (In other words CaffeAmericano is a MenuOption). Each drink's class is responsible to prepare the drink, calculate its cost, and setIngredients. If these ingredients or the recipe changes, it is just a matter of subclassing and overriding the drink's class.

Inventory is the class specilized to take care of the inventory.

The program begins with the list of inventories and menu options.
The user is supposed to choose a number between (1-6) followed by the "q" command to quit
The inventory is updated and displayed with the latest update.
Upon entering "r" the inventory is refilled and updated.
I have also handled error or invalid commands as shown in the output.

I have compiled and run the programs successfully. 

 