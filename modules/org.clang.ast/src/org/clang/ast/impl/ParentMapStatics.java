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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type ParentMapStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZL14BuildParentMapRN4llvm8DenseMapIPN5clang4StmtES3_NS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S3_EEEES3_15OpaqueValueMode; -static-type=ParentMapStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ParentMapStatics {

//<editor-fold defaultstate="collapsed" desc="BuildParentMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp", line = 29,
 FQN="BuildParentMap", NM="_ZL14BuildParentMapRN4llvm8DenseMapIPN5clang4StmtES3_NS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S3_EEEES3_15OpaqueValueMode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ParentMap.cpp -nm=_ZL14BuildParentMapRN4llvm8DenseMapIPN5clang4StmtES3_NS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S3_EEEES3_15OpaqueValueMode")
//</editor-fold>
public static void BuildParentMap(final DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*&*/ M, Stmt /*P*/ S) {
  BuildParentMap(M, S, 
              OpaqueValueMode.OV_Transparent);
}
public static void BuildParentMap(final DenseMap<Stmt /*P*/ , Stmt /*P*/ > /*&*/ M, Stmt /*P*/ S, 
              OpaqueValueMode OVMode/*= OV_Transparent*/) {
  if (!(S != null)) {
    return;
  }
  switch (S.getStmtClass()) {
   case PseudoObjectExprClass:
    {
      assert (OVMode == OpaqueValueMode.OV_Transparent) : "Should not appear alongside OVEs";
      PseudoObjectExpr /*P*/ POE = cast_PseudoObjectExpr(S);
      
      // If we are rebuilding the map, clear out any existing state.
      if ((M.$at_T1$RR(POE.getSyntacticForm()) != null)) {
        for (Stmt /*P*/ SubStmt : S.children())  {
          M.$set(SubStmt, null);
        }
      }
      
      M.$set(POE.getSyntacticForm(), S);
      BuildParentMap(M, POE.getSyntacticForm(), OpaqueValueMode.OV_Transparent);
      
      for (type$ptr<Expr /*P*/ /*const*/ /*P*/> I = $tryClone(POE.semantics_begin()), 
          /*P*/ /*const*/ /*P*/ E = $tryClone(POE.semantics_end());
           $noteq_ptr(I, E); I.$preInc()) {
        M.$set(I.$star(), S);
        BuildParentMap(M, I.$star(), OpaqueValueMode.OV_Opaque);
      }
      break;
    }
   case BinaryConditionalOperatorClass:
    {
      assert (OVMode == OpaqueValueMode.OV_Transparent) : "Should not appear alongside OVEs";
      BinaryConditionalOperator /*P*/ BCO = cast_BinaryConditionalOperator(S);
      
      M.$set(BCO.getCommon(), S);
      BuildParentMap(M, BCO.getCommon(), OpaqueValueMode.OV_Transparent);
      
      M.$set(BCO.getCond(), S);
      BuildParentMap(M, BCO.getCond(), OpaqueValueMode.OV_Opaque);
      
      M.$set(BCO.getTrueExpr(), S);
      BuildParentMap(M, BCO.getTrueExpr(), OpaqueValueMode.OV_Opaque);
      
      M.$set(BCO.getFalseExpr(), S);
      BuildParentMap(M, BCO.getFalseExpr(), OpaqueValueMode.OV_Transparent);
      
      break;
    }
   case OpaqueValueExprClass:
    {
      // FIXME: This isn't correct; it assumes that multiple OpaqueValueExprs
      // share a single source expression, but in the AST a single
      // OpaqueValueExpr is shared among multiple parent expressions.
      // The right thing to do is to give the OpaqueValueExpr its syntactic
      // parent, then not reassign that when traversing the semantic expressions.
      OpaqueValueExpr /*P*/ OVE = cast_OpaqueValueExpr(S);
      if (OVMode == OpaqueValueMode.OV_Transparent || !(M.$at_T1$RR(OVE.getSourceExpr()) != null)) {
        M.$set(OVE.getSourceExpr(), S);
        BuildParentMap(M, OVE.getSourceExpr(), OpaqueValueMode.OV_Transparent);
      }
      break;
    }
   default:
    for (Stmt /*P*/ SubStmt : S.children()) {
      if ((SubStmt != null)) {
        M.$set(SubStmt, S);
        BuildParentMap(M, SubStmt, OVMode);
      }
    }
    break;
  }
}

} // END OF class ParentMapStatics
