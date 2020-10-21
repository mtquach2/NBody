# NBody

NAME: Michelle Quach

DATE OF COMPLETION: October 21, 2020

PURPOSE OF LAB: Understand how to implement Lists(LinkedLists and ArrayLists) and create our first GUI. 

METHOD: We first read the file given in the code and scan all of the variables into a list. Based on what the first line says in the file, it is either going to be an ArrayList or LinkedList. Once the list is created, we create the Celestial bodies itself using the x/y positions and the size given in the file. We also create a random color for the Celestial. Then, we change the positions of the Celestials using the force equation F = G * m1 * m2 / r^2 and the initial velocities of the Celestials itself. This all happens in the Bodies.java file and is called in the main file NBody.java so that the Celestials move on the JFrame. (Due to fast speeds, timer is set to 500 so that the animations are visible to the naked eye). 

OUTSIDE SOURCES / HELP: Hunter Rocha

MESSAGE FOR GRADER: *USING JAVA 13* Animation may not work exactly the way it is supposed to. 
