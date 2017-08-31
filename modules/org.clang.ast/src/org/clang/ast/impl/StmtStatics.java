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
package org.clang.ast.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstMemberPointers.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type StmtStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=Tpl__ZN12_GLOBAL__N_118getSourceRangeImplEPKN5clang4StmtEMS1_KFNS0_11SourceRangeEvE;Tpl__ZN12_GLOBAL__N_118getSourceRangeImplEPKN5clang4StmtEMT0_KFNS0_11SourceRangeEvE;Tpl__ZN12_GLOBAL__N_119implements_childrenEMT_FN4llvm14iterator_rangeIN5clang12StmtIteratorEEEvE;Tpl__ZN12_GLOBAL__N_120implements_getLocEndEMT_KFN5clang14SourceLocationEvE;Tpl__ZN12_GLOBAL__N_122implements_getLocStartEMT_KFN5clang14SourceLocationEvE;_ZL13StmtClassInfo;_ZL15copyIntoContextRKN5clang10ASTContextEN4llvm9StringRefE;_ZL21check_implementationsv;_ZL21getStmtInfoTableEntryN5clang4Stmt9StmtClassE;_ZN12_GLOBAL__N_1L19implements_childrenEMN5clang4StmtEFN4llvm14iterator_rangeINS0_12StmtIteratorEEEvE;_ZN12_GLOBAL__N_1L20implements_getLocEndEMN5clang4StmtEKFNS0_14SourceLocationEvE;_ZN12_GLOBAL__N_1L22implements_getLocStartEMN5clang4StmtEKFNS0_14SourceLocationEvE;_ZN12_GLOBAL__N_1L7is_goodENS_4goodE; -static-type=StmtStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class StmtStatics {

//<editor-fold defaultstate="collapsed" desc="StmtClassInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 31,
 FQN="StmtClassInfo", NM="_ZL13StmtClassInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZL13StmtClassInfo")
//</editor-fold>
public static  StmtClassNameTable StmtClassInfo[/*182*/]/*J*/= new$T(new  StmtClassNameTable [182], ()->new  StmtClassNameTable());
//<editor-fold defaultstate="collapsed" desc="getStmtInfoTableEntry">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*sizeof*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 37,
 FQN="getStmtInfoTableEntry", NM="_ZL21getStmtInfoTableEntryN5clang4Stmt9StmtClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZL21getStmtInfoTableEntryN5clang4Stmt9StmtClassE")
//</editor-fold>
public static StmtClassNameTable /*&*/ getStmtInfoTableEntry(Stmt.StmtClass E) {
  /*static*/ boolean Initialized = getStmtInfoTableEntry$$.Initialized;
  if (Initialized) {
    return StmtClassInfo[E.getValue()];
  }
  
  // Intialize the table on the first use.
  Initialized = getStmtInfoTableEntry$$.Initialized = true;
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.GCCAsmStmtClass.getValue()].Name = $tryClone($("GCCAsmStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.GCCAsmStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__GCCAsmStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MSAsmStmtClass.getValue()].Name = $tryClone($("MSAsmStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MSAsmStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__MSAsmStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.AttributedStmtClass.getValue()].Name = $tryClone($("AttributedStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.AttributedStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__AttributedStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.BreakStmtClass.getValue()].Name = $tryClone($("BreakStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.BreakStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__BreakStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXCatchStmtClass.getValue()].Name = $tryClone($("CXXCatchStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXCatchStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXCatchStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXForRangeStmtClass.getValue()].Name = $tryClone($("CXXForRangeStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXForRangeStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXForRangeStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXTryStmtClass.getValue()].Name = $tryClone($("CXXTryStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXTryStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXTryStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CapturedStmtClass.getValue()].Name = $tryClone($("CapturedStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CapturedStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CapturedStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CompoundStmtClass.getValue()].Name = $tryClone($("CompoundStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CompoundStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CompoundStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ContinueStmtClass.getValue()].Name = $tryClone($("ContinueStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ContinueStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ContinueStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CoreturnStmtClass.getValue()].Name = $tryClone($("CoreturnStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CoreturnStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CoreturnStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CoroutineBodyStmtClass.getValue()].Name = $tryClone($("CoroutineBodyStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CoroutineBodyStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CoroutineBodyStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DeclStmtClass.getValue()].Name = $tryClone($("DeclStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DeclStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__DeclStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DoStmtClass.getValue()].Name = $tryClone($("DoStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DoStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__DoStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.BinaryConditionalOperatorClass.getValue()].Name = $tryClone($("BinaryConditionalOperator"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.BinaryConditionalOperatorClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__BinaryConditionalOperator();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ConditionalOperatorClass.getValue()].Name = $tryClone($("ConditionalOperator"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ConditionalOperatorClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ConditionalOperator();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.AddrLabelExprClass.getValue()].Name = $tryClone($("AddrLabelExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.AddrLabelExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__AddrLabelExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ArraySubscriptExprClass.getValue()].Name = $tryClone($("ArraySubscriptExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ArraySubscriptExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ArraySubscriptExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ArrayTypeTraitExprClass.getValue()].Name = $tryClone($("ArrayTypeTraitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ArrayTypeTraitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ArrayTypeTraitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.AsTypeExprClass.getValue()].Name = $tryClone($("AsTypeExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.AsTypeExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__AsTypeExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.AtomicExprClass.getValue()].Name = $tryClone($("AtomicExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.AtomicExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__AtomicExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.BinaryOperatorClass.getValue()].Name = $tryClone($("BinaryOperator"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.BinaryOperatorClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__BinaryOperator();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CompoundAssignOperatorClass.getValue()].Name = $tryClone($("CompoundAssignOperator"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CompoundAssignOperatorClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CompoundAssignOperator();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.BlockExprClass.getValue()].Name = $tryClone($("BlockExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.BlockExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__BlockExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXBindTemporaryExprClass.getValue()].Name = $tryClone($("CXXBindTemporaryExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXBindTemporaryExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXBindTemporaryExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXBoolLiteralExprClass.getValue()].Name = $tryClone($("CXXBoolLiteralExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXBoolLiteralExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXBoolLiteralExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXConstructExprClass.getValue()].Name = $tryClone($("CXXConstructExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXConstructExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXConstructExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXTemporaryObjectExprClass.getValue()].Name = $tryClone($("CXXTemporaryObjectExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXTemporaryObjectExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXTemporaryObjectExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDefaultArgExprClass.getValue()].Name = $tryClone($("CXXDefaultArgExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDefaultArgExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXDefaultArgExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDefaultInitExprClass.getValue()].Name = $tryClone($("CXXDefaultInitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDefaultInitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXDefaultInitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDeleteExprClass.getValue()].Name = $tryClone($("CXXDeleteExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDeleteExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXDeleteExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDependentScopeMemberExprClass.getValue()].Name = $tryClone($("CXXDependentScopeMemberExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDependentScopeMemberExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXDependentScopeMemberExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXFoldExprClass.getValue()].Name = $tryClone($("CXXFoldExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXFoldExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXFoldExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXInheritedCtorInitExprClass.getValue()].Name = $tryClone($("CXXInheritedCtorInitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXInheritedCtorInitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXInheritedCtorInitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXNewExprClass.getValue()].Name = $tryClone($("CXXNewExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXNewExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXNewExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXNoexceptExprClass.getValue()].Name = $tryClone($("CXXNoexceptExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXNoexceptExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXNoexceptExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXNullPtrLiteralExprClass.getValue()].Name = $tryClone($("CXXNullPtrLiteralExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXNullPtrLiteralExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXNullPtrLiteralExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXPseudoDestructorExprClass.getValue()].Name = $tryClone($("CXXPseudoDestructorExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXPseudoDestructorExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXPseudoDestructorExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXScalarValueInitExprClass.getValue()].Name = $tryClone($("CXXScalarValueInitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXScalarValueInitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXScalarValueInitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXStdInitializerListExprClass.getValue()].Name = $tryClone($("CXXStdInitializerListExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXStdInitializerListExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXStdInitializerListExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXThisExprClass.getValue()].Name = $tryClone($("CXXThisExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXThisExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXThisExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXThrowExprClass.getValue()].Name = $tryClone($("CXXThrowExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXThrowExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXThrowExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXTypeidExprClass.getValue()].Name = $tryClone($("CXXTypeidExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXTypeidExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXTypeidExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXUnresolvedConstructExprClass.getValue()].Name = $tryClone($("CXXUnresolvedConstructExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXUnresolvedConstructExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXUnresolvedConstructExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXUuidofExprClass.getValue()].Name = $tryClone($("CXXUuidofExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXUuidofExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXUuidofExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CallExprClass.getValue()].Name = $tryClone($("CallExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CallExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CallExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CUDAKernelCallExprClass.getValue()].Name = $tryClone($("CUDAKernelCallExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CUDAKernelCallExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CUDAKernelCallExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXMemberCallExprClass.getValue()].Name = $tryClone($("CXXMemberCallExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXMemberCallExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXMemberCallExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXOperatorCallExprClass.getValue()].Name = $tryClone($("CXXOperatorCallExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXOperatorCallExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXOperatorCallExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UserDefinedLiteralClass.getValue()].Name = $tryClone($("UserDefinedLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UserDefinedLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__UserDefinedLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CStyleCastExprClass.getValue()].Name = $tryClone($("CStyleCastExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CStyleCastExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CStyleCastExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXFunctionalCastExprClass.getValue()].Name = $tryClone($("CXXFunctionalCastExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXFunctionalCastExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXFunctionalCastExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXConstCastExprClass.getValue()].Name = $tryClone($("CXXConstCastExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXConstCastExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXConstCastExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDynamicCastExprClass.getValue()].Name = $tryClone($("CXXDynamicCastExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXDynamicCastExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXDynamicCastExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXReinterpretCastExprClass.getValue()].Name = $tryClone($("CXXReinterpretCastExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXReinterpretCastExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXReinterpretCastExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXStaticCastExprClass.getValue()].Name = $tryClone($("CXXStaticCastExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CXXStaticCastExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CXXStaticCastExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCBridgedCastExprClass.getValue()].Name = $tryClone($("ObjCBridgedCastExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCBridgedCastExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCBridgedCastExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ImplicitCastExprClass.getValue()].Name = $tryClone($("ImplicitCastExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ImplicitCastExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ImplicitCastExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CharacterLiteralClass.getValue()].Name = $tryClone($("CharacterLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CharacterLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CharacterLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ChooseExprClass.getValue()].Name = $tryClone($("ChooseExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ChooseExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ChooseExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CompoundLiteralExprClass.getValue()].Name = $tryClone($("CompoundLiteralExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CompoundLiteralExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CompoundLiteralExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ConvertVectorExprClass.getValue()].Name = $tryClone($("ConvertVectorExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ConvertVectorExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ConvertVectorExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CoawaitExprClass.getValue()].Name = $tryClone($("CoawaitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CoawaitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CoawaitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CoyieldExprClass.getValue()].Name = $tryClone($("CoyieldExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CoyieldExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CoyieldExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DeclRefExprClass.getValue()].Name = $tryClone($("DeclRefExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DeclRefExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__DeclRefExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DependentScopeDeclRefExprClass.getValue()].Name = $tryClone($("DependentScopeDeclRefExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DependentScopeDeclRefExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__DependentScopeDeclRefExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DesignatedInitExprClass.getValue()].Name = $tryClone($("DesignatedInitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DesignatedInitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__DesignatedInitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DesignatedInitUpdateExprClass.getValue()].Name = $tryClone($("DesignatedInitUpdateExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DesignatedInitUpdateExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__DesignatedInitUpdateExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ExprWithCleanupsClass.getValue()].Name = $tryClone($("ExprWithCleanups"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ExprWithCleanupsClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ExprWithCleanups();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ExpressionTraitExprClass.getValue()].Name = $tryClone($("ExpressionTraitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ExpressionTraitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ExpressionTraitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ExtVectorElementExprClass.getValue()].Name = $tryClone($("ExtVectorElementExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ExtVectorElementExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ExtVectorElementExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.FloatingLiteralClass.getValue()].Name = $tryClone($("FloatingLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.FloatingLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__FloatingLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.FunctionParmPackExprClass.getValue()].Name = $tryClone($("FunctionParmPackExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.FunctionParmPackExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__FunctionParmPackExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.GNUNullExprClass.getValue()].Name = $tryClone($("GNUNullExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.GNUNullExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__GNUNullExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.GenericSelectionExprClass.getValue()].Name = $tryClone($("GenericSelectionExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.GenericSelectionExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__GenericSelectionExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ImaginaryLiteralClass.getValue()].Name = $tryClone($("ImaginaryLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ImaginaryLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ImaginaryLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ImplicitValueInitExprClass.getValue()].Name = $tryClone($("ImplicitValueInitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ImplicitValueInitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ImplicitValueInitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.InitListExprClass.getValue()].Name = $tryClone($("InitListExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.InitListExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__InitListExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.IntegerLiteralClass.getValue()].Name = $tryClone($("IntegerLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.IntegerLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__IntegerLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.LambdaExprClass.getValue()].Name = $tryClone($("LambdaExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.LambdaExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__LambdaExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MSPropertyRefExprClass.getValue()].Name = $tryClone($("MSPropertyRefExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MSPropertyRefExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__MSPropertyRefExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MSPropertySubscriptExprClass.getValue()].Name = $tryClone($("MSPropertySubscriptExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MSPropertySubscriptExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__MSPropertySubscriptExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MaterializeTemporaryExprClass.getValue()].Name = $tryClone($("MaterializeTemporaryExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MaterializeTemporaryExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__MaterializeTemporaryExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MemberExprClass.getValue()].Name = $tryClone($("MemberExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MemberExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__MemberExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.NoInitExprClass.getValue()].Name = $tryClone($("NoInitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.NoInitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__NoInitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPArraySectionExprClass.getValue()].Name = $tryClone($("OMPArraySectionExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPArraySectionExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPArraySectionExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCArrayLiteralClass.getValue()].Name = $tryClone($("ObjCArrayLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCArrayLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCArrayLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAvailabilityCheckExprClass.getValue()].Name = $tryClone($("ObjCAvailabilityCheckExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAvailabilityCheckExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCAvailabilityCheckExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCBoolLiteralExprClass.getValue()].Name = $tryClone($("ObjCBoolLiteralExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCBoolLiteralExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCBoolLiteralExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCBoxedExprClass.getValue()].Name = $tryClone($("ObjCBoxedExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCBoxedExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCBoxedExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCDictionaryLiteralClass.getValue()].Name = $tryClone($("ObjCDictionaryLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCDictionaryLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCDictionaryLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCEncodeExprClass.getValue()].Name = $tryClone($("ObjCEncodeExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCEncodeExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCEncodeExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCIndirectCopyRestoreExprClass.getValue()].Name = $tryClone($("ObjCIndirectCopyRestoreExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCIndirectCopyRestoreExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCIndirectCopyRestoreExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCIsaExprClass.getValue()].Name = $tryClone($("ObjCIsaExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCIsaExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCIsaExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCIvarRefExprClass.getValue()].Name = $tryClone($("ObjCIvarRefExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCIvarRefExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCIvarRefExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCMessageExprClass.getValue()].Name = $tryClone($("ObjCMessageExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCMessageExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCMessageExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCPropertyRefExprClass.getValue()].Name = $tryClone($("ObjCPropertyRefExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCPropertyRefExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCPropertyRefExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCProtocolExprClass.getValue()].Name = $tryClone($("ObjCProtocolExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCProtocolExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCProtocolExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCSelectorExprClass.getValue()].Name = $tryClone($("ObjCSelectorExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCSelectorExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCSelectorExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCStringLiteralClass.getValue()].Name = $tryClone($("ObjCStringLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCStringLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCStringLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCSubscriptRefExprClass.getValue()].Name = $tryClone($("ObjCSubscriptRefExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCSubscriptRefExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCSubscriptRefExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OffsetOfExprClass.getValue()].Name = $tryClone($("OffsetOfExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OffsetOfExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OffsetOfExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OpaqueValueExprClass.getValue()].Name = $tryClone($("OpaqueValueExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OpaqueValueExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OpaqueValueExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UnresolvedLookupExprClass.getValue()].Name = $tryClone($("UnresolvedLookupExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UnresolvedLookupExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__UnresolvedLookupExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UnresolvedMemberExprClass.getValue()].Name = $tryClone($("UnresolvedMemberExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UnresolvedMemberExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__UnresolvedMemberExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.PackExpansionExprClass.getValue()].Name = $tryClone($("PackExpansionExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.PackExpansionExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__PackExpansionExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ParenExprClass.getValue()].Name = $tryClone($("ParenExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ParenExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ParenExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ParenListExprClass.getValue()].Name = $tryClone($("ParenListExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ParenListExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ParenListExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.PredefinedExprClass.getValue()].Name = $tryClone($("PredefinedExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.PredefinedExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__PredefinedExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.PseudoObjectExprClass.getValue()].Name = $tryClone($("PseudoObjectExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.PseudoObjectExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__PseudoObjectExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ShuffleVectorExprClass.getValue()].Name = $tryClone($("ShuffleVectorExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ShuffleVectorExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ShuffleVectorExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SizeOfPackExprClass.getValue()].Name = $tryClone($("SizeOfPackExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SizeOfPackExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__SizeOfPackExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.StmtExprClass.getValue()].Name = $tryClone($("StmtExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.StmtExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__StmtExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.StringLiteralClass.getValue()].Name = $tryClone($("StringLiteral"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.StringLiteralClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__StringLiteral();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SubstNonTypeTemplateParmExprClass.getValue()].Name = $tryClone($("SubstNonTypeTemplateParmExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SubstNonTypeTemplateParmExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__SubstNonTypeTemplateParmExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SubstNonTypeTemplateParmPackExprClass.getValue()].Name = $tryClone($("SubstNonTypeTemplateParmPackExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SubstNonTypeTemplateParmPackExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__SubstNonTypeTemplateParmPackExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.TypeTraitExprClass.getValue()].Name = $tryClone($("TypeTraitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.TypeTraitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__TypeTraitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.TypoExprClass.getValue()].Name = $tryClone($("TypoExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.TypoExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__TypoExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UnaryExprOrTypeTraitExprClass.getValue()].Name = $tryClone($("UnaryExprOrTypeTraitExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UnaryExprOrTypeTraitExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__UnaryExprOrTypeTraitExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UnaryOperatorClass.getValue()].Name = $tryClone($("UnaryOperator"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.UnaryOperatorClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__UnaryOperator();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.VAArgExprClass.getValue()].Name = $tryClone($("VAArgExpr"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.VAArgExprClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__VAArgExpr();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ForStmtClass.getValue()].Name = $tryClone($("ForStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ForStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ForStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.GotoStmtClass.getValue()].Name = $tryClone($("GotoStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.GotoStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__GotoStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.IfStmtClass.getValue()].Name = $tryClone($("IfStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.IfStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__IfStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.IndirectGotoStmtClass.getValue()].Name = $tryClone($("IndirectGotoStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.IndirectGotoStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__IndirectGotoStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.LabelStmtClass.getValue()].Name = $tryClone($("LabelStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.LabelStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__LabelStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MSDependentExistsStmtClass.getValue()].Name = $tryClone($("MSDependentExistsStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.MSDependentExistsStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__MSDependentExistsStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.NullStmtClass.getValue()].Name = $tryClone($("NullStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.NullStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__NullStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPAtomicDirectiveClass.getValue()].Name = $tryClone($("OMPAtomicDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPAtomicDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPAtomicDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPBarrierDirectiveClass.getValue()].Name = $tryClone($("OMPBarrierDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPBarrierDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPBarrierDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPCancelDirectiveClass.getValue()].Name = $tryClone($("OMPCancelDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPCancelDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPCancelDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPCancellationPointDirectiveClass.getValue()].Name = $tryClone($("OMPCancellationPointDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPCancellationPointDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPCancellationPointDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPCriticalDirectiveClass.getValue()].Name = $tryClone($("OMPCriticalDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPCriticalDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPCriticalDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPFlushDirectiveClass.getValue()].Name = $tryClone($("OMPFlushDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPFlushDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPFlushDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPDistributeDirectiveClass.getValue()].Name = $tryClone($("OMPDistributeDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPDistributeDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPDistributeDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPDistributeParallelForDirectiveClass.getValue()].Name = $tryClone($("OMPDistributeParallelForDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPDistributeParallelForDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPDistributeParallelForDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPDistributeParallelForSimdDirectiveClass.getValue()].Name = $tryClone($("OMPDistributeParallelForSimdDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPDistributeParallelForSimdDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPDistributeParallelForSimdDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPDistributeSimdDirectiveClass.getValue()].Name = $tryClone($("OMPDistributeSimdDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPDistributeSimdDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPDistributeSimdDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPForDirectiveClass.getValue()].Name = $tryClone($("OMPForDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPForDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPForDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPForSimdDirectiveClass.getValue()].Name = $tryClone($("OMPForSimdDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPForSimdDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPForSimdDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPParallelForDirectiveClass.getValue()].Name = $tryClone($("OMPParallelForDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPParallelForDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPParallelForDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPParallelForSimdDirectiveClass.getValue()].Name = $tryClone($("OMPParallelForSimdDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPParallelForSimdDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPParallelForSimdDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPSimdDirectiveClass.getValue()].Name = $tryClone($("OMPSimdDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPSimdDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPSimdDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetParallelForSimdDirectiveClass.getValue()].Name = $tryClone($("OMPTargetParallelForSimdDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetParallelForSimdDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTargetParallelForSimdDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskLoopDirectiveClass.getValue()].Name = $tryClone($("OMPTaskLoopDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskLoopDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTaskLoopDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskLoopSimdDirectiveClass.getValue()].Name = $tryClone($("OMPTaskLoopSimdDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskLoopSimdDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTaskLoopSimdDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPMasterDirectiveClass.getValue()].Name = $tryClone($("OMPMasterDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPMasterDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPMasterDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPOrderedDirectiveClass.getValue()].Name = $tryClone($("OMPOrderedDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPOrderedDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPOrderedDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPParallelDirectiveClass.getValue()].Name = $tryClone($("OMPParallelDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPParallelDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPParallelDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPParallelSectionsDirectiveClass.getValue()].Name = $tryClone($("OMPParallelSectionsDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPParallelSectionsDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPParallelSectionsDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPSectionDirectiveClass.getValue()].Name = $tryClone($("OMPSectionDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPSectionDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPSectionDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPSectionsDirectiveClass.getValue()].Name = $tryClone($("OMPSectionsDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPSectionsDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPSectionsDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPSingleDirectiveClass.getValue()].Name = $tryClone($("OMPSingleDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPSingleDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPSingleDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetDataDirectiveClass.getValue()].Name = $tryClone($("OMPTargetDataDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetDataDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTargetDataDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetDirectiveClass.getValue()].Name = $tryClone($("OMPTargetDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTargetDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetEnterDataDirectiveClass.getValue()].Name = $tryClone($("OMPTargetEnterDataDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetEnterDataDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTargetEnterDataDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetExitDataDirectiveClass.getValue()].Name = $tryClone($("OMPTargetExitDataDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetExitDataDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTargetExitDataDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetParallelDirectiveClass.getValue()].Name = $tryClone($("OMPTargetParallelDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetParallelDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTargetParallelDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetParallelForDirectiveClass.getValue()].Name = $tryClone($("OMPTargetParallelForDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetParallelForDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTargetParallelForDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetUpdateDirectiveClass.getValue()].Name = $tryClone($("OMPTargetUpdateDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTargetUpdateDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTargetUpdateDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskDirectiveClass.getValue()].Name = $tryClone($("OMPTaskDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTaskDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskgroupDirectiveClass.getValue()].Name = $tryClone($("OMPTaskgroupDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskgroupDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTaskgroupDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskwaitDirectiveClass.getValue()].Name = $tryClone($("OMPTaskwaitDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskwaitDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTaskwaitDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskyieldDirectiveClass.getValue()].Name = $tryClone($("OMPTaskyieldDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTaskyieldDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTaskyieldDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTeamsDirectiveClass.getValue()].Name = $tryClone($("OMPTeamsDirective"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.OMPTeamsDirectiveClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__OMPTeamsDirective();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtCatchStmtClass.getValue()].Name = $tryClone($("ObjCAtCatchStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtCatchStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCAtCatchStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtFinallyStmtClass.getValue()].Name = $tryClone($("ObjCAtFinallyStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtFinallyStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCAtFinallyStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtSynchronizedStmtClass.getValue()].Name = $tryClone($("ObjCAtSynchronizedStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtSynchronizedStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCAtSynchronizedStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtThrowStmtClass.getValue()].Name = $tryClone($("ObjCAtThrowStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtThrowStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCAtThrowStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtTryStmtClass.getValue()].Name = $tryClone($("ObjCAtTryStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAtTryStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCAtTryStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAutoreleasePoolStmtClass.getValue()].Name = $tryClone($("ObjCAutoreleasePoolStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCAutoreleasePoolStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCAutoreleasePoolStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCForCollectionStmtClass.getValue()].Name = $tryClone($("ObjCForCollectionStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ObjCForCollectionStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ObjCForCollectionStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ReturnStmtClass.getValue()].Name = $tryClone($("ReturnStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.ReturnStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__ReturnStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SEHExceptStmtClass.getValue()].Name = $tryClone($("SEHExceptStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SEHExceptStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__SEHExceptStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SEHFinallyStmtClass.getValue()].Name = $tryClone($("SEHFinallyStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SEHFinallyStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__SEHFinallyStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SEHLeaveStmtClass.getValue()].Name = $tryClone($("SEHLeaveStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SEHLeaveStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__SEHLeaveStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SEHTryStmtClass.getValue()].Name = $tryClone($("SEHTryStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SEHTryStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__SEHTryStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CaseStmtClass.getValue()].Name = $tryClone($("CaseStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.CaseStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__CaseStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DefaultStmtClass.getValue()].Name = $tryClone($("DefaultStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.DefaultStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__DefaultStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SwitchStmtClass.getValue()].Name = $tryClone($("SwitchStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.SwitchStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__SwitchStmt();
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.WhileStmtClass.getValue()].Name = $tryClone($("WhileStmt"));
  StmtClassInfo[(/*uint*/int)Stmt.StmtClass.WhileStmtClass.getValue()].Size = /*JAVA*/BYTES_IN_JAVA_OBJECT_HEADER;//$sizeof__WhileStmt();
  
  return StmtClassInfo[E.getValue()];
}
private static final class getStmtInfoTableEntry$$ {
  static/*static*/ boolean Initialized = false;
}


// These silly little functions have to be static inline to suppress
// unused warnings, and they have to be defined to suppress other
// warnings.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::is_good">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 159,
 FQN="(anonymous namespace)::is_good", NM="_ZN12_GLOBAL__N_1L7is_goodENS_4goodE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN12_GLOBAL__N_1L7is_goodENS_4goodE")
//</editor-fold>
public static /*inline*/ good is_good(good $Prm0) {
  return new good();
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::implements_children">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 162,
 FQN="(anonymous namespace)::implements_children", NM="Tpl__ZN12_GLOBAL__N_119implements_childrenEMT_FN4llvm14iterator_rangeIN5clang12StmtIteratorEEEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=Tpl__ZN12_GLOBAL__N_119implements_childrenEMT_FN4llvm14iterator_rangeIN5clang12StmtIteratorEEEvE")
//</editor-fold>
public static </*class*/ T> good implements_children$T(T$getChildrenStmts<T> $Prm0) {
  return new good();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::implements_children">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 165,
 FQN="(anonymous namespace)::implements_children", NM="_ZN12_GLOBAL__N_1L19implements_childrenEMN5clang4StmtEFN4llvm14iterator_rangeINS0_12StmtIteratorEEEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN12_GLOBAL__N_1L19implements_childrenEMN5clang4StmtEFN4llvm14iterator_rangeINS0_12StmtIteratorEEEvE")
//</editor-fold>
public static /*inline*/ bad implements_children(Stmt$getChildrenStmts $Prm0)/* __attribute__((unused))*/ {
  return new bad();
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::implements_getLocStart">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 171,
 FQN="(anonymous namespace)::implements_getLocStart", NM="Tpl__ZN12_GLOBAL__N_122implements_getLocStartEMT_KFN5clang14SourceLocationEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=Tpl__ZN12_GLOBAL__N_122implements_getLocStartEMT_KFN5clang14SourceLocationEvE")
//</editor-fold>
public static </*class*/ T > good implements_getLocStart$T(T$getLocStart<T> $Prm0) {
  return new good();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::implements_getLocStart">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 174,
 FQN="(anonymous namespace)::implements_getLocStart", NM="_ZN12_GLOBAL__N_1L22implements_getLocStartEMN5clang4StmtEKFNS0_14SourceLocationEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN12_GLOBAL__N_1L22implements_getLocStartEMN5clang4StmtEKFNS0_14SourceLocationEvE")
//</editor-fold>
public static /*inline*/ bad implements_getLocStart(Stmt$getLocStart $Prm0)/* __attribute__((unused))*/ {
  return new bad();
}

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::implements_getLocEnd">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 180,
 FQN="(anonymous namespace)::implements_getLocEnd", NM="Tpl__ZN12_GLOBAL__N_120implements_getLocEndEMT_KFN5clang14SourceLocationEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=Tpl__ZN12_GLOBAL__N_120implements_getLocEndEMT_KFN5clang14SourceLocationEvE")
//</editor-fold>
public static </*class*/ T> good implements_getLocEnd$T(T$getLocEnd<T> $Prm0) {
  return new good();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::implements_getLocEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 183,
 FQN="(anonymous namespace)::implements_getLocEnd", NM="_ZN12_GLOBAL__N_1L20implements_getLocEndEMN5clang4StmtEKFNS0_14SourceLocationEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN12_GLOBAL__N_1L20implements_getLocEndEMN5clang4StmtEKFNS0_14SourceLocationEvE")
//</editor-fold>
public static /*inline*/ bad implements_getLocEnd(Stmt$getLocEnd $Prm0)/* __attribute__((unused))*/ {
  return new bad();
}


/// Check whether the various Stmt classes implement their member
/// functions.
//<editor-fold defaultstate="collapsed" desc="check_implementations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 198,
 FQN="check_implementations", NM="_ZL21check_implementationsv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZL21check_implementationsv")
//</editor-fold>
public static /*inline*/ void check_implementations()/* __attribute__((unused))*/ {
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/GCCAsmStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/GCCAsmStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/GCCAsmStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/MSAsmStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/MSAsmStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/MSAsmStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/AttributedStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/AttributedStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/AttributedStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/BreakStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/BreakStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/BreakStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXCatchStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXCatchStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXCatchStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXForRangeStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXForRangeStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXForRangeStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXTryStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXTryStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXTryStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CapturedStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CapturedStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CapturedStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CompoundStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CompoundStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CompoundStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ContinueStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ContinueStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ContinueStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CoreturnStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CoreturnStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CoreturnStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CoroutineBodyStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CoroutineBodyStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CoroutineBodyStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/DeclStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/DeclStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/DeclStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/DoStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/DoStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/DoStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/BinaryConditionalOperator::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/BinaryConditionalOperator::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/BinaryConditionalOperator::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ConditionalOperator::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ConditionalOperator::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ConditionalOperator::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/AddrLabelExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/AddrLabelExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/AddrLabelExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ArraySubscriptExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ArraySubscriptExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ArraySubscriptExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ArrayTypeTraitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ArrayTypeTraitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ArrayTypeTraitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/AsTypeExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/AsTypeExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/AsTypeExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/AtomicExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/AtomicExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/AtomicExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/BinaryOperator::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/BinaryOperator::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/BinaryOperator::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CompoundAssignOperator::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CompoundAssignOperator::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CompoundAssignOperator::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/BlockExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/BlockExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/BlockExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXBindTemporaryExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXBindTemporaryExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXBindTemporaryExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXBoolLiteralExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXBoolLiteralExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXBoolLiteralExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXConstructExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXConstructExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXConstructExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXTemporaryObjectExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXTemporaryObjectExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXTemporaryObjectExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXDefaultArgExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXDefaultArgExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXDefaultArgExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXDefaultInitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXDefaultInitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXDefaultInitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXDeleteExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXDeleteExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXDeleteExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXDependentScopeMemberExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXDependentScopeMemberExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXDependentScopeMemberExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXFoldExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXFoldExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXFoldExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXInheritedCtorInitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXInheritedCtorInitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXInheritedCtorInitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXNewExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXNewExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXNewExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXNoexceptExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXNoexceptExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXNoexceptExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXNullPtrLiteralExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXNullPtrLiteralExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXNullPtrLiteralExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXPseudoDestructorExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXPseudoDestructorExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXPseudoDestructorExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXScalarValueInitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXScalarValueInitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXScalarValueInitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXStdInitializerListExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXStdInitializerListExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXStdInitializerListExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXThisExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXThisExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXThisExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXThrowExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXThrowExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXThrowExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXTypeidExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXTypeidExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXTypeidExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXUnresolvedConstructExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXUnresolvedConstructExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXUnresolvedConstructExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXUuidofExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXUuidofExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXUuidofExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CallExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CallExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CallExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CUDAKernelCallExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CUDAKernelCallExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CUDAKernelCallExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXMemberCallExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXMemberCallExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXMemberCallExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXOperatorCallExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXOperatorCallExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXOperatorCallExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/UserDefinedLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/UserDefinedLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/UserDefinedLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CStyleCastExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CStyleCastExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CStyleCastExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXFunctionalCastExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXFunctionalCastExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXFunctionalCastExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXConstCastExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXConstCastExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXConstCastExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXDynamicCastExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXDynamicCastExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXDynamicCastExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXReinterpretCastExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXReinterpretCastExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXReinterpretCastExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CXXStaticCastExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CXXStaticCastExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CXXStaticCastExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCBridgedCastExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCBridgedCastExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCBridgedCastExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ImplicitCastExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ImplicitCastExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ImplicitCastExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CharacterLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CharacterLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CharacterLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ChooseExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ChooseExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ChooseExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CompoundLiteralExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CompoundLiteralExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CompoundLiteralExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ConvertVectorExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ConvertVectorExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ConvertVectorExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CoawaitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CoawaitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CoawaitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CoyieldExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CoyieldExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CoyieldExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/DeclRefExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/DeclRefExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/DeclRefExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/DependentScopeDeclRefExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/DependentScopeDeclRefExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/DependentScopeDeclRefExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/DesignatedInitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/DesignatedInitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/DesignatedInitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/DesignatedInitUpdateExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/DesignatedInitUpdateExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/DesignatedInitUpdateExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ExprWithCleanups::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ExprWithCleanups::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ExprWithCleanups::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ExpressionTraitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ExpressionTraitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ExpressionTraitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ExtVectorElementExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ExtVectorElementExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ExtVectorElementExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/FloatingLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/FloatingLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/FloatingLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/FunctionParmPackExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/FunctionParmPackExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/FunctionParmPackExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/GNUNullExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/GNUNullExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/GNUNullExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/GenericSelectionExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/GenericSelectionExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/GenericSelectionExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ImaginaryLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ImaginaryLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ImaginaryLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ImplicitValueInitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ImplicitValueInitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ImplicitValueInitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/InitListExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/InitListExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/InitListExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/IntegerLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/IntegerLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/IntegerLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/LambdaExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/LambdaExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/LambdaExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/MSPropertyRefExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/MSPropertyRefExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/MSPropertyRefExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/MSPropertySubscriptExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/MSPropertySubscriptExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/MSPropertySubscriptExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/MaterializeTemporaryExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/MaterializeTemporaryExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/MaterializeTemporaryExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/MemberExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/MemberExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/MemberExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/NoInitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/NoInitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/NoInitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPArraySectionExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPArraySectionExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPArraySectionExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCArrayLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCArrayLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCArrayLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCAvailabilityCheckExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCAvailabilityCheckExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCAvailabilityCheckExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCBoolLiteralExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCBoolLiteralExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCBoolLiteralExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCBoxedExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCBoxedExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCBoxedExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCDictionaryLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCDictionaryLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCDictionaryLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCEncodeExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCEncodeExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCEncodeExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCIndirectCopyRestoreExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCIndirectCopyRestoreExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCIndirectCopyRestoreExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCIsaExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCIsaExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCIsaExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCIvarRefExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCIvarRefExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCIvarRefExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCMessageExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCMessageExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCMessageExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCPropertyRefExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCPropertyRefExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCPropertyRefExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCProtocolExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCProtocolExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCProtocolExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCSelectorExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCSelectorExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCSelectorExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCStringLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCStringLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCStringLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCSubscriptRefExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCSubscriptRefExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCSubscriptRefExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OffsetOfExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OffsetOfExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OffsetOfExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OpaqueValueExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OpaqueValueExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OpaqueValueExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/UnresolvedLookupExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/UnresolvedLookupExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/UnresolvedLookupExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/UnresolvedMemberExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/UnresolvedMemberExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/UnresolvedMemberExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/PackExpansionExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/PackExpansionExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/PackExpansionExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ParenExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ParenExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ParenExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ParenListExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ParenListExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ParenListExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/PredefinedExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/PredefinedExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/PredefinedExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/PseudoObjectExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/PseudoObjectExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/PseudoObjectExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ShuffleVectorExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ShuffleVectorExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ShuffleVectorExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/SizeOfPackExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/SizeOfPackExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/SizeOfPackExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/StmtExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/StmtExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/StmtExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/StringLiteral::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/StringLiteral::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/StringLiteral::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/SubstNonTypeTemplateParmExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/SubstNonTypeTemplateParmExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/SubstNonTypeTemplateParmExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/SubstNonTypeTemplateParmPackExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/SubstNonTypeTemplateParmPackExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/SubstNonTypeTemplateParmPackExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/TypeTraitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/TypeTraitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/TypeTraitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/TypoExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/TypoExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/TypoExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/UnaryExprOrTypeTraitExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/UnaryExprOrTypeTraitExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/UnaryExprOrTypeTraitExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/UnaryOperator::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/UnaryOperator::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/UnaryOperator::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/VAArgExpr::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/VAArgExpr::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/VAArgExpr::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ForStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ForStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ForStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/GotoStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/GotoStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/GotoStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/IfStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/IfStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/IfStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/IndirectGotoStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/IndirectGotoStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/IndirectGotoStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/LabelStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/LabelStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/LabelStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/MSDependentExistsStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/MSDependentExistsStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/MSDependentExistsStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/NullStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/NullStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/NullStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPAtomicDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPAtomicDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPAtomicDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPBarrierDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPBarrierDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPBarrierDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPCancelDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPCancelDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPCancelDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPCancellationPointDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPCancellationPointDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPCancellationPointDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPCriticalDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPCriticalDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPCriticalDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPFlushDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPFlushDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPFlushDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPDistributeDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPDistributeDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPDistributeDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPDistributeParallelForDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPDistributeParallelForDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPDistributeParallelForDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPDistributeParallelForSimdDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPDistributeParallelForSimdDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPDistributeParallelForSimdDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPDistributeSimdDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPDistributeSimdDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPDistributeSimdDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPForDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPForDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPForDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPForSimdDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPForSimdDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPForSimdDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPParallelForDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPParallelForDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPParallelForDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPParallelForSimdDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPParallelForSimdDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPParallelForSimdDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPSimdDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPSimdDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPSimdDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTargetParallelForSimdDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTargetParallelForSimdDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTargetParallelForSimdDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTaskLoopDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTaskLoopDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTaskLoopDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTaskLoopSimdDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTaskLoopSimdDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTaskLoopSimdDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPMasterDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPMasterDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPMasterDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPOrderedDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPOrderedDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPOrderedDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPParallelDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPParallelDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPParallelDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPParallelSectionsDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPParallelSectionsDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPParallelSectionsDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPSectionDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPSectionDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPSectionDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPSectionsDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPSectionsDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPSectionsDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPSingleDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPSingleDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPSingleDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTargetDataDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTargetDataDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTargetDataDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTargetDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTargetDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTargetDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTargetEnterDataDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTargetEnterDataDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTargetEnterDataDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTargetExitDataDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTargetExitDataDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTargetExitDataDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTargetParallelDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTargetParallelDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTargetParallelDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTargetParallelForDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTargetParallelForDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTargetParallelForDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTargetUpdateDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTargetUpdateDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTargetUpdateDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTaskDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTaskDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTaskDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTaskgroupDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTaskgroupDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTaskgroupDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTaskwaitDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTaskwaitDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTaskwaitDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTaskyieldDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTaskyieldDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTaskyieldDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/OMPTeamsDirective::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/OMPTeamsDirective::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/OMPTeamsDirective::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCAtCatchStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCAtCatchStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCAtCatchStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCAtFinallyStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCAtFinallyStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCAtFinallyStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCAtSynchronizedStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCAtSynchronizedStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCAtSynchronizedStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCAtThrowStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCAtThrowStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCAtThrowStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCAtTryStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCAtTryStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCAtTryStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCAutoreleasePoolStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCAutoreleasePoolStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCAutoreleasePoolStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ObjCForCollectionStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ObjCForCollectionStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ObjCForCollectionStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/ReturnStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/ReturnStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/ReturnStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/SEHExceptStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/SEHExceptStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/SEHExceptStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/SEHFinallyStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/SEHFinallyStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/SEHFinallyStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/SEHLeaveStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/SEHLeaveStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/SEHLeaveStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/SEHTryStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/SEHTryStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/SEHTryStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/CaseStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/CaseStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/CaseStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/DefaultStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/DefaultStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/DefaultStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/SwitchStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/SwitchStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/SwitchStmt::getLocEnd));
  /*J:(void)*/is_good(implements_children$T(/*AddrOf*//*FPtr*/WhileStmt::children));
  /*J:(void)*/is_good(implements_getLocStart$T(/*AddrOf*//*FPtr*/WhileStmt::getLocStart));
  /*J:(void)*/is_good(implements_getLocEnd$T(/*AddrOf*//*FPtr*/WhileStmt::getLocEnd));
}

/// This implementation is used when a class provides a custom
/// implementation of getSourceRange.
/*template <class S, class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getSourceRangeImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 228,
 FQN="(anonymous namespace)::getSourceRangeImpl", NM="Tpl__ZN12_GLOBAL__N_118getSourceRangeImplEPKN5clang4StmtEMT0_KFNS0_11SourceRangeEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=Tpl__ZN12_GLOBAL__N_118getSourceRangeImplEPKN5clang4StmtEMT0_KFNS0_11SourceRangeEvE")
//</editor-fold>
public static </*class*/ S extends Stmt> SourceRange getSourceRangeImpl$getSourceRange(/*const*/ Stmt /*P*/ stmt, 
                                 T$getSourceRange<S> v) {
  return ((/*static_cast*//*const*/ S /*P*/ )(stmt)).getSourceRange();
}


/// This implementation is used when a class doesn't provide a custom
/// implementation of getSourceRange.  Overload resolution should pick it over
/// the implementation above because it's more specialized according to
/// function template partial ordering.
/*template <class S> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getSourceRangeImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 238,
 FQN="(anonymous namespace)::getSourceRangeImpl", NM="Tpl__ZN12_GLOBAL__N_118getSourceRangeImplEPKN5clang4StmtEMS1_KFNS0_11SourceRangeEvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=Tpl__ZN12_GLOBAL__N_118getSourceRangeImplEPKN5clang4StmtEMS1_KFNS0_11SourceRangeEvE")
//</editor-fold>
public static </*class*/ S extends Stmt> SourceRange getSourceRangeImpl$Stmt(/*const*/ Stmt /*P*/ stmt, 
                       T$getSourceRange<S> v) {
  return new SourceRange(((/*static_cast*//*const*/ S /*P*/ )(stmt)).getLocStart(), ((/*static_cast*//*const*/ S /*P*/ )(stmt)).getLocEnd());
}

//<editor-fold defaultstate="collapsed" desc="copyIntoContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 729,
 FQN="copyIntoContext", NM="_ZL15copyIntoContextRKN5clang10ASTContextEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZL15copyIntoContextRKN5clang10ASTContextEN4llvm9StringRefE")
//</editor-fold>
public static StringRef copyIntoContext(final /*const*/ ASTContext /*&*/ C, StringRef str) {
  return str.copy(C);
}

} // END OF class StmtStatics
