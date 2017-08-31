// Test C++ chained PCH functionality

// Without PCH
// RUN: %clang_cc1 -fsyntax-only -verify -include %s -include %s %s

// With PCH
// RUN: %clang_cc1 -fsyntax-only -verify %s -chain-include %s -chain-include %s

// With modules
// RUN: %clang_cc1 -fsyntax-only -verify -fmodules %s -chain-include %s -chain-include %s

// expected-no-diagnostics

#ifndef HEADER1
#define HEADER1
//===----------------------------------------------------------------------===//
// Primary header for C++ chained PCH test

// Typedef
typedef int Integer;

//===----------------------------------------------------------------------===//
#elif not defined(HEADER2)
#define HEADER2
#if !defined(HEADER1)
#error Header inclusion order messed up
#endif

//===----------------------------------------------------------------------===//
// Dependent header for C++ chained PCH test

// Redefinition of typedef
typedef int Integer;

//===----------------------------------------------------------------------===//
#else
//===----------------------------------------------------------------------===//

Integer i = 17;

//===----------------------------------------------------------------------===//
#endif
