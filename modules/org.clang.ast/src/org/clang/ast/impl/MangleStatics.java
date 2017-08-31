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

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.basic.target.*;
import static org.clang.basic.target.TargetCXXABI.*;


//<editor-fold defaultstate="collapsed" desc="static type MangleStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZL19mangleFunctionBlockRN5clang13MangleContextEN4llvm9StringRefEPKNS_9BlockDeclERNS2_11raw_ostreamE;_ZL22getCallingConvManglingRKN5clang10ASTContextEPKNS_9NamedDeclE;_ZL9isExternCPKN5clang9NamedDeclE; -static-type=MangleStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class MangleStatics {


// FIXME: For blocks we currently mimic GCC's mangling scheme, which leaves
// much to be desired. Come up with a better mangling scheme.
//<editor-fold defaultstate="collapsed" desc="mangleFunctionBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 39,
 FQN="mangleFunctionBlock", NM="_ZL19mangleFunctionBlockRN5clang13MangleContextEN4llvm9StringRefEPKNS_9BlockDeclERNS2_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZL19mangleFunctionBlockRN5clang13MangleContextEN4llvm9StringRefEPKNS_9BlockDeclERNS2_11raw_ostreamE")
//</editor-fold>
public static void mangleFunctionBlock(final MangleContext /*&*/ Context, 
                   StringRef Outer, 
                   /*const*/ BlockDecl /*P*/ BD, 
                   final raw_ostream /*&*/ Out) {
  /*uint*/int discriminator = Context.getBlockId(BD, true);
  if (discriminator == 0) {
    Out.$out(/*KEEP_STR*/"__").$out(/*NO_COPY*/Outer).$out(/*KEEP_STR*/"_block_invoke");
  } else {
    Out.$out(/*KEEP_STR*/"__").$out(/*NO_COPY*/Outer).$out(/*KEEP_STR*/"_block_invoke_").$out_uint(discriminator + 1);
  }
}

//<editor-fold defaultstate="collapsed" desc="isExternC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 59,
 FQN="isExternC", NM="_ZL9isExternCPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZL9isExternCPKN5clang9NamedDeclE")
//</editor-fold>
public static boolean isExternC(/*const*/ NamedDecl /*P*/ ND) {
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
    if ((FD != null)) {
      return FD.isExternC();
    }
  }
  return cast_VarDecl(ND).isExternC();
}

//<editor-fold defaultstate="collapsed" desc="getCallingConvMangling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp", line = 65,
 FQN="getCallingConvMangling", NM="_ZL22getCallingConvManglingRKN5clang10ASTContextEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Mangle.cpp -nm=_ZL22getCallingConvManglingRKN5clang10ASTContextEPKNS_9NamedDeclE")
//</editor-fold>
public static CCMangling getCallingConvMangling(final /*const*/ ASTContext /*&*/ Context, 
                      /*const*/ NamedDecl /*P*/ ND) {
  final /*const*/ TargetInfo /*&*/ TI = Context.getTargetInfo();
  final /*const*/ Triple /*&*/ $Triple = TI.getTriple();
  if (!$Triple.isOSWindows()
     || !($Triple.getArch() == Triple.ArchType.x86
     || $Triple.getArch() == Triple.ArchType.x86_64)) {
    return CCMangling.CCM_Other;
  }
  if (Context.getLangOpts().CPlusPlus && !isExternC(ND)
     && $eq_TargetCXXABI$C(TI.getCXXABI(), new TargetCXXABI(TargetCXXABI.Kind.Microsoft))) {
    return CCMangling.CCM_Other;
  }
  
  /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
  if (!(FD != null)) {
    return CCMangling.CCM_Other;
  }
  QualType T = FD.getType();
  
  /*const*/ FunctionType /*P*/ FT = T.$arrow().castAs(FunctionType.class);
  
  CallingConv CC = FT.getCallConv();
  switch (CC) {
   default:
    return CCMangling.CCM_Other;
   case CC_X86FastCall:
    return CCMangling.CCM_Fast;
   case CC_X86StdCall:
    return CCMangling.CCM_Std;
   case CC_X86VectorCall:
    return CCMangling.CCM_Vector;
  }
}

} // END OF class MangleStatics
