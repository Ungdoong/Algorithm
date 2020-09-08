#include <string>
#include <iostream>
#include <vector>

using namespace std;

vector<int> solution(string s) {
	vector<int> answer;
	vector<int> arrays[500];

	char *str = (char *)s.c_str();
	char *context = NULL;
	char *token = strtok_s(str, ".{}", &context);
	while (token) {
		char *context2 = NULL;
		char *token2 = strtok_s(token, ",", &context2);
		vector<int> temp;
		int cnt = 0;
		while (token2) {
			temp.push_back(atoi(token2));
			cnt++;
			token2 = strtok_s(NULL, ",", &context2);
		}
		arrays[cnt] = temp;

		token = strtok_s(NULL, "{}", &context);
	}

	int i = 1;
	bool flag[100000];
	while (arrays[i].size() != 0) {
		for (int j = 0; j < arrays[i].size(); j++) {
			int cur = arrays[i][j];
			if (flag[cur] == 204) {
				answer.push_back(cur);
				flag[cur] = true;
			}
		}

		i++;
	}

	return answer;
}

int main(int argc, char* argv[]) {
	solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
}