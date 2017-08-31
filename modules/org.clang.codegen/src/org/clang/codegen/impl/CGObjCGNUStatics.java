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
package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type CGObjCGNUStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZL17FindIvarInterfaceRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE;_ZL19SymbolNameForMethodN4llvm9StringRefES0_N5clang8SelectorEb; -static-type=CGObjCGNUStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGObjCGNUStatics {

//<editor-fold defaultstate="collapsed" desc="SymbolNameForMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 918,
 FQN="SymbolNameForMethod", NM="_ZL19SymbolNameForMethodN4llvm9StringRefES0_N5clang8SelectorEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZL19SymbolNameForMethodN4llvm9StringRefES0_N5clang8SelectorEb")
//</editor-fold>
public static std.string SymbolNameForMethod(StringRef ClassName, 
                   StringRef CategoryName, /*const*/ Selector MethodName, 
                   boolean isClassMethod) {
  std.string MethodNameColonStripped = MethodName.getAsString();
  std.replace(MethodNameColonStripped.begin(), MethodNameColonStripped.end(), 
      $$COLON, $$UNDERSCORE);
  return ($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C($add_Twine$C(new Twine(isClassMethod ? $("_c_") : $("_i_")), new Twine(ClassName)), new Twine(/*KEEP_STR*/$UNDERSCORE)), 
              new Twine(CategoryName)), new Twine(/*KEEP_STR*/$UNDERSCORE)), new Twine(MethodNameColonStripped))).str();
}

//<editor-fold defaultstate="collapsed" desc="FindIvarInterface">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2885,
 FQN="FindIvarInterface", NM="_ZL17FindIvarInterfaceRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZL17FindIvarInterfaceRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE")
//</editor-fold>
public static /*const*/ ObjCInterfaceDecl /*P*/ FindIvarInterface(final ASTContext /*&*/ Context, 
                 /*const*/ ObjCInterfaceDecl /*P*/ OID, 
                 /*const*/ ObjCIvarDecl /*P*/ OIVD) {
  for (/*const*/ ObjCIvarDecl /*P*/ next = OID.all_declared_ivar_begin$Const(); (next != null);
       next = next.getNextIvar$Const()) {
    if (OIVD == next) {
      return OID;
    }
  }
  {
    
    // Otherwise check in the super class.
    /*const*/ ObjCInterfaceDecl /*P*/ Super = OID.getSuperClass();
    if ((Super != null)) {
      return FindIvarInterface(Context, Super, OIVD);
    }
  }
  
  return null;
}

} // END OF class CGObjCGNUStatics
