package B_세젤예어플리케이션;

class UserSolution 
{
	
    private char Table[][][];
    private int[] w;
    private boolean[][] nonDeter;
    
    void initTable()
    {
    	Table = new char[Constants.HEIGHT][Constants.WIDTH][Constants.LENGTH];
    }
    
    boolean updateCell(int row, int col, char equation[], int value[][])
    {
    	boolean[][] isNumber = new boolean[Constants.HEIGHT][Constants.WIDTH];
    	nonDeter = new boolean[Constants.HEIGHT][Constants.WIDTH];
    	
    	//union, find에 사용할 w 배열 초기화
    	w = new int[Constants.HEIGHT * Constants.WIDTH];
    	for(int i=0; i<Constants.HEIGHT; i++) {
    		for(int j=0; j<Constants.WIDTH; j++) {
    			int index = i*Constants.WIDTH + j;
    			w[index] = index;
    		}
    	}
    	
    	for(int i=0; i<equation.length; i++)
    		Table[row-1][col-1][i] = equation[i];
    	
    	if(Table[row-1][col-1][0] != '=')	return true;
    	
    	int imCount = 0;
    	
    	for(int i=0; i<Constants.HEIGHT; i++) {
    		for(int j=0; j<Constants.WIDTH; j++) {
    			if(Table[i][j][0] == '\u0000')	continue;
    			
    			if(Table[i][j][0] != '=') {
    				int tmp_i = 0;
    				String s = "";
    				while(Table[i][j][tmp_i] != '\u0000') {
    					s += Table[i][j][tmp_i];
    					tmp_i++;
    				}
    				
    				value[i][j] = Integer.parseInt(s);
    				isNumber[i][j] = true;
    			}
    		}
    	}
    	
    	for(int i=0; i<Constants.HEIGHT; i++) {
    		for(int j=0; j<Constants.WIDTH; j++) {
    			if(Table[i][j][0] != '=')	continue;
    			
    			
    		}
    	}
    	
    	return true;
    }
    
    int find(int index) {
    	if(w[index] == index)	return index;
    	else	return w[index] = find(w[index]);
    }
    
    void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	if(a < b)		w[b] = a;
    	else if(b > a)	w[a] = b;
    }
}
