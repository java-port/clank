// RUN: %clang_cc1 -std=c++11 -verify %s

template <typename T>
class AAA {
  class Inner {
    static const int Val = 5; // expected-note {{implicitly declared private here}}
    friend class AAA<char>;
  };
  
  int foo();
};

template <>
int AAA<int>::foo() {
  return Inner::Val; // expected-error {{'Val' is a private member of 'AAA<int>::Inner'}}
}

template <>
int AAA<char>::foo() {
  return Inner::Val;
}
