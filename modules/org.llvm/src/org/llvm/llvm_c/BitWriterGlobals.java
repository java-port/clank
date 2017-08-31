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
package org.llvm.llvm_c;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.Error;
import org.llvm.object.*;
import org.llvm.llvmc.*;


//<editor-fold defaultstate="collapsed" desc="static type BitWriterGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.BitWriterGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_Z20LLVMWriteBitcodeToFD;_Z22LLVMWriteBitcodeToFile;_Z28LLVMWriteBitcodeToFileHandle;_Z30LLVMWriteBitcodeToMemoryBuffer; -static-type=BitWriterGlobals -package=org.llvm.llvm_c")
//</editor-fold>
public final class BitWriterGlobals {


/**
* @defgroup LLVMCBitWriter Bit Writer
* @ingroup LLVMC
*
* @{
*/

/*===-- Operations on modules ---------------------------------------------===*/

/** Writes a module to the specified path. Returns 0 on success. */

/*===-- Operations on modules ---------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="LLVMWriteBitcodeToFile">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp", line = 20,
 FQN="LLVMWriteBitcodeToFile", NM="_Z22LLVMWriteBitcodeToFile",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_Z22LLVMWriteBitcodeToFile")
//</editor-fold>
public static int LLVMWriteBitcodeToFile( LLVMOpaqueModule /*P*/ M, /*const*/char$ptr/*char P*/ Path) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Writes a module to an open file descriptor. Returns 0 on success. */
//<editor-fold defaultstate="collapsed" desc="LLVMWriteBitcodeToFD">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp", line = 31,
 FQN="LLVMWriteBitcodeToFD", NM="_Z20LLVMWriteBitcodeToFD",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_Z20LLVMWriteBitcodeToFD")
//</editor-fold>
public static int LLVMWriteBitcodeToFD( LLVMOpaqueModule /*P*/ M, int FD, int ShouldClose, 
                    int Unbuffered) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Deprecated for LLVMWriteBitcodeToFD. Writes a module to an open file
descriptor. Returns 0 on success. Closes the Handle. */
//<editor-fold defaultstate="collapsed" desc="LLVMWriteBitcodeToFileHandle">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp", line = 39,
 FQN="LLVMWriteBitcodeToFileHandle", NM="_Z28LLVMWriteBitcodeToFileHandle",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_Z28LLVMWriteBitcodeToFileHandle")
//</editor-fold>
public static int LLVMWriteBitcodeToFileHandle( LLVMOpaqueModule /*P*/ M, int FileHandle) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Writes a module to a new memory buffer and returns it. */
//<editor-fold defaultstate="collapsed" desc="LLVMWriteBitcodeToMemoryBuffer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp", line = 43,
 FQN="LLVMWriteBitcodeToMemoryBuffer", NM="_Z30LLVMWriteBitcodeToMemoryBuffer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitWriter.cpp -nm=_Z30LLVMWriteBitcodeToMemoryBuffer")
//</editor-fold>
public static  LLVMOpaqueMemoryBuffer /*P*/ LLVMWriteBitcodeToMemoryBuffer( LLVMOpaqueModule /*P*/ M) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class BitWriterGlobals
