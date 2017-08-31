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
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.sema.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaFixItUtilsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp -nm=_ZL14isMacroDefinedRKN5clang4SemaENS_14SourceLocationEN4llvm9StringRefE;_ZL30getScalarZeroExpressionForTypeRKN5clang4TypeENS_14SourceLocationERKNS_4SemaE; -static-type=SemaFixItUtilsStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaFixItUtilsStatics {

//<editor-fold defaultstate="collapsed" desc="isMacroDefined">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp", line = 163,
 FQN="isMacroDefined", NM="_ZL14isMacroDefinedRKN5clang4SemaENS_14SourceLocationEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp -nm=_ZL14isMacroDefinedRKN5clang4SemaENS_14SourceLocationEN4llvm9StringRefE")
//</editor-fold>
public static boolean isMacroDefined(final /*const*/ Sema /*&*/ S, SourceLocation Loc, StringRef Name) {
  return (boolean)S.PP.getMacroDefinitionAtLoc($AddrOf(S.getASTContext().Idents.get(/*NO_COPY*/Name)), 
      new SourceLocation(Loc)).$bool();
}

//<editor-fold defaultstate="collapsed" desc="getScalarZeroExpressionForType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp", line = 168,
 FQN="getScalarZeroExpressionForType", NM="_ZL30getScalarZeroExpressionForTypeRKN5clang4TypeENS_14SourceLocationERKNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaFixItUtils.cpp -nm=_ZL30getScalarZeroExpressionForTypeRKN5clang4TypeENS_14SourceLocationERKNS_4SemaE")
//</editor-fold>
public static std.string getScalarZeroExpressionForType(final /*const*/ Type /*&*/ T, SourceLocation Loc, final /*const*/ Sema /*&*/ S) {
  assert (T.isScalarType()) : "use scalar types only";
  // Suggest "0" for non-enumeration scalar types, unless we can find a
  // better initializer.
  if (T.isEnumeralType()) {
    return new std.string();
  }
  if ((T.isObjCObjectPointerType() || T.isBlockPointerType())
     && isMacroDefined(S, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/"nil"))) {
    return new std.string(/*KEEP_STR*/"nil");
  }
  if (T.isRealFloatingType()) {
    return new std.string(/*KEEP_STR*/"0.0");
  }
  if (T.isBooleanType()
     && (S.LangOpts.CPlusPlus || isMacroDefined(S, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/$false)))) {
    return new std.string(/*KEEP_STR*/$false);
  }
  if (T.isPointerType() || T.isMemberPointerType()) {
    if (S.LangOpts.CPlusPlus11) {
      return new std.string(/*KEEP_STR*/$nullptr);
    }
    if (isMacroDefined(S, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/"NULL"))) {
      return new std.string(/*KEEP_STR*/"NULL");
    }
  }
  if (T.isCharType()) {
    return new std.string(/*KEEP_STR*/"'\\0'");
  }
  if (T.isWideCharType()) {
    return new std.string(/*KEEP_STR*/"L'\\0'");
  }
  if (T.isChar16Type()) {
    return new std.string(/*KEEP_STR*/"u'\\0'");
  }
  if (T.isChar32Type()) {
    return new std.string(/*KEEP_STR*/"U'\\0'");
  }
  return new std.string(/*KEEP_STR*/$0);
}

} // END OF class SemaFixItUtilsStatics
