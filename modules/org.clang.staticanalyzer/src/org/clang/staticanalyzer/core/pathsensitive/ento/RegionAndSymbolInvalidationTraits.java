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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


//===----------------------------------------------------------------------===//
// Means for storing region/symbol handling traits.
//===----------------------------------------------------------------------===//

/// Information about invalidation for a particular region/symbol.
//<editor-fold defaultstate="collapsed" desc="clang::ento::RegionAndSymbolInvalidationTraits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1316,
 FQN="clang::ento::RegionAndSymbolInvalidationTraits", NM="_ZN5clang4ento33RegionAndSymbolInvalidationTraitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento33RegionAndSymbolInvalidationTraitsE")
//</editor-fold>
public class RegionAndSymbolInvalidationTraits implements Destructors.ClassWithDestructor {
  /*typedef unsigned char StorageTypeForKinds*/;
  private DenseMapTypeUChar</*const*/ MemRegion /*P*/ > MRTraitsMap;
  private DenseMapTypeUChar</*const*/ SymExpr /*P*/ > SymTraitsMap;
  
  /*typedef llvm::DenseMap<const MemRegion *, StorageTypeForKinds>::const_iterator const_region_iterator*/
//  public final class const_region_iterator extends DenseMapIteratorTypeUChar</*const*/ MemRegion /*P*/ /*P*/>{ };
  /*typedef llvm::DenseMap<SymbolRef, StorageTypeForKinds>::const_iterator const_symbol_iterator*/
//  public final class const_symbol_iterator extends DenseMapIteratorTypeUChar</*const*/ SymExpr /*P*/ /*P*/>{ };
/*public:*/
  /// \brief Describes different invalidation traits.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionAndSymbolInvalidationTraits::InvalidationKinds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1328,
   FQN="clang::ento::RegionAndSymbolInvalidationTraits::InvalidationKinds", NM="_ZN5clang4ento33RegionAndSymbolInvalidationTraits17InvalidationKindsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento33RegionAndSymbolInvalidationTraits17InvalidationKindsE")
  //</editor-fold>
  public static final class/*enum*/ InvalidationKinds {
    /// Tells that a region's contents is not changed.
    public static final /*uint*/int TK_PreserveContents = 0x1;
    /// Suppress pointer-escaping of a region.
    public static final /*uint*/int TK_SuppressEscape = 0x2;
    // Do not invalidate super region.
    public static final /*uint*/int TK_DoNotInvalidateSuperRegion = 0x4;
    /// When applied to a MemSpaceRegion, indicates the entire memory space
    /// should be invalidated.
    public static final /*uint*/int TK_EntireMemSpace = 0x8;
    // Do not forget to extend StorageTypeForKinds if number of traits exceed 
    // the number of bits StorageTypeForKinds can store.
  };
  
  //===----------------------------------------------------------------------===//
  // RegionAndSymbolInvalidationTraits
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionAndSymbolInvalidationTraits::setTrait">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1526,
   FQN="clang::ento::RegionAndSymbolInvalidationTraits::setTrait", NM="_ZN5clang4ento33RegionAndSymbolInvalidationTraits8setTraitEPKNS0_7SymExprENS1_17InvalidationKindsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento33RegionAndSymbolInvalidationTraits8setTraitEPKNS0_7SymExprENS1_17InvalidationKindsE")
  //</editor-fold>
  public void setTrait(/*const*/ SymExpr /*P*/ Sym, 
          /*InvalidationKinds*//*uint*/int IK) {
    SymTraitsMap.$set(Sym, (byte)(SymTraitsMap.$at_T1$C$R(Sym) | IK));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionAndSymbolInvalidationTraits::setTrait">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1531,
   FQN="clang::ento::RegionAndSymbolInvalidationTraits::setTrait", NM="_ZN5clang4ento33RegionAndSymbolInvalidationTraits8setTraitEPKNS0_9MemRegionENS1_17InvalidationKindsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento33RegionAndSymbolInvalidationTraits8setTraitEPKNS0_9MemRegionENS1_17InvalidationKindsE")
  //</editor-fold>
  public void setTrait(/*const*/ MemRegion /*P*/ MR, 
          /*InvalidationKinds*//*uint*/int IK) {
    assert Native.$bool(MR);
    {
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(MR);
      if ((SR != null)) {
        setTrait(SR.getSymbol(), IK);
      } else {
        MRTraitsMap.$set(MR, (byte)(MRTraitsMap.$at_T1$C$R(MR) | IK));
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionAndSymbolInvalidationTraits::hasTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1540,
   FQN="clang::ento::RegionAndSymbolInvalidationTraits::hasTrait", NM="_ZNK5clang4ento33RegionAndSymbolInvalidationTraits8hasTraitEPKNS0_7SymExprENS1_17InvalidationKindsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento33RegionAndSymbolInvalidationTraits8hasTraitEPKNS0_7SymExprENS1_17InvalidationKindsE")
  //</editor-fold>
  public boolean hasTrait(/*const*/ SymExpr /*P*/ Sym, 
          /*InvalidationKinds*//*uint*/int IK) /*const*/ {
    DenseMapIteratorTypeUChar</*const*/ SymExpr /*P*/ /*P*/> I = SymTraitsMap.find$Const(Sym);
    if (I.$noteq(SymTraitsMap.end$Const())) {
      return (($uchar2int(I.$arrow().second) & IK) != 0);
    }
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionAndSymbolInvalidationTraits::hasTrait">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1549,
   FQN="clang::ento::RegionAndSymbolInvalidationTraits::hasTrait", NM="_ZNK5clang4ento33RegionAndSymbolInvalidationTraits8hasTraitEPKNS0_9MemRegionENS1_17InvalidationKindsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento33RegionAndSymbolInvalidationTraits8hasTraitEPKNS0_9MemRegionENS1_17InvalidationKindsE")
  //</editor-fold>
  public boolean hasTrait(/*const*/ MemRegion /*P*/ MR, 
          /*InvalidationKinds*//*uint*/int IK) /*const*/ {
    if (!(MR != null)) {
      return false;
    }
    {
      
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(MR);
      if ((SR != null)) {
        return hasTrait(SR.getSymbol(), IK);
      }
    }
    
    DenseMapIteratorTypeUChar</*const*/ MemRegion /*P*/ /*P*/> I = MRTraitsMap.find$Const(MR);
    if (I.$noteq(MRTraitsMap.end$Const())) {
      return (($uchar2int(I.$arrow().second) & IK) != 0);
    }
    
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionAndSymbolInvalidationTraits::~RegionAndSymbolInvalidationTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1316,
   FQN="clang::ento::RegionAndSymbolInvalidationTraits::~RegionAndSymbolInvalidationTraits", NM="_ZN5clang4ento33RegionAndSymbolInvalidationTraitsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento33RegionAndSymbolInvalidationTraitsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    SymTraitsMap.$destroy();
    MRTraitsMap.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::RegionAndSymbolInvalidationTraits::RegionAndSymbolInvalidationTraits">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1316,
   FQN="clang::ento::RegionAndSymbolInvalidationTraits::RegionAndSymbolInvalidationTraits", NM="_ZN5clang4ento33RegionAndSymbolInvalidationTraitsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento33RegionAndSymbolInvalidationTraitsC1Ev")
  //</editor-fold>
  public /*inline*/ RegionAndSymbolInvalidationTraits() {
    // : MRTraitsMap(), SymTraitsMap() 
    //START JInit
    this.MRTraitsMap = new DenseMapTypeUChar</*const*/ MemRegion /*P*/ >(DenseMapInfo$LikePtr.$Info(), (byte)0);
    this.SymTraitsMap = new DenseMapTypeUChar</*const*/ SymExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (byte)0);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "MRTraitsMap=" + MRTraitsMap // NOI18N
              + ", SymTraitsMap=" + SymTraitsMap; // NOI18N
  }
}
