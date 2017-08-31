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
package org.clang.driver.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.driver.*;
import org.llvm.support.sys.*;;
;


//<editor-fold defaultstate="collapsed" desc="static type MultilibStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZL13isFlagEnabledN4llvm9StringRefE;_ZL20normalizePathSegmentRSs;_ZL7composeRKN5clang6driver8MultilibES3_; -static-type=MultilibStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class MultilibStatics {


/// normalize Segment to "/foo/bar" or "".
//<editor-fold defaultstate="collapsed" desc="normalizePathSegment">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 35,
 FQN="normalizePathSegment", NM="_ZL20normalizePathSegmentRSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZL20normalizePathSegmentRSs")
//</editor-fold>
public static void normalizePathSegment(std.string/*&*/ Segment) {
  StringRef seg = new StringRef(Segment);
  
  // Prune trailing "/" or "./"
  while (true) {
    StringRef last = path.filename(/*NO_COPY*/seg);
    if ($noteq_StringRef(/*NO_COPY*/last, /*STRINGREF_STR*/".")) {
      break;
    }
    seg.$assignMove(path.parent_path(/*NO_COPY*/seg));
  }
  if (seg.empty() || $eq_StringRef(/*NO_COPY*/seg, /*STRINGREF_STR*/"/")) {
    Segment.$assign(/*KEEP_STR*/"");
    return;
  }
  
  // Add leading '/'
  if (seg.front() != $$SLASH) {
    Segment.$assignMove($add_T_str(/*KEEP_STR*/"/", seg.str()));
  } else {
    Segment.$assignMove(seg.$string());
  }
}

//<editor-fold defaultstate="collapsed" desc="compose">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 173,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", old_line = 191,
 FQN="compose", NM="_ZL7composeRKN5clang6driver8MultilibES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZL7composeRKN5clang6driver8MultilibES3_")
//</editor-fold>
public static Multilib compose(/*const*/ Multilib /*&*/ Base, /*const*/ Multilib /*&*/ New) {
  Multilib Composed = null;
  try {
    SmallString/*128*/ GCCSuffix/*J*/= new SmallString/*128*/(128);
    path.append(GCCSuffix, new Twine(/*KEEP_STR*/$SLASH), new Twine(Base.gccSuffix()), new Twine(New.gccSuffix()));
    SmallString/*128*/ OSSuffix/*J*/= new SmallString/*128*/(128);
    path.append(OSSuffix, new Twine(/*KEEP_STR*/$SLASH), new Twine(Base.osSuffix()), new Twine(New.osSuffix()));
    SmallString/*128*/ IncludeSuffix/*J*/= new SmallString/*128*/(128);
    path.append(IncludeSuffix, new Twine(/*KEEP_STR*/$SLASH), new Twine(Base.includeSuffix()), 
        new Twine(New.includeSuffix()));
    
    Composed/*J*/= new Multilib(GCCSuffix.$StringRef(), OSSuffix.$StringRef(), IncludeSuffix.$StringRef());
    
    std.vectorString/*&*/ Flags = Composed.flags();
    
    Flags.insert(Flags.end(), Base.flags().begin(), Base.flags().end());
    Flags.insert(Flags.end(), New.flags().begin(), New.flags().end());
    
    return new Multilib(JD$Move.INSTANCE, Composed);
  } finally {
    if (Composed != null) { Composed.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="isFlagEnabled">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp", line = 239,
 FQN="isFlagEnabled", NM="_ZL13isFlagEnabledN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Multilib.cpp -nm=_ZL13isFlagEnabledN4llvm9StringRefE")
//</editor-fold>
public static boolean isFlagEnabled(StringRef Flag) {
  /*char*/byte Indicator = Flag.front();
  assert (Indicator == $$PLUS || Indicator == $$MINUS);
  return Indicator == $$PLUS;
}

} // END OF class MultilibStatics
