# Node Coordinates
In back-end keep nodes positive and work in multitudes of 1. Front-end will dynamically calculate the position of the nodes

# Objects
## Maze 
### Variables
- Set of Line objects
- Id
- Path (that the user has taken)
- Last pressed node  // zit in path

### Methods
- GetAllLines() returns a set of lines
- updatePath(cord.) return boolean
  - If return true: do get all lines again
- isComplete() bool

## Line 
### Variables
startNode: Node
endNode: Node
filled: bool
dot: bool

## Node
Type: enum (start, middle, end)
filled: bool
dot: bool
x: int
y: int
