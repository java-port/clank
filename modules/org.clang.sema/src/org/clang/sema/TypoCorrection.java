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

package org.clang.sema;

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.AstClangGlobals.$out_raw_ostream_DeclarationName;


/// @brief Simple class containing the result of Sema::CorrectTypo
//<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 26,
 FQN="clang::TypoCorrection", NM="_ZN5clang14TypoCorrectionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionE")
//</editor-fold>
public class TypoCorrection implements Iterable<NamedDecl>, NativeCloneable<TypoCorrection>, NativeMoveable<TypoCorrection>, Destructors.ClassWithDestructor, Native.Native$Bool {
/*public:*/
  // "Distance" for unusable corrections
  public static /*const*//*uint*/int InvalidDistance = ~0/*U*/;
  // The largest distance still considered valid (larger edit distances are
  // mapped to InvalidDistance by getEditDistance).
  public static /*const*//*uint*/int MaximumDistance = 10000/*U*/;
  
  // Relative weightings of the "edit distance" components. The higher the
  // weight, the more of a penalty to fitness the component will give (higher
  // weights mean greater contribution to the total edit distance, with the
  // best correction candidates having the lowest edit distance).
  public static /*const*//*uint*/int CharDistanceWeight = 100/*U*/;
  public static /*const*//*uint*/int QualifierDistanceWeight = 110/*U*/;
  public static /*const*//*uint*/int CallbackDistanceWeight = 150/*U*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::TypoCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 42,
   FQN="clang::TypoCorrection::TypoCorrection", NM="_ZN5clang14TypoCorrectionC1ERKNS_15DeclarationNameEPNS_9NamedDeclEPNS_19NestedNameSpecifierEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionC1ERKNS_15DeclarationNameEPNS_9NamedDeclEPNS_19NestedNameSpecifierEjj")
  //</editor-fold>
  public TypoCorrection(final /*const*/ DeclarationName /*&*/ Name, NamedDecl /*P*/ NameDecl) {
    this(Name, NameDecl, 
      (NestedNameSpecifier /*P*/ )null, 0, 
      0);
  }
  public TypoCorrection(final /*const*/ DeclarationName /*&*/ Name, NamedDecl /*P*/ NameDecl, 
      NestedNameSpecifier /*P*/ NNS/*= null*/) {
    this(Name, NameDecl, 
      NNS, 0, 
      0);
  }
  public TypoCorrection(final /*const*/ DeclarationName /*&*/ Name, NamedDecl /*P*/ NameDecl, 
      NestedNameSpecifier /*P*/ NNS/*= null*/, /*uint*/int CharDistance/*= 0*/) {
    this(Name, NameDecl, 
      NNS, CharDistance, 
      0);
  }
  public TypoCorrection(final /*const*/ DeclarationName /*&*/ Name, NamedDecl /*P*/ NameDecl, 
      NestedNameSpecifier /*P*/ NNS/*= null*/, /*uint*/int CharDistance/*= 0*/, 
      /*uint*/int QualifierDistance/*= 0*/) {
    // : CorrectionName(Name), CorrectionNameSpec(NNS), CorrectionDecls(), CharDistance(CharDistance), QualifierDistance(QualifierDistance), CallbackDistance(0), CorrectionRange(), ForceSpecifierReplacement(false), RequiresImport(false) 
    //START JInit
    this.CorrectionName = new DeclarationName(Name);
    this.CorrectionNameSpec = NNS;
    this.CorrectionDecls = new SmallVector<NamedDecl /*P*/ >(1, (NamedDecl /*P*/ )null);
    this.CharDistance = CharDistance;
    this.QualifierDistance = QualifierDistance;
    this.CallbackDistance = 0;
    this.CorrectionRange = new SourceRange();
    this.ForceSpecifierReplacement = false;
    this.RequiresImport = false;
    //END JInit
    if ((NameDecl != null)) {
      CorrectionDecls.push_back(NameDecl);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::TypoCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 53,
   FQN="clang::TypoCorrection::TypoCorrection", NM="_ZN5clang14TypoCorrectionC1EPNS_9NamedDeclEPNS_19NestedNameSpecifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionC1EPNS_9NamedDeclEPNS_19NestedNameSpecifierEj")
  //</editor-fold>
  public TypoCorrection(NamedDecl /*P*/ Name) {
    this(Name, (NestedNameSpecifier /*P*/ )null, 
      0);
  }
  public TypoCorrection(NamedDecl /*P*/ Name, NestedNameSpecifier /*P*/ NNS/*= null*/) {
    this(Name, NNS, 
      0);
  }
  public TypoCorrection(NamedDecl /*P*/ Name, NestedNameSpecifier /*P*/ NNS/*= null*/, 
      /*uint*/int CharDistance/*= 0*/) {
    // : CorrectionName(Name->getDeclName()), CorrectionNameSpec(NNS), CorrectionDecls(), CharDistance(CharDistance), QualifierDistance(0), CallbackDistance(0), CorrectionRange(), ForceSpecifierReplacement(false), RequiresImport(false) 
    //START JInit
    this.CorrectionName = Name.getDeclName();
    this.CorrectionNameSpec = NNS;
    this.CorrectionDecls = new SmallVector<NamedDecl /*P*/ >(1, (NamedDecl /*P*/ )null);
    this.CharDistance = CharDistance;
    this.QualifierDistance = 0;
    this.CallbackDistance = 0;
    this.CorrectionRange = new SourceRange();
    this.ForceSpecifierReplacement = false;
    this.RequiresImport = false;
    //END JInit
    if ((Name != null)) {
      CorrectionDecls.push_back(Name);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::TypoCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 62,
   FQN="clang::TypoCorrection::TypoCorrection", NM="_ZN5clang14TypoCorrectionC1ENS_15DeclarationNameEPNS_19NestedNameSpecifierEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionC1ENS_15DeclarationNameEPNS_19NestedNameSpecifierEj")
  //</editor-fold>
  public TypoCorrection(DeclarationName Name) {
    this(Name, (NestedNameSpecifier /*P*/ )null, 
      0);
  }
  public TypoCorrection(DeclarationName Name, NestedNameSpecifier /*P*/ NNS/*= null*/) {
    this(Name, NNS, 
      0);
  }
  public TypoCorrection(DeclarationName Name, NestedNameSpecifier /*P*/ NNS/*= null*/, 
      /*uint*/int CharDistance/*= 0*/) {
    // : CorrectionName(Name), CorrectionNameSpec(NNS), CorrectionDecls(), CharDistance(CharDistance), QualifierDistance(0), CallbackDistance(0), CorrectionRange(), ForceSpecifierReplacement(false), RequiresImport(false) 
    //START JInit
    this.CorrectionName = new DeclarationName(Name);
    this.CorrectionNameSpec = NNS;
    this.CorrectionDecls = new SmallVector<NamedDecl /*P*/ >(1, (NamedDecl /*P*/ )null);
    this.CharDistance = CharDistance;
    this.QualifierDistance = 0;
    this.CallbackDistance = 0;
    this.CorrectionRange = new SourceRange();
    this.ForceSpecifierReplacement = false;
    this.RequiresImport = false;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::TypoCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 68,
   FQN="clang::TypoCorrection::TypoCorrection", NM="_ZN5clang14TypoCorrectionC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionC1Ev")
  //</editor-fold>
  public TypoCorrection() {
    // : CorrectionName(), CorrectionNameSpec(null), CorrectionDecls(), CharDistance(0), QualifierDistance(0), CallbackDistance(0), CorrectionRange(), ForceSpecifierReplacement(false), RequiresImport(false) 
    //START JInit
    this.CorrectionName = new DeclarationName();
    this.CorrectionNameSpec = null;
    this.CorrectionDecls = new SmallVector<NamedDecl /*P*/ >(1, (NamedDecl /*P*/ )null);
    this.CharDistance = 0;
    this.QualifierDistance = 0;
    this.CallbackDistance = 0;
    this.CorrectionRange = new SourceRange();
    this.ForceSpecifierReplacement = false;
    this.RequiresImport = false;
    //END JInit
  }

  
  /// \brief Gets the DeclarationName of the typo correction
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 74,
   FQN="clang::TypoCorrection::getCorrection", NM="_ZNK5clang14TypoCorrection13getCorrectionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection13getCorrectionEv")
  //</editor-fold>
  public DeclarationName getCorrection() /*const*/ {
    return new DeclarationName(CorrectionName);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getCorrectionAsIdentifierInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 75,
   FQN="clang::TypoCorrection::getCorrectionAsIdentifierInfo", NM="_ZNK5clang14TypoCorrection29getCorrectionAsIdentifierInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection29getCorrectionAsIdentifierInfoEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getCorrectionAsIdentifierInfo() /*const*/ {
    return CorrectionName.getAsIdentifierInfo();
  }

  
  /// \brief Gets the NestedNameSpecifier needed to use the typo correction
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getCorrectionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 80,
   FQN="clang::TypoCorrection::getCorrectionSpecifier", NM="_ZNK5clang14TypoCorrection22getCorrectionSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection22getCorrectionSpecifierEv")
  //</editor-fold>
  public NestedNameSpecifier /*P*/ getCorrectionSpecifier() /*const*/ {
    return CorrectionNameSpec;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::setCorrectionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 83,
   FQN="clang::TypoCorrection::setCorrectionSpecifier", NM="_ZN5clang14TypoCorrection22setCorrectionSpecifierEPNS_19NestedNameSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection22setCorrectionSpecifierEPNS_19NestedNameSpecifierE")
  //</editor-fold>
  public void setCorrectionSpecifier(NestedNameSpecifier /*P*/ NNS) {
    CorrectionNameSpec = NNS;
    ForceSpecifierReplacement = (NNS != null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::WillReplaceSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 88,
   FQN="clang::TypoCorrection::WillReplaceSpecifier", NM="_ZN5clang14TypoCorrection20WillReplaceSpecifierEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection20WillReplaceSpecifierEb")
  //</editor-fold>
  public void WillReplaceSpecifier(boolean ForceReplacement) {
    ForceSpecifierReplacement = ForceReplacement;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::WillReplaceSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 92,
   FQN="clang::TypoCorrection::WillReplaceSpecifier", NM="_ZNK5clang14TypoCorrection20WillReplaceSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection20WillReplaceSpecifierEv")
  //</editor-fold>
  public boolean WillReplaceSpecifier() /*const*/ {
    return ForceSpecifierReplacement;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::setQualifierDistance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 96,
   FQN="clang::TypoCorrection::setQualifierDistance", NM="_ZN5clang14TypoCorrection20setQualifierDistanceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection20setQualifierDistanceEj")
  //</editor-fold>
  public void setQualifierDistance(/*uint*/int ED) {
    QualifierDistance = ED;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::setCallbackDistance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 100,
   FQN="clang::TypoCorrection::setCallbackDistance", NM="_ZN5clang14TypoCorrection19setCallbackDistanceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection19setCallbackDistanceEj")
  //</editor-fold>
  public void setCallbackDistance(/*uint*/int ED) {
    CallbackDistance = ED;
  }

  
  // Convert the given weighted edit distance to a roughly equivalent number of
  // single-character edits (typically for comparison to the length of the
  // string being edited).
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::NormalizeEditDistance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 107,
   FQN="clang::TypoCorrection::NormalizeEditDistance", NM="_ZN5clang14TypoCorrection21NormalizeEditDistanceEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection21NormalizeEditDistanceEj")
  //</editor-fold>
  public static /*uint*/int NormalizeEditDistance(/*uint*/int ED) {
    if ($greater_uint(ED, MaximumDistance)) {
      return InvalidDistance;
    }
    return $div_uint((ED + $div_uint(CharDistanceWeight, 2)), CharDistanceWeight);
  }

  
  /// \brief Gets the "edit distance" of the typo correction from the typo.
  /// If Normalized is true, scale the distance down by the CharDistanceWeight
  /// to return the edit distance in terms of single-character edits.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getEditDistance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 116,
   FQN="clang::TypoCorrection::getEditDistance", NM="_ZNK5clang14TypoCorrection15getEditDistanceEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection15getEditDistanceEb")
  //</editor-fold>
  public /*uint*/int getEditDistance() /*const*/ {
    return getEditDistance(true);
  }
  public /*uint*/int getEditDistance(boolean Normalized/*= true*/) /*const*/ {
    if ($greater_uint(CharDistance, MaximumDistance) || $greater_uint(QualifierDistance, MaximumDistance)
       || $greater_uint(CallbackDistance, MaximumDistance)) {
      return InvalidDistance;
    }
    /*uint*/int ED = CharDistance * CharDistanceWeight
       + QualifierDistance * QualifierDistanceWeight
       + CallbackDistance * CallbackDistanceWeight;
    if ($greater_uint(ED, MaximumDistance)) {
      return InvalidDistance;
    }
    // Half the CharDistanceWeight is added to ED to simulate rounding since
    // integer division truncates the value (i.e. round-to-nearest-int instead
    // of round-to-zero).
    return Normalized ? NormalizeEditDistance(ED) : ED;
  }

  
  /// \brief Get the correction declaration found by name lookup (before we
  /// looked through using shadow declarations and the like).
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getFoundDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 134,
   FQN="clang::TypoCorrection::getFoundDecl", NM="_ZNK5clang14TypoCorrection12getFoundDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection12getFoundDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getFoundDecl() /*const*/ {
    return hasCorrectionDecl() ? (CorrectionDecls.begin$Const()).$star() : null;
  }

  
  /// \brief Gets the pointer to the declaration of the typo correction
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getCorrectionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 139,
   FQN="clang::TypoCorrection::getCorrectionDecl", NM="_ZNK5clang14TypoCorrection17getCorrectionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection17getCorrectionDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getCorrectionDecl() /*const*/ {
    NamedDecl /*P*/ D = getFoundDecl();
    return (D != null) ? D.getUnderlyingDecl() : null;
  }

  /*template <class DeclClass> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getCorrectionDeclAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 144,
   FQN="clang::TypoCorrection::getCorrectionDeclAs", NM="Tpl__ZNK5clang14TypoCorrection19getCorrectionDeclAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=Tpl__ZNK5clang14TypoCorrection19getCorrectionDeclAsEv")
  //</editor-fold>
  public </*class*/ DeclClass> DeclClass /*P*/ getCorrectionDeclAs(Class<DeclClass> DeclClassClass) /*const*/ {
    return dyn_cast_or_null(DeclClassClass, getCorrectionDecl());
  }

  
  /// \brief Clears the list of NamedDecls.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::ClearCorrectionDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 149,
   FQN="clang::TypoCorrection::ClearCorrectionDecls", NM="_ZN5clang14TypoCorrection20ClearCorrectionDeclsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection20ClearCorrectionDeclsEv")
  //</editor-fold>
  public void ClearCorrectionDecls() {
    CorrectionDecls.clear();
  }

  
  /// \brief Clears the list of NamedDecls before adding the new one.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::setCorrectionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 154,
   FQN="clang::TypoCorrection::setCorrectionDecl", NM="_ZN5clang14TypoCorrection17setCorrectionDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection17setCorrectionDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void setCorrectionDecl(NamedDecl /*P*/ CDecl) {
    CorrectionDecls.clear();
    addCorrectionDecl(CDecl);
  }

  
  /// \brief Clears the list of NamedDecls and adds the given set.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::setCorrectionDecls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 160,
   FQN="clang::TypoCorrection::setCorrectionDecls", NM="_ZN5clang14TypoCorrection18setCorrectionDeclsEN4llvm8ArrayRefIPNS_9NamedDeclEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection18setCorrectionDeclsEN4llvm8ArrayRefIPNS_9NamedDeclEEE")
  //</editor-fold>
  public void setCorrectionDecls(ArrayRef<NamedDecl /*P*/ > Decls) {
    CorrectionDecls.clear();
    CorrectionDecls.insert$T$value_T(CorrectionDecls.begin(), Decls.begin(), Decls.end());
  }

  
  /// \brief Add the given NamedDecl to the list of NamedDecls that are the
  /// declarations associated with the DeclarationName of this TypoCorrection
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::addCorrectionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4810,
   FQN="clang::TypoCorrection::addCorrectionDecl", NM="_ZN5clang14TypoCorrection17addCorrectionDeclEPNS_9NamedDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection17addCorrectionDeclEPNS_9NamedDeclE")
  //</editor-fold>
  public void addCorrectionDecl(NamedDecl /*P*/ CDecl) {
    if (!(CDecl != null)) {
      return;
    }
    if (isKeyword()) {
      CorrectionDecls.clear();
    }
    
    CorrectionDecls.push_back(CDecl);
    if (!CorrectionName.$bool()) {
      CorrectionName.$assignMove(CDecl.getDeclName());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getAsString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp", line = 4822,
   FQN="clang::TypoCorrection::getAsString", NM="_ZNK5clang14TypoCorrection11getAsStringERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection11getAsStringERKNS_11LangOptionsE")
  //</editor-fold>
  public std.string getAsString(final /*const*/ LangOptions /*&*/ LO) /*const*/ {
    if ((CorrectionNameSpec != null)) {
      raw_string_ostream PrefixOStream = null;
      try {
        std.string tmpBuffer/*J*/= new std.string();
        PrefixOStream/*J*/= new raw_string_ostream(tmpBuffer);
        CorrectionNameSpec.print(PrefixOStream, new PrintingPolicy(LO));
        $out_raw_ostream_DeclarationName(PrefixOStream, /*NO_COPY*/CorrectionName);
        return new std.string(PrefixOStream.str());
      } finally {
        if (PrefixOStream != null) { PrefixOStream.$destroy(); }
      }
    }
    
    return CorrectionName.getAsString();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getQuoted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 170,
   FQN="clang::TypoCorrection::getQuoted", NM="_ZNK5clang14TypoCorrection9getQuotedERKNS_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection9getQuotedERKNS_11LangOptionsE")
  //</editor-fold>
  public std.string getQuoted(final /*const*/ LangOptions /*&*/ LO) /*const*/ {
    return $add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/"'", getAsString(LO)), /*KEEP_STR*/"'");
  }

  
  /// \brief Returns whether this TypoCorrection has a non-empty DeclarationName
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::operator bool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 175,
   FQN="clang::TypoCorrection::operator bool", NM="_ZNK5clang14TypoCorrectioncvbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrectioncvbEv")
  //</editor-fold>
  public boolean $bool() /*const*/ {
    return ((boolean)(CorrectionName.$bool()));
  }

  
  /// \brief Mark this TypoCorrection as being a keyword.
  /// Since addCorrectionDeclsand setCorrectionDecl don't allow NULL to be
  /// added to the list of the correction's NamedDecl pointers, NULL is added
  /// as the only element in the list to mark this TypoCorrection as a keyword.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::makeKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 181,
   FQN="clang::TypoCorrection::makeKeyword", NM="_ZN5clang14TypoCorrection11makeKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection11makeKeywordEv")
  //</editor-fold>
  public void makeKeyword() {
    CorrectionDecls.clear();
    CorrectionDecls.push_back((NamedDecl /*P*/ /*const*/)null);
    ForceSpecifierReplacement = true;
  }

  
  // Check if this TypoCorrection is a keyword by checking if the first
  // item in CorrectionDecls is NULL.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::isKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 189,
   FQN="clang::TypoCorrection::isKeyword", NM="_ZNK5clang14TypoCorrection9isKeywordEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection9isKeywordEv")
  //</editor-fold>
  public boolean isKeyword() /*const*/ {
    return !CorrectionDecls.empty() && CorrectionDecls.front$Const() == null;
  }

  
  // Check if this TypoCorrection is the given keyword.
  /*template <std::size_t StrLen> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::isKeyword">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 195,
   FQN="clang::TypoCorrection::isKeyword", NM="Tpl__ZNK5clang14TypoCorrection9isKeywordERAT__Kc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=Tpl__ZNK5clang14TypoCorrection9isKeywordERAT__Kc")
  //</editor-fold>
  public /*<uint StrLen>*/ boolean isKeyword$T(final String Str) /*const*/ {
    return isKeyword() && getCorrectionAsIdentifierInfo().isStr(Str);
  }

  
  // Returns true if the correction either is a keyword or has a known decl.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::isResolved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 200,
   FQN="clang::TypoCorrection::isResolved", NM="_ZNK5clang14TypoCorrection10isResolvedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection10isResolvedEv")
  //</editor-fold>
  public boolean isResolved() /*const*/ {
    return !CorrectionDecls.empty();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::isOverloaded">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 202,
   FQN="clang::TypoCorrection::isOverloaded", NM="_ZNK5clang14TypoCorrection12isOverloadedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection12isOverloadedEv")
  //</editor-fold>
  public boolean isOverloaded() /*const*/ {
    return $greater_uint(CorrectionDecls.size(), 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::setCorrectionRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 206,
   FQN="clang::TypoCorrection::setCorrectionRange", NM="_ZN5clang14TypoCorrection18setCorrectionRangeEPNS_12CXXScopeSpecERKNS_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection18setCorrectionRangeEPNS_12CXXScopeSpecERKNS_19DeclarationNameInfoE")
  //</editor-fold>
  public void setCorrectionRange(CXXScopeSpec /*P*/ SS, 
                    final /*const*/ DeclarationNameInfo /*&*/ TypoName) {
    CorrectionRange.$assignMove(TypoName.getSourceRange());
    if (ForceSpecifierReplacement && (SS != null) && !SS.isEmpty()) {
      CorrectionRange.setBegin(SS.getBeginLoc());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::getCorrectionRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 213,
   FQN="clang::TypoCorrection::getCorrectionRange", NM="_ZNK5clang14TypoCorrection18getCorrectionRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection18getCorrectionRangeEv")
  //</editor-fold>
  public SourceRange getCorrectionRange() /*const*/ {
    return new SourceRange(CorrectionRange);
  }

   @Override
  public Iterator<NamedDecl> iterator() {
    return new JavaIterator<>(begin(), end());
  }
  
  /*typedef SmallVectorImpl<NamedDecl *>::iterator decl_iterator*/
//  public final class decl_iterator extends type$ptr<NamedDecl /*P*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 218,
   FQN="clang::TypoCorrection::begin", NM="_ZN5clang14TypoCorrection5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection5beginEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*P*/> begin() {
    return isKeyword() ? CorrectionDecls.end() : CorrectionDecls.begin();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 221,
   FQN="clang::TypoCorrection::end", NM="_ZN5clang14TypoCorrection3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection3endEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*P*/> end() {
    return CorrectionDecls.end();
  }

  /*typedef SmallVectorImpl<NamedDecl *>::const_iterator const_decl_iterator*/
//  public final class const_decl_iterator extends type$ptr<NamedDecl /*P*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 223,
   FQN="clang::TypoCorrection::begin", NM="_ZNK5clang14TypoCorrection5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection5beginEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*P*/> begin$Const() /*const*/ {
    return isKeyword() ? CorrectionDecls.end$Const() : CorrectionDecls.begin$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 226,
   FQN="clang::TypoCorrection::end", NM="_ZNK5clang14TypoCorrection3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection3endEv")
  //</editor-fold>
  public type$ptr<NamedDecl /*P*/ /*P*/> end$Const() /*const*/ {
    return CorrectionDecls.end$Const();
  }

  
  /// \brief Returns whether this typo correction is correcting to a
  /// declaration that was declared in a module that has not been imported.
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::requiresImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 230,
   FQN="clang::TypoCorrection::requiresImport", NM="_ZNK5clang14TypoCorrection14requiresImportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection14requiresImportEv")
  //</editor-fold>
  public boolean requiresImport() /*const*/ {
    return RequiresImport;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::setRequiresImport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 231,
   FQN="clang::TypoCorrection::setRequiresImport", NM="_ZN5clang14TypoCorrection17setRequiresImportEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrection17setRequiresImportEb")
  //</editor-fold>
  public void setRequiresImport(boolean Req) {
    RequiresImport = Req;
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::hasCorrectionDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 234,
   FQN="clang::TypoCorrection::hasCorrectionDecl", NM="_ZNK5clang14TypoCorrection17hasCorrectionDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZNK5clang14TypoCorrection17hasCorrectionDeclEv")
  //</editor-fold>
  private boolean hasCorrectionDecl() /*const*/ {
    return (!isKeyword() && !CorrectionDecls.empty());
  }

  
  // Results.
  private DeclarationName CorrectionName;
  private NestedNameSpecifier /*P*/ CorrectionNameSpec;
  private SmallVector<NamedDecl /*P*/ > CorrectionDecls;
  private /*uint*/int CharDistance;
  private /*uint*/int QualifierDistance;
  private /*uint*/int CallbackDistance;
  private SourceRange CorrectionRange;
  private boolean ForceSpecifierReplacement;
  private boolean RequiresImport;
  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::TypoCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 26,
   FQN="clang::TypoCorrection::TypoCorrection", NM="_ZN5clang14TypoCorrectionC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionC1EOS0_")
  //</editor-fold>
  public /*inline*/ TypoCorrection(JD$Move _dparam, final TypoCorrection /*&&*/$Prm0) {
    // : CorrectionName(static_cast<TypoCorrection &&>().CorrectionName), CorrectionNameSpec(static_cast<TypoCorrection &&>().CorrectionNameSpec), CorrectionDecls(static_cast<TypoCorrection &&>().CorrectionDecls), CharDistance(static_cast<TypoCorrection &&>().CharDistance), QualifierDistance(static_cast<TypoCorrection &&>().QualifierDistance), CallbackDistance(static_cast<TypoCorrection &&>().CallbackDistance), CorrectionRange(static_cast<TypoCorrection &&>().CorrectionRange), ForceSpecifierReplacement(static_cast<TypoCorrection &&>().ForceSpecifierReplacement), RequiresImport(static_cast<TypoCorrection &&>().RequiresImport) 
    //START JInit
    this.CorrectionName = new DeclarationName(JD$Move.INSTANCE, $Prm0.CorrectionName);
    this.CorrectionNameSpec = $Prm0.CorrectionNameSpec;
    this.CorrectionDecls = new SmallVector<NamedDecl /*P*/ >(JD$Move.INSTANCE, $Prm0.CorrectionDecls);
    this.CharDistance = $Prm0.CharDistance;
    this.QualifierDistance = $Prm0.QualifierDistance;
    this.CallbackDistance = $Prm0.CallbackDistance;
    this.CorrectionRange = new SourceRange(JD$Move.INSTANCE, $Prm0.CorrectionRange);
    this.ForceSpecifierReplacement = $Prm0.ForceSpecifierReplacement;
    this.RequiresImport = $Prm0.RequiresImport;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 26,
   FQN="clang::TypoCorrection::operator=", NM="_ZN5clang14TypoCorrectionaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionaSEOS0_")
  //</editor-fold>
  public /*inline*/ TypoCorrection /*&*/ $assignMove(final TypoCorrection /*&&*/$Prm0) {
    this.CorrectionName.$assignMove($Prm0.CorrectionName);
    this.CorrectionNameSpec = $Prm0.CorrectionNameSpec;
    this.CorrectionDecls.$assignMove($Prm0.CorrectionDecls);
    this.CharDistance = $Prm0.CharDistance;
    this.QualifierDistance = $Prm0.QualifierDistance;
    this.CallbackDistance = $Prm0.CallbackDistance;
    this.CorrectionRange.$assignMove($Prm0.CorrectionRange);
    this.ForceSpecifierReplacement = $Prm0.ForceSpecifierReplacement;
    this.RequiresImport = $Prm0.RequiresImport;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::TypoCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 26,
   FQN="clang::TypoCorrection::TypoCorrection", NM="_ZN5clang14TypoCorrectionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionC1ERKS0_")
  //</editor-fold>
  public /*inline*/ TypoCorrection(final /*const*/ TypoCorrection /*&*/ $Prm0) {
    // : CorrectionName(.CorrectionName), CorrectionNameSpec(.CorrectionNameSpec), CorrectionDecls(.CorrectionDecls), CharDistance(.CharDistance), QualifierDistance(.QualifierDistance), CallbackDistance(.CallbackDistance), CorrectionRange(.CorrectionRange), ForceSpecifierReplacement(.ForceSpecifierReplacement), RequiresImport(.RequiresImport) 
    //START JInit
    this.CorrectionName = new DeclarationName($Prm0.CorrectionName);
    this.CorrectionNameSpec = $Prm0.CorrectionNameSpec;
    this.CorrectionDecls = new SmallVector<NamedDecl /*P*/ >($Prm0.CorrectionDecls);
    this.CharDistance = $Prm0.CharDistance;
    this.QualifierDistance = $Prm0.QualifierDistance;
    this.CallbackDistance = $Prm0.CallbackDistance;
    this.CorrectionRange = new SourceRange($Prm0.CorrectionRange);
    this.ForceSpecifierReplacement = $Prm0.ForceSpecifierReplacement;
    this.RequiresImport = $Prm0.RequiresImport;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::~TypoCorrection">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 26,
   FQN="clang::TypoCorrection::~TypoCorrection", NM="_ZN5clang14TypoCorrectionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CorrectionDecls.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="clang::TypoCorrection::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/TypoCorrection.h", line = 26,
   FQN="clang::TypoCorrection::operator=", NM="_ZN5clang14TypoCorrectionaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLookup.cpp -nm=_ZN5clang14TypoCorrectionaSERKS0_")
  //</editor-fold>
  public /*inline*/ TypoCorrection /*&*/ $assign(final /*const*/ TypoCorrection /*&*/ $Prm0) {
    this.CorrectionName.$assign($Prm0.CorrectionName);
    this.CorrectionNameSpec = $Prm0.CorrectionNameSpec;
    this.CorrectionDecls.$assign($Prm0.CorrectionDecls);
    this.CharDistance = $Prm0.CharDistance;
    this.QualifierDistance = $Prm0.QualifierDistance;
    this.CallbackDistance = $Prm0.CallbackDistance;
    this.CorrectionRange.$assign($Prm0.CorrectionRange);
    this.ForceSpecifierReplacement = $Prm0.ForceSpecifierReplacement;
    this.RequiresImport = $Prm0.RequiresImport;
    return /*Deref*/this;
  }

  @Override public TypoCorrection clone() { 
    return new TypoCorrection(this); 
  }
  
  @Override public TypoCorrection move() { 
    return new TypoCorrection(JD$Move.INSTANCE, this); 
  }
  
  @Override public String toString() {
    return "" + "CorrectionName=" + CorrectionName // NOI18N
              + ", CorrectionNameSpec=" + CorrectionNameSpec // NOI18N
              + ", CorrectionDecls=" + CorrectionDecls // NOI18N
              + ", CharDistance=" + CharDistance // NOI18N
              + ", QualifierDistance=" + QualifierDistance // NOI18N
              + ", CallbackDistance=" + CallbackDistance // NOI18N
              + ", CorrectionRange=" + CorrectionRange // NOI18N
              + ", ForceSpecifierReplacement=" + ForceSpecifierReplacement // NOI18N
              + ", RequiresImport=" + RequiresImport; // NOI18N
  }
}
