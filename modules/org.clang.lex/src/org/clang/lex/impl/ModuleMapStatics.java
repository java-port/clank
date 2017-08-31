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

package org.clang.lex.impl;

import static org.clank.support.Native.$AddrOf;
import org.clang.basic.java.ClankAliases;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.Module.Header;
import org.clang.lex.*;
import static org.clank.support.Native.$createJavaCleaner;
import static org.clank.support.Native.$noteq_ptr;
import org.llvm.support.sys.path;


//<editor-fold defaultstate="collapsed" desc="static type ModuleMapStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL14formatModuleIdRKN4llvm11SmallVectorISt4pairISsN5clang14SourceLocationEELj2EEE;_ZL15isBuiltinHeaderN4llvm9StringRefE;_ZL16headerRoleToKindN5clang9ModuleMap16ModuleHeaderRoleE;_ZL17getTopLevelOrNullPN5clang6ModuleE;_ZL18inferFrameworkLinkPN5clang6ModuleEPKNS_14DirectoryEntryERNS_11FileManagerE;_ZL19isBetterKnownHeaderRKN5clang9ModuleMap11KnownHeaderES3_;_ZL20compareModuleHeadersPKN5clang6Module6HeaderES3_;_ZL20shouldAddRequirementPN5clang6ModuleEN4llvm9StringRefERb;_ZL22violatesPrivateIncludePN5clang6ModuleEPKNS_9FileEntryENS_9ModuleMap11KnownHeaderE;_ZL23appendSubframeworkPathsPN5clang6ModuleERN4llvm15SmallVectorImplIcEE;_ZL28sanitizeFilenameAsIdentifierN4llvm9StringRefERNS_15SmallVectorImplIcEE; -static-type=ModuleMapStatics -package=org.clang.lex.impl")
//</editor-fold>
public final class ModuleMapStatics {


/// \brief "Sanitize" a filename so that it can be used as an identifier.
//<editor-fold defaultstate="collapsed" desc="sanitizeFilenameAsIdentifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 108,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 111,
 FQN="sanitizeFilenameAsIdentifier", NM="_ZL28sanitizeFilenameAsIdentifierN4llvm9StringRefERNS_15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL28sanitizeFilenameAsIdentifierN4llvm9StringRefERNS_15SmallVectorImplIcEE")
//</editor-fold>
public static StringRef sanitizeFilenameAsIdentifier(StringRef Name, 
                            SmallString/*&*/ Buffer) {
  if (Name.empty()) {
    return new StringRef(JD$Move.INSTANCE, Name);
  }
  if (!isValidIdentifier(/*NO_COPY*/Name)) {
    // If we don't already have something with the form of an identifier,
    // create a buffer with the sanitized name.
    Buffer.clear();
    if (isDigit(Name.$at(0))) {
      Buffer.push_back($$UNDERSCORE);
    }
    Buffer.reserve(Buffer.size() + Name.size());
    for (/*uint*/int I = 0, N = Name.size(); I != N; ++I) {
      if (isIdentifierBody(Name.$at(I))) {
        Buffer.push_back(Name.$at(I));
      } else {
        Buffer.push_back($$UNDERSCORE);
      }
    }
    
    Name.$assignMove(new StringRef(Buffer.data(), Buffer.size()));
  }
  while (new StringSwitchBool(/*NO_COPY*/Name).
      
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
      Case(/*KEEP_STR*/"auto", true).
      Case(/*KEEP_STR*/"break", true).
      Case(/*KEEP_STR*/"case", true).
      Case(/*KEEP_STR*/"char", true).
      Case(/*KEEP_STR*/"const", true).
      Case(/*KEEP_STR*/"continue", true).
      Case(/*KEEP_STR*/"default", true).
      Case(/*KEEP_STR*/"do", true).
      Case(/*KEEP_STR*/"double", true).
      Case(/*KEEP_STR*/"else", true).
      Case(/*KEEP_STR*/"enum", true).
      Case(/*KEEP_STR*/"extern", true).
      Case(/*KEEP_STR*/"float", true).
      Case(/*KEEP_STR*/"for", true).
      Case(/*KEEP_STR*/"goto", true).
      Case(/*KEEP_STR*/"if", true).
      Case(/*KEEP_STR*/"inline", true).
      Case(/*KEEP_STR*/"int", true).
      Case(/*KEEP_STR*/"long", true).
      Case(/*KEEP_STR*/"register", true).
      Case(/*KEEP_STR*/"restrict", true).
      Case(/*KEEP_STR*/"return", true).
      Case(/*KEEP_STR*/"short", true).
      Case(/*KEEP_STR*/"signed", true).
      Case(/*KEEP_STR*/"sizeof", true).
      Case(/*KEEP_STR*/"static", true).
      Case(/*KEEP_STR*/"struct", true).
      Case(/*KEEP_STR*/"switch", true).
      Case(/*KEEP_STR*/"typedef", true).
      Case(/*KEEP_STR*/"union", true).
      Case(/*KEEP_STR*/"unsigned", true).
      Case(/*KEEP_STR*/"void", true).
      Case(/*KEEP_STR*/"volatile", true).
      Case(/*KEEP_STR*/"while", true).
      Case(/*KEEP_STR*/"_Alignas", true).
      Case(/*KEEP_STR*/"_Alignof", true).
      Case(/*KEEP_STR*/"_Atomic", true).
      Case(/*KEEP_STR*/"_Bool", true).
      Case(/*KEEP_STR*/"_Complex", true).
      Case(/*KEEP_STR*/"_Generic", true).
      Case(/*KEEP_STR*/"_Imaginary", true).
      Case(/*KEEP_STR*/"_Noreturn", true).
      Case(/*KEEP_STR*/"_Static_assert", true).
      Case(/*KEEP_STR*/"_Thread_local", true).
      Case(/*KEEP_STR*/"__func__", true).
      Case(/*KEEP_STR*/"__objc_yes", true).
      Case(/*KEEP_STR*/"__objc_no", true).
      
      // C++ 2.11p1: Keywords.
      Case(/*KEEP_STR*/"asm", true).
      Case(/*KEEP_STR*/"bool", true).
      Case(/*KEEP_STR*/"catch", true).
      Case(/*KEEP_STR*/"class", true).
      Case(/*KEEP_STR*/"const_cast", true).
      Case(/*KEEP_STR*/"delete", true).
      Case(/*KEEP_STR*/"dynamic_cast", true).
      Case(/*KEEP_STR*/"explicit", true).
      Case(/*KEEP_STR*/"export", true).
      Case(/*KEEP_STR*/"false", true).
      Case(/*KEEP_STR*/"friend", true).
      Case(/*KEEP_STR*/"mutable", true).
      Case(/*KEEP_STR*/"namespace", true).
      Case(/*KEEP_STR*/"new", true).
      Case(/*KEEP_STR*/"operator", true).
      Case(/*KEEP_STR*/"private", true).
      Case(/*KEEP_STR*/"protected", true).
      Case(/*KEEP_STR*/"public", true).
      Case(/*KEEP_STR*/"reinterpret_cast", true).
      Case(/*KEEP_STR*/"static_cast", true).
      Case(/*KEEP_STR*/"template", true).
      Case(/*KEEP_STR*/"this", true).
      Case(/*KEEP_STR*/"throw", true).
      Case(/*KEEP_STR*/"true", true).
      Case(/*KEEP_STR*/"try", true).
      Case(/*KEEP_STR*/"typename", true).
      Case(/*KEEP_STR*/"typeid", true).
      Case(/*KEEP_STR*/"using", true).
      Case(/*KEEP_STR*/"virtual", true).
      Case(/*KEEP_STR*/"wchar_t", true).
      
      // C++11 keywords
      Case(/*KEEP_STR*/"alignas", true).
      Case(/*KEEP_STR*/"alignof", true).
      Case(/*KEEP_STR*/"char16_t", true).
      Case(/*KEEP_STR*/"char32_t", true).
      Case(/*KEEP_STR*/"constexpr", true).
      Case(/*KEEP_STR*/"decltype", true).
      Case(/*KEEP_STR*/"noexcept", true).
      Case(/*KEEP_STR*/"nullptr", true).
      Case(/*KEEP_STR*/"static_assert", true).
      Case(/*KEEP_STR*/"thread_local", true).
      
      // C++ concepts TS keywords
      Case(/*KEEP_STR*/"concept", true).
      Case(/*KEEP_STR*/"requires", true).
      
      // C++ coroutines TS keywords
      Case(/*KEEP_STR*/"co_await", true).
      Case(/*KEEP_STR*/"co_return", true).
      Case(/*KEEP_STR*/"co_yield", true).
      
      // GNU Extensions (in impl-reserved namespace)
      Case(/*KEEP_STR*/"_Decimal32", true).
      Case(/*KEEP_STR*/"_Decimal64", true).
      Case(/*KEEP_STR*/"_Decimal128", true).
      Case(/*KEEP_STR*/"__null", true).
      Case(/*KEEP_STR*/"__alignof", true).
      Case(/*KEEP_STR*/"__attribute", true).
      Case(/*KEEP_STR*/"__builtin_choose_expr", true).
      Case(/*KEEP_STR*/"__builtin_offsetof", true).
      // __builtin_types_compatible_p is a GNU C extension that we handle like a C++
      // type trait.
      Case(/*KEEP_STR*/"__builtin_types_compatible_p", true).
      Case(/*KEEP_STR*/"__builtin_va_arg", true).
      Case(/*KEEP_STR*/"__extension__", true).
      Case(/*KEEP_STR*/"__float128", true).
      Case(/*KEEP_STR*/"__imag", true).
      Case(/*KEEP_STR*/"__int128", true).
      Case(/*KEEP_STR*/"__label__", true).
      Case(/*KEEP_STR*/"__real", true).
      Case(/*KEEP_STR*/"__thread", true).
      Case(/*KEEP_STR*/"__FUNCTION__", true).
      Case(/*KEEP_STR*/"__PRETTY_FUNCTION__", true).
      Case(/*KEEP_STR*/"__auto_type", true).
      
      // GNU Extensions (outside impl-reserved namespace)
      Case(/*KEEP_STR*/"typeof", true).
      
      // MS Extensions
      Case(/*KEEP_STR*/"__FUNCDNAME__", true).
      Case(/*KEEP_STR*/"__FUNCSIG__", true).
      Case(/*KEEP_STR*/"L__FUNCTION__", true).
      Case(/*KEEP_STR*/"__is_interface_class", true).
      Case(/*KEEP_STR*/"__is_sealed", true).
      
      // MSVC12.0 / VS2013 Type Traits
      Case(/*KEEP_STR*/"__is_destructible", true).
      Case(/*KEEP_STR*/"__is_nothrow_destructible", true).
      Case(/*KEEP_STR*/"__is_nothrow_assignable", true).
      Case(/*KEEP_STR*/"__is_constructible", true).
      Case(/*KEEP_STR*/"__is_nothrow_constructible", true).
      
      // MSVC14.0 / VS2015 Type Traits
      Case(/*KEEP_STR*/"__is_assignable", true).
      
      // GNU and MS Type Traits
      Case(/*KEEP_STR*/"__has_nothrow_assign", true).
      Case(/*KEEP_STR*/"__has_nothrow_move_assign", true).
      Case(/*KEEP_STR*/"__has_nothrow_copy", true).
      Case(/*KEEP_STR*/"__has_nothrow_constructor", true).
      Case(/*KEEP_STR*/"__has_trivial_assign", true).
      Case(/*KEEP_STR*/"__has_trivial_move_assign", true).
      Case(/*KEEP_STR*/"__has_trivial_copy", true).
      Case(/*KEEP_STR*/"__has_trivial_constructor", true).
      Case(/*KEEP_STR*/"__has_trivial_move_constructor", true).
      Case(/*KEEP_STR*/"__has_trivial_destructor", true).
      Case(/*KEEP_STR*/"__has_virtual_destructor", true).
      Case(/*KEEP_STR*/"__is_abstract", true).
      Case(/*KEEP_STR*/"__is_base_of", true).
      Case(/*KEEP_STR*/"__is_class", true).
      Case(/*KEEP_STR*/"__is_convertible_to", true).
      Case(/*KEEP_STR*/"__is_empty", true).
      Case(/*KEEP_STR*/"__is_enum", true).
      Case(/*KEEP_STR*/"__is_final", true).
      // Tentative name - there's no implementation of std::is_literal_type yet.
      Case(/*KEEP_STR*/"__is_literal", true).
      // Name for GCC 4.6 compatibility - people have already written libraries using
      // this name unfortunately.
      Case(/*KEEP_STR*/"__is_literal_type", true).
      Case(/*KEEP_STR*/"__is_pod", true).
      Case(/*KEEP_STR*/"__is_polymorphic", true).
      Case(/*KEEP_STR*/"__is_trivial", true).
      Case(/*KEEP_STR*/"__is_union", true).
      
      // Clang-only C++ Type Traits
      Case(/*KEEP_STR*/"__is_trivially_constructible", true).
      Case(/*KEEP_STR*/"__is_trivially_copyable", true).
      Case(/*KEEP_STR*/"__is_trivially_assignable", true).
      Case(/*KEEP_STR*/"__underlying_type", true).
      
      // Embarcadero Expression Traits
      Case(/*KEEP_STR*/"__is_lvalue_expr", true).
      Case(/*KEEP_STR*/"__is_rvalue_expr", true).
      
      // Embarcadero Unary Type Traits
      Case(/*KEEP_STR*/"__is_arithmetic", true).
      Case(/*KEEP_STR*/"__is_floating_point", true).
      Case(/*KEEP_STR*/"__is_integral", true).
      Case(/*KEEP_STR*/"__is_complete_type", true).
      Case(/*KEEP_STR*/"__is_void", true).
      Case(/*KEEP_STR*/"__is_array", true).
      Case(/*KEEP_STR*/"__is_function", true).
      Case(/*KEEP_STR*/"__is_reference", true).
      Case(/*KEEP_STR*/"__is_lvalue_reference", true).
      Case(/*KEEP_STR*/"__is_rvalue_reference", true).
      Case(/*KEEP_STR*/"__is_fundamental", true).
      Case(/*KEEP_STR*/"__is_object", true).
      Case(/*KEEP_STR*/"__is_scalar", true).
      Case(/*KEEP_STR*/"__is_compound", true).
      Case(/*KEEP_STR*/"__is_pointer", true).
      Case(/*KEEP_STR*/"__is_member_object_pointer", true).
      Case(/*KEEP_STR*/"__is_member_function_pointer", true).
      Case(/*KEEP_STR*/"__is_member_pointer", true).
      Case(/*KEEP_STR*/"__is_const", true).
      Case(/*KEEP_STR*/"__is_volatile", true).
      Case(/*KEEP_STR*/"__is_standard_layout", true).
      Case(/*KEEP_STR*/"__is_signed", true).
      Case(/*KEEP_STR*/"__is_unsigned", true).
      
      // Embarcadero Binary Type Traits
      Case(/*KEEP_STR*/"__is_same", true).
      Case(/*KEEP_STR*/"__is_convertible", true).
      Case(/*KEEP_STR*/"__array_rank", true).
      Case(/*KEEP_STR*/"__array_extent", true).
      
      // Apple Extension.
      Case(/*KEEP_STR*/"__private_extern__", true).
      Case(/*KEEP_STR*/"__module_private__", true).
      
      // Extension that will be enabled for Microsoft, Borland and PS4, but can be
      // disabled via '-fno-declspec'.
      Case(/*KEEP_STR*/"__declspec", true).
      
      // Microsoft Extension.
      Case(/*KEEP_STR*/"__cdecl", true).
      Case(/*KEEP_STR*/"__stdcall", true).
      Case(/*KEEP_STR*/"__fastcall", true).
      Case(/*KEEP_STR*/"__thiscall", true).
      Case(/*KEEP_STR*/"__vectorcall", true).
      Case(/*KEEP_STR*/"__forceinline", true).
      Case(/*KEEP_STR*/"__unaligned", true).
      Case(/*KEEP_STR*/"__super", true).
      
      // OpenCL address space qualifiers
      Case(/*KEEP_STR*/"__global", true).
      Case(/*KEEP_STR*/"__local", true).
      Case(/*KEEP_STR*/"__constant", true).
      Case(/*KEEP_STR*/"__private", true).
      Case(/*KEEP_STR*/"__generic", true).
      Case(/*KEEP_STR*/"global", true).
      Case(/*KEEP_STR*/"local", true).
      Case(/*KEEP_STR*/"constant", true).
      Case(/*KEEP_STR*/"private", true).
      Case(/*KEEP_STR*/"generic", true).
      // OpenCL function qualifiers
      Case(/*KEEP_STR*/"__kernel", true).
      Case(/*KEEP_STR*/"kernel", true).
      // OpenCL access qualifiers
      Case(/*KEEP_STR*/"__read_only", true).
      Case(/*KEEP_STR*/"__write_only", true).
      Case(/*KEEP_STR*/"__read_write", true).
      Case(/*KEEP_STR*/"read_only", true).
      Case(/*KEEP_STR*/"write_only", true).
      Case(/*KEEP_STR*/"read_write", true).
      // OpenCL builtins
      Case(/*KEEP_STR*/"__builtin_astype", true).
      Case(/*KEEP_STR*/"vec_step", true).Case(/*KEEP_STR*/"image1d_t", true).
      Case(/*KEEP_STR*/"image1d_array_t", true).
      Case(/*KEEP_STR*/"image1d_buffer_t", true).
      Case(/*KEEP_STR*/"image2d_t", true).
      Case(/*KEEP_STR*/"image2d_array_t", true).
      Case(/*KEEP_STR*/"image2d_depth_t", true).
      Case(/*KEEP_STR*/"image2d_array_depth_t", true).
      Case(/*KEEP_STR*/"image2d_msaa_t", true).
      Case(/*KEEP_STR*/"image2d_array_msaa_t", true).
      Case(/*KEEP_STR*/"image2d_msaa_depth_t", true).
      Case(/*KEEP_STR*/"image2d_array_msaa_depth_t", true).
      Case(/*KEEP_STR*/"image3d_t", true).
      
      // OpenMP Type Traits
      Case(/*KEEP_STR*/"__builtin_omp_required_simd_align", true).
      Case(/*KEEP_STR*/"pipe", true).
      
      // Borland Extensions.
      Case(/*KEEP_STR*/"__pascal", true).
      
      // Altivec Extension.
      Case(/*KEEP_STR*/"__vector", true).
      Case(/*KEEP_STR*/"__pixel", true).
      Case(/*KEEP_STR*/"__bool", true).
      
      // ARM NEON extensions.
      Case(/*KEEP_STR*/"__fp16", true).
      
      // OpenCL Extension.
      Case(/*KEEP_STR*/"half", true).
      
      // Objective-C ARC keywords.
      Case(/*KEEP_STR*/"__bridge", true).
      Case(/*KEEP_STR*/"__bridge_transfer", true).
      Case(/*KEEP_STR*/"__bridge_retained", true).
      Case(/*KEEP_STR*/"__bridge_retain", true).
      
      // Objective-C keywords.
      Case(/*KEEP_STR*/"__covariant", true).
      Case(/*KEEP_STR*/"__contravariant", true).
      Case(/*KEEP_STR*/"__kindof", true).
      
      // Alternate spelling for various tokens.  There are GCC extensions in all
      // languages, but should not be disabled in strict conformance mode.
      Case(/*KEEP_STR*/"__alignof__", true).
      Case(/*KEEP_STR*/"__asm", true).
      Case(/*KEEP_STR*/"__asm__", true).
      Case(/*KEEP_STR*/"__attribute__", true).
      Case(/*KEEP_STR*/"__complex", true).
      Case(/*KEEP_STR*/"__complex__", true).
      Case(/*KEEP_STR*/"__const", true).
      Case(/*KEEP_STR*/"__const__", true).
      Case(/*KEEP_STR*/"__decltype", true).
      Case(/*KEEP_STR*/"__imag__", true).
      Case(/*KEEP_STR*/"__inline", true).
      Case(/*KEEP_STR*/"__inline__", true).
      Case(/*KEEP_STR*/"__nullptr", true).
      Case(/*KEEP_STR*/"__real__", true).
      Case(/*KEEP_STR*/"__restrict", true).
      Case(/*KEEP_STR*/"__restrict__", true).
      Case(/*KEEP_STR*/"__signed", true).
      Case(/*KEEP_STR*/"__signed__", true).
      Case(/*KEEP_STR*/"__typeof", true).
      Case(/*KEEP_STR*/"__typeof__", true).
      Case(/*KEEP_STR*/"__volatile", true).
      Case(/*KEEP_STR*/"__volatile__", true).
      
      // Type nullability.
      Case(/*KEEP_STR*/"_Nonnull", true).
      Case(/*KEEP_STR*/"_Nullable", true).
      Case(/*KEEP_STR*/"_Null_unspecified", true).
      
      // Microsoft extensions which should be disabled in strict conformance mode
      Case(/*KEEP_STR*/"__ptr64", true).
      Case(/*KEEP_STR*/"__ptr32", true).
      Case(/*KEEP_STR*/"__sptr", true).
      Case(/*KEEP_STR*/"__uptr", true).
      Case(/*KEEP_STR*/"__w64", true).
      Case(/*KEEP_STR*/"__uuidof", true).
      Case(/*KEEP_STR*/"__try", true).
      Case(/*KEEP_STR*/"__finally", true).
      Case(/*KEEP_STR*/"__leave", true).
      Case(/*KEEP_STR*/"__int64", true).
      Case(/*KEEP_STR*/"__if_exists", true).
      Case(/*KEEP_STR*/"__if_not_exists", true).
      Case(/*KEEP_STR*/"__single_inheritance", true).
      Case(/*KEEP_STR*/"__multiple_inheritance", true).
      Case(/*KEEP_STR*/"__virtual_inheritance", true).
      Case(/*KEEP_STR*/"__interface", true).
      Case(/*KEEP_STR*/"__int8", true).
      Case(/*KEEP_STR*/"_int8", true).
      Case(/*KEEP_STR*/"__int16", true).
      Case(/*KEEP_STR*/"_int16", true).
      Case(/*KEEP_STR*/"__int32", true).
      Case(/*KEEP_STR*/"_int32", true).
      Case(/*KEEP_STR*/"_int64", true).
      Case(/*KEEP_STR*/"__wchar_t", true).
      Case(/*KEEP_STR*/"_asm", true).
      Case(/*KEEP_STR*/"_alignof", true).
      Case(/*KEEP_STR*/"__builtin_alignof", true).
      Case(/*KEEP_STR*/"_cdecl", true).
      Case(/*KEEP_STR*/"_fastcall", true).
      Case(/*KEEP_STR*/"_stdcall", true).
      Case(/*KEEP_STR*/"_thiscall", true).
      Case(/*KEEP_STR*/"_vectorcall", true).
      Case(/*KEEP_STR*/"_uuidof", true).
      Case(/*KEEP_STR*/"_inline", true).
      Case(/*KEEP_STR*/"_declspec", true).
      
      // Borland Extensions which should be disabled in strict conformance mode.
      Case(/*KEEP_STR*/"_pascal", true).
      
      // Clang Extensions.
      Case(/*KEEP_STR*/"__builtin_convertvector", true).
      Case(/*KEEP_STR*/"__char16_t", true).
      Case(/*KEEP_STR*/"__char32_t", true).
      Case(/*KEEP_STR*/"__builtin_available", true).
      
      // Clang-specific keywords enabled only in testing.
      Case(/*KEEP_STR*/"__unknown_anytype", true).Default(false)) {
    if ($noteq_ptr(Name.data(), Buffer.data())) {
      Buffer.append(Name.begin(), Name.size/*end*/()); // JAVA
    }
    Buffer.push_back($$UNDERSCORE);
    Name.$assignMove(new StringRef(Buffer.data(), Buffer.size()));
  }
  
  return new StringRef(JD$Move.INSTANCE, Name);
}


/// \brief Determine whether the given file name is the name of a builtin
/// header, supplied by Clang to replace, override, or augment existing system
/// headers.
//<editor-fold defaultstate="collapsed" desc="isBuiltinHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 147,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 150,
 FQN="isBuiltinHeader", NM="_ZL15isBuiltinHeaderN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL15isBuiltinHeaderN4llvm9StringRefE")
//</editor-fold>
public static boolean isBuiltinHeader(StringRef FileName) {
  return new StringSwitchBool(/*NO_COPY*/FileName).
      Case(/*KEEP_STR*/"float.h", true).
      Case(/*KEEP_STR*/"iso646.h", true).
      Case(/*KEEP_STR*/"limits.h", true).
      Case(/*KEEP_STR*/"stdalign.h", true).
      Case(/*KEEP_STR*/"stdarg.h", true).
      Case(/*KEEP_STR*/"stdatomic.h", true).
      Case(/*KEEP_STR*/"stdbool.h", true).
      Case(/*KEEP_STR*/"stddef.h", true).
      Case(/*KEEP_STR*/"stdint.h", true).
      Case(/*KEEP_STR*/"tgmath.h", true).
      Case(/*KEEP_STR*/"unwind.h", true).
      Default(false);
}

//<editor-fold defaultstate="collapsed" desc="violatesPrivateInclude">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 210,
 FQN="violatesPrivateInclude", NM="_ZL22violatesPrivateIncludePN5clang6ModuleEPKNS_9FileEntryENS_9ModuleMap11KnownHeaderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL22violatesPrivateIncludePN5clang6ModuleEPKNS_9FileEntryENS_9ModuleMap11KnownHeaderE")
//</editor-fold>
public static boolean violatesPrivateInclude(Module /*P*/ RequestingModule, 
                      /*const*/ FileEntry /*P*/ IncFileEnt, 
                      ModuleMap.KnownHeader Header) {
  if (((Header.getRole() & ModuleMap.ModuleHeaderRole.PrivateHeader) != 0)) {
    // Check for consistency between the module header role
    // as obtained from the lookup and as obtained from the module.
    // This check is not cheap, so enable it only for debugging.
    boolean IsPrivate = false;
    SmallVectorImpl<Module.Header> /*P*/ HeaderList[/*2*/] = new SmallVectorImpl /*P*/ [/*2*/] {
      $AddrOf(Header.getModule().Headers[Module.HeaderKind.HK_Private.getValue()]), 
      $AddrOf(Header.getModule().Headers[Module.HeaderKind.HK_PrivateTextual.getValue()])};
    for (SmallVectorImpl<Header> /*P*/ Hs : HeaderList)  {
      IsPrivate |= std.find_if(Hs.begin(), Hs.end(),  (H) -> 
            {
              return ((Header) H).Entry == IncFileEnt;
            }
         ).$noteq(Hs.end());
    }
    assert (IsPrivate) : "inconsistent headers and roles";
  }
  return !Header.isAccessibleFrom(RequestingModule);
}

//<editor-fold defaultstate="collapsed" desc="getTopLevelOrNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 233,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 239,
 FQN="getTopLevelOrNull", NM="_ZL17getTopLevelOrNullPN5clang6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL17getTopLevelOrNullPN5clang6ModuleE")
//</editor-fold>
public static Module /*P*/ getTopLevelOrNull(Module /*P*/ M) {
  return (M != null) ? M.getTopLevelModule() : null;
}

//<editor-fold defaultstate="collapsed" desc="isBetterKnownHeader">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 308,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 314,
 FQN="isBetterKnownHeader", NM="_ZL19isBetterKnownHeaderRKN5clang9ModuleMap11KnownHeaderES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL19isBetterKnownHeaderRKN5clang9ModuleMap11KnownHeaderES3_")
//</editor-fold>
public static boolean isBetterKnownHeader(/*const*/ ModuleMap.KnownHeader /*&*/ New, 
                   /*const*/ ModuleMap.KnownHeader /*&*/ Old) {
  // Prefer available modules.
  if (New.getModule().isAvailable() && !Old.getModule().isAvailable()) {
    return true;
  }
  
  // Prefer a public header over a private header.
  if ((New.getRole() & ModuleMap.ModuleHeaderRole.PrivateHeader)
     != (Old.getRole() & ModuleMap.ModuleHeaderRole.PrivateHeader)) {
    return !((New.getRole() & ModuleMap.ModuleHeaderRole.PrivateHeader) != 0);
  }
  
  // Prefer a non-textual header over a textual header.
  if ((New.getRole() & ModuleMap.ModuleHeaderRole.TextualHeader)
     != (Old.getRole() & ModuleMap.ModuleHeaderRole.TextualHeader)) {
    return !((New.getRole() & ModuleMap.ModuleHeaderRole.TextualHeader) != 0);
  }
  
  // Don't have a reason to choose between these. Just keep the first one.
  return false;
}


/// \brief For a framework module, infer the framework against which we
/// should link.
//<editor-fold defaultstate="collapsed" desc="inferFrameworkLink">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 563,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 575,
 FQN="inferFrameworkLink", NM="_ZL18inferFrameworkLinkPN5clang6ModuleEPKNS_14DirectoryEntryERNS_11FileManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL18inferFrameworkLinkPN5clang6ModuleEPKNS_14DirectoryEntryERNS_11FileManagerE")
//</editor-fold>
public static void inferFrameworkLink(Module /*P*/ Mod, /*const*/ DirectoryEntry /*P*/ FrameworkDir, 
                  FileManager /*&*/ FileMgr) {
  assert (Mod.IsFramework) : "Can only infer linking for framework modules";
  assert (!Mod.isSubFramework()) : "Can only infer linking for top-level frameworks";
  
  SmallString/*128*/ LibName/*J*/= new SmallString/*128*/(128);
  LibName.$addassign(/*STRINGREF_STR*/FrameworkDir.getName());
  path.append(LibName, new Twine(Mod.Name));
  
  // The library name of a framework has more than one possible extension since
  // the introduction of the text-based dynamic library format. We need to check
  // for both before we give up.
  final/*static*/ /*const*/char$ptr/*char P*/ frameworkExtensions[/*2*/] = inferFrameworkLink$$.frameworkExtensions;
  for (/*const*/char$ptr/*char P*/ extension : frameworkExtensions) {
    path.replace_extension(LibName, new Twine(extension));
    if ((FileMgr.getFile(LibName.$StringRef()) != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Mod.LinkLibraries.push_back($c$.track(new Module.LinkLibrary(Mod.Name, 
                /*IsFramework=*/ true))); $c$.clean();
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
}
private static final class inferFrameworkLink$$ {
  static final/*static*/ /*const*/char$ptr/*char P*/ frameworkExtensions[/*2*/] = (new /*const*/char$ptr/*char P*/ [/*2*/] {$EMPTY, $(".tbd")});
}

//<editor-fold defaultstate="collapsed" desc="headerRoleToKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 778,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 786,
 FQN="headerRoleToKind", NM="_ZL16headerRoleToKindN5clang9ModuleMap16ModuleHeaderRoleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL16headerRoleToKindN5clang9ModuleMap16ModuleHeaderRoleE")
//</editor-fold>
public static Module.HeaderKind headerRoleToKind(/*ModuleMap::ModuleHeaderRole*//*uint*/int Role) {
  switch ((int)Role) {
   default:
    throw new llvm_unreachable("unknown header role");
   case ModuleMap.ModuleHeaderRole.NormalHeader:
    return Module.HeaderKind.HK_Normal;
   case ModuleMap.ModuleHeaderRole.PrivateHeader:
    return Module.HeaderKind.HK_Private;
   case ModuleMap.ModuleHeaderRole.TextualHeader:
    return Module.HeaderKind.HK_Textual;
   case ModuleMap.ModuleHeaderRole.PrivateHeader | ModuleMap.ModuleHeaderRole.TextualHeader:
    return Module.HeaderKind.HK_PrivateTextual;
  }
}


/// Whether to add the requirement \p Feature to the module \p M.
///
/// This preserves backwards compatibility for two hacks in the Darwin system
/// module map files:
///
/// 1. The use of 'requires excluded' to make headers non-modular, which
///    should really be mapped to 'textual' now that we have this feature.  We
///    drop the 'excluded' requirement, and set \p IsRequiresExcludedHack to
///    true.  Later, this bit will be used to map all the headers inside this
///    module to 'textual'.
///
///    This affects Darwin.C.excluded (for assert.h) and Tcl.Private.
///
/// 2. Removes a bogus cplusplus requirement from IOKit.avc.  This requirement
///    was never correct and causes issues now that we check it, so drop it.
//<editor-fold defaultstate="collapsed" desc="shouldAddRequirement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1625,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 1623,
 FQN="shouldAddRequirement", NM="_ZL20shouldAddRequirementPN5clang6ModuleEN4llvm9StringRefERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL20shouldAddRequirementPN5clang6ModuleEN4llvm9StringRefERb")
//</editor-fold>
public static boolean shouldAddRequirement(Module /*P*/ M, StringRef Feature, 
                    bool$ref/*bool &*/ IsRequiresExcludedHack) {
  final/*static*/ /*const*/ StringRef DarwinCExcluded[/*3*/] = shouldAddRequirement$$.DarwinCExcluded;
  final/*static*/ /*const*/ StringRef TclPrivate[/*2*/] = shouldAddRequirement$$.TclPrivate;
  final/*static*/ /*const*/ StringRef IOKitAVC[/*2*/] = shouldAddRequirement$$.IOKitAVC;
  if ($eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"excluded") && (M.fullModuleNameIs(new ArrayRef<StringRef>(DarwinCExcluded))
     || M.fullModuleNameIs(new ArrayRef<StringRef>(TclPrivate)))) {
    IsRequiresExcludedHack.$set(true);
    return false;
  } else if ($eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"cplusplus") && M.fullModuleNameIs(new ArrayRef<StringRef>(IOKitAVC))) {
    return false;
  }
  
  return true;
}
private static final class shouldAddRequirement$$ {
  static final/*static*/ /*const*/ StringRef DarwinCExcluded[/*3*/] = new /*const*/ StringRef [/*3*/] {new StringRef("Darwin"), new StringRef($C), new StringRef("excluded")};
  static final/*static*/ /*const*/ StringRef TclPrivate[/*2*/] = new /*const*/ StringRef [/*2*/] {new StringRef("Tcl"), new StringRef("Private")};
  static final/*static*/ /*const*/ StringRef IOKitAVC[/*2*/] = new /*const*/ StringRef [/*2*/] {new StringRef("IOKit"), new StringRef("avc")};
}


/// \brief Append to \p Paths the set of paths needed to get to the 
/// subframework in which the given module lives.
//<editor-fold defaultstate="collapsed" desc="appendSubframeworkPaths">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1700,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 1698,
 FQN="appendSubframeworkPaths", NM="_ZL23appendSubframeworkPathsPN5clang6ModuleERN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL23appendSubframeworkPathsPN5clang6ModuleERN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static void appendSubframeworkPaths(Module /*P*/ Mod, 
        SmallString/*&*/ Path) {
  // Collect the framework names from the given module to the top-level module.
  SmallVector<StringRef> Paths/*J*/= new SmallVector<StringRef>(2, new StringRef());
  for (; (Mod != null); Mod = Mod.Parent) {
    if (Mod.IsFramework) {
      Paths.push_back(new StringRef(Mod.Name));
    }
  }
  if (Paths.empty()) {
    return;
  }

  // Add Frameworks/Name.framework for each subframework.
  for (/*uint*/int I = Paths.size() - 1; I != 0; --I)  {
    path.append(Path, new Twine(/*KEEP_STR*/"Frameworks"), $add_StringRef_char$ptr$C(Paths.$at(I - 1), /*KEEP_STR*/".framework"));
  }
}

//<editor-fold defaultstate="collapsed" desc="compareModuleHeaders">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1885,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 1883,
 FQN="compareModuleHeaders", NM="_ZL20compareModuleHeadersPKN5clang6Module6HeaderES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL20compareModuleHeadersPKN5clang6Module6HeaderES3_")
//</editor-fold>
public static int compareModuleHeaders(/*const*/ Module.Header /*P*/ A, 
                    /*const*/ Module.Header /*P*/ B) {
  return A.NameAsWritten.compare(B.NameAsWritten);
}


/// \brief Format a module-id into a string.
//<editor-fold defaultstate="collapsed" desc="formatModuleId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 2121,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 2115,
 FQN="formatModuleId", NM="_ZL14formatModuleIdRKN4llvm11SmallVectorISt4pairISsN5clang14SourceLocationEELj2EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZL14formatModuleIdRKN4llvm11SmallVectorISt4pairISsN5clang14SourceLocationEELj2EEE")
//</editor-fold>
public static std.string formatModuleId(/*const*/ClankAliases.ModuleId/*&*/ Id) {
  std.string result/*J*/= new std.string();
  {
    raw_string_ostream OS = null;
    try {
      OS/*J*/= new raw_string_ostream(result);

      for (/*uint*/int I = 0, N = Id.size(); I != N; ++I) {
        if ((I != 0)) {
        OS.$out(/*KEEP_STR*/$DOT);
        }
        OS.$out(Id.$at(I).first);
      }
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }

  return result;
}

} // END OF class ModuleMapStatics
