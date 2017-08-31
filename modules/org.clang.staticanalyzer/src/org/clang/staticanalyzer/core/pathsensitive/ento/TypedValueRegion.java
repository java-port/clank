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
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// TypedValueRegion - An abstract class representing regions having a typed value.
//<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 494,
 FQN="clang::ento::TypedValueRegion", NM="_ZN5clang4ento16TypedValueRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16TypedValueRegionE")
//</editor-fold>
public abstract class TypedValueRegion extends /*public*/ TypedRegion implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 429,
   FQN="clang::ento::TypedValueRegion::anchor", NM="_ZN5clang4ento16TypedValueRegion6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16TypedValueRegion6anchorEv")
  //</editor-fold>
  @Override public void anchor()/* override*/ {
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion::TypedValueRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 498,
   FQN="clang::ento::TypedValueRegion::TypedValueRegion", NM="_ZN5clang4ento16TypedValueRegionC1EPKNS0_9MemRegionENS2_4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16TypedValueRegionC1EPKNS0_9MemRegionENS2_4KindE")
  //</editor-fold>
  protected TypedValueRegion(/*const*/ MemRegion /*P*/ sReg, MemRegion.Kind k) {
    // : TypedRegion(sReg, k) 
    //START JInit
    super(sReg, k);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion::getValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 501,
   FQN="clang::ento::TypedValueRegion::getValueType", NM="_ZNK5clang4ento16TypedValueRegion12getValueTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16TypedValueRegion12getValueTypeEv")
  //</editor-fold>
  public abstract /*virtual*/ QualType getValueType() /*const*//* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion::getLocationType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 503,
   FQN="clang::ento::TypedValueRegion::getLocationType", NM="_ZNK5clang4ento16TypedValueRegion15getLocationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16TypedValueRegion15getLocationTypeEv")
  //</editor-fold>
  @Override public QualType getLocationType() /*const*//* override*/ {
    // FIXME: We can possibly optimize this later to cache this value.
    QualType T = getValueType();
    final ASTContext /*&*/ ctx = getContext();
    if ((T.$arrow().getAs(ObjCObjectType.class) != null)) {
      return ctx.getObjCObjectPointerType(new QualType(T));
    }
    return ctx.getPointerType(getValueType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion::getDesugaredValueType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 512,
   FQN="clang::ento::TypedValueRegion::getDesugaredValueType", NM="_ZNK5clang4ento16TypedValueRegion21getDesugaredValueTypeERNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16TypedValueRegion21getDesugaredValueTypeERNS_10ASTContextE")
  //</editor-fold>
  public QualType getDesugaredValueType(final ASTContext /*&*/ Context) /*const*/ {
    QualType T = getValueType();
    return (T.getTypePtrOrNull() != null) ? T.getDesugaredType(Context) : new QualType(T);
  }

  
  
  //===----------------------------------------------------------------------===//
  // Region extents.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion::getExtent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp", line = 179,
   FQN="clang::ento::TypedValueRegion::getExtent", NM="_ZNK5clang4ento16TypedValueRegion9getExtentERNS0_11SValBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZNK5clang4ento16TypedValueRegion9getExtentERNS0_11SValBuilderE")
  //</editor-fold>
  @Override public DefinedOrUnknownSVal getExtent(final SValBuilder /*&*/ svalBuilder) /*const*//* override*/ {
    final ASTContext /*&*/ Ctx = svalBuilder.getContext();
    QualType T = getDesugaredValueType(Ctx);
    if (isa_VariableArrayType(T)) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new NsNonloc.SymbolVal(svalBuilder.getSymbolManager().getExtentSymbol(this)));
    }
    if (T.$arrow().isIncompleteType()) {
      return new DefinedOrUnknownSVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    CharUnits size = Ctx.getTypeSizeInChars(/*NO_COPY*/T);
    QualType sizeTy = svalBuilder.getArrayIndexType();
    return new DefinedOrUnknownSVal(JD$Move.INSTANCE, svalBuilder.makeIntVal(size.getQuantity(), new QualType(sizeTy)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 519,
   FQN="clang::ento::TypedValueRegion::classof", NM="_ZN5clang4ento16TypedValueRegion7classofEPKNS0_9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16TypedValueRegion7classofEPKNS0_9MemRegionE")
  //</editor-fold>
  public static boolean classof(/*const*/ MemRegion /*P*/ R) {
    /*uint*/int k = R.getKind().getValue();
    return $greatereq_uint(k, Kind.BEGIN_TYPED_VALUE_REGIONS.getValue()) && $lesseq_uint(k, Kind.END_TYPED_VALUE_REGIONS.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::TypedValueRegion::~TypedValueRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/MemRegion.h", line = 494,
   FQN="clang::ento::TypedValueRegion::~TypedValueRegion", NM="_ZN5clang4ento16TypedValueRegionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/MemRegion.cpp -nm=_ZN5clang4ento16TypedValueRegionD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
