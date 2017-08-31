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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import org.clank.java.std;

//<editor-fold defaultstate="collapsed" desc="clang::ento::RegionRawOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 984,
 FQN="clang::ento::RegionRawOffset", NM="_ZN5clang4ento15RegionRawOffsetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15RegionRawOffsetE")
//</editor-fold>
public class RegionRawOffset {
/*private:*/
  /*friend  class ElementRegion*/
  
  private /*const*/ MemRegion /*P*/ Region;
  private CharUnits Offset;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionRawOffset::RegionRawOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 991,
   FQN="clang::ento::RegionRawOffset::RegionRawOffset", NM="_ZN5clang4ento15RegionRawOffsetC1EPKNS0_9MemRegionENS_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15RegionRawOffsetC1EPKNS0_9MemRegionENS_9CharUnitsE")
  //</editor-fold>
  /*friend*/public/*private*/ RegionRawOffset(/*const*/ MemRegion /*P*/ reg) {
    this(reg, CharUnits.Zero());
  }
  /*friend*/public/*private*/ RegionRawOffset(/*const*/ MemRegion /*P*/ reg, CharUnits offset/*= CharUnits::Zero()*/) {
    // : Region(reg), Offset(offset) 
    //START JInit
    this.Region = reg;
    this.Offset = new CharUnits(offset);
    //END JInit
  }

/*public:*/
  // FIXME: Eventually support symbolic offsets.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionRawOffset::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 996,
   FQN="clang::ento::RegionRawOffset::getOffset", NM="_ZNK5clang4ento15RegionRawOffset9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15RegionRawOffset9getOffsetEv")
  //</editor-fold>
  public CharUnits getOffset() /*const*/ {
    return new CharUnits(Offset);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionRawOffset::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 997,
   FQN="clang::ento::RegionRawOffset::getRegion", NM="_ZNK5clang4ento15RegionRawOffset9getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15RegionRawOffset9getRegionEv")
  //</editor-fold>
  public /*const*/ MemRegion /*P*/ getRegion() /*const*/ {
    return Region;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionRawOffset::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 528,
   FQN="clang::ento::RegionRawOffset::dumpToStream", NM="_ZNK5clang4ento15RegionRawOffset12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15RegionRawOffset12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpToStream(final raw_ostream /*&*/ os) /*const*/ {
    $out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/"raw_offset{"), getRegion()).$out_char($$COMMA).$out_llong(getOffset().getQuantity()).$out_char($$RCURLY);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionRawOffset::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 524,
   FQN="clang::ento::RegionRawOffset::dump", NM="_ZNK5clang4ento15RegionRawOffset4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15RegionRawOffset4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpToStream(llvm.errs());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionRawOffset::RegionRawOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 984,
   FQN="clang::ento::RegionRawOffset::RegionRawOffset", NM="_ZN5clang4ento15RegionRawOffsetC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15RegionRawOffsetC1EOS1_")
  //</editor-fold>
  public /*inline*/ RegionRawOffset(JD$Move _dparam, final RegionRawOffset /*&&*/$Prm0) {
    // : Region(static_cast<RegionRawOffset &&>().Region), Offset(static_cast<RegionRawOffset &&>().Offset) 
    //START JInit
    this.Region = $Prm0.Region;
    this.Offset = new CharUnits(JD$Move.INSTANCE, $Prm0.Offset);
    //END JInit
  }

  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);    
      dumpToStream(OS);
      OS.flush();      
      return Buf.toJavaString();
    }    
    return "" + "Region=" + Region // NOI18N
              + ", Offset=" + Offset; // NOI18N
  }
}
