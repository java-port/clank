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

package org.clang.ast;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.lex.Token;
import org.clang.lex.*;
import org.clang.lex.Lexer;
import org.clang.lex.llvm.*;
import static org.clang.ast.java.AstSizeofAndAlignment.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.SourceLocation.*;
import org.clang.basic.target.*;


/// StringLiteral - This represents a string literal expression, e.g. "foo"
/// or L"bar" (wide strings).  The actual string is returned by getBytes()
/// is NOT null-terminated, and the length of the string is determined by
/// calling getByteLength().  The C type for a string is always a
/// ConstantArrayType.  In C++, the char type is const qualified, in C it is
/// not.
///
/// Note that strings in C can be formed by concatenation of multiple string
/// literal pptokens in translation phase #6.  This keeps track of the locations
/// of each of these pieces.
///
/// Strings in C can also be truncated and extended by assigning into arrays,
/// e.g. with constructs like:
///   char X[2] = "foobar";
/// In this case, getByteLength() will return 6, but the string literal will
/// have type "char[2]".
//<editor-fold defaultstate="collapsed" desc="clang::StringLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1466,
 FQN="clang::StringLiteral", NM="_ZN5clang13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteralE")
//</editor-fold>
public class StringLiteral extends /*public*/ Expr implements ITrailingObjectsJavaBase<StringLiteral> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::StringKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1468,
   FQN="clang::StringLiteral::StringKind", NM="_ZN5clang13StringLiteral10StringKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral10StringKindE")
  //</editor-fold>
  public enum StringKind implements Native.ComparableLower {
    Ascii(0),
    Wide(Ascii.getValue() + 1),
    UTF8(Wide.getValue() + 1),
    UTF16(UTF8.getValue() + 1),
    UTF32(UTF16.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static StringKind valueOf(int val) {
      StringKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final StringKind[] VALUES;
      private static final StringKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (StringKind kind : StringKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new StringKind[min < 0 ? (1-min) : 0];
        VALUES = new StringKind[max >= 0 ? (1+max) : 0];
        for (StringKind kind : StringKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private StringKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((StringKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((StringKind)obj).value);}
    //</editor-fold>
  };
/*private:*/
  /*friend  class ASTStmtReader*/
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1479,
   FQN="clang::StringLiteral::(anonymous)", NM="_ZN5clang13StringLiteralE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteralE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public /*const*/char$ptr/*char P*/ asChar;
    public /*const*//*uint16_t*/ushort$ptr asUInt16;
    public /*const*//*uint32_t P*/uint$ptr asUInt32;
    
    //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1479,
     FQN="clang::StringLiteral::(anonymous union)::", NM="_ZN5clang13StringLiteralUt_C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteralUt_C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union1() {
    }

    
    @Override public String toString() {
      return "" + "asChar=" + asChar // NOI18N
                + ", asUInt16=" + asUInt16 // NOI18N
                + ", asUInt32=" + asUInt32; // NOI18N
    }
  };
  
  private Unnamed_union1 StrData;
  private /*uint*/int Length;
  private /*JBYTE unsigned int*/ byte CharByteWidth /*: 4*/;
  private /*JBYTE unsigned int*/ byte Kind /*: 3*/;
  private /*JBIT unsigned int*/ boolean IsPascal /*: 1*/;
  private /*uint*/int NumConcatenated;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private final type$ptr<SourceLocation /*P*/> TokLocs/*[1]*/ = (type$ptr<SourceLocation /*P*/>)$toConst(super.$this$plus1());
  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::StringLiteral">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1491,
   FQN="clang::StringLiteral::StringLiteral", NM="_ZN5clang13StringLiteralC1ENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteralC1ENS_8QualTypeE")
  //</editor-fold>
  private StringLiteral(QualType Ty, int NumStrs) {
    // : Expr(StringLiteralClass, Ty, VK_LValue, OK_Ordinary, false, false, false, false), StrData(), TokLocs() 
    //START JInit
    super(StmtClass.StringLiteralClass, new QualType(Ty), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, false, false, false, 
        false);
    this.StrData = new Unnamed_union1();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::mapCharByteWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 802,
   FQN="clang::StringLiteral::mapCharByteWidth", NM="_ZN5clang13StringLiteral16mapCharByteWidthERKNS_10TargetInfoENS0_10StringKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral16mapCharByteWidthERKNS_10TargetInfoENS0_10StringKindE")
  //</editor-fold>
  private static int mapCharByteWidth(final /*const*/ TargetInfo /*&*/ target, StringKind k) {
    int CharByteWidth = 0;
    switch (k) {
     case Ascii:
     case UTF8:
      CharByteWidth = target.getCharWidth();
      break;
     case Wide:
      CharByteWidth = target.getWCharWidth();
      break;
     case UTF16:
      CharByteWidth = target.getChar16Width();
      break;
     case UTF32:
      CharByteWidth = target.getChar32Width();
      break;
    }
    assert ((CharByteWidth & 7) == 0) : "Assumes character size is byte multiple";
    CharByteWidth /= 8;
    assert ((CharByteWidth == 1 || CharByteWidth == 2 || CharByteWidth == 4)) : "character byte widths supported are 1, 2, and 4 only";
    return CharByteWidth;
  }

/*public:*/
  /// This is the "fully general" constructor that allows representation of
  /// strings formed from multiple concatenated tokens.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 826,
   FQN="clang::StringLiteral::Create", NM="_ZN5clang13StringLiteral6CreateERKNS_10ASTContextEN4llvm9StringRefENS0_10StringKindEbNS_8QualTypeEPKNS_14SourceLocationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral6CreateERKNS_10ASTContextEN4llvm9StringRefENS0_10StringKindEbNS_8QualTypeEPKNS_14SourceLocationEj")
  //</editor-fold>
  public static StringLiteral /*P*/ Create(final /*const*/ ASTContext /*&*/ C, StringRef Str, 
        StringKind Kind, boolean Pascal, QualType Ty, 
        /*const*/type$ptr<SourceLocation> /*P*/ Loc, 
        /*uint*/int NumStrs) {
    assert ((C.getAsConstantArrayType(new QualType(Ty)) != null)) : "StringLiteral must be of constant array type!";
    
    // Allocate enough space for the StringLiteral plus an array of locations for
    // any concatenated string tokens.
    Object/*void P*/ Mem;
    // JAVA: MEMORY
    if (false) {
      Mem = C.Allocate($sizeof_StringLiteral()
           + $sizeof_SourceLocation() * (NumStrs - 1), 
        alignOf(StringLiteral.class));
    } else {
      // JAVA: we allocate NumStrs (vs NumStrs-1) Locs here, because TokLocs string is reference to $this$plus1
      // and not SourceLocation [1] as in Native which is in fact just trick to have Head in field and 
      // other objects in tail
      Mem = C.Allocate$JavaRef(1/*$sizeof_StringLiteral()*/
           + 1/*$sizeof_SourceLocation()*/ * (NumStrs/* - 1*/), 
        1/*alignOf(StringLiteral.class)*/,
        new std.pairIntPtr<>(1, ()->null), // for this
        new std.pairIntPtr<>((NumStrs/* - 1*/), ()->new SourceLocation()) // for trailing Locs
        );
    }
    StringLiteral /*P*/ SL = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new StringLiteral(new QualType(Ty), NumStrs);
     });
    
    // OPTIMIZE: could allocate this appended to the StringLiteral.
    SL.setString(C, new StringRef(Str), Kind, Pascal);
    
    SL.TokLocs.$at(0).$assign(Loc.$at(0));
    SL.NumConcatenated = NumStrs;
    if (NumStrs != 1) {
      memcpy($AddrOf(SL.TokLocs.$add(1)), Loc.$add(1), (true/*JAVA*/ ? 1 : $sizeof_SourceLocation()) * (NumStrs - 1), false);
    }
    return SL;
  }

  
  /// Simple constructor for string literals made from one token.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::Create">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1505,
   FQN="clang::StringLiteral::Create", NM="_ZN5clang13StringLiteral6CreateERKNS_10ASTContextEN4llvm9StringRefENS0_10StringKindEbNS_8QualTypeENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral6CreateERKNS_10ASTContextEN4llvm9StringRefENS0_10StringKindEbNS_8QualTypeENS_14SourceLocationE")
  //</editor-fold>
  public static StringLiteral /*P*/ Create(final /*const*/ ASTContext /*&*/ C, StringRef Str, 
        StringKind Kind, boolean Pascal, QualType Ty, 
        SourceLocation _Loc) {
    final type$ptr<SourceLocation> Loc = create_type$ptr(_Loc);
    return Create(C, new StringRef(Str), Kind, Pascal, new QualType(Ty), $AddrOf(Loc), 1);
  }

  
  /// \brief Construct an empty string literal.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::CreateEmpty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 851,
   FQN="clang::StringLiteral::CreateEmpty", NM="_ZN5clang13StringLiteral11CreateEmptyERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral11CreateEmptyERKNS_10ASTContextEj")
  //</editor-fold>
  public static StringLiteral /*P*/ CreateEmpty(final /*const*/ ASTContext /*&*/ C, 
             /*uint*/int NumStrs) {
    // JAVA: MEMORY
    // JAVA: we allocate NumStrs (vs NumStrs-1) Locs here, because TokLocs string is reference to $this$plus1
    // and not SourceLocation [1] as in Native which is in fact just trick to have Head in field and 
    // other objects in tail    
    Object/*void P*/ Mem = C.Allocate$JavaRef(/*$sizeof_StringLiteral()*/1
           + 1/*$sizeof_SourceLocation()*/ * (NumStrs/* - 1*/), 
        1/*alignOf(StringLiteral.class)*/,
        new std.pairIntPtr<>(1, ()->null), // for this
        new std.pairIntPtr<>((NumStrs/* - 1*/), ()->new SourceLocation()) // for trailing Locs
    );
    StringLiteral /*P*/ SL = /*NEW_EXPR [Stmt::new]*//*new (Mem)*/ Stmt.$new(Mem, (type$ptr<?> New$Mem)->{
        return new StringLiteral(new QualType(), NumStrs);
     });
    SL.CharByteWidth = $uint2uint_4bits(0);
    SL.Length = 0;
    SL.NumConcatenated = NumStrs;
    return SL;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1514,
   FQN="clang::StringLiteral::getString", NM="_ZNK5clang13StringLiteral9getStringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral9getStringEv")
  //</editor-fold>
  public StringRef getString() /*const*/ {
    assert (CharByteWidth == $int2uint_4bits(1)) : "This function is used in places that assume strings use char";
    return new StringRef(StrData.asChar, getByteLength());
  }

  
  /// Allow access to clients that need the byte representation, such as
  /// ASTWriterStmt::VisitStringLiteral().
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1522,
   FQN="clang::StringLiteral::getBytes", NM="_ZNK5clang13StringLiteral8getBytesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral8getBytesEv")
  //</editor-fold>
  public StringRef getBytes() /*const*/ {
    // FIXME: StringRef may not be the right type to use as a result for this.
    if (CharByteWidth == $int2uint_4bits(1)) {
      return new StringRef(StrData.asChar, getByteLength());
    }
    if (CharByteWidth == $int2uint_4bits(4)) {
      return new StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, StrData.asUInt32), 
          getByteLength());
    }
    assert (CharByteWidth == $int2uint_4bits(2)) : "unsupported CharByteWidth";
    return new StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, StrData.asUInt16), 
        getByteLength());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::outputString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 863,
   FQN="clang::StringLiteral::outputString", NM="_ZNK5clang13StringLiteral12outputStringERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral12outputStringERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void outputString(final raw_ostream /*&*/ OS) /*const*/ {
    switch (getKind()) {
     case Ascii:
      break; // no prefix.
     case Wide:
      OS.$out_char($$L);
      break;
     case UTF8:
      OS.$out(/*KEEP_STR*/"u8");
      break;
     case UTF16:
      OS.$out_char($$u);
      break;
     case UTF32:
      OS.$out_char($$U);
      break;
    }
    OS.$out_char($$DBL_QUOTE);
    final/*static*/ /*const*//*char*/byte Hex[/*17*/] = outputString$$.Hex;
    
    /*uint*/int LastSlashX = getLength();
    for (/*uint*/int I = 0, N = getLength(); I != N; ++I) {
      {
        /*uint32_t*/int Char = getCodeUnit(I);
        switch (Char) {
         default:
          // FIXME: Convert UTF-8 back to codepoints before rendering.
          
          // Convert UTF-16 surrogate pairs back to codepoints before rendering.
          // Leave invalid surrogates alone; we'll use \x for those.
          if (getKind() == StringKind.UTF16 && I != N - 1 && $greatereq_uint(Char, 0xd800)
             && $lesseq_uint(Char, 0xdbff)) {
            /*uint32_t*/int Trail = getCodeUnit(I + 1);
            if ($greatereq_uint(Trail, 0xdc00) && $lesseq_uint(Trail, 0xdfff)) {
              Char = 0x10000 + ((Char - 0xd800) << 10) + (Trail - 0xdc00);
              ++I;
            }
          }
          if ($greater_uint(Char, 0xff)) {
            // If this is a wide string, output characters over 0xff using \x
            // escapes. Otherwise, this is a UTF-16 or UTF-32 string, and Char is a
            // codepoint: use \x escapes for invalid codepoints.
            if (getKind() == StringKind.Wide
               || ($greatereq_uint(Char, 0xd800) && $lesseq_uint(Char, 0xdfff)) || $greatereq_uint(Char, 0x110000)) {
              // FIXME: Is this the best way to print wchar_t?
              OS.$out(/*KEEP_STR*/"\\x");
              int Shift = 28;
              while ((Char >>> Shift) == 0) {
                Shift -= 4;
              }
              for (; Shift >= 0; Shift -= 4)  {
                OS.$out_char(Hex[(Char >>> Shift) & 15]);
              }
              LastSlashX = I;
              break;
            }
            if ($greater_uint(Char, 0xffff)) {
              OS.$out(/*KEEP_STR*/"\\U00").$out_char(
                  Hex[(Char >>> 20) & 15]
              ).$out_char(
                  Hex[(Char >>> 16) & 15]
              );
            } else {
              OS.$out(/*KEEP_STR*/"\\u");
            }
            OS.$out_char(Hex[(Char >>> 12) & 15]).$out_char(
                Hex[(Char >>> 8) & 15]
            ).$out_char(
                Hex[(Char >>> 4) & 15]
            ).$out_char(
                Hex[(Char >>> 0) & 15]
            );
            break;
          }
          
          // If we used \x... for the previous character, and this character is a
          // hexadecimal digit, prevent it being slurped as part of the \x.
          if (LastSlashX + 1 == I) {
            switch (Char) {
             case '0':
             case '1':
             case '2':
             case '3':
             case '4':
             case '5':
             case '6':
             case '7':
             case '8':
             case '9':
             case 'a':
             case 'b':
             case 'c':
             case 'd':
             case 'e':
             case 'f':
             case 'A':
             case 'B':
             case 'C':
             case 'D':
             case 'E':
             case 'F':
              OS.$out(/*KEEP_STR*/"\"\"");
            }
          }
          assert ($lesseq_uint(Char, 0xFF)) : "Characters above 0xff should already have been handled.";
          if (isPrintable($uint2uchar(Char))) {
            OS.$out_char((/*char*/byte)$uint2char(Char));
          } else { // Output anything hard as an octal escape.
            OS.$out_char($$BACK_SLASH).$out_char(
                (/*char*/byte)$uint2char(($char2uint($$0) + ((Char >>> 6) & 7)))
            ).$out_char(
                (/*char*/byte)$uint2char(($char2uint($$0) + ((Char >>> 3) & 7)))
            ).$out_char(
                (/*char*/byte)$uint2char(($char2uint($$0) + ((Char >>> 0) & 7)))
            );
          }
          break;
         case '\\':
          // Handle some common non-printable cases to make dumps prettier.
          OS.$out(/*KEEP_STR*/"\\\\");
          break;
         case '"':
          OS.$out(/*KEEP_STR*/"\\\"");
          break;
         case '\n':
          OS.$out(/*KEEP_STR*/"\\n");
          break;
         case '\t':
          OS.$out(/*KEEP_STR*/"\\t");
          break;
         case '\007':
          OS.$out(/*KEEP_STR*/"\\a");
          break;
         case '\b':
          OS.$out(/*KEEP_STR*/"\\b");
          break;
        }
      }
    }
    OS.$out_char($$DBL_QUOTE);
  }
  private static final class outputString$$ {
    static final/*static*/ /*const*//*char*/byte Hex[/*17*/] = create_char$ptr_utf8("0123456789ABCDEF").$array();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getCodeUnit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1536,
   FQN="clang::StringLiteral::getCodeUnit", NM="_ZNK5clang13StringLiteral11getCodeUnitEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral11getCodeUnitEj")
  //</editor-fold>
  public /*uint32_t*/int getCodeUnit(/*size_t*/int i) /*const*/ {
    assert ($less_uint(i, Length)) : "out of bounds access";
    if (CharByteWidth == $int2uint_4bits(1)) {
      return $uchar2uint(((/*static_cast*//*uchar*/byte)(StrData.asChar.$at(i))));
    }
    if (CharByteWidth == $int2uint_4bits(4)) {
      return StrData.asUInt32.$at(i);
    }
    assert (CharByteWidth == $int2uint_4bits(2)) : "unsupported CharByteWidth";
    return $ushort2uint(StrData.asUInt16.$at(i));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getByteLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1546,
   FQN="clang::StringLiteral::getByteLength", NM="_ZNK5clang13StringLiteral13getByteLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral13getByteLengthEv")
  //</editor-fold>
  public /*uint*/int getByteLength() /*const*/ {
    return $4bits_uint2uint(CharByteWidth) * Length;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getLength">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1547,
   FQN="clang::StringLiteral::getLength", NM="_ZNK5clang13StringLiteral9getLengthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral9getLengthEv")
  //</editor-fold>
  public /*uint*/int getLength() /*const*/ {
    return Length;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getCharByteWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1548,
   FQN="clang::StringLiteral::getCharByteWidth", NM="_ZNK5clang13StringLiteral16getCharByteWidthEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral16getCharByteWidthEv")
  //</editor-fold>
  public /*uint*/int getCharByteWidth() /*const*/ {
    return CharByteWidth;
  }

  
  /// \brief Sets the string data to the given string data.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::setString">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 956,
   FQN="clang::StringLiteral::setString", NM="_ZN5clang13StringLiteral9setStringERKNS_10ASTContextEN4llvm9StringRefENS0_10StringKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral9setStringERKNS_10ASTContextEN4llvm9StringRefENS0_10StringKindEb")
  //</editor-fold>
  public void setString(final /*const*/ ASTContext /*&*/ C, StringRef Str, 
           StringKind Kind, boolean IsPascal) {
    //FIXME: we assume that the string data comes from a target that uses the same
    // code unit size and endianess for the type of string.
    this.Kind = $uint2uint_3bits(Kind.getValue());
    this.IsPascal = IsPascal;
    
    CharByteWidth = $uint2uint_4bits(mapCharByteWidth(C.getTargetInfo(), Kind));
    assert (($rem_uint(Str.size(), CharByteWidth) == 0)) : "size of data must be multiple of CharByteWidth";
    Length = $div_uint(Str.size(), CharByteWidth);
    switch (CharByteWidth) {
     case 1:
      {
        // JAVA: MEMORY
        char$ptr/*char P*/ AStrData = create_char$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
        /*new (C)*/ /*FIXME 1: $array_new_uint_ASTContext$C_uint*/new$char(Length));
        std.memcpy(AStrData, Str.data(), Length * sizeof$uint8());
        StrData.asChar = $noClone(AStrData);
        break;
      }
     case 2:
      {
        // JAVA: MEMORY
        /*uint16_t*/ushort$ptr AStrData = create_ushort$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
        /*new (C)*/ /*FIXME 1: $array_new_uint_ASTContext$C_uint*/new$ushort(Length));
        std.memcpy(AStrData, Str.data(), Length * sizeof$uint16());
        StrData.asUInt16 = $noClone(AStrData);
        break;
      }
     case 4:
      {
        // JAVA: MEMORY
        /*uint32_t P*/uint$ptr AStrData = create_uint$ptr(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
        /*new (C)*/ /*FIXME 2: $array_new_uint_ASTContext$C_uint*/new$uint(Length));
        std.memcpy(AStrData, Str.data(), Length * sizeof$uint32());
        StrData.asUInt32 = $noClone(AStrData);
        break;
      }
     default:
      throw new llvm_unreachable("unsupported CharByteWidth");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1554,
   FQN="clang::StringLiteral::getKind", NM="_ZNK5clang13StringLiteral7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral7getKindEv")
  //</editor-fold>
  public StringKind getKind() /*const*/ {
    return /*static_cast*/StringKind.valueOf(Kind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::isAscii">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1557,
   FQN="clang::StringLiteral::isAscii", NM="_ZNK5clang13StringLiteral7isAsciiEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral7isAsciiEv")
  //</editor-fold>
  public boolean isAscii() /*const*/ {
    return Kind == $int2uint_3bits(StringKind.Ascii.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::isWide">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1558,
   FQN="clang::StringLiteral::isWide", NM="_ZNK5clang13StringLiteral6isWideEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral6isWideEv")
  //</editor-fold>
  public boolean isWide() /*const*/ {
    return Kind == $int2uint_3bits(StringKind.Wide.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::isUTF8">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1559,
   FQN="clang::StringLiteral::isUTF8", NM="_ZNK5clang13StringLiteral6isUTF8Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral6isUTF8Ev")
  //</editor-fold>
  public boolean isUTF8() /*const*/ {
    return Kind == $int2uint_3bits(StringKind.UTF8.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::isUTF16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1560,
   FQN="clang::StringLiteral::isUTF16", NM="_ZNK5clang13StringLiteral7isUTF16Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral7isUTF16Ev")
  //</editor-fold>
  public boolean isUTF16() /*const*/ {
    return Kind == $int2uint_3bits(StringKind.UTF16.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::isUTF32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1561,
   FQN="clang::StringLiteral::isUTF32", NM="_ZNK5clang13StringLiteral7isUTF32Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral7isUTF32Ev")
  //</editor-fold>
  public boolean isUTF32() /*const*/ {
    return Kind == $int2uint_3bits(StringKind.UTF32.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::isPascal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1562,
   FQN="clang::StringLiteral::isPascal", NM="_ZNK5clang13StringLiteral8isPascalEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral8isPascalEv")
  //</editor-fold>
  public boolean isPascal() /*const*/ {
    return IsPascal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::containsNonAsciiOrNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1564,
   FQN="clang::StringLiteral::containsNonAsciiOrNull", NM="_ZNK5clang13StringLiteral22containsNonAsciiOrNullEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral22containsNonAsciiOrNullEv")
  //</editor-fold>
  public boolean containsNonAsciiOrNull() /*const*/ {
    StringRef Str = getString();
    for (/*uint*/int i = 0, e = Str.size(); i != e; ++i)  {
      if (!isASCII(Str.$at(i)) || !(Str.$at(i) != 0)) {
        return true;
      }
    }
    return false;
  }

  
  /// getNumConcatenated - Get the number of string literal tokens that were
  /// concatenated in translation phase #6 to form this string literal.
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getNumConcatenated">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1574,
   FQN="clang::StringLiteral::getNumConcatenated", NM="_ZNK5clang13StringLiteral18getNumConcatenatedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral18getNumConcatenatedEv")
  //</editor-fold>
  public /*uint*/int getNumConcatenated() /*const*/ {
    return NumConcatenated;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getStrTokenLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1576,
   FQN="clang::StringLiteral::getStrTokenLoc", NM="_ZNK5clang13StringLiteral14getStrTokenLocEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral14getStrTokenLocEj")
  //</editor-fold>
  public SourceLocation getStrTokenLoc(/*uint*/int TokNum) /*const*/ {
    assert ($less_uint(TokNum, NumConcatenated)) : "Invalid tok number";
    return new SourceLocation(TokLocs.$at(TokNum));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::setStrTokenLoc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1580,
   FQN="clang::StringLiteral::setStrTokenLoc", NM="_ZN5clang13StringLiteral14setStrTokenLocEjNS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral14setStrTokenLocEjNS_14SourceLocationE")
  //</editor-fold>
  public void setStrTokenLoc(/*uint*/int TokNum, SourceLocation L) {
    assert ($less_uint(TokNum, NumConcatenated)) : "Invalid tok number";
    TokLocs.$at(TokNum).$assign(L);
  }

  
  /// getLocationOfByte - Return a source location that points to the specified
  /// byte of this string literal.
  ///
  /// Strings are amazingly complex.  They can be formed from multiple tokens
  /// and can have escape sequences in them in addition to the usual trigraph
  /// and escaped newline business.  This routine handles this complexity.
  ///
  
  /// getLocationOfByte - Return a source location that points to the specified
  /// byte of this string literal.
  ///
  /// Strings are amazingly complex.  They can be formed from multiple tokens and
  /// can have escape sequences in them in addition to the usual trigraph and
  /// escaped newline business.  This routine handles this complexity.
  ///
  /// The *StartToken sets the first token to be searched in this function and
  /// the *StartTokenByteOffset is the byte offset of the first token. Before
  /// returning, it updates the *StartToken to the TokNo of the token being found
  /// and sets *StartTokenByteOffset to the byte offset of the token in the
  /// string.
  /// Using these two parameters can reduce the time complexity from O(n^2) to
  /// O(n) if one wants to get the location of byte for all the tokens in a
  /// string.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getLocationOfByte">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp", line = 1008,
   FQN="clang::StringLiteral::getLocationOfByte", NM="_ZNK5clang13StringLiteral17getLocationOfByteEjRKNS_13SourceManagerERKNS_11LangOptionsERKNS_10TargetInfoEPjSA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral17getLocationOfByteEjRKNS_13SourceManagerERKNS_11LangOptionsERKNS_10TargetInfoEPjSA_")
  //</editor-fold>
  public SourceLocation getLocationOfByte(/*uint*/int ByteNo, final /*const*/ SourceManager /*&*/ SM, 
                   final /*const*/ LangOptions /*&*/ Features, 
                   final /*const*/ TargetInfo /*&*/ Target) /*const*/ {
    return getLocationOfByte(ByteNo, SM, 
                   Features, 
                   Target, (uint$ptr/*uint P*/ )null, 
                   (uint$ptr/*uint P*/ )null);
  }
  public SourceLocation getLocationOfByte(/*uint*/int ByteNo, final /*const*/ SourceManager /*&*/ SM, 
                   final /*const*/ LangOptions /*&*/ Features, 
                   final /*const*/ TargetInfo /*&*/ Target, uint$ptr/*uint P*/ StartToken/*= null*/) /*const*/ {
    return getLocationOfByte(ByteNo, SM, 
                   Features, 
                   Target, StartToken, 
                   (uint$ptr/*uint P*/ )null);
  }
  public SourceLocation getLocationOfByte(/*uint*/int ByteNo, final /*const*/ SourceManager /*&*/ SM, 
                   final /*const*/ LangOptions /*&*/ Features, 
                   final /*const*/ TargetInfo /*&*/ Target, uint$ptr/*uint P*/ StartToken/*= null*/, 
                   uint$ptr/*uint P*/ StartTokenByteOffset/*= null*/) /*const*/ {
    assert ((Kind == $int2uint_3bits(StringLiteral.StringKind.Ascii.getValue()) || Kind == $int2uint_3bits(StringLiteral.StringKind.UTF8.getValue()))) : "Only narrow string literals are currently supported";
    
    // Loop over all of the tokens in this string until we find the one that
    // contains the byte we're looking for.
    /*uint*/int TokNo = 0;
    /*uint*/int StringOffset = 0;
    if (Native.$bool(StartToken)) {
      TokNo = StartToken.$star();
    }
    if (Native.$bool(StartTokenByteOffset)) {
      StringOffset = StartTokenByteOffset.$star();
      ByteNo -= StringOffset;
    }
    while (true) {
      org.clang.lex.Lexer TheLexer = null;
      try {
        assert ($less_uint(TokNo, getNumConcatenated())) : "Invalid byte number!";
        SourceLocation StrTokLoc = getStrTokenLoc(TokNo);
        
        // Get the spelling of the string so that we can get the data that makes up
        // the string literal, not the identifier for the macro it is potentially
        // expanded through.
        SourceLocation StrTokSpellingLoc = SM.getSpellingLoc(/*NO_COPY*/StrTokLoc);
        
        // Re-lex the token to get its length and original spelling.
        std.pairTypeUInt<FileID> LocInfo = SM.getDecomposedLoc(/*NO_COPY*/StrTokSpellingLoc);
        bool$ptr Invalid = /*JAVA:PERF*/null;//create_bool$ptr(false);
        StringRef Buffer = SM.getBufferData(/*NO_COPY*/LocInfo.first, /*AddrOf*/Invalid);
        if (Buffer /*JAVA:PERF*/== SourceManager.INVALID_BUFFER_DATA) {
          if ($noteq_ptr(StartTokenByteOffset, null)) {
            StartTokenByteOffset.$set(StringOffset);
          }
          if ($noteq_ptr(StartToken, null)) {
            StartToken.$set(TokNo);
          }
          return StrTokSpellingLoc;
        }
        
        /*const*/char$ptr/*char P*/ StrData = $tryClone(Buffer.data().$add(LocInfo.second));
        
        // Create a lexer starting at the beginning of this token.
        TheLexer/*J*/= new Lexer(SM.getLocForStartOfFile(/*NO_COPY*/LocInfo.first), Features, 
            Buffer.begin(), StrData, Buffer.end());
        Token TheTok/*J*/= new Token();
        TheLexer.LexFromRawLexer(TheTok);
        
        // Use the StringLiteralParser to compute the length of the string in bytes.
        StringLiteralParser SLP/*J*/= new StringLiteralParser(new ArrayRefToken(TheTok, false), SM, Features, Target);
        /*uint*/int TokNumBytes = SLP.GetStringLength();
        
        // If the byte is in this token, return the location of the byte.
        if ($less_uint(ByteNo, TokNumBytes)
           || (ByteNo == TokNumBytes && TokNo == getNumConcatenated() - 1)) {
          /*uint*/int Offset = SLP.getOffsetOfStringByte(TheTok, ByteNo);
          
          // Now that we know the offset of the token in the spelling, use the
          // preprocessor to get the offset in the original source.
          if ($noteq_ptr(StartTokenByteOffset, null)) {
            StartTokenByteOffset.$set(StringOffset);
          }
          if ($noteq_ptr(StartToken, null)) {
            StartToken.$set(TokNo);
          }
          return Lexer.AdvanceToTokenCharacter(/*NO_COPY*/StrTokLoc, Offset, SM, Features);
        }
        
        // Move to the next string token.
        StringOffset += TokNumBytes;
        ++TokNo;
        ByteNo -= TokNumBytes;
      } finally {
        if (TheLexer != null) { TheLexer.$destroy(); }
      }
    }
  }

  
  /*typedef const SourceLocation *tokloc_iterator*/
//  public final class tokloc_iterator extends /*const*/type$ptr<SourceLocation> /*P*/ { };
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::tokloc_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1599,
   FQN="clang::StringLiteral::tokloc_begin", NM="_ZNK5clang13StringLiteral12tokloc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral12tokloc_beginEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ tokloc_begin() /*const*/ {
    return TokLocs;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::tokloc_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1600,
   FQN="clang::StringLiteral::tokloc_end", NM="_ZNK5clang13StringLiteral10tokloc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral10tokloc_endEv")
  //</editor-fold>
  public /*const*/type$ptr<SourceLocation> /*P*/ tokloc_end() /*const*/ {
    return TokLocs.$add(NumConcatenated);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getLocStart">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1602,
   FQN="clang::StringLiteral::getLocStart", NM="_ZNK5clang13StringLiteral11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(TokLocs.$at(0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::getLocEnd">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1603,
   FQN="clang::StringLiteral::getLocEnd", NM="_ZNK5clang13StringLiteral9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZNK5clang13StringLiteral9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    return new SourceLocation(TokLocs.$at(NumConcatenated - 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1607,
   FQN="clang::StringLiteral::classof", NM="_ZN5clang13StringLiteral7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.StringLiteralClass;
  }

  
  // Iterators
  //<editor-fold defaultstate="collapsed" desc="clang::StringLiteral::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Expr.h", line = 1612,
   FQN="clang::StringLiteral::children", NM="_ZN5clang13StringLiteral8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp -nm=_ZN5clang13StringLiteral8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(), new StmtIterator());
  }

  
  @Override public String toString() {
    return "" + "StrData=" + StrData // NOI18N
              + ", Length=" + Length // NOI18N
              + ", CharByteWidth=" + $uchar2uint(CharByteWidth) // NOI18N
              + ", Kind=" + $uchar2uint(Kind) // NOI18N
              + ", IsPascal=" + IsPascal // NOI18N
              + ", NumConcatenated=" + NumConcatenated // NOI18N
              + ", TokLocs=" + TokLocs // NOI18N
              + super.toString(); // NOI18N
  }
}
