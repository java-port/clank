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

package org.llvm.mc;

import org.clank.support.*;
import org.llvm.support.*;


/// \brief This is an extension point for target-specific MCExpr subclasses to
/// implement.
///
/// NOTE: All subclasses are required to have trivial destructors because
/// MCExprs are bump pointer allocated and not destructed.
//<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 526,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 553,
 FQN="llvm::MCTargetExpr", NM="_ZN4llvm12MCTargetExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCTargetExprE")
//</editor-fold>
public abstract class MCTargetExpr extends /*public*/ MCExpr implements Destructors.ClassWithDestructor {
  
  /* *** */
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", line = 389,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp", old_line = 414,
   FQN="llvm::MCTargetExpr::anchor", NM="_ZN4llvm12MCTargetExpr6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCTargetExpr6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::MCTargetExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 529,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 556,
   FQN="llvm::MCTargetExpr::MCTargetExpr", NM="_ZN4llvm12MCTargetExprC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCTargetExprC1Ev")
  //</editor-fold>
  protected MCTargetExpr() {
    // : MCExpr(Target) 
    //START JInit
    super(ExprKind.Target);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::~MCTargetExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 530,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 557,
   FQN="llvm::MCTargetExpr::~MCTargetExpr", NM="_ZN4llvm12MCTargetExprD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCTargetExprD0Ev")
  //</editor-fold>
  public/*protected*/ /*virtual*/ void $destroy() {
    super.$destroy();
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::printImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 532,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 559,
   FQN="llvm::MCTargetExpr::printImpl", NM="_ZNK4llvm12MCTargetExpr9printImplERNS_11raw_ostreamEPKNS_9MCAsmInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm12MCTargetExpr9printImplERNS_11raw_ostreamEPKNS_9MCAsmInfoE")
  //</editor-fold>
  public abstract /*virtual*/ void printImpl(final raw_ostream /*&*/ OS, /*const*/ MCAsmInfo /*P*/ MAI) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::evaluateAsRelocatableImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 533,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 560,
   FQN="llvm::MCTargetExpr::evaluateAsRelocatableImpl", NM="_ZNK4llvm12MCTargetExpr25evaluateAsRelocatableImplERNS_7MCValueEPKNS_11MCAsmLayoutEPKNS_7MCFixupE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm12MCTargetExpr25evaluateAsRelocatableImplERNS_7MCValueEPKNS_11MCAsmLayoutEPKNS_7MCFixupE")
  //</editor-fold>
  public abstract /*virtual*/ boolean evaluateAsRelocatableImpl(final MCValue /*&*/ Res, 
                           /*const*/ MCAsmLayout /*P*/ Layout, 
                           /*const*/ MCFixup /*P*/ Fixup) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::visitUsedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 536,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 563,
   FQN="llvm::MCTargetExpr::visitUsedExpr", NM="_ZNK4llvm12MCTargetExpr13visitUsedExprERNS_10MCStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm12MCTargetExpr13visitUsedExprERNS_10MCStreamerE")
  //</editor-fold>
  public abstract /*virtual*/ void visitUsedExpr(final MCStreamer /*&*/ Streamer) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::findAssociatedFragment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 537,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 564,
   FQN="llvm::MCTargetExpr::findAssociatedFragment", NM="_ZNK4llvm12MCTargetExpr22findAssociatedFragmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm12MCTargetExpr22findAssociatedFragmentEv")
  //</editor-fold>
  public abstract /*virtual*/ MCFragment /*P*/ findAssociatedFragment() /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::fixELFSymbolsInTLSFixups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 539,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 566,
   FQN="llvm::MCTargetExpr::fixELFSymbolsInTLSFixups", NM="_ZNK4llvm12MCTargetExpr24fixELFSymbolsInTLSFixupsERNS_11MCAssemblerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZNK4llvm12MCTargetExpr24fixELFSymbolsInTLSFixupsERNS_11MCAssemblerE")
  //</editor-fold>
  public abstract /*virtual*/ void fixELFSymbolsInTLSFixups(final MCAssembler /*&*/ $Prm0) /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCTargetExpr::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", line = 541,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCExpr.h", old_line = 568,
   FQN="llvm::MCTargetExpr::classof", NM="_ZN4llvm12MCTargetExpr7classofEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCExpr.cpp -nm=_ZN4llvm12MCTargetExpr7classofEPKNS_6MCExprE")
  //</editor-fold>
  public static boolean classof(/*const*/ MCExpr /*P*/ E) {
    return E.getKind() == MCExpr.ExprKind.Target;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
