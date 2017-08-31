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

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;


/// \brief Holds a QualType and a TypeSourceInfo* that came out of a declarator
/// parsing.
///
/// LocInfoType is a "transient" type, only needed for passing to/from Parser
/// and Sema, when we want to preserve type source info for a parsed type.
/// It will not participate in the type system semantics in any way.
//<editor-fold defaultstate="collapsed" desc="clang::LocInfoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LocInfoType.h", line = 29,
 FQN="clang::LocInfoType", NM="_ZN5clang11LocInfoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang11LocInfoTypeE")
//</editor-fold>
public class LocInfoType extends /*public*/ Type {
  //<editor-fold defaultstate="collapsed" desc="clang::LocInfoType::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LocInfoType.h", line = 30,
   FQN="clang::LocInfoType::(anonymous)", NM="_ZN5clang11LocInfoTypeE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang11LocInfoTypeE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    // The last number that can fit in Type's TC.
    // Avoids conflict with an existing Type class.
    public static final /*uint*/int LocInfo = Type.TypeClass.TypeLast.getValue() + 1;
  /*}*/;
  
  private TypeSourceInfo /*P*/ DeclInfo;
  
  //<editor-fold defaultstate="collapsed" desc="clang::LocInfoType::LocInfoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LocInfoType.h", line = 38,
   FQN="clang::LocInfoType::LocInfoType", NM="_ZN5clang11LocInfoTypeC1ENS_8QualTypeEPNS_14TypeSourceInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang11LocInfoTypeC1ENS_8QualTypeEPNS_14TypeSourceInfoE")
  //</editor-fold>
  public/*private*/ LocInfoType(QualType ty, TypeSourceInfo /*P*/ TInfo) {
    // : Type((TypeClass)LocInfo, ty, ty->isDependentType(), ty->isInstantiationDependentType(), ty->isVariablyModifiedType(), ty->containsUnexpandedParameterPack()), DeclInfo(TInfo) 
    //START JInit
    super(TypeClass.valueOf(LocInfo), new QualType(ty), ty.$arrow().isDependentType(), 
        ty.$arrow().isInstantiationDependentType(), ty.$arrow().isVariablyModifiedType(), 
        ty.$arrow().containsUnexpandedParameterPack());
    this.DeclInfo = TInfo;
    //END JInit
    assert (getTypeClass() == TypeClass.valueOf(LocInfo)) : "LocInfo didn't fit in TC?";
  }

  /*friend  class Sema*/
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::LocInfoType::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LocInfoType.h", line = 48,
   FQN="clang::LocInfoType::getType", NM="_ZNK5clang11LocInfoType7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang11LocInfoType7getTypeEv")
  //</editor-fold>
  public QualType getType() /*const*/ {
    return getCanonicalTypeInternal();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::LocInfoType::getTypeSourceInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LocInfoType.h", line = 49,
   FQN="clang::LocInfoType::getTypeSourceInfo", NM="_ZNK5clang11LocInfoType17getTypeSourceInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang11LocInfoType17getTypeSourceInfoEv")
  //</editor-fold>
  public TypeSourceInfo /*P*/ getTypeSourceInfo() /*const*/ {
    return DeclInfo;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocInfoType::getAsStringInternal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5205,
   FQN="clang::LocInfoType::getAsStringInternal", NM="_ZNK5clang11LocInfoType19getAsStringInternalERSsRKNS_14PrintingPolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZNK5clang11LocInfoType19getAsStringInternalERSsRKNS_14PrintingPolicyE")
  //</editor-fold>
  public void getAsStringInternal(final std.string/*&*/ Str, 
                     final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    throw new llvm_unreachable("LocInfoType leaked into the type system; an opaque TypeTy* was used directly instead of getting the QualType through GetTypeFromParser");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::LocInfoType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/LocInfoType.h", line = 54,
   FQN="clang::LocInfoType::classof", NM="_ZN5clang11LocInfoType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZN5clang11LocInfoType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeClass() == TypeClass.valueOf(LocInfo);
  }

  static { assert LocInfo == (Type.TypeClass.TypeLast.getValue() + 1) : "we added LocInfoType$Java as TypeLast + 1:" + LocInfo + " vs. " + (Type.TypeClass.TypeLast.getValue() + 1); }
  
  static { assert Type.TypeClass.LocInfoType$Java.getValue() == LocInfo : "Type.TypeClass.LocInfoType$Java must exist and be equal to " + LocInfo + " vs. " + Type.TypeClass.LocInfoType$Java.getValue(); }
      
  @Override public String toString() {
    return "" + "DeclInfo=" + DeclInfo // NOI18N
              + super.toString(); // NOI18N
  }
}
