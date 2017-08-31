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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.DeclarationName.*;
import org.clang.ast.aliases.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaAccessStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL11CheckAccessRN5clang4SemaENS_14SourceLocationERN12_GLOBAL__N_112AccessTargetE;_ZL12FindBestPathRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetENS_15AccessSpecifierERNS_12CXXBasePathsE;_ZL12IsAccessibleRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE;_ZL13GetFriendKindRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclE;_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_7CanQualINS_4TypeEEE;_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclE;_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_10FriendDeclE;_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_12FunctionDeclE;_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_17ClassTemplateDeclE;_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_20FunctionTemplateDeclE;_ZL17DiagnoseBadAccessRN5clang4SemaENS_14SourceLocationERKN12_GLOBAL__N_116EffectiveContextERNS3_12AccessTargetE;_ZL18DiagnoseAccessPathRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE;_ZL18FindDeclaringClassPN5clang9NamedDeclE;_ZL18MightInstantiateToPKN5clang13CXXRecordDeclES2_;_ZL18MightInstantiateToRN5clang4SemaENS_7CanQualINS_4TypeEEES4_;_ZL18MightInstantiateToRN5clang4SemaEPNS_11DeclContextES3_;_ZL18MightInstantiateToRN5clang4SemaEPNS_12FunctionDeclES3_;_ZL18MightInstantiateToRN5clang4SemaEPNS_20FunctionTemplateDeclES3_;_ZL20CheckEffectiveAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_14SourceLocationERNS2_12AccessTargetE;_ZL20DelayDependentAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_14SourceLocationERKNS2_12AccessTargetE;_ZL22GetProtectedFriendKindRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclES8_;_ZL22IsDerivedFromInclusivePKN5clang13CXXRecordDeclES2_;_ZL23diagnoseBadDirectAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE;_ZL26TryDiagnoseProtectedAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE;_ZL36IsMicrosoftUsingDeclarationAccessBugRN5clang4SemaENS_14SourceLocationERN12_GLOBAL__N_112AccessTargetE;_ZL9HasAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclENS_15AccessSpecifierERKNS2_12AccessTargetE; -static-type=SemaAccessStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaAccessStatics {

//<editor-fold defaultstate="collapsed" desc="FindDeclaringClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 65,
 FQN="FindDeclaringClass", NM="_ZL18FindDeclaringClassPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL18FindDeclaringClassPN5clang9NamedDeclE")
//</editor-fold>
public static CXXRecordDecl /*P*/ FindDeclaringClass(NamedDecl /*P*/ D) {
  DeclContext /*P*/ DC = D.getDeclContext();
  
  // This can only happen at top: enum decls only "publish" their
  // immediate members.
  if (isa_EnumDecl(DC)) {
    DC = cast_EnumDecl(DC).getDeclContext();
  }
  
  CXXRecordDecl /*P*/ DeclaringClass = cast_CXXRecordDecl(DC);
  while (DeclaringClass.isAnonymousStructOrUnion()) {
    DeclaringClass = cast_CXXRecordDecl(DeclaringClass.getDeclContext());
  }
  return DeclaringClass;
}


/// Checks whether one class might instantiate to the other.
//<editor-fold defaultstate="collapsed" desc="MightInstantiateTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 259,
 FQN="MightInstantiateTo", NM="_ZL18MightInstantiateToPKN5clang13CXXRecordDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL18MightInstantiateToPKN5clang13CXXRecordDeclES2_")
//</editor-fold>
public static boolean MightInstantiateTo(/*const*/ CXXRecordDecl /*P*/ From, 
                  /*const*/ CXXRecordDecl /*P*/ To) {
  // Declaration names are always preserved by instantiation.
  if ($noteq_DeclarationName(From.getDeclName(), To.getDeclName())) {
    return false;
  }
  
  /*const*/ DeclContext /*P*/ FromDC = From.getDeclContext$Const().getPrimaryContext$Const();
  /*const*/ DeclContext /*P*/ ToDC = To.getDeclContext$Const().getPrimaryContext$Const();
  if (FromDC == ToDC) {
    return true;
  }
  if (FromDC.isFileContext() || ToDC.isFileContext()) {
    return false;
  }
  
  // Be conservative.
  return true;
}


/// Checks whether one class is derived from another, inclusively.
/// Properly indicates when it couldn't be determined due to
/// dependence.
///
/// This should probably be donated to AST or at least Sema.
//<editor-fold defaultstate="collapsed" desc="IsDerivedFromInclusive">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 279,
 FQN="IsDerivedFromInclusive", NM="_ZL22IsDerivedFromInclusivePKN5clang13CXXRecordDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL22IsDerivedFromInclusivePKN5clang13CXXRecordDeclES2_")
//</editor-fold>
public static AccessResult IsDerivedFromInclusive(/*const*/ CXXRecordDecl /*P*/ Derived, 
                      /*const*/ CXXRecordDecl /*P*/ Target) {
  assert (Derived.getCanonicalDecl$Const() == Derived);
  assert (Target.getCanonicalDecl$Const() == Target);
  if (Derived == Target) {
    return AccessResult.AR_accessible;
  }
  
  boolean CheckDependent = Derived.isDependentContext();
  if (CheckDependent && MightInstantiateTo(Derived, Target)) {
    return AccessResult.AR_dependent;
  }
  
  AccessResult OnFailure = AccessResult.AR_inaccessible;
  SmallVector</*const*/ CXXRecordDecl /*P*/ > Queue/*J*/= new SmallVector</*const*/ CXXRecordDecl /*P*/ >(8, (/*const*/ CXXRecordDecl /*P*/ )null); // actually a stack
  while (true) {
    if (Derived.isDependentContext() && !Derived.hasDefinition()
       && !Derived.isLambda()) {
      return AccessResult.AR_dependent;
    }
    
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : Derived.bases$Const()) {
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
            OnFailure = AccessResult.AR_dependent;
            continue;
          }
        }
      }
      
      RD = RD.getCanonicalDecl$Const();
      if (RD == Target) {
        return AccessResult.AR_accessible;
      }
      if (CheckDependent && MightInstantiateTo(RD, Target)) {
        OnFailure = AccessResult.AR_dependent;
      }
      
      Queue.push_back(RD);
    }
    if (Queue.empty()) {
      break;
    }
    
    Derived = Queue.pop_back_val();
  }
  
  return OnFailure;
}

//<editor-fold defaultstate="collapsed" desc="MightInstantiateTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 330,
 FQN="MightInstantiateTo", NM="_ZL18MightInstantiateToRN5clang4SemaEPNS_11DeclContextES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL18MightInstantiateToRN5clang4SemaEPNS_11DeclContextES3_")
//</editor-fold>
public static boolean MightInstantiateTo(final Sema /*&*/ S, DeclContext /*P*/ Context, 
                  DeclContext /*P*/ Friend) {
  if (Friend == Context) {
    return true;
  }
  assert (!Friend.isDependentContext()) : "can't handle friends with dependent contexts here";
  if (!Context.isDependentContext()) {
    return false;
  }
  if (Friend.isFileContext()) {
    return false;
  }
  
  // TODO: this is very conservative
  return true;
}


// Asks whether the type in 'context' can ever instantiate to the type
// in 'friend'.
//<editor-fold defaultstate="collapsed" desc="MightInstantiateTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 350,
 FQN="MightInstantiateTo", NM="_ZL18MightInstantiateToRN5clang4SemaENS_7CanQualINS_4TypeEEES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL18MightInstantiateToRN5clang4SemaENS_7CanQualINS_4TypeEEES4_")
//</editor-fold>
public static boolean MightInstantiateTo(final Sema /*&*/ S, CanQual<Type> Context, CanQual<Type> Friend) {
  if ($eq_CanQual$T_CanQual$U(/*NO_COPY*/Friend, /*NO_COPY*/Context)) {
    return true;
  }
  if (!((CanProxyType)Friend.$arrow()).$arrow().isDependentType() && !((CanProxyType)Context.$arrow()).$arrow().isDependentType()) {
    return false;
  }
  
  // TODO: this is very conservative.
  return true;
}

//<editor-fold defaultstate="collapsed" desc="MightInstantiateTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 361,
 FQN="MightInstantiateTo", NM="_ZL18MightInstantiateToRN5clang4SemaEPNS_12FunctionDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL18MightInstantiateToRN5clang4SemaEPNS_12FunctionDeclES3_")
//</editor-fold>
public static boolean MightInstantiateTo(final Sema /*&*/ S, 
                  FunctionDecl /*P*/ Context, 
                  FunctionDecl /*P*/ Friend) {
  if ($noteq_DeclarationName(Context.getDeclName(), Friend.getDeclName())) {
    return false;
  }
  if (!MightInstantiateTo(S, 
      Context.getDeclContext(), 
      Friend.getDeclContext())) {
    return false;
  }
  
  CanQual<FunctionProtoType> FriendTy = ((CanProxyFunctionProtoType)((CanProxyType)S.Context.getCanonicalType(Friend.getType()).$arrow()).$arrow().getAs(FunctionProtoType.class)).$CanQual$T();
  CanQual<FunctionProtoType> ContextTy = ((CanProxyFunctionProtoType)((CanProxyType)S.Context.getCanonicalType(Context.getType()).$arrow()).$arrow().getAs(FunctionProtoType.class)).$CanQual$T();
  
  // There isn't any way that I know of to add qualifiers
  // during instantiation.
  if (FriendTy.getQualifiers().$noteq(ContextTy.getQualifiers())) {
    return false;
  }
  if (((CanProxyFunctionProtoType)FriendTy.$arrow(FunctionProtoType.class)).$arrow().getNumParams() != ((CanProxyFunctionProtoType)ContextTy.$arrow(FunctionProtoType.class)).$arrow().getNumParams()) {
    return false;
  }
  if (!MightInstantiateTo(S, ((CanProxyFunctionProtoType)ContextTy.$arrow(FunctionProtoType.class)).$arrow().getReturnType(), 
      ((CanProxyFunctionProtoType)FriendTy.$arrow(FunctionProtoType.class)).$arrow().getReturnType())) {
    return false;
  }
  
  for (/*uint*/int I = 0, E = ((CanProxyFunctionProtoType)FriendTy.$arrow(FunctionProtoType.class)).$arrow().getNumParams(); I != E; ++I)  {
    if (!MightInstantiateTo(S, ((CanProxyFunctionProtoType)ContextTy.$arrow(FunctionProtoType.class)).$arrow().getParamType(I), 
        ((CanProxyFunctionProtoType)FriendTy.$arrow(FunctionProtoType.class)).$arrow().getParamType(I))) {
      return false;
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="MightInstantiateTo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 399,
 FQN="MightInstantiateTo", NM="_ZL18MightInstantiateToRN5clang4SemaEPNS_20FunctionTemplateDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL18MightInstantiateToRN5clang4SemaEPNS_20FunctionTemplateDeclES3_")
//</editor-fold>
public static boolean MightInstantiateTo(final Sema /*&*/ S, 
                  FunctionTemplateDecl /*P*/ Context, 
                  FunctionTemplateDecl /*P*/ Friend) {
  return MightInstantiateTo(S, 
      Context.getTemplatedDecl(), 
      Friend.getTemplatedDecl());
}

//<editor-fold defaultstate="collapsed" desc="MatchesFriend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 407,
 FQN="MatchesFriend", NM="_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static AccessResult MatchesFriend(final Sema /*&*/ S, 
             final /*const*/ EffectiveContext /*&*/ EC, 
             /*const*/ CXXRecordDecl /*P*/ Friend) {
  if (EC.includesClass(Friend)) {
    return AccessResult.AR_accessible;
  }
  if (EC.isDependent()) {
    for (/*const*/ CXXRecordDecl /*P*/ Context : EC.Records) {
      if (MightInstantiateTo(Context, Friend)) {
        return AccessResult.AR_dependent;
      }
    }
  }
  
  return AccessResult.AR_inaccessible;
}

//<editor-fold defaultstate="collapsed" desc="MatchesFriend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 423,
 FQN="MatchesFriend", NM="_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_7CanQualINS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_7CanQualINS_4TypeEEE")
//</editor-fold>
public static AccessResult MatchesFriend(final Sema /*&*/ S, 
             final /*const*/ EffectiveContext /*&*/ EC, 
             CanQual<Type> Friend) {
  {
    /*const*/ RecordType /*P*/ RT = ((CanProxyRecordType)((CanProxyType)Friend.$arrow()).$arrow().getAs(RecordType.class)).$T$C$P();
    if ((RT != null)) {
      return MatchesFriend(S, EC, cast_CXXRecordDecl(RT.getDecl()));
    }
  }
  
  // TODO: we can do better than this
  if (((CanProxyType)Friend.$arrow()).$arrow().isDependentType()) {
    return AccessResult.AR_dependent;
  }
  
  return AccessResult.AR_inaccessible;
}


/// Determines whether the given friend class template matches
/// anything in the effective context.
//<editor-fold defaultstate="collapsed" desc="MatchesFriend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 438,
 FQN="MatchesFriend", NM="_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_17ClassTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_17ClassTemplateDeclE")
//</editor-fold>
public static AccessResult MatchesFriend(final Sema /*&*/ S, 
             final /*const*/ EffectiveContext /*&*/ EC, 
             ClassTemplateDecl /*P*/ Friend) {
  AccessResult OnFailure = AccessResult.AR_inaccessible;
  
  // Check whether the friend is the template of a class in the
  // context chain.
  for (type$ptr<CXXRecordDecl /*P*/ /*P*/> I = $tryClone(EC.Records.begin$Const()), /*P*/ E = $tryClone(EC.Records.end$Const()); $noteq_iter(I, E); I.$preInc()) {
    CXXRecordDecl /*P*/ Record = I.$star();
    
    // Figure out whether the current class has a template:
    ClassTemplateDecl /*P*/ CTD;
    
    // A specialization of the template...
    if (isa_ClassTemplateSpecializationDecl(Record)) {
      CTD = cast_ClassTemplateSpecializationDecl(Record).
          getSpecializedTemplate();
      // ... or the template pattern itself.
    } else {
      CTD = Record.getDescribedClassTemplate();
      if (!(CTD != null)) {
        continue;
      }
    }
    
    // It's a match.
    if (Friend == CTD.getCanonicalDecl()) {
      return AccessResult.AR_accessible;
    }
    
    // If the context isn't dependent, it can't be a dependent match.
    if (!EC.isDependent()) {
      continue;
    }
    
    // If the template names don't match, it can't be a dependent
    // match.
    if ($noteq_DeclarationName(CTD.getDeclName(), Friend.getDeclName())) {
      continue;
    }
    
    // If the class's context can't instantiate to the friend's
    // context, it can't be a dependent match.
    if (!MightInstantiateTo(S, CTD.getDeclContext(), 
        Friend.getDeclContext())) {
      continue;
    }
    
    // Otherwise, it's a dependent match.
    OnFailure = AccessResult.AR_dependent;
  }
  
  return OnFailure;
}


/// Determines whether the given friend function matches anything in
/// the effective context.
//<editor-fold defaultstate="collapsed" desc="MatchesFriend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 491,
 FQN="MatchesFriend", NM="_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_12FunctionDeclE")
//</editor-fold>
public static AccessResult MatchesFriend(final Sema /*&*/ S, 
             final /*const*/ EffectiveContext /*&*/ EC, 
             FunctionDecl /*P*/ Friend) {
  AccessResult OnFailure = AccessResult.AR_inaccessible;
  
  for (type$ptr<FunctionDecl /*P*/ /*P*/> I = $tryClone(EC.Functions.begin$Const()), /*P*/ E = $tryClone(EC.Functions.end$Const()); $noteq_iter(I, E); I.$preInc()) {
    if (Friend == I.$star()) {
      return AccessResult.AR_accessible;
    }
    if (EC.isDependent() && MightInstantiateTo(S, I.$star(), Friend)) {
      OnFailure = AccessResult.AR_dependent;
    }
  }
  
  return OnFailure;
}


/// Determines whether the given friend function template matches
/// anything in the effective context.
//<editor-fold defaultstate="collapsed" desc="MatchesFriend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 510,
 FQN="MatchesFriend", NM="_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_20FunctionTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_20FunctionTemplateDeclE")
//</editor-fold>
public static AccessResult MatchesFriend(final Sema /*&*/ S, 
             final /*const*/ EffectiveContext /*&*/ EC, 
             FunctionTemplateDecl /*P*/ Friend) {
  if (EC.Functions.empty()) {
    return AccessResult.AR_inaccessible;
  }
  
  AccessResult OnFailure = AccessResult.AR_inaccessible;
  
  for (type$ptr<FunctionDecl /*P*/ /*P*/> I = $tryClone(EC.Functions.begin$Const()), /*P*/ E = $tryClone(EC.Functions.end$Const()); $noteq_iter(I, E); I.$preInc()) {
    
    FunctionTemplateDecl /*P*/ FTD = (I.$star()).getPrimaryTemplate();
    if (!(FTD != null)) {
      FTD = (I.$star()).getDescribedFunctionTemplate();
    }
    if (!(FTD != null)) {
      continue;
    }
    
    FTD = FTD.getCanonicalDecl();
    if (Friend == FTD) {
      return AccessResult.AR_accessible;
    }
    if (EC.isDependent() && MightInstantiateTo(S, FTD, Friend)) {
      OnFailure = AccessResult.AR_dependent;
    }
  }
  
  return OnFailure;
}


/// Determines whether the given friend declaration matches anything
/// in the effective context.
//<editor-fold defaultstate="collapsed" desc="MatchesFriend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 540,
 FQN="MatchesFriend", NM="_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_10FriendDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL13MatchesFriendRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPNS_10FriendDeclE")
//</editor-fold>
public static AccessResult MatchesFriend(final Sema /*&*/ S, 
             final /*const*/ EffectiveContext /*&*/ EC, 
             FriendDecl /*P*/ FriendD) {
  // Whitelist accesses if there's an invalid or unsupported friend
  // declaration.
  if (FriendD.isInvalidDecl() || FriendD.isUnsupportedFriend()) {
    return AccessResult.AR_accessible;
  }
  {
    
    TypeSourceInfo /*P*/ T = FriendD.getFriendType();
    if ((T != null)) {
      return MatchesFriend(S, EC, T.getType().$arrow().getCanonicalTypeUnqualified());
    }
  }
  
  NamedDecl /*P*/ Friend = cast_NamedDecl(FriendD.getFriendDecl().getCanonicalDecl());
  
  // FIXME: declarations with dependent or templated scope.
  if (isa_ClassTemplateDecl(Friend)) {
    return MatchesFriend(S, EC, cast_ClassTemplateDecl(Friend));
  }
  if (isa_FunctionTemplateDecl(Friend)) {
    return MatchesFriend(S, EC, cast_FunctionTemplateDecl(Friend));
  }
  if (isa_CXXRecordDecl(Friend)) {
    return MatchesFriend(S, EC, cast_CXXRecordDecl(Friend));
  }
  assert (isa_FunctionDecl(Friend)) : "unknown friend decl kind";
  return MatchesFriend(S, EC, cast_FunctionDecl(Friend));
}

//<editor-fold defaultstate="collapsed" desc="GetFriendKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 569,
 FQN="GetFriendKind", NM="_ZL13GetFriendKindRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL13GetFriendKindRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static AccessResult GetFriendKind(final Sema /*&*/ S, 
             final /*const*/ EffectiveContext /*&*/ EC, 
             /*const*/ CXXRecordDecl /*P*/ Class) {
  AccessResult OnFailure = AccessResult.AR_inaccessible;
  
  // Okay, check friends.
  for (FriendDecl /*P*/ Friend : Class.friends()) {
    switch (MatchesFriend(S, EC, Friend)) {
     case AR_accessible:
      return AccessResult.AR_accessible;
     case AR_inaccessible:
      continue;
     case AR_dependent:
      OnFailure = AccessResult.AR_dependent;
      break;
    }
  }
  
  // That's it, give up.
  return OnFailure;
}


/// Search for a class P that EC is a friend of, under the constraint
///   InstanceContext <= P
/// if InstanceContext exists, or else
///   NamingClass <= P
/// and with the additional restriction that a protected member of
/// NamingClass would have some natural access in P, which implicitly
/// imposes the constraint that P <= NamingClass.
///
/// This isn't quite the condition laid out in the standard.
/// Instead of saying that a notional protected member of NamingClass
/// would have to have some natural access in P, it says the actual
/// target has to have some natural access in P, which opens up the
/// possibility that the target (which is not necessarily a member
/// of NamingClass) might be more accessible along some path not
/// passing through it.  That's really a bad idea, though, because it
/// introduces two problems:
///   - Most importantly, it breaks encapsulation because you can
///     access a forbidden base class's members by directly subclassing
///     it elsewhere.
///   - It also makes access substantially harder to compute because it
///     breaks the hill-climbing algorithm: knowing that the target is
///     accessible in some base class would no longer let you change
///     the question solely to whether the base class is accessible,
///     because the original target might have been more accessible
///     because of crazy subclassing.
/// So we don't implement that.
//<editor-fold defaultstate="collapsed" desc="GetProtectedFriendKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 710,
 FQN="GetProtectedFriendKind", NM="_ZL22GetProtectedFriendKindRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL22GetProtectedFriendKindRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclES8_")
//</editor-fold>
public static AccessResult GetProtectedFriendKind(final Sema /*&*/ S, final /*const*/ EffectiveContext /*&*/ EC, 
                      /*const*/ CXXRecordDecl /*P*/ InstanceContext, 
                      /*const*/ CXXRecordDecl /*P*/ NamingClass) {
  ProtectedFriendContext PRC = null;
  try {
    assert (InstanceContext == null || InstanceContext.getCanonicalDecl$Const() == InstanceContext);
    assert (NamingClass.getCanonicalDecl$Const() == NamingClass);
    
    // If we don't have an instance context, our constraints give us
    // that NamingClass <= P <= NamingClass, i.e. P == NamingClass.
    // This is just the usual friendship check.
    if (!(InstanceContext != null)) {
      return GetFriendKind(S, EC, NamingClass);
    }
    
    PRC/*J*/= new ProtectedFriendContext(S, EC, InstanceContext, NamingClass);
    if (PRC.findFriendship(InstanceContext)) {
      return AccessResult.AR_accessible;
    }
    if (PRC.EverDependent) {
      return AccessResult.AR_dependent;
    }
    return AccessResult.AR_inaccessible;
  } finally {
    if (PRC != null) { PRC.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="HasAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 728,
 FQN="HasAccess", NM="_ZL9HasAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclENS_15AccessSpecifierERKNS2_12AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL9HasAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextEPKNS_13CXXRecordDeclENS_15AccessSpecifierERKNS2_12AccessTargetE")
//</editor-fold>
public static AccessResult HasAccess(final Sema /*&*/ S, 
         final /*const*/ EffectiveContext /*&*/ EC, 
         /*const*/ CXXRecordDecl /*P*/ NamingClass, 
         AccessSpecifier Access, 
         final /*const*/ AccessTarget /*&*/ Target) {
  assert (NamingClass.getCanonicalDecl$Const() == NamingClass) : "declaration should be canonicalized before being passed here";
  if (Access == AccessSpecifier.AS_public) {
    return AccessResult.AR_accessible;
  }
  assert (Access == AccessSpecifier.AS_private || Access == AccessSpecifier.AS_protected);
  
  AccessResult OnFailure = AccessResult.AR_inaccessible;
  
  for (type$ptr<CXXRecordDecl /*P*/ /*P*/> I = $tryClone(EC.Records.begin$Const()), /*P*/ E = $tryClone(EC.Records.end$Const()); $noteq_iter(I, E); I.$preInc()) {
    // All the declarations in EC have been canonicalized, so pointer
    // equality from this point on will work fine.
    /*const*/ CXXRecordDecl /*P*/ ECRecord = I.$star();
    
    // [B2] and [M2]
    if (Access == AccessSpecifier.AS_private) {
      if (ECRecord == NamingClass) {
        return AccessResult.AR_accessible;
      }
      if (EC.isDependent() && MightInstantiateTo(ECRecord, NamingClass)) {
        OnFailure = AccessResult.AR_dependent;
      }
      // [B3] and [M3]
    } else {
      assert (Access == AccessSpecifier.AS_protected);
      switch (IsDerivedFromInclusive(ECRecord, NamingClass)) {
       case AR_accessible:
        break;
       case AR_inaccessible:
        continue;
       case AR_dependent:
        OnFailure = AccessResult.AR_dependent;
        continue;
      }
      
      // C++ [class.protected]p1:
      //   An additional access check beyond those described earlier in
      //   [class.access] is applied when a non-static data member or
      //   non-static member function is a protected member of its naming
      //   class.  As described earlier, access to a protected member is
      //   granted because the reference occurs in a friend or member of
      //   some class C.  If the access is to form a pointer to member,
      //   the nested-name-specifier shall name C or a class derived from
      //   C. All other accesses involve a (possibly implicit) object
      //   expression. In this case, the class of the object expression
      //   shall be C or a class derived from C.
      //
      // We interpret this as a restriction on [M3].
      
      // In this part of the code, 'C' is just our context class ECRecord.
      
      // These rules are different if we don't have an instance context.
      if (!Target.hasInstanceContext()) {
        // If it's not an instance member, these restrictions don't apply.
        if (!Target.isInstanceMember()) {
          return AccessResult.AR_accessible;
        }
        
        // If it's an instance member, use the pointer-to-member rule
        // that the naming class has to be derived from the effective
        // context.
        
        // Emulate a MSVC bug where the creation of pointer-to-member
        // to protected member of base class is allowed but only from
        // static member functions.
        if (S.getLangOpts().MSVCCompat && !EC.Functions.empty()) {
          {
            CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(EC.Functions.front$Const());
            if ((MD != null)) {
              if (MD.isStatic()) {
                return AccessResult.AR_accessible;
              }
            }
          }
        }
        
        // Despite the standard's confident wording, there is a case
        // where you can have an instance member that's neither in a
        // pointer-to-member expression nor in a member access:  when
        // it names a field in an unevaluated context that can't be an
        // implicit member.  Pending clarification, we just apply the
        // same naming-class restriction here.
        //   FIXME: we're probably not correctly adding the
        //   protected-member restriction when we retroactively convert
        //   an expression to being evaluated.
        
        // We know that ECRecord derives from NamingClass.  The
        // restriction says to check whether NamingClass derives from
        // ECRecord, but that's not really necessary: two distinct
        // classes can't be recursively derived from each other.  So
        // along this path, we just need to check whether the classes
        // are equal.
        if (NamingClass == ECRecord) {
          return AccessResult.AR_accessible;
        }
        
        // Otherwise, this context class tells us nothing;  on to the next.
        continue;
      }
      assert (Target.isInstanceMember());
      
      /*const*/ CXXRecordDecl /*P*/ InstanceContext = Target.resolveInstanceContext(S);
      if (!(InstanceContext != null)) {
        OnFailure = AccessResult.AR_dependent;
        continue;
      }
      switch (IsDerivedFromInclusive(InstanceContext, ECRecord)) {
       case AR_accessible:
        return AccessResult.AR_accessible;
       case AR_inaccessible:
        continue;
       case AR_dependent:
        OnFailure = AccessResult.AR_dependent;
        continue;
      }
    }
  }
  
  // [M3] and [B3] say that, if the target is protected in N, we grant
  // access if the access occurs in a friend or member of some class P
  // that's a subclass of N and where the target has some natural
  // access in P.  The 'member' aspect is easy to handle because P
  // would necessarily be one of the effective-context records, and we
  // address that above.  The 'friend' aspect is completely ridiculous
  // to implement because there are no restrictions at all on P
  // *unless* the [class.protected] restriction applies.  If it does,
  // however, we should ignore whether the naming class is a friend,
  // and instead rely on whether any potential P is a friend.
  if (Access == AccessSpecifier.AS_protected && Target.isInstanceMember()) {
    // Compute the instance context if possible.
    /*const*/ CXXRecordDecl /*P*/ InstanceContext = null;
    if (Target.hasInstanceContext()) {
      InstanceContext = Target.resolveInstanceContext(S);
      if (!(InstanceContext != null)) {
        return AccessResult.AR_dependent;
      }
    }
    switch (GetProtectedFriendKind(S, EC, InstanceContext, NamingClass)) {
     case AR_accessible:
      return AccessResult.AR_accessible;
     case AR_inaccessible:
      return OnFailure;
     case AR_dependent:
      return AccessResult.AR_dependent;
    }
    throw new llvm_unreachable("impossible friendship kind");
  }
  switch (GetFriendKind(S, EC, NamingClass)) {
   case AR_accessible:
    return AccessResult.AR_accessible;
   case AR_inaccessible:
    return OnFailure;
   case AR_dependent:
    return AccessResult.AR_dependent;
  }
  
  // Silence bogus warnings
  throw new llvm_unreachable("impossible friendship kind");
}


/// Finds the best path from the naming class to the declaring class,
/// taking friend declarations into account.
///
/// C++0x [class.access.base]p5:
///   A member m is accessible at the point R when named in class N if
///   [M1] m as a member of N is public, or
///   [M2] m as a member of N is private, and R occurs in a member or
///        friend of class N, or
///   [M3] m as a member of N is protected, and R occurs in a member or
///        friend of class N, or in a member or friend of a class P
///        derived from N, where m as a member of P is public, private,
///        or protected, or
///   [M4] there exists a base class B of N that is accessible at R, and
///        m is accessible at R when named in class B.
///
/// C++0x [class.access.base]p4:
///   A base class B of N is accessible at R, if
///   [B1] an invented public member of B would be a public member of N, or
///   [B2] R occurs in a member or friend of class N, and an invented public
///        member of B would be a private or protected member of N, or
///   [B3] R occurs in a member or friend of a class P derived from N, and an
///        invented public member of B would be a private or protected member
///        of P, or
///   [B4] there exists a class S such that B is a base class of S accessible
///        at R and S is a base class of N accessible at R.
///
/// Along a single inheritance path we can restate both of these
/// iteratively:
///
/// First, we note that M1-4 are equivalent to B1-4 if the member is
/// treated as a notional base of its declaring class with inheritance
/// access equivalent to the member's access.  Therefore we need only
/// ask whether a class B is accessible from a class N in context R.
///
/// Let B_1 .. B_n be the inheritance path in question (i.e. where
/// B_1 = N, B_n = B, and for all i, B_{i+1} is a direct base class of
/// B_i).  For i in 1..n, we will calculate ACAB(i), the access to the
/// closest accessible base in the path:
///   Access(a, b) = (* access on the base specifier from a to b *)
///   Merge(a, forbidden) = forbidden
///   Merge(a, private) = forbidden
///   Merge(a, b) = min(a,b)
///   Accessible(c, forbidden) = false
///   Accessible(c, private) = (R is c) || IsFriend(c, R)
///   Accessible(c, protected) = (R derived from c) || IsFriend(c, R)
///   Accessible(c, public) = true
///   ACAB(n) = public
///   ACAB(i) =
///     let AccessToBase = Merge(Access(B_i, B_{i+1}), ACAB(i+1)) in
///     if Accessible(B_i, AccessToBase) then public else AccessToBase
///
/// B is an accessible base of N at R iff ACAB(1) = public.
///
/// \param FinalAccess the access of the "final step", or AS_public if
///   there is no final step.
/// \return null if friendship is dependent
//<editor-fold defaultstate="collapsed" desc="FindBestPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 926,
 FQN="FindBestPath", NM="_ZL12FindBestPathRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetENS_15AccessSpecifierERNS_12CXXBasePathsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL12FindBestPathRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetENS_15AccessSpecifierERNS_12CXXBasePathsE")
//</editor-fold>
public static CXXBasePath /*P*/ FindBestPath(final Sema /*&*/ S, 
            final /*const*/ EffectiveContext /*&*/ EC, 
            final AccessTarget /*&*/ Target, 
            AccessSpecifier FinalAccess, 
            final CXXBasePaths /*&*/ Paths) {
  // Derive the paths to the desired base.
  /*const*/ CXXRecordDecl /*P*/ Derived = Target.getNamingClass();
  /*const*/ CXXRecordDecl /*P*/ Base = Target.getDeclaringClass();
  
  // FIXME: fail correctly when there are dependent paths.
  boolean isDerived = Derived.isDerivedFrom(((/*const_cast*/CXXRecordDecl /*P*/ )(Base)), 
      Paths);
  assert (isDerived) : "derived class not actually derived from base";
  //(void)isDerived;
  
  CXXBasePath /*P*/ BestPath = null;
  assert (FinalAccess != AccessSpecifier.AS_none) : "forbidden access after declaring class";
  
  boolean AnyDependent = false;
  
  // Derive the friend-modified access along each path.
  Next:for (std.list.iterator<CXXBasePath> PI = Paths.begin(), PE = Paths.end();
       PI.$noteq(PE); PI.$preInc()) {
    AccessTarget.SavedInstanceContext _ = null;
    try {
      _ = Target.saveInstanceContext();
      
      // Walk through the path backwards.
      AccessSpecifier PathAccess = FinalAccess;
      type$ptr<CXXBasePathElement> I = $tryClone(PI.$arrow().end()), /*P*/ E = $tryClone(PI.$arrow().begin());
      while ($noteq_ptr(I, E)) {
        I.$preDec();
        assert (PathAccess != AccessSpecifier.AS_none);
        
        // If the declaration is a private member of a base class, there
        // is no level of friendship in derived classes that can make it
        // accessible.
        if (PathAccess == AccessSpecifier.AS_private) {
          PathAccess = AccessSpecifier.AS_none;
          break;
        }
        
        /*const*/ CXXRecordDecl /*P*/ NC = I./*->*/$star().Class.getCanonicalDecl$Const();
        
        AccessSpecifier BaseAccess = I./*->*/$star().Base.getAccessSpecifier();
        PathAccess = std.max(PathAccess, BaseAccess);
        switch (HasAccess(S, EC, NC, PathAccess, Target)) {
         case AR_inaccessible:
          break;
         case AR_accessible:
          PathAccess = AccessSpecifier.AS_public;
          
          // Future tests are not against members and so do not have
          // instance context.
          Target.suppressInstanceContext();
          break;
         case AR_dependent:
          AnyDependent = true;
          continue Next;
        }
      }
      
      // Note that we modify the path's Access field to the
      // friend-modified access.
      if (BestPath == null || PathAccess.getValue() < BestPath.Access.getValue()) {
        BestPath = $AddrOf(PI.$star());
        BestPath.Access = PathAccess;
        
        // Short-circuit if we found a public path.
        if (BestPath.Access == AccessSpecifier.AS_public) {
          return BestPath;
        }
      }
    } finally {
      if (_ != null) { _.$destroy(); }
    }
  }
  assert ((!(BestPath != null) || BestPath.Access != AccessSpecifier.AS_public)) : "fell out of loop with public path";
  
  // We didn't find a public path, but at least one path was subject
  // to dependent friendship, so delay the check.
  if (AnyDependent) {
    return null;
  }
  
  return BestPath;
}


/// Given that an entity has protected natural access, check whether
/// access might be denied because of the protected member access
/// restriction.
///
/// \return true if a note was emitted
//<editor-fold defaultstate="collapsed" desc="TryDiagnoseProtectedAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1018,
 FQN="TryDiagnoseProtectedAccess", NM="_ZL26TryDiagnoseProtectedAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL26TryDiagnoseProtectedAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE")
//</editor-fold>
public static boolean TryDiagnoseProtectedAccess(final Sema /*&*/ S, final /*const*/ EffectiveContext /*&*/ EC, 
                          final AccessTarget /*&*/ Target) {
  // Only applies to instance accesses.
  if (!Target.isInstanceMember()) {
    return false;
  }
  assert (Target.isMemberAccess());
  
  /*const*/ CXXRecordDecl /*P*/ NamingClass = Target.getEffectiveNamingClass();
  
  for (type$ptr<CXXRecordDecl /*P*/ /*P*/> I = $tryClone(EC.Records.begin$Const()), /*P*/ E = $tryClone(EC.Records.end$Const()); $noteq_iter(I, E); I.$preInc()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ CXXRecordDecl /*P*/ ECRecord = I.$star();
      switch (IsDerivedFromInclusive(ECRecord, NamingClass)) {
       case AR_accessible:
        break;
       case AR_inaccessible:
        continue;
       case AR_dependent:
        continue;
      }
      
      // The effective context is a subclass of the declaring class.
      // Check whether the [class.protected] restriction is limiting
      // access.
      
      // To get this exactly right, this might need to be checked more
      // holistically;  it's not necessarily the case that gaining
      // access here would grant us access overall.
      NamedDecl /*P*/ D = Target.getTargetDecl();
      
      // If we don't have an instance context, [class.protected] says the
      // naming class has to equal the context class.
      if (!Target.hasInstanceContext()) {
        // If it does, the restriction doesn't apply.
        if (NamingClass == ECRecord) {
          continue;
        }
        
        // TODO: it would be great to have a fixit here, since this is
        // such an obvious error.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocation(), diag.note_access_protected_restricted_noobject)), 
            S.Context.getTypeDeclType(ECRecord)));
        return true;
      }
      
      /*const*/ CXXRecordDecl /*P*/ InstanceContext = Target.resolveInstanceContext(S);
      assert ((InstanceContext != null)) : "diagnosing dependent access";
      switch (IsDerivedFromInclusive(InstanceContext, ECRecord)) {
       case AR_accessible:
        continue;
       case AR_dependent:
        continue;
       case AR_inaccessible:
        break;
      }
      
      // Okay, the restriction seems to be what's limiting us.
      
      // Use a special diagnostic for constructors and destructors.
      if (isa_CXXConstructorDecl(D) || isa_CXXDestructorDecl(D)
         || (isa_FunctionTemplateDecl(D)
         && isa_CXXConstructorDecl(cast_FunctionTemplateDecl(D).getTemplatedDecl()))) {
        return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocation(), 
                diag.note_access_protected_restricted_ctordtor)), 
            isa_CXXDestructorDecl(D.getAsFunction())).$bool());
      }
      
      // Otherwise, use the generic diagnostic.
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocation(), 
              diag.note_access_protected_restricted_object)), 
          S.Context.getTypeDeclType(ECRecord)).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// We are unable to access a given declaration due to its direct
/// access control;  diagnose that.
//<editor-fold defaultstate="collapsed" desc="diagnoseBadDirectAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1093,
 FQN="diagnoseBadDirectAccess", NM="_ZL23diagnoseBadDirectAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL23diagnoseBadDirectAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE")
//</editor-fold>
public static void diagnoseBadDirectAccess(final Sema /*&*/ S, 
                       final /*const*/ EffectiveContext /*&*/ EC, 
                       final AccessTarget /*&*/ entity) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (entity.isMemberAccess());
    NamedDecl /*P*/ D = entity.getTargetDecl();
    if (D.getAccess() == AccessSpecifier.AS_protected
       && TryDiagnoseProtectedAccess(S, EC, entity)) {
      return;
    }
    
    // Find an original declaration.
    while (D.isOutOfLine()) {
      NamedDecl /*P*/ PrevDecl = null;
      {
        VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
        if ((VD != null)) {
          PrevDecl = VD.getPreviousDecl();
        } else {
          FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
          if ((FD != null)) {
            PrevDecl = FD.getPreviousDecl();
          } else {
            TypedefNameDecl /*P*/ TND = dyn_cast_TypedefNameDecl(D);
            if ((TND != null)) {
              PrevDecl = TND.getPreviousDecl();
            } else {
              TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
              if ((TD != null)) {
                if (isa_RecordDecl(D) && cast_RecordDecl(D).isInjectedClassName()) {
                  break;
                }
                PrevDecl = TD.getPreviousDecl();
              }
            }
          }
        }
      }
      if (!(PrevDecl != null)) {
        break;
      }
      D = PrevDecl;
    }
    
    CXXRecordDecl /*P*/ DeclaringClass = FindDeclaringClass(D);
    Decl /*P*/ ImmediateChild;
    if (D.getDeclContext() == DeclaringClass) {
      ImmediateChild = D;
    } else {
      DeclContext /*P*/ DC = D.getDeclContext();
      while (DC.getParent() != DeclaringClass) {
        DC = DC.getParent();
      }
      ImmediateChild = cast_Decl(DC);
    }
    
    // Check whether there's an AccessSpecDecl preceding this in the
    // chain of the DeclContext.
    boolean isImplicit = true;
    for (/*const*/ Decl /*P*/ I : DeclaringClass.decls()) {
      if (I == ImmediateChild) {
        break;
      }
      if (isa_AccessSpecDecl(I)) {
        isImplicit = false;
        break;
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getLocation(), diag.note_access_natural)), 
            (/*uint*/int)((D.getAccess() == AccessSpecifier.AS_protected) ? 1 : 0)), 
        isImplicit));
  } finally {
    $c$.$destroy();
  }
}


/// Diagnose the path which caused the given declaration or base class
/// to become inaccessible.
//<editor-fold defaultstate="collapsed" desc="DiagnoseAccessPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1150,
 FQN="DiagnoseAccessPath", NM="_ZL18DiagnoseAccessPathRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL18DiagnoseAccessPathRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE")
//</editor-fold>
public static void DiagnoseAccessPath(final Sema /*&*/ S, 
                  final /*const*/ EffectiveContext /*&*/ EC, 
                  final AccessTarget /*&*/ entity) {
  AccessTarget.SavedInstanceContext _ = null;
  CXXBasePaths paths = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Save the instance context to preserve invariants.
    _ = entity.saveInstanceContext();
    
    // This basically repeats the main algorithm but keeps some more
    // information.
    
    // The natural access so far.
    AccessSpecifier accessSoFar = AccessSpecifier.AS_public;
    
    // Check whether we have special rights to the declaring class.
    if (entity.isMemberAccess()) {
      NamedDecl /*P*/ D = entity.getTargetDecl();
      accessSoFar = D.getAccess();
      /*const*/ CXXRecordDecl /*P*/ declaringClass = entity.getDeclaringClass();
      switch (HasAccess(S, EC, declaringClass, accessSoFar, entity)) {
       case AR_accessible:
        // If the declaration is accessible when named in its declaring
        // class, then we must be constrained by the path.
        accessSoFar = AccessSpecifier.AS_public;
        entity.suppressInstanceContext();
        break;
       case AR_inaccessible:
        if (accessSoFar == AccessSpecifier.AS_private
           || declaringClass == entity.getEffectiveNamingClass()) {
          diagnoseBadDirectAccess(S, EC, entity);
          return;
        }
        break;
       case AR_dependent:
        throw new llvm_unreachable("cannot diagnose dependent access");
      }
    }
    
    paths/*J*/= new CXXBasePaths();
    final CXXBasePath /*&*/ path = $Deref(FindBestPath(S, EC, entity, accessSoFar, paths));
    assert (path.Access != AccessSpecifier.AS_public);

    type$ptr<CXXBasePathElement> i = $tryClone(path.end()), /*P*/ e = $tryClone(path.begin());
    type$ptr<CXXBasePathElement> constrainingBase = $tryClone(i);
    while ($noteq_ptr(i, e)) {
      i.$preDec();
      assert (accessSoFar != AccessSpecifier.AS_none && accessSoFar != AccessSpecifier.AS_private);
      
      // Is the entity accessible when named in the deriving class, as
      // modified by the base specifier?
      /*const*/ CXXRecordDecl /*P*/ derivingClass = i./*->*/$star().Class.getCanonicalDecl$Const();
      /*const*/ CXXBaseSpecifier /*P*/ base = i./*->*/$star().Base;
      
      // If the access to this base is worse than the access we have to
      // the declaration, remember it.
      AccessSpecifier baseAccess = base.getAccessSpecifier();
      if (baseAccess.getValue() > accessSoFar.getValue()) {
        constrainingBase = $tryClone(i);
        accessSoFar = baseAccess;
      }
      switch (HasAccess(S, EC, derivingClass, accessSoFar, entity)) {
       case AR_inaccessible:
        break;
       case AR_accessible:
        accessSoFar = AccessSpecifier.AS_public;
        entity.suppressInstanceContext();
        constrainingBase = null;
        break;
       case AR_dependent:
        throw new llvm_unreachable("cannot diagnose dependent access");
      }
      
      // If this was private inheritance, but we don't have access to
      // the deriving class, we're done.
      if (accessSoFar == AccessSpecifier.AS_private) {
        assert (baseAccess == AccessSpecifier.AS_private);
        assert ($eq_ptr(constrainingBase, i));
        break;
      }
    }
    
    // If we don't have a constraining base, the access failure must be
    // due to the original declaration.
    if ($eq_ptr(constrainingBase, path.end())) {
      diagnoseBadDirectAccess(S, EC, entity);
      return;
    }
    
    // We're constrained by inheritance, but we want to say
    // "declared private here" if we're diagnosing a hierarchy
    // conversion and this is the final step.
    /*uint*/int diagnostic;
    if (entity.isMemberAccess()
       || $noteq_ptr(constrainingBase.$add(1), path.end())) {
      diagnostic = diag.note_access_constrained_by_path;
    } else {
      diagnostic = diag.note_access_natural;
    }
    
    /*const*/ CXXBaseSpecifier /*P*/ base = constrainingBase./*->*/$star().Base;
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(base.getSourceRange().getBegin(), diagnostic)), 
                base.getSourceRange()), 
            (base.getAccessSpecifier() == AccessSpecifier.AS_protected)), 
        (base.getAccessSpecifierAsWritten() == AccessSpecifier.AS_none)));
    if (entity.isMemberAccess()) {
      $c$.clean($c$.track(S.Diag(entity.getTargetDecl().getLocation(), 
          diag.note_member_declared_at)));
    }
  } finally {
    if (paths != null) { paths.$destroy(); }
    if (_ != null) { _.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseBadAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1259,
 FQN="DiagnoseBadAccess", NM="_ZL17DiagnoseBadAccessRN5clang4SemaENS_14SourceLocationERKN12_GLOBAL__N_116EffectiveContextERNS3_12AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL17DiagnoseBadAccessRN5clang4SemaENS_14SourceLocationERKN12_GLOBAL__N_116EffectiveContextERNS3_12AccessTargetE")
//</editor-fold>
public static void DiagnoseBadAccess(final Sema /*&*/ S, SourceLocation Loc, 
                 final /*const*/ EffectiveContext /*&*/ EC, 
                 final AccessTarget /*&*/ Entity) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ CXXRecordDecl /*P*/ NamingClass = Entity.getNamingClass();
    /*const*/ CXXRecordDecl /*P*/ DeclaringClass = Entity.getDeclaringClass();
    NamedDecl /*P*/ D = (Entity.isMemberAccess() ? Entity.getTargetDecl() : null);
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), Entity.getDiag())), 
                    (Entity.getAccess() == AccessSpecifier.AS_protected)), 
                ((D != null) ? D.getDeclName() : new DeclarationName())), 
            S.Context.getTypeDeclType(NamingClass)), 
        S.Context.getTypeDeclType(DeclaringClass)));
    DiagnoseAccessPath(S, EC, Entity);
  } finally {
    $c$.$destroy();
  }
}


/// MSVC has a bug where if during an using declaration name lookup, 
/// the declaration found is unaccessible (private) and that declaration 
/// was bring into scope via another using declaration whose target
/// declaration is accessible (public) then no error is generated.
/// Example:
///   class A {
///   public:
///     int f();
///   };
///   class B : public A {
///   private:
///     using A::f;
///   };
///   class C : public B {
///   private:
///     using B::f;
///   };
///
/// Here, B::f is private so this should fail in Standard C++, but 
/// because B::f refers to A::f which is public MSVC accepts it.
//<editor-fold defaultstate="collapsed" desc="IsMicrosoftUsingDeclarationAccessBug">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1294,
 FQN="IsMicrosoftUsingDeclarationAccessBug", NM="_ZL36IsMicrosoftUsingDeclarationAccessBugRN5clang4SemaENS_14SourceLocationERN12_GLOBAL__N_112AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL36IsMicrosoftUsingDeclarationAccessBugRN5clang4SemaENS_14SourceLocationERN12_GLOBAL__N_112AccessTargetE")
//</editor-fold>
public static boolean IsMicrosoftUsingDeclarationAccessBug(final Sema /*&*/ S, 
                                    SourceLocation AccessLoc, 
                                    final AccessTarget /*&*/ Entity) {
  {
    UsingShadowDecl /*P*/ Shadow = dyn_cast_UsingShadowDecl(Entity.getTargetDecl());
    if ((Shadow != null)) {
      /*const*/ NamedDecl /*P*/ OrigDecl = Entity.getTargetDecl().getUnderlyingDecl();
      if (Entity.getTargetDecl().getAccess() == AccessSpecifier.AS_private
         && (OrigDecl.getAccess() == AccessSpecifier.AS_public
         || OrigDecl.getAccess() == AccessSpecifier.AS_protected)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AccessLoc), diag.ext_ms_using_declaration_inaccessible)), 
                  Shadow.getUsingDecl().getQualifiedNameAsString()), 
              OrigDecl.getQualifiedNameAsString()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  return false;
}


/// Determines whether the accessed entity is accessible.  Public members
/// have been weeded out by this point.
//<editor-fold defaultstate="collapsed" desc="IsAccessible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1314,
 FQN="IsAccessible", NM="_ZL12IsAccessibleRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL12IsAccessibleRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextERNS2_12AccessTargetE")
//</editor-fold>
public static AccessResult IsAccessible(final Sema /*&*/ S, 
            final /*const*/ EffectiveContext /*&*/ EC, 
            final AccessTarget /*&*/ Entity) {
  AccessTarget.SavedInstanceContext _ = null;
  CXXBasePaths Paths = null;
  try {
    // Determine the actual naming class.
    /*const*/ CXXRecordDecl /*P*/ NamingClass = Entity.getEffectiveNamingClass();
    
    AccessSpecifier UnprivilegedAccess = Entity.getAccess();
    assert (UnprivilegedAccess != AccessSpecifier.AS_public) : "public access not weeded out";
    
    // Before we try to recalculate access paths, try to white-list
    // accesses which just trade in on the final step, i.e. accesses
    // which don't require [M4] or [B4]. These are by far the most
    // common forms of privileged access.
    if (UnprivilegedAccess != AccessSpecifier.AS_none) {
      switch (HasAccess(S, EC, NamingClass, UnprivilegedAccess, Entity)) {
       case AR_dependent:
        // This is actually an interesting policy decision.  We don't
        // *have* to delay immediately here: we can do the full access
        // calculation in the hope that friendship on some intermediate
        // class will make the declaration accessible non-dependently.
        // But that's not cheap, and odds are very good (note: assertion
        // made without data) that the friend declaration will determine
        // access.
        return AccessResult.AR_dependent;
       case AR_accessible:
        return AccessResult.AR_accessible;
       case AR_inaccessible:
        break;
      }
    }
    
    _ = Entity.saveInstanceContext();
    
    // We lower member accesses to base accesses by pretending that the
    // member is a base class of its declaring class.
    AccessSpecifier FinalAccess;
    if (Entity.isMemberAccess()) {
      // Determine if the declaration is accessible from EC when named
      // in its declaring class.
      NamedDecl /*P*/ Target = Entity.getTargetDecl();
      /*const*/ CXXRecordDecl /*P*/ DeclaringClass = Entity.getDeclaringClass();
      
      FinalAccess = Target.getAccess();
      switch (HasAccess(S, EC, DeclaringClass, FinalAccess, Entity)) {
       case AR_accessible:
        // Target is accessible at EC when named in its declaring class.
        // We can now hill-climb and simply check whether the declaring
        // class is accessible as a base of the naming class.  This is
        // equivalent to checking the access of a notional public
        // member with no instance context.
        FinalAccess = AccessSpecifier.AS_public;
        Entity.suppressInstanceContext();
        break;
       case AR_inaccessible:
        break;
       case AR_dependent:
        return AccessResult.AR_dependent; // see above
      }
      if (DeclaringClass == NamingClass) {
        return (FinalAccess == AccessSpecifier.AS_public ? AccessResult.AR_accessible : AccessResult.AR_inaccessible);
      }
    } else {
      FinalAccess = AccessSpecifier.AS_public;
    }
    assert (Entity.getDeclaringClass() != NamingClass);
    
    // Append the declaration's access if applicable.
    Paths/*J*/= new CXXBasePaths();
    CXXBasePath /*P*/ Path = FindBestPath(S, EC, Entity, FinalAccess, Paths);
    if (!(Path != null)) {
      return AccessResult.AR_dependent;
    }
    assert (Path.Access.getValue() <= UnprivilegedAccess.getValue()) : "access along best path worse than direct?";
    if (Path.Access == AccessSpecifier.AS_public) {
      return AccessResult.AR_accessible;
    }
    return AccessResult.AR_inaccessible;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
    if (_ != null) { _.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="DelayDependentAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1392,
 FQN="DelayDependentAccess", NM="_ZL20DelayDependentAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_14SourceLocationERKNS2_12AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL20DelayDependentAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_14SourceLocationERKNS2_12AccessTargetE")
//</editor-fold>
public static void DelayDependentAccess(final Sema /*&*/ S, 
                    final /*const*/ EffectiveContext /*&*/ EC, 
                    SourceLocation Loc, 
                    final /*const*/ AccessTarget /*&*/ Entity) {
  assert (EC.isDependent()) : "delaying non-dependent access";
  DeclContext /*P*/ DC = EC.getInnerContext();
  assert (DC.isDependentContext()) : "delaying non-dependent access";
  DependentDiagnostic.Create(S.Context, DC, DependentDiagnostic.AccessNonce.Access, 
      new SourceLocation(Loc), 
      Entity.isMemberAccess(), 
      Entity.getAccess(), 
      Entity.getTargetDecl(), 
      Entity.getNamingClass(), 
      Entity.getBaseObjectType(), 
      Entity.getDiag());
}


/// Checks access to an entity from the given effective context.
//<editor-fold defaultstate="collapsed" desc="CheckEffectiveAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1410,
 FQN="CheckEffectiveAccess", NM="_ZL20CheckEffectiveAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_14SourceLocationERNS2_12AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL20CheckEffectiveAccessRN5clang4SemaERKN12_GLOBAL__N_116EffectiveContextENS_14SourceLocationERNS2_12AccessTargetE")
//</editor-fold>
public static AccessResult CheckEffectiveAccess(final Sema /*&*/ S, 
                    final /*const*/ EffectiveContext /*&*/ EC, 
                    SourceLocation Loc, 
                    final AccessTarget /*&*/ Entity) {
  assert (Entity.getAccess() != AccessSpecifier.AS_public) : "called for public access!";
  switch (IsAccessible(S, EC, Entity)) {
   case AR_dependent:
    DelayDependentAccess(S, EC, new SourceLocation(Loc), Entity);
    return AccessResult.AR_dependent;
   case AR_inaccessible:
    if (S.getLangOpts().MSVCCompat
       && IsMicrosoftUsingDeclarationAccessBug(S, new SourceLocation(Loc), Entity)) {
      return AccessResult.AR_accessible;
    }
    if (!Entity.isQuiet()) {
      DiagnoseBadAccess(S, new SourceLocation(Loc), EC, Entity);
    }
    return AccessResult.AR_inaccessible;
   case AR_accessible:
    return AccessResult.AR_accessible;
  }
  
  // silence unnecessary warning
  throw new llvm_unreachable("invalid access result");
}

//<editor-fold defaultstate="collapsed" desc="CheckAccess">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp", line = 1437,
 FQN="CheckAccess", NM="_ZL11CheckAccessRN5clang4SemaENS_14SourceLocationERN12_GLOBAL__N_112AccessTargetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAccess.cpp -nm=_ZL11CheckAccessRN5clang4SemaENS_14SourceLocationERN12_GLOBAL__N_112AccessTargetE")
//</editor-fold>
public static Sema.AccessResult CheckAccess(final Sema /*&*/ S, SourceLocation Loc, 
           final AccessTarget /*&*/ Entity) {
  EffectiveContext EC = null;
  try {
    // If the access path is public, it's accessible everywhere.
    if (Entity.getAccess() == AccessSpecifier.AS_public) {
      return Sema.AccessResult.AR_accessible;
    }
    
    // If we're currently parsing a declaration, we may need to delay
    // access control checking, because our effective context might be
    // different based on what the declaration comes out as.
    //
    // For example, we might be parsing a declaration with a scope
    // specifier, like this:
    //   A::private_type A::foo() { ... }
    //
    // Or we might be parsing something that will turn out to be a friend:
    //   void foo(A::private_type);
    //   void B::foo(A::private_type);
    if (S.DelayedDiagnostics.shouldDelayDiagnostics()) {
      S.DelayedDiagnostics.add(DelayedDiagnostic.makeAccess(new SourceLocation(Loc), Entity));
      return Sema.AccessResult.AR_delayed;
    }
    
    EC/*J*/= new EffectiveContext(S.CurContext);
    switch (CheckEffectiveAccess(S, EC, new SourceLocation(Loc), Entity)) {
     case AR_accessible:
      return Sema.AccessResult.AR_accessible;
     case AR_inaccessible:
      return Sema.AccessResult.AR_inaccessible;
     case AR_dependent:
      return Sema.AccessResult.AR_dependent;
    }
    throw new llvm_unreachable("invalid access result");
  } finally {
    if (EC != null) { EC.$destroy(); }
  }
}

} // END OF class SemaAccessStatics
