class Enemy
{
  int x; 
  int y; 
  int type = 1; 
  Player player;

  Enemy(int x, int y, Player player)
  {
    this.x = x;
    this.y = y;
    this.player = player;
    
  }

  // prevents ArrayIndexOutOfBoundsException. 
  void outOfBounds()
  {
    for (int i = 0; i < enemys.length; i++) {
      enemys[i].x = constrain(enemys[i].x, 0, 24);
      enemys[i].y = constrain(enemys[i].y, 0, 24);
    }
  }

  // Enemy units follow player around the grid
  void MoveTowardsPlayer()
  { 
    // random chance (~25% chance) for at enemy flytter sig i en tilfældig retning.
    if (Math.random() < 0.25)
    {
      this.x = (int)random(25);
      this.y = (int)random(25);
    }  

    int xDistance = Math.abs(player.x - this.x);
    int yDistance = Math.abs(player.y - this.y);

    if (xDistance < yDistance)
    {
      if (player.x < this.x) {
        this.x -= 1;
      } else if (player.x > this.x) {
        this.x += 1;
      } else if (player.y < this.y) {
        this.y -= 1;
      } else if (player.y > this.y) {
        this.x += 1;
      }
      outOfBounds();
    }
  }
}
