
public class Maze
{
    private static char[][] maze;
    private static Location checkpoint = new Location(3,1);
    public Maze(char[][] aMaze) 
    {
        maze = aMaze;
    }

    public static boolean hasExit(Location location)
    {
        int x = location.getX();
        int y = location.getY();
        if((x == 0 && maze[0][y] == ' ') || (y == 0 && maze[x][0] == ' ') || 
        (x == maze.length - 1 && maze[maze.length - 1][y] == ' ') || 
        (y == maze[0].length - 1 && maze[x][maze[0].length] == ' '))
        {
            maze[x][y] = '!';
            for(int i = 0; i < maze[0].length; i++)
            {
                for(int j = 0; j < maze[0].length; j++)
                {
                    if(maze[i][j] == 'X')
                        maze[i][j] = ' ';
                }
            }
            return true;
        }
        if(x!=0 && y!=0 && x!=maze.length-1 && y!=maze[0].length-1)
        {
            int possibleRoutes = 0;
            if(maze[x - 1][y] == ' ')
                possibleRoutes++;
            if(maze[x + 1][y] == ' ')
                possibleRoutes++;
            if(maze[x][y - 1] == ' ')
                possibleRoutes++;
            if(maze[x][y + 1] == ' ')
                possibleRoutes++;
            if(possibleRoutes > 1)
            {
                for(int i = 0; i < maze.length; i++)
                {
                    for(int j = 0; j < maze[0].length; j++)
                    {
                        if(maze[i][j] == 'X')
                            maze[i][j] = ' ';

                    }
                    checkpoint = new Location(x, y);
                }
            }
            if(x < maze.length - 1 && maze[x + 1][y] == ' ') {  //check down
                maze[x][y] = '~';
                return hasExit(new Location(x + 1, y));
            }
            else if(y < maze[0].length - 1 && maze[x][y + 1] == ' ') //check right
            {
                maze[x][y] = '~';
                return hasExit(new Location(x, y + 1));
            }
            else if(y > 0 && maze[x][y - 1] == ' ')  //check left
            {
                maze[x][y] = '~';
                return hasExit(new Location(x, y - 1));
            }
            else if(x > 0 && maze[x - 1][y] == ' ') //check up
            {
                maze[x][y] = '~';
                return hasExit(new Location(x - 1, y));
            }
            else
            {
                if(maze[x][y] == ' ')
                {
                    maze[x][y] = 'X';
                    return hasExit(checkpoint);
                }
                else
                {
                    for(int i = 0; i < maze.length; i++)
                    {
                        for(int j = 0; j < maze[0].length; j++)
                        {
                            if(maze[i][j] == '~' || maze[i][j] == 'X')
                                maze[i][j] = ' ';
                        }
                    }
                }
            }
        }
        return false;
    }
}
