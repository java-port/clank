// RUN: %clang_cc1 -analyze -analyzer-checker=core.NullDereference -analyzer-output=text %s -verify
// RUN: %clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text %s -verify
int test(int *pp) {
  if (!pp) {
    //expected-note@-1{{Assuming 'pp' is null}}
    //expected-note@-2{{Taking true branch}}
    return *pp; // expected-warning {{Dereference of null pointer (loaded from variable 'pp')}}
                // expected-note@-1 {{Dereference of null pointer (loaded from variable 'pp')}}
  }
  return 0;
}
