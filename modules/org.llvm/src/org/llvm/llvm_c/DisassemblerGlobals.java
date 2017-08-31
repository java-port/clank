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
import org.llvm.java.LlvmFunctionPointers.*;
import org.llvm.support.Error;
import org.llvm.object.*;
import org.llvm.llvmc.*;


//<editor-fold defaultstate="collapsed" desc="static type DisassemblerGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.llvm_c.DisassemblerGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp -nm=_Z16LLVMCreateDisasm;_Z17LLVMDisasmDispose;_Z19LLVMCreateDisasmCPU;_Z20LLVMSetDisasmOptions;_Z21LLVMDisasmInstruction;_Z27LLVMCreateDisasmCPUFeatures; -static-type=DisassemblerGlobals -package=org.llvm.llvm_c")
//</editor-fold>
public final class DisassemblerGlobals {

/* !defined(__cplusplus) */

/**
* Create a disassembler for the TripleName.  Symbolic disassembly is supported
* by passing a block of information in the DisInfo parameter and specifying the
* TagType and callback functions as described above.  These can all be passed
* as NULL.  If successful, this returns a disassembler context.  If not, it
* returns NULL. This function is equivalent to calling
* LLVMCreateDisasmCPUFeatures() with an empty CPU name and feature set.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateDisasm">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp", line = 108,
 FQN="LLVMCreateDisasm", NM="_Z16LLVMCreateDisasm",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp -nm=_Z16LLVMCreateDisasm")
//</editor-fold>
public static Object/*void P*/ LLVMCreateDisasm(/*const*/char$ptr/*char P*/ TT, Object/*void P*/ DisInfo, 
                int TagType, VoidUIntUintUIntIntVoid2Int GetOpInfo, 
                VoidUIntUIntUIntChar2Char SymbolLookUp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a disassembler for the TripleName and a specific CPU.  Symbolic
* disassembly is supported by passing a block of information in the DisInfo
* parameter and specifying the TagType and callback functions as described
* above.  These can all be passed * as NULL.  If successful, this returns a
* disassembler context.  If not, it returns NULL. This function is equivalent
* to calling LLVMCreateDisasmCPUFeatures() with an empty feature set.
*/
//<editor-fold defaultstate="collapsed" desc="LLVMCreateDisasmCPU">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp", line = 100,
 FQN="LLVMCreateDisasmCPU", NM="_Z19LLVMCreateDisasmCPU",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp -nm=_Z19LLVMCreateDisasmCPU")
//</editor-fold>
public static Object/*void P*/ LLVMCreateDisasmCPU(/*const*/char$ptr/*char P*/ TT, /*const*/char$ptr/*char P*/ CPU, Object/*void P*/ DisInfo, int TagType, 
                   VoidUIntUintUIntIntVoid2Int GetOpInfo, 
                   VoidUIntUIntUIntChar2Char SymbolLookUp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Create a disassembler for the TripleName, a specific CPU and specific feature
* string.  Symbolic disassembly is supported by passing a block of information
* in the DisInfo parameter and specifying the TagType and callback functions as
* described above.  These can all be passed * as NULL.  If successful, this
* returns a disassembler context.  If not, it returns NULL.
*/

// LLVMCreateDisasm() creates a disassembler for the TripleName.  Symbolic
// disassembly is supported by passing a block of information in the DisInfo
// parameter and specifying the TagType and callback functions as described in
// the header llvm-c/Disassembler.h .  The pointer to the block and the 
// functions can all be passed as NULL.  If successful, this returns a
// disassembler context.  If not, it returns NULL.
//
//<editor-fold defaultstate="collapsed" desc="LLVMCreateDisasmCPUFeatures">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp", line = 35,
 FQN="LLVMCreateDisasmCPUFeatures", NM="_Z27LLVMCreateDisasmCPUFeatures",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp -nm=_Z27LLVMCreateDisasmCPUFeatures")
//</editor-fold>
public static Object/*void P*/ LLVMCreateDisasmCPUFeatures(/*const*/char$ptr/*char P*/ TT, /*const*/char$ptr/*char P*/ CPU, 
                           /*const*/char$ptr/*char P*/ Features, Object/*void P*/ DisInfo, int TagType, 
                           VoidUIntUintUIntIntVoid2Int GetOpInfo, 
                           VoidUIntUIntUIntChar2Char SymbolLookUp) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Set the disassembler's options.  Returns 1 if it can set the Options and 0
* otherwise.
*/

//
// LLVMSetDisasmOptions() sets the disassembler's options.  It returns 1 if it
// can set all the Options and 0 otherwise.
//
//<editor-fold defaultstate="collapsed" desc="LLVMSetDisasmOptions">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp", line = 289,
 FQN="LLVMSetDisasmOptions", NM="_Z20LLVMSetDisasmOptions",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp -nm=_Z20LLVMSetDisasmOptions")
//</editor-fold>
public static int LLVMSetDisasmOptions(Object/*void P*/ DCR, long/*uint64_t*/ Options) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Dispose of a disassembler context.
*/

//
// LLVMDisasmDispose() disposes of the disassembler specified by the context.
//
//<editor-fold defaultstate="collapsed" desc="LLVMDisasmDispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp", line = 118,
 FQN="LLVMDisasmDispose", NM="_Z17LLVMDisasmDispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp -nm=_Z17LLVMDisasmDispose")
//</editor-fold>
public static void LLVMDisasmDispose(Object/*void P*/ DCR) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* Disassemble a single instruction using the disassembler context specified in
* the parameter DC.  The bytes of the instruction are specified in the
* parameter Bytes, and contains at least BytesSize number of bytes.  The
* instruction is at the address specified by the PC parameter.  If a valid
* instruction can be disassembled, its string is returned indirectly in
* OutString whose size is specified in the parameter OutStringSize.  This
* function returns the number of bytes in the instruction or zero if there was
* no valid instruction.
*/

//
// LLVMDisasmInstruction() disassembles a single instruction using the
// disassembler context specified in the parameter DC.  The bytes of the
// instruction are specified in the parameter Bytes, and contains at least
// BytesSize number of bytes.  The instruction is at the address specified by
// the PC parameter.  If a valid instruction can be disassembled its string is
// returned indirectly in OutString which whos size is specified in the
// parameter OutStringSize.  This function returns the number of bytes in the
// instruction or zero if there was no valid instruction.  If this function
// returns zero the caller will have to pick how many bytes they want to step
// over by printing a .byte, .long etc. to continue.
//
//<editor-fold defaultstate="collapsed" desc="LLVMDisasmInstruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp", line = 239,
 FQN="LLVMDisasmInstruction", NM="_Z21LLVMDisasmInstruction",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDisassembler/Disassembler.cpp -nm=_Z21LLVMDisasmInstruction")
//</editor-fold>
public static /*size_t*/int LLVMDisasmInstruction(Object/*void P*/ DCR, byte/*uint8_t*//*P*/ Bytes, 
                     long/*uint64_t*/ BytesSize, long/*uint64_t*/ PC, char$ptr/*char P*/ OutString, 
                     /*size_t*/int OutStringSize) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class DisassemblerGlobals
