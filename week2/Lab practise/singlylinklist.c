#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node {
    char name[50];
    char priority[10];
    struct Node* next;
} Node;

Node *urgentHead = NULL, *urgentTail = NULL;
Node *regularHead = NULL, *regularTail = NULL;

Node* createNode(char* name, char* priority) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    strcpy(newNode->name, name);
    strcpy(newNode->priority, priority);
    newNode->next = NULL;
    return newNode;
}

void arrive(char* name, char* priority) {
    Node* newNode = createNode(name, priority);
    if (strcmp(priority, "URGENT") == 0) {
        if (urgentHead == NULL) urgentHead = urgentTail = newNode;
        else { urgentTail->next = newNode; urgentTail = newNode; }
    } else {
        if (regularHead == NULL) regularHead = regularTail = newNode;
        else { regularTail->next = newNode; regularTail = newNode; }
    }
}

void serve() {
    if (urgentHead != NULL) {
        printf("SERVE → %s\n", urgentHead->name);
        Node* temp = urgentHead;
        urgentHead = urgentHead->next;
        if (urgentHead == NULL) urgentTail = NULL;
        free(temp);
    } else if (regularHead != NULL) {
        printf("SERVE → %s\n", regularHead->name);
        Node* temp = regularHead;
        regularHead = regularHead->next;
        if (regularHead == NULL) regularTail = NULL;
        free(temp);
    } else {
        printf("SERVE → No patients\n");
    }
}

void printList(Node* head) {
    Node* p = head; int first = 1;
    while (p != NULL) {
        if (!first) printf(", ");
        printf("%s", p->name);
        first = 0;
        p = p->next;
    }
}

void list() {
    printf("LIST → URGENT:[");
    printList(urgentHead);
    printf("] REGULAR:[");
    printList(regularHead);
    printf("]\n");
}

int main() {
    // Test Case 1
    arrive("xyz", "yzx");
    arrive("yzw", "xyw");
    arrive("yxw", "xyz");

    list();  
    serve(); 
    list();   

    return 0;
}