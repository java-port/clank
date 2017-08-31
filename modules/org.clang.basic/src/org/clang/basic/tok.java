/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */
package org.clang.basic;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.basic.*;
import static org.clang.basic.tok.TokenKind.*;
import static org.clang.basic.tok.PPKeywordKind.*;
import static org.clang.basic.tok.ObjCKeywordKind.*;

import static org.clang.basic.impl.TokenKindsStatics.TokNames;

//<editor-fold defaultstate="collapsed" desc="static type tok">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok11OnOffSwitchE;_ZN5clang3tok12getTokenNameENS0_9TokenKindE;_ZN5clang3tok12isAnnotationENS0_9TokenKindE;_ZN5clang3tok13PPKeywordKindE;_ZN5clang3tok15ObjCKeywordKindE;_ZN5clang3tok15isAnyIdentifierENS0_9TokenKindE;_ZN5clang3tok15isStringLiteralENS0_9TokenKindE;_ZN5clang3tok18getKeywordSpellingENS0_9TokenKindE;_ZN5clang3tok21getPunctuatorSpellingENS0_9TokenKindE;_ZN5clang3tok9TokenKindE;_ZN5clang3tok9isLiteralENS0_9TokenKindE; -static-type=tok -package=org.clang.basic")
//</editor-fold>
public final class tok {


/// \brief Provides a simple uniform namespace for tokens from all C languages.
//<editor-fold defaultstate="collapsed" desc="clang::tok::TokenKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TokenKinds.h", line = 25,
 FQN="clang::tok::TokenKind", NM="_ZN5clang3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok9TokenKindE")
//</editor-fold>
public static final class/*enum*/ TokenKind/* : unsigned short*/ {
  
  //===----------------------------------------------------------------------===//
  // Language keywords.
  //===----------------------------------------------------------------------===//
  
  // These define members of the tok::* namespace.
  public static final char unknown = 0;
  // Not a token.
  public static final char eof = unknown + 1;
  // End of file.
  public static final char eod = eof + 1;
  // End of preprocessing directive (end of line inside a
  // directive).
  public static final char code_completion = eod + 1;
  // Code completion marker
  
  // C99 6.4.9: Comments.
  public static final char comment = code_completion + 1;
  // Comment (only in -E -C[C] mode)
  
  // C99 6.4.2: Identifiers.
  public static final char identifier = comment + 1;
  // abcde123
  public static final char raw_identifier = identifier + 1;
  // Used only in raw lexing mode.
  
  // C99 6.4.4.1: Integer Constants
  // C99 6.4.4.2: Floating Constants
  public static final char numeric_constant = raw_identifier + 1;
  // 0x123
  
  // C99 6.4.4: Character Constants
  public static final char char_constant = numeric_constant + 1;
  // 'a'
  public static final char wide_char_constant = char_constant + 1;
  // L'b'
  
  // C++1z Character Constants
  public static final char utf8_char_constant = wide_char_constant + 1;
  // u8'a'
  
  // C++11 Character Constants
  public static final char utf16_char_constant = utf8_char_constant + 1;
  // u'a'
  public static final char utf32_char_constant = utf16_char_constant + 1;
  // U'a'
  
  // C99 6.4.5: String Literals.
  public static final char string_literal = utf32_char_constant + 1;
  // "foo"
  public static final char wide_string_literal = string_literal + 1;
  // L"foo"
  public static final char angle_string_literal = wide_string_literal + 1;
  // <foo>
  
  // C++11 String Literals.
  public static final char utf8_string_literal = angle_string_literal + 1;
  // u8"foo"
  public static final char utf16_string_literal = utf8_string_literal + 1;
  // u"foo"
  public static final char utf32_string_literal = utf16_string_literal + 1;
  // U"foo"
  
  // C99 6.4.6: Punctuators.
  public static final char l_square = utf32_string_literal + 1;
  public static final char r_square = l_square + 1;
  public static final char l_paren = r_square + 1;
  public static final char r_paren = l_paren + 1;
  public static final char l_brace = r_paren + 1;
  public static final char r_brace = l_brace + 1;
  public static final char period = r_brace + 1;
  public static final char ellipsis = period + 1;
  public static final char amp = ellipsis + 1;
  public static final char ampamp = amp + 1;
  public static final char ampequal = ampamp + 1;
  public static final char star = ampequal + 1;
  public static final char starequal = star + 1;
  public static final char plus = starequal + 1;
  public static final char plusplus = plus + 1;
  public static final char plusequal = plusplus + 1;
  public static final char minus = plusequal + 1;
  public static final char arrow = minus + 1;
  public static final char minusminus = arrow + 1;
  public static final char minusequal = minusminus + 1;
  public static final char tilde = minusequal + 1;
  public static final char exclaim = tilde + 1;
  public static final char exclaimequal = exclaim + 1;
  public static final char slash = exclaimequal + 1;
  public static final char slashequal = slash + 1;
  public static final char percent = slashequal + 1;
  public static final char percentequal = percent + 1;
  public static final char less = percentequal + 1;
  public static final char lessless = less + 1;
  public static final char lessequal = lessless + 1;
  public static final char lesslessequal = lessequal + 1;
  public static final char greater = lesslessequal + 1;
  public static final char greatergreater = greater + 1;
  public static final char greaterequal = greatergreater + 1;
  public static final char greatergreaterequal = greaterequal + 1;
  public static final char caret = greatergreaterequal + 1;
  public static final char caretequal = caret + 1;
  public static final char pipe = caretequal + 1;
  public static final char pipepipe = pipe + 1;
  public static final char pipeequal = pipepipe + 1;
  public static final char question = pipeequal + 1;
  public static final char colon = question + 1;
  public static final char semi = colon + 1;
  public static final char equal = semi + 1;
  public static final char equalequal = equal + 1;
  public static final char comma = equalequal + 1;
  public static final char hash = comma + 1;
  public static final char hashhash = hash + 1;
  public static final char hashat = hashhash + 1;
  
  // C++ Support
  public static final char periodstar = hashat + 1;
  public static final char arrowstar = periodstar + 1;
  public static final char coloncolon = arrowstar + 1;
  
  // Objective C support.
  public static final char at = coloncolon + 1;
  
  // CUDA support.
  public static final char lesslessless = at + 1;
  public static final char greatergreatergreater = lesslessless + 1;
  
  // CL support
  public static final char caretcaret = greatergreatergreater + 1;
  
  // C99 6.4.1: Keywords.  These turn into kw_* tokens.
  // Flags allowed:
  //   KEYALL   - This is a keyword in all variants of C and C++, or it
  //              is a keyword in the implementation namespace that should
  //              always be treated as a keyword
  //   KEYC99   - This is a keyword introduced to C in C99
  //   KEYC11   - This is a keyword introduced to C in C11
  //   KEYCXX   - This is a C++ keyword, or a C++-specific keyword in the
  //              implementation namespace
  //   KEYNOCXX - This is a keyword in every non-C++ dialect.
  //   KEYCXX11 - This is a C++ keyword introduced to C++ in C++11
  //   KEYCONCEPTS - This is a keyword if the C++ extensions for concepts
  //                 are enabled.
  //   KEYGNU   - This is a keyword if GNU extensions are enabled
  //   KEYMS    - This is a keyword if Microsoft extensions are enabled
  //   KEYNOMS18 - This is a keyword that must never be enabled under
  //               MSVC <= v18.
  //   KEYOPENCL  - This is a keyword in OpenCL
  //   KEYNOOPENCL  - This is a keyword that is not supported in OpenCL
  //   KEYALTIVEC - This is a keyword in AltiVec
  //   KEYZVECTOR - This is a keyword for the System z vector extensions,
  //                which are heavily based on AltiVec
  //   KEYBORLAND - This is a keyword if Borland extensions are enabled
  //   KEYCOROUTINES - This is a keyword if support for the C++ coroutines
  //                   TS is enabled
  //   BOOLSUPPORT - This is a keyword if 'bool' is a built-in type
  //   HALFSUPPORT - This is a keyword if 'half' is a built-in type
  //   WCHARSUPPORT - This is a keyword if 'wchar_t' is a built-in type
  //
  public static final char kw_auto = caretcaret + 1;
  public static final char kw_break = kw_auto + 1;
  public static final char kw_case = kw_break + 1;
  public static final char kw_char = kw_case + 1;
  public static final char kw_const = kw_char + 1;
  public static final char kw_continue = kw_const + 1;
  public static final char kw_default = kw_continue + 1;
  public static final char kw_do = kw_default + 1;
  public static final char kw_double = kw_do + 1;
  public static final char kw_else = kw_double + 1;
  public static final char kw_enum = kw_else + 1;
  public static final char kw_extern = kw_enum + 1;
  public static final char kw_float = kw_extern + 1;
  public static final char kw_for = kw_float + 1;
  public static final char kw_goto = kw_for + 1;
  public static final char kw_if = kw_goto + 1;
  public static final char kw_inline = kw_if + 1;
  public static final char kw_int = kw_inline + 1;
  public static final char kw_long = kw_int + 1;
  public static final char kw_register = kw_long + 1;
  public static final char kw_restrict = kw_register + 1;
  public static final char kw_return = kw_restrict + 1;
  public static final char kw_short = kw_return + 1;
  public static final char kw_signed = kw_short + 1;
  public static final char kw_sizeof = kw_signed + 1;
  public static final char kw_static = kw_sizeof + 1;
  public static final char kw_struct = kw_static + 1;
  public static final char kw_switch = kw_struct + 1;
  public static final char kw_typedef = kw_switch + 1;
  public static final char kw_union = kw_typedef + 1;
  public static final char kw_unsigned = kw_union + 1;
  public static final char kw_void = kw_unsigned + 1;
  public static final char kw_volatile = kw_void + 1;
  public static final char kw_while = kw_volatile + 1;
  public static final char kw__Alignas = kw_while + 1;
  public static final char kw__Alignof = kw__Alignas + 1;
  public static final char kw__Atomic = kw__Alignof + 1;
  public static final char kw__Bool = kw__Atomic + 1;
  public static final char kw__Complex = kw__Bool + 1;
  public static final char kw__Generic = kw__Complex + 1;
  public static final char kw__Imaginary = kw__Generic + 1;
  public static final char kw__Noreturn = kw__Imaginary + 1;
  public static final char kw__Static_assert = kw__Noreturn + 1;
  public static final char kw__Thread_local = kw__Static_assert + 1;
  public static final char kw___func__ = kw__Thread_local + 1;
  public static final char kw___objc_yes = kw___func__ + 1;
  public static final char kw___objc_no = kw___objc_yes + 1;
  
  // C++ 2.11p1: Keywords.
  public static final char kw_asm = kw___objc_no + 1;
  public static final char kw_bool = kw_asm + 1;
  public static final char kw_catch = kw_bool + 1;
  public static final char kw_class = kw_catch + 1;
  public static final char kw_const_cast = kw_class + 1;
  public static final char kw_delete = kw_const_cast + 1;
  public static final char kw_dynamic_cast = kw_delete + 1;
  public static final char kw_explicit = kw_dynamic_cast + 1;
  public static final char kw_export = kw_explicit + 1;
  public static final char kw_false = kw_export + 1;
  public static final char kw_friend = kw_false + 1;
  public static final char kw_mutable = kw_friend + 1;
  public static final char kw_namespace = kw_mutable + 1;
  public static final char kw_new = kw_namespace + 1;
  public static final char kw_operator = kw_new + 1;
  public static final char kw_private = kw_operator + 1;
  public static final char kw_protected = kw_private + 1;
  public static final char kw_public = kw_protected + 1;
  public static final char kw_reinterpret_cast = kw_public + 1;
  public static final char kw_static_cast = kw_reinterpret_cast + 1;
  public static final char kw_template = kw_static_cast + 1;
  public static final char kw_this = kw_template + 1;
  public static final char kw_throw = kw_this + 1;
  public static final char kw_true = kw_throw + 1;
  public static final char kw_try = kw_true + 1;
  public static final char kw_typename = kw_try + 1;
  public static final char kw_typeid = kw_typename + 1;
  public static final char kw_using = kw_typeid + 1;
  public static final char kw_virtual = kw_using + 1;
  public static final char kw_wchar_t = kw_virtual + 1;
  
  // C++11 keywords
  public static final char kw_alignas = kw_wchar_t + 1;
  public static final char kw_alignof = kw_alignas + 1;
  public static final char kw_char16_t = kw_alignof + 1;
  public static final char kw_char32_t = kw_char16_t + 1;
  public static final char kw_constexpr = kw_char32_t + 1;
  public static final char kw_decltype = kw_constexpr + 1;
  public static final char kw_noexcept = kw_decltype + 1;
  public static final char kw_nullptr = kw_noexcept + 1;
  public static final char kw_static_assert = kw_nullptr + 1;
  public static final char kw_thread_local = kw_static_assert + 1;
  
  // C++ concepts TS keywords
  public static final char kw_concept = kw_thread_local + 1;
  public static final char kw_requires = kw_concept + 1;
  
  // C++ coroutines TS keywords
  public static final char kw_co_await = kw_requires + 1;
  public static final char kw_co_return = kw_co_await + 1;
  public static final char kw_co_yield = kw_co_return + 1;
  
  // GNU Extensions (in impl-reserved namespace)
  public static final char kw__Decimal32 = kw_co_yield + 1;
  public static final char kw__Decimal64 = kw__Decimal32 + 1;
  public static final char kw__Decimal128 = kw__Decimal64 + 1;
  public static final char kw___null = kw__Decimal128 + 1;
  public static final char kw___alignof = kw___null + 1;
  public static final char kw___attribute = kw___alignof + 1;
  public static final char kw___builtin_choose_expr = kw___attribute + 1;
  public static final char kw___builtin_offsetof = kw___builtin_choose_expr + 1;
  // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
  // type trait.
  public static final char kw___builtin_types_compatible_p = kw___builtin_offsetof + 1;
  public static final char kw___builtin_va_arg = kw___builtin_types_compatible_p + 1;
  public static final char kw___extension__ = kw___builtin_va_arg + 1;
  public static final char kw___float128 = kw___extension__ + 1;
  public static final char kw___imag = kw___float128 + 1;
  public static final char kw___int128 = kw___imag + 1;
  public static final char kw___label__ = kw___int128 + 1;
  public static final char kw___real = kw___label__ + 1;
  public static final char kw___thread = kw___real + 1;
  public static final char kw___FUNCTION__ = kw___thread + 1;
  public static final char kw___PRETTY_FUNCTION__ = kw___FUNCTION__ + 1;
  public static final char kw___auto_type = kw___PRETTY_FUNCTION__ + 1;
  
  // GNU Extensions (outside impl-reserved namespace)
  public static final char kw_typeof = kw___auto_type + 1;
  
  // MS Extensions
  public static final char kw___FUNCDNAME__ = kw_typeof + 1;
  public static final char kw___FUNCSIG__ = kw___FUNCDNAME__ + 1;
  public static final char kw_L__FUNCTION__ = kw___FUNCSIG__ + 1;
  public static final char kw___is_interface_class = kw_L__FUNCTION__ + 1;
  public static final char kw___is_sealed = kw___is_interface_class + 1;
  
  // MSVC12.0 / VS2013 Type Traits
  public static final char kw___is_destructible = kw___is_sealed + 1;
  public static final char kw___is_nothrow_destructible = kw___is_destructible + 1;
  public static final char kw___is_nothrow_assignable = kw___is_nothrow_destructible + 1;
  public static final char kw___is_constructible = kw___is_nothrow_assignable + 1;
  public static final char kw___is_nothrow_constructible = kw___is_constructible + 1;
  
  // MSVC14.0 / VS2015 Type Traits
  public static final char kw___is_assignable = kw___is_nothrow_constructible + 1;
  
  // GNU and MS Type Traits
  public static final char kw___has_nothrow_assign = kw___is_assignable + 1;
  public static final char kw___has_nothrow_move_assign = kw___has_nothrow_assign + 1;
  public static final char kw___has_nothrow_copy = kw___has_nothrow_move_assign + 1;
  public static final char kw___has_nothrow_constructor = kw___has_nothrow_copy + 1;
  public static final char kw___has_trivial_assign = kw___has_nothrow_constructor + 1;
  public static final char kw___has_trivial_move_assign = kw___has_trivial_assign + 1;
  public static final char kw___has_trivial_copy = kw___has_trivial_move_assign + 1;
  public static final char kw___has_trivial_constructor = kw___has_trivial_copy + 1;
  public static final char kw___has_trivial_move_constructor = kw___has_trivial_constructor + 1;
  public static final char kw___has_trivial_destructor = kw___has_trivial_move_constructor + 1;
  public static final char kw___has_virtual_destructor = kw___has_trivial_destructor + 1;
  public static final char kw___is_abstract = kw___has_virtual_destructor + 1;
  public static final char kw___is_base_of = kw___is_abstract + 1;
  public static final char kw___is_class = kw___is_base_of + 1;
  public static final char kw___is_convertible_to = kw___is_class + 1;
  public static final char kw___is_empty = kw___is_convertible_to + 1;
  public static final char kw___is_enum = kw___is_empty + 1;
  public static final char kw___is_final = kw___is_enum + 1;
  // Tentative name - there's no implementation of std::is_literal_type yet.
  public static final char kw___is_literal = kw___is_final + 1;
  public static final char kw___is_pod = kw___is_literal + 1;
  public static final char kw___is_polymorphic = kw___is_pod + 1;
  public static final char kw___is_trivial = kw___is_polymorphic + 1;
  public static final char kw___is_union = kw___is_trivial + 1;
  
  // Clang-only C++ Type Traits
  public static final char kw___is_trivially_constructible = kw___is_union + 1;
  public static final char kw___is_trivially_copyable = kw___is_trivially_constructible + 1;
  public static final char kw___is_trivially_assignable = kw___is_trivially_copyable + 1;
  public static final char kw___underlying_type = kw___is_trivially_assignable + 1;
  
  // Embarcadero Expression Traits
  public static final char kw___is_lvalue_expr = kw___underlying_type + 1;
  public static final char kw___is_rvalue_expr = kw___is_lvalue_expr + 1;
  
  // Embarcadero Unary Type Traits
  public static final char kw___is_arithmetic = kw___is_rvalue_expr + 1;
  public static final char kw___is_floating_point = kw___is_arithmetic + 1;
  public static final char kw___is_integral = kw___is_floating_point + 1;
  public static final char kw___is_complete_type = kw___is_integral + 1;
  public static final char kw___is_void = kw___is_complete_type + 1;
  public static final char kw___is_array = kw___is_void + 1;
  public static final char kw___is_function = kw___is_array + 1;
  public static final char kw___is_reference = kw___is_function + 1;
  public static final char kw___is_lvalue_reference = kw___is_reference + 1;
  public static final char kw___is_rvalue_reference = kw___is_lvalue_reference + 1;
  public static final char kw___is_fundamental = kw___is_rvalue_reference + 1;
  public static final char kw___is_object = kw___is_fundamental + 1;
  public static final char kw___is_scalar = kw___is_object + 1;
  public static final char kw___is_compound = kw___is_scalar + 1;
  public static final char kw___is_pointer = kw___is_compound + 1;
  public static final char kw___is_member_object_pointer = kw___is_pointer + 1;
  public static final char kw___is_member_function_pointer = kw___is_member_object_pointer + 1;
  public static final char kw___is_member_pointer = kw___is_member_function_pointer + 1;
  public static final char kw___is_const = kw___is_member_pointer + 1;
  public static final char kw___is_volatile = kw___is_const + 1;
  public static final char kw___is_standard_layout = kw___is_volatile + 1;
  public static final char kw___is_signed = kw___is_standard_layout + 1;
  public static final char kw___is_unsigned = kw___is_signed + 1;
  
  // Embarcadero Binary Type Traits
  public static final char kw___is_same = kw___is_unsigned + 1;
  public static final char kw___is_convertible = kw___is_same + 1;
  public static final char kw___array_rank = kw___is_convertible + 1;
  public static final char kw___array_extent = kw___array_rank + 1;
  
  // Apple Extension.
  public static final char kw___private_extern__ = kw___array_extent + 1;
  public static final char kw___module_private__ = kw___private_extern__ + 1;
  
  // Extension that will be enabled for Microsoft, Borland and PS4, but can be
  // disabled via '-fno-declspec'.
  public static final char kw___declspec = kw___module_private__ + 1;
  
  // Microsoft Extension.
  public static final char kw___cdecl = kw___declspec + 1;
  public static final char kw___stdcall = kw___cdecl + 1;
  public static final char kw___fastcall = kw___stdcall + 1;
  public static final char kw___thiscall = kw___fastcall + 1;
  public static final char kw___vectorcall = kw___thiscall + 1;
  public static final char kw___forceinline = kw___vectorcall + 1;
  public static final char kw___unaligned = kw___forceinline + 1;
  public static final char kw___super = kw___unaligned + 1;
  
  // OpenCL address space qualifiers
  public static final char kw___global = kw___super + 1;
  public static final char kw___local = kw___global + 1;
  public static final char kw___constant = kw___local + 1;
  public static final char kw___private = kw___constant + 1;
  public static final char kw___generic = kw___private + 1;
  // OpenCL function qualifiers
  public static final char kw___kernel = kw___generic + 1;
  // OpenCL access qualifiers
  public static final char kw___read_only = kw___kernel + 1;
  public static final char kw___write_only = kw___read_only + 1;
  public static final char kw___read_write = kw___write_only + 1;
  // OpenCL builtins
  public static final char kw___builtin_astype = kw___read_write + 1;
  public static final char kw_vec_step = kw___builtin_astype + 1;
  public static final char kw_image1d_t = kw_vec_step + 1;
  public static final char kw_image1d_array_t = kw_image1d_t + 1;
  public static final char kw_image1d_buffer_t = kw_image1d_array_t + 1;
  public static final char kw_image2d_t = kw_image1d_buffer_t + 1;
  public static final char kw_image2d_array_t = kw_image2d_t + 1;
  public static final char kw_image2d_depth_t = kw_image2d_array_t + 1;
  public static final char kw_image2d_array_depth_t = kw_image2d_depth_t + 1;
  public static final char kw_image2d_msaa_t = kw_image2d_array_depth_t + 1;
  public static final char kw_image2d_array_msaa_t = kw_image2d_msaa_t + 1;
  public static final char kw_image2d_msaa_depth_t = kw_image2d_array_msaa_t + 1;
  public static final char kw_image2d_array_msaa_depth_t = kw_image2d_msaa_depth_t + 1;
  public static final char kw_image3d_t = kw_image2d_array_msaa_depth_t + 1;
  
  // OpenMP Type Traits
  public static final char kw___builtin_omp_required_simd_align = kw_image3d_t + 1;
  public static final char kw_pipe = kw___builtin_omp_required_simd_align + 1;
  
  // Borland Extensions.
  public static final char kw___pascal = kw_pipe + 1;
  
  // Altivec Extension.
  public static final char kw___vector = kw___pascal + 1;
  public static final char kw___pixel = kw___vector + 1;
  public static final char kw___bool = kw___pixel + 1;
  
  // OpenCL Extension.
  public static final char kw_half = kw___bool + 1;
  
  // Objective-C ARC keywords.
  public static final char kw___bridge = kw_half + 1;
  public static final char kw___bridge_transfer = kw___bridge + 1;
  public static final char kw___bridge_retained = kw___bridge_transfer + 1;
  public static final char kw___bridge_retain = kw___bridge_retained + 1;
  
  // Objective-C keywords.
  public static final char kw___covariant = kw___bridge_retain + 1;
  public static final char kw___contravariant = kw___covariant + 1;
  public static final char kw___kindof = kw___contravariant + 1;
  
  // Type nullability.
  public static final char kw__Nonnull = kw___kindof + 1;
  public static final char kw__Nullable = kw__Nonnull + 1;
  public static final char kw__Null_unspecified = kw__Nullable + 1;
  
  // Microsoft extensions which should be disabled in strict conformance mode
  public static final char kw___ptr64 = kw__Null_unspecified + 1;
  public static final char kw___ptr32 = kw___ptr64 + 1;
  public static final char kw___sptr = kw___ptr32 + 1;
  public static final char kw___uptr = kw___sptr + 1;
  public static final char kw___w64 = kw___uptr + 1;
  public static final char kw___uuidof = kw___w64 + 1;
  public static final char kw___try = kw___uuidof + 1;
  public static final char kw___finally = kw___try + 1;
  public static final char kw___leave = kw___finally + 1;
  public static final char kw___int64 = kw___leave + 1;
  public static final char kw___if_exists = kw___int64 + 1;
  public static final char kw___if_not_exists = kw___if_exists + 1;
  public static final char kw___single_inheritance = kw___if_not_exists + 1;
  public static final char kw___multiple_inheritance = kw___single_inheritance + 1;
  public static final char kw___virtual_inheritance = kw___multiple_inheritance + 1;
  public static final char kw___interface = kw___virtual_inheritance + 1;
  
  // Clang Extensions.
  public static final char kw___builtin_convertvector = kw___interface + 1;
  public static final char kw___builtin_available = kw___builtin_convertvector + 1;
  
  // Clang-specific keywords enabled only in testing.
  public static final char kw___unknown_anytype = kw___builtin_available + 1;
  
  // TODO: What to do about context-sensitive keywords like:
  //       bycopy/byref/in/inout/oneway/out?
  public static final char annot_cxxscope = kw___unknown_anytype + 1;
  // annotation for a C++ scope spec, e.g. "::foo::bar::"
  public static final char annot_typename = annot_cxxscope + 1;
  // annotation for a C typedef name, a C++ (possibly
  // qualified) typename, e.g. "foo::MyClass", or
  // template-id that names a type ("std::vector<int>")
  public static final char annot_template_id = annot_typename + 1;
  // annotation for a C++ template-id that names a
  // function template specialization (not a type),
  // e.g., "std::swap<int>"
  public static final char annot_primary_expr = annot_template_id + 1;
  // annotation for a primary expression
  public static final char annot_decltype = annot_primary_expr + 1;
  // annotation for a decltype expression,
  // e.g., "decltype(foo.bar())"
  
  // Annotation for #pragma unused(...)
  // For each argument inside the parentheses the pragma handler will produce
  // one 'pragma_unused' annotation token followed by the argument token.
  public static final char annot_pragma_unused = annot_decltype + 1;
  
  // Annotation for #pragma GCC visibility...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_vis = annot_pragma_unused + 1;
  
  // Annotation for #pragma pack...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_pack = annot_pragma_vis + 1;
  
  // Annotation for #pragma clang __debug parser_crash...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_parser_crash = annot_pragma_pack + 1;
  
  // Annotation for #pragma clang __debug captured...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_captured = annot_pragma_parser_crash + 1;
  
  // Annotation for #pragma clang __debug dump...
  // The lexer produces these so that the parser and semantic analysis can
  // look up and dump the operand.
  public static final char annot_pragma_dump = annot_pragma_captured + 1;
  
  // Annotation for #pragma ms_struct...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_msstruct = annot_pragma_dump + 1;
  
  // Annotation for #pragma align...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_align = annot_pragma_msstruct + 1;
  
  // Annotation for #pragma weak id
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_weak = annot_pragma_align + 1;
  
  // Annotation for #pragma weak id = id
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_weakalias = annot_pragma_weak + 1;
  
  // Annotation for #pragma redefine_extname...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_redefine_extname = annot_pragma_weakalias + 1;
  
  // Annotation for #pragma STDC FP_CONTRACT...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_fp_contract = annot_pragma_redefine_extname + 1;
  
  // Annotation for #pragma pointers_to_members...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_ms_pointers_to_members = annot_pragma_fp_contract + 1;
  
  // Annotation for #pragma vtordisp...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_ms_vtordisp = annot_pragma_ms_pointers_to_members + 1;
  
  // Annotation for all microsoft #pragmas...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_ms_pragma = annot_pragma_ms_vtordisp + 1;
  
  // Annotation for #pragma OPENCL EXTENSION...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  public static final char annot_pragma_opencl_extension = annot_pragma_ms_pragma + 1;
  
  // Annotations for OpenMP pragma directives - #pragma omp ...
  // The lexer produces these so that they only take effect when the parser
  // handles #pragma omp ... directives.
  public static final char annot_pragma_openmp = annot_pragma_opencl_extension + 1;
  public static final char annot_pragma_openmp_end = annot_pragma_openmp + 1;
  
  // Annotations for loop pragma directives #pragma clang loop ...
  // The lexer produces these so that they only take effect when the parser
  // handles #pragma loop ... directives.
  public static final char annot_pragma_loop_hint = annot_pragma_openmp_end + 1;
  
  // Annotations for module import translated from #include etc.
  public static final char annot_module_include = annot_pragma_loop_hint + 1;
  public static final char annot_module_begin = annot_module_include + 1;
  public static final char annot_module_end = annot_module_begin + 1;
  public static final char NUM_TOKENS = annot_module_end + 1;
}

/// \brief Provides a namespace for preprocessor keywords which start with a
/// '#' at the beginning of the line.
//<editor-fold defaultstate="collapsed" desc="clang::tok::PPKeywordKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TokenKinds.h", line = 33,
 FQN="clang::tok::PPKeywordKind", NM="_ZN5clang3tok13PPKeywordKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok13PPKeywordKindE")
//</editor-fold>
public static final class/*enum*/ PPKeywordKind {
  
  //===----------------------------------------------------------------------===//
  // Preprocessor keywords.
  //===----------------------------------------------------------------------===//
  
  // These have meaning after a '#' at the start of a line. These define enums in
  // the tok::pp_* namespace.  Note that IdentifierInfo::getPPKeywordID must be
  // manually updated if something is added here.
  public static final char pp_not_keyword = 0;
  
  // C99 6.10.1 - Conditional Inclusion.
  public static final char pp_if = pp_not_keyword + 1;
  public static final char pp_ifdef = pp_if + 1;
  public static final char pp_ifndef = pp_ifdef + 1;
  public static final char pp_elif = pp_ifndef + 1;
  public static final char pp_else = pp_elif + 1;
  public static final char pp_endif = pp_else + 1;
  public static final char pp_defined = pp_endif + 1;
  
  // C99 6.10.2 - Source File Inclusion.
  public static final char pp_include = pp_defined + 1;
  public static final char pp___include_macros = pp_include + 1;
  
  // C99 6.10.3 - Macro Replacement.
  public static final char pp_define = pp___include_macros + 1;
  public static final char pp_undef = pp_define + 1;
  
  // C99 6.10.4 - Line Control.
  public static final char pp_line = pp_undef + 1;
  
  // C99 6.10.5 - Error Directive.
  public static final char pp_error = pp_line + 1;
  
  // C99 6.10.6 - Pragma Directive.
  public static final char pp_pragma = pp_error + 1;
  
  // GNU Extensions.
  public static final char pp_import = pp_pragma + 1;
  public static final char pp_include_next = pp_import + 1;
  public static final char pp_warning = pp_include_next + 1;
  public static final char pp_ident = pp_warning + 1;
  public static final char pp_sccs = pp_ident + 1;
  public static final char pp_assert = pp_sccs + 1;
  public static final char pp_unassert = pp_assert + 1;
  
  // Clang extensions
  public static final char pp___public_macro = pp_unassert + 1;
  public static final char pp___private_macro = pp___public_macro + 1;
  public static final char NUM_PP_KEYWORDS = pp___private_macro + 1;
}

/// \brief Provides a namespace for Objective-C keywords which start with
/// an '@'.
//<editor-fold defaultstate="collapsed" desc="clang::tok::ObjCKeywordKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TokenKinds.h", line = 41,
 FQN="clang::tok::ObjCKeywordKind", NM="_ZN5clang3tok15ObjCKeywordKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok15ObjCKeywordKindE")
//</editor-fold>
public static final class/*enum*/ ObjCKeywordKind {
  
  //===----------------------------------------------------------------------===//
  // Objective-C @-preceded keywords.
  //===----------------------------------------------------------------------===//
  
  // These have meaning after an '@' in Objective-C mode. These define enums in
  // the tok::objc_* namespace.
  public static final char objc_not_keyword = 0;
  public static final char objc_class = objc_not_keyword + 1;
  public static final char objc_compatibility_alias = objc_class + 1;
  public static final char objc_defs = objc_compatibility_alias + 1;
  public static final char objc_encode = objc_defs + 1;
  public static final char objc_end = objc_encode + 1;
  public static final char objc_implementation = objc_end + 1;
  public static final char objc_interface = objc_implementation + 1;
  public static final char objc_private = objc_interface + 1;
  public static final char objc_protected = objc_private + 1;
  public static final char objc_protocol = objc_protected + 1;
  public static final char objc_public = objc_protocol + 1;
  public static final char objc_selector = objc_public + 1;
  public static final char objc_throw = objc_selector + 1;
  public static final char objc_try = objc_throw + 1;
  public static final char objc_catch = objc_try + 1;
  public static final char objc_finally = objc_catch + 1;
  public static final char objc_synchronized = objc_finally + 1;
  public static final char objc_autoreleasepool = objc_synchronized + 1;
  public static final char objc_property = objc_autoreleasepool + 1;
  public static final char objc_package = objc_property + 1;
  public static final char objc_required = objc_package + 1;
  public static final char objc_optional = objc_required + 1;
  public static final char objc_synthesize = objc_optional + 1;
  public static final char objc_dynamic = objc_synthesize + 1;
  public static final char objc_import = objc_dynamic + 1;
  public static final char objc_available = objc_import + 1;
  public static final char NUM_OBJC_KEYWORDS = objc_available + 1;
}

/// \brief Defines the possible values of an on-off-switch (C99 6.10.6p2).
//<editor-fold defaultstate="collapsed" desc="clang::tok::OnOffSwitch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TokenKinds.h", line = 49,
 FQN="clang::tok::OnOffSwitch", NM="_ZN5clang3tok11OnOffSwitchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok11OnOffSwitchE")
//</editor-fold>
public enum OnOffSwitch implements Native.ComparableLower {
  OOS_ON(0),
  OOS_OFF(OOS_ON.getValue() + 1),
  OOS_DEFAULT(OOS_OFF.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OnOffSwitch valueOf(int val) {
    OnOffSwitch out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final OnOffSwitch[] VALUES;
    private static final OnOffSwitch[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OnOffSwitch kind : OnOffSwitch.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OnOffSwitch[min < 0 ? (1-min) : 0];
      VALUES = new OnOffSwitch[max >= 0 ? (1+max) : 0];
      for (OnOffSwitch kind : OnOffSwitch.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private OnOffSwitch(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OnOffSwitch)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OnOffSwitch)obj).value);}
  //</editor-fold>
}

/// \brief Determines the name of a token as used within the front end.
///
/// The name of a token will be an internal name (such as "l_square")
/// and should not be used as part of diagnostic messages.
//<editor-fold defaultstate="collapsed" desc="clang::tok::getTokenName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp", line = 25,
 FQN="clang::tok::getTokenName", NM="_ZN5clang3tok12getTokenNameENS0_9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok12getTokenNameENS0_9TokenKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getTokenName(/*tok.TokenKind*/char Kind)/* __attribute__((const))*/ {
  if ($ushort2int(Kind) < $ushort2int(tok.TokenKind.NUM_TOKENS)) {
    return TokNames[Kind];
  }
  throw new llvm_unreachable("unknown TokenKind");
  //return null;
}

public static String $kind2String(/*tok.TokenKind*/char Kind) {
  return Casts.toJavaString(getTokenName(Kind));
}

/// \brief Determines the spelling of simple punctuation tokens like
/// '!' or '%', and returns NULL for literal and annotation tokens.
///
/// This routine only retrieves the "simple" spelling of the token,
/// and will not produce any alternative spellings (e.g., a
/// digraph). For the actual spelling of a given Token, use
/// Preprocessor::getSpelling().
//<editor-fold defaultstate="collapsed" desc="clang::tok::getPunctuatorSpelling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp", line = 32,
 FQN="clang::tok::getPunctuatorSpelling", NM="_ZN5clang3tok21getPunctuatorSpellingENS0_9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok21getPunctuatorSpellingENS0_9TokenKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getPunctuatorSpelling(/*tok.TokenKind*/char Kind)/* __attribute__((const))*/ {
  switch (Kind) {
   case TokenKind.l_square:
    // U"foo"
    
    // C99 6.4.6: Punctuators.
    return $LSQUARE;
   case TokenKind.r_square:
    return $RSQUARE;
   case TokenKind.l_paren:
    return $LPAREN;
   case TokenKind.r_paren:
    return $RPAREN;
   case TokenKind.l_brace:
    return $LCURLY;
   case TokenKind.r_brace:
    return $RCURLY;
   case TokenKind.period:
    return $DOT;
   case TokenKind.ellipsis:
    return $ELLIPSIS;
   case TokenKind.amp:
    return $AMP;
   case TokenKind.ampamp:
    return $AMP_AMP;
   case TokenKind.ampequal:
    return $AMP_EQ;
   case TokenKind.star:
    return $STAR;
   case TokenKind.starequal:
    return $STAR_EQ;
   case TokenKind.plus:
    return $PLUS;
   case TokenKind.plusplus:
    return $PLUS_PLUS;
   case TokenKind.plusequal:
    return $PLUS_EQ;
   case TokenKind.minus:
    return $MINUS;
   case TokenKind.arrow:
    return $ARROW;
   case TokenKind.minusminus:
    return $MINUS_MINUS;
   case TokenKind.minusequal:
    return $MINUS_EQ;
   case TokenKind.tilde:
    return $TILDE;
   case TokenKind.exclaim:
    return $EXCLAIM;
   case TokenKind.exclaimequal:
    return $EXCLAIM_EQ;
   case TokenKind.slash:
    return $SLASH;
   case TokenKind.slashequal:
    return $SLASH_EQ;
   case TokenKind.percent:
    return $PERCENT;
   case TokenKind.percentequal:
    return $PERCENT_EQ;
   case TokenKind.less:
    return $LT;
   case TokenKind.lessless:
    return $LT_LT;
   case TokenKind.lessequal:
    return $LT_EQ;
   case TokenKind.lesslessequal:
    return $LT_LT_EQ;
   case TokenKind.greater:
    return $GT;
   case TokenKind.greatergreater:
    return $GT_GT;
   case TokenKind.greaterequal:
    return $GT_EQ;
   case TokenKind.greatergreaterequal:
    return $GT_GT_EQ;
   case TokenKind.caret:
    return $CARET;
   case TokenKind.caretequal:
    return $CARET_EQ;
   case TokenKind.pipe:
    return $PIPE;
   case TokenKind.pipepipe:
    return $PIPE_PIPE;
   case TokenKind.pipeequal:
    return $PIPE_EQ;
   case TokenKind.question:
    return $QMARK;
   case TokenKind.colon:
    return $COLON;
   case TokenKind.semi:
    return $SEMI;
   case TokenKind.equal:
    return $EQ;
   case TokenKind.equalequal:
    return $EQ_EQ;
   case TokenKind.comma:
    return $COMMA;
   case TokenKind.hash:
    return $HASH;
   case TokenKind.hashhash:
    return $HASH_HASH;
   case TokenKind.hashat:
    return $HASH_AT;
   case TokenKind.periodstar:
    
    // C++ Support
    return $DOT_STAR;
   case TokenKind.arrowstar:
    return $ARROW_STAR;
   case TokenKind.coloncolon:
    return $COLON_COLON;
   case TokenKind.at:
    
    // Objective C support.
    return $AT;
   case TokenKind.lesslessless:
    
    // CUDA support.
    return $LT_LT_LT;
   case TokenKind.greatergreatergreater:
    return $GT_GT_GT;
   case TokenKind.caretcaret:
    
    // CL support
    return $CARET_CARET;
   default:
    break;
  }
  return null;
}


/// \brief Determines the spelling of simple keyword and contextual keyword
/// tokens like 'int' and 'dynamic_cast'. Returns NULL for other token kinds.
//<editor-fold defaultstate="collapsed" desc="clang::tok::getKeywordSpelling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp", line = 41,
 FQN="clang::tok::getKeywordSpelling", NM="_ZN5clang3tok18getKeywordSpellingENS0_9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok18getKeywordSpellingENS0_9TokenKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getKeywordSpelling(/*tok.TokenKind*/char Kind)/* __attribute__((const))*/ {
  switch (Kind) {
   case TokenKind.kw_auto:
    
    // C99 6.4.1: Keywords.  These turn into kw_* tokens.
    // Flags allowed:
    //   KEYALL   - This is a keyword in all variants of C and C++, or it
    //              is a keyword in the implementation namespace that should
    //              always be treated as a keyword
    //   KEYC99   - This is a keyword introduced to C in C99
    //   KEYC11   - This is a keyword introduced to C in C11
    //   KEYCXX   - This is a C++ keyword, or a C++-specific keyword in the
    //              implementation namespace
    //   KEYNOCXX - This is a keyword in every non-C++ dialect.
    //   KEYCXX11 - This is a C++ keyword introduced to C++ in C++11
    //   KEYCONCEPTS - This is a keyword if the C++ extensions for concepts
    //                 are enabled.
    //   KEYGNU   - This is a keyword if GNU extensions are enabled
    //   KEYMS    - This is a keyword if Microsoft extensions are enabled
    //   KEYNOMS18 - This is a keyword that must never be enabled under
    //               MSVC <= v18.
    //   KEYOPENCL  - This is a keyword in OpenCL
    //   KEYNOOPENCL  - This is a keyword that is not supported in OpenCL
    //   KEYALTIVEC - This is a keyword in AltiVec
    //   KEYZVECTOR - This is a keyword for the System z vector extensions,
    //                which are heavily based on AltiVec
    //   KEYBORLAND - This is a keyword if Borland extensions are enabled
    //   KEYCOROUTINES - This is a keyword if support for the C++ coroutines
    //                   TS is enabled
    //   BOOLSUPPORT - This is a keyword if 'bool' is a built-in type
    //   HALFSUPPORT - This is a keyword if 'half' is a built-in type
    //   WCHARSUPPORT - This is a keyword if 'wchar_t' is a built-in type
    //
    return $auto;
   case TokenKind.kw_break:
    return $break;
   case TokenKind.kw_case:
    return $case;
   case TokenKind.kw_char:
    return $char;
   case TokenKind.kw_const:
    return $const;
   case TokenKind.kw_continue:
    return $continue;
   case TokenKind.kw_default:
    return $default;
   case TokenKind.kw_do:
    return $do;
   case TokenKind.kw_double:
    return $double;
   case TokenKind.kw_else:
    return $else;
   case TokenKind.kw_enum:
    return $enum;
   case TokenKind.kw_extern:
    return $extern;
   case TokenKind.kw_float:
    return $float;
   case TokenKind.kw_for:
    return $for;
   case TokenKind.kw_goto:
    return $goto;
   case TokenKind.kw_if:
    return $if;
   case TokenKind.kw_inline:
    return $inline;
   case TokenKind.kw_int:
    return $int;
   case TokenKind.kw_long:
    return $long;
   case TokenKind.kw_register:
    return $register;
   case TokenKind.kw_restrict:
    return $restrict;
   case TokenKind.kw_return:
    return $return;
   case TokenKind.kw_short:
    return $short;
   case TokenKind.kw_signed:
    return $signed;
   case TokenKind.kw_sizeof:
    return $sizeof;
   case TokenKind.kw_static:
    return $static;
   case TokenKind.kw_struct:
    return $struct;
   case TokenKind.kw_switch:
    return $switch;
   case TokenKind.kw_typedef:
    return $typedef;
   case TokenKind.kw_union:
    return $union;
   case TokenKind.kw_unsigned:
    return $unsigned;
   case TokenKind.kw_void:
    return $void;
   case TokenKind.kw_volatile:
    return $volatile;
   case TokenKind.kw_while:
    return $while;
   case TokenKind.kw__Alignas:
    return $_Alignas;
   case TokenKind.kw__Alignof:
    return $_Alignof;
   case TokenKind.kw__Atomic:
    return $_Atomic;
   case TokenKind.kw__Bool:
    return $_Bool;
   case TokenKind.kw__Complex:
    return $_Complex;
   case TokenKind.kw__Generic:
    return $_Generic;
   case TokenKind.kw__Imaginary:
    return $_Imaginary;
   case TokenKind.kw__Noreturn:
    return $_Noreturn;
   case TokenKind.kw__Static_assert:
    return $_Static_assert;
   case TokenKind.kw__Thread_local:
    return $_Thread_local;
   case TokenKind.kw___func__:
    return $__func__;
   case TokenKind.kw___objc_yes:
    return $__objc_yes;
   case TokenKind.kw___objc_no:
    return $__objc_no;
   case TokenKind.kw_asm:
    
    // C++ 2.11p1: Keywords.
    return $asm;
   case TokenKind.kw_bool:
    return $bool;
   case TokenKind.kw_catch:
    return $catch;
   case TokenKind.kw_class:
    return $class;
   case TokenKind.kw_const_cast:
    return $const_cast;
   case TokenKind.kw_delete:
    return $delete;
   case TokenKind.kw_dynamic_cast:
    return $dynamic_cast;
   case TokenKind.kw_explicit:
    return $explicit;
   case TokenKind.kw_export:
    return $export;
   case TokenKind.kw_false:
    return $false;
   case TokenKind.kw_friend:
    return $friend;
   case TokenKind.kw_mutable:
    return $mutable;
   case TokenKind.kw_namespace:
    return $namespace;
   case TokenKind.kw_new:
    return $new;
   case TokenKind.kw_operator:
    return $operator;
   case TokenKind.kw_private:
    return $private;
   case TokenKind.kw_protected:
    return $protected;
   case TokenKind.kw_public:
    return $public;
   case TokenKind.kw_reinterpret_cast:
    return $reinterpret_cast;
   case TokenKind.kw_static_cast:
    return $static_cast;
   case TokenKind.kw_template:
    return $template;
   case TokenKind.kw_this:
    return $this;
   case TokenKind.kw_throw:
    return $throw;
   case TokenKind.kw_true:
    return $true;
   case TokenKind.kw_try:
    return $try;
   case TokenKind.kw_typename:
    return $typename;
   case TokenKind.kw_typeid:
    return $typeid;
   case TokenKind.kw_using:
    return $using;
   case TokenKind.kw_virtual:
    return $virtual;
   case TokenKind.kw_wchar_t:
    return $wchar_t;
   case TokenKind.kw_alignas:
    
    // C++11 keywords
    return $alignas;
   case TokenKind.kw_alignof:
    return $alignof;
   case TokenKind.kw_char16_t:
    return $char16_t;
   case TokenKind.kw_char32_t:
    return $char32_t;
   case TokenKind.kw_constexpr:
    return $constexpr;
   case TokenKind.kw_decltype:
    return $decltype;
   case TokenKind.kw_noexcept:
    return $noexcept;
   case TokenKind.kw_nullptr:
    return $nullptr;
   case TokenKind.kw_static_assert:
    return $static_assert;
   case TokenKind.kw_thread_local:
    return $thread_local;
   case TokenKind.kw_concept:
    
    // C++ concepts TS keywords
    return $concept;
   case TokenKind.kw_requires:
    return $requires;
   case TokenKind.kw_co_await:
    
    // C++ coroutines TS keywords
    return $co_await;
   case TokenKind.kw_co_return:
    return $co_return;
   case TokenKind.kw_co_yield:
    return $co_yield;
   case TokenKind.kw__Decimal32:
    
    // GNU Extensions (in impl-reserved namespace)
    return $_Decimal32;
   case TokenKind.kw__Decimal64:
    return $_Decimal64;
   case TokenKind.kw__Decimal128:
    return $_Decimal128;
   case TokenKind.kw___null:
    return $__null;
   case TokenKind.kw___alignof:
    return $__alignof;
   case TokenKind.kw___attribute:
    return $__attribute;
   case TokenKind.kw___builtin_choose_expr:
    return $__builtin_choose_expr;
   case TokenKind.kw___builtin_offsetof:
    return $__builtin_offsetof;
   case TokenKind.kw___builtin_types_compatible_p:
    // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
    // type trait.
    return $__builtin_types_compatible_p;
   case TokenKind.kw___builtin_va_arg:
    return $__builtin_va_arg;
   case TokenKind.kw___extension__:
    return $__extension__;
   case TokenKind.kw___float128:
    return $__float128;
   case TokenKind.kw___imag:
    return $__imag;
   case TokenKind.kw___int128:
    return $__int128;
   case TokenKind.kw___label__:
    return $__label__;
   case TokenKind.kw___real:
    return $__real;
   case TokenKind.kw___thread:
    return $__thread;
   case TokenKind.kw___FUNCTION__:
    return $__FUNCTION__;
   case TokenKind.kw___PRETTY_FUNCTION__:
    return $__PRETTY_FUNCTION__;
   case TokenKind.kw___auto_type:
    return $__auto_type;
   case TokenKind.kw_typeof:
    
    // GNU Extensions (outside impl-reserved namespace)
    return $typeof;
   case TokenKind.kw___FUNCDNAME__:
    
    // MS Extensions
    return $__FUNCDNAME__;
   case TokenKind.kw___FUNCSIG__:
    return $__FUNCSIG__;
   case TokenKind.kw_L__FUNCTION__:
    return $L__FUNCTION__;
   case TokenKind.kw___is_interface_class:
    return $__is_interface_class;
   case TokenKind.kw___is_sealed:
    return $__is_sealed;
   case TokenKind.kw___is_destructible:
    
    // MSVC12.0 / VS2013 Type Traits
    return $__is_destructible;
   case TokenKind.kw___is_nothrow_destructible:
    return $__is_nothrow_destructible;
   case TokenKind.kw___is_nothrow_assignable:
    return $__is_nothrow_assignable;
   case TokenKind.kw___is_constructible:
    return $__is_constructible;
   case TokenKind.kw___is_nothrow_constructible:
    return $__is_nothrow_constructible;
   case TokenKind.kw___is_assignable:
    
    // MSVC14.0 / VS2015 Type Traits
    return $__is_assignable;
   case TokenKind.kw___has_nothrow_assign:
    
    // GNU and MS Type Traits
    return $__has_nothrow_assign;
   case TokenKind.kw___has_nothrow_move_assign:
    return $__has_nothrow_move_assign;
   case TokenKind.kw___has_nothrow_copy:
    return $__has_nothrow_copy;
   case TokenKind.kw___has_nothrow_constructor:
    return $__has_nothrow_constructor;
   case TokenKind.kw___has_trivial_assign:
    return $__has_trivial_assign;
   case TokenKind.kw___has_trivial_move_assign:
    return $__has_trivial_move_assign;
   case TokenKind.kw___has_trivial_copy:
    return $__has_trivial_copy;
   case TokenKind.kw___has_trivial_constructor:
    return $__has_trivial_constructor;
   case TokenKind.kw___has_trivial_move_constructor:
    return $__has_trivial_move_constructor;
   case TokenKind.kw___has_trivial_destructor:
    return $__has_trivial_destructor;
   case TokenKind.kw___has_virtual_destructor:
    return $__has_virtual_destructor;
   case TokenKind.kw___is_abstract:
    return $__is_abstract;
   case TokenKind.kw___is_base_of:
    return $__is_base_of;
   case TokenKind.kw___is_class:
    return $__is_class;
   case TokenKind.kw___is_convertible_to:
    return $__is_convertible_to;
   case TokenKind.kw___is_empty:
    return $__is_empty;
   case TokenKind.kw___is_enum:
    return $__is_enum;
   case TokenKind.kw___is_final:
    return $__is_final;
   case TokenKind.kw___is_literal:
    // Tentative name - there's no implementation of std::is_literal_type yet.
    return $__is_literal;
   case TokenKind.kw___is_pod:
    return $__is_pod;
   case TokenKind.kw___is_polymorphic:
    return $__is_polymorphic;
   case TokenKind.kw___is_trivial:
    return $__is_trivial;
   case TokenKind.kw___is_union:
    return $__is_union;
   case TokenKind.kw___is_trivially_constructible:
    
    // Clang-only C++ Type Traits
    return $__is_trivially_constructible;
   case TokenKind.kw___is_trivially_copyable:
    return $__is_trivially_copyable;
   case TokenKind.kw___is_trivially_assignable:
    return $__is_trivially_assignable;
   case TokenKind.kw___underlying_type:
    return $__underlying_type;
   case TokenKind.kw___is_lvalue_expr:
    
    // Embarcadero Expression Traits
    return $__is_lvalue_expr;
   case TokenKind.kw___is_rvalue_expr:
    return $__is_rvalue_expr;
   case TokenKind.kw___is_arithmetic:
    
    // Embarcadero Unary Type Traits
    return $__is_arithmetic;
   case TokenKind.kw___is_floating_point:
    return $__is_floating_point;
   case TokenKind.kw___is_integral:
    return $__is_integral;
   case TokenKind.kw___is_complete_type:
    return $__is_complete_type;
   case TokenKind.kw___is_void:
    return $__is_void;
   case TokenKind.kw___is_array:
    return $__is_array;
   case TokenKind.kw___is_function:
    return $__is_function;
   case TokenKind.kw___is_reference:
    return $__is_reference;
   case TokenKind.kw___is_lvalue_reference:
    return $__is_lvalue_reference;
   case TokenKind.kw___is_rvalue_reference:
    return $__is_rvalue_reference;
   case TokenKind.kw___is_fundamental:
    return $__is_fundamental;
   case TokenKind.kw___is_object:
    return $__is_object;
   case TokenKind.kw___is_scalar:
    return $__is_scalar;
   case TokenKind.kw___is_compound:
    return $__is_compound;
   case TokenKind.kw___is_pointer:
    return $__is_pointer;
   case TokenKind.kw___is_member_object_pointer:
    return $__is_member_object_pointer;
   case TokenKind.kw___is_member_function_pointer:
    return $__is_member_function_pointer;
   case TokenKind.kw___is_member_pointer:
    return $__is_member_pointer;
   case TokenKind.kw___is_const:
    return $__is_const;
   case TokenKind.kw___is_volatile:
    return $__is_volatile;
   case TokenKind.kw___is_standard_layout:
    return $__is_standard_layout;
   case TokenKind.kw___is_signed:
    return $__is_signed;
   case TokenKind.kw___is_unsigned:
    return $__is_unsigned;
   case TokenKind.kw___is_same:
    
    // Embarcadero Binary Type Traits
    return $__is_same;
   case TokenKind.kw___is_convertible:
    return $__is_convertible;
   case TokenKind.kw___array_rank:
    return $__array_rank;
   case TokenKind.kw___array_extent:
    return $__array_extent;
   case TokenKind.kw___private_extern__:
    
    // Apple Extension.
    return $__private_extern__;
   case TokenKind.kw___module_private__:
    return $__module_private__;
   case TokenKind.kw___declspec:
    
    // Extension that will be enabled for Microsoft, Borland and PS4, but can be
    // disabled via '-fno-declspec'.
    return $__declspec;
   case TokenKind.kw___cdecl:
    
    // Microsoft Extension.
    return $__cdecl;
   case TokenKind.kw___stdcall:
    return $__stdcall;
   case TokenKind.kw___fastcall:
    return $__fastcall;
   case TokenKind.kw___thiscall:
    return $__thiscall;
   case TokenKind.kw___vectorcall:
    return $__vectorcall;
   case TokenKind.kw___forceinline:
    return $__forceinline;
   case TokenKind.kw___unaligned:
    return $__unaligned;
   case TokenKind.kw___super:
    return $__super;
   case TokenKind.kw___global:
    
    // OpenCL address space qualifiers
    return $__global;
   case TokenKind.kw___local:
    return $__local;
   case TokenKind.kw___constant:
    return $__constant;
   case TokenKind.kw___private:
    return $__private;
   case TokenKind.kw___generic:
    return $__generic;
   case TokenKind.kw___kernel:
    // OpenCL function qualifiers
    return $__kernel;
   case TokenKind.kw___read_only:
    // OpenCL access qualifiers
    return $__read_only;
   case TokenKind.kw___write_only:
    return $__write_only;
   case TokenKind.kw___read_write:
    return $__read_write;
   case TokenKind.kw___builtin_astype:
    // OpenCL builtins
    return $__builtin_astype;
   case TokenKind.kw_vec_step:
    return $vec_step;
   case TokenKind.kw_image1d_t:
    return $image1d_t;
   case TokenKind.kw_image1d_array_t:
    return $image1d_array_t;
   case TokenKind.kw_image1d_buffer_t:
    return $image1d_buffer_t;
   case TokenKind.kw_image2d_t:
    return $image2d_t;
   case TokenKind.kw_image2d_array_t:
    return $image2d_array_t;
   case TokenKind.kw_image2d_depth_t:
    return $image2d_depth_t;
   case TokenKind.kw_image2d_array_depth_t:
    return $image2d_array_depth_t;
   case TokenKind.kw_image2d_msaa_t:
    return $image2d_msaa_t;
   case TokenKind.kw_image2d_array_msaa_t:
    return image2d_array_msaa_t;
   case TokenKind.kw_image2d_msaa_depth_t:
    return $image2d_msaa_depth_t;
   case TokenKind.kw_image2d_array_msaa_depth_t:
    return $image2d_array_msaa_depth_t;
   case TokenKind.kw_image3d_t:
    return $image3d_t;
   case TokenKind.kw___builtin_omp_required_simd_align:
    
    // OpenMP Type Traits
    return $__builtin_omp_required_simd_align;
   case TokenKind.kw_pipe:
    return $pipe;
   case TokenKind.kw___pascal:
    
    // Borland Extensions.
    return $__pascal;
   case TokenKind.kw___vector:
    
    // Altivec Extension.
    return $__vector;
   case TokenKind.kw___pixel:
    return $__pixel;
   case TokenKind.kw___bool:
    return $__bool;
   case TokenKind.kw_half:
    
    // OpenCL Extension.
    return $half;
   case TokenKind.kw___bridge:
    
    // Objective-C ARC keywords.
    return $__bridge;
   case TokenKind.kw___bridge_transfer:
    return $__bridge_transfer;
   case TokenKind.kw___bridge_retained:
    return $__bridge_retained;
   case TokenKind.kw___bridge_retain:
    return $__bridge_retain;
   case TokenKind.kw___covariant:
    
    // Objective-C keywords.
    return $__covariant;
   case TokenKind.kw___contravariant:
    return $__contravariant;
   case TokenKind.kw___kindof:
    return $__kindof;
   case TokenKind.kw__Nonnull:
    
    // Type nullability.
    return $_Nonnull;
   case TokenKind.kw__Nullable:
    return $_Nullable;
   case TokenKind.kw__Null_unspecified:
    return $_Null_unspecified;
   case TokenKind.kw___ptr64:
    
    // Microsoft extensions which should be disabled in strict conformance mode
    return $__ptr64;
   case TokenKind.kw___ptr32:
    return $__ptr32;
   case TokenKind.kw___sptr:
    return $__sptr;
   case TokenKind.kw___uptr:
    return $__uptr;
   case TokenKind.kw___w64:
    return $__w64;
   case TokenKind.kw___uuidof:
    return $__uuidof;
   case TokenKind.kw___try:
    return $__try;
   case TokenKind.kw___finally:
    return $__finally;
   case TokenKind.kw___leave:
    return $__leave;
   case TokenKind.kw___int64:
    return $__int64;
   case TokenKind.kw___if_exists:
    return $__if_exists;
   case TokenKind.kw___if_not_exists:
    return $__if_not_exists;
   case TokenKind.kw___single_inheritance:
    return $__single_inheritance;
   case TokenKind.kw___multiple_inheritance:
    return $__multiple_inheritance;
   case TokenKind.kw___virtual_inheritance:
    return $__virtual_inheritance;
   case TokenKind.kw___interface:
    return $__interface;
   case TokenKind.kw___builtin_convertvector:
    
    // Clang Extensions.
    return $__builtin_convertvector;
   case TokenKind.kw___builtin_available:
    return $__builtin_available;
   case TokenKind.kw___unknown_anytype:
    
    // Clang-specific keywords enabled only in testing.
    return $__unknown_anytype;
   default:
    break;
  }
  return null;
}


/// \brief Return true if this is a raw identifier or an identifier kind.
//<editor-fold defaultstate="collapsed" desc="clang::tok::isAnyIdentifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TokenKinds.h", line = 73,
 FQN="clang::tok::isAnyIdentifier", NM="_ZN5clang3tok15isAnyIdentifierENS0_9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok15isAnyIdentifierENS0_9TokenKindE")
//</editor-fold>
public static /*inline*/ boolean isAnyIdentifier(/*tok.TokenKind*/char K) {
  return (K == tok.TokenKind.identifier) || (K == tok.TokenKind.raw_identifier);
}


/// \brief Return true if this is a C or C++ string-literal (or
/// C++11 user-defined-string-literal) token.
//<editor-fold defaultstate="collapsed" desc="clang::tok::isStringLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TokenKinds.h", line = 79,
 FQN="clang::tok::isStringLiteral", NM="_ZN5clang3tok15isStringLiteralENS0_9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok15isStringLiteralENS0_9TokenKindE")
//</editor-fold>
public static /*inline*/ boolean isStringLiteral(/*tok.TokenKind*/char K) {
  return K == tok.TokenKind.string_literal      // "foo"
     || K == tok.TokenKind.wide_string_literal  // L"foo"
     || K == tok.TokenKind.utf8_string_literal  // u8"foo"
     || K == tok.TokenKind.utf16_string_literal // u"foo"
     || K == tok.TokenKind.utf32_string_literal;// U"foo"
}

//<editor-fold defaultstate="collapsed" desc="clang::tok::isAnnotation">
@Converted(kind = Converted.Kind.MANUAL_ADDED, optimized = Converted.Optimization.COMPLEX)
//</editor-fold>
public static boolean isCharLiteral(/*TokenKind*/char K) {
  return (K == tok.TokenKind.char_constant) // 'x'
           || (K == tok.TokenKind.wide_char_constant) // L'x'.
           || (K == tok.TokenKind.utf8_char_constant) // u8'x'.
           || (K == tok.TokenKind.utf16_char_constant) // u'x'.
           || (K == tok.TokenKind.utf32_char_constant); // U'x'.
}

private static final char literal_first_kind = tok.TokenKind.numeric_constant;
private static final char literal_last_kind = tok.TokenKind.utf32_string_literal;

/// \brief Return true if this is a "literal" kind, like a numeric
/// constant, string, etc.
//<editor-fold defaultstate="collapsed" desc="clang::tok::isLiteral">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.COMPLEX,       
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TokenKinds.h", line = 87,
 FQN="clang::tok::isLiteral", NM="_ZN5clang3tok9isLiteralENS0_9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok9isLiteralENS0_9TokenKindE")
//</editor-fold>
public static /*inline*/ boolean isLiteral(/*tok.TokenKind*/char K) {
  // JAVA PERF: use the fact that all literals are sequential kinds in TokenKind
  boolean out = (literal_first_kind <= K) && (K <= literal_last_kind);
  assert out == isLiteralOrigCheckImpl(K) : "different isLiteral result " + getTokenName(K) + " vs. " + out;
  return out;
}
private static /*inline*/ boolean isLiteralOrigCheckImpl(/*tok.TokenKind*/char K) {  
  return K == tok.TokenKind.numeric_constant || K == tok.TokenKind.char_constant
     || K == tok.TokenKind.wide_char_constant || K == tok.TokenKind.utf8_char_constant
     || K == tok.TokenKind.utf16_char_constant || K == tok.TokenKind.utf32_char_constant
     || isStringLiteral(K) || K == tok.TokenKind.angle_string_literal;
}

private static final char annot_first_kind = tok.TokenKind.annot_cxxscope;
private static final char annot_last_kind = tok.TokenKind.annot_module_end;

/// \brief Return true if this is any of tok::annot_* kinds.
//<editor-fold defaultstate="collapsed" desc="clang::tok::isAnnotation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.COMPLEX,       
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/TokenKinds.h", line = 95,
 FQN="clang::tok::isAnnotation", NM="_ZN5clang3tok12isAnnotationENS0_9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZN5clang3tok12isAnnotationENS0_9TokenKindE")
//</editor-fold>
public static /*inline*/ boolean isAnnotation(/*tok.TokenKind*/char K) {
  // PERF: let's use the knowledge that all annotations at the end of TokenKind set
  // and nobody asks invalid kind
  // check range
  assert annot_last_kind + 1 == tok.TokenKind.NUM_TOKENS : "used one compare because expected annotation kinds to be at the end of Kinds. Looks like have to use two compare";
  //boolean out = (annot_first_kind <= K) && (K <= annot_last_kind);
  assert K < tok.TokenKind.NUM_TOKENS;
  boolean out = (annot_first_kind <= K); 
  assert out == isAnnotationOrigCheckImpl(K) : "different isAnnotation result " + getTokenName(K) + " vs. " + out;
  return out;
}
private static /*inline*/ boolean isAnnotationOrigCheckImpl(/*tok.TokenKind*/char K) {  
  
  // TODO: What to do about context-sensitive keywords like:
  //       bycopy/byref/in/inout/oneway/out?
  if (K == tok.TokenKind.annot_cxxscope) { // annotation for a C++ scope spec, e.g. "::foo::bar::"
    return true;
  }
  if (K == tok.TokenKind.annot_typename) { // annotation for a C typedef name, a C++ (possibly
  // qualified) typename, e.g. "foo::MyClass", or
  // template-id that names a type ("std::vector<int>")
    return true;
  }
  if (K == tok.TokenKind.annot_template_id) { // annotation for a C++ template-id that names a
  // function template specialization (not a type),
  // e.g., "std::swap<int>"
    return true;
  }
  if (K == tok.TokenKind.annot_primary_expr) { // annotation for a primary expression
    return true;
  }
  if (K == tok.TokenKind.annot_decltype) { // annotation for a decltype expression,
  // e.g., "decltype(foo.bar())"
    return true;
  }
  
  // Annotation for #pragma unused(...)
  // For each argument inside the parentheses the pragma handler will produce
  // one 'pragma_unused' annotation token followed by the argument token.
  if (K == tok.TokenKind.annot_pragma_unused) {
    return true;
  }
  
  // Annotation for #pragma GCC visibility...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_vis) {
    return true;
  }
  
  // Annotation for #pragma pack...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_pack) {
    return true;
  }
  
  // Annotation for #pragma clang __debug parser_crash...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_parser_crash) {
    return true;
  }
  
  // Annotation for #pragma clang __debug captured...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_captured) {
    return true;
  }
  
  // Annotation for #pragma clang __debug dump...
  // The lexer produces these so that the parser and semantic analysis can
  // look up and dump the operand.
  if (K == tok.TokenKind.annot_pragma_dump) {
    return true;
  }
  
  // Annotation for #pragma ms_struct...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_msstruct) {
    return true;
  }
  
  // Annotation for #pragma align...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_align) {
    return true;
  }
  
  // Annotation for #pragma weak id
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_weak) {
    return true;
  }
  
  // Annotation for #pragma weak id = id
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_weakalias) {
    return true;
  }
  
  // Annotation for #pragma redefine_extname...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_redefine_extname) {
    return true;
  }
  
  // Annotation for #pragma STDC FP_CONTRACT...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_fp_contract) {
    return true;
  }
  
  // Annotation for #pragma pointers_to_members...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_ms_pointers_to_members) {
    return true;
  }
  
  // Annotation for #pragma vtordisp...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_ms_vtordisp) {
    return true;
  }
  
  // Annotation for all microsoft #pragmas...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_ms_pragma) {
    return true;
  }
  
  // Annotation for #pragma OPENCL EXTENSION...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  if (K == tok.TokenKind.annot_pragma_opencl_extension) {
    return true;
  }
  
  // Annotations for OpenMP pragma directives - #pragma omp ...
  // The lexer produces these so that they only take effect when the parser
  // handles #pragma omp ... directives.
  if (K == tok.TokenKind.annot_pragma_openmp) {
    return true;
  }
  if (K == tok.TokenKind.annot_pragma_openmp_end) {
    return true;
  }
  
  // Annotations for loop pragma directives #pragma clang loop ...
  // The lexer produces these so that they only take effect when the parser
  // handles #pragma loop ... directives.
  if (K == tok.TokenKind.annot_pragma_loop_hint) {
    return true;
  }
  
  // Annotations for module import translated from #include etc.
  if (K == tok.TokenKind.annot_module_include) {
    return true;
  }
  if (K == tok.TokenKind.annot_module_begin) {
    return true;
  }
  if (K == tok.TokenKind.annot_module_end) {
    return true;
  }
  return false;
}

} // END OF class tok
