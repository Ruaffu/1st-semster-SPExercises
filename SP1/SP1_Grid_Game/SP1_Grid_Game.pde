
int size = 40;
int gridSize = 25;
int[][] grid = new int[gridSize][gridSize];

Player player;
Enemy enemys[] = new Enemy[4];
Food food[] = new Food[4];

void setup()
{
  size(1001, 1001);
  frameRate(20);
  player = new Player(3, 4);
  initializeEnemys();
  initializeFood();
}

void draw()
{
  clearBoard();
  updateEntities();
  drawBoard();
  resolveCollisions();
  ui();
  isGameOver();
  player.playerMove();
}


void clearBoard()
{
  for (int x = 0; x < grid.length; x++)
  {
    for (int y = 0; y < grid[0].length; y++)
    {
      grid[x][y] = 0;
    }
  }
}

// the grid
void drawBoard()
{
  for (int x = 0; x < grid.length; x++)
  {
    for (int y = 0; y < grid[0].length; y++)
    {
      fill(getColorFromType(grid[x][y]));

      rect(x * size, y * size, size, size);
    }
  }
}

void resolveCollisions()
{
  for (int i = 0; i < enemys.length; i++) {
    if (grid[player.x][player.y] == grid[enemys[i].x][enemys[i].y])
    {
      player.takeDamage();
    }
  }

  for (int i = 0; i < food.length; i++) {
    if (grid[player.x][player.y] == grid[food[i].x][food[i].y]) {
      player.increaseScore();
    }
  }
}

// update player, enemys and food
void updateEntities()
{
  grid[player.x][player.y] = player.type;

  for (int i = 0; i < enemys.length; i++) {
    grid[enemys[i].x][enemys[i].y] = enemys[i].type;
    enemys[i].MoveTowardsPlayer();
  }

  for (int i = 0; i < enemys.length; i++) {
    grid[food[i].x][food[i].y] = food[i].type;
    food[i].moveAwayFromPlayer();
  }
}

// colors
color getColorFromType(int type) 
{
  color c = color(255);

  switch(type)
  {
  case 0: 
    c = color(127);
    break;
  case 1: 
    c = color(255, 0, 0);
    break;
  case 2: 
    c = color(0, 255, 0);
    break;
  case 3: 
    c = color(0, 255, 0);
    break;
  case 4: 
    c = color (64, 116, 255);
    break;
  }    

  return c;
}

// displays the game over screen and the final score
void isGameOver()
{
  boolean gameOver;
  if (player.health < -1)
  {
    gameOver = true;
  } else {
    gameOver = false;
  }

  if (gameOver == true)
  {
    stroke(0);
    fill(0);
    rect(0, 0, 1000, 1000);
    textSize(50);
    fill(250, 0, 0);
    text("Fatality!", 400, 400);
    text("Game over the final score is: "+ player.score, 100, height/2);
    stop();
  }
}

// health bar and score 
void ui()
{
  // Health bar
  stroke(0);
  fill(255, 100);
  rect(300, 5, 100, 40);
  fill(250, 0, 0, 200);
  rect(300, 5, player.health, 40);
  textSize(20);
  fill(0);
  text("Health", 305, 30);

  // Score
  stroke(0);
  fill(255, 100);
  rect(600, 5, 100, 40);
  textSize(20);
  fill(252, 232, 5);
  text("Score: " + player.score, 605, 30);
}

//this method initializes the enemys
void initializeEnemys()
{
  for (int i = 0; i < enemys.length; i++) {
    enemys[i] = new Enemy((int)random(0, grid.length), (int)random(0, grid[0].length), player);
  }
}

//this method initializes the food
void initializeFood()
{
  for (int i = 0; i < food.length; i++) {
    food[i] = new Food((int)random(0, grid.length), (int)random(0, grid[0].length), player);
  }
}
