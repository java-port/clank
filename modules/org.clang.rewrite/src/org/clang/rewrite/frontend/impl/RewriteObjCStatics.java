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
package org.clang.rewrite.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type RewriteObjCStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZL12IsHeaderFileRKSs;_ZL18scanToNextArgumentRPKc;_ZL19getIvarAccessStringPN5clang12ObjCIvarDeclE;_ZL19scanForProtocolRefsPKcS0_RS0_S1_;_ZL21BuildUniqueMethodNameRSsPN5clang14ObjCMethodDeclE;_ZL26RewriteOneForwardClassDeclPN5clang17ObjCInterfaceDeclERSs;_ZL31HasLocalVariableExternalStoragePN5clang9ValueDeclE; -static-type=RewriteObjCStatics -package=org.clang.rewrite.frontend.impl")
//</editor-fold>
public final class RewriteObjCStatics {

//<editor-fold defaultstate="collapsed" desc="IsHeaderFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 563,
 FQN="IsHeaderFile", NM="_ZL12IsHeaderFileRKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZL12IsHeaderFileRKSs")
//</editor-fold>
public static boolean IsHeaderFile(/*const*/std.string/*&*/ Filename) {
  /*size_t*/int DotPos = Filename.rfind($$DOT);
  if (DotPos == std.string.npos) {
    // no file extension
    return false;
  }
  
  std.string Ext = new std.string(Filename.begin$Const().$add(DotPos).$add(1), Filename.end$Const());
  // C header: .h
  // C++ header: .hh or .H;
  return $eq_string$C_T$C$P(Ext, /*KEEP_STR*/"h") || $eq_string$C_T$C$P(Ext, /*KEEP_STR*/"hh") || $eq_string$C_T$C$P(Ext, /*KEEP_STR*/"H");
}

//<editor-fold defaultstate="collapsed" desc="getIvarAccessString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 756,
 FQN="getIvarAccessString", NM="_ZL19getIvarAccessStringPN5clang12ObjCIvarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZL19getIvarAccessStringPN5clang12ObjCIvarDeclE")
//</editor-fold>
public static std.string getIvarAccessString(ObjCIvarDecl /*P*/ OID) {
  /*const*/ ObjCInterfaceDecl /*P*/ ClassDecl = OID.getContainingInterface();
  std.string S/*J*/= new std.string();
  S.$assign_T$C$P(/*KEEP_STR*/"((struct ");
  $addassign_string_StringRef(S, ClassDecl.getIdentifier().getName());
  S.$addassign_T$C$P(/*KEEP_STR*/"_IMPL *)self)->");
  $addassign_string_StringRef(S, OID.getName());
  return S;
}

//<editor-fold defaultstate="collapsed" desc="RewriteOneForwardClassDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 888,
 FQN="RewriteOneForwardClassDecl", NM="_ZL26RewriteOneForwardClassDeclPN5clang17ObjCInterfaceDeclERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZL26RewriteOneForwardClassDeclPN5clang17ObjCInterfaceDeclERSs")
//</editor-fold>
public static void RewriteOneForwardClassDecl(ObjCInterfaceDecl /*P*/ ForwardDecl, 
                          std.string/*&*/ typedefString) {
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"#ifndef _REWRITER_typedef_");
  typedefString.$addassign(ForwardDecl.getNameAsString());
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"\n");
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"#define _REWRITER_typedef_");
  typedefString.$addassign(ForwardDecl.getNameAsString());
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"\n");
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"typedef struct objc_object ");
  typedefString.$addassign(ForwardDecl.getNameAsString());
  typedefString.$addassign_T$C$P(/*KEEP_STR*/";\n#endif\n");
}

//<editor-fold defaultstate="collapsed" desc="scanForProtocolRefs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2028,
 FQN="scanForProtocolRefs", NM="_ZL19scanForProtocolRefsPKcS0_RS0_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZL19scanForProtocolRefsPKcS0_RS0_S1_")
//</editor-fold>
public static boolean scanForProtocolRefs(/*const*/char$ptr/*char P*/ startBuf, /*const*/char$ptr/*char P*/ endBuf, 
                   char$ptr/*const char P &*/ startRef, char$ptr/*const char P &*/ endRef) {
  while (startBuf.$less(endBuf)) {
    if (startBuf.$star() == $$LT) {
      startRef = $tryClone(startBuf); // mark the start.
    }
    if (startBuf.$star() == $$GT) {
      if ((startRef != null) && startRef.$star() == $$LT) {
        endRef = $tryClone(startBuf); // mark the end.
        return true;
      }
      return false;
    }
    startBuf.$postInc();
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="scanToNextArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 2045,
 FQN="scanToNextArgument", NM="_ZL18scanToNextArgumentRPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZL18scanToNextArgumentRPKc")
//</editor-fold>
public static void scanToNextArgument(char$ptr/*const char P &*/ argRef) {
  int angle = 0;
  while (argRef.$star() != $$RPAREN && (argRef.$star() != $$COMMA || angle > 0)) {
    if (argRef.$star() == $$LT) {
      angle++;
    } else if (argRef.$star() == $$GT) {
      angle--;
    }
    argRef.$postInc();
  }
  assert (angle == 0) : "scanToNextArgument - bad protocol type syntax";
}

//<editor-fold defaultstate="collapsed" desc="HasLocalVariableExternalStorage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3245,
 FQN="HasLocalVariableExternalStorage", NM="_ZL31HasLocalVariableExternalStoragePN5clang9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZL31HasLocalVariableExternalStoragePN5clang9ValueDeclE")
//</editor-fold>
public static boolean HasLocalVariableExternalStorage(ValueDecl /*P*/ VD) {
  {
    VarDecl /*P*/ Var = dyn_cast(VarDecl.class, VD);
    if ((Var != null)) {
      return (Var.isFunctionOrMethodVarDecl() && !Var.hasLocalStorage());
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="BuildUniqueMethodName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp", line = 3625,
 FQN="BuildUniqueMethodName", NM="_ZL21BuildUniqueMethodNameRSsPN5clang14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteObjC.cpp -nm=_ZL21BuildUniqueMethodNameRSsPN5clang14ObjCMethodDeclE")
//</editor-fold>
public static void BuildUniqueMethodName(std.string/*&*/ Name, 
                     ObjCMethodDecl /*P*/ MD) {
  ObjCInterfaceDecl /*P*/ IFace = MD.getClassInterface();
  Name.$assignMove(IFace.getName().$string());
  Name.$addassign($add_T$C$P_string(/*KEEP_STR*/"__", MD.getSelector().getAsString()));
  // Convert colons to underscores.
  /*size_t*/int loc = 0;
  while ((loc = Name.find(/*KEEP_STR*/":", loc)) != std.string.npos) {
    Name.replace(loc, 1, $UNDERSCORE);
  }
}

} // END OF class RewriteObjCStatics
