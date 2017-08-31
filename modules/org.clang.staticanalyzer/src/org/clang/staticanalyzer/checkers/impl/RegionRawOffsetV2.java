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
package org.clang.staticanalyzer.checkers.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals;


// FIXME: Eventually replace RegionRawOffset with this class.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 44,
 FQN="(anonymous namespace)::RegionRawOffsetV2", NM="_ZN12_GLOBAL__N_117RegionRawOffsetV2E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_117RegionRawOffsetV2E")
//</editor-fold>
public class RegionRawOffsetV2 {
/*private:*/
  private /*const*/ SubRegion /*P*/ baseRegion;
  private SVal byteOffset;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2::RegionRawOffsetV2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 49,
   FQN="(anonymous namespace)::RegionRawOffsetV2::RegionRawOffsetV2", NM="_ZN12_GLOBAL__N_117RegionRawOffsetV2C1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_117RegionRawOffsetV2C1Ev")
  //</editor-fold>
  private RegionRawOffsetV2() {
    // : baseRegion(null), byteOffset(UnknownVal()) 
    //START JInit
    this.baseRegion = null;
    this.byteOffset = new SVal(JD$Move.INSTANCE, new UnknownVal());
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2::RegionRawOffsetV2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 53,
   FQN="(anonymous namespace)::RegionRawOffsetV2::RegionRawOffsetV2", NM="_ZN12_GLOBAL__N_117RegionRawOffsetV2C1EPKN5clang4ento9SubRegionENS2_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_117RegionRawOffsetV2C1EPKN5clang4ento9SubRegionENS2_4SValE")
  //</editor-fold>
  public RegionRawOffsetV2(/*const*/ SubRegion /*P*/ base, SVal offset) {
    // : baseRegion(base), byteOffset(offset) 
    //START JInit
    this.baseRegion = base;
    this.byteOffset = new SVal(offset);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2::getByteOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 56,
   FQN="(anonymous namespace)::RegionRawOffsetV2::getByteOffset", NM="_ZNK12_GLOBAL__N_117RegionRawOffsetV213getByteOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZNK12_GLOBAL__N_117RegionRawOffsetV213getByteOffsetEv")
  //</editor-fold>
  public NonLoc getByteOffset() /*const*/ {
    return byteOffset.castAs(NonLoc.class);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2::getRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 57,
   FQN="(anonymous namespace)::RegionRawOffsetV2::getRegion", NM="_ZNK12_GLOBAL__N_117RegionRawOffsetV29getRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZNK12_GLOBAL__N_117RegionRawOffsetV29getRegionEv")
  //</editor-fold>
  public /*const*/ SubRegion /*P*/ getRegion() /*const*/ {
    return baseRegion;
  }

  
  
  /// Compute a raw byte offset from a base region.  Used for array bounds
  /// checking.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2::computeOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 256,
   FQN="(anonymous namespace)::RegionRawOffsetV2::computeOffset", NM="_ZN12_GLOBAL__N_117RegionRawOffsetV213computeOffsetEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS4_11SValBuilderENS4_4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_117RegionRawOffsetV213computeOffsetEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERNS4_11SValBuilderENS4_4SValE")
  //</editor-fold>
  public static RegionRawOffsetV2 computeOffset(IntrusiveRefCntPtr</*const*/ ProgramState> state, 
               final SValBuilder /*&*/ svalBuilder, 
               SVal location) {
    /*const*/ MemRegion /*P*/ region = location.getAsRegion();
    SVal offset = new SVal(JD$Move.INSTANCE, new UndefinedVal());
    while ((region != null)) {
      switch (region.getKind()) {
       default:
        {
          {
            /*const*/ SubRegion /*P*/ subReg = dyn_cast_SubRegion(region);
            if ((subReg != null)) {
              offset.$assignMove(ArrayBoundCheckerV2Statics.getValue(new SVal(offset), svalBuilder));
              if (!offset.isUnknownOrUndef$SVal()) {
                return new RegionRawOffsetV2(subReg, new SVal(offset));
              }
            }
          }
          return new RegionRawOffsetV2();
        }
       case ElementRegionKind:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*const*/ ElementRegion /*P*/ elemReg = cast_ElementRegion(region);
            SVal index = new SVal(JD$Move.INSTANCE, elemReg.getIndex());
            if (!index.getAs(NonLoc.class).$bool()) {
              return new RegionRawOffsetV2();
            }
            QualType elemType = elemReg.getElementType();
            // If the element is an incomplete type, go no further.
            final ASTContext /*&*/ astContext = svalBuilder.getContext();
            if (elemType.$arrow().isIncompleteType()) {
              return new RegionRawOffsetV2();
            }
            
            // Update the offset.
            $c$.clean(offset.$assignMove(ArrayBoundCheckerV2Statics.addValue($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), 
                    ArrayBoundCheckerV2Statics.getValue(new SVal(offset), svalBuilder), 
                    ArrayBoundCheckerV2Statics.scaleValue($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), 
                        index.castAs(NonLoc.class), 
                        astContext.getTypeSizeInChars(/*NO_COPY*/elemType), 
                        svalBuilder), 
                    svalBuilder)));
            if (offset.isUnknownOrUndef$SVal()) {
              return new RegionRawOffsetV2();
            }
            
            region = elemReg.getSuperRegion();
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    return new RegionRawOffsetV2();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 214,
   FQN="(anonymous namespace)::RegionRawOffsetV2::dump", NM="_ZNK12_GLOBAL__N_117RegionRawOffsetV24dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZNK12_GLOBAL__N_117RegionRawOffsetV24dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dumpToStream(llvm.errs());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 218,
   FQN="(anonymous namespace)::RegionRawOffsetV2::dumpToStream", NM="_ZNK12_GLOBAL__N_117RegionRawOffsetV212dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZNK12_GLOBAL__N_117RegionRawOffsetV212dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dumpToStream(final raw_ostream /*&*/ os) /*const*/ {
    StaticanalyzerLlvmGlobals.$out_raw_ostream_SVal(StaticanalyzerLlvmGlobals.$out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/"raw_offset_v2{"), getRegion()).$out_char($$COMMA), /*NO_COPY*/getByteOffset()).$out_char($$RCURLY);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionRawOffsetV2::RegionRawOffsetV2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp", line = 44,
   FQN="(anonymous namespace)::RegionRawOffsetV2::RegionRawOffsetV2", NM="_ZN12_GLOBAL__N_117RegionRawOffsetV2C1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ArrayBoundCheckerV2.cpp -nm=_ZN12_GLOBAL__N_117RegionRawOffsetV2C1EOS0_")
  //</editor-fold>
  public /*inline*/ RegionRawOffsetV2(JD$Move _dparam, final RegionRawOffsetV2 /*&&*/$Prm0) {
    // : baseRegion(static_cast<RegionRawOffsetV2 &&>().baseRegion), byteOffset(static_cast<RegionRawOffsetV2 &&>().byteOffset) 
    //START JInit
    this.baseRegion = $Prm0.baseRegion;
    this.byteOffset = new SVal(JD$Move.INSTANCE, $Prm0.byteOffset);
    //END JInit
  }

  
  @Override public String toString() {
    if (true) {
      return llvm.DumpJavaString(this, RegionRawOffsetV2::dumpToStream);
    }
    return "" + "baseRegion=" + baseRegion // NOI18N
              + ", byteOffset=" + byteOffset; // NOI18N
  }
}
