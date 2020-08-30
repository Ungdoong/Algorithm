#pragma once
#ifndef __KMP_H__
#define __KMP_H__

class KMP {
private:
	char arr[100];
public:
	int* getPi(char* pattern);
	int kmp(char* str, char* pattern);
};
#endif // !__KMP_H__
