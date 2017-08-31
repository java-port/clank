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
package org.llvm.adt.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.support.raw_ostream;


//<editor-fold defaultstate="collapsed" desc="static type TwineLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.adt.impl.TwineLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE;_ZN4llvmplEPKcRKNS_9StringRefE;_ZN4llvmplERKNS_5TwineES2_;_ZN4llvmplERKNS_9StringRefEPKc; -static-type=TwineLlvmGlobals -package=org.llvm.adt.impl")
//</editor-fold>
public final class TwineLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 514,
 FQN="llvm::operator+", NM="_ZN4llvmplERKNS_5TwineES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplERKNS_5TwineES2_")
//</editor-fold>
public static /*inline*/ Twine $add_Twine$C(final /*const*/ Twine /*&*/ LHS, final /*const*/ Twine /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Additional overload to guarantee simplified codegen; this is equivalent to
/// concat().
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 521,
 FQN="llvm::operator+", NM="_ZN4llvmplEPKcRKNS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplEPKcRKNS_9StringRefE")
//</editor-fold>
public static /*inline*/ Twine $add_char$ptr$C_StringRef$C(/*const*/char$ptr/*char P*/ LHS, final /*const*/ StringRef /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Additional overload to guarantee simplified codegen; this is equivalent to
/// concat().
//<editor-fold defaultstate="collapsed" desc="llvm::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 528,
 FQN="llvm::operator+", NM="_ZN4llvmplERKNS_9StringRefEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmplERKNS_9StringRefEPKc")
//</editor-fold>
public static /*inline*/ Twine $add_StringRef$C_char$ptr$C(final /*const*/ StringRef /*&*/ LHS, /*const*/char$ptr/*char P*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/Twine.h", line = 532,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Twine.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5TwineE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Twine$C(final raw_ostream /*&*/ OS, final /*const*/ Twine /*&*/ RHS) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class TwineLlvmGlobals
