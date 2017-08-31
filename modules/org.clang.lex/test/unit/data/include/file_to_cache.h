
#include/*comment*/ "file_with_guard.h"

#ifdef /*comment*/A
#/*comment*/include "file_a.h"
int file_to_cache_macro_a;
#/*comment*/elif B
#include "file_b.h"/*comment*/
int file_to_cache_macro_b;
#else/*comment*/
#include "file_c.h"
int file_to_cache_no_macro;
#endif
