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
package org.llvm.bitcode.reader.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.ir.*;
import org.llvm.llvmc.LLVMOpaqueContext;
import org.llvm.llvmc.LLVMOpaqueMemoryBuffer;
import org.llvm.llvmc.LLVMOpaqueModule;


//<editor-fold defaultstate="collapsed" desc="static type BitReaderStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.bitcode.reader.impl.BitReaderStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z16LLVMParseBitcode;_Z17LLVMParseBitcode2;_Z20LLVMGetBitcodeModule;_Z21LLVMGetBitcodeModule2;_Z25LLVMParseBitcodeInContext;_Z26LLVMParseBitcodeInContext2;_Z29LLVMGetBitcodeModuleInContext;_Z30LLVMGetBitcodeModuleInContext2;_ZL17diagnosticHandlerRKN4llvm14DiagnosticInfoEPv; -static-type=BitReaderStatics -package=org.llvm.bitcode.reader.impl")
//</editor-fold>
public final class BitReaderStatics {


/**
* @defgroup LLVMCBitReader Bit Reader
* @ingroup LLVMC
*
* @{
*/

/* Builds a module from the bitcode in the specified memory buffer, returning a
reference to the module via the OutModule parameter. Returns 0 on success.
Optionally returns a human-readable error message via OutMessage.

This is deprecated. Use LLVMParseBitcode2. */

/* Builds a module from the bitcode in the specified memory buffer, returning a
reference to the module via the OutModule parameter. Returns 0 on success.
Optionally returns a human-readable error message via OutMessage. */
//<editor-fold defaultstate="collapsed" desc="LLVMParseBitcode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 26,
 FQN="LLVMParseBitcode", NM="_Z16LLVMParseBitcode",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z16LLVMParseBitcode")
//</editor-fold>
public static int LLVMParseBitcode( LLVMOpaqueMemoryBuffer /*P*/ MemBuf, type$ptr<LLVMOpaqueModule /*P*/ /*P*/> OutModule, 
                type$ptr<char$ptr>/*char PP*/ OutMessage) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* Builds a module from the bitcode in the specified memory buffer, returning a
reference to the module via the OutModule parameter. Returns 0 on success. */
//<editor-fold defaultstate="collapsed" desc="LLVMParseBitcode2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 32,
 FQN="LLVMParseBitcode2", NM="_Z17LLVMParseBitcode2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z17LLVMParseBitcode2")
//</editor-fold>
public static int LLVMParseBitcode2( LLVMOpaqueMemoryBuffer /*P*/ MemBuf, 
                 type$ptr<LLVMOpaqueModule /*P*/ /*P*/> OutModule) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* This is deprecated. Use LLVMParseBitcodeInContext2. */
//<editor-fold defaultstate="collapsed" desc="LLVMParseBitcodeInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 44,
 FQN="LLVMParseBitcodeInContext", NM="_Z25LLVMParseBitcodeInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z25LLVMParseBitcodeInContext")
//</editor-fold>
public static int LLVMParseBitcodeInContext( LLVMOpaqueContext /*P*/ ContextRef, 
                          LLVMOpaqueMemoryBuffer /*P*/ MemBuf, 
                         type$ptr<LLVMOpaqueModule /*P*/ /*P*/> OutModule, 
                         type$ptr<char$ptr>/*char PP*/ OutMessage) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMParseBitcodeInContext2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 72,
 FQN="LLVMParseBitcodeInContext2", NM="_Z26LLVMParseBitcodeInContext2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z26LLVMParseBitcodeInContext2")
//</editor-fold>
public static int LLVMParseBitcodeInContext2( LLVMOpaqueContext /*P*/ ContextRef, 
                           LLVMOpaqueMemoryBuffer /*P*/ MemBuf, 
                          type$ptr<LLVMOpaqueModule /*P*/ /*P*/> OutModule) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Reads a module from the specified path, returning via the OutMP parameter
a module provider which performs lazy deserialization. Returns 0 on success.
Optionally returns a human-readable error message via OutMessage.
This is deprecated. Use LLVMGetBitcodeModuleInContext2. */

/* Reads a module from the specified path, returning via the OutModule parameter
a module provider which performs lazy deserialization. Returns 0 on success.
Optionally returns a human-readable error message via OutMessage. */
//<editor-fold defaultstate="collapsed" desc="LLVMGetBitcodeModuleInContext">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 91,
 FQN="LLVMGetBitcodeModuleInContext", NM="_Z29LLVMGetBitcodeModuleInContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z29LLVMGetBitcodeModuleInContext")
//</editor-fold>
public static int LLVMGetBitcodeModuleInContext( LLVMOpaqueContext /*P*/ ContextRef, 
                              LLVMOpaqueMemoryBuffer /*P*/ MemBuf, 
                             type$ptr<LLVMOpaqueModule /*P*/ /*P*/> OutM, type$ptr<char$ptr>/*char PP*/ OutMessage) {
  throw new UnsupportedOperationException("EmptyBody");
}


/** Reads a module from the specified path, returning via the OutMP parameter a
* module provider which performs lazy deserialization. Returns 0 on success. */
//<editor-fold defaultstate="collapsed" desc="LLVMGetBitcodeModuleInContext2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 120,
 FQN="LLVMGetBitcodeModuleInContext2", NM="_Z30LLVMGetBitcodeModuleInContext2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z30LLVMGetBitcodeModuleInContext2")
//</editor-fold>
public static int LLVMGetBitcodeModuleInContext2( LLVMOpaqueContext /*P*/ ContextRef, 
                               LLVMOpaqueMemoryBuffer /*P*/ MemBuf, 
                              type$ptr<LLVMOpaqueModule /*P*/ /*P*/> OutM) {
  throw new UnsupportedOperationException("EmptyBody");
}


/* This is deprecated. Use LLVMGetBitcodeModule2. */
//<editor-fold defaultstate="collapsed" desc="LLVMGetBitcodeModule">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 139,
 FQN="LLVMGetBitcodeModule", NM="_Z20LLVMGetBitcodeModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z20LLVMGetBitcodeModule")
//</editor-fold>
public static int LLVMGetBitcodeModule( LLVMOpaqueMemoryBuffer /*P*/ MemBuf, type$ptr<LLVMOpaqueModule /*P*/ /*P*/> OutM, 
                    type$ptr<char$ptr>/*char PP*/ OutMessage) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="LLVMGetBitcodeModule2">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 145,
 FQN="LLVMGetBitcodeModule2", NM="_Z21LLVMGetBitcodeModule2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_Z21LLVMGetBitcodeModule2")
//</editor-fold>
public static int LLVMGetBitcodeModule2( LLVMOpaqueMemoryBuffer /*P*/ MemBuf, 
                     type$ptr<LLVMOpaqueModule /*P*/ /*P*/> OutM) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="diagnosticHandler">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp", line = 37,
 FQN="diagnosticHandler", NM="_ZL17diagnosticHandlerRKN4llvm14DiagnosticInfoEPv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitReader.cpp -nm=_ZL17diagnosticHandlerRKN4llvm14DiagnosticInfoEPv")
//</editor-fold>
public static void diagnosticHandler(final /*const*/ DiagnosticInfo /*&*/ DI, Object/*void P*/ C) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class BitReaderStatics
