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

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.analysis.support.*;


/// BlockDataRegion - A region that represents a block instance.
///  Blocks are represented with two kinds of regions.  BlockCodeRegions
///  represent the "code", while BlockDataRegions represent instances of blocks,
///  which correspond to "code+data".  The distinction is important, because
///  like a closure a block captures the values of externally referenced
///  variables.
//<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 627,
 FQN="clang::ento::BlockDataRegion", NM="_ZN5clang4ento15BlockDataRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegionE")
//</editor-fold>
public class BlockDataRegion extends /*public*/ TypedRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
  private /*const*/ BlockCodeRegion /*P*/ BC;
  private /*const*/ LocationContext /*P*/ LC; // Can be null */
  private /*uint*/int BlockCount;
  private Object/*void P*/ ReferencedVars;
  private Object/*void P*/ OriginalVars;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::BlockDataRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 635,
   FQN="clang::ento::BlockDataRegion::BlockDataRegion", NM="_ZN5clang4ento15BlockDataRegionC1EPKNS0_15BlockCodeRegionEPKNS_15LocationContextEjPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegionC1EPKNS0_15BlockCodeRegionEPKNS_15LocationContextEjPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ BlockDataRegion(/*const*/ BlockCodeRegion /*P*/ bc, /*const*/ LocationContext /*P*/ lc, 
      /*uint*/int count, /*const*/ MemRegion /*P*/ sreg) {
    // : TypedRegion(sreg, BlockDataRegionKind), BC(bc), LC(lc), BlockCount(count), ReferencedVars(null), OriginalVars(null) 
    //START JInit
    super(sreg, Kind.BlockDataRegionKind);
    this.BC = bc;
    this.LC = lc;
    this.BlockCount = count;
    this.ReferencedVars = null;
    this.OriginalVars = null;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::getCodeRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 642,
   FQN="clang::ento::BlockDataRegion::getCodeRegion", NM="_ZNK5clang4ento15BlockDataRegion13getCodeRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion13getCodeRegionEv")
  //</editor-fold>
  public /*const*/ BlockCodeRegion /*P*/ getCodeRegion() /*const*/ {
    return BC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 644,
   FQN="clang::ento::BlockDataRegion::getDecl", NM="_ZNK5clang4ento15BlockDataRegion7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion7getDeclEv")
  //</editor-fold>
  public /*const*/ BlockDecl /*P*/ getDecl() /*const*/ {
    return BC.getDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::getLocationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 646,
   FQN="clang::ento::BlockDataRegion::getLocationType", NM="_ZNK5clang4ento15BlockDataRegion15getLocationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion15getLocationTypeEv")
  //</editor-fold>
  @Override public QualType getLocationType() /*const*//* override*/ {
    return BC.getLocationType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_iterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 648,
   FQN="clang::ento::BlockDataRegion::referenced_vars_iterator", NM="_ZN5clang4ento15BlockDataRegion24referenced_vars_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegion24referenced_vars_iteratorE")
  //</editor-fold>
  public static class referenced_vars_iterator implements Native.NativeComparable<referenced_vars_iterator> {
    private type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> R;
    private type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> OriginalR;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_iterator::referenced_vars_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 652,
     FQN="clang::ento::BlockDataRegion::referenced_vars_iterator::referenced_vars_iterator", NM="_ZN5clang4ento15BlockDataRegion24referenced_vars_iteratorC1EPKPKNS0_9MemRegionES7_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegion24referenced_vars_iteratorC1EPKPKNS0_9MemRegionES7_")
    //</editor-fold>
    public /*explicit*/ referenced_vars_iterator(type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> r, 
        type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/> originalR) {
      // : R(r), OriginalR(originalR) 
      //START JInit
      this.R = $tryClone(r);
      this.OriginalR = $tryClone(originalR);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_iterator::getCapturedRegion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 656,
     FQN="clang::ento::BlockDataRegion::referenced_vars_iterator::getCapturedRegion", NM="_ZNK5clang4ento15BlockDataRegion24referenced_vars_iterator17getCapturedRegionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion24referenced_vars_iterator17getCapturedRegionEv")
    //</editor-fold>
    public /*const*/ VarRegion /*P*/ getCapturedRegion() /*const*/ {
      return cast_VarRegion(R.$star());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_iterator::getOriginalRegion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 659,
     FQN="clang::ento::BlockDataRegion::referenced_vars_iterator::getOriginalRegion", NM="_ZNK5clang4ento15BlockDataRegion24referenced_vars_iterator17getOriginalRegionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion24referenced_vars_iterator17getOriginalRegionEv")
    //</editor-fold>
    public /*const*/ VarRegion /*P*/ getOriginalRegion() /*const*/ {
      return cast_VarRegion(OriginalR.$star());
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_iterator::operator==">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 663,
     FQN="clang::ento::BlockDataRegion::referenced_vars_iterator::operator==", NM="_ZNK5clang4ento15BlockDataRegion24referenced_vars_iteratoreqERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion24referenced_vars_iteratoreqERKS2_")
    //</editor-fold>
    public boolean $eq(final /*const*/ referenced_vars_iterator /*&*/ I) /*const*/ {
      assert (($eq_ptr(R, null)) == ($eq_ptr(I.R, null)));
      return $eq_ptr(I.R, R);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_iterator::operator!=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 667,
     FQN="clang::ento::BlockDataRegion::referenced_vars_iterator::operator!=", NM="_ZNK5clang4ento15BlockDataRegion24referenced_vars_iteratorneERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion24referenced_vars_iteratorneERKS2_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ referenced_vars_iterator /*&*/ I) /*const*/ {
      assert (($eq_ptr(R, null)) == ($eq_ptr(I.R, null)));
      return $noteq_ptr(I.R, R);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_iterator::operator++">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 671,
     FQN="clang::ento::BlockDataRegion::referenced_vars_iterator::operator++", NM="_ZN5clang4ento15BlockDataRegion24referenced_vars_iteratorppEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegion24referenced_vars_iteratorppEv")
    //</editor-fold>
    public referenced_vars_iterator /*&*/ $preInc() {
      R.$preInc();
      OriginalR.$preInc();
      return /*Deref*/this;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_iterator::referenced_vars_iterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 648,
     FQN="clang::ento::BlockDataRegion::referenced_vars_iterator::referenced_vars_iterator", NM="_ZN5clang4ento15BlockDataRegion24referenced_vars_iteratorC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegion24referenced_vars_iteratorC1EOS2_")
    //</editor-fold>
    public /*inline*/ referenced_vars_iterator(JD$Move _dparam, final referenced_vars_iterator /*&&*/$Prm0) {
      // : R(static_cast<referenced_vars_iterator &&>().R), OriginalR(static_cast<referenced_vars_iterator &&>().OriginalR) 
      //START JInit
      this.R = $tryClone($Prm0.R);
      this.OriginalR = $tryClone($Prm0.OriginalR);
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "R=" + R // NOI18N
                + ", OriginalR=" + OriginalR; // NOI18N
    }
  };
  
  /// Return the original region for a captured region, if
  /// one exists.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::getOriginalRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1512,
   FQN="clang::ento::BlockDataRegion::getOriginalRegion", NM="_ZNK5clang4ento15BlockDataRegion17getOriginalRegionEPKNS0_9VarRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion17getOriginalRegionEPKNS0_9VarRegionE")
  //</editor-fold>
  public /*const*/ VarRegion /*P*/ getOriginalRegion(/*const*/ VarRegion /*P*/ R) /*const*/ {
    for (referenced_vars_iterator I = referenced_vars_begin(), 
        E = referenced_vars_end();
         I.$noteq(E); I.$preInc()) {
      if (I.getCapturedRegion() == R) {
        return I.getOriginalRegion();
      }
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1478,
   FQN="clang::ento::BlockDataRegion::referenced_vars_begin", NM="_ZNK5clang4ento15BlockDataRegion21referenced_vars_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion21referenced_vars_beginEv")
  //</editor-fold>
  public BlockDataRegion.referenced_vars_iterator referenced_vars_begin() /*const*/ {
    ((/*const_cast*/BlockDataRegion /*P*/ )(this)).LazyInitializeReferencedVars();
    
    // JAVA: check first 
    if (ReferencedVars == EMPTY$ReferencedVars) { // $eq_ptr(Vec, (Object/*void P*/ )0x1)
      return new BlockDataRegion.referenced_vars_iterator((type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/>)null, (type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/>)null);
    }
    BumpVector</*const*/ MemRegion /*P*/ > /*P*/ Vec = ((/*static_cast*/BumpVector</*const*/ MemRegion /*P*/ > /*P*/ )(ReferencedVars));
    
    BumpVector</*const*/ MemRegion /*P*/ > /*P*/ VecOriginal = ((/*static_cast*/BumpVector</*const*/ MemRegion /*P*/ > /*P*/ )(OriginalVars));
    
    return new BlockDataRegion.referenced_vars_iterator(Vec.begin(), 
        VecOriginal.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::referenced_vars_end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1495,
   FQN="clang::ento::BlockDataRegion::referenced_vars_end", NM="_ZNK5clang4ento15BlockDataRegion19referenced_vars_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion19referenced_vars_endEv")
  //</editor-fold>
  public BlockDataRegion.referenced_vars_iterator referenced_vars_end() /*const*/ {
    ((/*const_cast*/BlockDataRegion /*P*/ )(this)).LazyInitializeReferencedVars();
    
    // JAVA: check first 
    if (ReferencedVars == EMPTY$ReferencedVars) { // $eq_ptr(Vec, (Object/*void P*/ )0x1)
      return new BlockDataRegion.referenced_vars_iterator((type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/>)null, (type$ptr</*const*/ MemRegion /*P*/ /*const*/ /*P*/>)null);
    }
    BumpVector</*const*/ MemRegion /*P*/ > /*P*/ Vec = ((/*static_cast*/BumpVector</*const*/ MemRegion /*P*/ > /*P*/ )(ReferencedVars));
    
    BumpVector</*const*/ MemRegion /*P*/ > /*P*/ VecOriginal = ((/*static_cast*/BumpVector</*const*/ MemRegion /*P*/ > /*P*/ )(OriginalVars));
    
    return new BlockDataRegion.referenced_vars_iterator(Vec.end(), 
        VecOriginal.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 464,
   FQN="clang::ento::BlockDataRegion::dumpToStream", NM="_ZNK5clang4ento15BlockDataRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    $out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/"block_data{"), BC);
    os.$out(/*KEEP_STR*/"; ");
    for (BlockDataRegion.referenced_vars_iterator I = referenced_vars_begin(), 
        E = referenced_vars_end(); I.$noteq(E); I.$preInc())  {
      $out_raw_ostream_MemRegion$C$P($out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/$LPAREN), I.getCapturedRegion()).$out(/*KEEP_STR*/$COMMA), 
          I.getOriginalRegion()).$out(/*KEEP_STR*/") ");
    }
    os.$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 391,
   FQN="clang::ento::BlockDataRegion::Profile", NM="_ZNK5clang4ento15BlockDataRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento15BlockDataRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    BlockDataRegion.ProfileRegion(ID, BC, LC, BlockCount, getSuperRegion());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 379,
   FQN="clang::ento::BlockDataRegion::ProfileRegion", NM="_ZN5clang4ento15BlockDataRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS0_15BlockCodeRegionEPKNS_15LocationContextEjPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegion13ProfileRegionERN4llvm16FoldingSetNodeIDEPKNS0_15BlockCodeRegionEPKNS_15LocationContextEjPKNS0_9MemRegionE")
  //</editor-fold>
  public static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               /*const*/ BlockCodeRegion /*P*/ BC, 
               /*const*/ LocationContext /*P*/ LC, 
               /*uint*/int BlkCount, 
               /*const*/ MemRegion /*P*/ sReg) {
    ID.AddInteger_int(MemRegion.Kind.BlockDataRegionKind.getValue());
    ID.AddPointer(BC);
    ID.AddPointer(LC);
    ID.AddInteger_uint(BlkCount);
    ID.AddPointer(sReg);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 693,
   FQN="clang::ento::BlockDataRegion::classof", NM="_ZN5clang4ento15BlockDataRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.BlockDataRegionKind;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::LazyInitializeReferencedVars">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*carefully renamed $BC, because field BC is used as well*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1440,
   FQN="clang::ento::BlockDataRegion::LazyInitializeReferencedVars", NM="_ZN5clang4ento15BlockDataRegion28LazyInitializeReferencedVarsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegion28LazyInitializeReferencedVarsEv")
  //</editor-fold>
  private void LazyInitializeReferencedVars() {
    BumpVectorContext $BC = null;
    try {
      if ((ReferencedVars != null)) {
        return;
      }
      
      AnalysisDeclContext /*P*/ AC = getCodeRegion().getAnalysisDeclContext();
      final /*const*/ iterator_range</*const*/ VarDecl /*P*/ /*const*/> /*&*/ ReferencedBlockVars = AC.getReferencedBlockVars(BC.getDecl());
       int NumBlockVars = std.distance(((type$ptr</*const*/ VarDecl /*P*/ /*const*/ /*P*/>)ReferencedBlockVars.begin()), ((type$ptr</*const*/ VarDecl /*P*/ /*const*/ /*P*/>)ReferencedBlockVars.end()));
      if (NumBlockVars == 0) {
        // JAVA
        ReferencedVars = EMPTY$ReferencedVars;//(Object/*void P*/ )0x1;
        return;
      }
      
      final MemRegionManager /*&*/ MemMgr = $Deref(getMemRegionManager());
      final BumpPtrAllocatorImpl /*&*/ A = MemMgr.getAllocator();
      $BC/*J*/= new BumpVectorContext(A);
      BumpVectorContext final$BC = $BC;
      
      /*typedef BumpVector<const MemRegion *> VarVec*/
//      final class VarVec extends BumpVector</*const*/ MemRegion /*P*/ >{ };
      BumpVector</*const*/ MemRegion /*P*/ > /*P*/ BV = A.<BumpVector>Allocate$T(BumpVector.class);
      /*NEW_EXPR [System]*/BV = /*new (BV)*/ $new_uint_voidPtr(BV, (type$ptr<?> New$Mem)->{
          return new BumpVector</*const*/ MemRegion /*P*/ >(new BumpVector.TypeAllocator<MemRegion>(
                (int size)->{return new MemRegion[size];}), final$BC, NumBlockVars);
       });
      BumpVector</*const*/ MemRegion /*P*/ > /*P*/ BVOriginal = A.<BumpVector>Allocate$T(BumpVector.class);
      /*NEW_EXPR [System]*/BVOriginal = /*new (BVOriginal)*/ $new_uint_voidPtr(BVOriginal, (type$ptr<?> New$Mem)->{
          return new BumpVector</*const*/ MemRegion /*P*/ >(new BumpVector.TypeAllocator<MemRegion>(
                (int size)->{return new MemRegion[size];}), final$BC, NumBlockVars);
       });
      
      for (/*const*/ VarDecl /*P*/ VD : ReferencedBlockVars) {
        /*const*/ VarRegion /*P*/ VR = null;
        /*const*/ VarRegion /*P*/ OriginalVR = null;
        // JAVA unfold std.tie
//        std.tie(VR, OriginalVR).$assign(getCaptureRegions(VD));
        std.pairPtrPtr</*const*/ VarRegion /*P*/, /*const*/ VarRegion /*P*/> $tie = getCaptureRegions(VD);
        VR = $tie.first;
        OriginalVR = $tie.second;
        assert Native.$bool(VR);
        assert Native.$bool(OriginalVR);
        BV.push_back(VR, $BC);
        BVOriginal.push_back(OriginalVR, $BC);
      }
      
      ReferencedVars = BV;
      OriginalVars = BVOriginal;
    } finally {
      if ($BC != null) { $BC.$destroy(); }
    }
  }

  
  //===----------------------------------------------------------------------===//
  // BlockDataRegion
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::getCaptureRegions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1417,
   FQN="clang::ento::BlockDataRegion::getCaptureRegions", NM="_ZN5clang4ento15BlockDataRegion17getCaptureRegionsEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegion17getCaptureRegionsEPKNS_7VarDeclE")
  //</editor-fold>
  private std.pairPtrPtr</*const*/ VarRegion /*P*/ , /*const*/ VarRegion /*P*/ > getCaptureRegions(/*const*/ VarDecl /*P*/ VD) {
    final MemRegionManager /*&*/ MemMgr = $Deref(getMemRegionManager());
    /*const*/ VarRegion /*P*/ VR = null;
    /*const*/ VarRegion /*P*/ OriginalVR = null;
    if (!VD.hasAttr(BlocksAttr.class) && VD.hasLocalStorage()) {
      VR = MemMgr.getVarRegion(VD, this);
      OriginalVR = MemMgr.getVarRegion(VD, LC);
    } else {
      if ((LC != null)) {
        VR = MemMgr.getVarRegion(VD, LC);
        OriginalVR = VR;
      } else {
        VR = MemMgr.getVarRegion(VD, MemMgr.getUnknownRegion());
        OriginalVR = MemMgr.getVarRegion(VD, LC);
      }
    }
    return std.make_pair_Ptr_Ptr(VR, OriginalVR);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockDataRegion::~BlockDataRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 627,
   FQN="clang::ento::BlockDataRegion::~BlockDataRegion", NM="_ZN5clang4ento15BlockDataRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento15BlockDataRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  private static final Object EMPTY$ReferencedVars = new Integer(0x1);
  
  @Override public String toString() {
    return "" + "BC=" + BC // NOI18N
              + ", LC=" + "[LocationContext]" // NOI18N
              + ", BlockCount=" + BlockCount // NOI18N
              + ", ReferencedVars=" + ReferencedVars // NOI18N
              + ", OriginalVars=" + OriginalVars // NOI18N
              + super.toString(); // NOI18N
  }
}
