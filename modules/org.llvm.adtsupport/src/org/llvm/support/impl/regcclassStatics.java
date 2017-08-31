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
package org.llvm.support.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;


//<editor-fold defaultstate="collapsed" desc="static type regcclassStatics">
@Converted(kind = Converted.Kind.MANUAL,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8cclasses; -static-type=regcclassStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class regcclassStatics {

//<editor-fold defaultstate="collapsed" desc="cclass">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/lib/Support/regcclass.h", line = 44,
 FQN="cclass", NM="_Z6cclass",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_Z6cclass")
//</editor-fold>
public static final class/*struct*/ cclass {
  public final /*const*/char$ptr/*char P*/ name;
  public final /*const*/char$ptr/*char P*/ chars;
  public final /*const*/char$ptr/*char P*/ multis;

  public cclass(char$ptr name, char$ptr chars, char$ptr multis) {
    this.name = name;
    this.chars = chars;
    this.multis = multis;
  }
  
  @Override public String toString() {
    return "" + "name=" + name // NOI18N
              + ", chars=" + chars // NOI18N
              + ", multis=" + multis; // NOI18N
  }
  }

/* character-class table */
//<editor-fold defaultstate="collapsed" desc="cclasses">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/regcclass.h", line = 44,
 FQN="cclasses", NM="_ZL8cclasses",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regcomp.c -nm=_ZL8cclasses")
//</editor-fold>
public static  cclass cclasses[/*13*/] = new  cclass [/*13*/] {
  new  cclass(
    $("alnum"), $("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"), 
    $EMPTY), 
  new  cclass(
    $("alpha"), $("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"), 
    $EMPTY), 
  new  cclass($("blank"), $(" \t"), $EMPTY), 
  new  cclass( // \a => \007
    $("cntrl"), $("\007\b\t\n\013\014\015\001\002\003\004\005\006\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037\177"), 
    $EMPTY), 
  new  cclass($("digit"), $("0123456789"), $EMPTY), 
  new  cclass(
    $("graph"), $("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"), 
    $EMPTY), 
  new  cclass(
    $("lower"), $("abcdefghijklmnopqrstuvwxyz"), 
    $EMPTY), 
  new  cclass(
    $("print"), $("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "), 
    $EMPTY), 
  new  cclass(
    $("punct"), $("!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"), 
    $EMPTY), 
  new  cclass($("space"), $("\t\n\013\014\015 "), $EMPTY), 
  new  cclass(
    $("upper"), $("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), 
    $EMPTY), 
  new  cclass(
    $("xdigit"), $("0123456789ABCDEFabcdef"), 
    $EMPTY), 
  new  cclass((/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null, $EMPTY)
};
} // END OF class regcclassStatics
