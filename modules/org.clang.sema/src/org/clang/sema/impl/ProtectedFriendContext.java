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

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.impl.SemaAccessStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// A helper class for checking for a friend which will grant access
/// to a protected instance member.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ProtectedFriendContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 597,
 FQN="(anonymous namespace)::ProtectedFriendContext", NM="_ZN12_GLOBAL__N_122ProtectedFriendContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_122ProtectedFriendContextE")
//</editor-fold>
public class/*struct*/ ProtectedFriendContext implements Destructors.ClassWithDestructor {
  public final Sema /*&*/ S;
  public final /*const*/ EffectiveContext /*&*/ EC;
  public /*const*/ CXXRecordDecl /*P*/ NamingClass;
  public boolean CheckDependent;
  public boolean EverDependent;
  
  /// The path down to the current base class.
  public SmallVector</*const*/ CXXRecordDecl /*P*/ > CurPath;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ProtectedFriendContext::ProtectedFriendContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 607,
   FQN="(anonymous namespace)::ProtectedFriendContext::ProtectedFriendContext", NM="_ZN12_GLOBAL__N_122ProtectedFriendContextC1ERN5clang4SemaERKNS_16EffectiveContextEPKNS1_13CXXRecordDeclES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_122ProtectedFriendContextC1ERN5clang4SemaERKNS_16EffectiveContextEPKNS1_13CXXRecordDeclES9_")
  //</editor-fold>
  public ProtectedFriendContext(final Sema /*&*/ S, final /*const*/ EffectiveContext /*&*/ EC, 
      /*const*/ CXXRecordDecl /*P*/ InstanceContext, 
      /*const*/ CXXRecordDecl /*P*/ NamingClass) {
    // : S(S), EC(EC), NamingClass(NamingClass), CheckDependent(InstanceContext->isDependentContext() || NamingClass->isDependentContext()), EverDependent(false), CurPath() 
    //START JInit
    this./*&*/S=/*&*/S;
    this./*&*/EC=/*&*/EC;
    this.NamingClass = NamingClass;
    this.CheckDependent = InstanceContext.isDependentContext()
       || NamingClass.isDependentContext();
    this.EverDependent = false;
    this.CurPath = new SmallVector</*const*/ CXXRecordDecl /*P*/ >(20, (/*const*/ CXXRecordDecl /*P*/ )null);
    //END JInit
  }

  
  /// Check classes in the current path for friendship, starting at
  /// the given index.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ProtectedFriendContext::checkFriendshipAlongPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 617,
   FQN="(anonymous namespace)::ProtectedFriendContext::checkFriendshipAlongPath", NM="_ZN12_GLOBAL__N_122ProtectedFriendContext24checkFriendshipAlongPathEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_122ProtectedFriendContext24checkFriendshipAlongPathEj")
  //</editor-fold>
  public boolean checkFriendshipAlongPath(/*uint*/int I) {
    assert ($less_uint(I, CurPath.size()));
    for (/*uint*/int E = CurPath.size(); I != E; ++I) {
      switch (GetFriendKind(S, EC, CurPath.$at(I))) {
       case AR_accessible:
        return true;
       case AR_inaccessible:
        continue;
       case AR_dependent:
        EverDependent = true;
        continue;
      }
    }
    return false;
  }

  
  /// Perform a search starting at the given class.
  ///
  /// PrivateDepth is the index of the last (least derived) class
  /// along the current path such that a notional public member of
  /// the final class in the path would have access in that class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ProtectedFriendContext::findFriendship">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 634,
   FQN="(anonymous namespace)::ProtectedFriendContext::findFriendship", NM="_ZN12_GLOBAL__N_122ProtectedFriendContext14findFriendshipEPKN5clang13CXXRecordDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_122ProtectedFriendContext14findFriendshipEPKN5clang13CXXRecordDeclEj")
  //</editor-fold>
  public boolean findFriendship(/*const*/ CXXRecordDecl /*P*/ Cur, /*uint*/int PrivateDepth) {
    // If we ever reach the naming class, check the current path for
    // friendship.  We can also stop recursing because we obviously
    // won't find the naming class there again.
    if (Cur == NamingClass) {
      return checkFriendshipAlongPath(PrivateDepth);
    }
    if (CheckDependent && MightInstantiateTo(Cur, NamingClass)) {
      EverDependent = true;
    }
    
    // Recurse into the base classes.
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : Cur.bases$Const()) {
      // If this is private inheritance, then a public member of the
      // base will not have any access in classes derived from Cur.
      /*uint*/int BasePrivateDepth = PrivateDepth;
      if (I.getAccessSpecifier() == AccessSpecifier.AS_private) {
        BasePrivateDepth = CurPath.size() - 1;
      }
      
      /*const*/ CXXRecordDecl /*P*/ RD;
      
      QualType T = I.getType();
      {
        /*const*/ RecordType /*P*/ RT = T.$arrow().<RecordType>getAs$RecordType();
        if ((RT != null)) {
          RD = cast_CXXRecordDecl(RT.getDecl());
        } else {
          /*const*/ InjectedClassNameType /*P*/ IT = T.$arrow().<InjectedClassNameType>getAs$InjectedClassNameType();
          if ((IT != null)) {
            RD = IT.getDecl();
          } else {
            assert (T.$arrow().isDependentType()) : "non-dependent base wasn't a record?";
            EverDependent = true;
            continue;
          }
        }
      }
      
      // Recurse.  We don't need to clean up if this returns true.
      CurPath.push_back(RD);
      if (findFriendship(RD.getCanonicalDecl$Const(), BasePrivateDepth)) {
        return true;
      }
      CurPath.pop_back();
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ProtectedFriendContext::findFriendship">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 676,
   FQN="(anonymous namespace)::ProtectedFriendContext::findFriendship", NM="_ZN12_GLOBAL__N_122ProtectedFriendContext14findFriendshipEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_122ProtectedFriendContext14findFriendshipEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  public boolean findFriendship(/*const*/ CXXRecordDecl /*P*/ Cur) {
    assert (CurPath.empty());
    CurPath.push_back(Cur);
    return findFriendship(Cur, 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ProtectedFriendContext::~ProtectedFriendContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 597,
   FQN="(anonymous namespace)::ProtectedFriendContext::~ProtectedFriendContext", NM="_ZN12_GLOBAL__N_122ProtectedFriendContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZN12_GLOBAL__N_122ProtectedFriendContextD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    CurPath.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", EC=" + "[EffectiveContext]" // NOI18N
              + ", NamingClass=" + NamingClass // NOI18N
              + ", CheckDependent=" + CheckDependent // NOI18N
              + ", EverDependent=" + EverDependent // NOI18N
              + ", CurPath=" + CurPath; // NOI18N
  }
}
