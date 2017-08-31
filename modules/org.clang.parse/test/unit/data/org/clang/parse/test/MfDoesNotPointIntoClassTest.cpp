//// RUN %clang_cc1 -fsyntax-only -std=c++98 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/MfDoesNotPointIntoClassTest.cpp
//// expected-no-diagnostics

template<typename _Ret, typename _Tp>
class mem_fun_t
{
public:
  explicit
  mem_fun_t(_Ret (_Tp::*__pf)())
  : _M_f(__pf) { }

  _Ret
  operator()(_Tp* __p) const
  { return (__p->*_M_f)(); }

private:
  _Ret (_Tp::*_M_f)();
};