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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


/// SubRegion - A region that subsets another larger region.  Most regions
///  are subclasses of SubRegion.
//<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 410,
 FQN="clang::ento::SubRegion", NM="_ZN5clang4ento9SubRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9SubRegionE")
//</editor-fold>
public abstract class SubRegion extends /*public*/ MemRegion implements Destructors.ClassWithDestructor {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 431,
   FQN="clang::ento::SubRegion::anchor", NM="_ZN5clang4ento9SubRegion6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9SubRegion6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }

/*protected:*/
  protected /*const*/ MemRegion /*P*/ superRegion;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion::SubRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 415,
   FQN="clang::ento::SubRegion::SubRegion", NM="_ZN5clang4ento9SubRegionC1EPKNS0_9MemRegionENS2_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9SubRegionC1EPKNS0_9MemRegionENS2_4KindE")
  //</editor-fold>
  protected SubRegion(/*const*/ MemRegion /*P*/ sReg, MemRegion.Kind k) {
    // : MemRegion(k), superRegion(sReg) 
    //START JInit
    super(k);
    this.superRegion = sReg;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion::getSuperRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 417,
   FQN="clang::ento::SubRegion::getSuperRegion", NM="_ZNK5clang4ento9SubRegion14getSuperRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9SubRegion14getSuperRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getSuperRegion() /*const*/ {
    return superRegion;
  }

  
  /// getExtent - Returns the size of the region in bytes.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 422,
   FQN="clang::ento::SubRegion::getExtent", NM="_ZNK5clang4ento9SubRegion9getExtentERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9SubRegion9getExtentERNS0_11SValBuilderE")
  //</editor-fold>
  public /*virtual*/ DefinedOrUnknownSVal getExtent(final SValBuilder /*&*/ svalBuilder) /*const*/ {
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion::getMemRegionManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 158,
   FQN="clang::ento::SubRegion::getMemRegionManager", NM="_ZNK5clang4ento9SubRegion19getMemRegionManagerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9SubRegion19getMemRegionManagerEv")
  //</editor-fold>
  @Override public MemRegionManager /*P*/ getMemRegionManager() /*const*//* override*/ {
    /*const*/ SubRegion /*P*/ r = this;
    do {
      /*const*/ MemRegion /*P*/ superRegion = r.getSuperRegion();
      {
        /*const*/ SubRegion /*P*/ sr = dyn_cast_SubRegion(superRegion);
        if ((sr != null)) {
          r = sr;
          continue;
        }
      }
      return superRegion.getMemRegionManager();
    } while (true);
  }

  
  
  //===----------------------------------------------------------------------===//
  // Basic methods.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion::isSubRegionOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 145,
   FQN="clang::ento::SubRegion::isSubRegionOf", NM="_ZNK5clang4ento9SubRegion13isSubRegionOfEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento9SubRegion13isSubRegionOfEPKNS0_9MemRegionE")
  //</editor-fold>
  @Override public boolean isSubRegionOf(/*const*/ MemRegion /*P*/ R) /*const*//* override*/ {
    /*const*/ MemRegion /*P*/ r = getSuperRegion();
    while (r != null) {
      if (r == R) {
        return true;
      }
      {
        /*const*/ SubRegion /*P*/ sr = dyn_cast_SubRegion(r);
        if ((sr != null)) {
          r = sr.getSuperRegion();
        } else {
          break;
        }
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 430,
   FQN="clang::ento::SubRegion::classof", NM="_ZN5clang4ento9SubRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9SubRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind().getValue() > Kind.END_MEMSPACES.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::SubRegion::~SubRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 410,
   FQN="clang::ento::SubRegion::~SubRegion", NM="_ZN5clang4ento9SubRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento9SubRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "superRegion=[" + superRegion + "]" // NOI18N
              + super.toString(); // NOI18N
  }
}
