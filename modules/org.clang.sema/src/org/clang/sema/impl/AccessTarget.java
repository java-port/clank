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

package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.impl.SemaAccessStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// Like sema::AccessedEntity, but kindly lets us scribble all over
/// it.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 149,
 FQN="(anonymous namespace)::AccessTarget", NM="_ZN12_GLOBAL__N_112AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTargetE")
//</editor-fold>
public class/*struct*/ AccessTarget extends /*public*/ AccessedEntity implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::AccessTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 150,
   FQN="(anonymous namespace)::AccessTarget::AccessTarget", NM="_ZN12_GLOBAL__N_112AccessTargetC1ERKN5clang4sema14AccessedEntityE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTargetC1ERKN5clang4sema14AccessedEntityE")
  //</editor-fold>
  public AccessTarget(final /*const*/ AccessedEntity /*&*/ Entity) {
    // : AccessedEntity(Entity) 
    //START JInit
    super(Entity);
    //END JInit
    initialize();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::AccessTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 155,
   FQN="(anonymous namespace)::AccessTarget::AccessTarget", NM="_ZN12_GLOBAL__N_112AccessTargetC1ERN5clang10ASTContextENS1_4sema14AccessedEntity11MemberNonceEPNS1_13CXXRecordDeclENS1_14DeclAccessPairENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTargetC1ERN5clang10ASTContextENS1_4sema14AccessedEntity11MemberNonceEPNS1_13CXXRecordDeclENS1_14DeclAccessPairENS1_8QualTypeE")
  //</editor-fold>
  public AccessTarget(final ASTContext /*&*/ Context, 
      MemberNonce _, 
      CXXRecordDecl /*P*/ NamingClass, 
      DeclAccessPair FoundDecl, 
      QualType BaseObjectType) {
    // : AccessedEntity(Context.getDiagAllocator(), Member, NamingClass, FoundDecl, BaseObjectType) 
    //START JInit
    super(Context.getDiagAllocator(), MemberNonce.Member, NamingClass, 
        new DeclAccessPair(FoundDecl), new QualType(BaseObjectType));
    //END JInit
    initialize();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::AccessTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 165,
   FQN="(anonymous namespace)::AccessTarget::AccessTarget", NM="_ZN12_GLOBAL__N_112AccessTargetC1ERN5clang10ASTContextENS1_4sema14AccessedEntity9BaseNonceEPNS1_13CXXRecordDeclES8_NS1_15AccessSpecifierE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTargetC1ERN5clang10ASTContextENS1_4sema14AccessedEntity9BaseNonceEPNS1_13CXXRecordDeclES8_NS1_15AccessSpecifierE")
  //</editor-fold>
  public AccessTarget(final ASTContext /*&*/ Context, 
      BaseNonce _, 
      CXXRecordDecl /*P*/ BaseClass, 
      CXXRecordDecl /*P*/ DerivedClass, 
      AccessSpecifier Access) {
    // : AccessedEntity(Context.getDiagAllocator(), Base, BaseClass, DerivedClass, Access) 
    //START JInit
    super(Context.getDiagAllocator(), BaseNonce.Base, BaseClass, DerivedClass, 
        Access);
    //END JInit
    initialize();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::isInstanceMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 175,
   FQN="(anonymous namespace)::AccessTarget::isInstanceMember", NM="_ZNK12_GLOBAL__N_112AccessTarget16isInstanceMemberEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK12_GLOBAL__N_112AccessTarget16isInstanceMemberEv")
  //</editor-fold>
  public boolean isInstanceMember() /*const*/ {
    return (isMemberAccess() && getTargetDecl().isCXXInstanceMember());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::hasInstanceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 179,
   FQN="(anonymous namespace)::AccessTarget::hasInstanceContext", NM="_ZNK12_GLOBAL__N_112AccessTarget18hasInstanceContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK12_GLOBAL__N_112AccessTarget18hasInstanceContextEv")
  //</editor-fold>
  public boolean hasInstanceContext() /*const*/ {
    return HasInstanceContext;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::SavedInstanceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 183,
   FQN="(anonymous namespace)::AccessTarget::SavedInstanceContext", NM="_ZN12_GLOBAL__N_112AccessTarget20SavedInstanceContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTarget20SavedInstanceContextE")
  //</editor-fold>
  public static class SavedInstanceContext implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::SavedInstanceContext::SavedInstanceContext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 185,
     FQN="(anonymous namespace)::AccessTarget::SavedInstanceContext::SavedInstanceContext", NM="_ZN12_GLOBAL__N_112AccessTarget20SavedInstanceContextC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTarget20SavedInstanceContextC1EOS1_")
    //</editor-fold>
    public SavedInstanceContext(JD$Move _dparam, final SavedInstanceContext /*&&*/S) {
      // : Target(S.Target), Has(S.Has) 
      //START JInit
      this.Target = S.Target;
      this.Has = S.Has;
      //END JInit
      S.Target = null;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::SavedInstanceContext::~SavedInstanceContext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 189,
     FQN="(anonymous namespace)::AccessTarget::SavedInstanceContext::~SavedInstanceContext", NM="_ZN12_GLOBAL__N_112AccessTarget20SavedInstanceContextD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTarget20SavedInstanceContextD0Ev")
    //</editor-fold>
    public void $destroy() {
      if ((Target != null)) {
        Target.HasInstanceContext = Has;
      }
    }

  /*private:*/
    /*friend  struct AccessTarget*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::SavedInstanceContext::SavedInstanceContext">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 196,
     FQN="(anonymous namespace)::AccessTarget::SavedInstanceContext::SavedInstanceContext", NM="_ZN12_GLOBAL__N_112AccessTarget20SavedInstanceContextC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTarget20SavedInstanceContextC1ERS0_")
    //</editor-fold>
    private /*explicit*/ SavedInstanceContext(final AccessTarget /*&*/ Target) {
      // : Target(&Target), Has(Target.HasInstanceContext) 
      //START JInit
      this.Target = $AddrOf(Target);
      this.Has = Target.HasInstanceContext;
      //END JInit
    }

    private AccessTarget /*P*/ Target;
    private boolean Has;
    
    @Override public String toString() {
      return "" + "Target=" + Target // NOI18N
                + ", Has=" + Has; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::saveInstanceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 202,
   FQN="(anonymous namespace)::AccessTarget::saveInstanceContext", NM="_ZN12_GLOBAL__N_112AccessTarget19saveInstanceContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTarget19saveInstanceContextEv")
  //</editor-fold>
  public SavedInstanceContext saveInstanceContext() {
    return new SavedInstanceContext(/*Deref*/this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::suppressInstanceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 206,
   FQN="(anonymous namespace)::AccessTarget::suppressInstanceContext", NM="_ZN12_GLOBAL__N_112AccessTarget23suppressInstanceContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTarget23suppressInstanceContextEv")
  //</editor-fold>
  public void suppressInstanceContext() {
    HasInstanceContext = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::resolveInstanceContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 210,
   FQN="(anonymous namespace)::AccessTarget::resolveInstanceContext", NM="_ZNK12_GLOBAL__N_112AccessTarget22resolveInstanceContextERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK12_GLOBAL__N_112AccessTarget22resolveInstanceContextERN5clang4SemaE")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ resolveInstanceContext(final Sema /*&*/ S) /*const*/ {
    assert (HasInstanceContext);
    if (CalculatedInstanceContext) {
      return InstanceContext;
    }
    
    CalculatedInstanceContext = true;
    DeclContext /*P*/ IC = S.computeDeclContext(getBaseObjectType());
    InstanceContext = ((IC != null) ? cast_CXXRecordDecl(IC).getCanonicalDecl() : null);
    return InstanceContext;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::getDeclaringClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 222,
   FQN="(anonymous namespace)::AccessTarget::getDeclaringClass", NM="_ZNK12_GLOBAL__N_112AccessTarget17getDeclaringClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK12_GLOBAL__N_112AccessTarget17getDeclaringClassEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getDeclaringClass() /*const*/ {
    return DeclaringClass;
  }

  
  /// The "effective" naming class is the canonical non-anonymous
  /// class containing the actual naming class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::getEffectiveNamingClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 228,
   FQN="(anonymous namespace)::AccessTarget::getEffectiveNamingClass", NM="_ZNK12_GLOBAL__N_112AccessTarget23getEffectiveNamingClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZNK12_GLOBAL__N_112AccessTarget23getEffectiveNamingClassEv")
  //</editor-fold>
  public /*const*/ CXXRecordDecl /*P*/ getEffectiveNamingClass() /*const*/ {
    /*const*/ CXXRecordDecl /*P*/ namingClass = getNamingClass();
    while (namingClass.isAnonymousStructOrUnion()) {
      namingClass = cast_CXXRecordDecl(namingClass.getParent$Const());
    }
    return namingClass.getCanonicalDecl$Const();
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::initialize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 236,
   FQN="(anonymous namespace)::AccessTarget::initialize", NM="_ZN12_GLOBAL__N_112AccessTarget10initializeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTarget10initializeEv")
  //</editor-fold>
  private void initialize() {
    HasInstanceContext = (isMemberAccess()
       && !getBaseObjectType().isNull()
       && getTargetDecl().isCXXInstanceMember());
    CalculatedInstanceContext = false;
    InstanceContext = null;
    if (isMemberAccess()) {
      DeclaringClass = FindDeclaringClass(getTargetDecl());
    } else {
      DeclaringClass = getBaseClass();
    }
    DeclaringClass = DeclaringClass.getCanonicalDecl$Const();
  }

  
  private /*JBIT bool*/ boolean HasInstanceContext /*: 1*/;
  private /*mutable *//*JBIT bool*/ boolean CalculatedInstanceContext /*: 1*/;
  private /*mutable *//*const*/ CXXRecordDecl /*P*/ InstanceContext;
  private /*const*/ CXXRecordDecl /*P*/ DeclaringClass;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AccessTarget::~AccessTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 149,
   FQN="(anonymous namespace)::AccessTarget::~AccessTarget", NM="_ZN12_GLOBAL__N_112AccessTargetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_112AccessTargetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "HasInstanceContext=" + HasInstanceContext // NOI18N
              + ", CalculatedInstanceContext=" + CalculatedInstanceContext // NOI18N
              + ", InstanceContext=" + InstanceContext // NOI18N
              + ", DeclaringClass=" + DeclaringClass // NOI18N
              + super.toString(); // NOI18N
  }
}
