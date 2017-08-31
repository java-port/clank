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
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type DeclCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZL13getAccessNameN5clang15AccessSpecifierE;_ZL17GetConversionTypeRN5clang10ASTContextEPNS_9NamedDeclE;_ZL20recursivelyOverridesPKN5clang13CXXMethodDeclES2_;_ZL25CollectVisibleConversionsRN5clang10ASTContextEPNS_13CXXRecordDeclERNS_16ASTUnresolvedSetE;_ZL25CollectVisibleConversionsRN5clang10ASTContextEPNS_13CXXRecordDeclEbNS_15AccessSpecifierERKN4llvm11SmallPtrSetINS_7CanQualINS_4TypeEEELj8EEERNS_16ASTUnresolvedSetERNS_17UnresolvedSetImplERNS6_IPNS_9NamedDeclELj8EEE; -static-type=DeclCXXStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class DeclCXXStatics {

//<editor-fold defaultstate="collapsed" desc="GetConversionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1110,
 FQN="GetConversionType", NM="_ZL17GetConversionTypeRN5clang10ASTContextEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZL17GetConversionTypeRN5clang10ASTContextEPNS_9NamedDeclE")
//</editor-fold>
public static CanQual<Type> GetConversionType(final ASTContext /*&*/ Context, NamedDecl /*P*/ Conv) {
  QualType T = cast_CXXConversionDecl(Conv.getUnderlyingDecl().getAsFunction()).
      getConversionType();
  return Context.getCanonicalType(new QualType(T));
}


/// Collect the visible conversions of a base class.
///
/// \param Record a base class of the class we're considering
/// \param InVirtual whether this base class is a virtual base (or a base
///   of a virtual base)
/// \param Access the access along the inheritance path to this base
/// \param ParentHiddenTypes the conversions provided by the inheritors
///   of this base
/// \param Output the set to which to add conversions from non-virtual bases
/// \param VOutput the set to which to add conversions from virtual bases
/// \param HiddenVBaseCs the set of conversions which were hidden in a
///   virtual base along some inheritance path
//<editor-fold defaultstate="collapsed" desc="CollectVisibleConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1129,
 FQN="CollectVisibleConversions", NM="_ZL25CollectVisibleConversionsRN5clang10ASTContextEPNS_13CXXRecordDeclEbNS_15AccessSpecifierERKN4llvm11SmallPtrSetINS_7CanQualINS_4TypeEEELj8EEERNS_16ASTUnresolvedSetERNS_17UnresolvedSetImplERNS6_IPNS_9NamedDeclELj8EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZL25CollectVisibleConversionsRN5clang10ASTContextEPNS_13CXXRecordDeclEbNS_15AccessSpecifierERKN4llvm11SmallPtrSetINS_7CanQualINS_4TypeEEELj8EEERNS_16ASTUnresolvedSetERNS_17UnresolvedSetImplERNS6_IPNS_9NamedDeclELj8EEE")
//</editor-fold>
public static void CollectVisibleConversions(final ASTContext /*&*/ Context, 
                         CXXRecordDecl /*P*/ Record, 
                         boolean InVirtual, 
                         AccessSpecifier Access, 
                         final /*const*/SmallPtrSet<CanQual<Type>> /*&*/ ParentHiddenTypes, 
                         final ASTUnresolvedSet /*&*/ Output, 
                         final UnresolvedSetImpl /*&*/ VOutput, 
                         final SmallPtrSet<NamedDecl /*P*/ > /*&*/ HiddenVBaseCs) {
  // The set of types which have conversions in this class or its
  // subclasses.  As an optimization, we don't copy the derived set
  // unless it might change.
  /*const*/SmallPtrSet<CanQual<Type>> /*P*/ HiddenTypes = $AddrOf(ParentHiddenTypes);
  SmallPtrSet<CanQual<Type>> HiddenTypesBuffer/*J*/= new SmallPtrSet<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 8);
  
  // Collect the direct conversions and figure out which conversions
  // will be hidden in the subclasses.
  UnresolvedSetIterator ConvI = Record.conversion_begin();
  UnresolvedSetIterator ConvE = Record.conversion_end();
  if (ConvI.$noteq(ConvE)) {
    HiddenTypesBuffer.$assign(ParentHiddenTypes);
    HiddenTypes = $AddrOf(HiddenTypesBuffer);
    
    for (UnresolvedSetIterator I = new UnresolvedSetIterator(ConvI); I.$noteq(ConvE); I.$preInc()) {
      CanQual<Type> ConvType/*J*/= GetConversionType(Context, I.getDecl());
      boolean Hidden = (ParentHiddenTypes.count(new CanQual<Type>(ConvType)) != 0);
      if (!Hidden) {
        HiddenTypesBuffer.insert(new CanQual<Type>(ConvType));
      }
      
      // If this conversion is hidden and we're in a virtual base,
      // remember that it's hidden along some inheritance path.
      if (Hidden && InVirtual) {
        HiddenVBaseCs.insert(cast_NamedDecl(I.getDecl().getCanonicalDecl()));
      } else 
      // If this conversion isn't hidden, add it to the appropriate output.
      if (!Hidden) {
        AccessSpecifier IAccess = CXXRecordDecl.MergeAccess(Access, I.getAccess());
        if (InVirtual) {
          VOutput.addDecl(I.getDecl(), IAccess);
        } else {
          Output.addDecl(Context, I.getDecl(), IAccess);
        }
      }
    }
  }
  
  // Collect information recursively from any base classes.
  for (final /*const*/ CXXBaseSpecifier /*&*/ I : Record.bases()) {
    /*const*/ RecordType /*P*/ RT = I.getType().$arrow().<RecordType>getAs$RecordType();
    if (!(RT != null)) {
      continue;
    }
    
    AccessSpecifier BaseAccess = CXXRecordDecl.MergeAccess(Access, I.getAccessSpecifier());
    boolean BaseInVirtual = InVirtual || I.isVirtual();
    
    CXXRecordDecl /*P*/ Base = cast_CXXRecordDecl(RT.getDecl());
    CollectVisibleConversions(Context, Base, BaseInVirtual, BaseAccess, 
        $Deref(HiddenTypes), Output, VOutput, HiddenVBaseCs);
  }
}


/// Collect the visible conversions of a class.
///
/// This would be extremely straightforward if it weren't for virtual
/// bases.  It might be worth special-casing that, really.
//<editor-fold defaultstate="collapsed" desc="CollectVisibleConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1194,
 FQN="CollectVisibleConversions", NM="_ZL25CollectVisibleConversionsRN5clang10ASTContextEPNS_13CXXRecordDeclERNS_16ASTUnresolvedSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZL25CollectVisibleConversionsRN5clang10ASTContextEPNS_13CXXRecordDeclERNS_16ASTUnresolvedSetE")
//</editor-fold>
public static void CollectVisibleConversions(final ASTContext /*&*/ Context, 
                         CXXRecordDecl /*P*/ Record, 
                         final ASTUnresolvedSet /*&*/ Output) {
  // The collection of all conversions in virtual bases that we've
  // found.  These will be added to the output as long as they don't
  // appear in the hidden-conversions set.
  UnresolvedSet VBaseCs/*J*/= new UnresolvedSet(8);
  
  // The set of conversions in virtual bases that we've determined to
  // be hidden.
  SmallPtrSet<NamedDecl /*P*/ > HiddenVBaseCs/*J*/= new SmallPtrSet<NamedDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  
  // The set of types hidden by classes derived from this one.
  SmallPtrSet<CanQual<Type>> HiddenTypes/*J*/= new SmallPtrSet<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 8);
  
  // Go ahead and collect the direct conversions and add them to the
  // hidden-types set.
  UnresolvedSetIterator ConvI = Record.conversion_begin();
  UnresolvedSetIterator ConvE = Record.conversion_end();
  Output.append(Context, new UnresolvedSetIterator(ConvI), new UnresolvedSetIterator(ConvE));
  for (; ConvI.$noteq(ConvE); ConvI.$preInc())  {
    HiddenTypes.insert(GetConversionType(Context, ConvI.getDecl()));
  }
  
  // Recursively collect conversions from base classes.
  for (final /*const*/ CXXBaseSpecifier /*&*/ I : Record.bases()) {
    /*const*/ RecordType /*P*/ RT = I.getType().$arrow().<RecordType>getAs$RecordType();
    if (!(RT != null)) {
      continue;
    }
    
    CollectVisibleConversions(Context, cast_CXXRecordDecl(RT.getDecl()), 
        I.isVirtual(), I.getAccessSpecifier(), 
        HiddenTypes, Output, VBaseCs, HiddenVBaseCs);
  }
  
  // Add any unhidden conversions provided by virtual bases.
  for (UnresolvedSetIterator I = VBaseCs.begin(), E = VBaseCs.end();
       I.$noteq(E); I.$preInc()) {
    if (!(HiddenVBaseCs.count(cast_NamedDecl(I.getDecl().getCanonicalDecl())) != 0)) {
      Output.addDecl(Context, I.getDecl(), I.getAccess());
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="recursivelyOverrides">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 1485,
 FQN="recursivelyOverrides", NM="_ZL20recursivelyOverridesPKN5clang13CXXMethodDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZL20recursivelyOverridesPKN5clang13CXXMethodDeclES2_")
//</editor-fold>
public static boolean recursivelyOverrides(/*const*/ CXXMethodDecl /*P*/ DerivedMD, 
                    /*const*/ CXXMethodDecl /*P*/ BaseMD) {
  for (type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(DerivedMD.begin_overridden_methods()), 
      E = $tryClone(DerivedMD.end_overridden_methods()); $noteq_ptr(I, E); I.$preInc()) {
    /*const*/ CXXMethodDecl /*P*/ MD = I.$star();
    if (MD.getCanonicalDecl$Const() == BaseMD.getCanonicalDecl$Const()) {
      return true;
    }
    if (recursivelyOverrides(MD, BaseMD)) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getAccessName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2336,
 FQN="getAccessName", NM="_ZL13getAccessNameN5clang15AccessSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZL13getAccessNameN5clang15AccessSpecifierE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getAccessName(AccessSpecifier AS) {
  switch (AS) {
   case AS_none:
    throw new llvm_unreachable("Invalid access specifier!");
   case AS_public:
    return $public;
   case AS_private:
    return $private;
   case AS_protected:
    return $protected;
  }
  throw new llvm_unreachable("Invalid access specifier!");
}

} // END OF class DeclCXXStatics
