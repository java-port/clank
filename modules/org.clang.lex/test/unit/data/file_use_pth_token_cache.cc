/*block comment*/
int no_macro; 
#include "include/file_to_cache.h"
#include "include/file_a.h"
#include "include/file_b.h"
#include "include/file_c.h"

int macro_a; // line comment
#define A /*defined A*/
#include "include/file_to_cache.h"
#include "include/file_a.h"
#include "include/file_b.h"
#include "include/file_c.h"

int macro_b;
#undef A /*undef*/
#define B /*defined B*/1
#include "include/file_to_cache.h"
#include "include/file_a.h"
#include "include/file_b.h"
#include "include/file_c.h"

