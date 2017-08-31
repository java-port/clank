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
package org.clang.ast.comments.impl;

import org.clank.support.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type CommentHTMLTagsPropertiesCommentsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_120isHTMLEndTagOptionalEN4llvm9StringRefE;_ZN5clang8comments12_GLOBAL__N_121isHTMLEndTagForbiddenEN4llvm9StringRefE; -static-type=CommentHTMLTagsPropertiesCommentsGlobals -package=org.clang.ast.comments.impl")
//</editor-fold>
public final class CommentHTMLTagsPropertiesCommentsGlobals {

/*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
|*                                                                            *|
|* HTML tag properties                                                        *|
|*                                                                            *|
|* Automatically generated file, do not edit!                                 *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLEndTagOptional">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentHTMLTagsProperties.inc", line = 9,
 FQN="clang::comments::(anonymous namespace)::isHTMLEndTagOptional", NM="_ZN5clang8comments12_GLOBAL__N_120isHTMLEndTagOptionalEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_120isHTMLEndTagOptionalEN4llvm9StringRefE")
//</editor-fold>
public static boolean isHTMLEndTagOptional(StringRef Name) {
  switch (Name.size()) {
   default:
    break;
   case 1: // 1 string to match.
    if (Name.$at(0) != $$p) {
      break;
    }
    return true; // "p"
   case 2: // 6 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'd': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'd': // 1 string to match.
        return true; // "dd"
       case 't': // 1 string to match.
        return true; // "dt"
      }
      break;
     case 'l': // 1 string to match.
      if (Name.$at(1) != $$i) {
        break;
      }
      return true; // "li"
     case 't': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'd': // 1 string to match.
        return true; // "td"
       case 'h': // 1 string to match.
        return true; // "th"
       case 'r': // 1 string to match.
        return true; // "tr"
      }
      break;
    }
    break;
   case 5: // 3 strings to match.
    if (Name.$at(0) != $$t) {
      break;
    }
    switch (Name.$at(1)) {
     default:
      break;
     case 'b': // 1 string to match.
      if ((memcmp(Name.data().$add(2), $("ody"), 3) != 0)) {
        break;
      }
      return true; // "tbody"
     case 'f': // 1 string to match.
      if ((memcmp(Name.data().$add(2), $("oot"), 3) != 0)) {
        break;
      }
      return true; // "tfoot"
     case 'h': // 1 string to match.
      if ((memcmp(Name.data().$add(2), $("ead"), 3) != 0)) {
        break;
      }
      return true; // "thead"
    }
    break;
   case 8: // 1 string to match.
    if ((memcmp(Name.data().$add(0), $("colgroup"), 8) != 0)) {
      break;
    }
    return true; // "colgroup"
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLEndTagForbidden">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentHTMLTagsProperties.inc", line = 72,
 FQN="clang::comments::(anonymous namespace)::isHTMLEndTagForbidden", NM="_ZN5clang8comments12_GLOBAL__N_121isHTMLEndTagForbiddenEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_121isHTMLEndTagForbiddenEN4llvm9StringRefE")
//</editor-fold>
public static boolean isHTMLEndTagForbidden(StringRef Name) {
  switch (Name.size()) {
   default:
    break;
   case 2: // 2 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'b': // 1 string to match.
      if (Name.$at(1) != $$r) {
        break;
      }
      return true; // "br"
     case 'h': // 1 string to match.
      if (Name.$at(1) != $$r) {
        break;
      }
      return true; // "hr"
    }
    break;
   case 3: // 2 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'c': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("ol"), 2) != 0)) {
        break;
      }
      return true; // "col"
     case 'i': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("mg"), 2) != 0)) {
        break;
      }
      return true; // "img"
    }
    break;
  }
  return false;
}

} // END OF class CommentHTMLTagsPropertiesCommentsGlobals
