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
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.sema.*;
import static org.clang.sema.java.SemaSizeofAndAlignment.*;


//<editor-fold defaultstate="collapsed" desc="static type AttributeListStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZL17normalizeAttrNameN4llvm9StringRefES0_N5clang13AttributeList6SyntaxE;_ZL23getFreeListIndexForSizej;_ZL7getInfoRKN5clang13AttributeListE; -static-type=AttributeListStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class AttributeListStatics {

//<editor-fold defaultstate="collapsed" desc="getFreeListIndexForSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 49,
 FQN="getFreeListIndexForSize", NM="_ZL23getFreeListIndexForSizej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZL23getFreeListIndexForSizej")
//</editor-fold>
public static /*size_t*/int getFreeListIndexForSize(/*size_t*/int size) {
  assert ($greatereq_uint(size, $sizeof_AttributeList()));
  assert (($rem_uint(size, $sizeof_ptr(/*Object */))) == 0);
  return ($div_uint((size - $sizeof_AttributeList()), $sizeof_ptr(/*Object */)));
}

//<editor-fold defaultstate="collapsed" desc="normalizeAttrName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 112,
 FQN="normalizeAttrName", NM="_ZL17normalizeAttrNameN4llvm9StringRefES0_N5clang13AttributeList6SyntaxE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZL17normalizeAttrNameN4llvm9StringRefES0_N5clang13AttributeList6SyntaxE")
//</editor-fold>
public static StringRef normalizeAttrName(StringRef AttrName, StringRef ScopeName, 
                 AttributeList.Syntax SyntaxUsed) {
  // Normalize the attribute name, __foo__ becomes foo. This is only allowable
  // for GNU attributes.
  boolean IsGNU = SyntaxUsed == AttributeList.Syntax.AS_GNU
     || (SyntaxUsed == AttributeList.Syntax.AS_CXX11 && $eq_StringRef(/*NO_COPY*/ScopeName, /*STRINGREF_STR*/"gnu"));
  if (IsGNU && $greatereq_uint(AttrName.size(), 4) && AttrName.startswith(/*STRINGREF_STR*/"__")
     && AttrName.endswith(/*STRINGREF_STR*/"__")) {
    AttrName.$assignMove(AttrName.slice(2, AttrName.size() - 2));
  }
  
  return new StringRef(JD$Move.INSTANCE, AttrName);
}

//<editor-fold defaultstate="collapsed" desc="getInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp", line = 176,
 FQN="getInfo", NM="_ZL7getInfoRKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AttributeList.cpp -nm=_ZL7getInfoRKN5clang13AttributeListE")
//</editor-fold>
public static /*const*/ ParsedAttrInfo /*&*/ getInfo(final /*const*/ AttributeList /*&*/ A) {
  return AttrParsedAttrImplGlobals.AttrInfoMap[A.getKind().getValue()];
}

} // END OF class AttributeListStatics
