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

package org.llvm.ir;

import org.clank.support.*;


/// \brief Alias summary information.
//<editor-fold defaultstate="collapsed" desc="llvm::AliasSummary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 206,
 FQN="llvm::AliasSummary", NM="_ZN4llvm12AliasSummaryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm12AliasSummaryE")
//</editor-fold>
public class AliasSummary extends /*public*/ GlobalValueSummary implements Destructors.ClassWithDestructor {
  private GlobalValueSummary /*P*/ AliaseeSummary;
/*public:*/
  /// Summary constructors.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSummary::AliasSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 211,
   FQN="llvm::AliasSummary::AliasSummary", NM="_ZN4llvm12AliasSummaryC1ENS_18GlobalValueSummary7GVFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm12AliasSummaryC1ENS_18GlobalValueSummary7GVFlagsE")
  //</editor-fold>
  public AliasSummary(GlobalValueSummary.GVFlags Flags) {
    // : GlobalValueSummary(AliasKind, Flags) 
    //START JInit
    super(SummaryKind.AliasKind, new GlobalValueSummary.GVFlags(Flags));
    //END JInit
  }

  
  /// Check if this is an alias summary.
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSummary::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 214,
   FQN="llvm::AliasSummary::classof", NM="_ZN4llvm12AliasSummary7classofEPKNS_18GlobalValueSummaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm12AliasSummary7classofEPKNS_18GlobalValueSummaryE")
  //</editor-fold>
  public static boolean classof(/*const*/ GlobalValueSummary /*P*/ GVS) {
    return GVS.getSummaryKind() == SummaryKind.AliasKind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSummary::setAliasee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 218,
   FQN="llvm::AliasSummary::setAliasee", NM="_ZN4llvm12AliasSummary10setAliaseeEPNS_18GlobalValueSummaryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm12AliasSummary10setAliaseeEPNS_18GlobalValueSummaryE")
  //</editor-fold>
  public void setAliasee(GlobalValueSummary /*P*/ Aliasee) {
    AliaseeSummary = Aliasee;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSummary::getAliasee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 220,
   FQN="llvm::AliasSummary::getAliasee", NM="_ZNK4llvm12AliasSummary10getAliaseeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZNK4llvm12AliasSummary10getAliaseeEv")
  //</editor-fold>
  public /*const*/ GlobalValueSummary /*&*/ getAliasee$Const() /*const*/ {
    return ((/*const_cast*/AliasSummary /*P*/ )(this)).getAliasee();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSummary::getAliasee">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 224,
   FQN="llvm::AliasSummary::getAliasee", NM="_ZN4llvm12AliasSummary10getAliaseeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm12AliasSummary10getAliaseeEv")
  //</editor-fold>
  public GlobalValueSummary /*&*/ getAliasee() {
    assert ((AliaseeSummary != null)) : "Unexpected missing aliasee summary";
    return /*Deref*/AliaseeSummary;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::AliasSummary::~AliasSummary">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/ModuleSummaryIndex.h", line = 206,
   FQN="llvm::AliasSummary::~AliasSummary", NM="_ZN4llvm12AliasSummaryD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/ModuleSummaryIndex.cpp -nm=_ZN4llvm12AliasSummaryD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "AliaseeSummary=" + AliaseeSummary // NOI18N
              + super.toString(); // NOI18N
  }
}
