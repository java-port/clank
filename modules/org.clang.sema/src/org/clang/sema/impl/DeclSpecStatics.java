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

import org.clank.support.*;
import org.clank.support.aliases.*;
;
import org.clang.basic.*;
import org.clang.sema.*;


//<editor-fold defaultstate="collapsed" desc="static type DeclSpecStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=Tpl__ZL12BadSpecifierT_S_RPKcRjb; -static-type=DeclSpecStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class DeclSpecStatics {

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="BadSpecifier">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp", line = 381,
 FQN="BadSpecifier", NM="Tpl__ZL12BadSpecifierT_S_RPKcRjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/DeclSpec.cpp -nm=Tpl__ZL12BadSpecifierT_S_RPKcRjb")
//</editor-fold>
public static </*class*/ T> boolean BadSpecifier(T TNew, T TPrev, 
            final char$ptr/*const char P &*/ PrevSpec, 
            final uint$ref/*uint &*/ DiagID) {
  ThreadStorageClassSpecifier x;
  DeclSpec.SCS y;
  DeclSpec.TSC z;
  TypeSpecifierWidth l;
  TypeSpecifierSign s;
  return BadSpecifier(TNew, TPrev, 
            PrevSpec, 
            DiagID, 
            true);
}
public static </*class*/ T> boolean BadSpecifier(T TNew, T TPrev, 
            final char$ptr/*const char P &*/ PrevSpec, 
            final uint$ref/*uint &*/ DiagID, 
            boolean IsExtension/*= true*/) {
  final Class<?> aClass = TPrev.getClass();
  if (aClass == DeclSpec.SCS.class) {
    PrevSpec.$assign(DeclSpec.getSpecifierName_SCS((DeclSpec.SCS) TPrev));
  } else if (aClass == DeclSpec.TQ.class) {
    PrevSpec.$assign(DeclSpec.getSpecifierName_TQ((DeclSpec.TQ) TPrev));
  } else if (aClass == DeclSpec.TSC.class) {
    PrevSpec.$assign(DeclSpec.getSpecifierName_TSC((DeclSpec.TSC) TPrev));
  } else if (aClass == ThreadStorageClassSpecifier.class) {
    PrevSpec.$assign(DeclSpec.getSpecifierName_ThreadStorageClassSpecifier((ThreadStorageClassSpecifier) TPrev));
  } else if (aClass == TypeSpecifierSign.class) {
    PrevSpec.$assign(DeclSpec.getSpecifierName_TypeSpecifierSign((TypeSpecifierSign) TPrev));
  } else if (aClass == TypeSpecifierWidth.class) {
    PrevSpec.$assign(DeclSpec.getSpecifierName_TypeSpecifierWidth((TypeSpecifierWidth) TPrev));
  } else {
    assert false : "Initialization of PrevSpec from " + NativeTrace.getIdentityStr(TPrev) + " is not implemented";
  }
  if (Native.$noteq(TNew, TPrev)) {
    DiagID.$set(diag.err_invalid_decl_spec_combination);
  } else {
    DiagID.$set(IsExtension ? diag.ext_duplicate_declspec : diag.warn_duplicate_declspec);
  }
  return true;
}

} // END OF class DeclSpecStatics
