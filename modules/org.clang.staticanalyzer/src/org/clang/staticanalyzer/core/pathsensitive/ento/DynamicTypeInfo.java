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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.QualType.*;


/// \brief Stores the currently inferred strictest bound on the runtime type
/// of a region in a given state along the analysis path.
//<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 19,
 FQN="clang::ento::DynamicTypeInfo", NM="_ZN5clang4ento15DynamicTypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento15DynamicTypeInfoE")
//</editor-fold>
public class DynamicTypeInfo implements Native.NativeComparable<DynamicTypeInfo>, FoldingSetTrait.Profilable, NativeCloneable<DynamicTypeInfo> {
/*private:*/
  private QualType T;
  private boolean CanBeASubClass;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::DynamicTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 26,
   FQN="clang::ento::DynamicTypeInfo::DynamicTypeInfo", NM="_ZN5clang4ento15DynamicTypeInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento15DynamicTypeInfoC1Ev")
  //</editor-fold>
  public DynamicTypeInfo() {
    // : T(QualType()) 
    //START JInit
    this.T = new QualType();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::DynamicTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 27,
   FQN="clang::ento::DynamicTypeInfo::DynamicTypeInfo", NM="_ZN5clang4ento15DynamicTypeInfoC1ENS_8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento15DynamicTypeInfoC1ENS_8QualTypeEb")
  //</editor-fold>
  public DynamicTypeInfo(QualType WithType) {
    this(WithType, true);
  }
  public DynamicTypeInfo(QualType WithType, boolean CanBeSub/*= true*/) {
    // : T(WithType), CanBeASubClass(CanBeSub) 
    //START JInit
    this.T = new QualType(WithType);
    this.CanBeASubClass = CanBeSub;
    //END JInit
  }

  
  /// \brief Return false if no dynamic type info is available.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 31,
   FQN="clang::ento::DynamicTypeInfo::isValid", NM="_ZNK5clang4ento15DynamicTypeInfo7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZNK5clang4ento15DynamicTypeInfo7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return !T.isNull();
  }

  
  /// \brief Returns the currently inferred upper bound on the runtime type.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 34,
   FQN="clang::ento::DynamicTypeInfo::getType", NM="_ZNK5clang4ento15DynamicTypeInfo7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZNK5clang4ento15DynamicTypeInfo7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return new QualType(T);
  }

  
  /// \brief Returns false if the type information is precise (the type T is
  /// the only type in the lattice), true otherwise.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::canBeASubClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 38,
   FQN="clang::ento::DynamicTypeInfo::canBeASubClass", NM="_ZNK5clang4ento15DynamicTypeInfo14canBeASubClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZNK5clang4ento15DynamicTypeInfo14canBeASubClassEv")
  //</editor-fold>
  public boolean canBeASubClass() /*const*/ {
    return CanBeASubClass;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 40,
   FQN="clang::ento::DynamicTypeInfo::Profile", NM="_ZNK5clang4ento15DynamicTypeInfo7ProfileERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZNK5clang4ento15DynamicTypeInfo7ProfileERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*/ {
    ID.Add(T);
    ID.AddInteger_uint((/*uint*/int)(CanBeASubClass ? 1 : 0));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 44,
   FQN="clang::ento::DynamicTypeInfo::operator==", NM="_ZNK5clang4ento15DynamicTypeInfoeqERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZNK5clang4ento15DynamicTypeInfoeqERKS1_")
  //</editor-fold>
  public boolean $eq(final /*const*/ DynamicTypeInfo /*&*/ X) /*const*/ {
    return $eq_QualType$C(T, X.T) && CanBeASubClass == X.CanBeASubClass;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::DynamicTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 19,
   FQN="clang::ento::DynamicTypeInfo::DynamicTypeInfo", NM="_ZN5clang4ento15DynamicTypeInfoC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento15DynamicTypeInfoC1ERKS1_")
  //</editor-fold>
  public /*inline*/ DynamicTypeInfo(final /*const*/ DynamicTypeInfo /*&*/ $Prm0) {
    // : T(.T), CanBeASubClass(.CanBeASubClass) 
    //START JInit
    this.T = new QualType($Prm0.T);
    this.CanBeASubClass = $Prm0.CanBeASubClass;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::DynamicTypeInfo::DynamicTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeInfo.h", line = 19,
   FQN="clang::ento::DynamicTypeInfo::DynamicTypeInfo", NM="_ZN5clang4ento15DynamicTypeInfoC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento15DynamicTypeInfoC1EOS1_")
  //</editor-fold>
  public /*inline*/ DynamicTypeInfo(JD$Move _dparam, final DynamicTypeInfo /*&&*/$Prm0) {
    // : T(static_cast<DynamicTypeInfo &&>().T), CanBeASubClass(static_cast<DynamicTypeInfo &&>().CanBeASubClass) 
    //START JInit
    this.T = new QualType(JD$Move.INSTANCE, $Prm0.T);
    this.CanBeASubClass = $Prm0.CanBeASubClass;
    //END JInit
  }

  @Override public DynamicTypeInfo clone() { return new DynamicTypeInfo(this); }
  
  @Override public String toString() {
    return "" + "T=" + T // NOI18N
              + ", CanBeASubClass=" + CanBeASubClass; // NOI18N
  }
}
