#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
	int answer = 0, max_h = board.size();
	vector<int> bucket;
	for (int i = 0; i < moves.size(); i++) {
		int cur = moves[i] - 1;
		
		for (int h = 0; h < max_h; h++) {
			if (board[h][cur] != 0) {
				int doll = board[h][cur];
				board[h][cur] = 0;

				if (bucket.size() && (doll == bucket.back())) {
					bucket.pop_back();
					answer += 2;
				}
				else {
					bucket.push_back(doll);
				}
				break;
			}
		}
	}

	return answer;
}

int main(int argc, char* argv[]) {
	vector<vector<int>> board = { {0, 0, 0, 0, 0},{0, 0, 1, 0, 3},{0, 2, 5, 0, 1},{4, 2, 4, 4, 2},{3, 5, 1, 3, 1} };
	vector<int> moves = { 1, 5,3,5,1,2,1,4 };

	int answer = solution(board, moves);

	printf("%d", answer);
}