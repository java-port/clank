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
package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.aliases.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.BaseSubobject.*;


//<editor-fold defaultstate="collapsed" desc="static type VTableBuilderStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=Tpl__ZN12_GLOBAL__N_1L25visitAllOverriddenMethodsEPKN5clang13CXXMethodDeclERT_;_ZL10extendPathPN5clang8VPtrInfoE;_ZL13PrintBasePathRKN4llvm11SmallVectorIPKN5clang13CXXRecordDeclELj1EEERNS_11raw_ostreamE;_ZL13isDirectVBasePKN5clang13CXXRecordDeclES2_;_ZL13rebucketPathsRN4llvm11SmallVectorIPN5clang8VPtrInfoELj2EEE;_ZL13setsIntersectRKN4llvm11SmallPtrSetIPKN5clang13CXXRecordDeclELj4EEENS_8ArrayRefIS4_EE;_ZL14selectBestPathRN5clang10ASTContextEPKNS_13CXXRecordDeclEPNS_8VPtrInfoERSt4listIN4llvm9SetVectorINS_13BaseSubobjectESt6vectorISA_SaISA_EENS8_8DenseSetISA_NS8_12DenseMapInfoISA_EEEEEESaISI_EE;_ZL18CreateVTableLayoutRKN12_GLOBAL__N_120ItaniumVTableBuilderE;_ZL19getOffsetOfFullPathRN5clang10ASTContextEPKNS_13CXXRecordDeclERKN4llvm9SetVectorINS_13BaseSubobjectESt6vectorIS7_SaIS7_EENS5_8DenseSetIS7_NS5_12DenseMapInfoIS7_EEEEEE;_ZL20findPathsToSubobjectRN5clang10ASTContextERKNS_15ASTRecordLayoutEPKNS_13CXXRecordDeclENS_9CharUnitsENS_13BaseSubobjectERN4llvm9SetVectorIS9_St6vectorIS9_SaIS9_EENSA_8DenseSetIS9_NSA_12DenseMapInfoIS9_EEEEEERSt4listISJ_SaISJ_EE;_ZL20removeRedundantPathsRSt4listIN4llvm9SetVectorIN5clang13BaseSubobjectESt6vectorIS3_SaIS3_EENS0_8DenseSetIS3_NS0_12DenseMapInfoIS3_EEEEEESaISB_EE;_ZL24GroupNewVirtualOverloadsPKN5clang13CXXRecordDeclERN4llvm11SmallVectorIPKNS_13CXXMethodDeclELj10EEE;_ZL27computeFullPathsForVFTablesRN5clang10ASTContextEPKNS_13CXXRecordDeclERN4llvm11SmallVectorIPNS_8VPtrInfoELj2EEE;_ZL28dumpMicrosoftThunkAdjustmentRKN5clang9ThunkInfoERN4llvm11raw_ostreamEb;_ZN12_GLOBAL__N_1L17ComputeBaseOffsetERKN5clang10ASTContextEPKNS0_13CXXRecordDeclERKNS0_11CXXBasePathE;_ZN12_GLOBAL__N_1L17ComputeBaseOffsetERKN5clang10ASTContextEPKNS0_13CXXRecordDeclES6_;_ZN12_GLOBAL__N_1L23HasSameVirtualSignatureEPKN5clang13CXXMethodDeclES3_;_ZN12_GLOBAL__N_1L27ComputeAllOverriddenMethodsEPKN5clang13CXXMethodDeclERN4llvm11SmallPtrSetIS3_Lj8EEE;_ZN12_GLOBAL__N_1L27FindNearestOverriddenMethodEPKN5clang13CXXMethodDeclERN4llvm14SmallSetVectorIPKNS0_13CXXRecordDeclELj8EEE;_ZN12_GLOBAL__N_1L30OverridesIndirectMethodInBasesEPKN5clang13CXXMethodDeclERN4llvm14SmallSetVectorIPKNS0_13CXXRecordDeclELj8EEE;_ZN12_GLOBAL__N_1L33ComputeReturnAdjustmentBaseOffsetERN5clang10ASTContextEPKNS0_13CXXMethodDeclES5_; -static-type=VTableBuilderStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class VTableBuilderStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeBaseOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 219,
 FQN="(anonymous namespace)::ComputeBaseOffset", NM="_ZN12_GLOBAL__N_1L17ComputeBaseOffsetERKN5clang10ASTContextEPKNS0_13CXXRecordDeclERKNS0_11CXXBasePathE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_1L17ComputeBaseOffsetERKN5clang10ASTContextEPKNS0_13CXXRecordDeclERKNS0_11CXXBasePathE")
//</editor-fold>
public static BaseOffset ComputeBaseOffset(final /*const*/ ASTContext /*&*/ Context, 
                 /*const*/ CXXRecordDecl /*P*/ DerivedRD, 
                 final /*const*/ CXXBasePath /*&*/ Path) {
  CharUnits NonVirtualOffset = CharUnits.Zero();
  
  /*uint*/int NonVirtualStart = 0;
  /*const*/ CXXRecordDecl /*P*/ VirtualBase = null;
  
  // First, look for the virtual base class.
  for (int I = Path.size(), E = 0; I != E; --I) {
    final /*const*/ CXXBasePathElement /*&*/ Element = Path.$at$Const(I - 1);
    if (Element.Base.isVirtual()) {
      NonVirtualStart = I;
      QualType VBaseType = Element.Base.getType();
      VirtualBase = VBaseType.$arrow().getAsCXXRecordDecl();
      break;
    }
  }
  
  // Now compute the non-virtual offset.
  for (/*uint*/int I = NonVirtualStart, E = Path.size(); I != E; ++I) {
    final /*const*/ CXXBasePathElement /*&*/ Element = Path.$at$Const(I);
    
    // Check the base class offset.
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(Element.Class);
    
    /*const*/ CXXRecordDecl /*P*/ Base = Element.Base.getType().$arrow().getAsCXXRecordDecl();
    
    NonVirtualOffset.$addassign(Layout.getBaseClassOffset(Base));
  }
  
  // FIXME: This should probably use CharUnits or something. Maybe we should
  // even change the base offsets in ASTRecordLayout to be specified in 
  // CharUnits.
  return new BaseOffset(DerivedRD, VirtualBase, new CharUnits(NonVirtualOffset));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeBaseOffset">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 258,
 FQN="(anonymous namespace)::ComputeBaseOffset", NM="_ZN12_GLOBAL__N_1L17ComputeBaseOffsetERKN5clang10ASTContextEPKNS0_13CXXRecordDeclES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_1L17ComputeBaseOffsetERKN5clang10ASTContextEPKNS0_13CXXRecordDeclES6_")
//</editor-fold>
public static BaseOffset ComputeBaseOffset(final /*const*/ ASTContext /*&*/ Context, 
                 /*const*/ CXXRecordDecl /*P*/ BaseRD, 
                 /*const*/ CXXRecordDecl /*P*/ DerivedRD) {
  CXXBasePaths Paths = null;
  try {
    Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ false, 
        /*RecordPaths=*/ true, /*DetectVirtual=*/ false);
    if (!DerivedRD.isDerivedFrom(BaseRD, Paths)) {
      throw new llvm_unreachable("Class must be derived from the passed in base class!");
    }
    
    return ComputeBaseOffset(Context, DerivedRD, Paths.front());
  } finally {
    if (Paths != null) { Paths.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeReturnAdjustmentBaseOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 270,
 FQN="(anonymous namespace)::ComputeReturnAdjustmentBaseOffset", NM="_ZN12_GLOBAL__N_1L33ComputeReturnAdjustmentBaseOffsetERN5clang10ASTContextEPKNS0_13CXXMethodDeclES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_1L33ComputeReturnAdjustmentBaseOffsetERN5clang10ASTContextEPKNS0_13CXXMethodDeclES5_")
//</editor-fold>
public static BaseOffset ComputeReturnAdjustmentBaseOffset(final ASTContext /*&*/ Context, 
                                 /*const*/ CXXMethodDecl /*P*/ DerivedMD, 
                                 /*const*/ CXXMethodDecl /*P*/ BaseMD) {
  /*const*/ FunctionType /*P*/ BaseFT = BaseMD.getType().$arrow().getAs(FunctionType.class);
  /*const*/ FunctionType /*P*/ DerivedFT = DerivedMD.getType().$arrow().getAs(FunctionType.class);
  
  // Canonicalize the return types.
  CanQual<Type> CanDerivedReturnType = Context.getCanonicalType(DerivedFT.getReturnType());
  CanQual<Type> CanBaseReturnType = Context.getCanonicalType(BaseFT.getReturnType());
  assert (((CanProxyType)CanDerivedReturnType.$arrow()).$arrow().getTypeClass() == ((CanProxyType)CanBaseReturnType.$arrow()).$arrow().getTypeClass()) : "Types must have same type class!";
  if ($eq_CanQual$T_CanQual$U(/*NO_COPY*/CanDerivedReturnType, /*NO_COPY*/CanBaseReturnType)) {
    // No adjustment needed.
    return new BaseOffset();
  }
  if (isa_ReferenceType(CanDerivedReturnType)) {
    CanDerivedReturnType.$assignMove(
        ((CanProxyReferenceType)((CanProxyType)CanDerivedReturnType.$arrow()).$arrow().getAs(ReferenceType.class)).$arrow().getPointeeType()
    );
    CanBaseReturnType.$assignMove(
        ((CanProxyReferenceType)((CanProxyType)CanBaseReturnType.$arrow()).$arrow().getAs(ReferenceType.class)).$arrow().getPointeeType()
    );
  } else if (isa_PointerType(CanDerivedReturnType)) {
    CanDerivedReturnType.$assignMove(
        ((CanProxyPointerType)((CanProxyType)CanDerivedReturnType.$arrow()).$arrow().getAs(PointerType.class)).$arrow().getPointeeType()
    );
    CanBaseReturnType.$assignMove(
        ((CanProxyPointerType)((CanProxyType)CanBaseReturnType.$arrow()).$arrow().getAs(PointerType.class)).$arrow().getPointeeType()
    );
  } else {
    throw new llvm_unreachable("Unexpected return type!");
  }
  
  // We need to compare unqualified types here; consider
  //   const T *Base::foo();
  //   T *Derived::foo();
  if ($eq_CanQual$T_CanQual$U(CanDerivedReturnType.getUnqualifiedType(), 
      CanBaseReturnType.getUnqualifiedType())) {
    // No adjustment needed.
    return new BaseOffset();
  }
  
  /*const*/ CXXRecordDecl /*P*/ DerivedRD = cast_CXXRecordDecl(cast_RecordType(CanDerivedReturnType).getDecl());
  
  /*const*/ CXXRecordDecl /*P*/ BaseRD = cast_CXXRecordDecl(cast_RecordType(CanBaseReturnType).getDecl());
  
  return ComputeBaseOffset(Context, BaseRD, DerivedRD);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HasSameVirtualSignature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 470,
 FQN="(anonymous namespace)::HasSameVirtualSignature", NM="_ZN12_GLOBAL__N_1L23HasSameVirtualSignatureEPKN5clang13CXXMethodDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_1L23HasSameVirtualSignatureEPKN5clang13CXXMethodDeclES3_")
//</editor-fold>
public static boolean HasSameVirtualSignature(/*const*/ CXXMethodDecl /*P*/ LHS, 
                       /*const*/ CXXMethodDecl /*P*/ RHS) {
  /*const*/ FunctionProtoType /*P*/ LT = cast_FunctionProtoType(LHS.getType().getCanonicalType());
  /*const*/ FunctionProtoType /*P*/ RT = cast_FunctionProtoType(RHS.getType().getCanonicalType());
  
  // Fast-path matches in the canonical types.
  if (LT == RT) {
    return true;
  }
  
  // Force the signatures to match.  We can't rely on the overrides
  // list here because there isn't necessarily an inheritance
  // relationship between the two methods.
  if (LT.getTypeQuals() != RT.getTypeQuals()) {
    return false;
  }
  return $eq_ArrayRef$T(LT.getParamTypes(), RT.getParamTypes());
}


/// Visit all the methods overridden by the given method recursively,
/// in a depth-first pre-order. The Visitor's visitor method returns a bool
/// indicating whether to continue the recursion for the given overridden
/// method (i.e. returning false stops the iteration).
/*template <class VisitorTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::visitAllOverriddenMethods">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1087,
 FQN="(anonymous namespace)::visitAllOverriddenMethods", NM="Tpl__ZN12_GLOBAL__N_1L25visitAllOverriddenMethodsEPKN5clang13CXXMethodDeclERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=Tpl__ZN12_GLOBAL__N_1L25visitAllOverriddenMethodsEPKN5clang13CXXMethodDeclERT_")
//</editor-fold>
public static </*class*/ VisitorTy extends CXXMethodDecl2Bool> void visitAllOverriddenMethods(/*const*/ CXXMethodDecl /*P*/ MD, final VisitorTy /*&*/ Visitor) {
  assert (MD.isVirtual()) : "Method is not virtual!";
  
  for (type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(MD.begin_overridden_methods()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(MD.end_overridden_methods()); $noteq_ptr(I, E); I.$preInc()) {
    /*const*/ CXXMethodDecl /*P*/ OverriddenMD = I.$star();
    if (Native.$not(Visitor.$call(OverriddenMD))) {
      continue;
    }
    visitAllOverriddenMethods(OverriddenMD, Visitor);
  }
}


/// ComputeAllOverriddenMethods - Given a method decl, will return a set of all
/// the overridden methods that the function decl overrides.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ComputeAllOverriddenMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1102,
 FQN="(anonymous namespace)::ComputeAllOverriddenMethods", NM="_ZN12_GLOBAL__N_1L27ComputeAllOverriddenMethodsEPKN5clang13CXXMethodDeclERN4llvm11SmallPtrSetIS3_Lj8EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_1L27ComputeAllOverriddenMethodsEPKN5clang13CXXMethodDeclERN4llvm11SmallPtrSetIS3_Lj8EEE")
//</editor-fold>
public static void ComputeAllOverriddenMethods(/*const*/ CXXMethodDecl /*P*/ MD, 
                           final SmallPtrSet</*const*/ CXXMethodDecl /*P*/ > /*&*/ OverriddenMethods) {
  CXXMethodDecl2Bool OverriddenMethodsCollector = /*[&, &OverriddenMethods]*/ (/*const*/ CXXMethodDecl /*P*/ MD$1) -> {
        // Don't recurse on this method if we've already collected it.
        return OverriddenMethods.insert(MD$1).second;
      };
  visitAllOverriddenMethods(MD, OverriddenMethodsCollector);
}


/// OverridesIndirectMethodInBase - Return whether the given member function
/// overrides any methods in the set of given bases. 
/// Unlike OverridesMethodInBase, this checks "overriders of overriders".
/// For example, if we have:
///
/// struct A { virtual void f(); }
/// struct B : A { virtual void f(); }
/// struct C : B { virtual void f(); }
///
/// OverridesIndirectMethodInBase will return true if given C::f as the method 
/// and { A } as the set of bases.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OverridesIndirectMethodInBases">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1336,
 FQN="(anonymous namespace)::OverridesIndirectMethodInBases", NM="_ZN12_GLOBAL__N_1L30OverridesIndirectMethodInBasesEPKN5clang13CXXMethodDeclERN4llvm14SmallSetVectorIPKNS0_13CXXRecordDeclELj8EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_1L30OverridesIndirectMethodInBasesEPKN5clang13CXXMethodDeclERN4llvm14SmallSetVectorIPKNS0_13CXXRecordDeclELj8EEE")
//</editor-fold>
public static boolean OverridesIndirectMethodInBases(/*const*/ CXXMethodDecl /*P*/ MD, 
                              final SmallSetVector</*const*/ CXXRecordDecl /*P*/ > /*&*/ Bases) {
  if ((Bases.count(MD.getParent$Const()) != 0)) {
    return true;
  }
  
  for (type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(MD.begin_overridden_methods()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(MD.end_overridden_methods()); $noteq_ptr(I, E); I.$preInc()) {
    /*const*/ CXXMethodDecl /*P*/ OverriddenMD = I.$star();
    
    // Check "indirect overriders".
    if (OverridesIndirectMethodInBases(OverriddenMD, Bases)) {
      return true;
    }
  }
  
  return false;
}


/// FindNearestOverriddenMethod - Given a method, returns the overridden method
/// from the nearest base. Returns null if no method was found.
/// The Bases are expected to be sorted in a base-to-derived order.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindNearestOverriddenMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 1421,
 FQN="(anonymous namespace)::FindNearestOverriddenMethod", NM="_ZN12_GLOBAL__N_1L27FindNearestOverriddenMethodEPKN5clang13CXXMethodDeclERN4llvm14SmallSetVectorIPKNS0_13CXXRecordDeclELj8EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZN12_GLOBAL__N_1L27FindNearestOverriddenMethodEPKN5clang13CXXMethodDeclERN4llvm14SmallSetVectorIPKNS0_13CXXRecordDeclELj8EEE")
//</editor-fold>
public static /*const*/ CXXMethodDecl /*P*/ FindNearestOverriddenMethod(/*const*/ CXXMethodDecl /*P*/ MD, 
                           final SmallSetVector</*const*/ CXXRecordDecl /*P*/ > /*&*/ Bases) {
  SmallPtrSet</*const*/ CXXMethodDecl /*P*/ > OverriddenMethods/*J*/= new SmallPtrSet</*const*/ CXXMethodDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  ComputeAllOverriddenMethods(MD, OverriddenMethods);
  
  for (/*const*/ CXXRecordDecl /*P*/ PrimaryBase : llvm.make_range(Bases.rbegin(), Bases.rend())) {
    // Now check the overridden methods.
    for (/*const*/ CXXMethodDecl /*P*/ OverriddenMD : OverriddenMethods) {
      // We found our overridden method.
      if (OverriddenMD.getParent$Const() == PrimaryBase) {
        return OverriddenMD;
      }
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="CreateVTableLayout">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2283,
 FQN="CreateVTableLayout", NM="_ZL18CreateVTableLayoutRKN12_GLOBAL__N_120ItaniumVTableBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL18CreateVTableLayoutRKN12_GLOBAL__N_120ItaniumVTableBuilderE")
//</editor-fold>
public static VTableLayout /*P*/ CreateVTableLayout(final /*const*/ ItaniumVTableBuilder /*&*/ Builder) {
  SmallVector<std.pairULongType<ThunkInfo>> VTableThunks/*J*/= new SmallVector<std.pairULongType<ThunkInfo>>(JD$T.INSTANCE, 1, Builder.vtable_thunks_begin(), Builder.vtable_thunks_end(), new std.pairULongType<ThunkInfo>(0, new ThunkInfo()));
  
  return new VTableLayout(Builder.getNumVTableComponents(), 
      Builder.vtable_component_begin(), 
      $uint2ulong(VTableThunks.size()), 
      VTableThunks.data(), 
      Builder.getAddressPoints(), 
      /*IsMicrosoftABI=*/ false);
}

//<editor-fold defaultstate="collapsed" desc="GroupNewVirtualOverloads">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2880,
 FQN="GroupNewVirtualOverloads", NM="_ZL24GroupNewVirtualOverloadsPKN5clang13CXXRecordDeclERN4llvm11SmallVectorIPKNS_13CXXMethodDeclELj10EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL24GroupNewVirtualOverloadsPKN5clang13CXXRecordDeclERN4llvm11SmallVectorIPKNS_13CXXMethodDeclELj10EEE")
//</editor-fold>
public static void GroupNewVirtualOverloads(/*const*/ CXXRecordDecl /*P*/ RD, 
                        final SmallVector</*const*/ CXXMethodDecl /*P*/ > /*&*/ VirtualMethods) {
  // Put the virtual methods into VirtualMethods in the proper order:
  // 1) Group overloads by declaration name. New groups are added to the
  //    vftable in the order of their first declarations in this class
  //    (including overrides, non-virtual methods and any other named decl that
  //    might be nested within the class).
  // 2) In each group, new overloads appear in the reverse order of declaration.
  /*typedef SmallVector<const CXXMethodDecl *, 1> MethodGroup*/
//  final class MethodGroup extends SmallVector</*const*/ CXXMethodDecl /*P*/ >{ };
  SmallVector<SmallVector</*const*/ CXXMethodDecl /*P*/ >> Groups/*J*/= new SmallVector<SmallVector</*const*/ CXXMethodDecl /*P*/ >>(10, new SmallVector</*const*/ CXXMethodDecl /*P*/ >(1));
  /*typedef llvm::DenseMap<DeclarationName, unsigned int> VisitedGroupIndicesTy*/
//  final class VisitedGroupIndicesTy extends DenseMapTypeUInt<DeclarationName>{ };
  DenseMapTypeUInt<DeclarationName> VisitedGroupIndices/*J*/= new DenseMapTypeUInt<DeclarationName>(DenseMapInfoDeclarationName.$Info(), 0);
  for (/*const*/ Decl /*P*/ D : RD.decls()) {
    /*const*/ NamedDecl /*P*/ ND = dyn_cast_NamedDecl(D);
    if (!(ND != null)) {
      continue;
    }
    pairTypeBool<DenseMapIteratorTypeUInt<DeclarationName>> pair = VisitedGroupIndices.insert_pair$KeyT$ValueT(std.make_pair_T_uint(ND.getDeclName(), Groups.size()));
    DenseMapIteratorTypeUInt<DeclarationName> J/*J*/= pair.first;//new DenseMapIteratorTypeUInt<DeclarationName>();
    boolean Inserted = pair.second;
    //std.tie(J, Inserted).$assign(VisitedGroupIndices.insert_pair$KeyT$ValueT(std.make_pair_T_uint(ND.getDeclName(), Groups.size())));
    if (Inserted) {
      Groups.push_back_T$RR(new SmallVector</*const*/ CXXMethodDecl /*P*/ >(1, (/*const*/ CXXMethodDecl /*P*/ )null));
    }
    {
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(ND);
      if ((MD != null)) {
        if (MD.isVirtual()) {
          Groups.$at(J.$arrow().second).push_back(MD.getCanonicalDecl$Const());
        }
      }
    }
  }
  
  for (final /*const*/SmallVector</*const*/ CXXMethodDecl /*P*/ > /*&*/ Group : Groups)  {
    VirtualMethods.append_T(Group.rbegin$Const(), Group.rend$Const());
  }
}

//<editor-fold defaultstate="collapsed" desc="isDirectVBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 2912,
 FQN="isDirectVBase", NM="_ZL13isDirectVBasePKN5clang13CXXRecordDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL13isDirectVBasePKN5clang13CXXRecordDeclES2_")
//</editor-fold>
public static boolean isDirectVBase(/*const*/ CXXRecordDecl /*P*/ Base, /*const*/ CXXRecordDecl /*P*/ RD) {
  for (final /*const*/ CXXBaseSpecifier /*&*/ B : RD.bases$Const()) {
    if (B.isVirtual() && B.getType().$arrow().getAsCXXRecordDecl() == Base) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="PrintBasePath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3077,
 FQN="PrintBasePath", NM="_ZL13PrintBasePathRKN4llvm11SmallVectorIPKN5clang13CXXRecordDeclELj1EEERNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL13PrintBasePathRKN4llvm11SmallVectorIPKN5clang13CXXRecordDeclELj1EEERNS_11raw_ostreamE")
//</editor-fold>
public static void PrintBasePath(final /*const*/SmallVector</*const*/ CXXRecordDecl /*P*/ > /*&*/ Path, final raw_ostream /*&*/ Out) {
  for (/*const*/ CXXRecordDecl /*P*/ Elem : llvm.make_range(Path.rbegin$Const(), Path.rend$Const())) {
    Out.$out(/*KEEP_STR*/$SGL_QUOTE);
    Elem.printQualifiedName(Out);
    Out.$out(/*KEEP_STR*/"' in ");
  }
}

//<editor-fold defaultstate="collapsed" desc="dumpMicrosoftThunkAdjustment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3086,
 FQN="dumpMicrosoftThunkAdjustment", NM="_ZL28dumpMicrosoftThunkAdjustmentRKN5clang9ThunkInfoERN4llvm11raw_ostreamEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL28dumpMicrosoftThunkAdjustmentRKN5clang9ThunkInfoERN4llvm11raw_ostreamEb")
//</editor-fold>
public static void dumpMicrosoftThunkAdjustment(final /*const*/ ThunkInfo /*&*/ TI, final raw_ostream /*&*/ Out, 
                            boolean ContinueFirstLine) {
  final /*const*/ ReturnAdjustment /*&*/ R = TI.Return;
  boolean Multiline = false;
  /*const*/char$ptr/*char P*/ LinePrefix = $("\n       ");
  if (!R.isEmpty() || (TI.Method != null)) {
    if (!ContinueFirstLine) {
      Out.$out(LinePrefix);
    }
    Out.$out(/*KEEP_STR*/"[return adjustment (to type '").$out(
        (((CXXMethodDecl)TI.Method).getReturnType()).getCanonicalType().getAsString()
    ).$out(
        /*KEEP_STR*/"'): "
    );
    if ((R.Virtual.Microsoft.VBPtrOffset != 0)) {
      Out.$out(/*KEEP_STR*/"vbptr at offset ").$out_uint(R.Virtual.Microsoft.VBPtrOffset).$out(/*KEEP_STR*/$COMMA_SPACE);
    }
    if ((R.Virtual.Microsoft.VBIndex != 0)) {
      Out.$out(/*KEEP_STR*/"vbase #").$out_uint(R.Virtual.Microsoft.VBIndex).$out(/*KEEP_STR*/$COMMA_SPACE);
    }
    Out.$out_llong(R.NonVirtual).$out(/*KEEP_STR*/" non-virtual]");
    Multiline = true;
  }
  
  final /*const*/ ThisAdjustment /*&*/ T = TI.This;
  if (!T.isEmpty()) {
    if (Multiline || !ContinueFirstLine) {
      Out.$out(LinePrefix);
    }
    Out.$out(/*KEEP_STR*/"[this adjustment: ");
    if (!TI.This.Virtual.isEmpty()) {
      assert (T.Virtual.Microsoft.VtordispOffset < 0);
      Out.$out(/*KEEP_STR*/"vtordisp at ").$out_int(T.Virtual.Microsoft.VtordispOffset).$out(/*KEEP_STR*/$COMMA_SPACE);
      if ((T.Virtual.Microsoft.VBPtrOffset != 0)) {
        Out.$out(/*KEEP_STR*/"vbptr at ").$out_int(T.Virtual.Microsoft.VBPtrOffset).$out(
            /*KEEP_STR*/" to the left,"
        );
        assert (T.Virtual.Microsoft.VBOffsetOffset > 0);
        Out.$out(LinePrefix).$out(/*KEEP_STR*/" vboffset at ").$out_int(
            T.Virtual.Microsoft.VBOffsetOffset
        ).$out(/*KEEP_STR*/" in the vbtable, ");
      }
    }
    Out.$out_llong(T.NonVirtual).$out(/*KEEP_STR*/" non-virtual]");
  }
}

//<editor-fold defaultstate="collapsed" desc="setsIntersect">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3241,
 FQN="setsIntersect", NM="_ZL13setsIntersectRKN4llvm11SmallPtrSetIPKN5clang13CXXRecordDeclELj4EEENS_8ArrayRefIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL13setsIntersectRKN4llvm11SmallPtrSetIPKN5clang13CXXRecordDeclELj4EEENS_8ArrayRefIS4_EE")
//</editor-fold>
public static boolean setsIntersect(final /*const*/SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > /*&*/ A, 
             ArrayRef</*const*/ CXXRecordDecl /*P*/ > B) {
  for (/*const*/ CXXRecordDecl /*P*/ Decl : B) {
    if ((A.count(Decl) != 0)) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="rebucketPaths">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3359,
 FQN="rebucketPaths", NM="_ZL13rebucketPathsRN4llvm11SmallVectorIPN5clang8VPtrInfoELj2EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL13rebucketPathsRN4llvm11SmallVectorIPN5clang8VPtrInfoELj2EEE")
//</editor-fold>
public static boolean rebucketPaths(final SmallVector<VPtrInfo /*P*/ > /*&*/ Paths) {
  // What we're essentially doing here is bucketing together ambiguous paths.
  // Any bucket with more than one path in it gets extended by NextBase, which
  // is usually the direct base of the inherited the vbptr.  This code uses a
  // sorted vector to implement a multiset to form the buckets.  Note that the
  // ordering is based on pointers, but it doesn't change our output order.  The
  // current algorithm is designed to match MSVC 2012's names.
  SmallVector<VPtrInfo /*P*/ > PathsSorted/*J*/= new SmallVector<VPtrInfo /*P*/ >(Paths);
  std.sort(PathsSorted.begin(), PathsSorted.end(), 
      /*[]*/ (/*const*/ VPtrInfo /*P*/ LHS, /*const*/ VPtrInfo /*P*/ RHS) -> {
            return LHS.MangledPath.$less(RHS.MangledPath);
          });
  boolean Changed = false;
  for (/*size_t*/int I = 0, E = PathsSorted.size(); I != E;) {
    // Scan forward to find the end of the bucket.
    /*size_t*/int BucketStart = I;
    do {
      ++I;
    } while (I != E && PathsSorted.$at(BucketStart).MangledPath.$eq(
        PathsSorted.$at(I).MangledPath
    ));
    
    // If this bucket has multiple paths, extend them all.
    if ($greater_uint(I - BucketStart, 1)) {
      for (/*size_t*/int II = BucketStart; II != I; ++II)  {
        Changed |= extendPath(PathsSorted.$at(II));
      }
      assert (Changed) : "no paths were extended to fix ambiguity";
    }
  }
  return Changed;
}

//<editor-fold defaultstate="collapsed" desc="extendPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3350,
 FQN="extendPath", NM="_ZL10extendPathPN5clang8VPtrInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL10extendPathPN5clang8VPtrInfoE")
//</editor-fold>
public static boolean extendPath(VPtrInfo /*P*/ P) {
  if ((P.NextBaseToMangle != null)) {
    P.MangledPath.push_back(P.NextBaseToMangle);
    P.NextBaseToMangle = null; // Prevent the path from being extended twice.
    return true;
  }
  return false;
}


// This recursive function finds all paths from a subobject centered at
// (RD, Offset) to the subobject located at BaseWithVPtr.
//<editor-fold defaultstate="collapsed" desc="findPathsToSubobject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3405,
 FQN="findPathsToSubobject", NM="_ZL20findPathsToSubobjectRN5clang10ASTContextERKNS_15ASTRecordLayoutEPKNS_13CXXRecordDeclENS_9CharUnitsENS_13BaseSubobjectERN4llvm9SetVectorIS9_St6vectorIS9_SaIS9_EENSA_8DenseSetIS9_NSA_12DenseMapInfoIS9_EEEEEERSt4listISJ_SaISJ_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL20findPathsToSubobjectRN5clang10ASTContextERKNS_15ASTRecordLayoutEPKNS_13CXXRecordDeclENS_9CharUnitsENS_13BaseSubobjectERN4llvm9SetVectorIS9_St6vectorIS9_SaIS9_EENSA_8DenseSetIS9_NSA_12DenseMapInfoIS9_EEEEEERSt4listISJ_SaISJ_EE")
//</editor-fold>
public static void findPathsToSubobject(final ASTContext /*&*/ Context, 
                    final /*const*/ ASTRecordLayout /*&*/ MostDerivedLayout, 
                    /*const*/ CXXRecordDecl /*P*/ RD, CharUnits Offset, 
                    BaseSubobject BaseWithVPtr, 
                    final SetVectorDenseSet<BaseSubobject>/*&*/ FullPath, 
                    final std.list<SetVectorDenseSet<BaseSubobject> > /*&*/ Paths) {
  if ($eq_BaseSubobject$C(new BaseSubobject(RD, new CharUnits(Offset)), BaseWithVPtr)) {
    Paths.push_back_T$C$R(FullPath);
    return;
  }
  
  final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
  
  for (final /*const*/ CXXBaseSpecifier /*&*/ BS : RD.bases$Const()) {
    /*const*/ CXXRecordDecl /*P*/ Base = BS.getType().$arrow().getAsCXXRecordDecl();
    CharUnits NewOffset = BS.isVirtual() ? MostDerivedLayout.getVBaseClassOffset(Base) : Offset.$add(Layout.getBaseClassOffset(Base));
    FullPath.insert(new BaseSubobject(Base, new CharUnits(NewOffset)));
    findPathsToSubobject(Context, MostDerivedLayout, Base, new CharUnits(NewOffset), 
        new BaseSubobject(BaseWithVPtr), FullPath, Paths);
    FullPath.pop_back();
  }
}


// Return the paths which are not subsets of other paths.
//<editor-fold defaultstate="collapsed" desc="removeRedundantPaths">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3431,
 FQN="removeRedundantPaths", NM="_ZL20removeRedundantPathsRSt4listIN4llvm9SetVectorIN5clang13BaseSubobjectESt6vectorIS3_SaIS3_EENS0_8DenseSetIS3_NS0_12DenseMapInfoIS3_EEEEEESaISB_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL20removeRedundantPathsRSt4listIN4llvm9SetVectorIN5clang13BaseSubobjectESt6vectorIS3_SaIS3_EENS0_8DenseSetIS3_NS0_12DenseMapInfoIS3_EEEEEESaISB_EE")
//</editor-fold>
public static void removeRedundantPaths(final std.list<SetVectorDenseSet<BaseSubobject> > /*&*/ FullPaths) {
  FullPaths.remove_if(/*[&, &FullPaths]*/ (final /*const*/SetVectorDenseSet<BaseSubobject>/*&*/ SpecificPath) -> {
            for (final /*const*/SetVectorDenseSet<BaseSubobject>/*&*/ OtherPath : FullPaths) {
              if ($AddrOf(SpecificPath) == $AddrOf(OtherPath)) {
                continue;
              }
              if (std.all_of(SpecificPath.begin$Const(), SpecificPath.end$Const(), 
                  /*[&, &OtherPath]*/ (final /*const*/ BaseSubobject /*&*/ BSO) -> {
                        return OtherPath.count(BSO) != 0;
                      })) {
                return true;
              }
            }
            return false;
          });
}

//<editor-fold defaultstate="collapsed" desc="getOffsetOfFullPath">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3447,
 FQN="getOffsetOfFullPath", NM="_ZL19getOffsetOfFullPathRN5clang10ASTContextEPKNS_13CXXRecordDeclERKN4llvm9SetVectorINS_13BaseSubobjectESt6vectorIS7_SaIS7_EENS5_8DenseSetIS7_NS5_12DenseMapInfoIS7_EEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL19getOffsetOfFullPathRN5clang10ASTContextEPKNS_13CXXRecordDeclERKN4llvm9SetVectorINS_13BaseSubobjectESt6vectorIS7_SaIS7_EENS5_8DenseSetIS7_NS5_12DenseMapInfoIS7_EEEEEE")
//</editor-fold>
public static CharUnits getOffsetOfFullPath(final ASTContext /*&*/ Context, 
                   /*const*/ CXXRecordDecl /*P*/ RD, 
                   final /*const*/SetVectorDenseSet<BaseSubobject>/*&*/ FullPath) {
  final /*const*/ ASTRecordLayout /*&*/ MostDerivedLayout = Context.getASTRecordLayout(RD);
  CharUnits Offset = CharUnits.fromQuantity(-1);
  for (final /*const*/ BaseSubobject /*&*/ BSO : FullPath) {
    /*const*/ CXXRecordDecl /*P*/ Base = BSO.getBase();
    // The first entry in the path is always the most derived record, skip it.
    if (Base == RD) {
      assert (Offset.getQuantity() == -1);
      Offset.$assignMove(CharUnits.Zero());
      continue;
    }
    assert (Offset.getQuantity() != -1);
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    // While we know which base has to be traversed, we don't know if that base
    // was a virtual base.
    /*const*/ CXXBaseSpecifier /*P*/ BaseBS = std.find_if(RD.bases_begin$Const(), RD.bases_end$Const(), /*[&, &Base]*/ (final /*const*/ CXXBaseSpecifier /*&*/ BS) -> {
              return BS.getType().$arrow().getAsCXXRecordDecl() == Base;
            }).$star();
    Offset.$assignMove(BaseBS.isVirtual() ? MostDerivedLayout.getVBaseClassOffset(Base) : Offset.$add(Layout.getBaseClassOffset(Base)));
    RD = Base;
  }
  return Offset;
}


// We want to select the path which introduces the most covariant overrides.  If
// two paths introduce overrides which the other path doesn't contain, issue a
// diagnostic.
//<editor-fold defaultstate="collapsed" desc="selectBestPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3479,
 FQN="selectBestPath", NM="_ZL14selectBestPathRN5clang10ASTContextEPKNS_13CXXRecordDeclEPNS_8VPtrInfoERSt4listIN4llvm9SetVectorINS_13BaseSubobjectESt6vectorISA_SaISA_EENS8_8DenseSetISA_NS8_12DenseMapInfoISA_EEEEEESaISI_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL14selectBestPathRN5clang10ASTContextEPKNS_13CXXRecordDeclEPNS_8VPtrInfoERSt4listIN4llvm9SetVectorINS_13BaseSubobjectESt6vectorISA_SaISA_EENS8_8DenseSetISA_NS8_12DenseMapInfoISA_EEEEEESaISI_EE")
//</editor-fold>
public static /*const*/SetVectorDenseSet<BaseSubobject>/*P*/ selectBestPath(final ASTContext /*&*/ Context, 
              /*const*/ CXXRecordDecl /*P*/ RD, VPtrInfo /*P*/ Info, 
              final std.list<SetVectorDenseSet<BaseSubobject> > /*&*/ FullPaths) {
  std.setPtr</*const*/ CXXMethodDecl /*P*/ > LastOverrides = null;
  try {
    // Handle some easy cases first.
    if (FullPaths.empty()) {
      return null;
    }
    if (FullPaths.size() == 1) {
      return $AddrOf(FullPaths.front());
    }
    
    /*const*/SetVectorDenseSet<BaseSubobject>/*P*/ BestPath = null;
    /*typedef std::setPtr<const CXXMethodDecl *> OverriderSetTy*/
//    final class OverriderSetTy extends std.setPtr</*const*/ CXXMethodDecl /*P*/ >{ };
    LastOverrides/*J*/= new std.setPtr</*const*/ CXXMethodDecl /*P*/ >();
    for (final /*const*/SetVectorDenseSet<BaseSubobject>/*&*/ SpecificPath : FullPaths) {
      std.setPtr</*const*/ CXXMethodDecl /*P*/ > CurrentOverrides = null;
      FinalOverriders Overriders = null;
      std.setPtr</*const*/ CXXMethodDecl /*P*/ > NewOverrides = null;
      std.setPtr</*const*/ CXXMethodDecl /*P*/ > MissingOverrides = null;
      try {
        assert (!SpecificPath.empty());
        CurrentOverrides/*J*/= new std.setPtr</*const*/ CXXMethodDecl /*P*/ >();
        /*const*/ CXXRecordDecl /*P*/ TopLevelRD = SpecificPath.begin$Const().$arrow().getBase();
        // Find the distance from the start of the path to the subobject with the
        // VPtr.
        CharUnits BaseOffset = getOffsetOfFullPath(Context, TopLevelRD, SpecificPath);
        Overriders/*J*/= new FinalOverriders(TopLevelRD, CharUnits.Zero(), TopLevelRD);
        for (/*const*/ CXXMethodDecl /*P*/ MD : Info.BaseWithVPtr.methods()) {
          if (!MD.isVirtual()) {
            continue;
          }
          FinalOverriders.OverriderInfo OI = Overriders.getOverrider(MD.getCanonicalDecl$Const(), new CharUnits(BaseOffset));
          /*const*/ CXXMethodDecl /*P*/ OverridingMethod = OI.Method;
          // Only overriders which have a return adjustment introduce problematic
          // thunks.
          if (ComputeReturnAdjustmentBaseOffset(Context, OverridingMethod, MD).
              isEmpty()) {
            continue;
          }
          // It's possible that the overrider isn't in this path.  If so, skip it
          // because this path didn't introduce it.
          /*const*/ CXXRecordDecl /*P*/ OverridingParent = OverridingMethod.getParent$Const();
          if (std.none_of(SpecificPath.begin$Const(), SpecificPath.end$Const(), 
              /*[&, &OverridingParent]*/ (final /*const*/ BaseSubobject /*&*/ BSO) -> {
                    return BSO.getBase() == OverridingParent;
                  })) {
            continue;
          }
          CurrentOverrides.insert_T$C$R(OverridingMethod);
        }
        NewOverrides = llvm.set_difference(CurrentOverrides, LastOverrides);
        if (NewOverrides.empty()) {
          continue;
        }
        MissingOverrides = llvm.set_difference(LastOverrides, CurrentOverrides);
        if (MissingOverrides.empty()) {
          // This path is a strict improvement over the last path, let's use it.
          BestPath = $AddrOf(SpecificPath);
          std.swap(CurrentOverrides, LastOverrides);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // This path introduces an overrider with a conflicting covariant thunk.
            final DiagnosticsEngine /*&*/ Diags = Context.getDiagnostics();
            /*const*/ CXXMethodDecl /*P*/ CovariantMD = NewOverrides.begin().$star();
            /*const*/ CXXMethodDecl /*P*/ ConflictMD = MissingOverrides.begin().$star();
            $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diags.Report(RD.getLocation(), diag.err_vftable_ambiguous_component)), 
                RD));
            $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diags.Report(CovariantMD.getLocation(), diag.note_covariant_thunk)), 
                CovariantMD));
            $c$.clean($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diags.Report(ConflictMD.getLocation(), diag.note_covariant_thunk)), 
                ConflictMD));
          } finally {
            $c$.$destroy();
          }
        }
      } finally {
        if (MissingOverrides != null) { MissingOverrides.$destroy(); }
        if (NewOverrides != null) { NewOverrides.$destroy(); }
        if (Overriders != null) { Overriders.$destroy(); }
        if (CurrentOverrides != null) { CurrentOverrides.$destroy(); }
      }
    }
    // Go with the path that introduced the most covariant overrides.  If there is
    // no such path, pick the first path.
    return (BestPath != null) ? BestPath : $AddrOf(FullPaths.front());
  } finally {
    if (LastOverrides != null) { LastOverrides.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="computeFullPathsForVFTables">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp", line = 3549,
 FQN="computeFullPathsForVFTables", NM="_ZL27computeFullPathsForVFTablesRN5clang10ASTContextEPKNS_13CXXRecordDeclERN4llvm11SmallVectorIPNS_8VPtrInfoELj2EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTableBuilder.cpp -nm=_ZL27computeFullPathsForVFTablesRN5clang10ASTContextEPKNS_13CXXRecordDeclERN4llvm11SmallVectorIPNS_8VPtrInfoELj2EEE")
//</editor-fold>
public static void computeFullPathsForVFTables(final ASTContext /*&*/ Context, 
                           /*const*/ CXXRecordDecl /*P*/ RD, 
                           final SmallVector<VPtrInfo /*P*/ > /*&*/ Paths) {
  SetVectorDenseSet<BaseSubobject> FullPath = null;
  std.list<SetVectorDenseSet<BaseSubobject> > FullPaths = null;
  try {
    final /*const*/ ASTRecordLayout /*&*/ MostDerivedLayout = Context.getASTRecordLayout(RD);
    FullPath/*J*/= new SetVectorDenseSet<BaseSubobject>(DenseMapInfoBaseSubobject.$Info(), new BaseSubobject());
    FullPaths/*J*/= new std.list<SetVectorDenseSet<BaseSubobject> >(
            new SetVectorDenseSet<BaseSubobject>(DenseMapInfoBaseSubobject.$Info(), new BaseSubobject())
    );
    for (VPtrInfo /*P*/ Info : Paths) {
      findPathsToSubobject(Context, MostDerivedLayout, RD, CharUnits.Zero(), 
          new BaseSubobject(Info.BaseWithVPtr, new CharUnits(Info.FullOffsetInMDC)), FullPath, 
          FullPaths);
      FullPath.clear();
      removeRedundantPaths(FullPaths);
      Info.PathToBaseWithVPtr.clear();
      {
        /*const*/SetVectorDenseSet<BaseSubobject>/*P*/ BestPath = selectBestPath(Context, RD, Info, FullPaths);
        if ((BestPath != null)) {
          for (final /*const*/ BaseSubobject /*&*/ BSO : $Deref(BestPath))  {
            Info.PathToBaseWithVPtr.push_back(BSO.getBase());
          }
        }
      }
      FullPaths.clear();
    }
  } finally {
    if (FullPaths != null) { FullPaths.$destroy(); }
    if (FullPath != null) { FullPath.$destroy(); }
  }
}

} // END OF class VTableBuilderStatics
