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

package org.clank.support;

// NB: don't add org.clank.java.std, otherwise we may have a cyclic dependencies and error in class initializers
//import org.clank.java.std;
import org.clank.support.aliases.*;

/**
 *
 * @author Vladimir Voskresensky
 */
public abstract class literal_constants {
  
  public static byte $(char c) {
    assert c < 128: "used for ANSII char constants only " + c;
    return (byte)c;
  }  

  @org.netbeans.api.annotations.common.SuppressWarnings(
          value = "ES_COMPARING_PARAMETER_STRING_WITH_EQ",
          justification = "comparision with interned string for assert")
  public static char$ptr $(String str) {
    // TODO: return built-ins?
    assert str != null && (str == str.intern()) : "used for string constants only " + str;
    assert !NativeTrace.hasWideChars(str) : "used for ASCII string constants only " + str;;
    return str.length() == 0 ? $EMPTY : new char$ptr$CharSequence(str, true);
  }  
  
  public static boolean builtInConst(char$ptr $Prm0) {
    if ($Prm0 == $EMPTY_TOMBSTONE) {
      return true;
    } else if ($Prm0 == $EMPTY_KEY) {
      return true;
    }
    if (CONST_ASCII_STRINGS != null) {
      for (char$ptr b : CONST_ASCII_STRINGS) {
        if (b == $Prm0) {
          return true;
        }
      }
    }
    return false;
  }
    
  // char => byte constants to prevent conversion
  // PERF: use "compile time" constants by casting to byte
  // instead of "runtime constant" created by calling $();
  // the second case would require bytecode for reading field from this class
  // where these constants are used, while now it is compile time constant
  public static final byte $$TERM = (byte)'\0';
  public static final byte $$SOH = ((byte)0x01);
  public static final byte $$STX = ((byte)0x02);
  public static final byte $$ETX = ((byte)0x03);
  public static final byte $$EOT = ((byte)0x04);
  public static final byte $$ENQ = ((byte)0x05);
  public static final byte $$ACK = ((byte)0x06);
  public static final byte $$SO  = ((byte)0x0e);
  public static final byte $$SI  = ((byte)0x0f);
  public static final byte $$DLE = ((byte)0x10);
  public static final byte $$DC1 = ((byte)0x11);
  public static final byte $$DC2 = ((byte)0x12);
  public static final byte $$DC3 = ((byte)0x13);
  public static final byte $$DC4 = ((byte)0x14);
  public static final byte $$NAK = ((byte)0x15);
  public static final byte $$SYN = ((byte)0x16);
  public static final byte $$ETB = ((byte)0x17);
  public static final byte $$CAN = ((byte)0x18);
  public static final byte $$EM  = ((byte)0x19);
  public static final byte $$SUB = ((byte)0x1a);
  public static final byte $$ESC = ((byte)0x1b);
  public static final byte $$IS4 = ((byte)0x1c);
  public static final byte $$FS  = ((byte)0x1c);
  public static final byte $$IS3 = ((byte)0x1d);
  public static final byte $$GS  = ((byte)0x1d);
  public static final byte $$IS2 = ((byte)0x1e);
  public static final byte $$RS  = ((byte)0x1e);
  public static final byte $$IS1 = ((byte)0x1f);
  public static final byte $$US  = ((byte)0x1f);
  public static final byte $$SPACE = (byte)' ';
  public static final byte $$TAB = (byte)'\t';
  public static final byte $$LF = (byte)'\n';
  public static final byte $$CR = (byte)'\r';
  public static final byte $$FF = (byte)'\f';
  public static final byte $$BEL = (byte)7; // '\a'
  public static final byte $$BS = (byte)'\b';
  public static final byte $$VTAB = (byte)11; // '\v'
  public static final byte $$SLASH = (byte)'/';
  public static final byte $$BACK_SLASH = (byte)'\\';
  public static final byte $$QMARK = (byte)'?';
  public static final byte $$EXCLAMATION = (byte)'!';
  public static final byte $$EQ = (byte)'=';
  public static final byte $$PIPE = (byte)'|';
  public static final byte $$AT = (byte)'@';
  public static final byte $$LT = (byte)'<';
  public static final byte $$GT = (byte)'>';
  public static final byte $$PERCENT = (byte)'%';
  public static final byte $$UNDERSCORE = (byte)'_';
  public static final byte $$MINUS = (byte)'-';
  public static final byte $$PLUS = (byte)'+';
  public static final byte $$STAR = (byte)'*';
  public static final byte $$DOT = (byte)'.';
  public static final byte $$COMMA = (byte)',';
  public static final byte $$COLON = (byte)':';
  public static final byte $$SEMI = (byte)';';
  public static final byte $$AMP = (byte)'&';
  public static final byte $$LSQUARE = (byte)'[';
  public static final byte $$RSQUARE = (byte)']';
  public static final byte $$LPAREN = (byte)'(';
  public static final byte $$RPAREN = (byte)')';
  public static final byte $$LCURLY = (byte)'{';
  public static final byte $$RCURLY = (byte)'}';
  public static final byte $$DOLLAR = (byte)'$';
  public static final byte $$HASH = (byte)'#';
  public static final byte $$DBL_QUOTE = (byte)'"';
  public static final byte $$SGL_QUOTE = (byte)'\'';
  public static final byte $$TILDE = (byte)'~';
  public static final byte $$CARET = (byte)'^';
  public static final byte $$BACKQUOTE = (byte)'`';
  
  public static final byte $$0 = (byte)'0';
  public static final byte $$1 = (byte)'1';
  public static final byte $$2 = (byte)'2';
  public static final byte $$3 = (byte)'3';
  public static final byte $$4 = (byte)'4';
  public static final byte $$5 = (byte)'5';
  public static final byte $$6 = (byte)'6';
  public static final byte $$7 = (byte)'7';
  public static final byte $$8 = (byte)'8';
  public static final byte $$9 = (byte)'9';
  
  public static final byte $$a = (byte)'a';
  public static final byte $$b = (byte)'b';
  public static final byte $$c = (byte)'c';
  public static final byte $$d = (byte)'d';
  public static final byte $$e = (byte)'e';
  public static final byte $$f = (byte)'f';
  public static final byte $$g = (byte)'g';
  public static final byte $$h = (byte)'h';
  public static final byte $$i = (byte)'i';
  public static final byte $$j = (byte)'j';
  public static final byte $$k = (byte)'k';
  public static final byte $$l = (byte)'l';
  public static final byte $$m = (byte)'m';
  public static final byte $$n = (byte)'n';
  public static final byte $$o = (byte)'o';
  public static final byte $$p = (byte)'p';
  public static final byte $$q = (byte)'q';
  public static final byte $$r = (byte)'r';
  public static final byte $$s = (byte)'s';
  public static final byte $$t = (byte)'t';
  public static final byte $$u = (byte)'u';
  public static final byte $$v = (byte)'v';
  public static final byte $$w = (byte)'w';
  public static final byte $$x = (byte)'x';
  public static final byte $$y = (byte)'y';
  public static final byte $$z = (byte)'z';
  
  public static final byte $$A = (byte)'A';
  public static final byte $$B = (byte)'B';
  public static final byte $$C = (byte)'C';
  public static final byte $$D = (byte)'D';
  public static final byte $$E = (byte)'E';
  public static final byte $$F = (byte)'F';
  public static final byte $$G = (byte)'G';
  public static final byte $$H = (byte)'H';
  public static final byte $$I = (byte)'I';
  public static final byte $$J = (byte)'J';
  public static final byte $$K = (byte)'K';
  public static final byte $$L = (byte)'L';
  public static final byte $$M = (byte)'M';
  public static final byte $$N = (byte)'N';
  public static final byte $$O = (byte)'O';
  public static final byte $$P = (byte)'P';
  public static final byte $$Q = (byte)'Q';
  public static final byte $$R = (byte)'R';
  public static final byte $$S = (byte)'S';
  public static final byte $$T = (byte)'T';
  public static final byte $$U = (byte)'U';
  public static final byte $$V = (byte)'V';
  public static final byte $$W = (byte)'W';
  public static final byte $$X = (byte)'X';
  public static final byte $$Y = (byte)'Y';
  public static final byte $$Z = (byte)'Z';  
  
  public static final byte $$DEL   = (byte)0x7f;   
  public static final byte $$EURO  = (byte)0x80; 
  public static final byte $$0xBB = (byte)0xbb; 
  public static final byte $$0xBF = (byte)0xbf; 
  public static final byte $$ACIRC = (byte)0xc2; 
  public static final byte $$0xCD  = (byte)0xcd; 
  public static final byte $$0xEF    = (byte)0xef;
  public static final byte $$0xFE    = (byte)0xfe;
  public static final byte $$0xFF    = (byte)0xff;
  public static final byte $$0xC7 = (byte)0xc7;
  public static final byte $$0xA1 = (byte)0xa1;
  public static final byte $$0xBA = (byte)0xba;
  public static final byte $$0xD1 = (byte)0xd1;
  public static final byte $$0xEE = (byte)0xee;
  public static final byte $$0xA9 = (byte)0xa9;
  public static final byte $$0xAF = (byte)0xaf;
  public static final byte $$0xF6 = (byte)0xf6;
  public static final byte $$0xDC = (byte)0xdc;
  public static final byte $$0xB8 = (byte)0xb8;
  public static final byte $$0xFA = (byte)0xfa;
  public static final byte $$0xA4 = (byte)0xa4;

  private static final /*const char* */byte[] CONST_BUFFER;
  private static final /*const char* */char$ptr[] CONST_ASCII_STRINGS;
  static {
      //<editor-fold defaultstate="collapsed" desc="strings">
      String[] const_strings =
      {
          "",
          " ",
          "\t",
          "\013",
          "\n",
          "\n\n\n\n\n\n\n\n",
          "\"\n",
          "\r",
          "/",
          "/=",
          "/*",
          "\\",
          "?",
          "=",
          "==",
          "|",
          "|=",
          "||",
          "@",
          "!",
          "!=",
          "%",
          "%=",
          "_",
          "-",
          "-=",
          "--",
          "->",
          "->*",
          "+",
          "++",
          "+=",
          "*",
          "*=",
          "*/",
          ".",
          "..",
          ".*",
          ".->",
          "...",
          "&",
          "&&",
          "&=",
          "[",
          "]",
          "[]",
          "(",
          ")",
          "()",
          "{",
          "}",
          "$",
          "#",
          "##",
          "#@",
          ",",
          ", ",
          ":",
          "::",
          ":\n",
          ";",
          "'",
          "\"",
          "~",
          "^",
          "^^",
          "^=",
          "<",
          "<=",
          "<<",
          "<<=",
          "<<<",
          ">",
          ">=",
          ">>",
          ">\n",
          ">>=",
          ">>>",
          "0",
          "1",
          "2",
          "3",
          "4",
          "5",
          "6",
          "7",
          "8",
          "9",
          "a",
          "b",
          "c",
          "d",
          "dd",
          "ddd",
          "e",
          "f",
          "ff",
          "fff",
          "fn",
          "fnc",
          "fne",
          "g",
          "h",
          "hh",
          "i",
          "i.",
          "ii",
          "j",
          "k",
          "l",
          "ll",
          "m",
          "n",
          "nc",
          "nct",
          "nctu",
          "ncF",
          "nr",
          "nt",
          "nu",
          "nF",
          "o",
          "p",
          "q",
          "r",
          "s",
          "t",
          "tn",
          "u",
          "v",
          "v.",
          "w",
          "x",
          "y",
          "z",
          "A",
          "B",
          "C",
          "D",
          "E",
          "F",
          "Fn",
          "Fnc",
          "G",
          "H",
          "I",
          "J",
          "K",
          "L",
          "LL",
          "LdLd",
          "M",
          "N",
          "O",
          "P",
          "Q",
          "R",
          "S",
          "T",
          "U",
          "UL",
          "ULL",
          "V",
          "W",
          "X",
          "Y",
          "Z",
          "__VA_ARGS__",
          "import",
          "line",
          "if",
          "else",
          "elif",
          "endif",
          "ifdef",
          "ifndef",
          "define",
          "undef",
          "warning",
          "error",
          "include",
          "include_next",
          "ident",
          "__public_macro",
          "__private_macro",
          "pragma",
          "once",
          "pragma once",
          "include_alias",
          "cfe-pth",
          "unknown",
          "eof",
          "eod",
          "code_completion",
          "comment",
          "identifier",
          "raw_identifier",
          "numeric_constant",
          "char_constant",
          "wide_char_constant",
          "utf8_char_constant",
          "utf16_char_constant",
          "utf32_char_constant",
          "string_literal",
          "wide_string_literal",
          "angle_string_literal",
          "utf8_string_literal",
          "utf16_string_literal",
          "utf32_string_literal",
          "l_square",
          "r_square",
          "l_paren",
          "r_paren",
          "l_brace",
          "r_brace",
          "period",
          "ellipsis",
          "amp",
          "ampamp",
          "ampequal",
          "star",
          "starequal",
          "plus",
          "plusplus",
          "plusequal",
          "minus",
          "arrow",
          "minusminus",
          "minusequal",
          "tilde",
          "exclaim",
          "exclaimequal",
          "slash",
          "slashequal",
          "percent",
          "percentequal",
          "less",
          "lessless",
          "lessequal",
          "lesslessequal",
          "greater",
          "greatergreater",
          "greaterequal",
          "greatergreaterequal",
          "caret",
          "caretequal",
          "pipe",
          "pipepipe",
          "pipeequal",
          "question",
          "colon",
          "semi",
          "equal",
          "equalequal",
          "comma",
          "hash",
          "hashhash",
          "hashat",
          "periodstar",
          "arrowstar",
          "coloncolon",
          "at",
          "lesslessless",
          "greatergreatergreater",
          "caretcaret",
          "auto",
          "break",
          "case",
          "char",
          "const",
          "continue",
          "default",
          "do",
          "double",
          "enum",
          "extern",
          "float",
          "for",
          "goto",
          "inline",
          "int",
          "long",
          "long int",
          "long long int",
          "long long unsigned int",
          "long unsigned int",
          "register",
          "restrict",
          "return",
          "short",
          "signed",
          "signed char",
          "sizeof",
          "static",
          "struct",
          "switch",
          "typedef",
          "union",
          "unsigned",
          "unsigned char",
          "unsigned int",
          "unsigned short",
          "void",
          "volatile",
          "while",
          "_Alignas",
          "_Alignof",
          "_Atomic",
          "_Bool",
          "_Complex",
          "_Generic",
          "_Imaginary",
          "_Noreturn",
          "_Static_assert",
          "_Thread_local",
          "__func__",
          "__objc_yes",
          "__objc_no",
          "asm",
          "bool",
          "catch",
          "class",
          "const_cast",
          "delete",
          "delete[]",
          "dynamic_cast",
          "explicit",
          "export",
          "false",
          "friend",
          "mutable",
          "namespace",
          "new",
          "new[]",
          "operator",
          "protected",
          "public",
          "reinterpret_cast",
          "static_cast",
          "template",
          "this",
          "throw",
          "true",
          "try",
          "typename",
          "typeid",
          "using",
          "virtual",
          "wchar_t",
          "alignas",
          "alignof",
          "char16_t",
          "char32_t",
          "constexpr",
          "decltype",
          "noexcept",
          "nullptr",
          "static_assert",
          "thread_local",
          "concept",
          "requires",
          "co_await",
          "co_return",
          "co_yield",
          "_Decimal32",
          "_Decimal64",
          "_Decimal128",
          "__null",
          "__alignof",
          "__attribute",
          "__builtin_choose_expr",
          "__builtin_offsetof",
          "__builtin_types_compatible_p",
          "__builtin_va_arg",
          "__extension__",
          "__float128",
          "__imag",
          "__int128",
          "__label__",
          "__real",
          "__thread",
          "__FUNCTION__",
          "__PRETTY_FUNCTION__",
          "__auto_type",
          "typeof",
          "__FUNCDNAME__",
          "__FUNCSIG__",
          "L__FUNCTION__",
          "__is_interface_class",
          "__is_sealed",
          "__is_destructible",
          "__is_nothrow_destructible",
          "__is_nothrow_assignable",
          "__is_constructible",
          "__is_nothrow_constructible",
          "__is_assignable",
          "__has_nothrow_assign",
          "__has_nothrow_move_assign",
          "__has_nothrow_copy",
          "__has_nothrow_constructor",
          "__has_trivial_assign",
          "__has_trivial_move_assign",
          "__has_trivial_copy",
          "__has_trivial_constructor",
          "__has_trivial_move_constructor",
          "__has_trivial_destructor",
          "__has_virtual_destructor",
          "__is_abstract",
          "__is_base_of",
          "__is_class",
          "__is_convertible_to",
          "__is_empty",
          "__is_enum",
          "__is_final",
          "__is_literal",
          "__is_literal_type",
          "__is_pod",
          "__is_polymorphic",
          "__is_trivial",
          "__is_union",
          "__is_trivially_constructible",
          "__is_trivially_copyable",
          "__is_trivially_assignable",
          "__underlying_type",
          "__is_lvalue_expr",
          "__is_rvalue_expr",
          "__is_arithmetic",
          "__is_floating_point",
          "__is_integral",
          "__is_complete_type",
          "__is_void",
          "__is_array",
          "__is_function",
          "__is_reference",
          "__is_lvalue_reference",
          "__is_rvalue_reference",
          "__is_fundamental",
          "__is_object",
          "__is_scalar",
          "__is_compound",
          "__is_pointer",
          "__is_member_object_pointer",
          "__is_member_function_pointer",
          "__is_member_pointer",
          "__is_const",
          "__is_volatile",
          "__is_standard_layout",
          "__is_signed",
          "__is_unsigned",
          "__is_same",
          "__is_convertible",
          "__array_rank",
          "__array_extent",
          "__private_extern__",
          "__module_private__",
          "__declspec",
          "__cdecl",
          "__stdcall",
          "__fastcall",
          "__thiscall",
          "__vectorcall",
          "__forceinline",
          "__unaligned",
          "__super",
          "__global",
          "__local",
          "__constant",
          "__private",
          "__generic",
          "global",
          "local",
          "constant",
          "private",
          "generic",
          "__kernel",
          "kernel",
          "__read_only",
          "__write_only",
          "__read_write",
          "read_only",
          "write_only",
          "read_write",
          "__builtin_astype",
          "vec_step",
          "image1d_t",
          "image1d_array_t",
          "image1d_buffer_t",
          "image2d_t",
          "image2d_array_t",
          "image2d_depth_t",
          "image2d_array_depth_t",
          "image2d_msaa_t",
          "image2d_array_msaa_t",
          "image2d_msaa_depth_t",
          "image2d_array_msaa_depth_t",
          "image3d_t",
          "__builtin_omp_required_simd_align",
          "__pascal",
          "__vector",
          "__pixel",
          "__bool",
          "__fp16",
          "half",
          "__bridge",
          "__bridge_transfer",
          "__bridge_retained",
          "__bridge_retain",
          "__covariant",
          "__contravariant",
          "__kindof",
          "nonnull",
          "_Nonnull",
          "nullable",
          "_Nullable",
          "null_unspecified",
          "_Null_unspecified",
          "__alignof__",
          "__asm",
          "__asm__",
          "__attribute__",
          "__complex",
          "__complex__",
          "__const",
          "__const__",
          "__decltype",
          "__imag__",
          "__inline",
          "__inline__",
          "__nullptr",
          "__real__",
          "__restrict",
          "__restrict__",
          "__signed",
          "__signed__",
          "__typeof",
          "__typeof__",
          "__volatile",
          "__volatile__",
          "__ptr64",
          "__ptr32",
          "__sptr",
          "__uptr",
          "__w64",
          "__uuidof",
          "__try",
          "__finally",
          "__leave",
          "__int64",
          "__if_exists",
          "__if_not_exists",
          "__single_inheritance",
          "__multiple_inheritance",
          "__virtual_inheritance",
          "__interface",
          "__int8",
          "_int8",
          "__int16",
          "_int16",
          "__int32",
          "_int32",
          "_int64",
          "__wchar_t",
          "_asm",
          "_alignof",
          "__builtin_alignof",
          "_cdecl",
          "_fastcall",
          "_stdcall",
          "_thiscall",
          "_vectorcall",
          "_uuidof",
          "_inline",
          "_declspec",
          "_pascal",
          "__builtin_convertvector",
          "__builtin_available",
          "__char16_t",
          "__char32_t",
          "__unknown_anytype",
          "annot_cxxscope",
          "annot_typename",
          "annot_template_id",
          "annot_primary_expr",
          "annot_decltype",
          "annot_pragma_unused",
          "annot_pragma_vis",
          "annot_pragma_pack",
          "annot_pragma_parser_crash",
          "annot_pragma_captured",
          "annot_pragma_dump",
          "annot_pragma_msstruct",
          "annot_pragma_align",
          "annot_pragma_weak",
          "annot_pragma_weakalias",
          "annot_pragma_redefine_extname",
          "annot_pragma_fp_contract",
          "annot_pragma_ms_pointers_to_members",
          "annot_pragma_ms_vtordisp",
          "annot_pragma_ms_pragma",
          "annot_pragma_opencl_extension",
          "annot_pragma_openmp",
          "annot_pragma_openmp_end",
          "annot_pragma_loop_hint",
          "annot_module_include",
          "annot_module_begin",
          "annot_module_end",
          "UTF-16 (BE)",
          "UTF-16 (LE)",
          "UTF-32 (BE)",
          "UTF-32 (LE)",
          "UTF-7",
          "UTF-1",
          "UTF-EBCDIC",
          "SDSU",
          "BOCU-1",
          "GB-18030",
          "/tmp",
          "/var/tmp",
          "<scratch space>",
          "<invalid>",
          "<built-in>",
      };
      //</editor-fold>
      
      CONST_ASCII_STRINGS = new char$ptr[const_strings.length];
      int size = 0;
      for (String str : const_strings) {
          size += str.length();
          size ++; // \0
      }
      CONST_BUFFER = new byte[size];
      int byteIndex = 0;
      int strIndex = 0;
      for (String str : const_strings) {
          int strStart = byteIndex;
          for (int i = 0; i < str.length(); i++) {
              assert str.charAt(i) < 128 : str + " has non ascii symbol at [" + i + "]=" + str.charAt(i); 
              CONST_BUFFER[byteIndex++] = $(str.charAt(i));
          }
          CONST_BUFFER[byteIndex++] = 0;
          CONST_ASCII_STRINGS[strIndex++] = create_const_char_const$ptr(CONST_BUFFER, strStart);
      }
      if (NativeTrace.isDebugMode()) {
          for (int i = 0; i < const_strings.length; i++) {
              String str = const_strings[i];
              assert memcmp_impl(CONST_ASCII_STRINGS[i], str, str.length()) == 0 : str + " vs. " + CONST_ASCII_STRINGS[i];
          }
          NativeTrace.registerArrayWithImmutableContent(CONST_ASCII_STRINGS, "CONST_ASCII_STRINGS");
          NativeTrace.registerArrayWithImmutableContent(CONST_BUFFER, "CONST_BUFFER");
      }
  }
  
  // used i.e. for DenseMapInfo to distinguish from EMPTY key
  // should be initialized after above static block
  public static final char$ptr $EMPTY_TOMBSTONE = create_const_char_const$ptr(CONST_BUFFER, 0); 
  public static final char$ptr $EMPTY_KEY = create_const_char_const$ptr(CONST_BUFFER, 0); 
  static {
    assert checkBuiltIn($EMPTY_TOMBSTONE, "");
    assert checkBuiltIn($EMPTY_KEY, "");
  }    
  
  //<editor-fold defaultstate="collapsed" desc="const char$ptr">
  // index used to initialize the following constants
  private static int const_ascii_string_next_index = 0;
  public static final /*const char* */char$ptr $EMPTY =                               get_next_const_ascii_string("");
  public static final /*const char* */char$ptr $SPACE =                               get_next_const_ascii_string(" ");
  public static final /*const char* */char$ptr $TAB =                                 get_next_const_ascii_string("\t");
  public static final /*const char* */char$ptr $VTAB =                                get_next_const_ascii_string("\013");
  public static final /*const char* */char$ptr $LF =                                  get_next_const_ascii_string("\n");
  public static final /*const char* */char$ptr $LFLFLFLFLFLFLFLF =                    get_next_const_ascii_string("\n\n\n\n\n\n\n\n");
  public static final /*const char* */char$ptr $QUOTE_LF =                            get_next_const_ascii_string("\"\n");
  public static final /*const char* */char$ptr $CR =                                  get_next_const_ascii_string("\r");
  public static final /*const char* */char$ptr $SLASH =                               get_next_const_ascii_string("/");
  public static final /*const char* */char$ptr $SLASH_EQ =                            get_next_const_ascii_string("/=");
  public static final /*const char* */char$ptr $SLASH_STAR =                          get_next_const_ascii_string("/*");
  public static final /*const char* */char$ptr $BACK_SLASH =                          get_next_const_ascii_string("\\");
  public static final /*const char* */char$ptr $QMARK =                               get_next_const_ascii_string("?");
  public static final /*const char* */char$ptr $EQ =                                  get_next_const_ascii_string("=");
  public static final /*const char* */char$ptr $EQ_EQ =                               get_next_const_ascii_string("==");
  public static final /*const char* */char$ptr $PIPE =                                get_next_const_ascii_string("|");
  public static final /*const char* */char$ptr $PIPE_EQ =                             get_next_const_ascii_string("|=");
  public static final /*const char* */char$ptr $PIPE_PIPE =                           get_next_const_ascii_string("||");
  public static final /*const char* */char$ptr $AT =                                  get_next_const_ascii_string("@");
  public static final /*const char* */char$ptr $EXCLAIM =                             get_next_const_ascii_string("!");
  public static final /*const char* */char$ptr $EXCLAIM_EQ =                          get_next_const_ascii_string("!=");
  public static final /*const char* */char$ptr $PERCENT =                             get_next_const_ascii_string("%");
  public static final /*const char* */char$ptr $PERCENT_EQ =                          get_next_const_ascii_string("%=");
  public static final /*const char* */char$ptr $UNDERSCORE =                          get_next_const_ascii_string("_");
  public static final /*const char* */char$ptr $MINUS =                               get_next_const_ascii_string("-");
  public static final /*const char* */char$ptr $MINUS_EQ =                            get_next_const_ascii_string("-=");
  public static final /*const char* */char$ptr $MINUS_MINUS =                         get_next_const_ascii_string("--");
  public static final /*const char* */char$ptr $ARROW =                               get_next_const_ascii_string("->");
  public static final /*const char* */char$ptr $ARROW_STAR =                          get_next_const_ascii_string("->*");
  public static final /*const char* */char$ptr $PLUS =                                get_next_const_ascii_string("+");
  public static final /*const char* */char$ptr $PLUS_PLUS =                           get_next_const_ascii_string("++");
  public static final /*const char* */char$ptr $PLUS_EQ =                             get_next_const_ascii_string("+=");
  public static final /*const char* */char$ptr $STAR =                                get_next_const_ascii_string("*");
  public static final /*const char* */char$ptr $STAR_EQ =                             get_next_const_ascii_string("*=");
  public static final /*const char* */char$ptr $STAR_SLASH =                          get_next_const_ascii_string("*/");
  public static final /*const char* */char$ptr $DOT =                                 get_next_const_ascii_string(".");
  public static final /*const char* */char$ptr $DOT_DOT =                             get_next_const_ascii_string("..");
  public static final /*const char* */char$ptr $DOT_STAR =                            get_next_const_ascii_string(".*");
  public static final /*const char* */char$ptr $DOT_ARROW =                           get_next_const_ascii_string(".->");
  public static final /*const char* */char$ptr $ELLIPSIS =                            get_next_const_ascii_string("...");
  public static final /*const char* */char$ptr $AMP =                                 get_next_const_ascii_string("&");
  public static final /*const char* */char$ptr $AMP_AMP =                             get_next_const_ascii_string("&&");
  public static final /*const char* */char$ptr $AMP_EQ =                              get_next_const_ascii_string("&=");
  public static final /*const char* */char$ptr $LSQUARE =                             get_next_const_ascii_string("[");
  public static final /*const char* */char$ptr $RSQUARE =                             get_next_const_ascii_string("]");
  public static final /*const char* */char$ptr $LSQUARE_RSQUARE =                     get_next_const_ascii_string("[]");
  public static final /*const char* */char$ptr $LPAREN =                              get_next_const_ascii_string("(");
  public static final /*const char* */char$ptr $RPAREN =                              get_next_const_ascii_string(")");
  public static final /*const char* */char$ptr $LPAREN_RPAREN =                       get_next_const_ascii_string("()");
  public static final /*const char* */char$ptr $LCURLY =                              get_next_const_ascii_string("{");
  public static final /*const char* */char$ptr $RCURLY =                              get_next_const_ascii_string("}");
  public static final /*const char* */char$ptr $DOLLAR =                              get_next_const_ascii_string("$");
  public static final /*const char* */char$ptr $HASH =                                get_next_const_ascii_string("#");
  public static final /*const char* */char$ptr $HASH_HASH =                           get_next_const_ascii_string("##");
  public static final /*const char* */char$ptr $HASH_AT =                             get_next_const_ascii_string("#@");
  public static final /*const char* */char$ptr $COMMA =                               get_next_const_ascii_string(",");
  public static final /*const char* */char$ptr $COMMA_SPACE =                         get_next_const_ascii_string(", ");
  public static final /*const char* */char$ptr $COLON =                               get_next_const_ascii_string(":");
  public static final /*const char* */char$ptr $COLON_COLON =                         get_next_const_ascii_string("::");
  public static final /*const char* */char$ptr $COLON_LF =                            get_next_const_ascii_string(":\n");
  public static final /*const char* */char$ptr $SEMI =                                get_next_const_ascii_string(";");
  public static final /*const char* */char$ptr $SGL_QUOTE =                           get_next_const_ascii_string("'");
  public static final /*const char* */char$ptr $DBL_QUOTE =                           get_next_const_ascii_string("\"");
  public static final /*const char* */char$ptr $TILDE =                               get_next_const_ascii_string("~");
  public static final /*const char* */char$ptr $CARET =                               get_next_const_ascii_string("^");
  public static final /*const char* */char$ptr $CARET_CARET =                         get_next_const_ascii_string("^^");
  public static final /*const char* */char$ptr $CARET_EQ =                            get_next_const_ascii_string("^=");
  public static final /*const char* */char$ptr $LT =                                  get_next_const_ascii_string("<");
  public static final /*const char* */char$ptr $LT_EQ =                               get_next_const_ascii_string("<=");
  public static final /*const char* */char$ptr $LT_LT =                               get_next_const_ascii_string("<<");
  public static final /*const char* */char$ptr $LT_LT_EQ =                            get_next_const_ascii_string("<<=");
  public static final /*const char* */char$ptr $LT_LT_LT =                            get_next_const_ascii_string("<<<");
  public static final /*const char* */char$ptr $GT =                                  get_next_const_ascii_string(">");
  public static final /*const char* */char$ptr $GT_EQ =                               get_next_const_ascii_string(">=");
  public static final /*const char* */char$ptr $GT_GT =                               get_next_const_ascii_string(">>");
  public static final /*const char* */char$ptr $GT_LF =                               get_next_const_ascii_string(">\n");
  public static final /*const char* */char$ptr $GT_GT_EQ =                            get_next_const_ascii_string(">>=");
  public static final /*const char* */char$ptr $GT_GT_GT =                            get_next_const_ascii_string(">>>");
  public static final /*const char* */char$ptr $0 =                                   get_next_const_ascii_string("0");
  public static final /*const char* */char$ptr $1 =                                   get_next_const_ascii_string("1");
  public static final /*const char* */char$ptr $2 =                                   get_next_const_ascii_string("2");
  public static final /*const char* */char$ptr $3 =                                   get_next_const_ascii_string("3");
  public static final /*const char* */char$ptr $4 =                                   get_next_const_ascii_string("4");
  public static final /*const char* */char$ptr $5 =                                   get_next_const_ascii_string("5");
  public static final /*const char* */char$ptr $6 =                                   get_next_const_ascii_string("6");
  public static final /*const char* */char$ptr $7 =                                   get_next_const_ascii_string("7");
  public static final /*const char* */char$ptr $8 =                                   get_next_const_ascii_string("8");
  public static final /*const char* */char$ptr $9 =                                   get_next_const_ascii_string("9");
  public static final /*const char* */char$ptr $a =                                   get_next_const_ascii_string("a");
  public static final /*const char* */char$ptr $b =                                   get_next_const_ascii_string("b");
  public static final /*const char* */char$ptr $c =                                   get_next_const_ascii_string("c");
  public static final /*const char* */char$ptr $d =                                   get_next_const_ascii_string("d");
  public static final /*const char* */char$ptr $dd =                                  get_next_const_ascii_string("dd");
  public static final /*const char* */char$ptr $ddd =                                 get_next_const_ascii_string("ddd");
  public static final /*const char* */char$ptr $e =                                   get_next_const_ascii_string("e");
  public static final /*const char* */char$ptr $f =                                   get_next_const_ascii_string("f");
  public static final /*const char* */char$ptr $ff =                                  get_next_const_ascii_string("ff");
  public static final /*const char* */char$ptr $fff =                                 get_next_const_ascii_string("fff");
  public static final /*const char* */char$ptr $fn =                                  get_next_const_ascii_string("fn");
  public static final /*const char* */char$ptr $fnc =                                 get_next_const_ascii_string("fnc");
  public static final /*const char* */char$ptr $fne =                                 get_next_const_ascii_string("fne");
  public static final /*const char* */char$ptr $g =                                   get_next_const_ascii_string("g");
  public static final /*const char* */char$ptr $h =                                   get_next_const_ascii_string("h");
  public static final /*const char* */char$ptr $hh =                                  get_next_const_ascii_string("hh");
  public static final /*const char* */char$ptr $i =                                   get_next_const_ascii_string("i");
  public static final /*const char* */char$ptr $iDOT =                                get_next_const_ascii_string("i.");
  public static final /*const char* */char$ptr $ii =                                  get_next_const_ascii_string("ii");
  public static final /*const char* */char$ptr $j =                                   get_next_const_ascii_string("j");
  public static final /*const char* */char$ptr $k =                                   get_next_const_ascii_string("k");
  public static final /*const char* */char$ptr $l =                                   get_next_const_ascii_string("l");
  public static final /*const char* */char$ptr $ll =                                  get_next_const_ascii_string("ll");
  public static final /*const char* */char$ptr $m =                                   get_next_const_ascii_string("m");
  public static final /*const char* */char$ptr $n =                                   get_next_const_ascii_string("n");
  public static final /*const char* */char$ptr $nc =                                  get_next_const_ascii_string("nc");
  public static final /*const char* */char$ptr $nct =                                 get_next_const_ascii_string("nct");
  public static final /*const char* */char$ptr $nctu =                                get_next_const_ascii_string("nctu");
  public static final /*const char* */char$ptr $ncF =                                 get_next_const_ascii_string("ncF");
  public static final /*const char* */char$ptr $nr =                                  get_next_const_ascii_string("nr");
  public static final /*const char* */char$ptr $nt =                                  get_next_const_ascii_string("nt");
  public static final /*const char* */char$ptr $nu =                                  get_next_const_ascii_string("nu");
  public static final /*const char* */char$ptr $nF =                                  get_next_const_ascii_string("nF");
  public static final /*const char* */char$ptr $o =                                   get_next_const_ascii_string("o");
  public static final /*const char* */char$ptr $p =                                   get_next_const_ascii_string("p");
  public static final /*const char* */char$ptr $q =                                   get_next_const_ascii_string("q");
  public static final /*const char* */char$ptr $r =                                   get_next_const_ascii_string("r");
  public static final /*const char* */char$ptr $s =                                   get_next_const_ascii_string("s");
  public static final /*const char* */char$ptr $t =                                   get_next_const_ascii_string("t");
  public static final /*const char* */char$ptr $tn =                                  get_next_const_ascii_string("tn");
  public static final /*const char* */char$ptr $u =                                   get_next_const_ascii_string("u");
  public static final /*const char* */char$ptr $v =                                   get_next_const_ascii_string("v");
  public static final /*const char* */char$ptr $vDOT =                                get_next_const_ascii_string("v.");
  public static final /*const char* */char$ptr $w =                                   get_next_const_ascii_string("w");
  public static final /*const char* */char$ptr $x =                                   get_next_const_ascii_string("x");
  public static final /*const char* */char$ptr $y =                                   get_next_const_ascii_string("y");
  public static final /*const char* */char$ptr $z =                                   get_next_const_ascii_string("z");
  public static final /*const char* */char$ptr $A =                                   get_next_const_ascii_string("A");
  public static final /*const char* */char$ptr $B =                                   get_next_const_ascii_string("B");
  public static final /*const char* */char$ptr $C =                                   get_next_const_ascii_string("C");
  public static final /*const char* */char$ptr $D =                                   get_next_const_ascii_string("D");
  public static final /*const char* */char$ptr $E =                                   get_next_const_ascii_string("E");
  public static final /*const char* */char$ptr $F =                                   get_next_const_ascii_string("F");
  public static final /*const char* */char$ptr $Fn =                                  get_next_const_ascii_string("Fn");
  public static final /*const char* */char$ptr $Fnc =                                 get_next_const_ascii_string("Fnc");
  public static final /*const char* */char$ptr $G =                                   get_next_const_ascii_string("G");
  public static final /*const char* */char$ptr $H =                                   get_next_const_ascii_string("H");
  public static final /*const char* */char$ptr $I =                                   get_next_const_ascii_string("I");
  public static final /*const char* */char$ptr $J =                                   get_next_const_ascii_string("J");
  public static final /*const char* */char$ptr $K =                                   get_next_const_ascii_string("K");
  public static final /*const char* */char$ptr $L =                                   get_next_const_ascii_string("L");
  public static final /*const char* */char$ptr $LL =                                  get_next_const_ascii_string("LL");
  public static final /*const char* */char$ptr $LdLd =                                get_next_const_ascii_string("LdLd");
  public static final /*const char* */char$ptr $M =                                   get_next_const_ascii_string("M");
  public static final /*const char* */char$ptr $N =                                   get_next_const_ascii_string("N");
  public static final /*const char* */char$ptr $O =                                   get_next_const_ascii_string("O");
  public static final /*const char* */char$ptr $P =                                   get_next_const_ascii_string("P");
  public static final /*const char* */char$ptr $Q =                                   get_next_const_ascii_string("Q");
  public static final /*const char* */char$ptr $R =                                   get_next_const_ascii_string("R");
  public static final /*const char* */char$ptr $S =                                   get_next_const_ascii_string("S");
  public static final /*const char* */char$ptr $T =                                   get_next_const_ascii_string("T");
  public static final /*const char* */char$ptr $U =                                   get_next_const_ascii_string("U");
  public static final /*const char* */char$ptr $UL =                                  get_next_const_ascii_string("UL");
  public static final /*const char* */char$ptr $ULL =                                 get_next_const_ascii_string("ULL");
  public static final /*const char* */char$ptr $V =                                   get_next_const_ascii_string("V");
  public static final /*const char* */char$ptr $W =                                   get_next_const_ascii_string("W");
  public static final /*const char* */char$ptr $X =                                   get_next_const_ascii_string("X");
  public static final /*const char* */char$ptr $Y =                                   get_next_const_ascii_string("Y");
  public static final /*const char* */char$ptr $Z =                                   get_next_const_ascii_string("Z");
  public static final /*const char* */char$ptr $__VA_ARGS__ =                         get_next_const_ascii_string("__VA_ARGS__");
  public static final /*const char* */char$ptr $import =                              get_next_const_ascii_string("import");
  public static final /*const char* */char$ptr $line =                                get_next_const_ascii_string("line");
  public static final /*const char* */char$ptr $if =                                  get_next_const_ascii_string("if");
  public static final /*const char* */char$ptr $else =                                get_next_const_ascii_string("else");
  public static final /*const char* */char$ptr $elif =                                get_next_const_ascii_string("elif");
  public static final /*const char* */char$ptr $endif =                               get_next_const_ascii_string("endif");
  public static final /*const char* */char$ptr $ifdef =                               get_next_const_ascii_string("ifdef");
  public static final /*const char* */char$ptr $ifndef =                              get_next_const_ascii_string("ifndef");
  public static final /*const char* */char$ptr $define =                              get_next_const_ascii_string("define");
  public static final /*const char* */char$ptr $undef =                               get_next_const_ascii_string("undef");
  public static final /*const char* */char$ptr $warning =                             get_next_const_ascii_string("warning");
  public static final /*const char* */char$ptr $error =                               get_next_const_ascii_string("error");
  public static final /*const char* */char$ptr $include =                             get_next_const_ascii_string("include");
  public static final /*const char* */char$ptr $include_next =                        get_next_const_ascii_string("include_next");
  public static final /*const char* */char$ptr $ident =                               get_next_const_ascii_string("ident");
  public static final /*const char* */char$ptr $__public_macro =                      get_next_const_ascii_string("__public_macro");
  public static final /*const char* */char$ptr $__private_macro =                     get_next_const_ascii_string("__private_macro");
  public static final /*const char* */char$ptr $pragma =                              get_next_const_ascii_string("pragma");
  public static final /*const char* */char$ptr $once =                                get_next_const_ascii_string("once");
  public static final /*const char* */char$ptr $pragma_once =                         get_next_const_ascii_string("pragma once");
  public static final /*const char* */char$ptr $include_alias =                       get_next_const_ascii_string("include_alias");
  public static final /*const char* */char$ptr $cfe_pth =                             get_next_const_ascii_string("cfe-pth");
  public static final /*const char* */char$ptr $unknown =                             get_next_const_ascii_string("unknown");
  public static final /*const char* */char$ptr $eof =                                 get_next_const_ascii_string("eof");
  public static final /*const char* */char$ptr $eod =                                 get_next_const_ascii_string("eod");
  public static final /*const char* */char$ptr $code_completion =                     get_next_const_ascii_string("code_completion");
  public static final /*const char* */char$ptr $comment =                             get_next_const_ascii_string("comment");
  public static final /*const char* */char$ptr $identifier =                          get_next_const_ascii_string("identifier");
  public static final /*const char* */char$ptr $raw_identifier =                      get_next_const_ascii_string("raw_identifier");
  public static final /*const char* */char$ptr $numeric_constant =                    get_next_const_ascii_string("numeric_constant");
  public static final /*const char* */char$ptr $char_constant =                       get_next_const_ascii_string("char_constant");
  public static final /*const char* */char$ptr $wide_char_constant =                  get_next_const_ascii_string("wide_char_constant");
  public static final /*const char* */char$ptr $utf8_char_constant =                  get_next_const_ascii_string("utf8_char_constant");
  public static final /*const char* */char$ptr $utf16_char_constant =                 get_next_const_ascii_string("utf16_char_constant");
  public static final /*const char* */char$ptr $utf32_char_constant =                 get_next_const_ascii_string("utf32_char_constant");
  public static final /*const char* */char$ptr $string_literal =                      get_next_const_ascii_string("string_literal");
  public static final /*const char* */char$ptr $wide_string_literal =                 get_next_const_ascii_string("wide_string_literal");
  public static final /*const char* */char$ptr $angle_string_literal =                get_next_const_ascii_string("angle_string_literal");
  public static final /*const char* */char$ptr $utf8_string_literal =                 get_next_const_ascii_string("utf8_string_literal");
  public static final /*const char* */char$ptr $utf16_string_literal =                get_next_const_ascii_string("utf16_string_literal");
  public static final /*const char* */char$ptr $utf32_string_literal =                get_next_const_ascii_string("utf32_string_literal");
  public static final /*const char* */char$ptr $l_square =                            get_next_const_ascii_string("l_square");
  public static final /*const char* */char$ptr $r_square =                            get_next_const_ascii_string("r_square");
  public static final /*const char* */char$ptr $l_paren =                             get_next_const_ascii_string("l_paren");
  public static final /*const char* */char$ptr $r_paren =                             get_next_const_ascii_string("r_paren");
  public static final /*const char* */char$ptr $l_brace =                             get_next_const_ascii_string("l_brace");
  public static final /*const char* */char$ptr $r_brace =                             get_next_const_ascii_string("r_brace");
  public static final /*const char* */char$ptr $period =                              get_next_const_ascii_string("period");
  public static final /*const char* */char$ptr $ellipsis =                            get_next_const_ascii_string("ellipsis");
  public static final /*const char* */char$ptr $amp =                                 get_next_const_ascii_string("amp");
  public static final /*const char* */char$ptr $ampamp =                              get_next_const_ascii_string("ampamp");
  public static final /*const char* */char$ptr $ampequal =                            get_next_const_ascii_string("ampequal");
  public static final /*const char* */char$ptr $star =                                get_next_const_ascii_string("star");
  public static final /*const char* */char$ptr $starequal =                           get_next_const_ascii_string("starequal");
  public static final /*const char* */char$ptr $plus =                                get_next_const_ascii_string("plus");
  public static final /*const char* */char$ptr $plusplus =                            get_next_const_ascii_string("plusplus");
  public static final /*const char* */char$ptr $plusequal =                           get_next_const_ascii_string("plusequal");
  public static final /*const char* */char$ptr $minus =                               get_next_const_ascii_string("minus");
  public static final /*const char* */char$ptr $arrow =                               get_next_const_ascii_string("arrow");
  public static final /*const char* */char$ptr $minusminus =                          get_next_const_ascii_string("minusminus");
  public static final /*const char* */char$ptr $minusequal =                          get_next_const_ascii_string("minusequal");
  public static final /*const char* */char$ptr $tilde =                               get_next_const_ascii_string("tilde");
  public static final /*const char* */char$ptr $exclaim =                             get_next_const_ascii_string("exclaim");
  public static final /*const char* */char$ptr $exclaimequal =                        get_next_const_ascii_string("exclaimequal");
  public static final /*const char* */char$ptr $slash =                               get_next_const_ascii_string("slash");
  public static final /*const char* */char$ptr $slashequal =                          get_next_const_ascii_string("slashequal");
  public static final /*const char* */char$ptr $percent =                             get_next_const_ascii_string("percent");
  public static final /*const char* */char$ptr $percentequal =                        get_next_const_ascii_string("percentequal");
  public static final /*const char* */char$ptr $less =                                get_next_const_ascii_string("less");
  public static final /*const char* */char$ptr $lessless =                            get_next_const_ascii_string("lessless");
  public static final /*const char* */char$ptr $lessequal =                           get_next_const_ascii_string("lessequal");
  public static final /*const char* */char$ptr $lesslessequal =                       get_next_const_ascii_string("lesslessequal");
  public static final /*const char* */char$ptr $greater =                             get_next_const_ascii_string("greater");
  public static final /*const char* */char$ptr $greatergreater =                      get_next_const_ascii_string("greatergreater");
  public static final /*const char* */char$ptr $greaterequal =                        get_next_const_ascii_string("greaterequal");
  public static final /*const char* */char$ptr $greatergreaterequal =                 get_next_const_ascii_string("greatergreaterequal");
  public static final /*const char* */char$ptr $caret =                               get_next_const_ascii_string("caret");
  public static final /*const char* */char$ptr $caretequal =                          get_next_const_ascii_string("caretequal");
  public static final /*const char* */char$ptr $pipe =                                get_next_const_ascii_string("pipe");
  public static final /*const char* */char$ptr $pipepipe =                            get_next_const_ascii_string("pipepipe");
  public static final /*const char* */char$ptr $pipeequal =                           get_next_const_ascii_string("pipeequal");
  public static final /*const char* */char$ptr $question =                            get_next_const_ascii_string("question");
  public static final /*const char* */char$ptr $colon =                               get_next_const_ascii_string("colon");
  public static final /*const char* */char$ptr $semi =                                get_next_const_ascii_string("semi");
  public static final /*const char* */char$ptr $equal =                               get_next_const_ascii_string("equal");
  public static final /*const char* */char$ptr $equalequal =                          get_next_const_ascii_string("equalequal");
  public static final /*const char* */char$ptr $comma =                               get_next_const_ascii_string("comma");
  public static final /*const char* */char$ptr $hash =                                get_next_const_ascii_string("hash");
  public static final /*const char* */char$ptr $hashhash =                            get_next_const_ascii_string("hashhash");
  public static final /*const char* */char$ptr $hashat =                              get_next_const_ascii_string("hashat");
  public static final /*const char* */char$ptr $periodstar =                          get_next_const_ascii_string("periodstar");
  public static final /*const char* */char$ptr $arrowstar =                           get_next_const_ascii_string("arrowstar");
  public static final /*const char* */char$ptr $coloncolon =                          get_next_const_ascii_string("coloncolon");
  public static final /*const char* */char$ptr $at =                                  get_next_const_ascii_string("at");
  public static final /*const char* */char$ptr $lesslessless =                        get_next_const_ascii_string("lesslessless");
  public static final /*const char* */char$ptr $greatergreatergreater =               get_next_const_ascii_string("greatergreatergreater");
  public static final /*const char* */char$ptr $caretcaret =                          get_next_const_ascii_string("caretcaret");
  public static final /*const char* */char$ptr $auto =                                get_next_const_ascii_string("auto");
  public static final /*const char* */char$ptr $break =                               get_next_const_ascii_string("break");
  public static final /*const char* */char$ptr $case =                                get_next_const_ascii_string("case");
  public static final /*const char* */char$ptr $char =                                get_next_const_ascii_string("char");
  public static final /*const char* */char$ptr $const =                               get_next_const_ascii_string("const");
  public static final /*const char* */char$ptr $continue =                            get_next_const_ascii_string("continue");
  public static final /*const char* */char$ptr $default =                             get_next_const_ascii_string("default");
  public static final /*const char* */char$ptr $do =                                  get_next_const_ascii_string("do");
  public static final /*const char* */char$ptr $double =                              get_next_const_ascii_string("double");
  public static final /*const char* */char$ptr $enum =                                get_next_const_ascii_string("enum");
  public static final /*const char* */char$ptr $extern =                              get_next_const_ascii_string("extern");
  public static final /*const char* */char$ptr $float =                               get_next_const_ascii_string("float");
  public static final /*const char* */char$ptr $for =                                 get_next_const_ascii_string("for");
  public static final /*const char* */char$ptr $goto =                                get_next_const_ascii_string("goto");
  public static final /*const char* */char$ptr $inline =                              get_next_const_ascii_string("inline");
  public static final /*const char* */char$ptr $int =                                 get_next_const_ascii_string("int");
  public static final /*const char* */char$ptr $long =                                get_next_const_ascii_string("long");
  public static final /*const char* */char$ptr $long_int =                            get_next_const_ascii_string("long int");
  public static final /*const char* */char$ptr $long_long_int =                       get_next_const_ascii_string("long long int");
  public static final /*const char* */char$ptr $long_long_unsigned_int =              get_next_const_ascii_string("long long unsigned int");
  public static final /*const char* */char$ptr $long_unsigned_int =                   get_next_const_ascii_string("long unsigned int");
  public static final /*const char* */char$ptr $register =                            get_next_const_ascii_string("register");
  public static final /*const char* */char$ptr $restrict =                            get_next_const_ascii_string("restrict");
  public static final /*const char* */char$ptr $return =                              get_next_const_ascii_string("return");
  public static final /*const char* */char$ptr $short =                               get_next_const_ascii_string("short");
  public static final /*const char* */char$ptr $signed =                              get_next_const_ascii_string("signed");
  public static final /*const char* */char$ptr $signed_char =                         get_next_const_ascii_string("signed char");
  public static final /*const char* */char$ptr $sizeof =                              get_next_const_ascii_string("sizeof");
  public static final /*const char* */char$ptr $static =                              get_next_const_ascii_string("static");
  public static final /*const char* */char$ptr $struct =                              get_next_const_ascii_string("struct");
  public static final /*const char* */char$ptr $switch =                              get_next_const_ascii_string("switch");
  public static final /*const char* */char$ptr $typedef =                             get_next_const_ascii_string("typedef");
  public static final /*const char* */char$ptr $union =                               get_next_const_ascii_string("union");
  public static final /*const char* */char$ptr $unsigned =                            get_next_const_ascii_string("unsigned");
  public static final /*const char* */char$ptr $unsigned_char =                       get_next_const_ascii_string("unsigned char");
  public static final /*const char* */char$ptr $unsigned_int =                        get_next_const_ascii_string("unsigned int");
  public static final /*const char* */char$ptr $unsigned_short =                      get_next_const_ascii_string("unsigned short");
  public static final /*const char* */char$ptr $void =                                get_next_const_ascii_string("void");
  public static final /*const char* */char$ptr $volatile =                            get_next_const_ascii_string("volatile");
  public static final /*const char* */char$ptr $while =                               get_next_const_ascii_string("while");
  public static final /*const char* */char$ptr $_Alignas =                            get_next_const_ascii_string("_Alignas");
  public static final /*const char* */char$ptr $_Alignof =                            get_next_const_ascii_string("_Alignof");
  public static final /*const char* */char$ptr $_Atomic =                             get_next_const_ascii_string("_Atomic");
  public static final /*const char* */char$ptr $_Bool =                               get_next_const_ascii_string("_Bool");
  public static final /*const char* */char$ptr $_Complex =                            get_next_const_ascii_string("_Complex");
  public static final /*const char* */char$ptr $_Generic =                            get_next_const_ascii_string("_Generic");
  public static final /*const char* */char$ptr $_Imaginary =                          get_next_const_ascii_string("_Imaginary");
  public static final /*const char* */char$ptr $_Noreturn =                           get_next_const_ascii_string("_Noreturn");
  public static final /*const char* */char$ptr $_Static_assert =                      get_next_const_ascii_string("_Static_assert");
  public static final /*const char* */char$ptr $_Thread_local =                       get_next_const_ascii_string("_Thread_local");
  public static final /*const char* */char$ptr $__func__ =                            get_next_const_ascii_string("__func__");
  public static final /*const char* */char$ptr $__objc_yes =                          get_next_const_ascii_string("__objc_yes");
  public static final /*const char* */char$ptr $__objc_no =                           get_next_const_ascii_string("__objc_no");
  public static final /*const char* */char$ptr $asm =                                 get_next_const_ascii_string("asm");
  public static final /*const char* */char$ptr $bool =                                get_next_const_ascii_string("bool");
  public static final /*const char* */char$ptr $catch =                               get_next_const_ascii_string("catch");
  public static final /*const char* */char$ptr $class =                               get_next_const_ascii_string("class");
  public static final /*const char* */char$ptr $const_cast =                          get_next_const_ascii_string("const_cast");
  public static final /*const char* */char$ptr $delete =                              get_next_const_ascii_string("delete");
  public static final /*const char* */char$ptr $delete_LSQUARE_RSQUARE =              get_next_const_ascii_string("delete[]");
  public static final /*const char* */char$ptr $dynamic_cast =                        get_next_const_ascii_string("dynamic_cast");
  public static final /*const char* */char$ptr $explicit =                            get_next_const_ascii_string("explicit");
  public static final /*const char* */char$ptr $export =                              get_next_const_ascii_string("export");
  public static final /*const char* */char$ptr $false =                               get_next_const_ascii_string("false");
  public static final /*const char* */char$ptr $friend =                              get_next_const_ascii_string("friend");
  public static final /*const char* */char$ptr $mutable =                             get_next_const_ascii_string("mutable");
  public static final /*const char* */char$ptr $namespace =                           get_next_const_ascii_string("namespace");
  public static final /*const char* */char$ptr $new =                                 get_next_const_ascii_string("new");
  public static final /*const char* */char$ptr $new_LSQUARE_RSQUARE =                 get_next_const_ascii_string("new[]");
  public static final /*const char* */char$ptr $operator =                            get_next_const_ascii_string("operator");
  public static final /*const char* */char$ptr $protected =                           get_next_const_ascii_string("protected");
  public static final /*const char* */char$ptr $public =                              get_next_const_ascii_string("public");
  public static final /*const char* */char$ptr $reinterpret_cast =                    get_next_const_ascii_string("reinterpret_cast");
  public static final /*const char* */char$ptr $static_cast =                         get_next_const_ascii_string("static_cast");
  public static final /*const char* */char$ptr $template =                            get_next_const_ascii_string("template");
  public static final /*const char* */char$ptr $this =                                get_next_const_ascii_string("this");
  public static final /*const char* */char$ptr $throw =                               get_next_const_ascii_string("throw");
  public static final /*const char* */char$ptr $true =                                get_next_const_ascii_string("true");
  public static final /*const char* */char$ptr $try =                                 get_next_const_ascii_string("try");
  public static final /*const char* */char$ptr $typename =                            get_next_const_ascii_string("typename");
  public static final /*const char* */char$ptr $typeid =                              get_next_const_ascii_string("typeid");
  public static final /*const char* */char$ptr $using =                               get_next_const_ascii_string("using");
  public static final /*const char* */char$ptr $virtual =                             get_next_const_ascii_string("virtual");
  public static final /*const char* */char$ptr $wchar_t =                             get_next_const_ascii_string("wchar_t");
  public static final /*const char* */char$ptr $alignas =                             get_next_const_ascii_string("alignas");
  public static final /*const char* */char$ptr $alignof =                             get_next_const_ascii_string("alignof");
  public static final /*const char* */char$ptr $char16_t =                            get_next_const_ascii_string("char16_t");
  public static final /*const char* */char$ptr $char32_t =                            get_next_const_ascii_string("char32_t");
  public static final /*const char* */char$ptr $constexpr =                           get_next_const_ascii_string("constexpr");
  public static final /*const char* */char$ptr $decltype =                            get_next_const_ascii_string("decltype");
  public static final /*const char* */char$ptr $noexcept =                            get_next_const_ascii_string("noexcept");
  public static final /*const char* */char$ptr $nullptr =                             get_next_const_ascii_string("nullptr");
  public static final /*const char* */char$ptr $static_assert =                       get_next_const_ascii_string("static_assert");
  public static final /*const char* */char$ptr $thread_local =                        get_next_const_ascii_string("thread_local");
  public static final /*const char* */char$ptr $concept =                             get_next_const_ascii_string("concept");
  public static final /*const char* */char$ptr $requires =                            get_next_const_ascii_string("requires");
  public static final /*const char* */char$ptr $co_await =                            get_next_const_ascii_string("co_await");
  public static final /*const char* */char$ptr $co_return =                           get_next_const_ascii_string("co_return");
  public static final /*const char* */char$ptr $co_yield =                            get_next_const_ascii_string("co_yield");
  public static final /*const char* */char$ptr $_Decimal32 =                          get_next_const_ascii_string("_Decimal32");
  public static final /*const char* */char$ptr $_Decimal64 =                          get_next_const_ascii_string("_Decimal64");
  public static final /*const char* */char$ptr $_Decimal128 =                         get_next_const_ascii_string("_Decimal128");
  public static final /*const char* */char$ptr $__null =                              get_next_const_ascii_string("__null");
  public static final /*const char* */char$ptr $__alignof =                           get_next_const_ascii_string("__alignof");
  public static final /*const char* */char$ptr $__attribute =                         get_next_const_ascii_string("__attribute");
  public static final /*const char* */char$ptr $__builtin_choose_expr =               get_next_const_ascii_string("__builtin_choose_expr");
  public static final /*const char* */char$ptr $__builtin_offsetof =                  get_next_const_ascii_string("__builtin_offsetof");
  public static final /*const char* */char$ptr $__builtin_types_compatible_p =        get_next_const_ascii_string("__builtin_types_compatible_p");
  public static final /*const char* */char$ptr $__builtin_va_arg =                    get_next_const_ascii_string("__builtin_va_arg");
  public static final /*const char* */char$ptr $__extension__ =                       get_next_const_ascii_string("__extension__");
  public static final /*const char* */char$ptr $__float128 =                          get_next_const_ascii_string("__float128");
  public static final /*const char* */char$ptr $__imag =                              get_next_const_ascii_string("__imag");
  public static final /*const char* */char$ptr $__int128 =                            get_next_const_ascii_string("__int128");
  public static final /*const char* */char$ptr $__label__ =                           get_next_const_ascii_string("__label__");
  public static final /*const char* */char$ptr $__real =                              get_next_const_ascii_string("__real");
  public static final /*const char* */char$ptr $__thread =                            get_next_const_ascii_string("__thread");
  public static final /*const char* */char$ptr $__FUNCTION__ =                        get_next_const_ascii_string("__FUNCTION__");
  public static final /*const char* */char$ptr $__PRETTY_FUNCTION__ =                 get_next_const_ascii_string("__PRETTY_FUNCTION__");
  public static final /*const char* */char$ptr $__auto_type =                         get_next_const_ascii_string("__auto_type");
  public static final /*const char* */char$ptr $typeof =                              get_next_const_ascii_string("typeof");
  public static final /*const char* */char$ptr $__FUNCDNAME__ =                       get_next_const_ascii_string("__FUNCDNAME__");
  public static final /*const char* */char$ptr $__FUNCSIG__ =                         get_next_const_ascii_string("__FUNCSIG__");
  public static final /*const char* */char$ptr $L__FUNCTION__ =                       get_next_const_ascii_string("L__FUNCTION__");
  public static final /*const char* */char$ptr $__is_interface_class =                get_next_const_ascii_string("__is_interface_class");
  public static final /*const char* */char$ptr $__is_sealed =                         get_next_const_ascii_string("__is_sealed");
  public static final /*const char* */char$ptr $__is_destructible =                   get_next_const_ascii_string("__is_destructible");
  public static final /*const char* */char$ptr $__is_nothrow_destructible =           get_next_const_ascii_string("__is_nothrow_destructible");
  public static final /*const char* */char$ptr $__is_nothrow_assignable =             get_next_const_ascii_string("__is_nothrow_assignable");
  public static final /*const char* */char$ptr $__is_constructible =                  get_next_const_ascii_string("__is_constructible");
  public static final /*const char* */char$ptr $__is_nothrow_constructible =          get_next_const_ascii_string("__is_nothrow_constructible");
  public static final /*const char* */char$ptr $__is_assignable =                     get_next_const_ascii_string("__is_assignable");
  public static final /*const char* */char$ptr $__has_nothrow_assign =                get_next_const_ascii_string("__has_nothrow_assign");
  public static final /*const char* */char$ptr $__has_nothrow_move_assign =           get_next_const_ascii_string("__has_nothrow_move_assign");
  public static final /*const char* */char$ptr $__has_nothrow_copy =                  get_next_const_ascii_string("__has_nothrow_copy");
  public static final /*const char* */char$ptr $__has_nothrow_constructor =           get_next_const_ascii_string("__has_nothrow_constructor");
  public static final /*const char* */char$ptr $__has_trivial_assign =                get_next_const_ascii_string("__has_trivial_assign");
  public static final /*const char* */char$ptr $__has_trivial_move_assign =           get_next_const_ascii_string("__has_trivial_move_assign");
  public static final /*const char* */char$ptr $__has_trivial_copy =                  get_next_const_ascii_string("__has_trivial_copy");
  public static final /*const char* */char$ptr $__has_trivial_constructor =           get_next_const_ascii_string("__has_trivial_constructor");
  public static final /*const char* */char$ptr $__has_trivial_move_constructor =      get_next_const_ascii_string("__has_trivial_move_constructor");
  public static final /*const char* */char$ptr $__has_trivial_destructor =            get_next_const_ascii_string("__has_trivial_destructor");
  public static final /*const char* */char$ptr $__has_virtual_destructor =            get_next_const_ascii_string("__has_virtual_destructor");
  public static final /*const char* */char$ptr $__is_abstract =                       get_next_const_ascii_string("__is_abstract");
  public static final /*const char* */char$ptr $__is_base_of =                        get_next_const_ascii_string("__is_base_of");
  public static final /*const char* */char$ptr $__is_class =                          get_next_const_ascii_string("__is_class");
  public static final /*const char* */char$ptr $__is_convertible_to =                 get_next_const_ascii_string("__is_convertible_to");
  public static final /*const char* */char$ptr $__is_empty =                          get_next_const_ascii_string("__is_empty");
  public static final /*const char* */char$ptr $__is_enum =                           get_next_const_ascii_string("__is_enum");
  public static final /*const char* */char$ptr $__is_final =                          get_next_const_ascii_string("__is_final");
  public static final /*const char* */char$ptr $__is_literal =                        get_next_const_ascii_string("__is_literal");
  public static final /*const char* */char$ptr $__is_literal_type =                   get_next_const_ascii_string("__is_literal_type");
  public static final /*const char* */char$ptr $__is_pod =                            get_next_const_ascii_string("__is_pod");
  public static final /*const char* */char$ptr $__is_polymorphic =                    get_next_const_ascii_string("__is_polymorphic");
  public static final /*const char* */char$ptr $__is_trivial =                        get_next_const_ascii_string("__is_trivial");
  public static final /*const char* */char$ptr $__is_union =                          get_next_const_ascii_string("__is_union");
  public static final /*const char* */char$ptr $__is_trivially_constructible =        get_next_const_ascii_string("__is_trivially_constructible");
  public static final /*const char* */char$ptr $__is_trivially_copyable =             get_next_const_ascii_string("__is_trivially_copyable");
  public static final /*const char* */char$ptr $__is_trivially_assignable =           get_next_const_ascii_string("__is_trivially_assignable");
  public static final /*const char* */char$ptr $__underlying_type =                   get_next_const_ascii_string("__underlying_type");
  public static final /*const char* */char$ptr $__is_lvalue_expr =                    get_next_const_ascii_string("__is_lvalue_expr");
  public static final /*const char* */char$ptr $__is_rvalue_expr =                    get_next_const_ascii_string("__is_rvalue_expr");
  public static final /*const char* */char$ptr $__is_arithmetic =                     get_next_const_ascii_string("__is_arithmetic");
  public static final /*const char* */char$ptr $__is_floating_point =                 get_next_const_ascii_string("__is_floating_point");
  public static final /*const char* */char$ptr $__is_integral =                       get_next_const_ascii_string("__is_integral");
  public static final /*const char* */char$ptr $__is_complete_type =                  get_next_const_ascii_string("__is_complete_type");
  public static final /*const char* */char$ptr $__is_void =                           get_next_const_ascii_string("__is_void");
  public static final /*const char* */char$ptr $__is_array =                          get_next_const_ascii_string("__is_array");
  public static final /*const char* */char$ptr $__is_function =                       get_next_const_ascii_string("__is_function");
  public static final /*const char* */char$ptr $__is_reference =                      get_next_const_ascii_string("__is_reference");
  public static final /*const char* */char$ptr $__is_lvalue_reference =               get_next_const_ascii_string("__is_lvalue_reference");
  public static final /*const char* */char$ptr $__is_rvalue_reference =               get_next_const_ascii_string("__is_rvalue_reference");
  public static final /*const char* */char$ptr $__is_fundamental =                    get_next_const_ascii_string("__is_fundamental");
  public static final /*const char* */char$ptr $__is_object =                         get_next_const_ascii_string("__is_object");
  public static final /*const char* */char$ptr $__is_scalar =                         get_next_const_ascii_string("__is_scalar");
  public static final /*const char* */char$ptr $__is_compound =                       get_next_const_ascii_string("__is_compound");
  public static final /*const char* */char$ptr $__is_pointer =                        get_next_const_ascii_string("__is_pointer");
  public static final /*const char* */char$ptr $__is_member_object_pointer =          get_next_const_ascii_string("__is_member_object_pointer");
  public static final /*const char* */char$ptr $__is_member_function_pointer =        get_next_const_ascii_string("__is_member_function_pointer");
  public static final /*const char* */char$ptr $__is_member_pointer =                 get_next_const_ascii_string("__is_member_pointer");
  public static final /*const char* */char$ptr $__is_const =                          get_next_const_ascii_string("__is_const");
  public static final /*const char* */char$ptr $__is_volatile =                       get_next_const_ascii_string("__is_volatile");
  public static final /*const char* */char$ptr $__is_standard_layout =                get_next_const_ascii_string("__is_standard_layout");
  public static final /*const char* */char$ptr $__is_signed =                         get_next_const_ascii_string("__is_signed");
  public static final /*const char* */char$ptr $__is_unsigned =                       get_next_const_ascii_string("__is_unsigned");
  public static final /*const char* */char$ptr $__is_same =                           get_next_const_ascii_string("__is_same");
  public static final /*const char* */char$ptr $__is_convertible =                    get_next_const_ascii_string("__is_convertible");
  public static final /*const char* */char$ptr $__array_rank =                        get_next_const_ascii_string("__array_rank");
  public static final /*const char* */char$ptr $__array_extent =                      get_next_const_ascii_string("__array_extent");
  public static final /*const char* */char$ptr $__private_extern__ =                  get_next_const_ascii_string("__private_extern__");
  public static final /*const char* */char$ptr $__module_private__ =                  get_next_const_ascii_string("__module_private__");
  public static final /*const char* */char$ptr $__declspec =                          get_next_const_ascii_string("__declspec");
  public static final /*const char* */char$ptr $__cdecl =                             get_next_const_ascii_string("__cdecl");
  public static final /*const char* */char$ptr $__stdcall =                           get_next_const_ascii_string("__stdcall");
  public static final /*const char* */char$ptr $__fastcall =                          get_next_const_ascii_string("__fastcall");
  public static final /*const char* */char$ptr $__thiscall =                          get_next_const_ascii_string("__thiscall");
  public static final /*const char* */char$ptr $__vectorcall =                        get_next_const_ascii_string("__vectorcall");
  public static final /*const char* */char$ptr $__forceinline =                       get_next_const_ascii_string("__forceinline");
  public static final /*const char* */char$ptr $__unaligned =                         get_next_const_ascii_string("__unaligned");
  public static final /*const char* */char$ptr $__super =                             get_next_const_ascii_string("__super");
  public static final /*const char* */char$ptr $__global =                            get_next_const_ascii_string("__global");
  public static final /*const char* */char$ptr $__local =                             get_next_const_ascii_string("__local");
  public static final /*const char* */char$ptr $__constant =                          get_next_const_ascii_string("__constant");
  public static final /*const char* */char$ptr $__private =                           get_next_const_ascii_string("__private");
  public static final /*const char* */char$ptr $__generic =                           get_next_const_ascii_string("__generic");
  public static final /*const char* */char$ptr $global =                              get_next_const_ascii_string("global");
  public static final /*const char* */char$ptr $local =                               get_next_const_ascii_string("local");
  public static final /*const char* */char$ptr $constant =                            get_next_const_ascii_string("constant");
  public static final /*const char* */char$ptr $private =                             get_next_const_ascii_string("private");
  public static final /*const char* */char$ptr $generic =                             get_next_const_ascii_string("generic");
  public static final /*const char* */char$ptr $__kernel =                            get_next_const_ascii_string("__kernel");
  public static final /*const char* */char$ptr $kernel =                              get_next_const_ascii_string("kernel");
  public static final /*const char* */char$ptr $__read_only =                         get_next_const_ascii_string("__read_only");
  public static final /*const char* */char$ptr $__write_only =                        get_next_const_ascii_string("__write_only");
  public static final /*const char* */char$ptr $__read_write =                        get_next_const_ascii_string("__read_write");
  public static final /*const char* */char$ptr $read_only =                           get_next_const_ascii_string("read_only");
  public static final /*const char* */char$ptr $write_only =                          get_next_const_ascii_string("write_only");
  public static final /*const char* */char$ptr $read_write =                          get_next_const_ascii_string("read_write");
  public static final /*const char* */char$ptr $__builtin_astype =                    get_next_const_ascii_string("__builtin_astype");
  public static final /*const char* */char$ptr $vec_step =                            get_next_const_ascii_string("vec_step");
  public static final /*const char* */char$ptr $image1d_t =                           get_next_const_ascii_string("image1d_t");
  public static final /*const char* */char$ptr $image1d_array_t =                     get_next_const_ascii_string("image1d_array_t");
  public static final /*const char* */char$ptr $image1d_buffer_t =                    get_next_const_ascii_string("image1d_buffer_t");
  public static final /*const char* */char$ptr $image2d_t =                           get_next_const_ascii_string("image2d_t");
  public static final /*const char* */char$ptr $image2d_array_t =                     get_next_const_ascii_string("image2d_array_t");
  public static final /*const char* */char$ptr $image2d_depth_t =                     get_next_const_ascii_string("image2d_depth_t");
  public static final /*const char* */char$ptr $image2d_array_depth_t =               get_next_const_ascii_string("image2d_array_depth_t");
  public static final /*const char* */char$ptr $image2d_msaa_t =                      get_next_const_ascii_string("image2d_msaa_t");
  public static final /*const char* */char$ptr image2d_array_msaa_t =                 get_next_const_ascii_string("image2d_array_msaa_t");
  public static final /*const char* */char$ptr $image2d_msaa_depth_t =                get_next_const_ascii_string("image2d_msaa_depth_t");
  public static final /*const char* */char$ptr $image2d_array_msaa_depth_t =          get_next_const_ascii_string("image2d_array_msaa_depth_t");
  public static final /*const char* */char$ptr $image3d_t =                           get_next_const_ascii_string("image3d_t");
  public static final /*const char* */char$ptr $__builtin_omp_required_simd_align =   get_next_const_ascii_string("__builtin_omp_required_simd_align");
  public static final /*const char* */char$ptr $__pascal =                            get_next_const_ascii_string("__pascal");
  public static final /*const char* */char$ptr $__vector =                            get_next_const_ascii_string("__vector");
  public static final /*const char* */char$ptr $__pixel =                             get_next_const_ascii_string("__pixel");
  public static final /*const char* */char$ptr $__bool =                              get_next_const_ascii_string("__bool");
  public static final /*const char* */char$ptr $__fp16 =                              get_next_const_ascii_string("__fp16");
  public static final /*const char* */char$ptr $half =                                get_next_const_ascii_string("half");
  public static final /*const char* */char$ptr $__bridge =                            get_next_const_ascii_string("__bridge");
  public static final /*const char* */char$ptr $__bridge_transfer =                   get_next_const_ascii_string("__bridge_transfer");
  public static final /*const char* */char$ptr $__bridge_retained =                   get_next_const_ascii_string("__bridge_retained");
  public static final /*const char* */char$ptr $__bridge_retain =                     get_next_const_ascii_string("__bridge_retain");
  public static final /*const char* */char$ptr $__covariant =                         get_next_const_ascii_string("__covariant");
  public static final /*const char* */char$ptr $__contravariant =                     get_next_const_ascii_string("__contravariant");
  public static final /*const char* */char$ptr $__kindof =                            get_next_const_ascii_string("__kindof");
  public static final /*const char* */char$ptr $nonnull =                             get_next_const_ascii_string("nonnull");
  public static final /*const char* */char$ptr $_Nonnull =                            get_next_const_ascii_string("_Nonnull");
  public static final /*const char* */char$ptr $nullable =                            get_next_const_ascii_string("nullable");
  public static final /*const char* */char$ptr $_Nullable =                           get_next_const_ascii_string("_Nullable");
  public static final /*const char* */char$ptr $null_unspecified =                    get_next_const_ascii_string("null_unspecified");
  public static final /*const char* */char$ptr $_Null_unspecified =                   get_next_const_ascii_string("_Null_unspecified");
  public static final /*const char* */char$ptr $__alignof__ =                         get_next_const_ascii_string("__alignof__");
  public static final /*const char* */char$ptr $__asm =                               get_next_const_ascii_string("__asm");
  public static final /*const char* */char$ptr $__asm__ =                             get_next_const_ascii_string("__asm__");
  public static final /*const char* */char$ptr $__attribute__ =                       get_next_const_ascii_string("__attribute__");
  public static final /*const char* */char$ptr $__complex =                           get_next_const_ascii_string("__complex");
  public static final /*const char* */char$ptr $__complex__ =                         get_next_const_ascii_string("__complex__");
  public static final /*const char* */char$ptr $__const =                             get_next_const_ascii_string("__const");
  public static final /*const char* */char$ptr $__const__ =                           get_next_const_ascii_string("__const__");
  public static final /*const char* */char$ptr $__decltype =                          get_next_const_ascii_string("__decltype");
  public static final /*const char* */char$ptr $__imag__ =                            get_next_const_ascii_string("__imag__");
  public static final /*const char* */char$ptr $__inline =                            get_next_const_ascii_string("__inline");
  public static final /*const char* */char$ptr $__inline__ =                          get_next_const_ascii_string("__inline__");
  public static final /*const char* */char$ptr $__nullptr =                           get_next_const_ascii_string("__nullptr");
  public static final /*const char* */char$ptr $__real__ =                            get_next_const_ascii_string("__real__");
  public static final /*const char* */char$ptr $__restrict =                          get_next_const_ascii_string("__restrict");
  public static final /*const char* */char$ptr $__restrict__ =                        get_next_const_ascii_string("__restrict__");
  public static final /*const char* */char$ptr $__signed =                            get_next_const_ascii_string("__signed");
  public static final /*const char* */char$ptr $__signed__ =                          get_next_const_ascii_string("__signed__");
  public static final /*const char* */char$ptr $__typeof =                            get_next_const_ascii_string("__typeof");
  public static final /*const char* */char$ptr $__typeof__ =                          get_next_const_ascii_string("__typeof__");
  public static final /*const char* */char$ptr $__volatile =                          get_next_const_ascii_string("__volatile");
  public static final /*const char* */char$ptr $__volatile__ =                        get_next_const_ascii_string("__volatile__");
  public static final /*const char* */char$ptr $__ptr64 =                             get_next_const_ascii_string("__ptr64");
  public static final /*const char* */char$ptr $__ptr32 =                             get_next_const_ascii_string("__ptr32");
  public static final /*const char* */char$ptr $__sptr =                              get_next_const_ascii_string("__sptr");
  public static final /*const char* */char$ptr $__uptr =                              get_next_const_ascii_string("__uptr");
  public static final /*const char* */char$ptr $__w64 =                               get_next_const_ascii_string("__w64");
  public static final /*const char* */char$ptr $__uuidof =                            get_next_const_ascii_string("__uuidof");
  public static final /*const char* */char$ptr $__try =                               get_next_const_ascii_string("__try");
  public static final /*const char* */char$ptr $__finally =                           get_next_const_ascii_string("__finally");
  public static final /*const char* */char$ptr $__leave =                             get_next_const_ascii_string("__leave");
  public static final /*const char* */char$ptr $__int64 =                             get_next_const_ascii_string("__int64");
  public static final /*const char* */char$ptr $__if_exists =                         get_next_const_ascii_string("__if_exists");
  public static final /*const char* */char$ptr $__if_not_exists =                     get_next_const_ascii_string("__if_not_exists");
  public static final /*const char* */char$ptr $__single_inheritance =                get_next_const_ascii_string("__single_inheritance");
  public static final /*const char* */char$ptr $__multiple_inheritance =              get_next_const_ascii_string("__multiple_inheritance");
  public static final /*const char* */char$ptr $__virtual_inheritance =               get_next_const_ascii_string("__virtual_inheritance");
  public static final /*const char* */char$ptr $__interface =                         get_next_const_ascii_string("__interface");
  public static final /*const char* */char$ptr $__int8 =                              get_next_const_ascii_string("__int8");
  public static final /*const char* */char$ptr $_int8 =                               get_next_const_ascii_string("_int8");
  public static final /*const char* */char$ptr $__int16 =                             get_next_const_ascii_string("__int16");
  public static final /*const char* */char$ptr $_int16 =                              get_next_const_ascii_string("_int16");
  public static final /*const char* */char$ptr $__int32 =                             get_next_const_ascii_string("__int32");
  public static final /*const char* */char$ptr $_int32 =                              get_next_const_ascii_string("_int32");
  public static final /*const char* */char$ptr $_int64 =                              get_next_const_ascii_string("_int64");
  public static final /*const char* */char$ptr $__wchar_t =                           get_next_const_ascii_string("__wchar_t");
  public static final /*const char* */char$ptr $_asm =                                get_next_const_ascii_string("_asm");
  public static final /*const char* */char$ptr $_alignof =                            get_next_const_ascii_string("_alignof");
  public static final /*const char* */char$ptr $__builtin_alignof =                   get_next_const_ascii_string("__builtin_alignof");
  public static final /*const char* */char$ptr $_cdecl =                              get_next_const_ascii_string("_cdecl");
  public static final /*const char* */char$ptr $_fastcall =                           get_next_const_ascii_string("_fastcall");
  public static final /*const char* */char$ptr $_stdcall =                            get_next_const_ascii_string("_stdcall");
  public static final /*const char* */char$ptr $_thiscall =                           get_next_const_ascii_string("_thiscall");
  public static final /*const char* */char$ptr $_vectorcall =                         get_next_const_ascii_string("_vectorcall");
  public static final /*const char* */char$ptr $_uuidof =                             get_next_const_ascii_string("_uuidof");
  public static final /*const char* */char$ptr $_inline =                             get_next_const_ascii_string("_inline");
  public static final /*const char* */char$ptr $_declspec =                           get_next_const_ascii_string("_declspec");
  public static final /*const char* */char$ptr $_pascal =                             get_next_const_ascii_string("_pascal");
  public static final /*const char* */char$ptr $__builtin_convertvector =             get_next_const_ascii_string("__builtin_convertvector");
  public static final /*const char* */char$ptr $__builtin_available =                 get_next_const_ascii_string("__builtin_available");
  public static final /*const char* */char$ptr $__char16_t =                          get_next_const_ascii_string("__char16_t");
  public static final /*const char* */char$ptr $__char32_t =                          get_next_const_ascii_string("__char32_t");
  public static final /*const char* */char$ptr $__unknown_anytype =                   get_next_const_ascii_string("__unknown_anytype");
  public static final /*const char* */char$ptr $annot_cxxscope =                      get_next_const_ascii_string("annot_cxxscope");
  public static final /*const char* */char$ptr $annot_typename =                      get_next_const_ascii_string("annot_typename");
  public static final /*const char* */char$ptr $annot_template_id =                   get_next_const_ascii_string("annot_template_id");
  public static final /*const char* */char$ptr $annot_primary_expr =                  get_next_const_ascii_string("annot_primary_expr");
  public static final /*const char* */char$ptr $annot_decltype =                      get_next_const_ascii_string("annot_decltype");
  public static final /*const char* */char$ptr $annot_pragma_unused =                 get_next_const_ascii_string("annot_pragma_unused");
  public static final /*const char* */char$ptr $annot_pragma_vis =                    get_next_const_ascii_string("annot_pragma_vis");
  public static final /*const char* */char$ptr $annot_pragma_pack =                   get_next_const_ascii_string("annot_pragma_pack");
  public static final /*const char* */char$ptr $annot_pragma_parser_crash =           get_next_const_ascii_string("annot_pragma_parser_crash");
  public static final /*const char* */char$ptr $annot_pragma_captured =               get_next_const_ascii_string("annot_pragma_captured");
  public static final /*const char* */char$ptr $annot_pragma_dump =                   get_next_const_ascii_string("annot_pragma_dump");
  public static final /*const char* */char$ptr $annot_pragma_msstruct =               get_next_const_ascii_string("annot_pragma_msstruct");
  public static final /*const char* */char$ptr $annot_pragma_align =                  get_next_const_ascii_string("annot_pragma_align");
  public static final /*const char* */char$ptr $annot_pragma_weak =                   get_next_const_ascii_string("annot_pragma_weak");
  public static final /*const char* */char$ptr $annot_pragma_weakalias =              get_next_const_ascii_string("annot_pragma_weakalias");
  public static final /*const char* */char$ptr $annot_pragma_redefine_extname =       get_next_const_ascii_string("annot_pragma_redefine_extname");
  public static final /*const char* */char$ptr $annot_pragma_fp_contract =            get_next_const_ascii_string("annot_pragma_fp_contract");
  public static final /*const char* */char$ptr $annot_pragma_ms_pointers_to_members =  get_next_const_ascii_string("annot_pragma_ms_pointers_to_members");
  public static final /*const char* */char$ptr $annot_pragma_ms_vtordisp =            get_next_const_ascii_string("annot_pragma_ms_vtordisp");
  public static final /*const char* */char$ptr $annot_pragma_ms_pragma =              get_next_const_ascii_string("annot_pragma_ms_pragma");
  public static final /*const char* */char$ptr $annot_pragma_opencl_extension =       get_next_const_ascii_string("annot_pragma_opencl_extension");
  public static final /*const char* */char$ptr $annot_pragma_openmp =                 get_next_const_ascii_string("annot_pragma_openmp");
  public static final /*const char* */char$ptr $annot_pragma_openmp_end =             get_next_const_ascii_string("annot_pragma_openmp_end");
  public static final /*const char* */char$ptr $annot_pragma_loop_hint =              get_next_const_ascii_string("annot_pragma_loop_hint");
  public static final /*const char* */char$ptr $annot_module_include =                get_next_const_ascii_string("annot_module_include");
  public static final /*const char* */char$ptr $annot_module_begin =                  get_next_const_ascii_string("annot_module_begin");
  public static final /*const char* */char$ptr $annot_module_end =                    get_next_const_ascii_string("annot_module_end");
  public static final /*const char* */char$ptr $UTF_16__BE_ =                         get_next_const_ascii_string("UTF-16 (BE)");
  public static final /*const char* */char$ptr $UTF_16__LE_ =                         get_next_const_ascii_string("UTF-16 (LE)");
  public static final /*const char* */char$ptr $UTF_32__BE_ =                         get_next_const_ascii_string("UTF-32 (BE)");
  public static final /*const char* */char$ptr $UTF_32__LE_ =                         get_next_const_ascii_string("UTF-32 (LE)");
  public static final /*const char* */char$ptr $UTF_7 =                               get_next_const_ascii_string("UTF-7");
  public static final /*const char* */char$ptr $UTF_1 =                               get_next_const_ascii_string("UTF-1");
  public static final /*const char* */char$ptr $UTF_EBCDIC =                          get_next_const_ascii_string("UTF-EBCDIC");
  public static final /*const char* */char$ptr $SDSU =                                get_next_const_ascii_string("SDSU");
  public static final /*const char* */char$ptr $BOCU_1 =                              get_next_const_ascii_string("BOCU-1");
  public static final /*const char* */char$ptr $GB_18030 =                            get_next_const_ascii_string("GB-18030");
  public static final /*const char* */char$ptr $SLASH_TMP =                           get_next_const_ascii_string("/tmp");
  public static final /*const char* */char$ptr $SLASH_VAR_SLASH_TMP =                 get_next_const_ascii_string("/var/tmp");
  public static final /*const char* */char$ptr $scratch_space_marker =                get_next_const_ascii_string("<scratch space>");
  public static final /*const char* */char$ptr $invalid_marker =                      get_next_const_ascii_string("<invalid>");
  public static final /*const char* */char$ptr $built_in_marker =                     get_next_const_ascii_string("<built-in>");
  static {
    assert const_ascii_string_next_index == 621 : 621 + " vs. " + const_ascii_string_next_index;
  }
  //</editor-fold>
  
  private static /*const char* */char$ptr get_next_const_ascii_string(String assertContent) {
    /*uint*/int idx = const_ascii_string_next_index++;
    final char$ptr constPtr = CONST_ASCII_STRINGS[idx];
    assert strlen_impl(constPtr) == assertContent.length() : strlen_impl(constPtr) + " vs. " + assertContent;
    assert memcmp_impl(constPtr, assertContent, assertContent.length()) == 0 : 
            assertContent + " vs. " + constPtr;
    return constPtr;
  } 
  
  private static boolean checkBuiltIn(char$ptr b, String toCompare) {
    assert memcmp_impl(b, toCompare, toCompare.length()) == 0;
    assert builtInConst(b);
    return true;
  }  
  
  private static char$ptr create_const_char_const$ptr(byte[] array, /*uint*/int idx) {
    return new char$ptr$array(array, idx, true, true);
  }  
  
  // copy-paste from std.memcmp Otherwise we may have a cyclic dependencies and error in class initializers
  private static int memcmp_impl(char$ptr ptr, CharSequence Str, /*size_t*/ int len) {
    int ptrIdx = 0;
    int StrIdx = 0;
    int pos = 0;
    int len1 = (int) len;
    int ch1 = 0;
    int ch2 = 0;
    while (pos < len1 && (ch1 = ptr.$at(ptrIdx)) == (ch2 = Str.charAt(StrIdx))) {
      pos++;
      ptrIdx++;
      StrIdx++;
    }
    return pos == len1 ? 0 : ch1 - ch2 // works for ascii chars
    ;  
  }

  
  // copy-paste from std.strlen. Otherwise we may have a cyclic dependencies and error in class initializers
  private static int strlen_impl(char$ptr str) {
    int len = 0;
    while (str.$at(len) != '\0') {
      len++;
    }
    return len;
  }  
}
