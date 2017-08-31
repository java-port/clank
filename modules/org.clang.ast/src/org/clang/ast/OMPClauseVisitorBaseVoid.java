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

import org.clank.support.*;
import org.llvm.support.*;


/// \brief This class implements a simple visitor for OMPClause
/// subclasses.
/*template <class ImplClass, template <typename > class Ptr, typename RetTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 192,
 FQN="clang::OMPClauseVisitorBase", NM="_ZN5clang20OMPClauseVisitorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBaseE")
//</editor-fold>
public interface/*class*/ OMPClauseVisitorBaseVoid</*class*/ ImplClass extends OMPClauseVisitorBaseVoid<?, ?>, /*template <typename > TEMPLATE*/
/*class */Ptr/*, typename RetTy*/>  {

/*public:*/
  
  // OpenMP clauses.
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPIfClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 187,
   FQN="clang::OMPClauseVisitorBase::VisitOMPIfClause", NM="_ZN5clang20OMPClauseVisitorBase16VisitOMPIfClauseENT0_INS_11OMPIfClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase16VisitOMPIfClauseENT0_INS_11OMPIfClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPIfClause(OMPIfClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPIfClause(((/*static_cast*/OMPIfClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPFinalClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 188,
   FQN="clang::OMPClauseVisitorBase::VisitOMPFinalClause", NM="_ZN5clang20OMPClauseVisitorBase19VisitOMPFinalClauseENT0_INS_14OMPFinalClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase19VisitOMPFinalClauseENT0_INS_14OMPFinalClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPFinalClause(OMPFinalClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPFinalClause(((/*static_cast*/OMPFinalClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPNumThreadsClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 189,
   FQN="clang::OMPClauseVisitorBase::VisitOMPNumThreadsClause", NM="_ZN5clang20OMPClauseVisitorBase24VisitOMPNumThreadsClauseENT0_INS_19OMPNumThreadsClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase24VisitOMPNumThreadsClauseENT0_INS_19OMPNumThreadsClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPNumThreadsClause(OMPNumThreadsClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPNumThreadsClause(((/*static_cast*/OMPNumThreadsClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPSafelenClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 190,
   FQN="clang::OMPClauseVisitorBase::VisitOMPSafelenClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPSafelenClauseENT0_INS_16OMPSafelenClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPSafelenClauseENT0_INS_16OMPSafelenClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPSafelenClause(OMPSafelenClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSafelenClause(((/*static_cast*/OMPSafelenClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPSimdlenClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 191,
   FQN="clang::OMPClauseVisitorBase::VisitOMPSimdlenClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPSimdlenClauseENT0_INS_16OMPSimdlenClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPSimdlenClauseENT0_INS_16OMPSimdlenClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPSimdlenClause(OMPSimdlenClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSimdlenClause(((/*static_cast*/OMPSimdlenClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPCollapseClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 192,
   FQN="clang::OMPClauseVisitorBase::VisitOMPCollapseClause", NM="_ZN5clang20OMPClauseVisitorBase22VisitOMPCollapseClauseENT0_INS_17OMPCollapseClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase22VisitOMPCollapseClauseENT0_INS_17OMPCollapseClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPCollapseClause(OMPCollapseClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPCollapseClause(((/*static_cast*/OMPCollapseClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPDefaultClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 193,
   FQN="clang::OMPClauseVisitorBase::VisitOMPDefaultClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPDefaultClauseENT0_INS_16OMPDefaultClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPDefaultClauseENT0_INS_16OMPDefaultClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPDefaultClause(OMPDefaultClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDefaultClause(((/*static_cast*/OMPDefaultClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPPrivateClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 194,
   FQN="clang::OMPClauseVisitorBase::VisitOMPPrivateClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPPrivateClauseENT0_INS_16OMPPrivateClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPPrivateClauseENT0_INS_16OMPPrivateClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPPrivateClause(OMPPrivateClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPPrivateClause(((/*static_cast*/OMPPrivateClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPFirstprivateClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 195,
   FQN="clang::OMPClauseVisitorBase::VisitOMPFirstprivateClause", NM="_ZN5clang20OMPClauseVisitorBase26VisitOMPFirstprivateClauseENT0_INS_21OMPFirstprivateClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase26VisitOMPFirstprivateClauseENT0_INS_21OMPFirstprivateClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPFirstprivateClause(OMPFirstprivateClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPFirstprivateClause(((/*static_cast*/OMPFirstprivateClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPLastprivateClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 196,
   FQN="clang::OMPClauseVisitorBase::VisitOMPLastprivateClause", NM="_ZN5clang20OMPClauseVisitorBase25VisitOMPLastprivateClauseENT0_INS_20OMPLastprivateClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase25VisitOMPLastprivateClauseENT0_INS_20OMPLastprivateClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPLastprivateClause(OMPLastprivateClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLastprivateClause(((/*static_cast*/OMPLastprivateClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPSharedClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 197,
   FQN="clang::OMPClauseVisitorBase::VisitOMPSharedClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPSharedClauseENT0_INS_15OMPSharedClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPSharedClauseENT0_INS_15OMPSharedClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPSharedClause(OMPSharedClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSharedClause(((/*static_cast*/OMPSharedClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPReductionClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 198,
   FQN="clang::OMPClauseVisitorBase::VisitOMPReductionClause", NM="_ZN5clang20OMPClauseVisitorBase23VisitOMPReductionClauseENT0_INS_18OMPReductionClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase23VisitOMPReductionClauseENT0_INS_18OMPReductionClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPReductionClause(OMPReductionClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPReductionClause(((/*static_cast*/OMPReductionClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPLinearClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 199,
   FQN="clang::OMPClauseVisitorBase::VisitOMPLinearClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPLinearClauseENT0_INS_15OMPLinearClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPLinearClauseENT0_INS_15OMPLinearClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPLinearClause(OMPLinearClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPLinearClause(((/*static_cast*/OMPLinearClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPAlignedClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 200,
   FQN="clang::OMPClauseVisitorBase::VisitOMPAlignedClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPAlignedClauseENT0_INS_16OMPAlignedClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPAlignedClauseENT0_INS_16OMPAlignedClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPAlignedClause(OMPAlignedClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPAlignedClause(((/*static_cast*/OMPAlignedClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPCopyinClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 201,
   FQN="clang::OMPClauseVisitorBase::VisitOMPCopyinClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPCopyinClauseENT0_INS_15OMPCopyinClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPCopyinClauseENT0_INS_15OMPCopyinClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPCopyinClause(OMPCopyinClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPCopyinClause(((/*static_cast*/OMPCopyinClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPCopyprivateClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 202,
   FQN="clang::OMPClauseVisitorBase::VisitOMPCopyprivateClause", NM="_ZN5clang20OMPClauseVisitorBase25VisitOMPCopyprivateClauseENT0_INS_20OMPCopyprivateClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase25VisitOMPCopyprivateClauseENT0_INS_20OMPCopyprivateClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPCopyprivateClause(OMPCopyprivateClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPCopyprivateClause(((/*static_cast*/OMPCopyprivateClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPProcBindClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 203,
   FQN="clang::OMPClauseVisitorBase::VisitOMPProcBindClause", NM="_ZN5clang20OMPClauseVisitorBase22VisitOMPProcBindClauseENT0_INS_17OMPProcBindClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase22VisitOMPProcBindClauseENT0_INS_17OMPProcBindClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPProcBindClause(OMPProcBindClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPProcBindClause(((/*static_cast*/OMPProcBindClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPScheduleClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 204,
   FQN="clang::OMPClauseVisitorBase::VisitOMPScheduleClause", NM="_ZN5clang20OMPClauseVisitorBase22VisitOMPScheduleClauseENT0_INS_17OMPScheduleClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase22VisitOMPScheduleClauseENT0_INS_17OMPScheduleClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPScheduleClause(OMPScheduleClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPScheduleClause(((/*static_cast*/OMPScheduleClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPOrderedClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 205,
   FQN="clang::OMPClauseVisitorBase::VisitOMPOrderedClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPOrderedClauseENT0_INS_16OMPOrderedClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPOrderedClauseENT0_INS_16OMPOrderedClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPOrderedClause(OMPOrderedClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPOrderedClause(((/*static_cast*/OMPOrderedClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPNowaitClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 206,
   FQN="clang::OMPClauseVisitorBase::VisitOMPNowaitClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPNowaitClauseENT0_INS_15OMPNowaitClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPNowaitClauseENT0_INS_15OMPNowaitClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPNowaitClause(OMPNowaitClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPNowaitClause(((/*static_cast*/OMPNowaitClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPUntiedClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 207,
   FQN="clang::OMPClauseVisitorBase::VisitOMPUntiedClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPUntiedClauseENT0_INS_15OMPUntiedClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPUntiedClauseENT0_INS_15OMPUntiedClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPUntiedClause(OMPUntiedClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPUntiedClause(((/*static_cast*/OMPUntiedClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPMergeableClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 208,
   FQN="clang::OMPClauseVisitorBase::VisitOMPMergeableClause", NM="_ZN5clang20OMPClauseVisitorBase23VisitOMPMergeableClauseENT0_INS_18OMPMergeableClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase23VisitOMPMergeableClauseENT0_INS_18OMPMergeableClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPMergeableClause(OMPMergeableClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPMergeableClause(((/*static_cast*/OMPMergeableClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPFlushClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 209,
   FQN="clang::OMPClauseVisitorBase::VisitOMPFlushClause", NM="_ZN5clang20OMPClauseVisitorBase19VisitOMPFlushClauseENT0_INS_14OMPFlushClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase19VisitOMPFlushClauseENT0_INS_14OMPFlushClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPFlushClause(OMPFlushClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPFlushClause(((/*static_cast*/OMPFlushClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPReadClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 210,
   FQN="clang::OMPClauseVisitorBase::VisitOMPReadClause", NM="_ZN5clang20OMPClauseVisitorBase18VisitOMPReadClauseENT0_INS_13OMPReadClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase18VisitOMPReadClauseENT0_INS_13OMPReadClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPReadClause(OMPReadClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPReadClause(((/*static_cast*/OMPReadClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPWriteClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 211,
   FQN="clang::OMPClauseVisitorBase::VisitOMPWriteClause", NM="_ZN5clang20OMPClauseVisitorBase19VisitOMPWriteClauseENT0_INS_14OMPWriteClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase19VisitOMPWriteClauseENT0_INS_14OMPWriteClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPWriteClause(OMPWriteClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPWriteClause(((/*static_cast*/OMPWriteClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPUpdateClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 212,
   FQN="clang::OMPClauseVisitorBase::VisitOMPUpdateClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPUpdateClauseENT0_INS_15OMPUpdateClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPUpdateClauseENT0_INS_15OMPUpdateClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPUpdateClause(OMPUpdateClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPUpdateClause(((/*static_cast*/OMPUpdateClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPCaptureClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 213,
   FQN="clang::OMPClauseVisitorBase::VisitOMPCaptureClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPCaptureClauseENT0_INS_16OMPCaptureClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPCaptureClauseENT0_INS_16OMPCaptureClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPCaptureClause(OMPCaptureClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPCaptureClause(((/*static_cast*/OMPCaptureClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPSeqCstClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 214,
   FQN="clang::OMPClauseVisitorBase::VisitOMPSeqCstClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPSeqCstClauseENT0_INS_15OMPSeqCstClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPSeqCstClauseENT0_INS_15OMPSeqCstClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPSeqCstClause(OMPSeqCstClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSeqCstClause(((/*static_cast*/OMPSeqCstClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPDependClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 215,
   FQN="clang::OMPClauseVisitorBase::VisitOMPDependClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPDependClauseENT0_INS_15OMPDependClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPDependClauseENT0_INS_15OMPDependClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPDependClause(OMPDependClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDependClause(((/*static_cast*/OMPDependClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPDeviceClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 216,
   FQN="clang::OMPClauseVisitorBase::VisitOMPDeviceClause", NM="_ZN5clang20OMPClauseVisitorBase20VisitOMPDeviceClauseENT0_INS_15OMPDeviceClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase20VisitOMPDeviceClauseENT0_INS_15OMPDeviceClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPDeviceClause(OMPDeviceClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDeviceClause(((/*static_cast*/OMPDeviceClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPThreadsClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 217,
   FQN="clang::OMPClauseVisitorBase::VisitOMPThreadsClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPThreadsClauseENT0_INS_16OMPThreadsClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPThreadsClauseENT0_INS_16OMPThreadsClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPThreadsClause(OMPThreadsClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPThreadsClause(((/*static_cast*/OMPThreadsClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPSIMDClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 218,
   FQN="clang::OMPClauseVisitorBase::VisitOMPSIMDClause", NM="_ZN5clang20OMPClauseVisitorBase18VisitOMPSIMDClauseENT0_INS_13OMPSIMDClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase18VisitOMPSIMDClauseENT0_INS_13OMPSIMDClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPSIMDClause(OMPSIMDClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPSIMDClause(((/*static_cast*/OMPSIMDClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPMapClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 219,
   FQN="clang::OMPClauseVisitorBase::VisitOMPMapClause", NM="_ZN5clang20OMPClauseVisitorBase17VisitOMPMapClauseENT0_INS_12OMPMapClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase17VisitOMPMapClauseENT0_INS_12OMPMapClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPMapClause(OMPMapClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPMapClause(((/*static_cast*/OMPMapClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPNumTeamsClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 220,
   FQN="clang::OMPClauseVisitorBase::VisitOMPNumTeamsClause", NM="_ZN5clang20OMPClauseVisitorBase22VisitOMPNumTeamsClauseENT0_INS_17OMPNumTeamsClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase22VisitOMPNumTeamsClauseENT0_INS_17OMPNumTeamsClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPNumTeamsClause(OMPNumTeamsClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPNumTeamsClause(((/*static_cast*/OMPNumTeamsClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPThreadLimitClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 221,
   FQN="clang::OMPClauseVisitorBase::VisitOMPThreadLimitClause", NM="_ZN5clang20OMPClauseVisitorBase25VisitOMPThreadLimitClauseENT0_INS_20OMPThreadLimitClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase25VisitOMPThreadLimitClauseENT0_INS_20OMPThreadLimitClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPThreadLimitClause(OMPThreadLimitClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPThreadLimitClause(((/*static_cast*/OMPThreadLimitClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPPriorityClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 222,
   FQN="clang::OMPClauseVisitorBase::VisitOMPPriorityClause", NM="_ZN5clang20OMPClauseVisitorBase22VisitOMPPriorityClauseENT0_INS_17OMPPriorityClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase22VisitOMPPriorityClauseENT0_INS_17OMPPriorityClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPPriorityClause(OMPPriorityClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPPriorityClause(((/*static_cast*/OMPPriorityClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPGrainsizeClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 223,
   FQN="clang::OMPClauseVisitorBase::VisitOMPGrainsizeClause", NM="_ZN5clang20OMPClauseVisitorBase23VisitOMPGrainsizeClauseENT0_INS_18OMPGrainsizeClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase23VisitOMPGrainsizeClauseENT0_INS_18OMPGrainsizeClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPGrainsizeClause(OMPGrainsizeClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPGrainsizeClause(((/*static_cast*/OMPGrainsizeClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPNogroupClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 224,
   FQN="clang::OMPClauseVisitorBase::VisitOMPNogroupClause", NM="_ZN5clang20OMPClauseVisitorBase21VisitOMPNogroupClauseENT0_INS_16OMPNogroupClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase21VisitOMPNogroupClauseENT0_INS_16OMPNogroupClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPNogroupClause(OMPNogroupClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPNogroupClause(((/*static_cast*/OMPNogroupClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPNumTasksClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 225,
   FQN="clang::OMPClauseVisitorBase::VisitOMPNumTasksClause", NM="_ZN5clang20OMPClauseVisitorBase22VisitOMPNumTasksClauseENT0_INS_17OMPNumTasksClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase22VisitOMPNumTasksClauseENT0_INS_17OMPNumTasksClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPNumTasksClause(OMPNumTasksClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPNumTasksClause(((/*static_cast*/OMPNumTasksClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPHintClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 226,
   FQN="clang::OMPClauseVisitorBase::VisitOMPHintClause", NM="_ZN5clang20OMPClauseVisitorBase18VisitOMPHintClauseENT0_INS_13OMPHintClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase18VisitOMPHintClauseENT0_INS_13OMPHintClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPHintClause(OMPHintClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPHintClause(((/*static_cast*/OMPHintClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPDistScheduleClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 227,
   FQN="clang::OMPClauseVisitorBase::VisitOMPDistScheduleClause", NM="_ZN5clang20OMPClauseVisitorBase26VisitOMPDistScheduleClauseENT0_INS_21OMPDistScheduleClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase26VisitOMPDistScheduleClauseENT0_INS_21OMPDistScheduleClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPDistScheduleClause(OMPDistScheduleClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDistScheduleClause(((/*static_cast*/OMPDistScheduleClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPDefaultmapClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 228,
   FQN="clang::OMPClauseVisitorBase::VisitOMPDefaultmapClause", NM="_ZN5clang20OMPClauseVisitorBase24VisitOMPDefaultmapClauseENT0_INS_19OMPDefaultmapClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase24VisitOMPDefaultmapClauseENT0_INS_19OMPDefaultmapClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPDefaultmapClause(OMPDefaultmapClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPDefaultmapClause(((/*static_cast*/OMPDefaultmapClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPToClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 229,
   FQN="clang::OMPClauseVisitorBase::VisitOMPToClause", NM="_ZN5clang20OMPClauseVisitorBase16VisitOMPToClauseENT0_INS_11OMPToClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase16VisitOMPToClauseENT0_INS_11OMPToClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPToClause(OMPToClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPToClause(((/*static_cast*/OMPToClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPFromClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 230,
   FQN="clang::OMPClauseVisitorBase::VisitOMPFromClause", NM="_ZN5clang20OMPClauseVisitorBase18VisitOMPFromClauseENT0_INS_13OMPFromClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase18VisitOMPFromClauseENT0_INS_13OMPFromClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPFromClause(OMPFromClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPFromClause(((/*static_cast*/OMPFromClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPUseDevicePtrClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 231,
   FQN="clang::OMPClauseVisitorBase::VisitOMPUseDevicePtrClause", NM="_ZN5clang20OMPClauseVisitorBase26VisitOMPUseDevicePtrClauseENT0_INS_21OMPUseDevicePtrClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase26VisitOMPUseDevicePtrClauseENT0_INS_21OMPUseDevicePtrClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPUseDevicePtrClause(OMPUseDevicePtrClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPUseDevicePtrClause(((/*static_cast*/OMPUseDevicePtrClause/*P*/)(S))); return;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPIsDevicePtrClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenMPKinds.def", line = 232,
   FQN="clang::OMPClauseVisitorBase::VisitOMPIsDevicePtrClause", NM="_ZN5clang20OMPClauseVisitorBase25VisitOMPIsDevicePtrClauseENT0_INS_20OMPIsDevicePtrClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase25VisitOMPIsDevicePtrClauseENT0_INS_20OMPIsDevicePtrClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPIsDevicePtrClause(OMPIsDevicePtrClause/*P*/ S) {
    ((/*static_cast*/ImplClass /*P*/ )(this)).VisitOMPIsDevicePtrClause(((/*static_cast*/OMPIsDevicePtrClause/*P*/)(S))); return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::Visit">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 203,
   FQN="clang::OMPClauseVisitorBase::Visit", NM="_ZN5clang20OMPClauseVisitorBase5VisitENT0_INS_9OMPClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase5VisitENT0_INS_9OMPClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void Visit(OMPClause/*P*/ S) {
    // Top switch clause: visit each OMPClause.
    switch (S.getClauseKind()) {
     default:
      throw new llvm_unreachable("Unknown clause kind!");
     case OMPC_if:
      
      // OpenMP clauses.
      VisitOMPIfClause(((/*static_cast*/OMPIfClause/*P*/)(S))); return;
     case OMPC_final:
      VisitOMPFinalClause(((/*static_cast*/OMPFinalClause/*P*/)(S))); return;
     case OMPC_num_threads:
      VisitOMPNumThreadsClause(((/*static_cast*/OMPNumThreadsClause/*P*/)(S))); return;
     case OMPC_safelen:
      VisitOMPSafelenClause(((/*static_cast*/OMPSafelenClause/*P*/)(S))); return;
     case OMPC_simdlen:
      VisitOMPSimdlenClause(((/*static_cast*/OMPSimdlenClause/*P*/)(S))); return;
     case OMPC_collapse:
      VisitOMPCollapseClause(((/*static_cast*/OMPCollapseClause/*P*/)(S))); return;
     case OMPC_default:
      VisitOMPDefaultClause(((/*static_cast*/OMPDefaultClause/*P*/)(S))); return;
     case OMPC_private:
      VisitOMPPrivateClause(((/*static_cast*/OMPPrivateClause/*P*/)(S))); return;
     case OMPC_firstprivate:
      VisitOMPFirstprivateClause(((/*static_cast*/OMPFirstprivateClause/*P*/)(S))); return;
     case OMPC_lastprivate:
      VisitOMPLastprivateClause(((/*static_cast*/OMPLastprivateClause/*P*/)(S))); return;
     case OMPC_shared:
      VisitOMPSharedClause(((/*static_cast*/OMPSharedClause/*P*/)(S))); return;
     case OMPC_reduction:
      VisitOMPReductionClause(((/*static_cast*/OMPReductionClause/*P*/)(S))); return;
     case OMPC_linear:
      VisitOMPLinearClause(((/*static_cast*/OMPLinearClause/*P*/)(S))); return;
     case OMPC_aligned:
      VisitOMPAlignedClause(((/*static_cast*/OMPAlignedClause/*P*/)(S))); return;
     case OMPC_copyin:
      VisitOMPCopyinClause(((/*static_cast*/OMPCopyinClause/*P*/)(S))); return;
     case OMPC_copyprivate:
      VisitOMPCopyprivateClause(((/*static_cast*/OMPCopyprivateClause/*P*/)(S))); return;
     case OMPC_proc_bind:
      VisitOMPProcBindClause(((/*static_cast*/OMPProcBindClause/*P*/)(S))); return;
     case OMPC_schedule:
      VisitOMPScheduleClause(((/*static_cast*/OMPScheduleClause/*P*/)(S))); return;
     case OMPC_ordered:
      VisitOMPOrderedClause(((/*static_cast*/OMPOrderedClause/*P*/)(S))); return;
     case OMPC_nowait:
      VisitOMPNowaitClause(((/*static_cast*/OMPNowaitClause/*P*/)(S))); return;
     case OMPC_untied:
      VisitOMPUntiedClause(((/*static_cast*/OMPUntiedClause/*P*/)(S))); return;
     case OMPC_mergeable:
      VisitOMPMergeableClause(((/*static_cast*/OMPMergeableClause/*P*/)(S))); return;
     case OMPC_flush:
      VisitOMPFlushClause(((/*static_cast*/OMPFlushClause/*P*/)(S))); return;
     case OMPC_read:
      VisitOMPReadClause(((/*static_cast*/OMPReadClause/*P*/)(S))); return;
     case OMPC_write:
      VisitOMPWriteClause(((/*static_cast*/OMPWriteClause/*P*/)(S))); return;
     case OMPC_update:
      VisitOMPUpdateClause(((/*static_cast*/OMPUpdateClause/*P*/)(S))); return;
     case OMPC_capture:
      VisitOMPCaptureClause(((/*static_cast*/OMPCaptureClause/*P*/)(S))); return;
     case OMPC_seq_cst:
      VisitOMPSeqCstClause(((/*static_cast*/OMPSeqCstClause/*P*/)(S))); return;
     case OMPC_depend:
      VisitOMPDependClause(((/*static_cast*/OMPDependClause/*P*/)(S))); return;
     case OMPC_device:
      VisitOMPDeviceClause(((/*static_cast*/OMPDeviceClause/*P*/)(S))); return;
     case OMPC_threads:
      VisitOMPThreadsClause(((/*static_cast*/OMPThreadsClause/*P*/)(S))); return;
     case OMPC_simd:
      VisitOMPSIMDClause(((/*static_cast*/OMPSIMDClause/*P*/)(S))); return;
     case OMPC_map:
      VisitOMPMapClause(((/*static_cast*/OMPMapClause/*P*/)(S))); return;
     case OMPC_num_teams:
      VisitOMPNumTeamsClause(((/*static_cast*/OMPNumTeamsClause/*P*/)(S))); return;
     case OMPC_thread_limit:
      VisitOMPThreadLimitClause(((/*static_cast*/OMPThreadLimitClause/*P*/)(S))); return;
     case OMPC_priority:
      VisitOMPPriorityClause(((/*static_cast*/OMPPriorityClause/*P*/)(S))); return;
     case OMPC_grainsize:
      VisitOMPGrainsizeClause(((/*static_cast*/OMPGrainsizeClause/*P*/)(S))); return;
     case OMPC_nogroup:
      VisitOMPNogroupClause(((/*static_cast*/OMPNogroupClause/*P*/)(S))); return;
     case OMPC_num_tasks:
      VisitOMPNumTasksClause(((/*static_cast*/OMPNumTasksClause/*P*/)(S))); return;
     case OMPC_hint:
      VisitOMPHintClause(((/*static_cast*/OMPHintClause/*P*/)(S))); return;
     case OMPC_dist_schedule:
      VisitOMPDistScheduleClause(((/*static_cast*/OMPDistScheduleClause/*P*/)(S))); return;
     case OMPC_defaultmap:
      VisitOMPDefaultmapClause(((/*static_cast*/OMPDefaultmapClause/*P*/)(S))); return;
     case OMPC_to:
      VisitOMPToClause(((/*static_cast*/OMPToClause/*P*/)(S))); return;
     case OMPC_from:
      VisitOMPFromClause(((/*static_cast*/OMPFromClause/*P*/)(S))); return;
     case OMPC_use_device_ptr:
      VisitOMPUseDevicePtrClause(((/*static_cast*/OMPUseDevicePtrClause/*P*/)(S))); return;
     case OMPC_is_device_ptr:
      VisitOMPIsDevicePtrClause(((/*static_cast*/OMPIsDevicePtrClause/*P*/)(S))); return;
    }
  }

  // Base case, ignore it. :)
  //<editor-fold defaultstate="collapsed" desc="clang::OMPClauseVisitorBase::VisitOMPClause">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/StmtVisitor.h", line = 213,
   FQN="clang::OMPClauseVisitorBase::VisitOMPClause", NM="_ZN5clang20OMPClauseVisitorBase14VisitOMPClauseENT0_INS_9OMPClauseEE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZN5clang20OMPClauseVisitorBase14VisitOMPClauseENT0_INS_9OMPClauseEE4typeE")
  //</editor-fold>
  public default/*interface*/ void VisitOMPClause(OMPClause/*P*/ Node) {
    return /*void*/;
  }
}
