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
package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.io.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.lex.*;
import org.clang.basic.*;
import static org.clang.staticanalyzer.core.impl.IssueHashStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type IssueHashStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp -nm=_ZL12GetSignaturePKN5clang12FunctionDeclE;_ZL13NormalizeLineRKN5clang13SourceManagerERNS_13FullSourceLocERKNS_11LangOptionsE;_ZL16GetHashOfContentN4llvm9StringRefE;_ZL16GetNthLineOfFilePN4llvm12MemoryBufferEi;_ZL32GetEnclosingDeclContextSignaturePKN5clang4DeclE; -static-type=IssueHashStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class IssueHashStatics {


// Get a string representation of the parts of the signature that can be 
// overloaded on.
//<editor-fold defaultstate="collapsed" desc="GetSignature">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp", line = 32,
 FQN="GetSignature", NM="_ZL12GetSignaturePKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp -nm=_ZL12GetSignaturePKN5clang12FunctionDeclE")
//</editor-fold>
public static std.string GetSignature(/*const*/ FunctionDecl /*P*/ Target) {
  if (!(Target != null)) {
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }
  std.string Signature/*J*/= new std.string();
  if (!isa_CXXConstructorDecl(Target) && !isa_CXXDestructorDecl(Target)
     && !isa_CXXConversionDecl(Target)) {
    Signature.append(Target.getReturnType().getAsString().data()).append($SPACE);
  }
  Signature.append(Target.getQualifiedNameAsString().data()).append($LPAREN);
  
  for (int i = 0, paramsCount = Target.getNumParams(); i < paramsCount; ++i) {
    if ((i != 0)) {
      Signature.append($COMMA_SPACE);
    }
    Signature.append(Target.getParamDecl$Const(i).getType().getAsString().data());
  }
  if (Target.isVariadic()) {
    Signature.append($(", ..."));
  }
  Signature.append($RPAREN);
  
  /*const*/ FunctionType /*P*/ TargetT = dyn_cast_or_null_FunctionType(Target.getType().getTypePtr());
  if (!(TargetT != null) || !isa_CXXMethodDecl(Target)) {
    return Signature;
  }
  if (TargetT.isConst()) {
    Signature.append($(" const"));
  }
  if (TargetT.isVolatile()) {
    Signature.append($(" volatile"));
  }
  if (TargetT.isRestrict()) {
    Signature.append($(" restrict"));
  }
  {
    
    /*const*/ FunctionProtoType /*P*/ TargetPT = dyn_cast_or_null_FunctionProtoType(Target.getType().getTypePtr());
    if ((TargetPT != null)) {
      switch (TargetPT.getRefQualifier()) {
       case RQ_LValue:
        Signature.append($(" &"));
        break;
       case RQ_RValue:
        Signature.append($(" &&"));
        break;
       default:
        break;
      }
    }
  }
  
  return Signature;
}

//<editor-fold defaultstate="collapsed" desc="GetEnclosingDeclContextSignature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp", line = 82,
 FQN="GetEnclosingDeclContextSignature", NM="_ZL32GetEnclosingDeclContextSignaturePKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp -nm=_ZL32GetEnclosingDeclContextSignaturePKN5clang4DeclE")
//</editor-fold>
public static std.string GetEnclosingDeclContextSignature(/*const*/ Decl /*P*/ D) {
  if (!(D != null)) {
    return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  }
  {
    
    /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
    if ((ND != null)) {
      std.string DeclName/*J*/= new std.string();
      switch (ND.getKind()) {
       case Namespace:
       case Record:
       case CXXRecord:
       case Enum:
        DeclName.$assignMove(ND.getQualifiedNameAsString());
        break;
       case CXXConstructor:
       case CXXDestructor:
       case CXXConversion:
       case CXXMethod:
       case Function:
        DeclName.$assignMove(GetSignature(dyn_cast_or_null_FunctionDecl(ND)));
        break;
       case ObjCMethod:
        // ObjC Methods can not be overloaded, qualified name uniquely identifies
        // the method.
        DeclName.$assignMove(ND.getQualifiedNameAsString());
        break;
       default:
        break;
      }
      
      return DeclName;
    }
  }
  
  return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
}

//<editor-fold defaultstate="collapsed" desc="GetNthLineOfFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp", line = 118,
 FQN="GetNthLineOfFile", NM="_ZL16GetNthLineOfFilePN4llvm12MemoryBufferEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp -nm=_ZL16GetNthLineOfFilePN4llvm12MemoryBufferEi")
//</editor-fold>
public static StringRef GetNthLineOfFile(MemoryBuffer /*P*/ Buffer, int Line) {
  if (!(Buffer != null)) {
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }
  
  line_iterator LI/*J*/= new line_iterator($Deref(Buffer), false);
  for (; !LI.is_at_eof() && LI.line_number() != Line; LI.$preInc())  {
    ;
  }
  
  return LI.$star();
}

//<editor-fold defaultstate="collapsed" desc="NormalizeLine">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*use raw_string_ostream*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp", line = 129,
 FQN="NormalizeLine", NM="_ZL13NormalizeLineRKN5clang13SourceManagerERNS_13FullSourceLocERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp -nm=_ZL13NormalizeLineRKN5clang13SourceManagerERNS_13FullSourceLocERKNS_11LangOptionsE")
//</editor-fold>
public static std.string NormalizeLine(final /*const*/ SourceManager /*&*/ SM, final FullSourceLoc /*&*/ L, 
             final /*const*/ LangOptions /*&*/ LangOpts) {
  Lexer $Lexer = null;
  raw_string_ostream LineBuff = null;
  try {
    final/*static*/ StringRef Whitespaces = NormalizeLine$$.Whitespaces;
    
    StringRef Str = GetNthLineOfFile(SM.getBuffer(L.getFileID(), /*NO_COPY*/L), 
        L.getExpansionLineNumber());
    /*size_t*/int col = Str.find_first_not_of(/*NO_COPY*/Whitespaces);
    if (col == StringRef.npos) {
      col = 1; // The line only contains whitespace.
    } else {
      col++;
    }
    SourceLocation StartOfLine = SM.translateLineCol(SM.getFileID(/*NO_COPY*/L), L.getExpansionLineNumber(), col);
    MemoryBuffer /*P*/ Buffer = SM.getBuffer(SM.getFileID(/*NO_COPY*/StartOfLine), /*NO_COPY*/StartOfLine);
    if (!(Buffer != null)) {
      return /*{ */new std.string()/* }*/;
    }
    
    // JAVA PERF: use faster method
    /*const*/char$ptr/*char P*/ BufferPos = SM.getCharacterData_ValidOnly(/*NO_COPY*/StartOfLine.getRawEncoding(), create_char$null$ptr());
    
    Token $Token/*J*/= new Token();
    $Lexer/*J*/= new Lexer(SM.getLocForStartOfFile(SM.getFileID(/*NO_COPY*/StartOfLine)), LangOpts, 
        Buffer.getBufferStart(), BufferPos, Buffer.getBufferEnd());
    
    /*size_t*/int NextStart = 0;
    std.string $LineBuff = new std.string();
    LineBuff/*J*/= new raw_string_ostream($LineBuff);
    while (!$Lexer.LexFromRawLexer($Token) && $less_uint(NextStart, 2)) {
      if ($Token.isAtStartOfLine() && $greater_uint(NextStart++, 0)) {
        continue;
      }
      $out_os_string$C(LineBuff, new std.string(SM.getCharacterData_ValidOnly($Token.$getLocation(), BufferPos), 
              $Token.getLength()));
    }
    
    return LineBuff.str();
  } finally {
    if (LineBuff != null) { LineBuff.$destroy(); }
    if ($Lexer != null) { $Lexer.$destroy(); }
  }
}
private static final class NormalizeLine$$ {
  static final/*static*/ StringRef Whitespaces = new StringRef(/*KEEP_STR*/" \t\n");
}

//<editor-fold defaultstate="collapsed" desc="GetHashOfContent">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp", line = 165,
 FQN="GetHashOfContent", NM="_ZL16GetHashOfContentN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/IssueHash.cpp -nm=_ZL16GetHashOfContentN4llvm9StringRefE")
//</editor-fold>
public static SmallString/*32*/ GetHashOfContent(StringRef Content) {
  MD5 Hash/*J*/= new MD5();
  byte/*uint8_t*/ MD5Res[/*16*/] = new$char(16);
  SmallString/*32*/ Res/*J*/= new SmallString/*32*/(32);
  
  Hash.update(new StringRef(Content));
  Hash.__final(MD5Res);
  MD5.stringifyResult(MD5Res, Res);
  
  return Res;
}

} // END OF class IssueHashStatics
