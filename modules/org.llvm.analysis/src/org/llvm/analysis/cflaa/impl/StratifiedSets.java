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

package org.llvm.analysis.cflaa.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import org.llvm.analysis.bfi_detail.*;


/// \brief These are stratified sets, as described in "Fast algorithms for
/// Dyck-CFL-reachability with applications to Alias Analysis" by Zhang Q, Lyu M
/// R, Yuan H, and Su Z. -- in short, this is meant to represent different sets
/// of Value*s. If two Value*s are in the same set, or if both sets have
/// overlapping attributes, then the Value*s are said to alias.
///
/// Sets may be related by position, meaning that one set may be considered as
/// above or below another. In CFL Alias Analysis, this gives us an indication
/// of how two variables are related; if the set of variable A is below a set
/// containing variable B, then at some point, a variable that has interacted
/// with B (or B itself) was either used in order to extract the variable A, or
/// was used as storage of variable A.
///
/// Sets may also have attributes (as noted above). These attributes are
/// generally used for noting whether a variable in the set has interacted with
/// a variable whose origins we don't quite know (i.e. globals/arguments), or if
/// the variable may have had operations performed on it (modified in a function
/// call). All attributes that exist in a set A must exist in all sets marked as
/// below set A.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSets">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 85,
 FQN="llvm::cflaa::StratifiedSets", NM="_ZN4llvm5cflaa14StratifiedSetsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa14StratifiedSetsE")
//</editor-fold>
public class StratifiedSets</*typename*/ T>  implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSets::StratifiedSets<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 87,
   FQN="llvm::cflaa::StratifiedSets::StratifiedSets<T>", NM="_ZN4llvm5cflaa14StratifiedSetsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa14StratifiedSetsC1Ev")
  //</editor-fold>
  public StratifiedSets()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  // TODO: Figure out how to make MSVC not call the copy ctor here, and delete
  // it.
  
  // Can't default these due to compile errors in MSVC2013
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSets::StratifiedSets<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 93,
   FQN="llvm::cflaa::StratifiedSets::StratifiedSets<T>", NM="_ZN4llvm5cflaa14StratifiedSetsC1EONS0_14StratifiedSetsIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa14StratifiedSetsC1EONS0_14StratifiedSetsIT_EE")
  //</editor-fold>
  public StratifiedSets(JD$Move _dparam, final StratifiedSets<T> /*&&*/Other) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSets::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 94,
   FQN="llvm::cflaa::StratifiedSets::operator=", NM="_ZN4llvm5cflaa14StratifiedSetsaSEONS0_14StratifiedSetsIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa14StratifiedSetsaSEONS0_14StratifiedSetsIT_EE")
  //</editor-fold>
  public StratifiedSets<T> /*&*/ $assignMove(final StratifiedSets<T> /*&&*/Other) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSets::StratifiedSets<T>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 100,
   FQN="llvm::cflaa::StratifiedSets::StratifiedSets<T>", NM="_ZN4llvm5cflaa14StratifiedSetsC1ENS_8DenseMapIT_NS0_14StratifiedInfoENS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S4_EEEESt6vectorINS0_14StratifiedLinkESaISC_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm5cflaa14StratifiedSetsC1ENS_8DenseMapIT_NS0_14StratifiedInfoENS_12DenseMapInfoIS3_EENS_6detail12DenseMapPairIS3_S4_EEEESt6vectorINS0_14StratifiedLinkESaISC_EE")
  //</editor-fold>
  public StratifiedSets(DenseMap<T, StratifiedInfo> Map, 
      std.vector<StratifiedLink> Links) {
    // : Values(std::move(Map)), Links(std::move(Links)) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSets::find">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 104,
   FQN="llvm::cflaa::StratifiedSets::find", NM="_ZNK4llvm5cflaa14StratifiedSets4findERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa14StratifiedSets4findERKT_")
  //</editor-fold>
  public Optional<StratifiedInfo> find(final /*const*/ T /*&*/ Elem) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSets::getLink">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 111,
   FQN="llvm::cflaa::StratifiedSets::getLink", NM="_ZNK4llvm5cflaa14StratifiedSets7getLinkEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa14StratifiedSets7getLinkEj")
  //</editor-fold>
  public /*const*/ StratifiedLink /*&*/ getLink(/*uint*/int Index) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  private DenseMap<T, StratifiedInfo> Values;
  private std.vector<StratifiedLink> Links;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::cflaa::StratifiedSets::inbounds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/StratifiedSets.h", line = 120,
   FQN="llvm::cflaa::StratifiedSets::inbounds", NM="_ZNK4llvm5cflaa14StratifiedSets8inboundsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZNK4llvm5cflaa14StratifiedSets8inboundsEj")
  //</editor-fold>
  private boolean inbounds(/*uint*/int Idx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $destroy() { }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Values=" + Values // NOI18N
              + ", Links=" + Links; // NOI18N
  }
}
