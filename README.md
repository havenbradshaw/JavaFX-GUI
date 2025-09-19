TO RUN, TYPE IN TERMINAL:
mvn javafx:run

This application gives the user a canvas to draw shapes on, it currently allows for circles and rectangles. The shapes are drawn upon mouse click and shape type is controlled by both radio buttons and keyboard commands. The shapes have unique colors and sizes. The shapes are counted and the amount is displayed on the screen. The screen can be cleared by either a button or keyboard command. 

KEYBOARD CONTROLS:

X - CLEAR SCREEN
C - CIRCLE
R - RECTANGLE
LMB - DRAW

level 1: 

Created 3 classes - main, circle and rectangle. Rectangle and Circle define the shapes and main builds the GUI and uses the shape classes to draw the shape specified in the with the radio buttons. Added a button to clear the canvas. 

-AI: 

Used Copilot to help me implement the interactable features (helping me figure out syntax and where to add radio buttons, clear canvas.) Had it refactor my code to run correctly when I had issues with using the classes I made in main. Asked it design and implementation questions to ensure my code is set up properly and easily read. 

level 2:

Added an ObservableLIst to track shapes as they're drawn. Added labels to show live tracking of shapes as they're drawn and have it update when the screen is cleared. 

-AI: 

Used copilot to implement the observablelist into main as well as set up my live labels. Got help with JavaFx syntax, syntax and code structure. 

level 3: 

added keyboard shortcuts to change shape and clear the screen. Refactored my code for maintainability and reducing redundancy. Created DrawableShape interface to be implemented in any shape that can be drawn (circle and rectange) and give those shapes attributes (color). 

AI: 

Had copilot help me with implementing keyboard controls. Copilot cleaned up some of my redundant code by creating new helper methods such as the clearCanvasAndCounts() method. Copilot helpmed me with getting my drawableShapes interface working with rectangle and circle and suggested I use it to provide the color attribute. 

