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
package org.clang.parse.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.parse.*;


//<editor-fold defaultstate="collapsed" desc="static type ParseObjcStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZL18takeDeclAttributesRN5clang16ParsedAttributesEPNS_13AttributeListE;_ZL18takeDeclAttributesRN5clang16ParsedAttributesERNS_10DeclaratorE;_ZL34addContextSensitiveTypeNullabilityRN5clang6ParserERNS_10DeclaratorENS_15NullabilityKindENS_14SourceLocationERb;_ZL36diagnoseRedundantPropertyNullabilityRN5clang6ParserERNS_12ObjCDeclSpecENS_15NullabilityKindENS_14SourceLocationE; -static-type=ParseObjcStatics -package=org.clang.parse.impl")
//</editor-fold>
public final class ParseObjcStatics {


/// Add an attribute for a context-sensitive type nullability to the given
/// declarator.
//<editor-fold defaultstate="collapsed" desc="addContextSensitiveTypeNullability">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 393,
 FQN="addContextSensitiveTypeNullability", NM="_ZL34addContextSensitiveTypeNullabilityRN5clang6ParserERNS_10DeclaratorENS_15NullabilityKindENS_14SourceLocationERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZL34addContextSensitiveTypeNullabilityRN5clang6ParserERNS_10DeclaratorENS_15NullabilityKindENS_14SourceLocationERb")
//</editor-fold>
public static void addContextSensitiveTypeNullability(final Parser /*&*/ P, 
                                  final Declarator /*&*/ D, 
                                  NullabilityKind nullability, 
                                  SourceLocation nullabilityLoc, 
                                  final bool$ref/*bool &*/ addedToDeclSpec) {
  // Create the attribute.
  Void2RetType<AttributeList> getNullabilityAttr =  () -> 
    {
      return D.getAttributePool().create(P.getNullabilityKeyword(nullability), 
          new SourceRange(/*NO_COPY*/nullabilityLoc), 
          (IdentifierInfo /*P*/ )null, new SourceLocation(), 
          (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >> /*P*/ )null, 0, 
          AttributeList.Syntax.AS_ContextSensitiveKeyword);
    }
;
  if ($greater_uint(D.getNumTypeObjects(), 0)) {
    // Add the attribute to the declarator chunk nearest the declarator.
    AttributeList /*P*/ nullabilityAttr = getNullabilityAttr.$call();
    final DeclaratorChunk /*&*/ chunk = D.getTypeObject(0);
    nullabilityAttr.setNext(chunk.getAttrListRef().$deref());
    chunk.getAttrListRef().$set(nullabilityAttr);
  } else if (!addedToDeclSpec.$deref()) {
    // Otherwise, just put it on the declaration specifiers (if one
    // isn't there already).
    D.getMutableDeclSpec().addAttributes(getNullabilityAttr.$call());
    addedToDeclSpec.$set(true);
  }
}


/// Diagnose redundant or conflicting nullability information.
//<editor-fold defaultstate="collapsed" desc="diagnoseRedundantPropertyNullability">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 815,
 FQN="diagnoseRedundantPropertyNullability", NM="_ZL36diagnoseRedundantPropertyNullabilityRN5clang6ParserERNS_12ObjCDeclSpecENS_15NullabilityKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZL36diagnoseRedundantPropertyNullabilityRN5clang6ParserERNS_12ObjCDeclSpecENS_15NullabilityKindENS_14SourceLocationE")
//</editor-fold>
public static void diagnoseRedundantPropertyNullability(final Parser /*&*/ P, 
                                    final ObjCDeclSpec /*&*/ DS, 
                                    NullabilityKind nullability, 
                                    SourceLocation nullabilityLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (DS.getNullability() == nullability) {
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_pairTypeBool$NullabilityKind($c$.track(P.Diag(new SourceLocation(nullabilityLoc), diag.warn_nullability_duplicate)), 
              new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability, true)), 
          new SourceRange(DS.getNullabilityLoc())));
      return;
    }
    
    $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_pairTypeBool$NullabilityKind($out_DiagnosticBuilder$C_pairTypeBool$NullabilityKind($c$.track(P.Diag(new SourceLocation(nullabilityLoc), diag.err_nullability_conflicting)), 
                new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, nullability, true)), 
            new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, DS.getNullability(), true)), 
        new SourceRange(DS.getNullabilityLoc())));
  } finally {
    $c$.$destroy();
  }
}


/// Take all the decl attributes out of the given list and add
/// them to the given attribute set.
//<editor-fold defaultstate="collapsed" desc="takeDeclAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1216,
 FQN="takeDeclAttributes", NM="_ZL18takeDeclAttributesRN5clang16ParsedAttributesEPNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZL18takeDeclAttributesRN5clang16ParsedAttributesEPNS_13AttributeListE")
//</editor-fold>
public static void takeDeclAttributes(final ParsedAttributes /*&*/ attrs, 
                  AttributeList /*P*/ list) {
  while ((list != null)) {
    AttributeList /*P*/ cur = list;
    list = cur.getNext();
    if (!cur.isUsedAsTypeAttr()) {
      // Clear out the next pointer.  We're really completely
      // destroying the internal invariants of the declarator here,
      // but it doesn't matter because we're done with it.
      cur.setNext((AttributeList /*P*/ )null);
      attrs.add(cur);
    }
  }
}


/// takeDeclAttributes - Take all the decl attributes from the given
/// declarator and add them to the given list.
//<editor-fold defaultstate="collapsed" desc="takeDeclAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp", line = 1234,
 FQN="takeDeclAttributes", NM="_ZL18takeDeclAttributesRN5clang16ParsedAttributesERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseObjc.cpp -nm=_ZL18takeDeclAttributesRN5clang16ParsedAttributesERNS_10DeclaratorE")
//</editor-fold>
public static void takeDeclAttributes(final ParsedAttributes /*&*/ attrs, 
                  final Declarator /*&*/ D) {
  // First, take ownership of all attributes.
  attrs.getPool().takeAllFrom(D.getAttributePool());
  attrs.getPool().takeAllFrom(D.getDeclSpec().getAttributePool());
  
  // Now actually move the attributes over.
  takeDeclAttributes(attrs, D.getDeclSpec().getAttributes$Const().getList());
  takeDeclAttributes(attrs, D.getAttributes());
  for (/*uint*/int i = 0, e = D.getNumTypeObjects(); i != e; ++i)  {
    takeDeclAttributes(attrs, 
        ((/*const_cast*/AttributeList /*P*/ )(D.getTypeObject(i).getAttrs())));
  }
}

} // END OF class ParseObjcStatics
