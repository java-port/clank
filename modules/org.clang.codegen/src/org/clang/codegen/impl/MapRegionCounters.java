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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.codegen.impl.*;
import static org.clang.ast.java.AstRTTI.cast_BinaryOperator;


/// A RecursiveASTVisitor that fills a map of statements to PGO counters.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MapRegionCounters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 113,
 FQN="(anonymous namespace)::MapRegionCounters", NM="_ZN12_GLOBAL__N_117MapRegionCountersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_117MapRegionCountersE")
//</editor-fold>
public class/*struct*/ MapRegionCounters implements /*public*/ RecursiveASTVisitor<MapRegionCounters> {
  /// The next counter value to assign.
  public /*uint*/int NextCounter;
  /// The function hash.
  public PGOHash Hash;
  /// The map of statements to counters.
  public final DenseMapTypeUInt</*const*/ Stmt /*P*/ > /*&*/ CounterMap;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MapRegionCounters::MapRegionCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 121,
   FQN="(anonymous namespace)::MapRegionCounters::MapRegionCounters", NM="_ZN12_GLOBAL__N_117MapRegionCountersC1ERN4llvm8DenseMapIPKN5clang4StmtEjNS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_117MapRegionCountersC1ERN4llvm8DenseMapIPKN5clang4StmtEjNS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_jEEEE")
  //</editor-fold>
  public MapRegionCounters(final DenseMapTypeUInt</*const*/ Stmt /*P*/ > /*&*/ CounterMap) {
    // : RecursiveASTVisitor<MapRegionCounters>(), NextCounter(0), Hash(), CounterMap(CounterMap) 
    //START JInit
    $RecursiveASTVisitor();
    this.NextCounter = 0;
    this.Hash = new PGOHash();
    this./*&*/CounterMap=/*&*/CounterMap;
    //END JInit
  }

  
  // Blocks and lambdas are handled as separate functions, so we need not
  // traverse them in the parent context.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MapRegionCounters::TraverseBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 126,
   FQN="(anonymous namespace)::MapRegionCounters::TraverseBlockExpr", NM="_ZN12_GLOBAL__N_117MapRegionCounters17TraverseBlockExprEPN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_117MapRegionCounters17TraverseBlockExprEPN5clang9BlockExprE")
  //</editor-fold>
  public boolean TraverseBlockExpr(BlockExpr /*P*/ BE) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MapRegionCounters::TraverseLambdaBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 127,
   FQN="(anonymous namespace)::MapRegionCounters::TraverseLambdaBody", NM="_ZN12_GLOBAL__N_117MapRegionCounters18TraverseLambdaBodyEPN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_117MapRegionCounters18TraverseLambdaBodyEPN5clang10LambdaExprE")
  //</editor-fold>
  public boolean TraverseLambdaBody(LambdaExpr /*P*/ LE) {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MapRegionCounters::TraverseCapturedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 128,
   FQN="(anonymous namespace)::MapRegionCounters::TraverseCapturedStmt", NM="_ZN12_GLOBAL__N_117MapRegionCounters20TraverseCapturedStmtEPN5clang12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_117MapRegionCounters20TraverseCapturedStmtEPN5clang12CapturedStmtE")
  //</editor-fold>
  public boolean TraverseCapturedStmt(CapturedStmt /*P*/ CS) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MapRegionCounters::VisitDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 130,
   FQN="(anonymous namespace)::MapRegionCounters::VisitDecl", NM="_ZN12_GLOBAL__N_117MapRegionCounters9VisitDeclEPKN5clang4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_117MapRegionCounters9VisitDeclEPKN5clang4DeclE")
  //</editor-fold>
  public boolean VisitDecl(/*const*/ Decl /*P*/ D) {
    switch (D.getKind()) {
     default:
      break;
     case Function:
     case CXXMethod:
     case CXXConstructor:
     case CXXDestructor:
     case CXXConversion:
     case ObjCMethod:
     case Block:
     case Captured:
      CounterMap.$set(D.getBody(), NextCounter++);
      break;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MapRegionCounters::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 148,
   FQN="(anonymous namespace)::MapRegionCounters::VisitStmt", NM="_ZN12_GLOBAL__N_117MapRegionCounters9VisitStmtEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_117MapRegionCounters9VisitStmtEPKN5clang4StmtE")
  //</editor-fold>
  public boolean VisitStmt(/*const*/ Stmt /*P*/ S) {
    PGOHash.HashType Type = getHashType(S);
    if (Type == PGOHash.HashType.None) {
      return true;
    }
    
    CounterMap.$set(S, NextCounter++);
    Hash.combine(Type);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MapRegionCounters::getHashType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 157,
   FQN="(anonymous namespace)::MapRegionCounters::getHashType", NM="_ZN12_GLOBAL__N_117MapRegionCounters11getHashTypeEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_117MapRegionCounters11getHashTypeEPKN5clang4StmtE")
  //</editor-fold>
  public PGOHash.HashType getHashType(/*const*/ Stmt /*P*/ S) {
    switch (S.getStmtClass()) {
     default:
      break;
     case LabelStmtClass:
      return PGOHash.HashType.LabelStmt;
     case WhileStmtClass:
      return PGOHash.HashType.WhileStmt;
     case DoStmtClass:
      return PGOHash.HashType.DoStmt;
     case ForStmtClass:
      return PGOHash.HashType.ForStmt;
     case CXXForRangeStmtClass:
      return PGOHash.HashType.CXXForRangeStmt;
     case ObjCForCollectionStmtClass:
      return PGOHash.HashType.ObjCForCollectionStmt;
     case SwitchStmtClass:
      return PGOHash.HashType.SwitchStmt;
     case CaseStmtClass:
      return PGOHash.HashType.CaseStmt;
     case DefaultStmtClass:
      return PGOHash.HashType.DefaultStmt;
     case IfStmtClass:
      return PGOHash.HashType.IfStmt;
     case CXXTryStmtClass:
      return PGOHash.HashType.CXXTryStmt;
     case CXXCatchStmtClass:
      return PGOHash.HashType.CXXCatchStmt;
     case ConditionalOperatorClass:
      return PGOHash.HashType.ConditionalOperator;
     case BinaryConditionalOperatorClass:
      return PGOHash.HashType.BinaryConditionalOperator;
     case BinaryOperatorClass:
      {
        /*const*/ org.clang.ast.BinaryOperator /*P*/ BO = cast_BinaryOperator(S);
        if (BO.getOpcode() == BinaryOperatorKind.BO_LAnd) {
          return PGOHash.HashType.BinaryOperatorLAnd;
        }
        if (BO.getOpcode() == BinaryOperatorKind.BO_LOr) {
          return PGOHash.HashType.BinaryOperatorLOr;
        }
        break;
      }
    }
    return PGOHash.HashType.None;
  }

  
  @Override public String toString() {
    return "" + "NextCounter=" + NextCounter // NOI18N
              + ", Hash=" + Hash // NOI18N
              + ", CounterMap=" + "[DenseMapTypeUInt$Stmt]" // NOI18N
              + super.toString(); // NOI18N
  }
}
