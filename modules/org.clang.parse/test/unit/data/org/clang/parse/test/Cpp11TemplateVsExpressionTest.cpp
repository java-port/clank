// RUN %clang_cc1 -fsyntax-only -std=c++11 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/Cpp11TemplateVsExpressionTest.cpp
// expected-no-diagnostics

template <int Val>
struct X {
  X(int var);
};

static int Y = 0;

int main() {
  auto a = X<5>(0);
  auto b = Y<5>(0);
  return 0;
}
