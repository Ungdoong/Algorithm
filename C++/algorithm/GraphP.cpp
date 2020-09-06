#include <stdio.h>
#include <memory>

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

Graph* createGraph(int N) {
	Graph *newGraph = (Graph *)malloc(sizeof(Graph));

	newGraph->num_vertices = N;
	newGraph->adjList = (AdjList *)malloc(sizeof(AdjList));
	for (int i = 0; i < N; i++) {
		newGraph->num_vertices = 0;
		newGraph->adjList[i].head = newGraph->adjList[i].tail = NULL;
	}

	return newGraph;
}

void destroyGraph(Graph *graph) {
	if (graph) {
		if (graph->adjList) {
			for (int i = 0; i < graph->num_vertices; i++) {
				Node *ptr = graph->adjList[i].head;
				while (ptr) {
					Node *tmp = ptr;
					ptr = ptr->next;

					free(tmp);
				}
			}

			free(graph->adjList);
		}

		free(graph);
	}
}

void addNode(Graph *graph, int src, int dst) {
	Node *newNode = createNode(dst);

	if (graph->adjList[src].tail == NULL) {
		graph->adjList[src].head = graph->adjList[src].tail =newNode;
	}
	else {
		graph->adjList[src].tail->next = newNode;
		graph->adjList[src].tail = newNode;
	}
	graph->adjList[src].num_members++;

	newNode = createNode(src);
	if (graph->adjList[dst].tail == NULL) {
		graph->adjList[dst].head = graph->adjList[dst].tail = newNode;
	}
	else {
		graph->adjList[dst].tail->next = newNode;
		graph->adjList[dst].tail = newNode;
	}
	graph->adjList[dst].num_members++;
}

void displayGraph(Graph *graph, int v) {
	Node *ptr = graph->adjList[v].head;

	while (ptr) {
		printf("%d ", ptr->vertex);
		ptr = ptr->next;
	}
	printf("\n");
}

int main(int argc, char* argv[]) {
	Graph *graph = createGraph(6);

	addNode(graph, 0, 1);
	addNode(graph, 0, 2);
	addNode(graph, 0, 3);
	addNode(graph, 1, 2);
	addNode(graph, 1, 4);
	addNode(graph, 3, 4);
	addNode(graph, 4, 5);

	displayGraph(graph, 0);
	displayGraph(graph, 2);
	displayGraph(graph, 4);
}