#include <stdio.h>

extern int variableExterna;
extern void modificarVariableExterna();

int main(void) {
    printf("Hello, World!\n");
    printf("Variable: %d\n", variableExterna);
    modificarVariableExterna();
    printf("Variable: %d\n", variableExterna);
    return 0;
}
