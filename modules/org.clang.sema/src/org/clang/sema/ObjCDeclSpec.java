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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


/// \brief Captures information about "declaration specifiers" specific to
/// Objective-C.
//<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 776,
 FQN="clang::ObjCDeclSpec", NM="_ZN5clang12ObjCDeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpecE")
//</editor-fold>
public class ObjCDeclSpec {
/*public:*/
  /// ObjCDeclQualifier - Qualifier used on types in method
  /// declarations.  Not all combinations are sensible.  Parameters
  /// can be one of { in, out, inout } with one of { bycopy, byref }.
  /// Returns can either be { oneway } or not.
  ///
  /// This should be kept in sync with Decl::ObjCDeclQualifier.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::ObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 784,
   FQN="clang::ObjCDeclSpec::ObjCDeclQualifier", NM="_ZN5clang12ObjCDeclSpec17ObjCDeclQualifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec17ObjCDeclQualifierE")
  //</editor-fold>
  public static final class/*enum*/ ObjCDeclQualifier {
    public static final /*uint*/int DQ_None = 0x0;
    public static final /*uint*/int DQ_In = 0x1;
    public static final /*uint*/int DQ_Inout = 0x2;
    public static final /*uint*/int DQ_Out = 0x4;
    public static final /*uint*/int DQ_Bycopy = 0x8;
    public static final /*uint*/int DQ_Byref = 0x10;
    public static final /*uint*/int DQ_Oneway = 0x20;
    public static final /*uint*/int DQ_CSNullability = 0x40;
  };
  
  /// PropertyAttributeKind - list of property attributes.
  /// Keep this list in sync with LLVM's Dwarf.h ApplePropertyAttributes.
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::ObjCPropertyAttributeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 797,
   FQN="clang::ObjCDeclSpec::ObjCPropertyAttributeKind", NM="_ZN5clang12ObjCDeclSpec25ObjCPropertyAttributeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec25ObjCPropertyAttributeKindE")
  //</editor-fold>
  public static final class/*enum*/ ObjCPropertyAttributeKind {
    public static final /*uint*/int DQ_PR_noattr = 0x0;
    public static final /*uint*/int DQ_PR_readonly = 0x01;
    public static final /*uint*/int DQ_PR_getter = 0x02;
    public static final /*uint*/int DQ_PR_assign = 0x04;
    public static final /*uint*/int DQ_PR_readwrite = 0x08;
    public static final /*uint*/int DQ_PR_retain = 0x10;
    public static final /*uint*/int DQ_PR_copy = 0x20;
    public static final /*uint*/int DQ_PR_nonatomic = 0x40;
    public static final /*uint*/int DQ_PR_setter = 0x80;
    public static final /*uint*/int DQ_PR_atomic = 0x100;
    public static final /*uint*/int DQ_PR_weak = 0x200;
    public static final /*uint*/int DQ_PR_strong = 0x400;
    public static final /*uint*/int DQ_PR_unsafe_unretained = 0x800;
    public static final /*uint*/int DQ_PR_nullability = 0x1000;
    public static final /*uint*/int DQ_PR_null_resettable = 0x2000;
    public static final /*uint*/int DQ_PR_class = 0x4000;
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::ObjCDeclSpec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 816,
   FQN="clang::ObjCDeclSpec::ObjCDeclSpec", NM="_ZN5clang12ObjCDeclSpecC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpecC1Ev")
  //</editor-fold>
  public ObjCDeclSpec() {
    // : objcDeclQualifier(DQ_None), PropertyAttributes(DQ_PR_noattr), Nullability(0), NullabilityLoc(), GetterName(null), SetterName(null) 
    //START JInit
    this.objcDeclQualifier = $uint2uint_7bits(ObjCDeclQualifier.DQ_None);
    this.PropertyAttributes = $uint2uint_15bits(ObjCPropertyAttributeKind.DQ_PR_noattr);
    this.Nullability = $uint2uint_2bits(0);
    this.NullabilityLoc = new SourceLocation();
    this.GetterName = null;
    this.SetterName = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::getObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 820,
   FQN="clang::ObjCDeclSpec::getObjCDeclQualifier", NM="_ZNK5clang12ObjCDeclSpec20getObjCDeclQualifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12ObjCDeclSpec20getObjCDeclQualifierEv")
  //</editor-fold>
  public /*ObjCDeclQualifier*//*uint*/int getObjCDeclQualifier() /*const*/ {
    return objcDeclQualifier;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::setObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 821,
   FQN="clang::ObjCDeclSpec::setObjCDeclQualifier", NM="_ZN5clang12ObjCDeclSpec20setObjCDeclQualifierENS0_17ObjCDeclQualifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec20setObjCDeclQualifierENS0_17ObjCDeclQualifierE")
  //</editor-fold>
  public void setObjCDeclQualifier(/*ObjCDeclQualifier*//*uint*/int DQVal) {
    objcDeclQualifier = $uint2uint_7bits((/*ObjCDeclQualifier*//*uint*/int)(objcDeclQualifier | $int2uint_7bits(DQVal)));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::clearObjCDeclQualifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 824,
   FQN="clang::ObjCDeclSpec::clearObjCDeclQualifier", NM="_ZN5clang12ObjCDeclSpec22clearObjCDeclQualifierENS0_17ObjCDeclQualifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec22clearObjCDeclQualifierENS0_17ObjCDeclQualifierE")
  //</editor-fold>
  public void clearObjCDeclQualifier(/*ObjCDeclQualifier*//*uint*/int DQVal) {
    objcDeclQualifier = $uint2uint_7bits((/*ObjCDeclQualifier*//*uint*/int)(objcDeclQualifier & $int2uint_7bits(~DQVal)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::getPropertyAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 828,
   FQN="clang::ObjCDeclSpec::getPropertyAttributes", NM="_ZNK5clang12ObjCDeclSpec21getPropertyAttributesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12ObjCDeclSpec21getPropertyAttributesEv")
  //</editor-fold>
  public /*ObjCPropertyAttributeKind*//*uint*/int getPropertyAttributes() /*const*/ {
    return ((/*ObjCPropertyAttributeKind*//*uint*/int)(PropertyAttributes));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::setPropertyAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 831,
   FQN="clang::ObjCDeclSpec::setPropertyAttributes", NM="_ZN5clang12ObjCDeclSpec21setPropertyAttributesENS0_25ObjCPropertyAttributeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec21setPropertyAttributesENS0_25ObjCPropertyAttributeKindE")
  //</editor-fold>
  public void setPropertyAttributes(/*ObjCPropertyAttributeKind*//*uint*/int PRVal) {
    PropertyAttributes
       = $uint2uint_15bits((/*ObjCPropertyAttributeKind*//*uint*/int)(PropertyAttributes | $int2uint_15bits(PRVal)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::getNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 836,
   FQN="clang::ObjCDeclSpec::getNullability", NM="_ZNK5clang12ObjCDeclSpec14getNullabilityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12ObjCDeclSpec14getNullabilityEv")
  //</editor-fold>
  public NullabilityKind getNullability() /*const*/ {
    assert ((((getObjCDeclQualifier() & ObjCDeclQualifier.DQ_CSNullability) != 0) || ((getPropertyAttributes() & ObjCPropertyAttributeKind.DQ_PR_nullability) != 0))) : "Objective-C declspec doesn't have nullability";
    return /*static_cast*/NullabilityKind.valueOf(Nullability);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::getNullabilityLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 843,
   FQN="clang::ObjCDeclSpec::getNullabilityLoc", NM="_ZNK5clang12ObjCDeclSpec17getNullabilityLocEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12ObjCDeclSpec17getNullabilityLocEv")
  //</editor-fold>
  public SourceLocation getNullabilityLoc() /*const*/ {
    assert ((((getObjCDeclQualifier() & ObjCDeclQualifier.DQ_CSNullability) != 0) || ((getPropertyAttributes() & ObjCPropertyAttributeKind.DQ_PR_nullability) != 0))) : "Objective-C declspec doesn't have nullability";
    return new SourceLocation(NullabilityLoc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::setNullability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 850,
   FQN="clang::ObjCDeclSpec::setNullability", NM="_ZN5clang12ObjCDeclSpec14setNullabilityENS_14SourceLocationENS_15NullabilityKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec14setNullabilityENS_14SourceLocationENS_15NullabilityKindE")
  //</editor-fold>
  public void setNullability(SourceLocation loc, NullabilityKind kind) {
    assert ((((getObjCDeclQualifier() & ObjCDeclQualifier.DQ_CSNullability) != 0) || ((getPropertyAttributes() & ObjCPropertyAttributeKind.DQ_PR_nullability) != 0))) : "Set the nullability declspec or property attribute first";
    Nullability = $uint2uint_2bits(((/*static_cast*//*uint*/int)kind.getValue()));
    NullabilityLoc.$assign(loc);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::getGetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 858,
   FQN="clang::ObjCDeclSpec::getGetterName", NM="_ZNK5clang12ObjCDeclSpec13getGetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12ObjCDeclSpec13getGetterNameEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getGetterName$Const() /*const*/ {
    return GetterName;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::getGetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 859,
   FQN="clang::ObjCDeclSpec::getGetterName", NM="_ZN5clang12ObjCDeclSpec13getGetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec13getGetterNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getGetterName() {
    return GetterName;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::setGetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 860,
   FQN="clang::ObjCDeclSpec::setGetterName", NM="_ZN5clang12ObjCDeclSpec13setGetterNameEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec13setGetterNameEPNS_14IdentifierInfoE")
  //</editor-fold>
  public void setGetterName(IdentifierInfo /*P*/ name) {
    GetterName = name;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::getSetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 862,
   FQN="clang::ObjCDeclSpec::getSetterName", NM="_ZNK5clang12ObjCDeclSpec13getSetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZNK5clang12ObjCDeclSpec13getSetterNameEv")
  //</editor-fold>
  public /*const*/ IdentifierInfo /*P*/ getSetterName$Const() /*const*/ {
    return SetterName;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::getSetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 863,
   FQN="clang::ObjCDeclSpec::getSetterName", NM="_ZN5clang12ObjCDeclSpec13getSetterNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec13getSetterNameEv")
  //</editor-fold>
  public IdentifierInfo /*P*/ getSetterName() {
    return SetterName;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ObjCDeclSpec::setSetterName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DeclSpec.h", line = 864,
   FQN="clang::ObjCDeclSpec::setSetterName", NM="_ZN5clang12ObjCDeclSpec13setSetterNameEPNS_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=_ZN5clang12ObjCDeclSpec13setSetterNameEPNS_14IdentifierInfoE")
  //</editor-fold>
  public void setSetterName(IdentifierInfo /*P*/ name) {
    SetterName = name;
  }

/*private:*/
  // FIXME: These two are unrelated and mutually exclusive. So perhaps
  // we can put them in a union to reflect their mutual exclusivity
  // (space saving is negligible).
  private /*JBYTE ObjCDeclQualifier*/ byte objcDeclQualifier /*: 7*/;
  
  // NOTE: VC++ treats enums as signed, avoid using ObjCPropertyAttributeKind
  private /*JCHAR unsigned int*/ char PropertyAttributes /*: 15*/;
  
  private /*JBYTE unsigned int*/ byte Nullability /*: 2*/;
  
  private SourceLocation NullabilityLoc;
  
  private IdentifierInfo /*P*/ GetterName; // getter name or NULL if no getter
  private IdentifierInfo /*P*/ SetterName; // setter name or NULL if no setter
  
  @Override public String toString() {
    return "" + "objcDeclQualifier=" + $uchar2uint(objcDeclQualifier) // NOI18N
              + ", PropertyAttributes=" + $ushort2uint(PropertyAttributes) // NOI18N
              + ", Nullability=" + $uchar2uint(Nullability) // NOI18N
              + ", NullabilityLoc=" + NullabilityLoc // NOI18N
              + ", GetterName=" + GetterName // NOI18N
              + ", SetterName=" + SetterName; // NOI18N
  }
}
