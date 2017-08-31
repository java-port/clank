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
package org.clang.rewrite.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.rewrite.core.*;


//<editor-fold defaultstate="collapsed" desc="static type HTMLRewriteStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZL13AddLineNumberRN5clang13RewriteBufferEjjj; -static-type=HTMLRewriteStatics -package=org.clang.rewrite.impl")
//</editor-fold>
public final class HTMLRewriteStatics {

//<editor-fold defaultstate="collapsed" desc="AddLineNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp", line = 208,
 FQN="AddLineNumber", NM="_ZL13AddLineNumberRN5clang13RewriteBufferEjjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Rewrite/HTMLRewrite.cpp -nm=_ZL13AddLineNumberRN5clang13RewriteBufferEjjj")
//</editor-fold>
public static void AddLineNumber(RewriteBuffer /*&*/ RB, /*uint*/int LineNo, 
             /*uint*/int B, /*uint*/int E) {
  raw_svector_ostream OS = null;
  try {
    SmallString/*256*/ Str/*J*/= new SmallString/*256*/(256);
    OS/*J*/= new raw_svector_ostream(Str);
    
    OS.$out(/*KEEP_STR*/"<tr><td class=\"num\" id=\"LN").$out_uint(
        LineNo
    ).$out(/*KEEP_STR*/"\">").$out_uint(
        LineNo
    ).$out(/*KEEP_STR*/"</td><td class=\"line\">");
    if (B == E) { // Handle empty lines.
      OS.$out(/*KEEP_STR*/" </td></tr>");
      RB.InsertTextBefore(B, OS.str());
    } else {
      RB.InsertTextBefore(B, OS.str());
      RB.InsertTextBefore(E, new StringRef(/*KEEP_STR*/"</td></tr>"));
    }
  } finally {
    if (OS != null) { OS.$destroy(); }
  }
}

} // END OF class HTMLRewriteStatics
