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
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief This represents 'schedule' clause in the '#pragma omp ...' directive.
///
/// \code
/// #pragma omp for schedule(static, 3)
/// \endcode
/// In this example directive '#pragma omp for' has 'schedule' clause with
/// arguments 'static' and '3'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 698,
 FQN="clang::OMPScheduleClause", NM="_ZN5clang17OMPScheduleClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClauseE")
//</editor-fold>
public class OMPScheduleClause extends /*public*/ OMPClause implements /*public*/ OMPClauseWithPreInit {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief A kind of the 'schedule' clause.
  private /*OpenMPScheduleClauseKind*/int Kind;
  /// \brief Modifiers for 'schedule' clause.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 705,
   FQN="clang::OMPScheduleClause::(anonymous)", NM="_ZN5clang17OMPScheduleClauseE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClauseE_Unnamed_enum")
  //</editor-fold>
  private enum Unnamed_enum implements Native.ComparableLower {
    FIRST(0),
    SECOND(FIRST.getValue() + 1),
    NUM_MODIFIERS(SECOND.getValue() + 1);

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
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private int Modifiers[/*2*/] = new /*OpenMPScheduleClauseModifier*/int [2];
  /// \brief Locations of modifiers.
  private SourceLocation ModifiersLoc[/*2*/] = new SourceLocation [2];
  /// \brief Start location of the schedule ind in source code.
  private SourceLocation KindLoc;
  /// \brief Location of ',' (if any).
  private SourceLocation CommaLoc;
  /// \brief Chunk size.
  private Expr /*P*/ ChunkSize;
  
  /// \brief Set schedule kind.
  ///
  /// \param K Schedule kind.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setScheduleKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 720,
   FQN="clang::OMPScheduleClause::setScheduleKind", NM="_ZN5clang17OMPScheduleClause15setScheduleKindENS_24OpenMPScheduleClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause15setScheduleKindENS_24OpenMPScheduleClauseKindE")
  //</editor-fold>
  /*friend*/public void setScheduleKind(/*OpenMPScheduleClauseKind*/int K) {
    Kind = K;
  }

  /// \brief Set the first schedule modifier.
  ///
  /// \param M Schedule modifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setFirstScheduleModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 725,
   FQN="clang::OMPScheduleClause::setFirstScheduleModifier", NM="_ZN5clang17OMPScheduleClause24setFirstScheduleModifierENS_28OpenMPScheduleClauseModifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause24setFirstScheduleModifierENS_28OpenMPScheduleClauseModifierE")
  //</editor-fold>
  /*friend*/public void setFirstScheduleModifier(/*OpenMPScheduleClauseModifier*/int M) {
    Modifiers[Unnamed_enum.FIRST.getValue()] = M;
  }

  /// \brief Set the second schedule modifier.
  ///
  /// \param M Schedule modifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setSecondScheduleModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 732,
   FQN="clang::OMPScheduleClause::setSecondScheduleModifier", NM="_ZN5clang17OMPScheduleClause25setSecondScheduleModifierENS_28OpenMPScheduleClauseModifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause25setSecondScheduleModifierENS_28OpenMPScheduleClauseModifierE")
  //</editor-fold>
  /*friend*/public void setSecondScheduleModifier(/*OpenMPScheduleClauseModifier*/int M) {
    Modifiers[Unnamed_enum.SECOND.getValue()] = M;
  }

  /// \brief Set location of the first schedule modifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setFirstScheduleModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 737,
   FQN="clang::OMPScheduleClause::setFirstScheduleModifierLoc", NM="_ZN5clang17OMPScheduleClause27setFirstScheduleModifierLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause27setFirstScheduleModifierLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setFirstScheduleModifierLoc(SourceLocation Loc) {
    ModifiersLoc[Unnamed_enum.FIRST.getValue()].$assign(Loc);
  }

  /// \brief Set location of the second schedule modifier.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setSecondScheduleModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 742,
   FQN="clang::OMPScheduleClause::setSecondScheduleModifierLoc", NM="_ZN5clang17OMPScheduleClause28setSecondScheduleModifierLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause28setSecondScheduleModifierLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setSecondScheduleModifierLoc(SourceLocation Loc) {
    ModifiersLoc[Unnamed_enum.SECOND.getValue()].$assign(Loc);
  }

  /// \brief Set schedule modifier location.
  ///
  /// \param M Schedule modifier location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setScheduleModifer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 749,
   FQN="clang::OMPScheduleClause::setScheduleModifer", NM="_ZN5clang17OMPScheduleClause18setScheduleModiferENS_28OpenMPScheduleClauseModifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause18setScheduleModiferENS_28OpenMPScheduleClauseModifierE")
  //</editor-fold>
  private void setScheduleModifer(/*OpenMPScheduleClauseModifier*/int M) {
    if (Modifiers[Unnamed_enum.FIRST.getValue()] == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown) {
      Modifiers[Unnamed_enum.FIRST.getValue()] = M;
    } else {
      assert (Modifiers[Unnamed_enum.SECOND.getValue()] == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown);
      Modifiers[Unnamed_enum.SECOND.getValue()] = M;
    }
  }

  /// \brief Sets the location of '('.
  ///
  /// \param Loc Location of '('.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 761,
   FQN="clang::OMPScheduleClause::setLParenLoc", NM="_ZN5clang17OMPScheduleClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Set schedule kind start location.
  ///
  /// \param KLoc Schedule kind location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setScheduleKindLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 766,
   FQN="clang::OMPScheduleClause::setScheduleKindLoc", NM="_ZN5clang17OMPScheduleClause18setScheduleKindLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause18setScheduleKindLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setScheduleKindLoc(SourceLocation KLoc) {
    KindLoc.$assign(KLoc);
  }

  /// \brief Set location of ','.
  ///
  /// \param Loc Location of ','.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setCommaLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 771,
   FQN="clang::OMPScheduleClause::setCommaLoc", NM="_ZN5clang17OMPScheduleClause11setCommaLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause11setCommaLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setCommaLoc(SourceLocation Loc) {
    CommaLoc.$assign(Loc);
  }

  /// \brief Set chunk size.
  ///
  /// \param E Chunk size.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::setChunkSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 776,
   FQN="clang::OMPScheduleClause::setChunkSize", NM="_ZN5clang17OMPScheduleClause12setChunkSizeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause12setChunkSizeEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setChunkSize(Expr /*P*/ E) {
    ChunkSize = E;
  }

/*public:*/
  /// \brief Build 'schedule' clause with schedule kind \a Kind and chunk size
  /// expression \a ChunkSize.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param KLoc Starting location of the argument.
  /// \param CommaLoc Location of ','.
  /// \param EndLoc Ending location of the clause.
  /// \param Kind Schedule kind.
  /// \param ChunkSize Chunk size.
  /// \param HelperChunkSize Helper chunk size for combined directives.
  /// \param M1 The first modifier applied to 'schedule' clause.
  /// \param M1Loc Location of the first modifier
  /// \param M2 The second modifier applied to 'schedule' clause.
  /// \param M2Loc Location of the second modifier
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::OMPScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 795,
   FQN="clang::OMPScheduleClause::OMPScheduleClause", NM="_ZN5clang17OMPScheduleClauseC1ENS_14SourceLocationES1_S1_S1_S1_NS_24OpenMPScheduleClauseKindEPNS_4ExprEPNS_4StmtENS_28OpenMPScheduleClauseModifierES1_S7_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClauseC1ENS_14SourceLocationES1_S1_S1_S1_NS_24OpenMPScheduleClauseKindEPNS_4ExprEPNS_4StmtENS_28OpenMPScheduleClauseModifierES1_S7_S1_")
  //</editor-fold>
  public OMPScheduleClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation KLoc, SourceLocation CommaLoc, 
      SourceLocation EndLoc, /*OpenMPScheduleClauseKind*/int Kind, 
      Expr /*P*/ ChunkSize, Stmt /*P*/ HelperChunkSize, 
      /*OpenMPScheduleClauseModifier*/int M1, SourceLocation M1Loc, 
      /*OpenMPScheduleClauseModifier*/int M2, SourceLocation M2Loc) {
    // : OMPClause(OMPC_schedule, StartLoc, EndLoc), OMPClauseWithPreInit(this), LParenLoc(LParenLoc), Kind(Kind), ModifiersLoc(), KindLoc(KLoc), CommaLoc(CommaLoc), ChunkSize(ChunkSize) 
    //START JInit
    super(OpenMPClauseKind.OMPC_schedule, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.OMPClauseWithPreInit$Flds = $OMPClauseWithPreInit(this);
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Kind = Kind;
    this.ModifiersLoc = new$T(new SourceLocation [2], ()->new SourceLocation());
    this.KindLoc = new SourceLocation(KLoc);
    this.CommaLoc = new SourceLocation(CommaLoc);
    this.ChunkSize = ChunkSize;
    //END JInit
    setPreInitStmt(HelperChunkSize);
    Modifiers[Unnamed_enum.FIRST.getValue()] = M1;
    Modifiers[Unnamed_enum.SECOND.getValue()] = M2;
    ModifiersLoc[Unnamed_enum.FIRST.getValue()].$assign(M1Loc);
    ModifiersLoc[Unnamed_enum.SECOND.getValue()].$assign(M2Loc);
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::OMPScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 813,
   FQN="clang::OMPScheduleClause::OMPScheduleClause", NM="_ZN5clang17OMPScheduleClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClauseC1Ev")
  //</editor-fold>
  public /*explicit*/ OMPScheduleClause() {
    // : OMPClause(OMPC_schedule, SourceLocation(), SourceLocation()), OMPClauseWithPreInit(this), LParenLoc(), Kind(OMPC_SCHEDULE_unknown), ModifiersLoc(), KindLoc(), CommaLoc(), ChunkSize(null) 
    //START JInit
    super(OpenMPClauseKind.OMPC_schedule, new SourceLocation(), new SourceLocation());
    this.OMPClauseWithPreInit$Flds = $OMPClauseWithPreInit(this);
    this.LParenLoc = new SourceLocation();
    this.Kind = OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown;
    this.ModifiersLoc = new$T(new SourceLocation [2], ()->new SourceLocation());
    this.KindLoc = new SourceLocation();
    this.CommaLoc = new SourceLocation();
    this.ChunkSize = null;
    //END JInit
    Modifiers[Unnamed_enum.FIRST.getValue()] = OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown;
    Modifiers[Unnamed_enum.SECOND.getValue()] = OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown;
  }

  
  /// \brief Get kind of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getScheduleKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 823,
   FQN="clang::OMPScheduleClause::getScheduleKind", NM="_ZNK5clang17OMPScheduleClause15getScheduleKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPScheduleClause15getScheduleKindEv")
  //</editor-fold>
  public /*OpenMPScheduleClauseKind*/int getScheduleKind() /*const*/ {
    return Kind;
  }

  /// \brief Get the first modifier of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getFirstScheduleModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 826,
   FQN="clang::OMPScheduleClause::getFirstScheduleModifier", NM="_ZNK5clang17OMPScheduleClause24getFirstScheduleModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPScheduleClause24getFirstScheduleModifierEv")
  //</editor-fold>
  public /*OpenMPScheduleClauseModifier*/int getFirstScheduleModifier() /*const*/ {
    return Modifiers[Unnamed_enum.FIRST.getValue()];
  }

  /// \brief Get the second modifier of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getSecondScheduleModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 831,
   FQN="clang::OMPScheduleClause::getSecondScheduleModifier", NM="_ZNK5clang17OMPScheduleClause25getSecondScheduleModifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPScheduleClause25getSecondScheduleModifierEv")
  //</editor-fold>
  public /*OpenMPScheduleClauseModifier*/int getSecondScheduleModifier() /*const*/ {
    return Modifiers[Unnamed_enum.SECOND.getValue()];
  }

  /// \brief Get location of '('.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 836,
   FQN="clang::OMPScheduleClause::getLParenLoc", NM="_ZN5clang17OMPScheduleClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() {
    return new SourceLocation(LParenLoc);
  }

  /// \brief Get kind location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getScheduleKindLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 839,
   FQN="clang::OMPScheduleClause::getScheduleKindLoc", NM="_ZN5clang17OMPScheduleClause18getScheduleKindLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause18getScheduleKindLocEv")
  //</editor-fold>
  public SourceLocation getScheduleKindLoc() {
    return new SourceLocation(KindLoc);
  }

  /// \brief Get the first modifier location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getFirstScheduleModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 842,
   FQN="clang::OMPScheduleClause::getFirstScheduleModifierLoc", NM="_ZNK5clang17OMPScheduleClause27getFirstScheduleModifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPScheduleClause27getFirstScheduleModifierLocEv")
  //</editor-fold>
  public SourceLocation getFirstScheduleModifierLoc() /*const*/ {
    return new SourceLocation(ModifiersLoc[Unnamed_enum.FIRST.getValue()]);
  }

  /// \brief Get the second modifier location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getSecondScheduleModifierLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 847,
   FQN="clang::OMPScheduleClause::getSecondScheduleModifierLoc", NM="_ZNK5clang17OMPScheduleClause28getSecondScheduleModifierLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPScheduleClause28getSecondScheduleModifierLocEv")
  //</editor-fold>
  public SourceLocation getSecondScheduleModifierLoc() /*const*/ {
    return new SourceLocation(ModifiersLoc[Unnamed_enum.SECOND.getValue()]);
  }

  /// \brief Get location of ','.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getCommaLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 852,
   FQN="clang::OMPScheduleClause::getCommaLoc", NM="_ZN5clang17OMPScheduleClause11getCommaLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause11getCommaLocEv")
  //</editor-fold>
  public SourceLocation getCommaLoc() {
    return new SourceLocation(CommaLoc);
  }

  /// \brief Get chunk size.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getChunkSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 855,
   FQN="clang::OMPScheduleClause::getChunkSize", NM="_ZN5clang17OMPScheduleClause12getChunkSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause12getChunkSizeEv")
  //</editor-fold>
  public Expr /*P*/ getChunkSize() {
    return ChunkSize;
  }

  /// \brief Get chunk size.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::getChunkSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 858,
   FQN="clang::OMPScheduleClause::getChunkSize", NM="_ZNK5clang17OMPScheduleClause12getChunkSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang17OMPScheduleClause12getChunkSizeEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getChunkSize$Const() /*const*/ {
    return ChunkSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 860,
   FQN="clang::OMPScheduleClause::classof", NM="_ZN5clang17OMPScheduleClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_schedule;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPScheduleClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 864,
   FQN="clang::OMPScheduleClause::children", NM="_ZN5clang17OMPScheduleClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang17OMPScheduleClause8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    return new iterator_range<Stmt/*P*/>(new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(ChunkSize)))), 
        new StmtIterator(((type$ptr<Stmt /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, $AddrOf(ChunkSize))).$add(1)));
  }

  
  private final OMPClauseWithPreInit$Fields OMPClauseWithPreInit$Flds;// use return value of $OMPClauseWithPreInit();
  @Override public final OMPClauseWithPreInit$Fields $OMPClauseWithPreInit$Fields() { return OMPClauseWithPreInit$Flds; }
  
  @Override public String toString() {
    return "" + "LParenLoc=" + LParenLoc // NOI18N
              + ", Kind=" + Kind // NOI18N
              + ", Modifiers=" + Modifiers // NOI18N
              + ", ModifiersLoc=" + ModifiersLoc // NOI18N
              + ", KindLoc=" + KindLoc // NOI18N
              + ", CommaLoc=" + CommaLoc // NOI18N
              + ", ChunkSize=" + ChunkSize // NOI18N
              + super.toString(); // NOI18N
  }
}
