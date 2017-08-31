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


//<editor-fold defaultstate="collapsed" desc="static type CommentHTMLNamedCharacterReferencesCommentsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_142translateHTMLNamedCharacterReferenceToUTF8EN4llvm9StringRefE; -static-type=CommentHTMLNamedCharacterReferencesCommentsGlobals -package=org.clang.ast.comments.impl")
//</editor-fold>
public final class CommentHTMLNamedCharacterReferencesCommentsGlobals {

/*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
|*                                                                            *|
|* HTML named character reference to UTF-8 translation                        *|
|*                                                                            *|
|* Automatically generated file, do not edit!                                 *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::translateHTMLNamedCharacterReferenceToUTF8">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentHTMLNamedCharacterReferences.inc", line = 9,
 FQN="clang::comments::(anonymous namespace)::translateHTMLNamedCharacterReferenceToUTF8", NM="_ZN5clang8comments12_GLOBAL__N_142translateHTMLNamedCharacterReferenceToUTF8EN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_142translateHTMLNamedCharacterReferenceToUTF8EN4llvm9StringRefE")
//</editor-fold>
public static StringRef translateHTMLNamedCharacterReferenceToUTF8(StringRef Name) {
  switch (Name.size()) {
   default:
    break;
   case 2: // 15 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'G': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'T': // 1 string to match.
        return new StringRef(/*KEEP_STR*/$GT); // "GT"
       case 't': // 1 string to match.
        return new StringRef(/*KEEP_STR*/$GT); // "Gt"
      }
      break;
     case 'L': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'T': // 1 string to match.
        return new StringRef(/*KEEP_STR*/$LT); // "LT"
       case 't': // 1 string to match.
        return new StringRef(/*KEEP_STR*/$LT); // "Lt"
      }
      break;
     case 'P': // 1 string to match.
      if (Name.$at(1) != $$i) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\240"); // "Pi"
     case 'X': // 1 string to match.
      if (Name.$at(1) != $$i) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\236"); // "Xi"
     case 'g': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'e': // 1 string to match.
        return new StringRef(/*KEEP_STR*/"\342\211\245"); // "ge"
       case 't': // 1 string to match.
        return new StringRef(/*KEEP_STR*/$GT); // "gt"
      }
      break;
     case 'l': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'e': // 1 string to match.
        return new StringRef(/*KEEP_STR*/"\342\211\244"); // "le"
       case 't': // 1 string to match.
        return new StringRef(/*KEEP_STR*/$LT); // "lt"
      }
      break;
     case 'm': // 1 string to match.
      if (Name.$at(1) != $$u) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\274"); // "mu"
     case 'n': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'e': // 1 string to match.
        return new StringRef(/*KEEP_STR*/"\342\211\240"); // "ne"
       case 'u': // 1 string to match.
        return new StringRef(/*KEEP_STR*/"\316\275"); // "nu"
      }
      break;
     case 'p': // 1 string to match.
      if (Name.$at(1) != $$i) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\317\200"); // "pi"
     case 'x': // 1 string to match.
      if (Name.$at(1) != $$i) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\276"); // "xi"
    }
    break;
   case 3: // 16 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'A': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("MP"), 2) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/$AMP); // "AMP"
     case 'P': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'h': // 1 string to match.
        if (Name.$at(2) != $$i) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\316\246"); // "Phi"
       case 's': // 1 string to match.
        if (Name.$at(2) != $$i) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\316\250"); // "Psi"
      }
      break;
     case 'R': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("EG"), 2) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\302\256"); // "REG"
     case 'a': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("mp"), 2) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/$AMP); // "amp"
     case 'c': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("hi"), 2) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\317\207"); // "chi"
     case 'd': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("eg"), 2) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\302\260"); // "deg"
     case 'e': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("ta"), 2) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\267"); // "eta"
     case 'i': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $nt, 2) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\342\210\253"); // "int"
     case 'p': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'h': // 1 string to match.
        if (Name.$at(2) != $$i) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\317\206"); // "phi"
       case 's': // 1 string to match.
        if (Name.$at(2) != $$i) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\317\210"); // "psi"
      }
      break;
     case 'r': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'e': // 1 string to match.
        if (Name.$at(2) != $$g) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\302\256"); // "reg"
       case 'h': // 1 string to match.
        if (Name.$at(2) != $$o) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\317\201"); // "rho"
      }
      break;
     case 's': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'i': // 1 string to match.
        if (Name.$at(2) != $$m) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\274"); // "sim"
       case 'u': // 1 string to match.
        if (Name.$at(2) != $$m) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\221"); // "sum"
      }
      break;
     case 't': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("au"), 2) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\317\204"); // "tau"
    }
    break;
   case 4: // 30 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'A': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\204"); // "Auml"
     case 'C': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("OPY"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\302\251"); // "COPY"
     case 'E': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\213"); // "Euml"
     case 'I': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\217"); // "Iuml"
     case 'O': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\226"); // "Ouml"
     case 'Q': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("UOT"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/$DBL_QUOTE); // "QUOT"
     case 'U': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\234"); // "Uuml"
     case 'Y': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\305\270"); // "Yuml"
     case 'a': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'p': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("os"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/$SGL_QUOTE); // "apos"
       case 'u': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ml"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\244"); // "auml"
      }
      break;
     case 'b': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("eta"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\262"); // "beta"
     case 'c': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("opy"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\302\251"); // "copy"
     case 'e': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\253"); // "euml"
     case 'i': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ta"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\316\271"); // "iota"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("in"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\210"); // "isin"
       case 'u': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ml"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\257"); // "iuml"
      }
      break;
     case 'l': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("arr"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\342\206\220"); // "larr"
     case 'n': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("bsp"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\302\240"); // "nbsp"
     case 'o': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\266"); // "ouml"
     case 'p': // 4 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rt"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\202"); // "part"
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rp"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\212\245"); // "perp"
       case 'r': // 2 strings to match.
        if (Name.$at(2) != $$o) {
          break;
        }
        switch (Name.$at(3)) {
         default:
          break;
         case 'd': // 1 string to match.
          return new StringRef(/*KEEP_STR*/"\342\210\217"); // "prod"
         case 'p': // 1 string to match.
          return new StringRef(/*KEEP_STR*/"\342\210\235"); // "prop"
        }
        break;
      }
      break;
     case 'q': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uot"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/$DBL_QUOTE); // "quot"
     case 'r': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("arr"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\342\206\222"); // "rarr"
     case 's': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ot"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\213\205"); // "sdot"
       case 'e': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ct"), 2) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\302\247"); // "sect"
      }
      break;
     case 'u': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\274"); // "uuml"
     case 'y': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("uml"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\277"); // "yuml"
     case 'z': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("eta"), 3) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\266"); // "zeta"
    }
    break;
   case 5: // 48 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'A': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("irc"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\202"); // "Acirc"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ing"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\205"); // "Aring"
      }
      break;
     case 'D': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("elta"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\224"); // "Delta"
     case 'E': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("circ"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\212"); // "Ecirc"
     case 'G': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("amma"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\223"); // "Gamma"
     case 'I': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("circ"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\216"); // "Icirc"
     case 'O': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("irc"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\224"); // "Ocirc"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ega"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\316\251"); // "Omega"
      }
      break;
     case 'P': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("rime"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\342\200\263"); // "Prime"
     case 'S': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("igma"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\243"); // "Sigma"
     case 'T': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'R': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ADE"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\204\242"); // "TRADE"
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("eta"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\316\230"); // "Theta"
      }
      break;
     case 'U': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("circ"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\233"); // "Ucirc"
     case 'Y': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("circ"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\305\266"); // "Ycirc"
     case 'a': // 4 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("irc"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\242"); // "acirc"
       case 'l': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("pha"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\316\261"); // "alpha"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ing"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\245"); // "aring"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ymp"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\211\210"); // "asymp"
      }
      break;
     case 'd': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("elta"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\264"); // "delta"
     case 'e': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("irc"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\252"); // "ecirc"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("pty"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\205"); // "empty"
       case 'q': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("uiv"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\211\241"); // "equiv"
      }
      break;
     case 'g': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("amma"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\263"); // "gamma"
     case 'i': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("irc"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\256"); // "icirc"
       case 'n': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("fin"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\236"); // "infin"
      }
      break;
     case 'k': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("appa"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\272"); // "kappa"
     case 'l': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("eil"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\214\210"); // "lceil"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("quo"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\200\234"); // "ldquo"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("quo"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\200\230"); // "lsquo"
      }
      break;
     case 'm': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ash"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\200\224"); // "mdash"
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("nus"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\222"); // "minus"
      }
      break;
     case 'n': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("bla"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\207"); // "nabla"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ash"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\200\223"); // "ndash"
       case 'o': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("tin"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\211"); // "notin"
      }
      break;
     case 'o': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("irc"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\264"); // "ocirc"
       case 'm': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ega"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\317\211"); // "omega"
      }
      break;
     case 'p': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("rime"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\342\200\262"); // "prime"
     case 'r': // 4 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("dic"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\210\232"); // "radic"
       case 'c': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("eil"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\214\211"); // "rceil"
       case 'd': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("quo"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\200\235"); // "rdquo"
       case 's': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("quo"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\200\231"); // "rsquo"
      }
      break;
     case 's': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("gma"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\317\203"); // "sigma"
       case 'z': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("lig"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\237"); // "szlig"
      }
      break;
     case 't': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'h': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("eta"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\316\270"); // "theta"
       case 'i': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("mes"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\227"); // "times"
       case 'r': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ade"), 3) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\204\242"); // "trade"
      }
      break;
     case 'u': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("circ"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\273"); // "ucirc"
     case 'y': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("circ"), 4) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\305\267"); // "ycirc"
    }
    break;
   case 6: // 37 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'A': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\201"); // "Aacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\200"); // "Agrave"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ilde"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\203"); // "Atilde"
      }
      break;
     case 'C': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("cedil"), 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\207"); // "Ccedil"
     case 'E': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\211"); // "Eacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\210"); // "Egrave"
      }
      break;
     case 'I': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\215"); // "Iacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\214"); // "Igrave"
      }
      break;
     case 'L': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("ambda"), 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\233"); // "Lambda"
     case 'N': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $tilde, 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\221"); // "Ntilde"
     case 'O': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\223"); // "Oacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\222"); // "Ograve"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ilde"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\225"); // "Otilde"
      }
      break;
     case 'U': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\232"); // "Uacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\231"); // "Ugrave"
      }
      break;
     case 'Y': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("acute"), 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\235"); // "Yacute"
     case 'a': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\241"); // "aacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\240"); // "agrave"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ilde"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\243"); // "atilde"
      }
      break;
     case 'c': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("cedil"), 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\247"); // "ccedil"
     case 'e': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\251"); // "eacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\250"); // "egrave"
      }
      break;
     case 'i': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\255"); // "iacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\254"); // "igrave"
      }
      break;
     case 'l': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("mbda"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\316\273"); // "lambda"
       case 'f': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("loor"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\342\214\212"); // "lfloor"
      }
      break;
     case 'n': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $tilde, 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\303\261"); // "ntilde"
     case 'o': // 3 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\263"); // "oacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\262"); // "ograve"
       case 't': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("ilde"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\265"); // "otilde"
      }
      break;
     case 'p': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("lusmn"), 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\302\261"); // "plusmn"
     case 'r': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("floor"), 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\342\214\213"); // "rfloor"
     case 's': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("igmaf"), 5) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\317\202"); // "sigmaf"
     case 'u': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\272"); // "uacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\271"); // "ugrave"
      }
      break;
     case 'y': // 2 strings to match.
      switch (Name.$at(1)) {
       default:
        break;
       case 'a': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("cute"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\303\275"); // "yacute"
       case 'g': // 1 string to match.
        if ((memcmp(Name.data().$add(2), $("rave"), 4) != 0)) {
          break;
        }
        return new StringRef(/*KEEP_STR*/"\341\273\263"); // "ygrave"
      }
      break;
    }
    break;
   case 7: // 3 strings to match.
    switch (Name.$at(0)) {
     default:
      break;
     case 'U': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("psilon"), 6) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\245"); // "Upsilon"
     case 'e': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("psilon"), 6) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\316\265"); // "epsilon"
     case 'u': // 1 string to match.
      if ((memcmp(Name.data().$add(1), $("psilon"), 6) != 0)) {
        break;
      }
      return new StringRef(/*KEEP_STR*/"\317\205"); // "upsilon"
    }
    break;
  }
  return new StringRef();
}

} // END OF class CommentHTMLNamedCharacterReferencesCommentsGlobals
