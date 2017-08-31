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
package org.llvm.profiledata.IndexedInstrProf;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type IndexedInstrProfGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf11ComputeHashENS0_5HashTENS_9StringRefE;_ZN4llvm16IndexedInstrProf11ComputeHashENS_9StringRefE;_ZN4llvm16IndexedInstrProf12allocSummaryEj;_ZN4llvm16IndexedInstrProfL5MagicE;_ZN4llvm16IndexedInstrProfL7VersionE;_ZN4llvm16IndexedInstrProfL8HashTypeE; -static-type=IndexedInstrProfGlobals -package=org.llvm.profiledata.IndexedInstrProf")
//</editor-fold>
public final class IndexedInstrProfGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::ComputeHash">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 794,
 FQN="llvm::IndexedInstrProf::ComputeHash", NM="_ZN4llvm16IndexedInstrProf11ComputeHashENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf11ComputeHashENS_9StringRefE")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ ComputeHash(StringRef K) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::ComputeHash">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 760,
 FQN="llvm::IndexedInstrProf::ComputeHash", NM="_ZN4llvm16IndexedInstrProf11ComputeHashENS0_5HashTENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf11ComputeHashENS0_5HashTENS_9StringRefE")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ ComputeHash(HashT Type, StringRef K) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Magic">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 768,
 FQN="llvm::IndexedInstrProf::Magic", NM="_ZN4llvm16IndexedInstrProfL5MagicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProfL5MagicE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Magic = 0x8169666f72706cffL/*ULL*/;
//<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::Version">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 790,
 FQN="llvm::IndexedInstrProf::Version", NM="_ZN4llvm16IndexedInstrProfL7VersionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProfL7VersionE")
//</editor-fold>
public static /*const*/long/*uint64_t*/ Version = ProfVersion.CurrentVersion.getValue();
//<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::HashType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 792,
 FQN="llvm::IndexedInstrProf::HashType", NM="_ZN4llvm16IndexedInstrProfL8HashTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProfL8HashTypeE")
//</editor-fold>
public static /*const*/ HashT HashType = HashT.MD5;
//<editor-fold defaultstate="collapsed" desc="llvm::IndexedInstrProf::allocSummary">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/ProfileData/InstrProf.h", line = 884,
 FQN="llvm::IndexedInstrProf::allocSummary", NM="_ZN4llvm16IndexedInstrProf12allocSummaryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.profiledata/llvmToClangType ${LLVM_SRC}/llvm/lib/ProfileData/InstrProf.cpp -nm=_ZN4llvm16IndexedInstrProf12allocSummaryEj")
//</editor-fold>
public static /*inline*/ std.unique_ptr<Summary> allocSummary(/*uint32_t*/int TotalSize) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class IndexedInstrProfGlobals
