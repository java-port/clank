// RUN: %clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify %s > %T/noreturn_func.cpp.ast
// RUN: %clang_cc1 -triple x86_64-unknown-linux-gnu -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/noreturn_func.cpp.cfg
// RUN: diff %T/noreturn_func.cpp.cfg %S/Input/noreturn_func.cpp.cfg > %T/noreturn_func.cpp.cfg.diff
// expected-no-diagnostics

void __my_throw_bad_cast(void) __attribute__((__noreturn__));

inline const char& __my_check_facet(const char* __f)
{
  if (!__f) {
    __my_throw_bad_cast();
  }
  return *__f;
}

