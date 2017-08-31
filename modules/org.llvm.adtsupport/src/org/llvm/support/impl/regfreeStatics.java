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
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import org.llvm.support.impl.regexJava.*;
import static org.llvm.support.impl.regexJava.*;

//<editor-fold defaultstate="collapsed" desc="static type regfreeStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regfree.c -nm=_Z12llvm_regfree; -static-type=regfreeStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class regfreeStatics {


/*
- llvm_regfree - free everything
*/
//<editor-fold defaultstate="collapsed" desc="llvm_regfree">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*removed free*/,
 source = "${LLVM_SRC}/llvm/lib/Support/regfree.c", line = 49,
 FQN="llvm_regfree", NM="_Z12llvm_regfree",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/regfree.c -nm=_Z12llvm_regfree")
//</editor-fold>
public static void llvm_regfree( llvm_regex /*P*/ preg) {
   re_guts /*P*/ g;
  if (preg.re_magic != MAGIC1) { /* oops */
    return; /* nice to complain, but hard */
  }
  
  g = preg.re_g;
  if (Native.$bool(g == ((Object/*void P*/ )NULL)) || Native.$bool(g.magic != MAGIC2)) { /* oops again */
    return;
  }
  preg.re_magic = 0; /* mark it invalid */
  g.magic = 0; /* mark it invalid */
  if ($noteq_ptr(g.strip, ((Object/*void P*/ )NULL))) {
    free(reinterpret_cast(char$ptr/*char P*/ .class, g.strip));
  }
  if (g.sets != ((Object/*void P*/ )NULL)) {
//JAVA:  free((char$ptr/*char P*/ )g.sets);
  }
  if ($noteq_ptr(g.setbits, ((Object/*void P*/ )NULL))) {
    free(reinterpret_cast(char$ptr/*char P*/ .class, g.setbits));
  }
  if ($noteq_ptr(g.must, ((Object/*void P*/ )NULL))) {
    free(g.must);
  }
//JAVA:  free((char$ptr/*char P*/ )g);
}

} // END OF class regfreeStatics
