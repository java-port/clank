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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.HashingGlobals.hash_code;
import static org.llvm.adt.HashingGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type APIntLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm10hash_valueERKNS_5APIntE;_ZN4llvmeqEyRKNS_5APIntE;_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE;_ZN4llvmneEyRKNS_5APIntE; -static-type=APIntLlvmGlobals -package=org.llvm.adt.impl")
//</editor-fold>
public final class APIntLlvmGlobals {


/// \brief Overload to compute a hash_code for an APInt value.
//<editor-fold defaultstate="collapsed" desc="llvm::hash_value">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", line = 655,
 old_source = "${LLVM_SRC}/llvm/lib/Support/APInt.cpp", old_line = 668,
 FQN="llvm::hash_value", NM="_ZN4llvm10hash_valueERKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvm10hash_valueERKNS_5APIntE")
//</editor-fold>
public static hash_code hash_value(final /*const*/ APInt /*&*/ Arg) {
  if (Arg.isSingleWord()) {
    return hash_combine(Arg.VAL);
  }
  
  return hash_combine_range(Arg.pVal, Arg.pVal.$add(Arg.getNumWords()));
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator==">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1744,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1735,
 FQN="llvm::operator==", NM="_ZN4llvmeqEyRKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvmeqEyRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean $eq_ulong_APInt$C(long/*uint64_t*/ V1, final /*const*/ APInt /*&*/ V2) {
  return V2.$eq(V1);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator!=">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1746,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1737,
 FQN="llvm::operator!=", NM="_ZN4llvmneEyRKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvmneEyRKNS_5APIntE")
//</editor-fold>
public static /*inline*/ boolean $noteq_ulong_APInt$C(long/*uint64_t*/ V1, final /*const*/ APInt /*&*/ V2) {
  return V2.$noteq(V1);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", line = 1748,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/APInt.h", old_line = 1739,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/APInt.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5APIntE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_APInt$C(final raw_ostream /*&*/ OS, final /*const*/ APInt /*&*/ I) {
  I.print(OS, true);
  return OS;
}

} // END OF class APIntLlvmGlobals
