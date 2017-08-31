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

package org.clang.ast;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


/// \brief Provides information a specialization of a member of a class
/// template, which may be a member function, static data member,
/// member class or member enumeration.
//<editor-fold defaultstate="collapsed" desc="clang::MemberSpecializationInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 500,
 FQN="clang::MemberSpecializationInfo", NM="_ZN5clang24MemberSpecializationInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24MemberSpecializationInfoE")
//</editor-fold>
public class MemberSpecializationInfo {
  // The member declaration from which this member was instantiated, and the
  // manner in which the instantiation occurred (in the lower two bits).
  private PointerIntPair<NamedDecl /*P*/ > MemberAndTSK;
  
  // The point at which this member was first instantiated.
  private SourceLocation PointOfInstantiation;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::MemberSpecializationInfo::MemberSpecializationInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 509,
   FQN="clang::MemberSpecializationInfo::MemberSpecializationInfo", NM="_ZN5clang24MemberSpecializationInfoC1EPNS_9NamedDeclENS_26TemplateSpecializationKindENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24MemberSpecializationInfoC1EPNS_9NamedDeclENS_26TemplateSpecializationKindENS_14SourceLocationE")
  //</editor-fold>
  public /*explicit*/ MemberSpecializationInfo(NamedDecl /*P*/ IF, TemplateSpecializationKind TSK) {
    this(IF, TSK, 
      new SourceLocation());
  }
  public /*explicit*/ MemberSpecializationInfo(NamedDecl /*P*/ IF, TemplateSpecializationKind TSK, 
      SourceLocation POI/*= SourceLocation()*/) {
    // : MemberAndTSK(IF, TSK - 1), PointOfInstantiation(POI) 
    //START JInit
    this.MemberAndTSK = new PointerIntPair<NamedDecl /*P*/ >(IF, TSK.getValue() - 1);
    this.PointOfInstantiation = new SourceLocation(POI);
    //END JInit
    assert (TSK != TemplateSpecializationKind.TSK_Undeclared) : "Cannot encode undeclared template specializations for members";
  }

  
  /// \brief Retrieve the member declaration from which this member was
  /// instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberSpecializationInfo::getInstantiatedFrom">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 519,
   FQN="clang::MemberSpecializationInfo::getInstantiatedFrom", NM="_ZNK5clang24MemberSpecializationInfo19getInstantiatedFromEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24MemberSpecializationInfo19getInstantiatedFromEv")
  //</editor-fold>
  public NamedDecl /*P*/ getInstantiatedFrom() /*const*/ {
    return MemberAndTSK.getPointer();
  }

  
  /// \brief Determine what kind of template specialization this is.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberSpecializationInfo::getTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 522,
   FQN="clang::MemberSpecializationInfo::getTemplateSpecializationKind", NM="_ZNK5clang24MemberSpecializationInfo29getTemplateSpecializationKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24MemberSpecializationInfo29getTemplateSpecializationKindEv")
  //</editor-fold>
  public TemplateSpecializationKind getTemplateSpecializationKind() /*const*/ {
    return TemplateSpecializationKind.valueOf((MemberAndTSK.getInt() + 1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MemberSpecializationInfo::isExplicitSpecialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 526,
   FQN="clang::MemberSpecializationInfo::isExplicitSpecialization", NM="_ZNK5clang24MemberSpecializationInfo24isExplicitSpecializationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24MemberSpecializationInfo24isExplicitSpecializationEv")
  //</editor-fold>
  public boolean isExplicitSpecialization() /*const*/ {
    return getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization;
  }

  
  /// \brief Set the template specialization kind.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberSpecializationInfo::setTemplateSpecializationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 531,
   FQN="clang::MemberSpecializationInfo::setTemplateSpecializationKind", NM="_ZN5clang24MemberSpecializationInfo29setTemplateSpecializationKindENS_26TemplateSpecializationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24MemberSpecializationInfo29setTemplateSpecializationKindENS_26TemplateSpecializationKindE")
  //</editor-fold>
  public void setTemplateSpecializationKind(TemplateSpecializationKind TSK) {
    assert (TSK != TemplateSpecializationKind.TSK_Undeclared) : "Cannot encode undeclared template specializations for members";
    MemberAndTSK.setInt(TSK.getValue() - 1);
  }

  
  /// \brief Retrieve the first point of instantiation of this member.
  /// If the point of instantiation is an invalid location, then this member
  /// has not yet been instantiated.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberSpecializationInfo::getPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 540,
   FQN="clang::MemberSpecializationInfo::getPointOfInstantiation", NM="_ZNK5clang24MemberSpecializationInfo23getPointOfInstantiationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZNK5clang24MemberSpecializationInfo23getPointOfInstantiationEv")
  //</editor-fold>
  public SourceLocation getPointOfInstantiation() /*const*/ {
    return new SourceLocation(PointOfInstantiation);
  }

  
  /// \brief Set the first point of instantiation.
  //<editor-fold defaultstate="collapsed" desc="clang::MemberSpecializationInfo::setPointOfInstantiation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclTemplate.h", line = 545,
   FQN="clang::MemberSpecializationInfo::setPointOfInstantiation", NM="_ZN5clang24MemberSpecializationInfo23setPointOfInstantiationENS_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang24MemberSpecializationInfo23setPointOfInstantiationENS_14SourceLocationE")
  //</editor-fold>
  public void setPointOfInstantiation(SourceLocation POI) {
    PointOfInstantiation.$assign(POI);
  }

  
  @Override public String toString() {
    return "" + "MemberAndTSK=" + MemberAndTSK // NOI18N
              + ", PointOfInstantiation=" + PointOfInstantiation; // NOI18N
  }
}
