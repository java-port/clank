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

package org.llvm.analysis;

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
import org.llvm.analysis.RegionInfoGlobals.RegionInfoBase;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;

//<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 866,
 FQN="llvm::RegionInfo", NM="_ZN4llvm10RegionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfoE")
//</editor-fold>
public class RegionInfo extends /*public*/ RegionInfoBase/*<RegionTraitsFunction>*/ implements Destructors.ClassWithDestructor {
/*public:*/
  // JAVA: typedef RegionInfoBase<RegionTraits<Function> > Base
//  public final class Base extends RegionInfoBase<RegionTraitsFunction>{ };
  
  
  //===----------------------------------------------------------------------===//
  // RegionInfo implementation
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo::RegionInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 78,
   FQN="llvm::RegionInfo::RegionInfo", NM="_ZN4llvm10RegionInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfoC1Ev")
  //</editor-fold>
  public RegionInfo() {
    // : RegionInfoBase<RegionTraits<Function> >() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo::~RegionInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 83,
   FQN="llvm::RegionInfo::~RegionInfo", NM="_ZN4llvm10RegionInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfoD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo::RegionInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 874,
   FQN="llvm::RegionInfo::RegionInfo", NM="_ZN4llvm10RegionInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfoC1EOS0_")
  //</editor-fold>
  public RegionInfo(JD$Move _dparam, final RegionInfo /*&&*/Arg) {
    // : Base(std::move(static_cast<Base & >(Arg))) 
    //super(JD$Move.INSTANCE, std.move(((/*static_cast*/RegionInfoBase<RegionTraitsFunction> /*&*/ )(Arg))));
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 876,
   FQN="llvm::RegionInfo::operator=", NM="_ZN4llvm10RegionInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfoaSEOS0_")
  //</editor-fold>
  public RegionInfo /*&*/ $assignMove(final RegionInfo /*&&*/RHS) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // updateStatistics - Update statistic about created regions.
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo::updateStatistics">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 87,
   FQN="llvm::RegionInfo::updateStatistics", NM="_ZN4llvm10RegionInfo16updateStatisticsEPNS_6RegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfo16updateStatisticsEPNS_6RegionE")
  //</editor-fold>
  @Override public final void updateStatistics(Region /*P*/ R)/* final*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo::recalculate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 95,
   FQN="llvm::RegionInfo::recalculate", NM="_ZN4llvm10RegionInfo11recalculateERNS_8FunctionEPNS_13DominatorTreeEPNS_17PostDominatorTreeEPNS_17DominanceFrontierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfo11recalculateERNS_8FunctionEPNS_13DominatorTreeEPNS_17PostDominatorTreeEPNS_17DominanceFrontierE")
  //</editor-fold>
  public void recalculate(final Function /*&*/ F, DominatorTree /*P*/ DT_, 
             PostDominatorTree /*P*/ PDT_, DominanceFrontier /*P*/ DF_) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// @brief Opens a viewer to show the GraphViz visualization of the regions.
  ///
  /// Useful during debugging as an alternative to dump().
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo::view">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 108,
   FQN="llvm::RegionInfo::view", NM="_ZN4llvm10RegionInfo4viewEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfo4viewEv")
  //</editor-fold>
  public void view() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @brief Opens a viewer to show the GraphViz visualization of this region
  /// without instructions in the BasicBlocks.
  ///
  /// Useful during debugging as an alternative to dump().
  //<editor-fold defaultstate="collapsed" desc="llvm::RegionInfo::viewOnly">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 110,
   FQN="llvm::RegionInfo::viewOnly", NM="_ZN4llvm10RegionInfo8viewOnlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm10RegionInfo8viewOnlyEv")
  //</editor-fold>
  public void viewOnly() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
