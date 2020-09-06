#include <stdio.h>

#define MAX_KEY 64
#define MAX_DATA 128
#define MAX_TABLE 4096


typedef struct {
	char key[MAX_KEY + 1];
	char data[MAX_DATA + 1];
}Hash;

Hash table[MAX_TABLE];

int m_strcmp(const char *str1, const char *str2) {
	while (*str1 != 0 && *str1 == *str2) {
		str1++;
		str2++;
	}

	return *str1 - *str2;
}

void m_strcpy(char *dst, const char *src) {
	while (*dst = *src) {
		dst++;
		src++;
	}

	*dst = '\0';
}

unsigned long hash(const char *key) {
	unsigned long hash = 5381;
	int c;

	while (c = *key++) {
		hash = (((hash << 5) + hash) + c) % MAX_KEY;
	}

	return hash % MAX_KEY;
}

void find(const char *key) {
	unsigned long h = hash(key);
	int cnt = MAX_TABLE;

	while (cnt-- && table[h].key[0] != 0) {
		if (m_strcmp(table[h].key, key) == 0) {
			printf("Find %s, %s\n", table[h].key, table[h].data);
			return;
		}

		h = (h + 1) % MAX_TABLE;
	}

	printf("Not Found\n");
}

void add(const char *key, const char *data) {
	unsigned long h = hash(key);
	int cnt = MAX_TABLE;

	while (cnt-- && table[h].key[0] != 0) {
		if (m_strcmp(table[h].key, key) == 0) {
			printf("Aleady Exist\n");
			return;
		}

	}

	if (cnt) {
		m_strcpy(table[h].key, key);
		m_strcpy(table[h].data, data);
		printf("Added\n");
	}
	else {
		printf("table is full\n");
	}
}

int main(int argc, char argv[]) {
	add("01", "hello");
	add("01", "hello");
	find("02");
	add("02", "hello");
	find("02");
	add("03", "hello!");

	return 1;
}