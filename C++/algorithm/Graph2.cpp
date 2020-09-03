#include <stdio.h>
#include <malloc.h>

typedef struct node {
	int vertex;
	node *next;
}Node;

typedef struct {
	int num_members;
	Node *head;
	Node *tail;
}AdjList;

typedef struct {
	int num_vertices;
	AdjList *adjList;
}Graph;

Node* createNode(int v) {
	Node *newNode = (Node *)malloc(sizeof(Node));

	newNode->vertex = v;
	newNode->next = NULL;

	return newNode;
}

Graph* createGraph(int n) {
	Graph *graph = (Graph *)malloc(sizeof(Graph));
	graph->num_vertices = n;

	graph->adjList = (AdjList *)malloc(sizeof(AdjList) * n);

	for (int i = 0; i < n; i++) {
		graph->adjList[i].head = graph->adjList[i].tail = NULL;
		graph->adjList[i].num_members = 0;
	}

	return graph;
}

void destroyGraph(Graph *graph) {
	if (graph) {
		if (graph->adjList) {
			for (int v = 0; v < graph->num_vertices; v++) {
				Node * listPtr = graph->adjList[v].head;
				while (listPtr) {
					Node *tmp = listPtr;
					listPtr = listPtr->next;
					free(tmp);
				}
			}

			free(graph->adjList);
		}

		free(graph);
	}
}

void addNode(Graph *graph, int src, int dest) {
	Node *newNode = createNode(dest);

	if (graph->adjList[src].tail != NULL) {
		graph->adjList[src].tail->next = newNode;
		graph->adjList[src].tail = newNode;
	}
	else {
		graph->adjList[src].head = graph->adjList[src].tail = newNode;
	}
	graph->adjList[src].num_members++;

	newNode = createNode(src);
	if (graph->adjList[dest].tail != NULL) {
		graph->adjList[dest].tail->next = newNode;
		graph->adjList[dest].tail = newNode;
	}
	else {
		graph->adjList[dest].head = graph->adjList[dest].tail = newNode;
	}
	graph->adjList[dest].num_members++;
}

void displayGraph(Graph *graph, int i) {
	Node *listPtr = graph->adjList[i].head;
	while (listPtr) {
		printf("%d ", listPtr->vertex);
		listPtr = listPtr->next;
	}
	printf("\n");
}

int main(int argc, char* argv[]) {
	int T, V, E, Q, sv, ev;

	scanf_s("%d", &T);

	for (int test_case = 1; test_case <= T; test_case++) {
		scanf_s("%d %d %d", &V, &E, &Q);

		Graph *graph = createGraph(V);

		for (int i = 0; i < E; i++) {
			scanf_s("%d %d", &sv, &ev);
			addNode(graph, sv, ev);
		}
		printf("#%d\n", test_case);

		for (int i = 0; i < Q; i++) {
			scanf_s("%d", &sv);
			displayGraph(graph, sv);
		}
	}

	return 0;
}