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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaPseudoObjectStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZL26LookupMethodInReceiverTypeRN5clang4SemaENS_8SelectorEPKNS_19ObjCPropertyRefExprE;_ZL28CheckKeyForObjCARCConversionRN5clang4SemaENS_8QualTypeEPNS_4ExprE;_ZL36stripOpaqueValuesFromPseudoObjectRefRN5clang4SemaEPNS_4ExprE; -static-type=SemaPseudoObjectStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaPseudoObjectStatics {


//===----------------------------------------------------------------------===//
//  Objective-C @property and implicit property references
//===----------------------------------------------------------------------===//

/// Look up a method in the receiver type of an Objective-C property
/// reference.
//<editor-fold defaultstate="collapsed" desc="LookupMethodInReceiverType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 542,
 FQN="LookupMethodInReceiverType", NM="_ZL26LookupMethodInReceiverTypeRN5clang4SemaENS_8SelectorEPKNS_19ObjCPropertyRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZL26LookupMethodInReceiverTypeRN5clang4SemaENS_8SelectorEPKNS_19ObjCPropertyRefExprE")
//</editor-fold>
public static ObjCMethodDecl /*P*/ LookupMethodInReceiverType(final Sema /*&*/ S, Selector sel, 
                          /*const*/ ObjCPropertyRefExpr /*P*/ PRE) {
  if (PRE.isObjectReceiver()) {
    /*const*/ ObjCObjectPointerType /*P*/ PT = PRE.getBase$Const().getType().$arrow().castAs(ObjCObjectPointerType.class);
    
    // Special case for 'self' in class method implementations.
    if (PT.isObjCClassType()
       && S.isSelfExpr(((/*const_cast*/Expr /*P*/ )(PRE.getBase$Const())))) {
      // This cast is safe because isSelfExpr is only true within
      // methods.
      ObjCMethodDecl /*P*/ method = cast_ObjCMethodDecl(S.CurContext.getNonClosureAncestor());
      return S.LookupMethodInObjectType(new Selector(sel), 
          S.Context.getObjCInterfaceType(method.getClassInterface()), 
          /*instance*/ false);
    }
    
    return S.LookupMethodInObjectType(new Selector(sel), PT.getPointeeType(), true);
  }
  if (PRE.isSuperReceiver()) {
    {
      /*const*/ ObjCObjectPointerType /*P*/ PT = PRE.getSuperReceiverType().$arrow().getAs(ObjCObjectPointerType.class);
      if ((PT != null)) {
        return S.LookupMethodInObjectType(new Selector(sel), PT.getPointeeType(), true);
      }
    }
    
    return S.LookupMethodInObjectType(new Selector(sel), PRE.getSuperReceiverType(), false);
  }
  assert (PRE.isClassReceiver()) : "Invalid expression";
  QualType IT = S.Context.getObjCInterfaceType(PRE.getClassReceiver());
  return S.LookupMethodInObjectType(new Selector(sel), new QualType(IT), false);
}


/// CheckKeyForObjCARCConversion - This routine suggests bridge casting of CF
/// objects used as dictionary subscript key objects.
//<editor-fold defaultstate="collapsed" desc="CheckKeyForObjCARCConversion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1113,
 FQN="CheckKeyForObjCARCConversion", NM="_ZL28CheckKeyForObjCARCConversionRN5clang4SemaENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZL28CheckKeyForObjCARCConversionRN5clang4SemaENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public static void CheckKeyForObjCARCConversion(final Sema /*&*/ S, QualType ContainerT, 
                            type$ref<Expr /*P*/> Key) {
  if (ContainerT.isNull()) {
    return;
  }
  // dictionary subscripting.
  // - (id)objectForKeyedSubscript:(id)key;
  IdentifierInfo /*P*/ KeyIdents[/*1*/] = new IdentifierInfo /*P*/ [/*1*/] {
    $AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"objectForKeyedSubscript")))
  };
  Selector GetterSelector = S.Context.Selectors.getSelector(1, create_type$ptr(KeyIdents));
  ObjCMethodDecl /*P*/ Getter = S.LookupMethodInObjectType(new Selector(GetterSelector), new QualType(ContainerT), 
      true/*instance*/);
  if (!(Getter != null)) {
    return;
  }
  QualType T = Getter.parameters().$at(0).getType();
  S.CheckObjCARCConversion(Key.$deref().getSourceRange(), 
      new QualType(T), Key, Sema.CheckedConversionKind.CCK_ImplicitConversion);
}


/// Given a pseudo-object reference, rebuild it without the opaque
/// values.  Basically, undo the behavior of rebuildAndCaptureObject.
/// This should never operate in-place.
//<editor-fold defaultstate="collapsed" desc="stripOpaqueValuesFromPseudoObjectRef">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 1622,
 FQN="stripOpaqueValuesFromPseudoObjectRef", NM="_ZL36stripOpaqueValuesFromPseudoObjectRefRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZL36stripOpaqueValuesFromPseudoObjectRefRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static Expr /*P*/ stripOpaqueValuesFromPseudoObjectRef(final Sema /*&*/ S, Expr /*P*/ E) {
  return new Rebuilder(S, 
      /*FuncArg*//*[=]*/ (Expr /*P*/ _E, /*uint*/int $Prm1) -> {
            return cast_OpaqueValueExpr(_E).getSourceExpr();
          }).
      rebuild(E);
}

} // END OF class SemaPseudoObjectStatics
