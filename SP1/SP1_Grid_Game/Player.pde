class Player
{
  int x; 
  int y; 
  int type = 3; 
  int health; 
  int score;

  Player(int x, int y)
  {
    this.x = x;
    this.y = y;
    health = 100;
  }


  void takeDamage()
  {
    health--;
  }

  void increaseScore()
  {
    score++;
  }

  // prevents ArrayIndexOutOfBoundsException. 
  void outOfBounds()
  {
    for (int i = 0; i < player.x; i++) { //right
      player.x = constrain(player.x, 0, 24);
    }
    for (int i = 0; i > player.x; i--) { //left
      player.x = constrain(player.x, 0, 24);
    }
    for (int i = 0; i < player.y; i++) { //down
      player.y = constrain(player.y, 0, 24);
    }
    for (int i = 0; i > player.y; i--) { //up
      player.y = constrain(player.y, 0, 24);
    }
  }

  // player controls
  void playerMove()
  {
    if (keyPressed)
    {
      if (key == 'w')
      {
        player.y--;
      }
      if (key == 'a')
      {
        player.x--;
      }
      if (key == 's')
      {
        player.y++;
      }
      if (key == 'd')
      {
        player.x++;
      }
      outOfBounds();
    }
  }
}
