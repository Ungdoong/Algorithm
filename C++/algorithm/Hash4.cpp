#include <stdio.h>
#include <memory>

using namespace std;

#define MAX_KEY 64
#define MAX_DATA 128
#define MAX_TABLE 409

struct Hash{
	char key[MAX_KEY + 1];
	char data[MAX_DATA + 1];

	Hash() {
		memset(key, 0, MAX_KEY + 1);
	}
};

int my_strcmp(const char *str1, const char *str2){
	while (*str1 != '\0' && *str1 == *str2) {
		str1++;
		str2++;
	}

	return *str1 - *str2;
}

void my_strcpy(char *dest, const char *src) {
	while (*dest = *src) {
		*dest++;
		*src++;
	}
}

class MyHash {
private:
	Hash table[MAX_TABLE];
public:
	MyHash(){}

	int hash(const char* key) {
		unsigned long hash = 5381;
		char c;

		while (c = *key++) {
			hash = (((hash << 5) + hash) + c) % MAX_TABLE;
		}

		return hash % MAX_TABLE;
	}

	void find(const char *key, const char *data) {
		unsigned long h = hash(key);
		int cnt = MAX_TABLE;

		while (table[h].key[0] != 0 && cnt--) {
			if (my_strcmp(table[h].key, key) == 0) {
				printf("Find %s / %s\n", key, data);
				return;
			}

			h = (h + 1) % MAX_TABLE;
		}

		printf("Not Found\n");
	}

	void add(const char *key, const char *data) {
		unsigned long h = hash(key);
		int cnt = MAX_TABLE;

		while (table[h].key[0] != 0 && cnt--) {
			if (my_strcmp(table[h].key, key) == 0) {
				printf("Already Exist\n");
				return;
			}

			h = (h + 1) % MAX_TABLE;
		}

		if (cnt) {
			my_strcpy(table[h].key, key);
			my_strcpy(table[h].data, data);
			printf("Added\n");
		}
	}
};

int main(int argc, char argv[]) {
	MyHash hash;

	hash.add("01", "hello");
	hash.add("01", "hello");
	hash.find("02", "hello");
	hash.add("02", "hello");
	hash.find("02", "hello");
	hash.add("03", "hello!");

	return 1;
}