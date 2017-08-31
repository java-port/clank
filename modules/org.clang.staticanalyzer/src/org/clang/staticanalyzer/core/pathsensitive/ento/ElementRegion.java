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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.pathsensitive.llvm.StaticanalyzerLlvmGlobals.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.CharUnitsGlobals.$star_long_CharUnits$C;


/// \brief ElementRegin is used to represent both array elements and casts.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1004,
 FQN="clang::ento::ElementRegion", NM="_ZN5clang4ento13ElementRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13ElementRegionE")
//</editor-fold>
public class ElementRegion extends /*public*/ TypedValueRegion implements Destructors.ClassWithDestructor {
  /*friend  class MemRegionManager*/
  
  private QualType ElementType;
  private NonLoc Index;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::ElementRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1010,
   FQN="clang::ento::ElementRegion::ElementRegion", NM="_ZN5clang4ento13ElementRegionC1ENS_8QualTypeENS0_6NonLocEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13ElementRegionC1ENS_8QualTypeENS0_6NonLocEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ ElementRegion(QualType elementType, NonLoc Idx, /*const*/ MemRegion /*P*/ sReg) {
    // : TypedValueRegion(sReg, ElementRegionKind), ElementType(elementType), Index(Idx) 
    //START JInit
    super(sReg, Kind.ElementRegionKind);
    this.ElementType = new QualType(elementType);
    this.Index = new NonLoc(Idx);
    //END JInit
    assert ((!Idx.getAs(NsNonloc.ConcreteInt.class).$bool() || Idx.castAs(NsNonloc.ConcreteInt.class).getValue().isSigned())) : "The index must be signed";
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::ProfileRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 343,
   FQN="clang::ento::ElementRegion::ProfileRegion", NM="_ZN5clang4ento13ElementRegion13ProfileRegionERN4llvm16FoldingSetNodeIDENS_8QualTypeENS0_4SValEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13ElementRegion13ProfileRegionERN4llvm16FoldingSetNodeIDENS_8QualTypeENS0_4SValEPKNS0_9MemRegionE")
  //</editor-fold>
  /*friend*/public/*private*/ static void ProfileRegion(final FoldingSetNodeID /*&*/ ID, 
               QualType ElementType, SVal Idx, 
               /*const*/ MemRegion /*P*/ superRegion) {
    ID.AddInteger_int(MemRegion.Kind.ElementRegionKind.getValue());
    ID.Add(ElementType);
    ID.AddPointer(superRegion);
    Idx.Profile(ID);
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::getIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1023,
   FQN="clang::ento::ElementRegion::getIndex", NM="_ZNK5clang4ento13ElementRegion8getIndexEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13ElementRegion8getIndexEv")
  //</editor-fold>
  public NonLoc getIndex() /*const*/ {
    return new NonLoc(Index);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1025,
   FQN="clang::ento::ElementRegion::getValueType", NM="_ZNK5clang4ento13ElementRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13ElementRegion12getValueTypeEv")
  //</editor-fold>
  @Override public QualType getValueType() /*const*//* override*/ {
    return new QualType(ElementType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::getElementType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1029,
   FQN="clang::ento::ElementRegion::getElementType", NM="_ZNK5clang4ento13ElementRegion14getElementTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13ElementRegion14getElementTypeEv")
  //</editor-fold>
  public QualType getElementType() /*const*/ {
    return new QualType(ElementType);
  }

  /// Compute the offset within the array. The array might also be a subobject.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::getAsArrayOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 1188,
   FQN="clang::ento::ElementRegion::getAsArrayOffset", NM="_ZNK5clang4ento13ElementRegion16getAsArrayOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13ElementRegion16getAsArrayOffsetEv")
  //</editor-fold>
  public RegionRawOffset getAsArrayOffset() /*const*/ {
    CharUnits offset = CharUnits.Zero();
    /*const*/ ElementRegion /*P*/ ER = this;
    /*const*/ MemRegion /*P*/ superR = null;
    final ASTContext /*&*/ C = getContext();
    
    // FIXME: Handle multi-dimensional arrays.
    while ((ER != null)) {
      superR = ER.getSuperRegion();
      
      // FIXME: generalize to symbolic offsets.
      SVal index = new SVal(JD$Move.INSTANCE, ER.getIndex());
      {
        Optional<NsNonloc.ConcreteInt> CI = index.getAs(NsNonloc.ConcreteInt.class);
        if (CI.$bool()) {
          // Update the offset.
          long/*int64_t*/ i = CI.$arrow().getValue().getSExtValue();
          if (i != 0) {
            QualType elemType = ER.getElementType();
            
            // If we are pointing to an incomplete type, go no further.
            if (elemType.$arrow().isIncompleteType()) {
              superR = ER;
              break;
            }
            
            CharUnits size = C.getTypeSizeInChars(/*NO_COPY*/elemType);
            offset.$addassign(($star_long_CharUnits$C(i, size)));
          }
          
          // Go to the next ElementRegion (if any).
          ER = dyn_cast_ElementRegion(superR);
          continue;
        }
      }
      
      return new RegionRawOffset((/*const*/ MemRegion /*P*/ )null);
    }
    assert ((superR != null)) : "super region cannot be NULL";
    return new RegionRawOffset(superR, new CharUnits(offset));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::dumpToStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 493,
   FQN="clang::ento::ElementRegion::dumpToStream", NM="_ZNK5clang4ento13ElementRegion12dumpToStreamERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13ElementRegion12dumpToStreamERN4llvm11raw_ostreamE")
  //</editor-fold>
  @Override public void dumpToStream(final raw_ostream /*&*/ os) /*const*//* override*/ {
    $out_raw_ostream_SVal($out_raw_ostream_MemRegion$C$P(os.$out(/*KEEP_STR*/"element{"), superRegion).$out_char($$COMMA), 
        /*NO_COPY*/Index).$out_char($$COMMA).$out(getElementType().getAsString()).$out_char($$RCURLY);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 352,
   FQN="clang::ento::ElementRegion::Profile", NM="_ZNK5clang4ento13ElementRegion7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento13ElementRegion7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    ElementRegion.ProfileRegion(ID, new QualType(ElementType), new SVal(Index), superRegion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1039,
   FQN="clang::ento::ElementRegion::classof", NM="_ZN5clang4ento13ElementRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13ElementRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    return R.getKind() == Kind.ElementRegionKind;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ElementRegion::~ElementRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 1004,
   FQN="clang::ento::ElementRegion::~ElementRegion", NM="_ZN5clang4ento13ElementRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento13ElementRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ElementType=" + ElementType // NOI18N
              + ", Index=" + Index // NOI18N
              + super.toString(); // NOI18N
  }
}
