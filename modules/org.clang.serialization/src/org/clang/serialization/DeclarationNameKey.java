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

package org.clang.serialization;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.serialization.impl.SerializationStatics.ComputeHash;
import org.clank.support.Native.NativePOD;


/// \brief A key used when looking up entities by \ref DeclarationName.
///
/// Different \ref DeclarationNames are mapped to different keys, but the
/// same key can occasionally represent multiple names (for names that
/// contain types, in particular).
//<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1573,
 FQN="clang::serialization::DeclarationNameKey", NM="_ZN5clang13serialization18DeclarationNameKeyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization18DeclarationNameKeyE")
//</editor-fold>
public class DeclarationNameKey implements NativePOD<DeclarationNameKey> {
  // JAVA: typedef unsigned int NameKind;
  
  private /*uint*/int Kind;
  private Object/*uint64_t*/ Data;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::DeclarationNameKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1580,
   FQN="clang::serialization::DeclarationNameKey::DeclarationNameKey", NM="_ZN5clang13serialization18DeclarationNameKeyC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization18DeclarationNameKeyC1Ev")
  //</editor-fold>
  public DeclarationNameKey() {
    // : Kind(implicit NameKind()), Data(implicit uint64_t()) 
    //START JInit
    this.Kind = /*implicit-init*/((/*uint*/int)/*zero-init*/0);
    this.Data = /*implicit-init*/null;//((long/*uint64_t*/)/*zero-init*/0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::DeclarationNameKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 871,
   FQN="clang::serialization::DeclarationNameKey::DeclarationNameKey", NM="_ZN5clang13serialization18DeclarationNameKeyC1ENS_15DeclarationNameE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization18DeclarationNameKeyC1ENS_15DeclarationNameE")
  //</editor-fold>
  public DeclarationNameKey(DeclarationName Name) {
    // : Kind(Name.getNameKind()) 
    //START JInit
    this.Kind = Name.getNameKind().getValue();
    //END JInit
    switch (DeclarationName.NameKind.valueOf(Kind)) {
     case Identifier:
      Data = Name.getAsIdentifierInfo();
      break;
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      Data = Name.getObjCSelector().getAsOpaquePtr();
      break;
     case CXXOperatorName:
      Data = Integer.valueOf(Name.getCXXOverloadedOperator().getValue());
      break;
     case CXXLiteralOperatorName:
      Data = Name.getCXXLiteralIdentifier();
      break;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
     case CXXUsingDirective:
      Data = null;
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::DeclarationNameKey">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1583,
   FQN="clang::serialization::DeclarationNameKey::DeclarationNameKey", NM="_ZN5clang13serialization18DeclarationNameKeyC1Ejy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization18DeclarationNameKeyC1Ejy")
  //</editor-fold>
  public DeclarationNameKey(/*uint*/int Kind, Object/*uint64_t*/ Data) {
    // : Kind(Kind), Data(Data) 
    //START JInit
    this.Kind = Kind;
    this.Data = Data;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1586,
   FQN="clang::serialization::DeclarationNameKey::getKind", NM="_ZNK5clang13serialization18DeclarationNameKey7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization18DeclarationNameKey7getKindEv")
  //</editor-fold>
  public /*uint*/int getKind() /*const*/ {
    return Kind;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::getIdentifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1588,
   FQN="clang::serialization::DeclarationNameKey::getIdentifier", NM="_ZNK5clang13serialization18DeclarationNameKey13getIdentifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization18DeclarationNameKey13getIdentifierEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getIdentifier() /*const*/ {
    assert (Kind == DeclarationName.NameKind.Identifier.getValue() || Kind == DeclarationName.NameKind.CXXLiteralOperatorName.getValue());
    return (IdentifierInfo /*P*/ )Data;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::getSelector">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1593,
   FQN="clang::serialization::DeclarationNameKey::getSelector", NM="_ZNK5clang13serialization18DeclarationNameKey11getSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization18DeclarationNameKey11getSelectorEv")
  //</editor-fold>
  public Selector getSelector() /*const*/ {
    assert (Kind == DeclarationName.NameKind.ObjCZeroArgSelector.getValue() || Kind == DeclarationName.NameKind.ObjCOneArgSelector.getValue() || Kind == DeclarationName.NameKind.ObjCMultiArgSelector.getValue());
    return new Selector(Data);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::getOperatorKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1599,
   FQN="clang::serialization::DeclarationNameKey::getOperatorKind", NM="_ZNK5clang13serialization18DeclarationNameKey15getOperatorKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization18DeclarationNameKey15getOperatorKindEv")
  //</editor-fold>
  public OverloadedOperatorKind getOperatorKind() /*const*/ {
    assert (Kind == DeclarationName.NameKind.CXXOperatorName.getValue());
    return OverloadedOperatorKind.valueOf((Integer)Data);
  }

  
  /// Compute a fingerprint of this key for use in on-disk hash table.
  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::getHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp", line = 897,
   FQN="clang::serialization::DeclarationNameKey::getHash", NM="_ZNK5clang13serialization18DeclarationNameKey7getHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang13serialization18DeclarationNameKey7getHashEv")
  //</editor-fold>
  public /*uint*/int getHash() /*const*/ {
    FoldingSetNodeID ID/*J*/= new FoldingSetNodeID();
    ID.AddInteger_uint(Kind);
    switch (DeclarationName.NameKind.valueOf(Kind)) {
     case Identifier:
     case CXXLiteralOperatorName:
      ID.AddString(((IdentifierInfo /*P*/ )Data).getName());
      break;
     case ObjCZeroArgSelector:
     case ObjCOneArgSelector:
     case ObjCMultiArgSelector:
      ID.AddInteger_uint(ComputeHash(new Selector(Data)));
      break;
     case CXXOperatorName:
      ID.AddInteger_uint(OverloadedOperatorKind.valueOf((Integer)Data).getValue());
      break;
     case CXXConstructorName:
     case CXXDestructorName:
     case CXXConversionFunctionName:
     case CXXUsingDirective:
      break;
    }
    
    return ID.ComputeHash();
  }

  
  /*friend*///<editor-fold defaultstate="collapsed" desc="clang::serialization::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1607,
   FQN="clang::serialization::operator==", NM="_ZN5clang13serializationeqERKNS0_18DeclarationNameKeyES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serializationeqERKNS0_18DeclarationNameKeyES3_")
  //</editor-fold>
  public static boolean $eq_DeclarationNameKey$C(final /*const*/ DeclarationNameKey /*&*/ A, 
                          final /*const*/ DeclarationNameKey /*&*/ B) {
    if (A.Kind != B.Kind) {
      return false;
    }
    assert (A.Data == null) || (B.Data == null) || (A.Data.getClass() == B.Data.getClass()) :
            "Same kinds must have same Data classes " + NativeTrace.getIdentityStr(A.Data) + 
            " vs. " + NativeTrace.getIdentityStr(B.Data);
    return Native.$eq(A.Data, B.Data, true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::DeclarationNameKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1573,
   FQN="clang::serialization::DeclarationNameKey::DeclarationNameKey", NM="_ZN5clang13serialization18DeclarationNameKeyC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization18DeclarationNameKeyC1ERKS1_")
  //</editor-fold>
  public /*inline*/ DeclarationNameKey(final /*const*/ DeclarationNameKey /*&*/ $Prm0) {
    // : Kind(.Kind), Data(.Data) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Data = $Prm0.Data;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::DeclarationNameKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1573,
   FQN="clang::serialization::DeclarationNameKey::DeclarationNameKey", NM="_ZN5clang13serialization18DeclarationNameKeyC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization18DeclarationNameKeyC1EOS1_")
  //</editor-fold>
  public /*inline*/ DeclarationNameKey(JD$Move _dparam, final DeclarationNameKey /*&&*/$Prm0) {
    // : Kind(static_cast<DeclarationNameKey &&>().Kind), Data(static_cast<DeclarationNameKey &&>().Data) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Data = $Prm0.Data;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1573,
   FQN="clang::serialization::DeclarationNameKey::operator=", NM="_ZN5clang13serialization18DeclarationNameKeyaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization18DeclarationNameKeyaSERKS1_")
  //</editor-fold>
  public /*inline*/ DeclarationNameKey /*&*/ $assign(final /*const*/ DeclarationNameKey /*&*/ $Prm0) {
    this.Kind = $Prm0.Kind;
    this.Data = $Prm0.Data;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclarationNameKey::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1573,
   FQN="clang::serialization::DeclarationNameKey::operator=", NM="_ZN5clang13serialization18DeclarationNameKeyaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang13serialization18DeclarationNameKeyaSEOS1_")
  //</editor-fold>
  public /*inline*/ DeclarationNameKey /*&*/ $assignMove(final DeclarationNameKey /*&&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.Data = $Prm0.Data;
    return /*Deref*/this;
  }

  @Override public DeclarationNameKey clone() {
    return new DeclarationNameKey(this);
  }

  @Override  public boolean $eq(DeclarationNameKey other) {
    return $eq_DeclarationNameKey$C(this, other);
  }
  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Data=" + Data; // NOI18N
  }
}
