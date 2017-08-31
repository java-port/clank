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
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;


/// A declaration being accessed, together with information about how
/// it was accessed.
//<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 32,
 FQN="clang::sema::AccessedEntity", NM="_ZN5clang4sema14AccessedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntityE")
//</editor-fold>
public class AccessedEntity implements Destructors.ClassWithDestructor {

  public static /*uint*/int $sizeof_AccessedEntity() {
    throw new UnsupportedOperationException();
  }

/*public:*/
  /// A member declaration found through lookup.  The target is the
  /// member.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::MemberNonce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 36,
   FQN="clang::sema::AccessedEntity::MemberNonce", NM="_ZN5clang4sema14AccessedEntity11MemberNonceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntity11MemberNonceE")
  //</editor-fold>
  public enum MemberNonce implements Native.ComparableLower {
    Member(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MemberNonce valueOf(int val) {
      MemberNonce out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MemberNonce[] VALUES;
      private static final MemberNonce[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MemberNonce kind : MemberNonce.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MemberNonce[min < 0 ? (1-min) : 0];
        VALUES = new MemberNonce[max >= 0 ? (1+max) : 0];
        for (MemberNonce kind : MemberNonce.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private MemberNonce(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MemberNonce)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MemberNonce)obj).value);}
    //</editor-fold>
  };
  
  /// A hierarchy (base-to-derived or derived-to-base) conversion.
  /// The target is the base class.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::BaseNonce">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 40,
   FQN="clang::sema::AccessedEntity::BaseNonce", NM="_ZN5clang4sema14AccessedEntity9BaseNonceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntity9BaseNonceE")
  //</editor-fold>
  public enum BaseNonce implements Native.ComparableLower {
    Base(0);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static BaseNonce valueOf(int val) {
      BaseNonce out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final BaseNonce[] VALUES;
      private static final BaseNonce[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (BaseNonce kind : BaseNonce.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new BaseNonce[min < 0 ? (1-min) : 0];
        VALUES = new BaseNonce[max >= 0 ? (1+max) : 0];
        for (BaseNonce kind : BaseNonce.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private BaseNonce(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((BaseNonce)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((BaseNonce)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::isMemberAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 42,
   FQN="clang::sema::AccessedEntity::isMemberAccess", NM="_ZNK5clang4sema14AccessedEntity14isMemberAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity14isMemberAccessEv")
  //</editor-fold>
  public boolean isMemberAccess() /*const*/ {
    return IsMember;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::AccessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 44,
   FQN="clang::sema::AccessedEntity::AccessedEntity", NM="_ZN5clang4sema14AccessedEntityC1ERNS_17PartialDiagnostic16StorageAllocatorENS1_11MemberNonceEPNS_13CXXRecordDeclENS_14DeclAccessPairENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntityC1ERNS_17PartialDiagnostic16StorageAllocatorENS1_11MemberNonceEPNS_13CXXRecordDeclENS_14DeclAccessPairENS_8QualTypeE")
  //</editor-fold>
  public AccessedEntity(final PartialDiagnostic.StorageAllocator /*&*/ Allocator, 
      MemberNonce _, 
      CXXRecordDecl /*P*/ NamingClass, 
      DeclAccessPair FoundDecl, 
      QualType BaseObjectType) {
    // : Access(FoundDecl.getAccess()), IsMember(true), Target(FoundDecl.getDecl()), NamingClass(NamingClass), BaseObjectType(BaseObjectType), Diag(0, Allocator) 
    //START JInit
    this.Access = $uint2uint_2bits(FoundDecl.getAccess().getValue());
    this.IsMember = true;
    this.Target = FoundDecl.getDecl();
    this.NamingClass = NamingClass;
    this.BaseObjectType = new QualType(BaseObjectType);
    this.Diag = new PartialDiagnostic(0, Allocator);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::AccessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 54,
   FQN="clang::sema::AccessedEntity::AccessedEntity", NM="_ZN5clang4sema14AccessedEntityC1ERNS_17PartialDiagnostic16StorageAllocatorENS1_9BaseNonceEPNS_13CXXRecordDeclES7_NS_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntityC1ERNS_17PartialDiagnostic16StorageAllocatorENS1_9BaseNonceEPNS_13CXXRecordDeclES7_NS_15AccessSpecifierE")
  //</editor-fold>
  public AccessedEntity(final PartialDiagnostic.StorageAllocator /*&*/ Allocator, 
      BaseNonce _, 
      CXXRecordDecl /*P*/ BaseClass, 
      CXXRecordDecl /*P*/ DerivedClass, 
      AccessSpecifier Access) {
    // : Access(Access), IsMember(false), Target(BaseClass), NamingClass(DerivedClass), BaseObjectType(), Diag(0, Allocator) 
    //START JInit
    this.Access = $uint2uint_2bits(Access.getValue());
    this.IsMember = false;
    this.Target = BaseClass;
    this.NamingClass = DerivedClass;
    this.BaseObjectType = new QualType();
    this.Diag = new PartialDiagnostic(0, Allocator);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::isQuiet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 65,
   FQN="clang::sema::AccessedEntity::isQuiet", NM="_ZNK5clang4sema14AccessedEntity7isQuietEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity7isQuietEv")
  //</editor-fold>
  public boolean isQuiet() /*const*/ {
    return Diag.getDiagID() == 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::getAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 67,
   FQN="clang::sema::AccessedEntity::getAccess", NM="_ZNK5clang4sema14AccessedEntity9getAccessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity9getAccessEv")
  //</editor-fold>
  public AccessSpecifier getAccess() /*const*/ {
    return AccessSpecifier.valueOf(Access);
  }

  
  // These apply to member decls...
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::getTargetDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 70,
   FQN="clang::sema::AccessedEntity::getTargetDecl", NM="_ZNK5clang4sema14AccessedEntity13getTargetDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity13getTargetDeclEv")
  //</editor-fold>
  public NamedDecl /*P*/ getTargetDecl() /*const*/ {
    return Target;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::getNamingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 71,
   FQN="clang::sema::AccessedEntity::getNamingClass", NM="_ZNK5clang4sema14AccessedEntity14getNamingClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity14getNamingClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getNamingClass() /*const*/ {
    return NamingClass;
  }

  
  // ...and these apply to hierarchy conversions.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::getBaseClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 74,
   FQN="clang::sema::AccessedEntity::getBaseClass", NM="_ZNK5clang4sema14AccessedEntity12getBaseClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity12getBaseClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getBaseClass() /*const*/ {
    assert (!IsMember);
    return cast(CXXRecordDecl.class, Target);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::getDerivedClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 77,
   FQN="clang::sema::AccessedEntity::getDerivedClass", NM="_ZNK5clang4sema14AccessedEntity15getDerivedClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity15getDerivedClassEv")
  //</editor-fold>
  public CXXRecordDecl /*P*/ getDerivedClass() /*const*/ {
    return NamingClass;
  }

  
  /// Retrieves the base object type, important when accessing
  /// an instance member.
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::getBaseObjectType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 81,
   FQN="clang::sema::AccessedEntity::getBaseObjectType", NM="_ZNK5clang4sema14AccessedEntity17getBaseObjectTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity17getBaseObjectTypeEv")
  //</editor-fold>
  public QualType getBaseObjectType() /*const*/ {
    return new QualType(BaseObjectType);
  }

  
  /// Sets a diagnostic to be performed.  The diagnostic is given
  /// four (additional) arguments:
  ///   %0 - 0 if the entity was private, 1 if protected
  ///   %1 - the DeclarationName of the entity
  ///   %2 - the TypeDecl type of the naming class
  ///   %3 - the TypeDecl type of the declaring class
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::setDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 89,
   FQN="clang::sema::AccessedEntity::setDiag", NM="_ZN5clang4sema14AccessedEntity7setDiagERKNS_17PartialDiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntity7setDiagERKNS_17PartialDiagnosticE")
  //</editor-fold>
  public void setDiag(final /*const*/ PartialDiagnostic /*&*/ PDiag) {
    assert (isQuiet()) : "partial diagnostic already defined";
    Diag.$assign(PDiag);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::setDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 93,
   FQN="clang::sema::AccessedEntity::setDiag", NM="_ZN5clang4sema14AccessedEntity7setDiagEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntity7setDiagEj")
  //</editor-fold>
  public PartialDiagnostic /*&*/ setDiag(/*uint*/int DiagID) {
    assert (isQuiet()) : "partial diagnostic already defined";
    assert ((DiagID != 0)) : "creating null diagnostic";
    Diag.Reset(DiagID);
    return Diag;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::getDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 99,
   FQN="clang::sema::AccessedEntity::getDiag", NM="_ZNK5clang4sema14AccessedEntity7getDiagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZNK5clang4sema14AccessedEntity7getDiagEv")
  //</editor-fold>
  public /*const*/ PartialDiagnostic /*&*/ getDiag() /*const*/ {
    return Diag;
  }

/*private:*/
  private /*JBYTE unsigned int*/ byte Access /*: 2*/;
  private /*JBIT unsigned int*/ boolean IsMember /*: 1*/;
  private NamedDecl /*P*/ Target;
  private CXXRecordDecl /*P*/ NamingClass;
  private QualType BaseObjectType;
  private PartialDiagnostic Diag;
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::AccessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 32,
   FQN="clang::sema::AccessedEntity::AccessedEntity", NM="_ZN5clang4sema14AccessedEntityC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntityC1ERKS1_")
  //</editor-fold>
  public /*inline*/ AccessedEntity(final /*const*/ AccessedEntity /*&*/ $Prm0) {
    // : Access(.Access), IsMember(.IsMember), Target(.Target), NamingClass(.NamingClass), BaseObjectType(.BaseObjectType), Diag(.Diag) 
    //START JInit
    this.Access = $uint2uint_2bits($Prm0.Access);
    this.IsMember = $Prm0.IsMember;
    this.Target = $Prm0.Target;
    this.NamingClass = $Prm0.NamingClass;
    this.BaseObjectType = new QualType($Prm0.BaseObjectType);
    this.Diag = new PartialDiagnostic($Prm0.Diag);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::AccessedEntity::~AccessedEntity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/DelayedDiagnostic.h", line = 32,
   FQN="clang::sema::AccessedEntity::~AccessedEntity", NM="_ZN5clang4sema14AccessedEntityD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DelayedDiagnostic.cpp -nm=_ZN5clang4sema14AccessedEntityD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Diag.$destroy();
    //END JDestroy
  }

  public AccessedEntity() {
    this.Access = 0;
    this.IsMember = false;
    this.Target = null;
    this.NamingClass = null;
    this.BaseObjectType = new QualType();
    this.Diag = new PartialDiagnostic(new PartialDiagnostic.NullDiagnostic());
  }

  public /*inline*/ AccessedEntity /*&*/ $assignMove(final AccessedEntity /*&&*/$Prm0) {
    this.Access = $Prm0.Access;
    this.IsMember = $Prm0.IsMember;
    this.Target = $Prm0.Target;
    $Prm0.Target = null;
    this.NamingClass = $Prm0.NamingClass;
    $Prm0.NamingClass = null;
    this.BaseObjectType = $Prm0.BaseObjectType;
    $Prm0.BaseObjectType = null;
    this.Diag = $Prm0.Diag;
    $Prm0.Diag = null;
    return /*Deref*/this;
  }  
  
  public /*inline*/ AccessedEntity /*&*/ $MemoryCopy(final AccessedEntity /*&&*/$Prm0) {
    this.Access = $Prm0.Access;
    this.IsMember = $Prm0.IsMember;
    this.Target = $Prm0.Target;
    this.NamingClass = $Prm0.NamingClass;
    this.BaseObjectType.$assign($Prm0.BaseObjectType);
    this.Diag.$MemoryCopy($Prm0.Diag);
    return /*Deref*/this;
  }
  
  @Override public String toString() {
    return "" + "Access=" + $uchar2uint(Access) // NOI18N
              + ", IsMember=" + IsMember // NOI18N
              + ", Target=" + Target // NOI18N
              + ", NamingClass=" + NamingClass // NOI18N
              + ", BaseObjectType=" + BaseObjectType // NOI18N
              + ", Diag=" + "[PartialDiagnostic]"; // NOI18N
  }
}
