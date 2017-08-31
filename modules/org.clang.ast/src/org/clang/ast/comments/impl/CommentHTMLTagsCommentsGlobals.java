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


//<editor-fold defaultstate="collapsed" desc="static type CommentHTMLTagsCommentsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_113isHTMLTagNameEN4llvm9StringRefE; -static-type=CommentHTMLTagsCommentsGlobals -package=org.clang.ast.comments.impl")
//</editor-fold>
public final class CommentHTMLTagsCommentsGlobals {

/*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
|*                                                                            *|
|* HTML tag name matcher                                                      *|
|*                                                                            *|
|* Automatically generated file, do not edit!                                 *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLTagName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentHTMLTags.inc", line = 9,
 FQN="clang::comments::(anonymous namespace)::isHTMLTagName", NM="_ZN5clang8comments12_GLOBAL__N_113isHTMLTagNameEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_113isHTMLTagNameEN4llvm9StringRefE")
//</editor-fold>
public static boolean isHTMLTagName(StringRef Name) {
  switch (Name.size()) {
   default:
    break;
   case 1: // 6 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'a': // 1 string to match.
      return true; // "a"
     case 'b': // 1 string to match.
      return true; // "b"
     case 'i': // 1 string to match.
      return true; // "i"
     case 'p': // 1 string to match.
      return true; // "p"
     case 's': // 1 string to match.
      return true; // "s"
     case 'u': // 1 string to match.
      return true; // "u"
    }
    break;
   case 2: // 19 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'b': // 1 string to match.
      if (Name.$at(1) != $$r) {
        break;
      }
      return true; // "br"
     case 'd': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'd': // 1 string to match.
        return true; // "dd"
       case 'l': // 1 string to match.
        return true; // "dl"
       case 't': // 1 string to match.
        return true; // "dt"
      }
      break;
     case 'e': // 1 string to match.
      if (Name.$at(1) != $$m) {
        break;
      }
      return true; // "em"
     case 'h': // 7 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case '1': // 1 string to match.
        return true; // "h1"
       case '2': // 1 string to match.
        return true; // "h2"
       case '3': // 1 string to match.
        return true; // "h3"
       case '4': // 1 string to match.
        return true; // "h4"
       case '5': // 1 string to match.
        return true; // "h5"
       case '6': // 1 string to match.
        return true; // "h6"
       case 'r': // 1 string to match.
        return true; // "hr"
      }
      break;
     case 'l': // 1 string to match.
      if (Name.$at(1) != $$i) {
        break;
      }
      return true; // "li"
     case 'o': // 1 string to match.
      if (Name.$at(1) != $$l) {
        break;
      }
      return true; // "ol"
     case 't': // 4 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'd': // 1 string to match.
        return true; // "td"
       case 'h': // 1 string to match.
        return true; // "th"
       case 'r': // 1 string to match.
        return true; // "tr"
       case 't': // 1 string to match.
        return true; // "tt"
      }
      break;
     case 'u': // 1 string to match.
      if (Name.$at(1) != $$l) {
        break;
      }
      return true; // "ul"
    }
    break;
   case 3: // 9 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'b': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("ig"), 2) != 0)) {
        break;
      }
      return true; // "big"
     case 'c': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("ol"), 2) != 0)) {
        break;
      }
      return true; // "col"
     case 'd': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'e': // 1 string to match.
        if (Name.$at(2) != $$l) {
          break;
        }
        return true; // "del"
       case 'i': // 1 string to match.
        if (Name.$at(2) != $$v) {
          break;
        }
        return true; // "div"
      }
      break;
     case 'i': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'm': // 1 string to match.
        if (Name.$at(2) != $$g) {
          break;
        }
        return true; // "img"
       case 'n': // 1 string to match.
        if (Name.$at(2) != $$s) {
          break;
        }
        return true; // "ins"
      }
      break;
     case 'p': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("re"), 2) != 0)) {
        break;
      }
      return true; // "pre"
     case 's': // 2 strings to match.
      if (Name.$at(1) != $$u) {
        break;
      }
      switch (Name.$at(2)) {
       default:
        break;
       case 'b': // 1 string to match.
        return true; // "sub"
       case 'p': // 1 string to match.
        return true; // "sup"
      }
      break;
    }
    break;
   case 4: // 3 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'c': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("ode"), 3) != 0)) {
        break;
      }
      return true; // "code"
     case 'f': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("ont"), 3) != 0)) {
        break;
      }
      return true; // "font"
     case 's': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("pan"), 3) != 0)) {
        break;
      }
      return true; // "span"
    }
    break;
   case 5: // 5 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 's': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("mall"), 4) != 0)) {
        break;
      }
      return true; // "small"
     case 't': // 4 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ble"), 3) != 0)) {
          break;
        }
        return true; // "table"
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
    }
    break;
   case 6: // 2 strings to match.
    if ((memcmp(Name.data().$add(0), $("str"), 3) != 0)) {
      break;
    }
    switch (Name.$at(3)) {
     default:
      break;
     case 'i': // 1 string to match.
      if ((memcmp(Name.data().$add(4), $("ke"), 2) != 0)) {
        break;
      }
      return true; // "strike"
     case 'o': // 1 string to match.
      if ((memcmp(Name.data().$add(4), $("ng"), 2) != 0)) {
        break;
      }
      return true; // "strong"
    }
    break;
   case 7: // 1 string to match.
    if ((memcmp(Name.data().$add(0), $("caption"), 7) != 0)) {
      break;
    }
    return true; // "caption"
   case 8: // 1 string to match.
    if ((memcmp(Name.data().$add(0), $("colgroup"), 8) != 0)) {
      break;
    }
    return true; // "colgroup"
   case 10: // 1 string to match.
    if ((memcmp(Name.data().$add(0), $("blockquote"), 10) != 0)) {
      break;
    }
    return true; // "blockquote"
  }
  return false;
}

} // END OF class CommentHTMLTagsCommentsGlobals
