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
package org.clang.analysis.domainspecific.ento;

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type cocoa">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp -nm=_ZN5clang4ento5cocoa16isCocoaObjectRefENS_8QualTypeE;_ZN5clang4ento5cocoa9isRefTypeENS_8QualTypeEN4llvm9StringRefES4_; -static-type=cocoa -package=org.clang.analysis.domainspecific.ento")
//</editor-fold>
public final class cocoa {

//<editor-fold defaultstate="collapsed" desc="clang::ento::cocoa::isRefType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp", line = 25,
 FQN="clang::ento::cocoa::isRefType", NM="_ZN5clang4ento5cocoa9isRefTypeENS_8QualTypeEN4llvm9StringRefES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp -nm=_ZN5clang4ento5cocoa9isRefTypeENS_8QualTypeEN4llvm9StringRefES4_")
//</editor-fold>
public static boolean isRefType(QualType RetTy, StringRef Prefix) {
  return isRefType(RetTy, Prefix, 
         new StringRef());
}
public static boolean isRefType(QualType RetTy, StringRef Prefix, 
         StringRef Name/*= StringRef()*/) {
  {
    // Recursively walk the typedef stack, allowing typedefs of reference types.
    /*const*/ TypedefType /*P*/ TD;
    while (((/*P*/ TD = RetTy.$arrow().getAs$TypedefType()) != null)) {
      StringRef TDName = TD.getDecl().getIdentifier().getName();
      if (TDName.startswith(/*NO_COPY*/Prefix) && TDName.endswith(/*STRINGREF_STR*/"Ref")) {
        return true;
      }
      // XPC unfortunately uses CF-style function names, but aren't CF types.
      if (TDName.startswith(/*STRINGREF_STR*/"xpc_")) {
        return false;
      }
      RetTy.$assignMove(TD.getDecl().getUnderlyingType());
    }
  }
  if (Name.empty()) {
    return false;
  }
  
  // Is the type void*?
  /*const*/ PointerType /*P*/ PT = RetTy.$arrow().getAs(PointerType.class);
  if (!(PT.getPointeeType().getUnqualifiedType().$arrow().isVoidType())) {
    return false;
  }
  
  // Does the name start with the prefix?
  return Name.startswith(/*NO_COPY*/Prefix);
}

//<editor-fold defaultstate="collapsed" desc="clang::ento::cocoa::isCocoaObjectRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp", line = 59,
 FQN="clang::ento::cocoa::isCocoaObjectRef", NM="_ZN5clang4ento5cocoa16isCocoaObjectRefENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CocoaConventions.cpp -nm=_ZN5clang4ento5cocoa16isCocoaObjectRefENS_8QualTypeE")
//</editor-fold>
public static boolean isCocoaObjectRef(QualType Ty) {
  if (!Ty.$arrow().isObjCObjectPointerType()) {
    return false;
  }
  
  /*const*/ ObjCObjectPointerType /*P*/ PT = Ty.$arrow().getAs(ObjCObjectPointerType.class);
  
  // Can be true for objects with the 'NSObject' attribute.
  if (!(PT != null)) {
    return true;
  }
  
  // We assume that id<..>, id, Class, and Class<..> all represent tracked
  // objects.
  if (PT.isObjCIdType() || PT.isObjCQualifiedIdType()
     || PT.isObjCClassType() || PT.isObjCQualifiedClassType()) {
    return true;
  }
  
  // Does the interface subclass NSObject?
  // FIXME: We can memoize here if this gets too expensive.
  /*const*/ ObjCInterfaceDecl /*P*/ ID = PT.getInterfaceDecl();
  
  // Assume that anything declared with a forward declaration and no
  // @interface subclasses NSObject.
  if (!ID.hasDefinition()) {
    return true;
  }
  
  for (; (ID != null); ID = ID.getSuperClass())  {
    if ($eq_StringRef(ID.getIdentifier().getName(), /*STRINGREF_STR*/"NSObject")) {
      return true;
    }
  }
  
  return false;
}

} // END OF class cocoa
