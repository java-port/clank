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
package org.clang.basic.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;


//<editor-fold defaultstate="collapsed" desc="static type TokenKindsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZL8TokNames; -static-type=TokenKindsStatics -package=org.clang.basic.impl")
//</editor-fold>
public final class TokenKindsStatics {

//<editor-fold defaultstate="collapsed" desc="TokNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp", line = 18,
 FQN="TokNames", NM="_ZL8TokNames",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/TokenKinds.cpp -nm=_ZL8TokNames")
//</editor-fold>
public static /*const*/char$ptr/*char P*//*const*/ TokNames[/*353*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*353*/] {
  
  //===----------------------------------------------------------------------===//
  // Language keywords.
  //===----------------------------------------------------------------------===//
  
  // These define members of the tok::* namespace.
  $unknown,  // Not a token.
  $eof,  // End of file.
  $eod,  // End of preprocessing directive (end of line inside a
  // directive).
  $code_completion,  // Code completion marker
  
  // C99 6.4.9: Comments.
  $comment,  // Comment (only in -E -C[C] mode)
  
  // C99 6.4.2: Identifiers.
  $identifier,  // abcde123
  $raw_identifier,  // Used only in raw lexing mode.
  
  // C99 6.4.4.1: Integer Constants
  // C99 6.4.4.2: Floating Constants
  $numeric_constant,  // 0x123
  
  // C99 6.4.4: Character Constants
  $char_constant,  // 'a'
  $wide_char_constant,  // L'b'
  
  // C++1z Character Constants
  $utf8_char_constant,  // u8'a'
  
  // C++11 Character Constants
  $utf16_char_constant,  // u'a'
  $utf32_char_constant,  // U'a'
  
  // C99 6.4.5: String Literals.
  $string_literal,  // "foo"
  $wide_string_literal,  // L"foo"
  $angle_string_literal,  // <foo>
  
  // C++11 String Literals.
  $utf8_string_literal,  // u8"foo"
  $utf16_string_literal,  // u"foo"
  $utf32_string_literal,  // U"foo"
  
  // C99 6.4.6: Punctuators.
  $l_square, 
  $r_square, 
  $l_paren, 
  $r_paren, 
  $l_brace, 
  $r_brace, 
  $period, 
  $ellipsis, 
  $amp, 
  $ampamp, 
  $ampequal, 
  $star, 
  $starequal, 
  $plus, 
  $plusplus, 
  $plusequal, 
  $minus, 
  $arrow, 
  $minusminus, 
  $minusequal, 
  $tilde, 
  $exclaim, 
  $exclaimequal, 
  $slash, 
  $slashequal, 
  $percent, 
  $percentequal, 
  $less, 
  $lessless, 
  $lessequal, 
  $lesslessequal, 
  $greater, 
  $greatergreater, 
  $greaterequal, 
  $greatergreaterequal, 
  $caret, 
  $caretequal, 
  $pipe, 
  $pipepipe, 
  $pipeequal, 
  $question, 
  $colon, 
  $semi, 
  $equal, 
  $equalequal, 
  $comma, 
  $hash, 
  $hashhash, 
  $hashat, 
  
  // C++ Support
  $periodstar, 
  $arrowstar, 
  $coloncolon, 
  
  // Objective C support.
  $at, 
  
  // CUDA support.
  $lesslessless, 
  $greatergreatergreater, 
  
  // CL support
  $caretcaret, 
  
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
  $auto, 
  $break, 
  $case, 
  $char, 
  $const, 
  $continue, 
  $default, 
  $do, 
  $double, 
  $else, 
  $enum, 
  $extern, 
  $float, 
  $for, 
  $goto, 
  $if, 
  $inline, 
  $int, 
  $long, 
  $register, 
  $restrict, 
  $return, 
  $short, 
  $signed, 
  $sizeof, 
  $static, 
  $struct, 
  $switch, 
  $typedef, 
  $union, 
  $unsigned, 
  $void, 
  $volatile, 
  $while, 
  $_Alignas, 
  $_Alignof, 
  $_Atomic, 
  $_Bool, 
  $_Complex, 
  $_Generic, 
  $_Imaginary, 
  $_Noreturn, 
  $_Static_assert, 
  $_Thread_local, 
  $__func__, 
  $__objc_yes, 
  $__objc_no, 
  
  // C++ 2.11p1: Keywords.
  $asm, 
  $bool, 
  $catch, 
  $class, 
  $const_cast, 
  $delete, 
  $dynamic_cast, 
  $explicit, 
  $export, 
  $false, 
  $friend, 
  $mutable, 
  $namespace, 
  $new, 
  $operator, 
  $private, 
  $protected, 
  $public, 
  $reinterpret_cast, 
  $static_cast, 
  $template, 
  $this, 
  $throw, 
  $true, 
  $try, 
  $typename, 
  $typeid, 
  $using, 
  $virtual, 
  $wchar_t, 
  
  // C++11 keywords
  $alignas, 
  $alignof, 
  $char16_t, 
  $char32_t, 
  $constexpr, 
  $decltype, 
  $noexcept, 
  $nullptr, 
  $static_assert, 
  $thread_local, 
  
  // C++ concepts TS keywords
  $concept, 
  $requires, 
  
  // C++ coroutines TS keywords
  $co_await, 
  $co_return, 
  $co_yield, 
  
  // GNU Extensions (in impl-reserved namespace)
  $_Decimal32, 
  $_Decimal64, 
  $_Decimal128, 
  $__null, 
  $__alignof, 
  $__attribute, 
  $__builtin_choose_expr, 
  $__builtin_offsetof, 
  // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
  // type trait.
  $__builtin_types_compatible_p, 
  $__builtin_va_arg, 
  $__extension__, 
  $__float128, 
  $__imag, 
  $__int128, 
  $__label__, 
  $__real, 
  $__thread, 
  $__FUNCTION__, 
  $__PRETTY_FUNCTION__, 
  $__auto_type, 
  
  // GNU Extensions (outside impl-reserved namespace)
  $typeof, 
  
  // MS Extensions
  $__FUNCDNAME__, 
  $__FUNCSIG__, 
  $L__FUNCTION__, 
  $__is_interface_class, 
  $__is_sealed, 
  
  // MSVC12.0 / VS2013 Type Traits
  $__is_destructible, 
  $__is_nothrow_destructible, 
  $__is_nothrow_assignable, 
  $__is_constructible, 
  $__is_nothrow_constructible, 
  
  // MSVC14.0 / VS2015 Type Traits
  $__is_assignable, 
  
  // GNU and MS Type Traits
  $__has_nothrow_assign, 
  $__has_nothrow_move_assign, 
  $__has_nothrow_copy, 
  $__has_nothrow_constructor, 
  $__has_trivial_assign, 
  $__has_trivial_move_assign, 
  $__has_trivial_copy, 
  $__has_trivial_constructor, 
  $__has_trivial_move_constructor, 
  $__has_trivial_destructor, 
  $__has_virtual_destructor, 
  $__is_abstract, 
  $__is_base_of, 
  $__is_class, 
  $__is_convertible_to, 
  $__is_empty, 
  $__is_enum, 
  $__is_final, 
  // Tentative name - there's no implementation of std::is_literal_type yet.
  $__is_literal, 
  $__is_pod, 
  $__is_polymorphic, 
  $__is_trivial, 
  $__is_union, 
  
  // Clang-only C++ Type Traits
  $__is_trivially_constructible, 
  $__is_trivially_copyable, 
  $__is_trivially_assignable, 
  $__underlying_type, 
  
  // Embarcadero Expression Traits
  $__is_lvalue_expr, 
  $__is_rvalue_expr, 
  
  // Embarcadero Unary Type Traits
  $__is_arithmetic, 
  $__is_floating_point, 
  $__is_integral, 
  $__is_complete_type, 
  $__is_void, 
  $__is_array, 
  $__is_function, 
  $__is_reference, 
  $__is_lvalue_reference, 
  $__is_rvalue_reference, 
  $__is_fundamental, 
  $__is_object, 
  $__is_scalar, 
  $__is_compound, 
  $__is_pointer, 
  $__is_member_object_pointer, 
  $__is_member_function_pointer, 
  $__is_member_pointer, 
  $__is_const, 
  $__is_volatile, 
  $__is_standard_layout, 
  $__is_signed, 
  $__is_unsigned, 
  
  // Embarcadero Binary Type Traits
  $__is_same, 
  $__is_convertible, 
  $__array_rank, 
  $__array_extent, 
  
  // Apple Extension.
  $__private_extern__, 
  $__module_private__, 
  
  // Extension that will be enabled for Microsoft, Borland and PS4, but can be
  // disabled via '-fno-declspec'.
  $__declspec, 
  
  // Microsoft Extension.
  $__cdecl, 
  $__stdcall, 
  $__fastcall, 
  $__thiscall, 
  $__vectorcall, 
  $__forceinline, 
  $__unaligned, 
  $__super, 
  
  // OpenCL address space qualifiers
  $__global, 
  $__local, 
  $__constant, 
  $__private, 
  $__generic, 
  // OpenCL function qualifiers
  $__kernel, 
  // OpenCL access qualifiers
  $__read_only, 
  $__write_only, 
  $__read_write, 
  // OpenCL builtins
  $__builtin_astype, 
  $vec_step, 
  $image1d_t, 
  $image1d_array_t, 
  $image1d_buffer_t, 
  $image2d_t, 
  $image2d_array_t, 
  $image2d_depth_t, 
  $image2d_array_depth_t, 
  $image2d_msaa_t, 
  image2d_array_msaa_t, 
  $image2d_msaa_depth_t, 
  $image2d_array_msaa_depth_t, 
  $image3d_t, 
  
  // OpenMP Type Traits
  $__builtin_omp_required_simd_align, 
  $pipe, 
  
  // Borland Extensions.
  $__pascal, 
  
  // Altivec Extension.
  $__vector, 
  $__pixel, 
  $__bool, 
  
  // OpenCL Extension.
  $half, 
  
  // Objective-C ARC keywords.
  $__bridge, 
  $__bridge_transfer, 
  $__bridge_retained, 
  $__bridge_retain, 
  
  // Objective-C keywords.
  $__covariant, 
  $__contravariant, 
  $__kindof, 
  
  // Type nullability.
  $_Nonnull, 
  $_Nullable, 
  $_Null_unspecified, 
  
  // Microsoft extensions which should be disabled in strict conformance mode
  $__ptr64, 
  $__ptr32, 
  $__sptr, 
  $__uptr, 
  $__w64, 
  $__uuidof, 
  $__try, 
  $__finally, 
  $__leave, 
  $__int64, 
  $__if_exists, 
  $__if_not_exists, 
  $__single_inheritance, 
  $__multiple_inheritance, 
  $__virtual_inheritance, 
  $__interface, 
  
  // Clang Extensions.
  $__builtin_convertvector, 
  $__builtin_available, 
  
  // Clang-specific keywords enabled only in testing.
  $__unknown_anytype, 
  
  // TODO: What to do about context-sensitive keywords like:
  //       bycopy/byref/in/inout/oneway/out?
  $annot_cxxscope,  // annotation for a C++ scope spec, e.g. "::foo::bar::"
  $annot_typename,  // annotation for a C typedef name, a C++ (possibly
  // qualified) typename, e.g. "foo::MyClass", or
  // template-id that names a type ("std::vector<int>")
  $annot_template_id,  // annotation for a C++ template-id that names a
  // function template specialization (not a type),
  // e.g., "std::swap<int>"
  $annot_primary_expr,  // annotation for a primary expression
  $annot_decltype,  // annotation for a decltype expression,
  // e.g., "decltype(foo.bar())"
  
  // Annotation for #pragma unused(...)
  // For each argument inside the parentheses the pragma handler will produce
  // one 'pragma_unused' annotation token followed by the argument token.
  $annot_pragma_unused, 
  
  // Annotation for #pragma GCC visibility...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_vis, 
  
  // Annotation for #pragma pack...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_pack, 
  
  // Annotation for #pragma clang __debug parser_crash...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_parser_crash, 
  
  // Annotation for #pragma clang __debug captured...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_captured, 
  
  // Annotation for #pragma clang __debug dump...
  // The lexer produces these so that the parser and semantic analysis can
  // look up and dump the operand.
  $annot_pragma_dump, 
  
  // Annotation for #pragma ms_struct...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_msstruct, 
  
  // Annotation for #pragma align...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_align, 
  
  // Annotation for #pragma weak id
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_weak, 
  
  // Annotation for #pragma weak id = id
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_weakalias, 
  
  // Annotation for #pragma redefine_extname...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_redefine_extname, 
  
  // Annotation for #pragma STDC FP_CONTRACT...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_fp_contract, 
  
  // Annotation for #pragma pointers_to_members...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_ms_pointers_to_members, 
  
  // Annotation for #pragma vtordisp...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_ms_vtordisp, 
  
  // Annotation for all microsoft #pragmas...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_ms_pragma, 
  
  // Annotation for #pragma OPENCL EXTENSION...
  // The lexer produces these so that they only take effect when the parser
  // handles them.
  $annot_pragma_opencl_extension, 
  
  // Annotations for OpenMP pragma directives - #pragma omp ...
  // The lexer produces these so that they only take effect when the parser
  // handles #pragma omp ... directives.
  $annot_pragma_openmp, 
  $annot_pragma_openmp_end, 
  
  // Annotations for loop pragma directives #pragma clang loop ...
  // The lexer produces these so that they only take effect when the parser
  // handles #pragma loop ... directives.
  $annot_pragma_loop_hint, 
  
  // Annotations for module import translated from #include etc.
  $annot_module_include, 
  $annot_module_begin, 
  $annot_module_end, 
  (/*const*/char$ptr/*char P*//*const*/)null
});
} // END OF class TokenKindsStatics
