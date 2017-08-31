// RUN %clang_cc1 -fsyntax-only -std=c++11 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/MultiArgsTemplatesTest.cpp
// expected-no-diagnostics

struct AAA379 {};
struct BBB379 {};
struct CCC379 {};

template <typename T1>
struct OneTemplateParam {};

template <typename T1, typename T2>
struct TwoTemplateParams {};

template <typename T1, typename T2, typename T3>
struct MultiLevelWildcards {};

void foo379() {
  TwoTemplateParams<AAA379*, AAA379*> VarTTP0;
  MultiLevelWildcards<TwoTemplateParams<AAA379*, AAA379*>, AAA379, AAA379> VarTTP1;
  MultiLevelWildcards<TwoTemplateParams<AAA379, AAA379>, OneTemplateParam<AAA379*>, BBB379> Var1;
  MultiLevelWildcards<TwoTemplateParams<AAA379, BBB379>, OneTemplateParam<AAA379*>, BBB379> Var2;
  MultiLevelWildcards<TwoTemplateParams<AAA379, CCC379>, OneTemplateParam<AAA379*>, BBB379> Var3;
  MultiLevelWildcards<TwoTemplateParams<AAA379, AAA379>, TwoTemplateParams<BBB379, BBB379>, TwoTemplateParams<CCC379, CCC379>> Var4;
}