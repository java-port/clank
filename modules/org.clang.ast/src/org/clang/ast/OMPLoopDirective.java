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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.basic.BasicClangGlobals.*;


/// \brief This is a common base class for loop directives ('omp simd', 'omp
/// for', 'omp for simd' etc.). It is responsible for the loop code generation.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 293,
 FQN="clang::OMPLoopDirective", NM="_ZN5clang16OMPLoopDirectiveE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirectiveE")
//</editor-fold>
public class OMPLoopDirective extends /*public*/ OMPExecutableDirective {
  /*friend  class ASTStmtReader*/
  /// \brief Number of collapsed loops as specified by 'collapse' clause.
  private /*uint*/int CollapsedNum;
  
  /// \brief Offsets to the stored exprs.
  /// This enumeration contains offsets to all the pointers to children
  /// expressions stored in OMPLoopDirective.
  /// The first 9 children are nesessary for all the loop directives, and
  /// the next 10 are specific to the worksharing ones.
  /// After the fixed children, three arrays of length CollapsedNum are
  /// allocated: loop counters, their updates and final values.
  /// PrevLowerBound and PrevUpperBound are used to communicate blocking
  /// information in composite constructs which require loop blocking
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 308,
   FQN="clang::OMPLoopDirective::(anonymous)", NM="_ZN5clang16OMPLoopDirectiveE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirectiveE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    AssociatedStmtOffset(0),
    IterationVariableOffset(1),
    LastIterationOffset(2),
    CalcLastIterationOffset(3),
    PreConditionOffset(4),
    CondOffset(5),
    InitOffset(6),
    IncOffset(7),
    PreInitsOffset(8),
    // The '...End' enumerators do not correspond to child expressions - they
    // specify the offset to the end (and start of the following counters/
    // updates/finals arrays).
    DefaultEnd(9),
    // The following 7 exprs are used by worksharing loops only.
    IsLastIterVariableOffset(9),
    LowerBoundVariableOffset(10),
    UpperBoundVariableOffset(11),
    StrideVariableOffset(12),
    EnsureUpperBoundOffset(13),
    NextLowerBoundOffset(14),
    NextUpperBoundOffset(15),
    NumIterationsOffset(16),
    PrevLowerBoundVariableOffset(17),
    PrevUpperBoundVariableOffset(18),
    // Offset to the end (and start of the following counters/updates/finals
    // arrays) for worksharing loop directives.
    WorksharingEnd(19);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum valueOf(int val) {
      Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum[] VALUES;
      private static final Unnamed_enum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum kind : Unnamed_enum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Get the counters storage.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 339,
   FQN="clang::OMPLoopDirective::getCounters", NM="_ZN5clang16OMPLoopDirective11getCountersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11getCountersEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getCounters() {
    type$ptr<Expr /*P*/ /*P*/> Storage = $tryClone(((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(((std.next(child_begin(), getArraysOffset(getDirectiveKind()))).$star())))));
    return new MutableArrayRef<Expr /*P*/ >(Storage, CollapsedNum, true);
  }

  
  /// \brief Get the private counters storage.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getPrivateCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 346,
   FQN="clang::OMPLoopDirective::getPrivateCounters", NM="_ZN5clang16OMPLoopDirective18getPrivateCountersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective18getPrivateCountersEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getPrivateCounters() {
    type$ptr<Expr /*P*/ /*P*/> Storage = $tryClone(((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(std.next(child_begin(), getArraysOffset(getDirectiveKind()) + CollapsedNum).$star()))));
    return new MutableArrayRef<Expr /*P*/ >(Storage, CollapsedNum, true);
  }

  
  /// \brief Get the updates storage.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 353,
   FQN="clang::OMPLoopDirective::getInits", NM="_ZN5clang16OMPLoopDirective8getInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective8getInitsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getInits() {
    type$ptr<Expr /*P*/ /*P*/> Storage = $tryClone(((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(std.next(child_begin(), 
        getArraysOffset(getDirectiveKind()) + 2 * CollapsedNum).$star()))));
    return new MutableArrayRef<Expr /*P*/ >(Storage, CollapsedNum, true);
  }

  
  /// \brief Get the updates storage.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getUpdates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 361,
   FQN="clang::OMPLoopDirective::getUpdates", NM="_ZN5clang16OMPLoopDirective10getUpdatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective10getUpdatesEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getUpdates() {
    type$ptr<Expr /*P*/ /*P*/> Storage = $tryClone(((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(std.next(child_begin(), 
        getArraysOffset(getDirectiveKind()) + 3 * CollapsedNum).$star()))));
    return new MutableArrayRef<Expr /*P*/ >(Storage, CollapsedNum, true);
  }

  
  /// \brief Get the final counter updates storage.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getFinals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 369,
   FQN="clang::OMPLoopDirective::getFinals", NM="_ZN5clang16OMPLoopDirective9getFinalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective9getFinalsEv")
  //</editor-fold>
  private MutableArrayRef<Expr /*P*/ > getFinals() {
    type$ptr<Expr /*P*/ /*P*/> Storage = $tryClone(((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(std.next(child_begin(), 
        getArraysOffset(getDirectiveKind()) + 4 * CollapsedNum).$star()))));
    return new MutableArrayRef<Expr /*P*/ >(Storage, CollapsedNum, true);
  }

/*protected:*/
  /// \brief Build instance of loop directive of class \a Kind.
  ///
  /// \param SC Statement class.
  /// \param Kind Kind of OpenMP directive.
  /// \param StartLoc Starting location of the directive (directive keyword).
  /// \param EndLoc Ending location of the directive.
  /// \param CollapsedNum Number of collapsed loops from 'collapse' clause.
  /// \param NumClauses Number of clauses.
  /// \param NumSpecialChildren Number of additional directive-specific stmts.
  ///
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::OMPLoopDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 388,
   FQN="clang::OMPLoopDirective::OMPLoopDirective", NM="Tpl__ZN5clang16OMPLoopDirectiveC1EPKT_NS_4Stmt9StmtClassENS_19OpenMPDirectiveKindENS_14SourceLocationES7_jjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=Tpl__ZN5clang16OMPLoopDirectiveC1EPKT_NS_4Stmt9StmtClassENS_19OpenMPDirectiveKindENS_14SourceLocationES7_jjj")
  //</editor-fold>
  protected </*typename*/ T> OMPLoopDirective(/*const*/ T /*P*/ That, StmtClass SC, OpenMPDirectiveKind Kind, 
      SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int CollapsedNum, /*uint*/int NumClauses) {
    $OMPLoopDirective(That, SC, Kind, StartLoc, EndLoc, CollapsedNum, NumClauses);
  }
  protected final </*typename*/ T> void $OMPLoopDirective(/*const*/ T /*P*/ That, StmtClass SC, OpenMPDirectiveKind Kind, 
      SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int CollapsedNum, /*uint*/int NumClauses) {
    $OMPLoopDirective(That, SC, Kind, 
      StartLoc, EndLoc, 
      CollapsedNum, NumClauses, 
      0);
  }
  protected </*typename*/ T> OMPLoopDirective(/*const*/ T /*P*/ That, StmtClass SC, OpenMPDirectiveKind Kind, 
      SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int CollapsedNum, /*uint*/int NumClauses, 
      /*uint*/int NumSpecialChildren/*= 0*/) {
    $OMPLoopDirective(That, SC, Kind, StartLoc, EndLoc, CollapsedNum, NumClauses, NumSpecialChildren);
  }
  protected final </*typename*/ T> void $OMPLoopDirective(/*const*/ T /*P*/ That, StmtClass SC, OpenMPDirectiveKind Kind, 
      SourceLocation StartLoc, SourceLocation EndLoc, 
      /*uint*/int CollapsedNum, /*uint*/int NumClauses, 
      /*uint*/int NumSpecialChildren/*= 0*/) {
    // : OMPExecutableDirective(That, SC, Kind, StartLoc, EndLoc, NumClauses, numLoopChildren(CollapsedNum, Kind) + NumSpecialChildren), CollapsedNum(CollapsedNum) 
    //START JInit
    /*ParenListExpr*/$OMPExecutableDirective(That, SC, Kind, StartLoc, EndLoc, NumClauses, numLoopChildren(CollapsedNum, Kind)
       + NumSpecialChildren);
    this.CollapsedNum = CollapsedNum;
    //END JInit
  }

  
  /// \brief Offset to the start of children expression arrays.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getArraysOffset">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 398,
   FQN="clang::OMPLoopDirective::getArraysOffset", NM="_ZN5clang16OMPLoopDirective15getArraysOffsetENS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective15getArraysOffsetENS_19OpenMPDirectiveKindE")
  //</editor-fold>
  protected static /*uint*/int getArraysOffset(OpenMPDirectiveKind Kind) {
    return (isOpenMPWorksharingDirective(Kind)
       || isOpenMPTaskLoopDirective(Kind)
       || isOpenMPDistributeDirective(Kind)) ? Unnamed_enum.WorksharingEnd.getValue() : Unnamed_enum.DefaultEnd.getValue();
  }

  
  /// \brief Children number.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::numLoopChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 407,
   FQN="clang::OMPLoopDirective::numLoopChildren", NM="_ZN5clang16OMPLoopDirective15numLoopChildrenEjNS_19OpenMPDirectiveKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective15numLoopChildrenEjNS_19OpenMPDirectiveKindE")
  //</editor-fold>
  protected static /*uint*/int numLoopChildren(/*uint*/int CollapsedNum, 
                 OpenMPDirectiveKind Kind) {
    return getArraysOffset(Kind) + 5 * CollapsedNum; // Counters,
    // PrivateCounters, Inits,
    // Updates and Finals
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setIterationVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 414,
   FQN="clang::OMPLoopDirective::setIterationVariable", NM="_ZN5clang16OMPLoopDirective20setIterationVariableEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective20setIterationVariableEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setIterationVariable(Expr /*P*/ IV) {
    std.next(child_begin(), Unnamed_enum.IterationVariableOffset.getValue()).star$ref().$set(IV);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setLastIteration">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 417,
   FQN="clang::OMPLoopDirective::setLastIteration", NM="_ZN5clang16OMPLoopDirective16setLastIterationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective16setLastIterationEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setLastIteration(Expr /*P*/ LI) {
    std.next(child_begin(), Unnamed_enum.LastIterationOffset.getValue()).star$ref().$set(LI);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setCalcLastIteration">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 420,
   FQN="clang::OMPLoopDirective::setCalcLastIteration", NM="_ZN5clang16OMPLoopDirective20setCalcLastIterationEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective20setCalcLastIterationEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setCalcLastIteration(Expr /*P*/ CLI) {
    std.next(child_begin(), Unnamed_enum.CalcLastIterationOffset.getValue()).star$ref().$set(CLI);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setPreCond">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 423,
   FQN="clang::OMPLoopDirective::setPreCond", NM="_ZN5clang16OMPLoopDirective10setPreCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective10setPreCondEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setPreCond(Expr /*P*/ PC) {
    std.next(child_begin(), Unnamed_enum.PreConditionOffset.getValue()).star$ref().$set(PC);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setCond">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 426,
   FQN="clang::OMPLoopDirective::setCond", NM="_ZN5clang16OMPLoopDirective7setCondEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective7setCondEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setCond(Expr /*P*/ Cond) {
    std.next(child_begin(), Unnamed_enum.CondOffset.getValue()).star$ref().$set(Cond);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setInit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 429,
   FQN="clang::OMPLoopDirective::setInit", NM="_ZN5clang16OMPLoopDirective7setInitEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective7setInitEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setInit(Expr /*P*/ Init) {
    std.next(child_begin(), Unnamed_enum.InitOffset.getValue()).star$ref().$set(Init);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setInc">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 430,
   FQN="clang::OMPLoopDirective::setInc", NM="_ZN5clang16OMPLoopDirective6setIncEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective6setIncEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setInc(Expr /*P*/ Inc) {
    std.next(child_begin(), Unnamed_enum.IncOffset.getValue()).star$ref().$set(Inc);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setPreInits">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 431,
   FQN="clang::OMPLoopDirective::setPreInits", NM="_ZN5clang16OMPLoopDirective11setPreInitsEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11setPreInitsEPNS_4StmtE")
  //</editor-fold>
  /*friend*/public void setPreInits(Stmt /*P*/ PreInits) {
    std.next(child_begin(), Unnamed_enum.PreInitsOffset.getValue()).star$ref().$set(PreInits);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setIsLastIterVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 434,
   FQN="clang::OMPLoopDirective::setIsLastIterVariable", NM="_ZN5clang16OMPLoopDirective21setIsLastIterVariableEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective21setIsLastIterVariableEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setIsLastIterVariable(Expr /*P*/ IL) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.IsLastIterVariableOffset.getValue()).star$ref().$set(IL);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setLowerBoundVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 441,
   FQN="clang::OMPLoopDirective::setLowerBoundVariable", NM="_ZN5clang16OMPLoopDirective21setLowerBoundVariableEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective21setLowerBoundVariableEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setLowerBoundVariable(Expr /*P*/ LB) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.LowerBoundVariableOffset.getValue()).star$ref().$set(LB);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setUpperBoundVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 448,
   FQN="clang::OMPLoopDirective::setUpperBoundVariable", NM="_ZN5clang16OMPLoopDirective21setUpperBoundVariableEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective21setUpperBoundVariableEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setUpperBoundVariable(Expr /*P*/ UB) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.UpperBoundVariableOffset.getValue()).star$ref().$set(UB);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setStrideVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 455,
   FQN="clang::OMPLoopDirective::setStrideVariable", NM="_ZN5clang16OMPLoopDirective17setStrideVariableEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective17setStrideVariableEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setStrideVariable(Expr /*P*/ ST) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.StrideVariableOffset.getValue()).star$ref().$set(ST);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setEnsureUpperBound">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 462,
   FQN="clang::OMPLoopDirective::setEnsureUpperBound", NM="_ZN5clang16OMPLoopDirective19setEnsureUpperBoundEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective19setEnsureUpperBoundEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setEnsureUpperBound(Expr /*P*/ EUB) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.EnsureUpperBoundOffset.getValue()).star$ref().$set(EUB);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setNextLowerBound">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 469,
   FQN="clang::OMPLoopDirective::setNextLowerBound", NM="_ZN5clang16OMPLoopDirective17setNextLowerBoundEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective17setNextLowerBoundEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setNextLowerBound(Expr /*P*/ NLB) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.NextLowerBoundOffset.getValue()).star$ref().$set(NLB);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setNextUpperBound">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 476,
   FQN="clang::OMPLoopDirective::setNextUpperBound", NM="_ZN5clang16OMPLoopDirective17setNextUpperBoundEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective17setNextUpperBoundEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setNextUpperBound(Expr /*P*/ NUB) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.NextUpperBoundOffset.getValue()).star$ref().$set(NUB);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setNumIterations">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 483,
   FQN="clang::OMPLoopDirective::setNumIterations", NM="_ZN5clang16OMPLoopDirective16setNumIterationsEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective16setNumIterationsEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setNumIterations(Expr /*P*/ NI) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.NumIterationsOffset.getValue()).star$ref().$set(NI);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setPrevLowerBoundVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 490,
   FQN="clang::OMPLoopDirective::setPrevLowerBoundVariable", NM="_ZN5clang16OMPLoopDirective25setPrevLowerBoundVariableEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective25setPrevLowerBoundVariableEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setPrevLowerBoundVariable(Expr /*P*/ PrevLB) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.PrevLowerBoundVariableOffset.getValue()).star$ref().$set(PrevLB);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setPrevUpperBoundVariable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 497,
   FQN="clang::OMPLoopDirective::setPrevUpperBoundVariable", NM="_ZN5clang16OMPLoopDirective25setPrevUpperBoundVariableEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective25setPrevUpperBoundVariableEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setPrevUpperBoundVariable(Expr /*P*/ PrevUB) {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    std.next(child_begin(), Unnamed_enum.PrevUpperBoundVariableOffset.getValue()).star$ref().$set(PrevUB);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 26,
   FQN="clang::OMPLoopDirective::setCounters", NM="_ZN5clang16OMPLoopDirective11setCountersEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11setCountersEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setCounters(ArrayRef<Expr /*P*/ > A) {
    assert (A.size() == getCollapsedNumber()) : "Number of loop counters is not the same as the collapsed number";
    std.copy(A.begin(), A.end(), getCounters().begin());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setPrivateCounters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 32,
   FQN="clang::OMPLoopDirective::setPrivateCounters", NM="_ZN5clang16OMPLoopDirective18setPrivateCountersEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective18setPrivateCountersEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setPrivateCounters(ArrayRef<Expr /*P*/ > A) {
    assert (A.size() == getCollapsedNumber()) : "Number of loop private counters is not the same as the collapsed number";
    std.copy(A.begin(), A.end(), getPrivateCounters().begin());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 39,
   FQN="clang::OMPLoopDirective::setInits", NM="_ZN5clang16OMPLoopDirective8setInitsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective8setInitsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setInits(ArrayRef<Expr /*P*/ > A) {
    assert (A.size() == getCollapsedNumber()) : "Number of counter inits is not the same as the collapsed number";
    std.copy(A.begin(), A.end(), getInits().begin());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setUpdates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 45,
   FQN="clang::OMPLoopDirective::setUpdates", NM="_ZN5clang16OMPLoopDirective10setUpdatesEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective10setUpdatesEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setUpdates(ArrayRef<Expr /*P*/ > A) {
    assert (A.size() == getCollapsedNumber()) : "Number of counter updates is not the same as the collapsed number";
    std.copy(A.begin(), A.end(), getUpdates().begin());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::setFinals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp", line = 51,
   FQN="clang::OMPLoopDirective::setFinals", NM="_ZN5clang16OMPLoopDirective9setFinalsEN4llvm8ArrayRefIPNS_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective9setFinalsEN4llvm8ArrayRefIPNS_4ExprEEE")
  //</editor-fold>
  /*friend*/public void setFinals(ArrayRef<Expr /*P*/ > A) {
    assert (A.size() == getCollapsedNumber()) : "Number of counter finals is not the same as the collapsed number";
    std.copy(A.begin(), A.end(), getFinals().begin());
  }


/*public:*/
  /// \brief The expressions built for the OpenMP loop CodeGen for the
  /// whole collapsed loop nest.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::HelperExprs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 513,
   FQN="clang::OMPLoopDirective::HelperExprs", NM="_ZN5clang16OMPLoopDirective11HelperExprsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11HelperExprsE")
  //</editor-fold>
  public static class/*struct*/ HelperExprs implements Destructors.ClassWithDestructor {
    /// \brief Loop iteration variable.
    public Expr /*P*/ IterationVarRef;
    /// \brief Loop last iteration number.
    public Expr /*P*/ LastIteration;
    /// \brief Loop number of iterations.
    public Expr /*P*/ NumIterations;
    /// \brief Calculation of last iteration.
    public Expr /*P*/ CalcLastIteration;
    /// \brief Loop pre-condition.
    public Expr /*P*/ PreCond;
    /// \brief Loop condition.
    public Expr /*P*/ Cond;
    /// \brief Loop iteration variable init.
    public Expr /*P*/ Init;
    /// \brief Loop increment.
    public Expr /*P*/ Inc;
    /// \brief IsLastIteration - local flag variable passed to runtime.
    public Expr /*P*/ IL;
    /// \brief LowerBound - local variable passed to runtime.
    public Expr /*P*/ LB;
    /// \brief UpperBound - local variable passed to runtime.
    public Expr /*P*/ UB;
    /// \brief Stride - local variable passed to runtime.
    public Expr /*P*/ ST;
    /// \brief EnsureUpperBound -- expression LB = min(LB, NumIterations).
    public Expr /*P*/ EUB;
    /// \brief Update of LowerBound for statically sheduled 'omp for' loops.
    public Expr /*P*/ NLB;
    /// \brief Update of UpperBound for statically sheduled 'omp for' loops.
    public Expr /*P*/ NUB;
    /// \brief PreviousLowerBound - local variable passed to runtime in the
    /// enclosing schedule or null if that does not apply.
    public Expr /*P*/ PrevLB;
    /// \brief PreviousUpperBound - local variable passed to runtime in the
    /// enclosing schedule or null if that does not apply.
    public Expr /*P*/ PrevUB;
    /// \brief Counters Loop counters.
    public SmallVector<Expr /*P*/ > Counters;
    /// \brief PrivateCounters Loop counters.
    public SmallVector<Expr /*P*/ > PrivateCounters;
    /// \brief Expressions for loop counters inits for CodeGen.
    public SmallVector<Expr /*P*/ > Inits;
    /// \brief Expressions for loop counters update for CodeGen.
    public SmallVector<Expr /*P*/ > Updates;
    /// \brief Final loop counter values for GodeGen.
    public SmallVector<Expr /*P*/ > Finals;
    /// Init statement for all captured expressions.
    public Stmt /*P*/ PreInits;
    
    /// \brief Check if all the expressions are built (does not check the
    /// worksharing ones).
    //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::HelperExprs::builtAll">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 565,
     FQN="clang::OMPLoopDirective::HelperExprs::builtAll", NM="_ZN5clang16OMPLoopDirective11HelperExprs8builtAllEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11HelperExprs8builtAllEv")
    //</editor-fold>
    public boolean builtAll() {
      return IterationVarRef != null && LastIteration != null
         && NumIterations != null && PreCond != null
         && Cond != null && Init != null && Inc != null;
    }

    
    /// \brief Initialize all the fields to null.
    /// \param Size Number of elements in the counters/finals/updates arrays.
    //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::HelperExprs::clear">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 573,
     FQN="clang::OMPLoopDirective::HelperExprs::clear", NM="_ZN5clang16OMPLoopDirective11HelperExprs5clearEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11HelperExprs5clearEj")
    //</editor-fold>
    public void clear(/*uint*/int Size) {
      IterationVarRef = null;
      LastIteration = null;
      CalcLastIteration = null;
      PreCond = null;
      Cond = null;
      Init = null;
      Inc = null;
      IL = null;
      LB = null;
      UB = null;
      ST = null;
      EUB = null;
      NLB = null;
      NUB = null;
      NumIterations = null;
      PrevLB = null;
      PrevUB = null;
      Counters.resize(Size);
      PrivateCounters.resize(Size);
      Inits.resize(Size);
      Updates.resize(Size);
      Finals.resize(Size);
      for (/*uint*/int i = 0; $less_uint(i, Size); ++i) {
        Counters.$set(i, null);
        PrivateCounters.$set(i, null);
        Inits.$set(i, null);
        Updates.$set(i, null);
        Finals.$set(i, null);
      }
      PreInits = null;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::HelperExprs::HelperExprs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 513,
     FQN="clang::OMPLoopDirective::HelperExprs::HelperExprs", NM="_ZN5clang16OMPLoopDirective11HelperExprsC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11HelperExprsC1Ev")
    //</editor-fold>
    public /*inline*/ HelperExprs() {
      // : Counters(), PrivateCounters(), Inits(), Updates(), Finals() 
      //START JInit
      this.Counters = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      this.PrivateCounters = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      this.Inits = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      this.Updates = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      this.Finals = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::HelperExprs::~HelperExprs">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 513,
     FQN="clang::OMPLoopDirective::HelperExprs::~HelperExprs", NM="_ZN5clang16OMPLoopDirective11HelperExprsD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11HelperExprsD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      Finals.$destroy();
      Updates.$destroy();
      Inits.$destroy();
      PrivateCounters.$destroy();
      Counters.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "IterationVarRef=" + IterationVarRef // NOI18N
                + ", LastIteration=" + LastIteration // NOI18N
                + ", NumIterations=" + NumIterations // NOI18N
                + ", CalcLastIteration=" + CalcLastIteration // NOI18N
                + ", PreCond=" + PreCond // NOI18N
                + ", Cond=" + Cond // NOI18N
                + ", Init=" + Init // NOI18N
                + ", Inc=" + Inc // NOI18N
                + ", IL=" + IL // NOI18N
                + ", LB=" + LB // NOI18N
                + ", UB=" + UB // NOI18N
                + ", ST=" + ST // NOI18N
                + ", EUB=" + EUB // NOI18N
                + ", NLB=" + NLB // NOI18N
                + ", NUB=" + NUB // NOI18N
                + ", PrevLB=" + PrevLB // NOI18N
                + ", PrevUB=" + PrevUB // NOI18N
                + ", Counters=" + Counters // NOI18N
                + ", PrivateCounters=" + PrivateCounters // NOI18N
                + ", Inits=" + Inits // NOI18N
                + ", Updates=" + Updates // NOI18N
                + ", Finals=" + Finals // NOI18N
                + ", PreInits=" + PreInits; // NOI18N
    }
  };
  
  /// \brief Get number of collapsed loops.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getCollapsedNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 608,
   FQN="clang::OMPLoopDirective::getCollapsedNumber", NM="_ZNK5clang16OMPLoopDirective18getCollapsedNumberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective18getCollapsedNumberEv")
  //</editor-fold>
  public /*uint*/int getCollapsedNumber() /*const*/ {
    return CollapsedNum;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getIterationVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 610,
   FQN="clang::OMPLoopDirective::getIterationVariable", NM="_ZNK5clang16OMPLoopDirective20getIterationVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective20getIterationVariableEv")
  //</editor-fold>
  public Expr /*P*/ getIterationVariable() /*const*/ {
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.IterationVariableOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getLastIteration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 614,
   FQN="clang::OMPLoopDirective::getLastIteration", NM="_ZNK5clang16OMPLoopDirective16getLastIterationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective16getLastIterationEv")
  //</editor-fold>
  public Expr /*P*/ getLastIteration() /*const*/ {
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.LastIterationOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getCalcLastIteration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 618,
   FQN="clang::OMPLoopDirective::getCalcLastIteration", NM="_ZNK5clang16OMPLoopDirective20getCalcLastIterationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective20getCalcLastIterationEv")
  //</editor-fold>
  public Expr /*P*/ getCalcLastIteration() /*const*/ {
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.CalcLastIterationOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getPreCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 622,
   FQN="clang::OMPLoopDirective::getPreCond", NM="_ZNK5clang16OMPLoopDirective10getPreCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective10getPreCondEv")
  //</editor-fold>
  public Expr /*P*/ getPreCond() /*const*/ {
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.PreConditionOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 626,
   FQN="clang::OMPLoopDirective::getCond", NM="_ZNK5clang16OMPLoopDirective7getCondEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective7getCondEv")
  //</editor-fold>
  public Expr /*P*/ getCond() /*const*/ {
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.CondOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 630,
   FQN="clang::OMPLoopDirective::getInit", NM="_ZNK5clang16OMPLoopDirective7getInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective7getInitEv")
  //</editor-fold>
  public Expr /*P*/ getInit() /*const*/ {
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.InitOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 634,
   FQN="clang::OMPLoopDirective::getInc", NM="_ZNK5clang16OMPLoopDirective6getIncEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective6getIncEv")
  //</editor-fold>
  public Expr /*P*/ getInc() /*const*/ {
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.IncOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getPreInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 638,
   FQN="clang::OMPLoopDirective::getPreInits", NM="_ZNK5clang16OMPLoopDirective11getPreInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective11getPreInitsEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getPreInits$Const() /*const*/ {
    return std.next(child_begin$Const(), Unnamed_enum.PreInitsOffset.getValue()).$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getPreInits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 641,
   FQN="clang::OMPLoopDirective::getPreInits", NM="_ZN5clang16OMPLoopDirective11getPreInitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective11getPreInitsEv")
  //</editor-fold>
  public Stmt /*P*/ getPreInits() {
    return std.next(child_begin(), Unnamed_enum.PreInitsOffset.getValue()).$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getIsLastIterVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 642,
   FQN="clang::OMPLoopDirective::getIsLastIterVariable", NM="_ZNK5clang16OMPLoopDirective21getIsLastIterVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective21getIsLastIterVariableEv")
  //</editor-fold>
  public Expr /*P*/ getIsLastIterVariable() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.IsLastIterVariableOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getLowerBoundVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 650,
   FQN="clang::OMPLoopDirective::getLowerBoundVariable", NM="_ZNK5clang16OMPLoopDirective21getLowerBoundVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective21getLowerBoundVariableEv")
  //</editor-fold>
  public Expr /*P*/ getLowerBoundVariable() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.LowerBoundVariableOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getUpperBoundVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 658,
   FQN="clang::OMPLoopDirective::getUpperBoundVariable", NM="_ZNK5clang16OMPLoopDirective21getUpperBoundVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective21getUpperBoundVariableEv")
  //</editor-fold>
  public Expr /*P*/ getUpperBoundVariable() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.UpperBoundVariableOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getStrideVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 666,
   FQN="clang::OMPLoopDirective::getStrideVariable", NM="_ZNK5clang16OMPLoopDirective17getStrideVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective17getStrideVariableEv")
  //</editor-fold>
  public Expr /*P*/ getStrideVariable() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.StrideVariableOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getEnsureUpperBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 674,
   FQN="clang::OMPLoopDirective::getEnsureUpperBound", NM="_ZNK5clang16OMPLoopDirective19getEnsureUpperBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective19getEnsureUpperBoundEv")
  //</editor-fold>
  public Expr /*P*/ getEnsureUpperBound() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.EnsureUpperBoundOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getNextLowerBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 682,
   FQN="clang::OMPLoopDirective::getNextLowerBound", NM="_ZNK5clang16OMPLoopDirective17getNextLowerBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective17getNextLowerBoundEv")
  //</editor-fold>
  public Expr /*P*/ getNextLowerBound() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.NextLowerBoundOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getNextUpperBound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 690,
   FQN="clang::OMPLoopDirective::getNextUpperBound", NM="_ZNK5clang16OMPLoopDirective17getNextUpperBoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective17getNextUpperBoundEv")
  //</editor-fold>
  public Expr /*P*/ getNextUpperBound() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.NextUpperBoundOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getNumIterations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 698,
   FQN="clang::OMPLoopDirective::getNumIterations", NM="_ZNK5clang16OMPLoopDirective16getNumIterationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective16getNumIterationsEv")
  //</editor-fold>
  public Expr /*P*/ getNumIterations() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.NumIterationsOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getPrevLowerBoundVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 706,
   FQN="clang::OMPLoopDirective::getPrevLowerBoundVariable", NM="_ZNK5clang16OMPLoopDirective25getPrevLowerBoundVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective25getPrevLowerBoundVariableEv")
  //</editor-fold>
  public Expr /*P*/ getPrevLowerBoundVariable() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.PrevLowerBoundVariableOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getPrevUpperBoundVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 714,
   FQN="clang::OMPLoopDirective::getPrevUpperBoundVariable", NM="_ZNK5clang16OMPLoopDirective25getPrevUpperBoundVariableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective25getPrevUpperBoundVariableEv")
  //</editor-fold>
  public Expr /*P*/ getPrevUpperBoundVariable() /*const*/ {
    assert ((isOpenMPWorksharingDirective(getDirectiveKind()) || isOpenMPTaskLoopDirective(getDirectiveKind()) || isOpenMPDistributeDirective(getDirectiveKind()))) : "expected worksharing loop directive";
    return ((/*const_cast*/Expr /*P*/ )(reinterpret_cast(/*const*/ Expr /*P*/ .class, std.next(child_begin$Const(), Unnamed_enum.PrevUpperBoundVariableOffset.getValue()).$star())));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::getBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 722,
   FQN="clang::OMPLoopDirective::getBody", NM="_ZNK5clang16OMPLoopDirective7getBodyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective7getBodyEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ getBody() /*const*/ {
    // This relies on the loop form is already checked by Sema.
    Stmt /*P*/ Body = getAssociatedStmt().IgnoreContainers(true);
    Body = cast_ForStmt(Body).getBody();
    for (/*uint*/int Cnt = 1; $less_uint(Cnt, CollapsedNum); ++Cnt) {
      Body = Body.IgnoreContainers();
      Body = cast_ForStmt(Body).getBody();
    }
    return Body;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::counters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 733,
   FQN="clang::OMPLoopDirective::counters", NM="_ZN5clang16OMPLoopDirective8countersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective8countersEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > counters() {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, getCounters());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::counters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 735,
   FQN="clang::OMPLoopDirective::counters", NM="_ZNK5clang16OMPLoopDirective8countersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective8countersEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > counters$Const() /*const*/ {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, ((/*const_cast*/OMPLoopDirective /*P*/ )(this)).getCounters());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::private_counters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 739,
   FQN="clang::OMPLoopDirective::private_counters", NM="_ZN5clang16OMPLoopDirective16private_countersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective16private_countersEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > private_counters() {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, getPrivateCounters());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::private_counters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 741,
   FQN="clang::OMPLoopDirective::private_counters", NM="_ZNK5clang16OMPLoopDirective16private_countersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective16private_countersEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > private_counters$Const() /*const*/ {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, ((/*const_cast*/OMPLoopDirective /*P*/ )(this)).getPrivateCounters());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 745,
   FQN="clang::OMPLoopDirective::inits", NM="_ZN5clang16OMPLoopDirective5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective5initsEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > inits() {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, getInits());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::inits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 747,
   FQN="clang::OMPLoopDirective::inits", NM="_ZNK5clang16OMPLoopDirective5initsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective5initsEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > inits$Const() /*const*/ {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, ((/*const_cast*/OMPLoopDirective /*P*/ )(this)).getInits());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::updates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 751,
   FQN="clang::OMPLoopDirective::updates", NM="_ZN5clang16OMPLoopDirective7updatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective7updatesEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > updates() {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, getUpdates());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::updates">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 753,
   FQN="clang::OMPLoopDirective::updates", NM="_ZNK5clang16OMPLoopDirective7updatesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective7updatesEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > updates$Const() /*const*/ {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, ((/*const_cast*/OMPLoopDirective /*P*/ )(this)).getUpdates());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::finals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 757,
   FQN="clang::OMPLoopDirective::finals", NM="_ZN5clang16OMPLoopDirective6finalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective6finalsEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > finals() {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, getFinals());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::finals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 759,
   FQN="clang::OMPLoopDirective::finals", NM="_ZNK5clang16OMPLoopDirective6finalsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang16OMPLoopDirective6finalsEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > finals$Const() /*const*/ {
    return new ArrayRef<Expr /*P*/ >(JD$Move.INSTANCE, ((/*const_cast*/OMPLoopDirective /*P*/ )(this)).getFinals());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPLoopDirective::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtOpenMP.h", line = 763,
   FQN="clang::OMPLoopDirective::classof", NM="_ZN5clang16OMPLoopDirective7classofEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang16OMPLoopDirective7classofEPKNS_4StmtE")
  //</editor-fold>
  public static boolean classof(/*const*/ Stmt /*P*/ T) {
    return T.getStmtClass() == StmtClass.OMPSimdDirectiveClass
       || T.getStmtClass() == StmtClass.OMPForDirectiveClass
       || T.getStmtClass() == StmtClass.OMPForSimdDirectiveClass
       || T.getStmtClass() == StmtClass.OMPParallelForDirectiveClass
       || T.getStmtClass() == StmtClass.OMPParallelForSimdDirectiveClass
       || T.getStmtClass() == StmtClass.OMPTaskLoopDirectiveClass
       || T.getStmtClass() == StmtClass.OMPTaskLoopSimdDirectiveClass
       || T.getStmtClass() == StmtClass.OMPDistributeDirectiveClass
       || T.getStmtClass() == StmtClass.OMPTargetParallelForDirectiveClass
       || T.getStmtClass() == StmtClass.OMPDistributeParallelForDirectiveClass
       || T.getStmtClass() == StmtClass.OMPDistributeParallelForSimdDirectiveClass
       || T.getStmtClass() == StmtClass.OMPDistributeSimdDirectiveClass
       || T.getStmtClass() == StmtClass.OMPTargetParallelForSimdDirectiveClass;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected OMPLoopDirective() {}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "CollapsedNum=" + CollapsedNum // NOI18N
              + super.toString(); // NOI18N
  }
}
