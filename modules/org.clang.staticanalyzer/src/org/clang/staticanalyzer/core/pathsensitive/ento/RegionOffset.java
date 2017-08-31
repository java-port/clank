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
import static org.clank.java.io.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// Represent a region's offset within the top level base region.
//<editor-fold defaultstate="collapsed" desc="clang::ento::RegionOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 47,
 FQN="clang::ento::RegionOffset", NM="_ZN5clang4ento12RegionOffsetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12RegionOffsetE")
//</editor-fold>
public class RegionOffset {
  /// The base region.
  private /*const*/ MemRegion /*P*/ R;
  
  /// The bit offset within the base region. Can be negative.
  private long/*int64_t*/ Offset;
/*public:*/
  // We're using a const instead of an enumeration due to the size required;
  // Visual Studio will only create enumerations of size int, not long long.
  public static /*const*/long/*int64_t*/ Symbolic = INT64_MAX;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionOffset::RegionOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 59,
   FQN="clang::ento::RegionOffset::RegionOffset", NM="_ZN5clang4ento12RegionOffsetC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12RegionOffsetC1Ev")
  //</editor-fold>
  public RegionOffset() {
    // : R(null) 
    //START JInit
    this.R = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionOffset::RegionOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 60,
   FQN="clang::ento::RegionOffset::RegionOffset", NM="_ZN5clang4ento12RegionOffsetC1EPKNS0_9MemRegionEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12RegionOffsetC1EPKNS0_9MemRegionEx")
  //</editor-fold>
  public RegionOffset(/*const*/ MemRegion /*P*/ r, long/*int64_t*/ off) {
    // : R(r), Offset(off) 
    //START JInit
    this.R = r;
    this.Offset = off;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionOffset::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 62,
   FQN="clang::ento::RegionOffset::getRegion", NM="_ZNK5clang4ento12RegionOffset9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12RegionOffset9getRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getRegion() /*const*/ {
    return R;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionOffset::hasSymbolicOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 64,
   FQN="clang::ento::RegionOffset::hasSymbolicOffset", NM="_ZNK5clang4ento12RegionOffset17hasSymbolicOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12RegionOffset17hasSymbolicOffsetEv")
  //</editor-fold>
  public boolean hasSymbolicOffset() /*const*/ {
    return Offset == Symbolic;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionOffset::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 66,
   FQN="clang::ento::RegionOffset::getOffset", NM="_ZNK5clang4ento12RegionOffset9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12RegionOffset9getOffsetEv")
  //</editor-fold>
  public long/*int64_t*/ getOffset() /*const*/ {
    assert (!hasSymbolicOffset());
    return Offset;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionOffset::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 71,
   FQN="clang::ento::RegionOffset::isValid", NM="_ZNK5clang4ento12RegionOffset7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento12RegionOffset7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return (R != null);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionOffset::RegionOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 47,
   FQN="clang::ento::RegionOffset::RegionOffset", NM="_ZN5clang4ento12RegionOffsetC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento12RegionOffsetC1EOS1_")
  //</editor-fold>
  public /*inline*/ RegionOffset(JD$Move _dparam, final RegionOffset /*&&*/$Prm0) {
    // : R(static_cast<RegionOffset &&>().R), Offset(static_cast<RegionOffset &&>().Offset) 
    //START JInit
    this.R = $Prm0.R;
    this.Offset = $Prm0.Offset;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "R=" + R // NOI18N
              + ", Offset=" + Offset; // NOI18N
  }
}
