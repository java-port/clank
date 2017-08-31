/*copyright*/
#ifndef __FILE_WITH_GUARD_H__
#define __FILE_WITH_GUARD_H__

#ifdef A
int file_guarded_macro_a;
#elif B
int file_guarded_macro_b;
#else
int file_guarded_no_macro;
#endif

#define PPP __pascal

int __far __pascal LibMain ( int a, short b, short c, long d );

#endif //__FILE_WITH_GUARD_H__
