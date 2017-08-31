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
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief This represents 'dist_schedule' clause in the '#pragma omp ...'
/// directive.
///
/// \code
/// #pragma omp distribute dist_schedule(static, 3)
/// \endcode
/// In this example directive '#pragma omp distribute' has 'dist_schedule'
/// clause with arguments 'static' and '3'.
///
//<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3812,
 FQN="clang::OMPDistScheduleClause", NM="_ZN5clang21OMPDistScheduleClauseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClauseE")
//</editor-fold>
public class OMPDistScheduleClause extends /*public*/ OMPClause implements /*public*/ OMPClauseWithPreInit {
  /*friend  class OMPClauseReader*/
  /// \brief Location of '('.
  private SourceLocation LParenLoc;
  /// \brief A kind of the 'schedule' clause.
  private /*OpenMPDistScheduleClauseKind*/int Kind;
  /// \brief Start location of the schedule kind in source code.
  private SourceLocation KindLoc;
  /// \brief Location of ',' (if any).
  private SourceLocation CommaLoc;
  /// \brief Chunk size.
  private Expr /*P*/ ChunkSize;
  
  /// \brief Set schedule kind.
  ///
  /// \param K Schedule kind.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::setDistScheduleKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3829,
   FQN="clang::OMPDistScheduleClause::setDistScheduleKind", NM="_ZN5clang21OMPDistScheduleClause19setDistScheduleKindENS_28OpenMPDistScheduleClauseKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause19setDistScheduleKindENS_28OpenMPDistScheduleClauseKindE")
  //</editor-fold>
  /*friend*/public void setDistScheduleKind(/*OpenMPDistScheduleClauseKind*/int K) {
    Kind = K;
  }

  /// \brief Sets the location of '('.
  ///
  /// \param Loc Location of '('.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::setLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3834,
   FQN="clang::OMPDistScheduleClause::setLParenLoc", NM="_ZN5clang21OMPDistScheduleClause12setLParenLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause12setLParenLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setLParenLoc(SourceLocation Loc) {
    LParenLoc.$assign(Loc);
  }

  /// \brief Set schedule kind start location.
  ///
  /// \param KLoc Schedule kind location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::setDistScheduleKindLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3839,
   FQN="clang::OMPDistScheduleClause::setDistScheduleKindLoc", NM="_ZN5clang21OMPDistScheduleClause22setDistScheduleKindLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause22setDistScheduleKindLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setDistScheduleKindLoc(SourceLocation KLoc) {
    KindLoc.$assign(KLoc);
  }

  /// \brief Set location of ','.
  ///
  /// \param Loc Location of ','.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::setCommaLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3844,
   FQN="clang::OMPDistScheduleClause::setCommaLoc", NM="_ZN5clang21OMPDistScheduleClause11setCommaLocENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause11setCommaLocENS_14SourceLocationE")
  //</editor-fold>
  /*friend*/public void setCommaLoc(SourceLocation Loc) {
    CommaLoc.$assign(Loc);
  }

  /// \brief Set chunk size.
  ///
  /// \param E Chunk size.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::setChunkSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3849,
   FQN="clang::OMPDistScheduleClause::setChunkSize", NM="_ZN5clang21OMPDistScheduleClause12setChunkSizeEPNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause12setChunkSizeEPNS_4ExprE")
  //</editor-fold>
  /*friend*/public void setChunkSize(Expr /*P*/ E) {
    ChunkSize = E;
  }

/*public:*/
  /// \brief Build 'dist_schedule' clause with schedule kind \a Kind and chunk
  /// size expression \a ChunkSize.
  ///
  /// \param StartLoc Starting location of the clause.
  /// \param LParenLoc Location of '('.
  /// \param KLoc Starting location of the argument.
  /// \param CommaLoc Location of ','.
  /// \param EndLoc Ending location of the clause.
  /// \param Kind DistSchedule kind.
  /// \param ChunkSize Chunk size.
  /// \param HelperChunkSize Helper chunk size for combined directives.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::OMPDistScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3864,
   FQN="clang::OMPDistScheduleClause::OMPDistScheduleClause", NM="_ZN5clang21OMPDistScheduleClauseC1ENS_14SourceLocationES1_S1_S1_S1_NS_28OpenMPDistScheduleClauseKindEPNS_4ExprEPNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClauseC1ENS_14SourceLocationES1_S1_S1_S1_NS_28OpenMPDistScheduleClauseKindEPNS_4ExprEPNS_4StmtE")
  //</editor-fold>
  public OMPDistScheduleClause(SourceLocation StartLoc, SourceLocation LParenLoc, 
      SourceLocation KLoc, SourceLocation CommaLoc, 
      SourceLocation EndLoc, 
      /*OpenMPDistScheduleClauseKind*/int Kind, Expr /*P*/ ChunkSize, 
      Stmt /*P*/ HelperChunkSize) {
    // : OMPClause(OMPC_dist_schedule, StartLoc, EndLoc), OMPClauseWithPreInit(this), LParenLoc(LParenLoc), Kind(Kind), KindLoc(KLoc), CommaLoc(CommaLoc), ChunkSize(ChunkSize) 
    //START JInit
    super(OpenMPClauseKind.OMPC_dist_schedule, new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    this.OMPClauseWithPreInit$Flds = $OMPClauseWithPreInit(this);
    this.LParenLoc = new SourceLocation(LParenLoc);
    this.Kind = Kind;
    this.KindLoc = new SourceLocation(KLoc);
    this.CommaLoc = new SourceLocation(CommaLoc);
    this.ChunkSize = ChunkSize;
    //END JInit
    setPreInitStmt(HelperChunkSize);
  }

  
  /// \brief Build an empty clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::OMPDistScheduleClause">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3877,
   FQN="clang::OMPDistScheduleClause::OMPDistScheduleClause", NM="_ZN5clang21OMPDistScheduleClauseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClauseC1Ev")
  //</editor-fold>
  public /*explicit*/ OMPDistScheduleClause() {
    // : OMPClause(OMPC_dist_schedule, SourceLocation(), SourceLocation()), OMPClauseWithPreInit(this), LParenLoc(), Kind(OMPC_DIST_SCHEDULE_unknown), KindLoc(), CommaLoc(), ChunkSize(null) 
    //START JInit
    super(OpenMPClauseKind.OMPC_dist_schedule, new SourceLocation(), new SourceLocation());
    this.OMPClauseWithPreInit$Flds = $OMPClauseWithPreInit(this);
    this.LParenLoc = new SourceLocation();
    this.Kind = OpenMPDistScheduleClauseKind.OMPC_DIST_SCHEDULE_unknown;
    this.KindLoc = new SourceLocation();
    this.CommaLoc = new SourceLocation();
    this.ChunkSize = null;
    //END JInit
  }

  
  /// \brief Get kind of the clause.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::getDistScheduleKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3884,
   FQN="clang::OMPDistScheduleClause::getDistScheduleKind", NM="_ZNK5clang21OMPDistScheduleClause19getDistScheduleKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang21OMPDistScheduleClause19getDistScheduleKindEv")
  //</editor-fold>
  public /*OpenMPDistScheduleClauseKind*/int getDistScheduleKind() /*const*/ {
    return Kind;
  }

  /// \brief Get location of '('.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::getLParenLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3887,
   FQN="clang::OMPDistScheduleClause::getLParenLoc", NM="_ZN5clang21OMPDistScheduleClause12getLParenLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause12getLParenLocEv")
  //</editor-fold>
  public SourceLocation getLParenLoc() {
    return new SourceLocation(LParenLoc);
  }

  /// \brief Get kind location.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::getDistScheduleKindLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3890,
   FQN="clang::OMPDistScheduleClause::getDistScheduleKindLoc", NM="_ZN5clang21OMPDistScheduleClause22getDistScheduleKindLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause22getDistScheduleKindLocEv")
  //</editor-fold>
  public SourceLocation getDistScheduleKindLoc() {
    return new SourceLocation(KindLoc);
  }

  /// \brief Get location of ','.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::getCommaLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3893,
   FQN="clang::OMPDistScheduleClause::getCommaLoc", NM="_ZN5clang21OMPDistScheduleClause11getCommaLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause11getCommaLocEv")
  //</editor-fold>
  public SourceLocation getCommaLoc() {
    return new SourceLocation(CommaLoc);
  }

  /// \brief Get chunk size.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::getChunkSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3896,
   FQN="clang::OMPDistScheduleClause::getChunkSize", NM="_ZN5clang21OMPDistScheduleClause12getChunkSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause12getChunkSizeEv")
  //</editor-fold>
  public Expr /*P*/ getChunkSize() {
    return ChunkSize;
  }

  /// \brief Get chunk size.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::getChunkSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3899,
   FQN="clang::OMPDistScheduleClause::getChunkSize", NM="_ZNK5clang21OMPDistScheduleClause12getChunkSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZNK5clang21OMPDistScheduleClause12getChunkSizeEv")
  //</editor-fold>
  public /*const*/ Expr /*P*/ getChunkSize$Const() /*const*/ {
    return ChunkSize;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3901,
   FQN="clang::OMPDistScheduleClause::classof", NM="_ZN5clang21OMPDistScheduleClause7classofEPKNS_9OMPClauseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause7classofEPKNS_9OMPClauseE")
  //</editor-fold>
  public static boolean classof(/*const*/ OMPClause /*P*/ T) {
    return T.getClauseKind() == OpenMPClauseKind.OMPC_dist_schedule;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPDistScheduleClause::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OpenMPClause.h", line = 3905,
   FQN="clang::OMPDistScheduleClause::children", NM="_ZN5clang21OMPDistScheduleClause8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/OpenMPClause.cpp -nm=_ZN5clang21OMPDistScheduleClause8childrenEv")
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
              + ", KindLoc=" + KindLoc // NOI18N
              + ", CommaLoc=" + CommaLoc // NOI18N
              + ", ChunkSize=" + ChunkSize // NOI18N
              + super.toString(); // NOI18N
  }
}
