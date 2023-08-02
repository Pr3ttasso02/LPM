#include<stdio.h>
#include<limits.h>
#include<float.h>
void main(){
	int i = INT_MAX;
	float f = FLT_MAX;
	double d = DBL_MAX;

	printf("\n\tMaior inteiro positivo: %d", i);
	printf("\n\tMaior inteiro negativo: %d", i+1);
	printf("\n\tMaior float (simples) positivo: %f", f);
	printf("\n\tMaior double (duplo) positivo: %f", d);
}
