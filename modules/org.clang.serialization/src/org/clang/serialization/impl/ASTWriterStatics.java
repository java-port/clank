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
package org.clang.serialization.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.bitcode.*;
import org.clang.serialization.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.sema.ExternalSemaSource;
import org.clank.java.stdimpl.aliases.StdVector;
import org.llvm.bitcode.bitc.BlockInfoCodes;
import org.llvm.support.sys.path;


//<editor-fold defaultstate="collapsed" desc="static type ASTWriterStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.serialization.impl.ASTWriterStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=Tpl__ZL18AddLazyVectorDeclsRN5clang9ASTWriterERT_RN4llvm11SmallVectorIyLj64EEE;Tpl__ZL5bytesRKN4llvm15SmallVectorImplIT_EE;Tpl__ZL5bytesRKSt6vectorIT_T0_E;_ZL11EmitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL12EmitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE;_ZL12getSignaturev;_ZL13AddStmtsExprsRN4llvm15BitstreamWriterERNS_15SmallVectorImplIyEE;_ZL16addExceptionSpecPKN5clang17FunctionProtoTypeERNS_15ASTRecordWriterE;_ZL17shouldIgnoreMacroPN5clang14MacroDirectiveEbRKNS_12PreprocessorE;_ZL18cleanPathForOutputRN5clang11FileManagerERN4llvm15SmallVectorImplIcEE;_ZL18getNumberOfModulesPN5clang6ModuleE;_ZL20CreateSLocFileAbbrevRN4llvm15BitstreamWriterE;_ZL21EmitCXXBaseSpecifiersRN5clang9ASTWriterEN4llvm8ArrayRefINS_16CXXBaseSpecifierEEE;_ZL21getDeclForLocalLookupRKN5clang11LangOptionsEPNS_9NamedDeclE;_ZL21isImportedDeclContextPN5clang9ASTReaderEPKNS_4DeclE;_ZL22CreateSLocBufferAbbrevRN4llvm15BitstreamWriterE;_ZL23EmitCXXCtorInitializersRN5clang9ASTWriterEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE;_ZL25CreateSLocExpansionAbbrevRN4llvm15BitstreamWriterE;_ZL26CreateSLocBufferBlobAbbrevRN4llvm15BitstreamWriterEb;_ZL31adjustFilenameForRelocatableASTPKcN4llvm9StringRefE; -static-type=ASTWriterStatics -package=org.clang.serialization.impl")
//</editor-fold>
public final class ASTWriterStatics {

  //template <typename T = unsigned long, typename Allocator = allocator<unsigned long>> 
  //<editor-fold defaultstate="collapsed" desc="bytes">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 69,
   FQN="bytes", NM="_ZL5bytesIySaIyEEN4llvm9StringRefERKSt6vectorIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL5bytesIySaIyEEN4llvm9StringRefERKSt6vectorIT_T0_E")
  //</editor-fold>
  public static StringRef bytes(final /*const*/ std.vectorULong /*&*/ v) {
    if (v.empty()) {
      return new StringRef();
    }
    return new StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, $AddrOf(v.ptr$at(0))), 
        $sizeof_ULong() * v.size());
  }
  //template <typename T = unsigned int, typename Allocator = allocator<unsigned int>> 
  //<editor-fold defaultstate="collapsed" desc="bytes">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 69,
   FQN="bytes", NM="_ZL5bytesIjSaIjEEN4llvm9StringRefERKSt6vectorIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL5bytesIjSaIjEEN4llvm9StringRefERKSt6vectorIT_T0_E")
  //</editor-fold>
  public static StringRef bytes(final /*const*/ std.vectorUInt /*&*/ v) {
    if (v.empty()) {
      return new StringRef();
    }
    return new StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, $AddrOf(v.ptr$at(0))), 
        $sizeof_UInt() * v.size());
  }
  public static StringRef bytes(final /*const*/ SmallVectorUInt /*&*/ v) {
    if (v.empty()) {
      return new StringRef();
    }
    return new StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, $AddrOf(v.ptr$at(0))), 
        $sizeof_UInt() * v.size());
  }
  //template <typename T = DeclOffset, typename Allocator = allocator<DeclOffset>> 
  //<editor-fold defaultstate="collapsed" desc="bytes">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 69,
   FQN="bytes", NM="_ZL5bytesIN5clang13serialization10DeclOffsetESaIS2_EEN4llvm9StringRefERKSt6vectorIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL5bytesIN5clang13serialization10DeclOffsetESaIS2_EEN4llvm9StringRefERKSt6vectorIT_T0_E")
  //</editor-fold>
  public static </*typename*/ T extends SizeofCapable & ToByteArray> StringRef bytes(final /*const*/std.vector<T> /*&*/ v) {
    if (v.empty()) {
      return new StringRef();
    }
    int size_t = v.$at(0).$sizeof();
    char$ptr ret = create_char$ptr(new byte[v.size()*size_t]);
    char$ptr res = $Clone(ret);
    for(int i = 0; i < v.size(); i++) {
      byte[] object = v.$at(i).toByteArray();
      for(int j = 0; j < object.length; j++) {
        res.$set(object[j]);
        res.$postInc();
      }
    }
    return new StringRef(ret, v.size()*size_t);
    //return StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, v.data()), Native.$star(T.$sizeof(), v.size()));
  }
  //template <typename T = DeclOffset, typename Allocator = allocator<DeclOffset>> 
  //<editor-fold defaultstate="collapsed" desc="bytes">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 69,
   FQN="bytes", NM="_ZL5bytesIN5clang13serialization10DeclOffsetESaIS2_EEN4llvm9StringRefERKSt6vectorIT_T0_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL5bytesIN5clang13serialization10DeclOffsetESaIS2_EEN4llvm9StringRefERKSt6vectorIT_T0_E")
  //</editor-fold>
  public static </*typename*/ T extends SizeofCapable & ToByteArray> StringRef bytes(final /*const*/SmallVector<T> /*&*/ v) {
    if (v.empty()) {
      return new StringRef();
    }
    int size_t = v.$at(0).$sizeof();
    char$ptr ret = create_char$ptr(new byte[v.size()*size_t]);
    char$ptr res = $Clone(ret);
    for(int i = 0; i < v.size(); i++) {
      byte[] object = v.$at(i).toByteArray();
      for(int j = 0; j < object.length; j++) {
        res.$set(object[j]);
        res.$postInc();
      }
    }
    return new StringRef(ret, v.size()*size_t);
    //return StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, v.data()), Native.$star(T.$sizeof(), v.size()));
  }  
//  /*template <typename T, typename Allocator> TEMPLATE*/
//  //<editor-fold defaultstate="collapsed" desc="bytes">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 69,
//   FQN="bytes", NM="Tpl__ZL5bytesRKSt6vectorIT_T0_E",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=Tpl__ZL5bytesRKSt6vectorIT_T0_E")
//  //</editor-fold>
//  public static </*typename*/ T, /*typename*/ Allocator> StringRef bytes(final /*const*/ std.vector<T, Allocator> /*&*/ v) {
//    if (v.empty()) {
//      return new StringRef();
//    }
//    return StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, Native.$addr(v[0])), Native.$star($sizeof_T(), v.size()));
//  }

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="bytes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 76,
 FQN="bytes", NM="Tpl__ZL5bytesRKN4llvm15SmallVectorImplIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=Tpl__ZL5bytesRKN4llvm15SmallVectorImplIT_EE")
//</editor-fold>
public static </*typename*/ T extends SizeofCapable & ToByteArray> StringRef bytes(final /*const*/ SmallVectorImpl<T> /*&*/ v) {
    if (v.empty()) {
      return new StringRef();
    }
    int size_t = v.$at(0).$sizeof();
    char$ptr ret = create_char$ptr(new byte[v.size()*size_t]);
    char$ptr res = $Clone(ret);
    for(int i = 0; i < v.size(); i++) {
      byte[] object = v.$at(i).toByteArray();
      for(int j = 0; j < object.length; j++) {
        res.$set(object[j]);
        res.$postInc();
      }
    }
    return new StringRef(ret, v.size()*size_t);
   //return StringRef(reinterpret_cast(/*const*/char$ptr/*char P*/ .class, v.data()), Native.$star(T.$sizeof(), v.size()));
}

//<editor-fold defaultstate="collapsed" desc="addExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 235,
 FQN="addExceptionSpec", NM="_ZL16addExceptionSpecPKN5clang17FunctionProtoTypeERNS_15ASTRecordWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL16addExceptionSpecPKN5clang17FunctionProtoTypeERNS_15ASTRecordWriterE")
//</editor-fold>
public static void addExceptionSpec(/*const*/ FunctionProtoType /*P*/ T, 
                final ASTRecordWriter /*&*/ Record) {
  Record.push_back(T.getExceptionSpecType().getValue());
  if (T.getExceptionSpecType() == ExceptionSpecificationType.EST_Dynamic) {
    Record.push_back($uint2ulong(T.getNumExceptions()));
    for (/*uint*/int I = 0, N = T.getNumExceptions(); I != N; ++I)  {
      Record.AddTypeRef(T.getExceptionType(I));
    }
  } else if (T.getExceptionSpecType() == ExceptionSpecificationType.EST_ComputedNoexcept) {
    Record.AddStmt(T.getNoexceptExpr());
  } else if (T.getExceptionSpecType() == ExceptionSpecificationType.EST_Uninstantiated) {
    Record.AddDeclRef(T.getExceptionSpecDecl());
    Record.AddDeclRef(T.getExceptionSpecTemplate());
  } else if (T.getExceptionSpecType() == ExceptionSpecificationType.EST_Unevaluated) {
    Record.AddDeclRef(T.getExceptionSpecDecl());
  }
}


//===----------------------------------------------------------------------===//
// ASTWriter Implementation
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="EmitBlockID">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 751,
 FQN="EmitBlockID", NM="_ZL11EmitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL11EmitBlockIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE")
//</editor-fold>
public static void EmitBlockID(/*uint*/int ID, /*const*/char$ptr/*char P*/ Name, 
           final BitstreamWriter /*&*/ Stream, 
           final SmallVectorImplULong /*&*/ Record) {
  Record.clear();
  Record.push_back($uint2ullong(ID));
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_SETBID.getValue(), Record);
  
  // Emit the block name if present.
  if (!Native.$bool(Name) || Name.$at(0) == 0) {
    return;
  }
  Record.clear();
  Name = $Clone(Name);
  while ((Name.$star() != 0)) {
    Record.push_back($char2ullong(Name.$postInc().$star()));
  }
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_BLOCKNAME.getValue(), Record);
}

//<editor-fold defaultstate="collapsed" desc="EmitRecordID">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 767,
 FQN="EmitRecordID", NM="_ZL12EmitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL12EmitRecordIDjPKcRN4llvm15BitstreamWriterERNS1_15SmallVectorImplIyEE")
//</editor-fold>
public static void EmitRecordID(/*uint*/int ID, /*const*/char$ptr/*char P*/ Name, 
            final BitstreamWriter /*&*/ Stream, 
            final SmallVectorImplULong /*&*/ Record) {
  Record.clear();
  Record.push_back($uint2ullong(ID));
  Name = $Clone(Name);
  while ((Name.$star() != 0)) {
    Record.push_back($char2ullong(Name.$postInc().$star()));
  }
  Stream.EmitRecord(BlockInfoCodes.BLOCKINFO_CODE_SETRECORDNAME.getValue(), Record);
}

//<editor-fold defaultstate="collapsed" desc="AddStmtsExprs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 777,
 FQN="AddStmtsExprs", NM="_ZL13AddStmtsExprsRN4llvm15BitstreamWriterERNS_15SmallVectorImplIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL13AddStmtsExprsRN4llvm15BitstreamWriterERNS_15SmallVectorImplIyEE")
//</editor-fold>
public static void AddStmtsExprs(final BitstreamWriter /*&*/ Stream, 
             final SmallVectorImplULong /*&*/ Record) {
  EmitRecordID(StmtCode.STMT_STOP, $("STMT_STOP"), Stream, Record);
  EmitRecordID(StmtCode.STMT_NULL_PTR, $("STMT_NULL_PTR"), Stream, Record);
  EmitRecordID(StmtCode.STMT_REF_PTR, $("STMT_REF_PTR"), Stream, Record);
  EmitRecordID(StmtCode.STMT_NULL, $("STMT_NULL"), Stream, Record);
  EmitRecordID(StmtCode.STMT_COMPOUND, $("STMT_COMPOUND"), Stream, Record);
  EmitRecordID(StmtCode.STMT_CASE, $("STMT_CASE"), Stream, Record);
  EmitRecordID(StmtCode.STMT_DEFAULT, $("STMT_DEFAULT"), Stream, Record);
  EmitRecordID(StmtCode.STMT_LABEL, $("STMT_LABEL"), Stream, Record);
  EmitRecordID(StmtCode.STMT_ATTRIBUTED, $("STMT_ATTRIBUTED"), Stream, Record);
  EmitRecordID(StmtCode.STMT_IF, $("STMT_IF"), Stream, Record);
  EmitRecordID(StmtCode.STMT_SWITCH, $("STMT_SWITCH"), Stream, Record);
  EmitRecordID(StmtCode.STMT_WHILE, $("STMT_WHILE"), Stream, Record);
  EmitRecordID(StmtCode.STMT_DO, $("STMT_DO"), Stream, Record);
  EmitRecordID(StmtCode.STMT_FOR, $("STMT_FOR"), Stream, Record);
  EmitRecordID(StmtCode.STMT_GOTO, $("STMT_GOTO"), Stream, Record);
  EmitRecordID(StmtCode.STMT_INDIRECT_GOTO, $("STMT_INDIRECT_GOTO"), Stream, Record);
  EmitRecordID(StmtCode.STMT_CONTINUE, $("STMT_CONTINUE"), Stream, Record);
  EmitRecordID(StmtCode.STMT_BREAK, $("STMT_BREAK"), Stream, Record);
  EmitRecordID(StmtCode.STMT_RETURN, $("STMT_RETURN"), Stream, Record);
  EmitRecordID(StmtCode.STMT_DECL, $("STMT_DECL"), Stream, Record);
  EmitRecordID(StmtCode.STMT_GCCASM, $("STMT_GCCASM"), Stream, Record);
  EmitRecordID(StmtCode.STMT_MSASM, $("STMT_MSASM"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_PREDEFINED, $("EXPR_PREDEFINED"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_DECL_REF, $("EXPR_DECL_REF"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_INTEGER_LITERAL, $("EXPR_INTEGER_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_FLOATING_LITERAL, $("EXPR_FLOATING_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_IMAGINARY_LITERAL, $("EXPR_IMAGINARY_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_STRING_LITERAL, $("EXPR_STRING_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CHARACTER_LITERAL, $("EXPR_CHARACTER_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_PAREN, $("EXPR_PAREN"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_PAREN_LIST, $("EXPR_PAREN_LIST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_UNARY_OPERATOR, $("EXPR_UNARY_OPERATOR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_SIZEOF_ALIGN_OF, $("EXPR_SIZEOF_ALIGN_OF"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_ARRAY_SUBSCRIPT, $("EXPR_ARRAY_SUBSCRIPT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CALL, $("EXPR_CALL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_MEMBER, $("EXPR_MEMBER"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_BINARY_OPERATOR, $("EXPR_BINARY_OPERATOR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_COMPOUND_ASSIGN_OPERATOR, $("EXPR_COMPOUND_ASSIGN_OPERATOR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CONDITIONAL_OPERATOR, $("EXPR_CONDITIONAL_OPERATOR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_IMPLICIT_CAST, $("EXPR_IMPLICIT_CAST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CSTYLE_CAST, $("EXPR_CSTYLE_CAST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_COMPOUND_LITERAL, $("EXPR_COMPOUND_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_EXT_VECTOR_ELEMENT, $("EXPR_EXT_VECTOR_ELEMENT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_INIT_LIST, $("EXPR_INIT_LIST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_DESIGNATED_INIT, $("EXPR_DESIGNATED_INIT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_DESIGNATED_INIT_UPDATE, $("EXPR_DESIGNATED_INIT_UPDATE"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_IMPLICIT_VALUE_INIT, $("EXPR_IMPLICIT_VALUE_INIT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_NO_INIT, $("EXPR_NO_INIT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_VA_ARG, $("EXPR_VA_ARG"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_ADDR_LABEL, $("EXPR_ADDR_LABEL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_STMT, $("EXPR_STMT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CHOOSE, $("EXPR_CHOOSE"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_GNU_NULL, $("EXPR_GNU_NULL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_SHUFFLE_VECTOR, $("EXPR_SHUFFLE_VECTOR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_BLOCK, $("EXPR_BLOCK"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_GENERIC_SELECTION, $("EXPR_GENERIC_SELECTION"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_STRING_LITERAL, $("EXPR_OBJC_STRING_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_BOXED_EXPRESSION, $("EXPR_OBJC_BOXED_EXPRESSION"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_ARRAY_LITERAL, $("EXPR_OBJC_ARRAY_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_DICTIONARY_LITERAL, $("EXPR_OBJC_DICTIONARY_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_ENCODE, $("EXPR_OBJC_ENCODE"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_SELECTOR_EXPR, $("EXPR_OBJC_SELECTOR_EXPR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_PROTOCOL_EXPR, $("EXPR_OBJC_PROTOCOL_EXPR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_IVAR_REF_EXPR, $("EXPR_OBJC_IVAR_REF_EXPR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_PROPERTY_REF_EXPR, $("EXPR_OBJC_PROPERTY_REF_EXPR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_KVC_REF_EXPR, $("EXPR_OBJC_KVC_REF_EXPR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_MESSAGE_EXPR, $("EXPR_OBJC_MESSAGE_EXPR"), Stream, Record);
  EmitRecordID(StmtCode.STMT_OBJC_FOR_COLLECTION, $("STMT_OBJC_FOR_COLLECTION"), Stream, Record);
  EmitRecordID(StmtCode.STMT_OBJC_CATCH, $("STMT_OBJC_CATCH"), Stream, Record);
  EmitRecordID(StmtCode.STMT_OBJC_FINALLY, $("STMT_OBJC_FINALLY"), Stream, Record);
  EmitRecordID(StmtCode.STMT_OBJC_AT_TRY, $("STMT_OBJC_AT_TRY"), Stream, Record);
  EmitRecordID(StmtCode.STMT_OBJC_AT_SYNCHRONIZED, $("STMT_OBJC_AT_SYNCHRONIZED"), Stream, Record);
  EmitRecordID(StmtCode.STMT_OBJC_AT_THROW, $("STMT_OBJC_AT_THROW"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OBJC_BOOL_LITERAL, $("EXPR_OBJC_BOOL_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.STMT_CXX_CATCH, $("STMT_CXX_CATCH"), Stream, Record);
  EmitRecordID(StmtCode.STMT_CXX_TRY, $("STMT_CXX_TRY"), Stream, Record);
  EmitRecordID(StmtCode.STMT_CXX_FOR_RANGE, $("STMT_CXX_FOR_RANGE"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_OPERATOR_CALL, $("EXPR_CXX_OPERATOR_CALL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_MEMBER_CALL, $("EXPR_CXX_MEMBER_CALL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_CONSTRUCT, $("EXPR_CXX_CONSTRUCT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_TEMPORARY_OBJECT, $("EXPR_CXX_TEMPORARY_OBJECT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_STATIC_CAST, $("EXPR_CXX_STATIC_CAST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_DYNAMIC_CAST, $("EXPR_CXX_DYNAMIC_CAST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_REINTERPRET_CAST, $("EXPR_CXX_REINTERPRET_CAST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_CONST_CAST, $("EXPR_CXX_CONST_CAST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_FUNCTIONAL_CAST, $("EXPR_CXX_FUNCTIONAL_CAST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_USER_DEFINED_LITERAL, $("EXPR_USER_DEFINED_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_STD_INITIALIZER_LIST, $("EXPR_CXX_STD_INITIALIZER_LIST"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_BOOL_LITERAL, $("EXPR_CXX_BOOL_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_NULL_PTR_LITERAL, $("EXPR_CXX_NULL_PTR_LITERAL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_TYPEID_EXPR, $("EXPR_CXX_TYPEID_EXPR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_TYPEID_TYPE, $("EXPR_CXX_TYPEID_TYPE"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_THIS, $("EXPR_CXX_THIS"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_THROW, $("EXPR_CXX_THROW"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_DEFAULT_ARG, $("EXPR_CXX_DEFAULT_ARG"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_DEFAULT_INIT, $("EXPR_CXX_DEFAULT_INIT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_BIND_TEMPORARY, $("EXPR_CXX_BIND_TEMPORARY"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_SCALAR_VALUE_INIT, $("EXPR_CXX_SCALAR_VALUE_INIT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_NEW, $("EXPR_CXX_NEW"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_DELETE, $("EXPR_CXX_DELETE"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_PSEUDO_DESTRUCTOR, $("EXPR_CXX_PSEUDO_DESTRUCTOR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_EXPR_WITH_CLEANUPS, $("EXPR_EXPR_WITH_CLEANUPS"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_DEPENDENT_SCOPE_MEMBER, $("EXPR_CXX_DEPENDENT_SCOPE_MEMBER"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_DEPENDENT_SCOPE_DECL_REF, $("EXPR_CXX_DEPENDENT_SCOPE_DECL_REF"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_UNRESOLVED_CONSTRUCT, $("EXPR_CXX_UNRESOLVED_CONSTRUCT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_UNRESOLVED_MEMBER, $("EXPR_CXX_UNRESOLVED_MEMBER"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_UNRESOLVED_LOOKUP, $("EXPR_CXX_UNRESOLVED_LOOKUP"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_EXPRESSION_TRAIT, $("EXPR_CXX_EXPRESSION_TRAIT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_NOEXCEPT, $("EXPR_CXX_NOEXCEPT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_OPAQUE_VALUE, $("EXPR_OPAQUE_VALUE"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_BINARY_CONDITIONAL_OPERATOR, $("EXPR_BINARY_CONDITIONAL_OPERATOR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_TYPE_TRAIT, $("EXPR_TYPE_TRAIT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_ARRAY_TYPE_TRAIT, $("EXPR_ARRAY_TYPE_TRAIT"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_PACK_EXPANSION, $("EXPR_PACK_EXPANSION"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_SIZEOF_PACK, $("EXPR_SIZEOF_PACK"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_SUBST_NON_TYPE_TEMPLATE_PARM, $("EXPR_SUBST_NON_TYPE_TEMPLATE_PARM"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_SUBST_NON_TYPE_TEMPLATE_PARM_PACK, $("EXPR_SUBST_NON_TYPE_TEMPLATE_PARM_PACK"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_FUNCTION_PARM_PACK, $("EXPR_FUNCTION_PARM_PACK"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_MATERIALIZE_TEMPORARY, $("EXPR_MATERIALIZE_TEMPORARY"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CUDA_KERNEL_CALL, $("EXPR_CUDA_KERNEL_CALL"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_UUIDOF_EXPR, $("EXPR_CXX_UUIDOF_EXPR"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_CXX_UUIDOF_TYPE, $("EXPR_CXX_UUIDOF_TYPE"), Stream, Record);
  EmitRecordID(StmtCode.EXPR_LAMBDA, $("EXPR_LAMBDA"), Stream, Record);
}


/// \brief Prepares a path for being written to an AST file by converting it
/// to an absolute path and removing nested './'s.
///
/// \return \c true if the path was changed.
//<editor-fold defaultstate="collapsed" desc="cleanPathForOutput">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1161,
 FQN="cleanPathForOutput", NM="_ZL18cleanPathForOutputRN5clang11FileManagerERN4llvm15SmallVectorImplIcEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL18cleanPathForOutputRN5clang11FileManagerERN4llvm15SmallVectorImplIcEE")
//</editor-fold>
public static boolean cleanPathForOutput(final FileManager /*&*/ FileMgr, 
                  final SmallString/*&*/ Path) {
  boolean Changed = FileMgr.makeAbsolutePath(Path);
  return Changed || path.remove_dots(Path);
}


/// \brief Adjusts the given filename to only write out the portion of the
/// filename that is not part of the system root directory.
///
/// \param Filename the file name to adjust.
///
/// \param BaseDir When non-NULL, the PCH file is a relocatable AST file and
/// the returned filename will be adjusted by this root directory.
///
/// \returns either the original filename (if it needs no adjustment) or the
/// adjusted filename (which points into the @p Filename parameter).
//<editor-fold defaultstate="collapsed" desc="adjustFilenameForRelocatableAST">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1177,
 FQN="adjustFilenameForRelocatableAST", NM="_ZL31adjustFilenameForRelocatableASTPKcN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL31adjustFilenameForRelocatableASTPKcN4llvm9StringRefE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ adjustFilenameForRelocatableAST(/*const*/char$ptr/*char P*/ Filename, StringRef BaseDir) {
  assert (Native.$bool(Filename)) : "No file name to adjust?";
  if (BaseDir.empty()) {
    return Filename;
  }
  
  // Verify that the filename and the system root have the same prefix.
  /*uint*/int Pos = 0;
  for (; (Filename.$at(Pos) != 0) && $less_uint(Pos, BaseDir.size()); ++Pos)  {
    if (Filename.$at(Pos) != BaseDir.$at(Pos)) {
      return Filename; // Prefixes don't match.
    }
  }
  
  // We hit the end of the filename before we hit the end of the system root.
  if (!(Filename.$at(Pos) != 0)) {
    return Filename;
  }
  
  // If there's not a path separator at the end of the base directory nor
  // immediately after it, then this isn't within the base directory.
  if (!path.is_separator(Filename.$at(Pos))) {
    if (!path.is_separator(BaseDir.back())) {
      return Filename;
    }
  } else {
    // If the file name has a '/' at the current position, skip over the '/'.
    // We distinguish relative paths from absolute paths by the
    // absence of '/' at the beginning of relative paths.
    //
    // FIXME: This is wrong. We distinguish them by asking if the path is
    // absolute, which isn't the same thing. And there might be multiple '/'s
    // in a row. Use a better mechanism to indicate whether we have emitted an
    // absolute or relative path.
    ++Pos;
  }
  
  return Filename.$add(Pos);
}

//<editor-fold defaultstate="collapsed" desc="getSignature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1214,
 FQN="getSignature", NM="_ZL12getSignaturev",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL12getSignaturev")
//</editor-fold>
public static /*uint*/int getSignature() {
  while (true) {
    {
      /*uint*/int S = org.llvm.support.sys.Process.GetRandomNumber();
      if ((S != 0)) {
        return S;
      }
    }
    // Rely on GetRandomNumber to eventually return non-zero...
  }
}


//===----------------------------------------------------------------------===//
// Source Manager Serialization
//===----------------------------------------------------------------------===//

/// \brief Create an abbreviation for the SLocEntry that refers to a
/// file.
//<editor-fold defaultstate="collapsed" desc="CreateSLocFileAbbrev">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1641,
 FQN="CreateSLocFileAbbrev", NM="_ZL20CreateSLocFileAbbrevRN4llvm15BitstreamWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL20CreateSLocFileAbbrevRN4llvm15BitstreamWriterE")
//</editor-fold>
public static /*uint*/int CreateSLocFileAbbrev(final BitstreamWriter /*&*/ Stream) {
  //JAVA: using namespace llvm;
  
  BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
  Abbrev.Add(new BitCodeAbbrevOp(SourceManagerRecordTypes.SM_SLOC_FILE_ENTRY));
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // Offset
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // Include location
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(2))); // Characteristic
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Line directives
  // FileEntry fields.
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Input File ID
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // NumCreatedFIDs
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(24))); // FirstDeclIndex
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // NumDecls
  return Stream.EmitAbbrev(Abbrev);
}


/// \brief Create an abbreviation for the SLocEntry that refers to a
/// buffer.
//<editor-fold defaultstate="collapsed" desc="CreateSLocBufferAbbrev">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1660,
 FQN="CreateSLocBufferAbbrev", NM="_ZL22CreateSLocBufferAbbrevRN4llvm15BitstreamWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL22CreateSLocBufferAbbrevRN4llvm15BitstreamWriterE")
//</editor-fold>
public static /*uint*/int CreateSLocBufferAbbrev(final BitstreamWriter /*&*/ Stream) {
  //JAVA: using namespace llvm;
  
  BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
  Abbrev.Add(new BitCodeAbbrevOp(SourceManagerRecordTypes.SM_SLOC_BUFFER_ENTRY));
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // Offset
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // Include location
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(2))); // Characteristic
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Fixed, $int2ulong(1))); // Line directives
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Buffer name blob
  return Stream.EmitAbbrev(Abbrev);
}


/// \brief Create an abbreviation for the SLocEntry that refers to a
/// buffer's blob.
//<editor-fold defaultstate="collapsed" desc="CreateSLocBufferBlobAbbrev">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1675,
 FQN="CreateSLocBufferBlobAbbrev", NM="_ZL26CreateSLocBufferBlobAbbrevRN4llvm15BitstreamWriterEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL26CreateSLocBufferBlobAbbrevRN4llvm15BitstreamWriterEb")
//</editor-fold>
public static /*uint*/int CreateSLocBufferBlobAbbrev(final BitstreamWriter /*&*/ Stream, 
                          boolean Compressed) {
  //JAVA: using namespace llvm;
  
  BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
  Abbrev.Add(new BitCodeAbbrevOp((Compressed ? SourceManagerRecordTypes.SM_SLOC_BUFFER_BLOB_COMPRESSED : SourceManagerRecordTypes.SM_SLOC_BUFFER_BLOB)));
  if (Compressed) {
    Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // Uncompressed size
  }
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.Blob)); // Blob
  return Stream.EmitAbbrev(Abbrev);
}


/// \brief Create an abbreviation for the SLocEntry that refers to a macro
/// expansion.
//<editor-fold defaultstate="collapsed" desc="CreateSLocExpansionAbbrev">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 1690,
 FQN="CreateSLocExpansionAbbrev", NM="_ZL25CreateSLocExpansionAbbrevRN4llvm15BitstreamWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL25CreateSLocExpansionAbbrevRN4llvm15BitstreamWriterE")
//</editor-fold>
public static /*uint*/int CreateSLocExpansionAbbrev(final BitstreamWriter /*&*/ Stream) {
  //JAVA: using namespace llvm;
  
  BitCodeAbbrev /*P*/ Abbrev = new BitCodeAbbrev();
  Abbrev.Add(new BitCodeAbbrevOp(SourceManagerRecordTypes.SM_SLOC_EXPANSION_ENTRY));
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // Offset
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // Spelling location
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // Start location
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(8))); // End location
  Abbrev.Add(new BitCodeAbbrevOp(BitCodeAbbrevOp.Encoding.VBR, $int2ulong(6))); // Token length
  return Stream.EmitAbbrev(Abbrev);
}


//===----------------------------------------------------------------------===//
// Preprocessor Serialization
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="shouldIgnoreMacro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2109,
 FQN="shouldIgnoreMacro", NM="_ZL17shouldIgnoreMacroPN5clang14MacroDirectiveEbRKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL17shouldIgnoreMacroPN5clang14MacroDirectiveEbRKNS_12PreprocessorE")
//</editor-fold>
public static boolean shouldIgnoreMacro(MacroDirective /*P*/ MD, boolean IsModule, 
                 final /*const*/ Preprocessor /*&*/ PP) {
  {
    MacroInfo /*P*/ MI = MD.getMacroInfo();
    if ((MI != null)) {
      if (MI.isBuiltinMacro()) {
        return true;
      }
    }
  }
  if (IsModule) {
    SourceLocation Loc = MD.getLocation();
    if (Loc.isInvalid()) {
      return true;
    }
    if (PP.getSourceManager().getFileID(/*NO_COPY*/Loc).$eq(PP.getPredefinesFileID())) {
      return true;
    }
  }
  
  return false;
}


/// \brief Compute the number of modules within the given tree (including the
/// given module).
//<editor-fold defaultstate="collapsed" desc="getNumberOfModules">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 2439,
 FQN="getNumberOfModules", NM="_ZL18getNumberOfModulesPN5clang6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL18getNumberOfModulesPN5clang6ModuleE")
//</editor-fold>
public static /*uint*/int getNumberOfModules(Module /*P*/ Mod) {
  /*uint*/int ChildModules = 0;
  for (StdVector.iterator<Module> Sub = Mod.submodule_begin(), SubEnd = Mod.submodule_end();
       $noteq___normal_iterator$C(Sub, SubEnd); Sub.$preInc())  {
    ChildModules += getNumberOfModules(Sub.$star());
  }
  
  return ChildModules + 1;
}


//===----------------------------------------------------------------------===//
// Identifier Table Serialization
//===----------------------------------------------------------------------===//

/// Determine the declaration that should be put into the name lookup table to
/// represent the given declaration in this module. This is usually D itself,
/// but if D was imported and merged into a local declaration, we want the most
/// recent local declaration instead. The chosen declaration will be the most
/// recent declaration in any module that imports this one.
//<editor-fold defaultstate="collapsed" desc="getDeclForLocalLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 3102,
 FQN="getDeclForLocalLookup", NM="_ZL21getDeclForLocalLookupRKN5clang11LangOptionsEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL21getDeclForLocalLookupRKN5clang11LangOptionsEPNS_9NamedDeclE")
//</editor-fold>
public static NamedDecl /*P*/ getDeclForLocalLookup(final /*const*/ LangOptions /*&*/ LangOpts, 
                     NamedDecl /*P*/ D) {
  if (!LangOpts.Modules || !D.isFromASTFile()) {
    return D;
  }
  {
    
    Decl /*P*/ Redecl = D.getPreviousDecl$Decl();
    if ((Redecl != null)) {
      // For Redeclarable decls, a prior declaration might be local.
      for (; (Redecl != null); Redecl = Redecl.getPreviousDecl$Decl()) {
        // If we find a local decl, we're done.
        if (!Redecl.isFromASTFile()) {
          // Exception: in very rare cases (for injected-class-names), not all
          // redeclarations are in the same semantic context. Skip ones in a
          // different context. They don't go in this lookup table at all.
          if (!Redecl.getDeclContext().getRedeclContext().Equals(D.getDeclContext().getRedeclContext())) {
            continue;
          }
          return cast_NamedDecl(Redecl);
        }
        
        // If we find a decl from a (chained-)PCH stop since we won't find a
        // local one.
        if (Redecl.getOwningModuleID() == 0) {
          break;
        }
      }
    } else {
      Decl /*P*/ First = D.getCanonicalDecl();
      if ((First != null)) {
        // For Mergeable decls, the first decl might be local.
        if (!First.isFromASTFile()) {
          return cast_NamedDecl(First);
        }
      }
    }
  }
  
  // All declarations are imported. Our most recent declaration will also be
  // the most recent one in anyone who imports us.
  return D;
}

//template <typename Vector = LazyVector<VarDecl *, ExternalSemaSource, &clang::ExternalSemaSource::ReadTentativeDefinitions, 2, 2>> 
//<editor-fold defaultstate="collapsed" desc="AddLazyVectorDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 4143,
 FQN="AddLazyVectorDecls", NM="_ZL18AddLazyVectorDeclsIN5clang10LazyVectorIPNS0_7VarDeclENS0_18ExternalSemaSourceEXadL_ZNS4_24ReadTentativeDefinitionsERN4llvm15SmallVectorImplIS3_EEEELj2ELj2EEEEvRNS0_9ASTWriterERT_RNS5_11SmallVectorIyLj64EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL18AddLazyVectorDeclsIN5clang10LazyVectorIPNS0_7VarDeclENS0_18ExternalSemaSourceEXadL_ZNS4_24ReadTentativeDefinitionsERN4llvm15SmallVectorImplIS3_EEEELj2ELj2EEEEvRNS0_9ASTWriterERT_RNS5_11SmallVectorIyLj64EEE")
//</editor-fold>
public static <T extends Decl> void AddLazyVectorDecls(final ASTWriter /*&*/ Writer, final LazyVector<T /*P*/ , ExternalSemaSource> Vec, 
                  final SmallVectorULong /*&*/ Record) {
  for (LazyVector.iterator I =  Vec.begin(null, true), E = Vec.end();
       I.$noteq(E); I.$preInc()) {
    Writer.AddDeclRef((Decl)I.$star(), Record);
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitCXXBaseSpecifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5410,
 FQN="EmitCXXBaseSpecifiers", NM="_ZL21EmitCXXBaseSpecifiersRN5clang9ASTWriterEN4llvm8ArrayRefINS_16CXXBaseSpecifierEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL21EmitCXXBaseSpecifiersRN5clang9ASTWriterEN4llvm8ArrayRefINS_16CXXBaseSpecifierEEE")
//</editor-fold>
public static long/*uint64_t*/ EmitCXXBaseSpecifiers(final ASTWriter /*&*/ W, 
                     ArrayRef<CXXBaseSpecifier> Bases) {
  ASTRecordWriter Writer = null;
  try {
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    Writer/*J*/= new ASTRecordWriter(W, Record);
    Writer.push_back($uint2ulong(Bases.size()));
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : Bases)  {
      Writer.AddCXXBaseSpecifier(Base);
    }
    
    return Writer.Emit(DeclCode.DECL_CXX_BASE_SPECIFIERS);
  } finally {
    if (Writer != null) { Writer.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="EmitCXXCtorInitializers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5427,
 FQN="EmitCXXCtorInitializers", NM="_ZL23EmitCXXCtorInitializersRN5clang9ASTWriterEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL23EmitCXXCtorInitializersRN5clang9ASTWriterEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE")
//</editor-fold>
public static long/*uint64_t*/ EmitCXXCtorInitializers(final ASTWriter /*&*/ W, 
                       ArrayRef<CXXCtorInitializer /*P*/ > CtorInits) {
  ASTRecordWriter Writer = null;
  try {
    SmallVectorULong Record/*J*/= new SmallVectorULong(64, (long/*uint64_t*/)0);
    Writer/*J*/= new ASTRecordWriter(W, Record);
    Writer.push_back($uint2ulong(CtorInits.size()));
    
    for (CXXCtorInitializer /*P*/ Init : CtorInits) {
      if (Init.isBaseInitializer()) {
        Writer.push_back(CtorInitializerType.CTOR_INITIALIZER_BASE);
        Writer.AddTypeSourceInfo(Init.getTypeSourceInfo());
        Writer.push_back((Init.isBaseVirtual() ? 1 : 0));
      } else if (Init.isDelegatingInitializer()) {
        Writer.push_back(CtorInitializerType.CTOR_INITIALIZER_DELEGATING);
        Writer.AddTypeSourceInfo(Init.getTypeSourceInfo());
      } else if (Init.isMemberInitializer()) {
        Writer.push_back(CtorInitializerType.CTOR_INITIALIZER_MEMBER);
        Writer.AddDeclRef(Init.getMember());
      } else {
        Writer.push_back(CtorInitializerType.CTOR_INITIALIZER_INDIRECT_MEMBER);
        Writer.AddDeclRef(Init.getIndirectMember());
      }
      
      Writer.AddSourceLocation(Init.getMemberLocation());
      Writer.AddStmt(Init.getInit());
      Writer.AddSourceLocation(Init.getLParenLoc());
      Writer.AddSourceLocation(Init.getRParenLoc());
      Writer.push_back((Init.isWritten() ? 1 : 0));
      if (Init.isWritten()) {
        Writer.push_back($int2ulong(Init.getSourceOrder()));
      } else {
        Writer.push_back($uint2ulong(Init.getNumArrayIndices()));
        for (VarDecl /*P*/ VD : Init.getArrayIndices())  {
          Writer.AddDeclRef(VD);
        }
      }
    }
    
    return Writer.Emit(DeclCode.DECL_CXX_CTOR_INITIALIZERS);
  } finally {
    if (Writer != null) { Writer.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="isImportedDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp", line = 5657,
 FQN="isImportedDeclContext", NM="_ZL21isImportedDeclContextPN5clang9ASTReaderEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTWriter.cpp -nm=_ZL21isImportedDeclContextPN5clang9ASTReaderEPKNS_4DeclE")
//</editor-fold>
public static boolean isImportedDeclContext(ASTReader /*P*/ Chain, /*const*/ Decl /*P*/ D) {
  if (D.isFromASTFile()) {
    return true;
  }
  
  // The predefined __va_list_tag struct is imported if we imported any decls.
  // FIXME: This is a gross hack.
  return D == D.getASTContext().getVaListTagDecl();
}

} // END OF class ASTWriterStatics
