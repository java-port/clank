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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.codegen.CodeGen.impl.*;


/// A StmtVisitor that propagates the raw counts through the AST and
/// records the count at statements where the value may change.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 204,
 FQN="(anonymous namespace)::ComputeRegionCounts", NM="_ZN12_GLOBAL__N_119ComputeRegionCountsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCountsE")
//</editor-fold>
public class/*struct*/ ComputeRegionCounts implements /*public*/ ConstStmtVisitorVoid<ComputeRegionCounts>, Destructors.ClassWithDestructor {
  /// PGO state.
  public final CodeGenPGO /*&*/ PGO;
  
  /// A flag that is set when the current count should be recorded on the
  /// next statement, such as at the exit of a loop.
  public boolean RecordNextStmtCount;
  
  /// The count at the current location in the traversal.
  public long/*uint64_t*/ CurrentCount;
  
  /// The map of statements to count values.
  public final DenseMapTypeULong</*const*/ Stmt /*P*/ > /*&*/ CountMap;
  
  /// BreakContinueStack - Keep counts of breaks and continues inside loops.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::BreakContinue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 219,
   FQN="(anonymous namespace)::ComputeRegionCounts::BreakContinue", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts13BreakContinueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts13BreakContinueE")
  //</editor-fold>
  public static class/*struct*/ BreakContinue {
    public long/*uint64_t*/ BreakCount;
    public long/*uint64_t*/ ContinueCount;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::BreakContinue::BreakContinue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 222,
     FQN="(anonymous namespace)::ComputeRegionCounts::BreakContinue::BreakContinue", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts13BreakContinueC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts13BreakContinueC1Ev")
    //</editor-fold>
    public BreakContinue() {
      // : BreakCount(0), ContinueCount(0) 
      //START JInit
      this.BreakCount = $int2ulong(0);
      this.ContinueCount = $int2ulong(0);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::BreakContinue::BreakContinue">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 219,
     FQN="(anonymous namespace)::ComputeRegionCounts::BreakContinue::BreakContinue", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts13BreakContinueC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts13BreakContinueC1EOS1_")
    //</editor-fold>
    public /*inline*/ BreakContinue(JD$Move _dparam, final BreakContinue /*&&*/$Prm0) {
      // : BreakCount(static_cast<BreakContinue &&>().BreakCount), ContinueCount(static_cast<BreakContinue &&>().ContinueCount) 
      //START JInit
      this.BreakCount = $Prm0.BreakCount;
      this.ContinueCount = $Prm0.ContinueCount;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "BreakCount=" + BreakCount // NOI18N
                + ", ContinueCount=" + ContinueCount; // NOI18N
    }
  };
  public SmallVector<BreakContinue> BreakContinueStack;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::ComputeRegionCounts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 226,
   FQN="(anonymous namespace)::ComputeRegionCounts::ComputeRegionCounts", NM="_ZN12_GLOBAL__N_119ComputeRegionCountsC1ERN4llvm8DenseMapIPKN5clang4StmtEyNS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_yEEEERNS3_7CodeGen10CodeGenPGOE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCountsC1ERN4llvm8DenseMapIPKN5clang4StmtEyNS1_12DenseMapInfoIS6_EENS1_6detail12DenseMapPairIS6_yEEEERNS3_7CodeGen10CodeGenPGOE")
  //</editor-fold>
  public ComputeRegionCounts(final DenseMapTypeULong</*const*/ Stmt /*P*/ > /*&*/ CountMap, 
      final CodeGenPGO /*&*/ PGO) {
    // : ConstStmtVisitor<ComputeRegionCounts>(), PGO(PGO), RecordNextStmtCount(false), CountMap(CountMap), BreakContinueStack() 
    //START JInit
    $ConstStmtVisitor();
    this./*&*/PGO=/*&*/PGO;
    this.RecordNextStmtCount = false;
    this./*&*/CountMap=/*&*/CountMap;
    this.BreakContinueStack = new SmallVector<BreakContinue>(8, new BreakContinue());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::RecordStmtCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 230,
   FQN="(anonymous namespace)::ComputeRegionCounts::RecordStmtCount", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts15RecordStmtCountEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts15RecordStmtCountEPKN5clang4StmtE")
  //</editor-fold>
  public void RecordStmtCount(/*const*/ Stmt /*P*/ S) {
    if (RecordNextStmtCount) {
      CountMap.$set(S, CurrentCount);
      RecordNextStmtCount = false;
    }
  }

  
  /// Set and return the current count.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::setCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 238,
   FQN="(anonymous namespace)::ComputeRegionCounts::setCount", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts8setCountEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts8setCountEy")
  //</editor-fold>
  public long/*uint64_t*/ setCount(long/*uint64_t*/ Count) {
    CurrentCount = Count;
    return Count;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 243,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts9VisitStmtEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts9VisitStmtEPKN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(/*const*/ Stmt /*P*/ S) {
    RecordStmtCount(S);
    for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
      if ((Child != null)) {
        /*J:ToBase*/ConstStmtVisitorVoid /*P*/ .super.Visit(Child);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitFunctionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 250,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitFunctionDecl", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitFunctionDeclEPKN5clang12FunctionDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitFunctionDeclEPKN5clang12FunctionDeclE")
  //</editor-fold>
  public void VisitFunctionDecl(/*const*/ FunctionDecl /*P*/ D) {
    // Counter tracks entry to the function body.
    long/*uint64_t*/ BodyCount = setCount(PGO.getRegionCount(D.getBody()));
    CountMap.$set(D.getBody(), BodyCount);
    Visit(D.getBody());
  }

  
  // Skip lambda expressions. We visit these as FunctionDecls when we're
  // generating them and aren't interested in the body when generating a
  // parent context.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitLambdaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 260,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitLambdaExpr", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitLambdaExprEPKN5clang10LambdaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitLambdaExprEPKN5clang10LambdaExprE")
  //</editor-fold>
  public void VisitLambdaExpr(/*const*/ LambdaExpr /*P*/ LE) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitCapturedDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 262,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitCapturedDecl", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitCapturedDeclEPKN5clang12CapturedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitCapturedDeclEPKN5clang12CapturedDeclE")
  //</editor-fold>
  public void VisitCapturedDecl(/*const*/ CapturedDecl /*P*/ D) {
    // Counter tracks entry to the capture body.
    long/*uint64_t*/ BodyCount = setCount(PGO.getRegionCount(D.getBody()));
    CountMap.$set(D.getBody(), BodyCount);
    Visit(D.getBody());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitObjCMethodDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 269,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitObjCMethodDecl", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts19VisitObjCMethodDeclEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts19VisitObjCMethodDeclEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  public void VisitObjCMethodDecl(/*const*/ ObjCMethodDecl /*P*/ D) {
    // Counter tracks entry to the method body.
    long/*uint64_t*/ BodyCount = setCount(PGO.getRegionCount(D.getBody()));
    CountMap.$set(D.getBody(), BodyCount);
    Visit(D.getBody());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitBlockDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 276,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitBlockDecl", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts14VisitBlockDeclEPKN5clang9BlockDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts14VisitBlockDeclEPKN5clang9BlockDeclE")
  //</editor-fold>
  public void VisitBlockDecl(/*const*/ BlockDecl /*P*/ D) {
    // Counter tracks entry to the block body.
    long/*uint64_t*/ BodyCount = setCount(PGO.getRegionCount(D.getBody()));
    CountMap.$set(D.getBody(), BodyCount);
    Visit(D.getBody());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitReturnStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 283,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitReturnStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitReturnStmtEPKN5clang10ReturnStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitReturnStmtEPKN5clang10ReturnStmtE")
  //</editor-fold>
  public void VisitReturnStmt(/*const*/ ReturnStmt /*P*/ S) {
    RecordStmtCount(S);
    if ((S.getRetValue$Const() != null)) {
      Visit(S.getRetValue$Const());
    }
    CurrentCount = $int2ulong(0);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 291,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitCXXThrowExpr", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitCXXThrowExprEPKN5clang12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitCXXThrowExprEPKN5clang12CXXThrowExprE")
  //</editor-fold>
  public void VisitCXXThrowExpr(/*const*/ CXXThrowExpr /*P*/ E) {
    RecordStmtCount(E);
    if ((E.getSubExpr$Const() != null)) {
      Visit(E.getSubExpr$Const());
    }
    CurrentCount = $int2ulong(0);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitGotoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 299,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitGotoStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts13VisitGotoStmtEPKN5clang8GotoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts13VisitGotoStmtEPKN5clang8GotoStmtE")
  //</editor-fold>
  public void VisitGotoStmt(/*const*/ GotoStmt /*P*/ S) {
    RecordStmtCount(S);
    CurrentCount = $int2ulong(0);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitLabelStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 305,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitLabelStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts14VisitLabelStmtEPKN5clang9LabelStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts14VisitLabelStmtEPKN5clang9LabelStmtE")
  //</editor-fold>
  public void VisitLabelStmt(/*const*/ LabelStmt /*P*/ S) {
    RecordNextStmtCount = false;
    // Counter tracks the block following the label.
    long/*uint64_t*/ BlockCount = setCount(PGO.getRegionCount(S));
    CountMap.$set(S, BlockCount);
    Visit(S.getSubStmt$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitBreakStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 313,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitBreakStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts14VisitBreakStmtEPKN5clang9BreakStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts14VisitBreakStmtEPKN5clang9BreakStmtE")
  //</editor-fold>
  public void VisitBreakStmt(/*const*/ BreakStmt /*P*/ S) {
    RecordStmtCount(S);
    assert (!BreakContinueStack.empty()) : "break not in a loop or switch!";
    BreakContinueStack.back().BreakCount += CurrentCount;
    CurrentCount = $int2ulong(0);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitContinueStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 321,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitContinueStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitContinueStmtEPKN5clang12ContinueStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitContinueStmtEPKN5clang12ContinueStmtE")
  //</editor-fold>
  public void VisitContinueStmt(/*const*/ ContinueStmt /*P*/ S) {
    RecordStmtCount(S);
    assert (!BreakContinueStack.empty()) : "continue stmt not in a loop!";
    BreakContinueStack.back().ContinueCount += CurrentCount;
    CurrentCount = $int2ulong(0);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitWhileStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 329,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitWhileStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts14VisitWhileStmtEPKN5clang9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts14VisitWhileStmtEPKN5clang9WhileStmtE")
  //</editor-fold>
  public void VisitWhileStmt(/*const*/ WhileStmt /*P*/ S) {
    RecordStmtCount(S);
    long/*uint64_t*/ ParentCount = CurrentCount;
    
    BreakContinueStack.push_back(new BreakContinue());
    // Visit the body region first so the break/continue adjustments can be
    // included when visiting the condition.
    long/*uint64_t*/ BodyCount = setCount(PGO.getRegionCount(S));
    CountMap.$set(S.getBody$Const(), CurrentCount);
    Visit(S.getBody$Const());
    long/*uint64_t*/ BackedgeCount = CurrentCount;
    
    // ...then go back and propagate counts through the condition. The count
    // at the start of the condition is the sum of the incoming edges,
    // the backedge from the end of the loop body, and the edges from
    // continue statements.
    BreakContinue BC = BreakContinueStack.pop_back_val();
    long/*uint64_t*/ CondCount = setCount(ParentCount + BackedgeCount + BC.ContinueCount);
    CountMap.$set(S.getCond$Const(), CondCount);
    Visit(S.getCond$Const());
    setCount(BC.BreakCount + CondCount - BodyCount);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitDoStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 354,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitDoStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts11VisitDoStmtEPKN5clang6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts11VisitDoStmtEPKN5clang6DoStmtE")
  //</editor-fold>
  public void VisitDoStmt(/*const*/ DoStmt /*P*/ S) {
    RecordStmtCount(S);
    long/*uint64_t*/ LoopCount = PGO.getRegionCount(S);
    
    BreakContinueStack.push_back(new BreakContinue());
    // The count doesn't include the fallthrough from the parent scope. Add it.
    long/*uint64_t*/ BodyCount = setCount(LoopCount + CurrentCount);
    CountMap.$set(S.getBody$Const(), BodyCount);
    Visit(S.getBody$Const());
    long/*uint64_t*/ BackedgeCount = CurrentCount;
    
    BreakContinue BC = BreakContinueStack.pop_back_val();
    // The count at the start of the condition is equal to the count at the
    // end of the body, plus any continues.
    long/*uint64_t*/ CondCount = setCount(BackedgeCount + BC.ContinueCount);
    CountMap.$set(S.getCond$Const(), CondCount);
    Visit(S.getCond$Const());
    setCount(BC.BreakCount + CondCount - LoopCount);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitForStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 375,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitForStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts12VisitForStmtEPKN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts12VisitForStmtEPKN5clang7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(/*const*/ ForStmt /*P*/ S) {
    RecordStmtCount(S);
    if ((S.getInit$Const() != null)) {
      Visit(S.getInit$Const());
    }
    
    long/*uint64_t*/ ParentCount = CurrentCount;
    
    BreakContinueStack.push_back(new BreakContinue());
    // Visit the body region first. (This is basically the same as a while
    // loop; see further comments in VisitWhileStmt.)
    long/*uint64_t*/ BodyCount = setCount(PGO.getRegionCount(S));
    CountMap.$set(S.getBody$Const(), BodyCount);
    Visit(S.getBody$Const());
    long/*uint64_t*/ BackedgeCount = CurrentCount;
    BreakContinue BC = BreakContinueStack.pop_back_val();
    
    // The increment is essentially part of the body but it needs to include
    // the count for all the continue statements.
    if ((S.getInc$Const() != null)) {
      long/*uint64_t*/ IncCount = setCount(BackedgeCount + BC.ContinueCount);
      CountMap.$set(S.getInc$Const(), IncCount);
      Visit(S.getInc$Const());
    }
    
    // ...then go back and propagate counts through the condition.
    long/*uint64_t*/ CondCount = setCount(ParentCount + BackedgeCount + BC.ContinueCount);
    if ((S.getCond$Const() != null)) {
      CountMap.$set(S.getCond$Const(), CondCount);
      Visit(S.getCond$Const());
    }
    setCount(BC.BreakCount + CondCount - BodyCount);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitCXXForRangeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 410,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitCXXForRangeStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts20VisitCXXForRangeStmtEPKN5clang15CXXForRangeStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts20VisitCXXForRangeStmtEPKN5clang15CXXForRangeStmtE")
  //</editor-fold>
  public void VisitCXXForRangeStmt(/*const*/ CXXForRangeStmt /*P*/ S) {
    RecordStmtCount(S);
    Visit(S.getLoopVarStmt$Const());
    Visit(S.getRangeStmt$Const());
    Visit(S.getBeginStmt$Const());
    Visit(S.getEndStmt$Const());
    
    long/*uint64_t*/ ParentCount = CurrentCount;
    BreakContinueStack.push_back(new BreakContinue());
    // Visit the body region first. (This is basically the same as a while
    // loop; see further comments in VisitWhileStmt.)
    long/*uint64_t*/ BodyCount = setCount(PGO.getRegionCount(S));
    CountMap.$set(S.getBody$Const(), BodyCount);
    Visit(S.getBody$Const());
    long/*uint64_t*/ BackedgeCount = CurrentCount;
    BreakContinue BC = BreakContinueStack.pop_back_val();
    
    // The increment is essentially part of the body but it needs to include
    // the count for all the continue statements.
    long/*uint64_t*/ IncCount = setCount(BackedgeCount + BC.ContinueCount);
    CountMap.$set(S.getInc$Const(), IncCount);
    Visit(S.getInc$Const());
    
    // ...then go back and propagate counts through the condition.
    long/*uint64_t*/ CondCount = setCount(ParentCount + BackedgeCount + BC.ContinueCount);
    CountMap.$set(S.getCond$Const(), CondCount);
    Visit(S.getCond$Const());
    setCount(BC.BreakCount + CondCount - BodyCount);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitObjCForCollectionStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 442,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitObjCForCollectionStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts26VisitObjCForCollectionStmtEPKN5clang21ObjCForCollectionStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts26VisitObjCForCollectionStmtEPKN5clang21ObjCForCollectionStmtE")
  //</editor-fold>
  public void VisitObjCForCollectionStmt(/*const*/ ObjCForCollectionStmt /*P*/ S) {
    RecordStmtCount(S);
    Visit(S.getElement$Const());
    long/*uint64_t*/ ParentCount = CurrentCount;
    BreakContinueStack.push_back(new BreakContinue());
    // Counter tracks the body of the loop.
    long/*uint64_t*/ BodyCount = setCount(PGO.getRegionCount(S));
    CountMap.$set(S.getBody$Const(), BodyCount);
    Visit(S.getBody$Const());
    long/*uint64_t*/ BackedgeCount = CurrentCount;
    BreakContinue BC = BreakContinueStack.pop_back_val();
    
    setCount(BC.BreakCount + ParentCount + BackedgeCount + BC.ContinueCount
           - BodyCount);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitSwitchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 459,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitSwitchStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitSwitchStmtEPKN5clang10SwitchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitSwitchStmtEPKN5clang10SwitchStmtE")
  //</editor-fold>
  public void VisitSwitchStmt(/*const*/ SwitchStmt /*P*/ S) {
    RecordStmtCount(S);
    Visit(S.getCond$Const());
    CurrentCount = $int2ulong(0);
    BreakContinueStack.push_back(new BreakContinue());
    Visit(S.getBody$Const());
    // If the switch is inside a loop, add the continue counts.
    BreakContinue BC = BreakContinueStack.pop_back_val();
    if (!BreakContinueStack.empty()) {
      BreakContinueStack.back().ContinueCount += BC.ContinueCount;
    }
    // Counter tracks the exit block of the switch.
    setCount(PGO.getRegionCount(S));
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitSwitchCase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 474,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitSwitchCase", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitSwitchCaseEPKN5clang10SwitchCaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitSwitchCaseEPKN5clang10SwitchCaseE")
  //</editor-fold>
  public void VisitSwitchCase(/*const*/ SwitchCase /*P*/ S) {
    RecordNextStmtCount = false;
    // Counter for this particular case. This counts only jumps from the
    // switch header and does not include fallthrough from the case before
    // this one.
    long/*uint64_t*/ CaseCount = PGO.getRegionCount(S);
    setCount(CurrentCount + CaseCount);
    // We need the count without fallthrough in the mapping, so it's more useful
    // for branch probabilities.
    CountMap.$set(S, CaseCount);
    RecordNextStmtCount = true;
    Visit(S.getSubStmt$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 488,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitIfStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts11VisitIfStmtEPKN5clang6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts11VisitIfStmtEPKN5clang6IfStmtE")
  //</editor-fold>
  public void VisitIfStmt(/*const*/ IfStmt /*P*/ S) {
    RecordStmtCount(S);
    long/*uint64_t*/ ParentCount = CurrentCount;
    Visit(S.getCond$Const());
    
    // Counter tracks the "then" part of an if statement. The count for
    // the "else" part, if it exists, will be calculated from this counter.
    long/*uint64_t*/ ThenCount = setCount(PGO.getRegionCount(S));
    CountMap.$set(S.getThen$Const(), ThenCount);
    Visit(S.getThen$Const());
    long/*uint64_t*/ OutCount = CurrentCount;
    
    long/*uint64_t*/ ElseCount = ParentCount - ThenCount;
    if ((S.getElse$Const() != null)) {
      setCount(ElseCount);
      CountMap.$set(S.getElse$Const(), ElseCount);
      Visit(S.getElse$Const());
      OutCount += CurrentCount;
    } else {
      OutCount += ElseCount;
    }
    setCount(OutCount);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitCXXTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 512,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitCXXTryStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitCXXTryStmtEPKN5clang10CXXTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts15VisitCXXTryStmtEPKN5clang10CXXTryStmtE")
  //</editor-fold>
  public void VisitCXXTryStmt(/*const*/ CXXTryStmt /*P*/ S) {
    RecordStmtCount(S);
    Visit(S.getTryBlock$Const());
    for (/*uint*/int I = 0, E = S.getNumHandlers(); $less_uint(I, E); ++I)  {
      Visit(S.getHandler$Const(I));
    }
    // Counter tracks the continuation block of the try statement.
    setCount(PGO.getRegionCount(S));
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitCXXCatchStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 522,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitCXXCatchStmt", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitCXXCatchStmtEPKN5clang12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts17VisitCXXCatchStmtEPKN5clang12CXXCatchStmtE")
  //</editor-fold>
  public void VisitCXXCatchStmt(/*const*/ CXXCatchStmt /*P*/ S) {
    RecordNextStmtCount = false;
    // Counter tracks the catch statement's handler block.
    long/*uint64_t*/ CatchCount = setCount(PGO.getRegionCount(S));
    CountMap.$set(S, CatchCount);
    Visit(S.getHandlerBlock());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 530,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitAbstractConditionalOperator", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE")
  //</editor-fold>
  public void VisitAbstractConditionalOperator(/*const*/ AbstractConditionalOperator /*P*/ E) {
    RecordStmtCount(E);
    long/*uint64_t*/ ParentCount = CurrentCount;
    Visit(E.getCond());
    
    // Counter tracks the "true" part of a conditional operator. The
    // count in the "false" part will be calculated from this counter.
    long/*uint64_t*/ TrueCount = setCount(PGO.getRegionCount(E));
    CountMap.$set(E.getTrueExpr(), TrueCount);
    Visit(E.getTrueExpr());
    long/*uint64_t*/ OutCount = CurrentCount;
    
    long/*uint64_t*/ FalseCount = setCount(ParentCount - TrueCount);
    CountMap.$set(E.getFalseExpr(), FalseCount);
    Visit(E.getFalseExpr());
    OutCount += CurrentCount;
    
    setCount(OutCount);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitBinLAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 551,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitBinLAnd", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts12VisitBinLAndEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts12VisitBinLAndEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinLAnd(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    RecordStmtCount(E);
    long/*uint64_t*/ ParentCount = CurrentCount;
    Visit(E.getLHS());
    // Counter tracks the right hand side of a logical and operator.
    long/*uint64_t*/ RHSCount = setCount(PGO.getRegionCount(E));
    CountMap.$set(E.getRHS(), RHSCount);
    Visit(E.getRHS());
    setCount(ParentCount + RHSCount - CurrentCount);
    RecordNextStmtCount = true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::VisitBinLOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 563,
   FQN="(anonymous namespace)::ComputeRegionCounts::VisitBinLOr", NM="_ZN12_GLOBAL__N_119ComputeRegionCounts11VisitBinLOrEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCounts11VisitBinLOrEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinLOr(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
    RecordStmtCount(E);
    long/*uint64_t*/ ParentCount = CurrentCount;
    Visit(E.getLHS());
    // Counter tracks the right hand side of a logical or operator.
    long/*uint64_t*/ RHSCount = setCount(PGO.getRegionCount(E));
    CountMap.$set(E.getRHS(), RHSCount);
    Visit(E.getRHS());
    setCount(ParentCount + RHSCount - CurrentCount);
    RecordNextStmtCount = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeRegionCounts::~ComputeRegionCounts">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 204,
   FQN="(anonymous namespace)::ComputeRegionCounts::~ComputeRegionCounts", NM="_ZN12_GLOBAL__N_119ComputeRegionCountsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN12_GLOBAL__N_119ComputeRegionCountsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    BreakContinueStack.$destroy();
    ConstStmtVisitorVoid.super.$destroy$ConstStmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "PGO=" + PGO // NOI18N
              + ", RecordNextStmtCount=" + RecordNextStmtCount // NOI18N
              + ", CurrentCount=" + CurrentCount // NOI18N
              + ", CountMap=" + "[DenseMapTypeULong$Stmt]" // NOI18N
              + ", BreakContinueStack=" + BreakContinueStack // NOI18N
              + super.toString(); // NOI18N
  }
}
